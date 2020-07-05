package com.etoak.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CrossDomainFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");// 允许所有的请求域名访问我们的跨域资源，可以固定单个或者多个内容
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");// 允许何种请求方法访问该跨域资源服务器
        httpResponse.setHeader("Access-Control-Max-Age", "3600");//// 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
        httpResponse.addHeader("Access-Control-Allow-Headers", "Accept, Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");// 允许所有的请求header访问，可以自定义设置任意请求头信息
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");// 是否允许用户发送、处理 cookie
        chain.doFilter(request, httpResponse);
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-----CrossDomainFilter init -------");
    }
    
    @Override
    public void destroy() {
        
    }
    
}
