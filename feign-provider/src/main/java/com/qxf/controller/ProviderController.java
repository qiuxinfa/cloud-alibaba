package com.qxf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 21:41
 **/
@RestController
public class ProviderController {

    @GetMapping("/feign/provider/{msg}")
    public String testFeign(@PathVariable("msg") String msg){
        return "feignProvider "+msg;
    }
}
