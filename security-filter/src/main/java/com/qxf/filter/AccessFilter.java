package com.qxf.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName AccessFilter
 * @Description 只能从网关访问微服务
 * @Author qiuxinfa
 * @Date 2021/5/19 20:22
 **/
@Component
public class AccessFilter implements Filter{
    /**
     * 网关在请求头添加的信息，如果 请求头 有这个值，表示已经经过网关认证，可以访问微服务
     */
    private static final String GATEWAY_HEADER = "gateway_header";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String header = request.getHeader(GATEWAY_HEADER);
        if (!"true".equals(header)){
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write("请从网关访问微服务");
            return;
        }
        filterChain.doFilter(request,response);
    }
}
