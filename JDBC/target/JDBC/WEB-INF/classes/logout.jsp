<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/18
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注销</title>
</head>
<body>
<jsp:include page="left.jsp"></jsp:include>
<%
    response.setHeader("refresh","3;URL = login.jsp");
    session.invalidate();
%>
<h3>您已成功退出，三秒钟后跳转到登录页面</h3>
<h3>如果没有自动跳转，请点击<a href="login.jsp">这里</a></h3>
</body>
</html>
