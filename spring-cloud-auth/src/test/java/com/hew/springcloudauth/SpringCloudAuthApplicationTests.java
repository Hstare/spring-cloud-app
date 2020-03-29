package com.hew.springcloudauth;

import ch.qos.logback.core.util.TimeUtil;
import com.hew.springcloudauth.Query.UserQuery;
import com.hew.springcloudauth.util.JWTUtils;
import io.jsonwebtoken.Claims;
import io.micrometer.core.instrument.util.TimeUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

import java.security.interfaces.RSAPublicKey;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@SpringBootTest
class SpringCloudAuthApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {

    }

    @Test
    public void testJWT() {
        String name = "张三";
        logger.error("xxxxxxxxxxxx:{}", name);
        long l = TimeUnit.MINUTES.toSeconds(3);
        logger.error("xxxxxxxxxxxx:{}", l);
    }
}
