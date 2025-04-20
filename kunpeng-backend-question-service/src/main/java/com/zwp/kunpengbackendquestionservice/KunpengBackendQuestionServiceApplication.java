package com.zwp.kunpengbackendquestionservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.zwp.kunpengbackendquestionservice.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.zwp")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zwp.kunpengbackendserviceclient.service"})
public class KunpengBackendQuestionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunpengBackendQuestionServiceApplication.class, args);
    }

}
