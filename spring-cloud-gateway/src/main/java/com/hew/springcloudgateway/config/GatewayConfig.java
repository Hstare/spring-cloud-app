package com.hew.springcloudgateway.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

/**
 * @author HeXiaoWei
 * @date 2019/12/30 22:56
 */
@Configurable
public class GatewayConfig {
    @Bean
    public GlobalFilter globalFilter(){
        return new GatewayGlobalFilter();
    }
}
