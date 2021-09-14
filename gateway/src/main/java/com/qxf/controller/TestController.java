package com.qxf.controller;

import org.springframework.beans.BeansException;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/9/14 21:56
 **/
@RestController
public class TestController implements ApplicationContextAware{
    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       context = applicationContext;
    }

    @GetMapping("/gateway/test")
    public Object test(){
        RouteDefinitionLocator locator = context.getBean(RouteDefinitionLocator.class);
        return locator.getRouteDefinitions();
    }
}
