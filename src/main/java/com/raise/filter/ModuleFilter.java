package com.raise.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xiangxiaolong
 * @create 2022-02-23 21:37
 */
//@WebFilter("/*")
public class ModuleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String[] urls = {"/login.jsp","/user/login"};
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String url = req.getRequestURL().toString();
//        for (String u : urls) {
//            if (url.contains(u)){
//                chain.doFilter(req,resp);
//                return;
//            }
//        }
//        HttpSession session = req.getSession();
//        String username = (String) session.getAttribute("username");
//        if (username == null){
//            req.setAttribute("error_msg","请先登录！");
//            req.getRequestDispatcher("/login.jsp").forward(req,resp);
//        }else {
//            chain.doFilter(req,resp);
//        }
    }

    @Override
    public void destroy() {

    }
}
