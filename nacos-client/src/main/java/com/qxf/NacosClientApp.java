package com.qxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosClientApp
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/18 23:48
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientApp {
    public static void main(String[] args) {
        SpringApplication.run(NacosClientApp.class,args);
    }
}
