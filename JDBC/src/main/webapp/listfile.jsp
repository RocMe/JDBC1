<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"  contentType="text/html; ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path", basePath);
%>
<html>
<head>
    <title>下载文件显示页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="gb2312">
    <title>Basic FileBox - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${path}jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}jquery-easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${path}jquery-easyui/demo.css">
    <script type="text/javascript" src="${path}jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${path}jquery-easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${path}css/admin.css">

</head>

<body>
文件目录：
<!-- 遍历Map集合 -->
<jsp:include page="left.jsp"></jsp:include>
<c:forEach var="me" items="${fileNameMap}">
    <c:url value="/servlet/DownLoadServlet" var="downurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    <div class="easyui-panel" title="文件" style="width:200px;padding:30px 70px 50px 70px">
    ${me.value}<a href="${downurl}">下载</a></div>
    <br/>
</c:forEach>
</body>
</html>
<!--http://www.cnblogs.com/xdp-gacl/p/4200090.html -->