<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/3/16
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>用户登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>用户登录</p>
        </div>
        <form action = "login_form",method = "post">
            用户名: <input type="text" name="usn" placeholder="请输入用户名"><br><br>
            密码: <input type="password" name="pwd" placeholder="请输入密码"><br><br>
            <input type="submit" value="登录"><br><br>
            <input type="button" value="注册" onclick="window.location.href = 'http://localhost:8080/JDBC/register.jsp'">
        </form>
    </div>
</div>
</body>
</html>
