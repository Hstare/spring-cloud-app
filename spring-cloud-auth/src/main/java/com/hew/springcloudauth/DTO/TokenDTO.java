package com.hew.springcloudauth.DTO;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author HeXiaoWei
 * @date 2020/2/28 15:13
 */
@Data
@Accessors(chain = true)
public class TokenDTO {
    private Boolean verified;
    private Boolean newToken;
    private String token;
}
