package com.zwp.kunpengbackendgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 开发微服务时，网关服务不需要数据库的支持，这时候可以使用此配置。也可以用于测试环境，避免自动加载不需要的 Bean
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class KunpengBackendGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(KunpengBackendGatewayApplication.class, args);
    }

}
