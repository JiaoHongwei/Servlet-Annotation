package com.hw.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/18 17:06
 * @Version 1.0
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("UserFilter...doFilter... ");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
