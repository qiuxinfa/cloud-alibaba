package com.qxf.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.api.naming.pojo.ListView;
import com.alibaba.nacos.client.naming.NacosNamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NacosTestController
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/9/11 23:16
 **/
@RestController
public class NacosTestController {

    @Value("${spring.cloud.nacos.discovery.server-addr}")
    private String serverAddr;

    @GetMapping("/nacos/instance")
    public Object getAllInstance() throws NacosException {
        List<Instance> instances = new ArrayList<>();
        NacosNamingService service = new NacosNamingService(serverAddr);
        ListView<String> servicesOfServer = service.getServicesOfServer(1, 1000);
        for (String serviceName : servicesOfServer.getData()) {
            instances.addAll(service.getAllInstances(serviceName));
        }
        return instances;
    }
}
