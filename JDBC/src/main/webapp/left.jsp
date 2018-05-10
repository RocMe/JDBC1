<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/4/18
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("path", basePath);
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}css/admin.css">
    <link rel="stylesheet" type="text/css" href="${path}css/mood.css">
    <link rel="stylesheet" type="text/css" href="${path}css/bootstrap.min.css">
    <title>科研信息管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
    <div class="leftsidebar_box">
        <!--div class="line">
            <div class="avtor">
                <a href="#"><span>Hi,<!--s:property value="#session.userInfo.userName"--/></span></a>
            </div>
        </div-->
        <!--描述：左侧管理栏目导航-->
        <dl class="system_log">
            <a href="user_data.jsp"><dt id="person_info">个人信息管理<img src="images\left\select_xl01.png"></img></dt></a>
        </dl>
        <dl class="custom">
            <a href="select.jsp"><dt id="jtitle">科研项目管理<img src="images/left/select_xl01.png"></img></dt></a>
        </dl>
        <dl class="app">
            <a href="upload.jsp"><dt>文件管理<img src="images/left/select_xl01.png"></img></dt></a>
        </dl>
        <dl class="statistics">
            <a href="contact_us.jsp"><dt>联系我们<img src="images/left/select_xl01.png"></img></dt></a>
        </dl>
    </div>
    <script type="text/javascript" src="${path }js/jquery.min.js"></script>
    <script type="text/javascript" src="${path }js/admin.js"></script>
    <script type="text/javascript" src="${path }js/bootstrap.min.js"></script>
</body>
</html>
