package com.hw.servlet;

import com.hw.service.HelloService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/18 16:07
 * @Version 1.0
 */
@HandlesTypes(value = {HelloService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类：");
        for (Class<?> clazz : set) {
            System.out.println(clazz);
        }

        ServletRegistration.Dynamic servlet = servletContext.addServlet("userServlet", new UserServlet());
        servlet.addMapping("/user");

        servletContext.addListener(UserListener.class);

        FilterRegistration.Dynamic filer = servletContext.addFilter("userFiler", UserFilter.class);
        filer.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
    }
}
