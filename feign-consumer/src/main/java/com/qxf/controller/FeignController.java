package com.qxf.controller;

import com.qxf.feign.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FeignController
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 21:17
 **/
@RestController
public class FeignController {
    @Autowired
    private TestFeignService testFeignService;

    @GetMapping("/feign/test")
    public String testFeign(String msg){
        return testFeignService.feignProvider(msg);
    }
}
