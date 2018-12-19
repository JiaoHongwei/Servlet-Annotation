package com.hw.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/18 15:05
 * @Version 1.0
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        response.getWriter().write("hello....");
        System.out.println(Thread.currentThread() + "start...");
        try {
            sayHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "end...");
//        System.out.println(request.getRequestURI());
    }

    public void sayHello() throws InterruptedException {
        System.out.println(Thread.currentThread() + "processing...");
        Thread.sleep(3000);
    }
}
