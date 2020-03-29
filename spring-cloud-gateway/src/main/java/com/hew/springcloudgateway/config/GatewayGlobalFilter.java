package com.hew.springcloudgateway.config;

import com.alibaba.fastjson.JSON;
import com.hew.springcloudauth.DTO.TokenDTO;
import com.hew.springcloudauth.util.JWTUtils;
import com.hew.springcloudcommon.VO.ResultVO;
import com.hew.springcloudcommon.enums.CodeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author HeXiaoWei
 * @date 2019/12/30 22:45
 */
public class GatewayGlobalFilter implements GlobalFilter, Ordered {
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 作为第一个和最后一个过滤器
     * 功能简介：根据请求头做出对应的操作，未登录->登录验证，已登录->token验证
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("--> global Filter");
        logger.info("exchange:---->>>"+exchange.toString());
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        //跳过不需要认证的路径（假设只有登录路径）
        if(path.endsWith("/login")){
            return chain.filter(exchange);
        }else{ //需要认证的路径
            String authorization = request.getHeaders().getFirst("Authorization");
            boolean present = Optional.ofNullable(authorization).isPresent();
            ServerHttpResponse response = exchange.getResponse();
            if(!present){
                return authFailed(response
                        ,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED
                        ,CodeMessage.NETWORK_AUTHENTICATION_REQUIRED.getCode()
                        ,CodeMessage.NETWORK_AUTHENTICATION_REQUIRED.getMessage());
            }else{
                TokenDTO tokenDTO = JWTUtils.verifyToken(authorization);
                boolean nonPassed = null == tokenDTO || (null != tokenDTO && !tokenDTO.getVerified());
                if(nonPassed){
                    return authFailed(response
                            ,HttpStatus.UNAUTHORIZED
                            ,CodeMessage.UNAUTHORIZED.getCode()
                            ,CodeMessage.UNAUTHORIZED.getMessage());
                }else if(null != tokenDTO && tokenDTO.getVerified() && tokenDTO.getNewToken()){
                    request.getHeaders().add("Authorization",tokenDTO.getToken());
                }
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    /**
     * 认证失败
     * @param response
     * @param status
     * @param code
     * @param msg
     * @return
     */
    private Mono<Void> authFailed(ServerHttpResponse response,HttpStatus status,Integer code,String msg){
        response.setStatusCode(status);
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code)
                .setData(null)
                .setMsg(msg);
        DataBuffer wrap = response.bufferFactory().wrap(JSON.toJSONString(resultVO).getBytes());
        return response.writeWith(Flux.just(wrap));
    }
}
