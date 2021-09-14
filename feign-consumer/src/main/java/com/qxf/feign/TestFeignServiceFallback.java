package com.qxf.feign;

import feign.hystrix.FallbackFactory;

/**
 * @ClassName TestFeignServiceFallback
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/9/13 20:50
 **/
public class TestFeignServiceFallback implements FallbackFactory<TestFeignService>{
    @Override
    public TestFeignService create(Throwable throwable) {
        return new TestFeignService(){
            @Override
            public String feignProvider(String msg) {
                return null;
            }

            @Override
            public String test(String msg) {
                return null;
            }
        };
    }
}
