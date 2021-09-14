package com.qxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName FeignProvider
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 21:40
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class FeignProvider {
    public static void main(String[] args) {
        SpringApplication.run(FeignProvider.class,args);
    }
}
