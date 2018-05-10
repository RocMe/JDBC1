<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/19
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员页面</title>
</head>
<body>
<jsp:include page="left.jsp"></jsp:include>
<%
    String name = "";
    if(session.getAttribute("usn") == null){
%>
<script type="text/javascript" language="javascript">
    alert("未登录");
    window.location='http://localhost:8080/JDBC/login.jsp';
</script>
<%
    }
    else {
        name = (String) session.getAttribute("usn");
        if(!name.equals("SYSDBA")) {
%>
<script type="text/javascript" language="javascript">
    alert("非管理员");
    window.location='http://localhost:8080/JDBC/user_data.jsp';
</script>
<%
        }
    }
%>
<form action = "sysdba_form",method = "post">
    用户名称：<input type="text" name="user_name" placeholder="请输入用户名称"><br><br>
    用户新密码：<input type="password" name="new_password" placeholder="请输入用户新密码"><br><br>
    <input type="submit" value="修改"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
