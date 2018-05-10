<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/18
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
    <meta charset="gb2312">
    <title>Basic FileBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui/demo.css">
    <script type="text/javascript" src="jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
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
<div class="easyui-panel" title="上传文件" style="width:400px;padding:30px 70px 50px 70px" >
    <form method="post"  action="upload_form" enctype="multipart/form-data"  >
        选择一个文件:
        <input type="file" name="uploadFile" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
</div>
</body>
</html>
