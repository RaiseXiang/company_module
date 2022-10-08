<%--
  Created by IntelliJ IDEA.
  User: xiangxl
  Date: 2022/1/25
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <h3 align="center">欢迎登陆</h3>
<%--    <a href="/brand_module/register.jsp">没有账号？点我注册</a>--%>
<hr>
    <div align="center">
        <form action="/company_module/user/login" method="post">
            <div><font color="red">${error_msg}</font></div>
            用户名：<input type="text" name="username" value="${cookie.username.value}">
            <br>
            密码：<input type="password" name="password" value="${cookie.password.value}">
            <br>
            记住密码：<input type="checkbox" name="remember" value="1">
            <input type="submit" value="登陆" size="400">
        </form>
    </div>
</body>
</html>
