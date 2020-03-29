package com.hew.springcloudauth.util;

import com.hew.springcloudauth.DTO.TokenDTO;
import com.hew.springcloudauth.Query.UserQuery;
import com.hew.springclouddubboapi.service.IUserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author HeXiaoWei
 * @date 2019/12/22 22:43
 */
public class JWTUtils implements Serializable {
    static Logger logger = LoggerFactory.getLogger(JWTUtils.class);

    @Reference
    static IUserService userService;
    /**
     * 单位：分钟
     */
    private static final long DEFAULT_EXPIRE_TIME = 30L;

    private static KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

    private static PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

    private static PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    private static String createToken(Claims claims){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expire = now.plusMinutes(DEFAULT_EXPIRE_TIME);
        claims.setExpiration(Date.from(expire.atZone(ZoneId.systemDefault()).toInstant()));
        return Jwts.builder()
                .setClaims(claims)
                .signWith(getPrivateKey())
                .compressWith(CompressionCodecs.DEFLATE)
                .compact();
    }

    public static String createToken(UserQuery user) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expire = now.plusMinutes(DEFAULT_EXPIRE_TIME);
        Claims claims = Jwts.claims();
        claims.put("name",user.getName());
        claims.put("sex",user.getSex());
        claims.put("state",user.getState());
        claims.put("userId",user.getId());
        claims.setIssuer("spring-cloud-auth")
                .setAudience("browser")
                .setIssuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(expire.atZone(ZoneId.systemDefault()).toInstant()))
                .setId(UUID.randomUUID().toString());
        return createToken(claims);
    }

    private static Claims checkToken(String token) {
        Claims claims = null;
        try {
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(getPublicKey())
                    .requireAudience("browser")
                    .requireIssuer("spring-cloud-auth")
                    // 时钟偏差三分钟都是有效的
                    .setAllowedClockSkewSeconds(TimeUnit.MINUTES.toSeconds(3L))
                    .parseClaimsJws(token);
            LocalDateTime dateTime = LocalDateTime.now();
            Date now = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
            claims = jws.getBody();
            // "iat" < TODAY
            boolean iat = claims.getIssuedAt().before(now);
            // "exp" < 此事  token过期了
            boolean expire = claims.getExpiration().before(now);
            // 验证 此时小于发行时间 token不正确
            if(!iat){
                return null;
            }
            //过期了检查一遍用户状态
            if(expire){
                //首先检查此时用户状态，用户非正常，则更改用户状态
                Byte state = userService.getUserState((Long) claims.get("userId"));
                if(state != 1){
                    claims.put("state",state);
                }

            }
        } catch (MissingClaimException mce) {
            mce.printStackTrace();
            logger.error("token缺少Audience或者Issuer字段");
        } catch(IncorrectClaimException ice) {
            ice.printStackTrace();
            logger.error("Audience或者Issuer与预期不符合");
            // the parsed JWT had a sub field, but its value was not equal to 'jsmith'
        }catch (io.jsonwebtoken.security.SignatureException se){
            se.printStackTrace();
            logger.error("签名异常");
        }
        return claims;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static TokenDTO verifyToken(String token){
        TokenDTO tokenDTO = new TokenDTO();
        Claims claims = checkToken(token);
        if(null == claims){
            return null;
        }
        if(1 == (Integer) claims.get("state")){
            String newToken = createToken(claims);
            tokenDTO.setToken(newToken)
                    .setVerified(true)
                    .setNewToken(true);
        }
        return tokenDTO;
    }
}
