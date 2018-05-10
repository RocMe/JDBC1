<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/21
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系我们</title>
</head>
<body>
<jsp:include page="left.jsp"></jsp:include>
<%
    if(session.getAttribute("usn") == null){
%>
<script type="text/javascript" language="javascript">
    alert("未登录");
    window.location='http://localhost:8080/JDBC/login.jsp';
</script>
<%
    }
%>
<form action = "contact_us_form",method = "post">
    联系电话：021-12345678<br><br>
    联系传真：12345678<br><br>
    联系邮箱：123456789@gmail.com<br><br>
    提出您的宝贵意见：<br><br>
    您的姓名：<input type="text" name="name"><br><br>
    您的邮箱：<input type="text" name="email"><br><br>
    您的意见或建议：<br><br>
    <textarea name="advice" rows="30" cols="30"></textarea><br><br>
    <input type="submit" value="提交"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
