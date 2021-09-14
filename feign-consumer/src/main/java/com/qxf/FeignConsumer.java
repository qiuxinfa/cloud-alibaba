package com.qxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName FeignConsumer
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 21:15
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumer.class,args);
    }
}
