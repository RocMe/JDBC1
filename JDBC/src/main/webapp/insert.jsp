<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/11
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息添加</title>
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
<form action = "insert_form",method = "post">
    <select name="insert" id="insert_info">
        <option value="">--选择添加信息--</option>
        <option value="项目信息">项目信息</option>
        <option value="公司信息">公司信息</option>
        <option value="管理信息">管理信息</option>
    </select><br><br>
    项目编号: <input type="text" name="pid" placeholder="请输入项目编号"><br><br>
    项目名称: <input type="text" name="pn" placeholder="请输入项目名称"><br><br>
    项目类型: <input type="text" name="pt" placeholder="请输入项目类型"><br><br>
    项目总费用: <input type="text" name="pf" placeholder="请输入项目总费用"><br><br>
    项目状态: <input type="text" name="ps" placeholder="请输入项目状态"><br><br>
    预计开始日期: <input type="date" name="std"><br><br>
    预计完成日期: <input type="date" name="end"><br><br>
    公司编号：<input type="text" name="cid" placeholder="请输入公司编号"><br><br>
    公司名称：<input type="text" name="cn" placeholder="请输入公司名称"><br><br>
    公司类型：<input type="text" name="ct" placeholder="请输入公司类型"><br><br>
    公司负责人：<input type="text" name="cc" placeholder="请输入公司负责人"><br><br>
    公司电话：<input type="text" name="cp" placeholder="请输入公司电话"><br><br>
    公司邮箱：<input type="text" name="ce" placeholder="请输入公司邮箱"><br><br>
    合同编号：<input type="text" name="contract" placeholder="请输入合同编号"><br><br>
    下拨费用：<input type="text" name="fare" placeholder="请输入下拨费用"><br><br>
    <input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/select.jsp'">
    <input type="submit" value="添加"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
