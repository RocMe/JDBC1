<%@ page import="java.util.List" %>
<%@ page import="com.entity.company" %>
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
    List<Integer> projectList = (List<Integer>)request.getAttribute("projectList");
    List<company> companyList = (List<company>)request.getAttribute("companyList");
    if(companyList == null || companyList.size() < 1){
        out.println("查询失败");
    }
    else{
        for(int i = 0;i < companyList.size();i++) {
            company com = companyList.get(i);
            out.println("公司编号：" + com.getID() + "<br>");
            out.println("公司名称：" + com.getName() + "<br>");
            out.println("公司类型：" + com.getType() + "<br>");
            out.println("公司负责人：" + com.getContact() + "<br>");
            out.println("公司电话：" + com.getPhone() + "<br>");
            out.println("公司邮箱：" + com.getEmail() + "<br>");
        }
        for(int i = 0;i < projectList.size();i++) {
            int j = projectList.get(i);
            int k = i + 1;
            out.println("负责项目" + k + "：" + j + "<br>");
        }
    }
%>
<input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/query.jsp'"><br><br>
<input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</body>
</html>
