package com.qxf.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName FeignService
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 21:18
 **/
@FeignClient(name = "feign-provider",fallbackFactory = TestFeignServiceFallback.class)
public interface TestFeignService {

    @GetMapping("/feign/provider/{msg}")
    String feignProvider(@PathVariable("msg") String msg);

    @GetMapping("/feign/test/{msg}")
    String test(@PathVariable("msg") String msg);
}
