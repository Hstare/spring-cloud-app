package com.hew.springcloudnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNacosApplication.class, args);
    }

}
