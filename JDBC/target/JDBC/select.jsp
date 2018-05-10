<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/3/17
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科研项目管理</title>
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
<form>
    <input type="button" value="信息查询" onclick="window.location.href = 'http://localhost:8080/JDBC/query.jsp'"><br><br>
    <input type="button" value="信息添加" onclick="window.location.href = 'http://localhost:8080/JDBC/insert.jsp'"><br><br>
    <input type="button" value="信息修改" onclick="window.location.href = 'http://localhost:8080/JDBC/update.jsp'"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
