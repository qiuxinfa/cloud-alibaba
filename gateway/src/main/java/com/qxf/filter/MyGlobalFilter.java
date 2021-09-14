package com.qxf.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName MyGlobalFilter
 * @Description TODO
 * @Author qiuxinfa
 * @Date 2021/5/19 20:42
 **/
@Component
public class MyGlobalFilter implements GlobalFilter,Ordered{
    /**
     * 网关在请求头添加的信息，如果 请求头 有这个值，表示已经经过网关认证，可以访问微服务
     */
    private static final String GATEWAY_HEADER = "gateway_header";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        // TODO 获取请求的url，如果是白名单则放行
        // TODO 获取token，如果token正确则放行
        // 认证通过之后，在请求头添加认证标志
        request = exchange.getRequest().mutate().header(GATEWAY_HEADER,"true").build();
        //把新的 exchange放回到过滤链
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
