<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>用户注册</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>用户注册</p>
        </div>
        <form action = "register_form",method = "post">
            Username: <input type="text" name="usn" placeholder="请输入用户名"><br><br>
            Password: <input type="password" name="pwd" placeholder="请输入密码"><br><br>
            <input type="submit" value="确定">
            <input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/login.jsp'">
    </div>
</div>
</body>
</html>