<%@ page import="java.util.List" %>
<%@ page import="com.entity.manage" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/16
  Time: 21:34
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
    List<manage> manageList = (List<manage>)request.getAttribute("manageList");
    if(manageList == null || manageList.size() < 1){
        out.println("查询失败");
    }
    else{
        for(int i = 0;i < manageList.size();i++) {
            manage man = manageList.get(i);
            out.println("项目编号：" + man.getPID() + "<br>");
            out.println("公司编号：" + man.getCID() + "<br>");
            out.println("合同编号：" + man.getContract() + "<br>");
            out.println("下拨费用：" + man.getFare() + "<br>");
        }
    }
%>
<input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/query.jsp'"><br><br>
<input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</body>
</html>
