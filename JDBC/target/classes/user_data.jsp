<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/18
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息管理</title>
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
        out.print("当前用户为："+ name + "<br>");
        if(name.equals("SYSDBA")) {
            out.print("当前身份为：系统管理员" + "<br>");
        }
        else {
            out.print("当前身份为：一般用户" + "<br>");
        }
    }
%>
<form action = "user_data_form",method = "post">
    <input type="hidden" name="user_name" value=<%=name%>>
    修改密码：<input type="password" name="new_password" placeholder="请输入新密码"><br><br>
    <input type="submit" value="修改">
    <input type="button" value="管理员修改密码" onclick="window.location.href = 'http://localhost:8080/JDBC/sysdba.jsp'"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
