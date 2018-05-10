<%@ page import="java.util.List" %>
<%@ page import="com.entity.project" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/16
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
<jsp:include page="left.jsp"></jsp:include>
<%
    List<project> projectList = (List<project>)request.getAttribute("projectList");
    List<Integer> companyList = (List<Integer>)request.getAttribute("companyList");
    if(projectList == null || projectList.size() < 1){
        out.println("查询失败");
    }
    else{
        for(int i = 0;i < projectList.size();i++) {
            project pro = projectList.get(i);
            out.println("项目编号：" + pro.getID() + "<br>");
            out.println("项目名称：" + pro.getName() + "<br>");
            out.println("项目类型：" + pro.getType() + "<br>");
            out.println("项目总费用：" + pro.getFare() + "<br>");
            out.println("项目状态：" + pro.getStatus() + "<br>");
            out.println("预计开始日期：" + pro.getSrartdate() + "<br>");
            out.println("预计完成日期：" + pro.getEnddate() + "<br>");
        }
        for(int i = 0;i < companyList.size();i++) {
            int j = companyList.get(i);
            int k = i + 1;
            out.println("负责公司" + k + "：" + j + "<br>");
        }
    }
%>
<input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/query.jsp'"><br><br>
<input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</body>
</html>
