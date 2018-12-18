package com.hw.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Description 监听项目的启动和停止
 * @Author hw
 * @Date 2018/12/18 17:07
 * @Version 1.0
 */
public class UserListener implements ServletContextListener {

    /**
     * 启动
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener... contextInitialized...");
        ServletContext servletContext = servletContextEvent.getServletContext();
    }

    /**
     * 停止
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("UserListener... contextDestroyed...");
    }
}
