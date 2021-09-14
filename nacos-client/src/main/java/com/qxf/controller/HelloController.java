package com.qxf.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/18 23:49
 **/
@RestController
@RefreshScope
public class HelloController {

    @Value("${config.name}")
    private String name;

    @Value("${config.age}")
    private Integer age;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("启动端口："+port);
        return "name = "+name + " ，age = "+age;
    }
}
