<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/11
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
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
<form action = "query_form",method = "post">
    <select name="query" id="query_info">
        <option value="">--选择查询信息--</option>
        <option value="项目信息">项目信息</option>
        <option value="公司信息">公司信息</option>
        <option value="管理信息">管理信息</option>
    </select><br><br>
    <input type="text" name="id1" placeholder="请输入编号1"><br><br>
    <input type="text" name="id2" placeholder="请输入编号2"><br><br>
    <input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/select.jsp'">
    <input type="submit" value="查询"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
