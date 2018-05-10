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
    <style>
        .container{
            position: relative;
        }

        .container .text{
            position: absolute;
            top: 10px;
            left: 20px;
            margin-left: 20px;
        }
        .container .text,.container .text h1{
            font-size:25px;
        }
        .form1{
            float: left;
        }

    </style>
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

<form class="form1">
    <a href="query.jsp">
        <div class="container">
            <img class="background" src="images/bg.png" />
            <div class="text">
                <h1>信息查询</h1>
            </div>
        </div>
    </a><br>
    <a href="insert.jsp">
        <div class="container">
            <img class="background" src="images/bg.png" />
            <div class="text">
                <h1>信息添加</h1>
            </div>
        </div>
    </a><br>
    <a href="update.jsp">
        <div class="container">
            <img class="background" src="images/bg.png" />
            <div class="text">
                <h1>信息修改</h1>
            </div>
        </div>
    </a><br>
    <a href="logout.jsp">
        <div class="container">
            <img class="background" src="images/bg.png" />
            <div class="text">
                <h1>用户注销</h1>
            </div>
        </div>
    </a><br>

</form>
</body>
</html>
