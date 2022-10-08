package com.raise.web;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author xiangxiaolong
 * @create 2022-02-18 23:50
 */

public class BasicServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURL().toString();
        int methodIndex = url.lastIndexOf("/");
        String methodName = url.substring(methodIndex + 1);
//        System.out.println(methodName);
        Class<? extends BasicServlet> companyServlet = this.getClass();
        Method method = companyServlet.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        method.invoke(this,req,resp);
    }
}
