//package com.qxf.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.cloud.gateway.filter.FilterDefinition;
//import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import reactor.core.publisher.Flux;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName MyRouteDefinitionLocator
// * @Description 根据微服务名，动态路由
// * @Author qiuxinfa
// * @Date 2021/9/14 20:53
// **/
//@Component
//public class MyRouteDefinitionLocator implements RouteDefinitionLocator {
//
//    private static final String SERVICE_URL = "http://localhost:8848/nacos/v1/ns/catalog/services?hasIpCount=true&withInstances=false&pageNo=1&pageSize=1000";
//    private static RestTemplate restTemplate = new RestTemplate();
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Value("${spring.application.name}")
//    private String gatewayName;
//
//    @Override
//    public Flux<RouteDefinition> getRouteDefinitions() {
//        // 该方法会返回已经不存在的服务
////        List<String> serviceList = discoveryClient.getServices();
//
//        Map<String,Object> map = restTemplate.getForObject(SERVICE_URL, Map.class);
//        if (map == null || map.get("serviceList") == null){
//            return Flux.empty();
//        }
//        List<Map<String,Object>> dtos= (List<Map<String, Object>>) map.get("serviceList");
//        List<String> serviceList = new ArrayList<>(dtos.size());
//        for (Map<String, Object> dto : dtos) {
//            serviceList.add(dto.get("name").toString());
//        }
//
//        System.out.println("serviceList = "+serviceList);
//        // 只有网关服务，直接返回
//        if (serviceList.size() < 2){
//            return Flux.empty();
//        }
//        // 服务的个数
//        int serviceNum = serviceList.size();
//        if (serviceList.contains(gatewayName)){
//            // 排除网关服务
//            serviceNum--;
//
//        }
//        RouteDefinition[] routeDefinitions = new RouteDefinition[serviceNum];
//        int count = 0;
//        for (String service : serviceList) {
//            if (service.equalsIgnoreCase(gatewayName)){
//                continue;
//            }
//            RouteDefinition definition = new RouteDefinition();
//            definition.setId(service);
//            definition.setUri(URI.create("lb://"+service));
//            definition.setPredicates(Collections.singletonList(new PredicateDefinition("Path=/"+service+"/**")));
//            definition.setFilters(Collections.singletonList(new FilterDefinition("StripPrefix=1")));
//            routeDefinitions[count++] = definition;
//        }
//        return Flux.just(routeDefinitions);
//    }
//}
