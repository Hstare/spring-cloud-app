package com.hew.springcloudserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
//@MapperScan("com.hew.springcloudserver.mapper")
public class SpringCloudServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServerApplication.class, args);
    }

}
