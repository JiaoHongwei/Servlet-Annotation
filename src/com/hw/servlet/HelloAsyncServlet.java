package com.hw.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author hw
 * @Date 2018/12/19 11:20
 * @Version 1.0
 */
@WebServlet(value = "/async", asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync();
        System.out.println("主线程开始：" + Thread.currentThread() + "start..." + System.currentTimeMillis());
        asyncContext.start(() -> {
            try {
                System.out.println("子线程开始：" + Thread.currentThread() + "start..." + System.currentTimeMillis());
                sayHello();
                asyncContext.complete();
                ServletResponse response = asyncContext.getResponse();
                response.getWriter().write("异步执行完成");
                System.out.println("子线程结束：" + Thread.currentThread() + "end..." + System.currentTimeMillis());
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("主线程结束：" + Thread.currentThread() + "end..." + System.currentTimeMillis());

    }

    public void sayHello() throws InterruptedException {
        System.out.println("主线程运行：" + Thread.currentThread() + "processing..." + System.currentTimeMillis());
        Thread.sleep(3000);
    }
}
