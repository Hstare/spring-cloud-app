package com.hew.springcloudserver.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

//import static io.lettuce.core.ReadFrom.MASTER_PREFERRED;
//import static io.lettuce.core.ReadFrom.REPLICA_PREFERRED;
/**
 * @author HeXiaoWei
 * @date 2019/11/21 22:16
 */
/*@Configurable
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFaction(){
        //读写策略
        LettuceClientConfiguration build = LettuceClientConfiguration.builder().readFrom(REPLICA_PREFERRED).build();
        RedisSentinelConfiguration sentinel = new RedisSentinelConfiguration().master("master")
                .sentinel("127.0.0.1", 63791)
                .sentinel("127.0.0.1", 63792);
        return new LettuceConnectionFactory(sentinel,build);
    }
}*/
