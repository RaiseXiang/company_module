package com.raise.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author xiangxiaolong
 * @create 2022-02-23 21:41
 */
@WebServlet("/user/*")
public class UserServlet extends BasicServlet{
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding(StandardCharsets.UTF_8 + "");
        String line = req.getReader().readLine();
        String[] split = line.split("&");
        String username = split[0].split("=")[1];
        String password = split[1].split("=")[1];
        if ("admin".equals(username) && "admin".equals(password)){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
        }
        resp.sendRedirect("localhost:8080/company_detail.html");
    }
}
