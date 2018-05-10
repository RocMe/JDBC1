<%--
  Created by IntelliJ IDEA.
  User: hasee-pc
  Date: 2018/4/11
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息修改</title>
    <script>
        var select_info={};
        select_info['项目信息']=['项目编号','项目名称','项目类型','项目总费用','项目状态','预计开始日期','预计完成日期'];
        select_info['公司信息']=['公司编号','公司名称','公司类型','公司负责人','公司电话','公司邮箱'];
        select_info['管理信息']=['合同编号','下拨费用'];
        function ChangeInfoList(){
            var info_list1 = document.getElementById("update_info1");
            var info_list2 = document.getElementById("update_info2");
            var sel_info = info_list1.options[info_list1.selectedIndex].value;
            while (info_list2.options.length){
                info_list2.remove(0);
            }
            var infos = select_info[sel_info];
            if(infos){
                for (var i = 0;i < infos.length;i++){
                    var info = new Option(infos[i],i);
                    info_list2.options.add(info);
                }
            }
        }
    </script>
</head>
<body onload="ChangeInfoList();">
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
<form action = "update_form",method = "post">
    <select name="first" id="update_info1" onchange="ChangeInfoList();">
        <option value="">--选择修改信息--</option>
        <option value="项目信息">项目信息</option>
        <option value="公司信息">公司信息</option>
        <option value="管理信息">管理信息</option>
    </select>
    <select name="second" id="update_info2"></select><br><br>
    <input type="text" name="id" placeholder="请输入编号"><br><br>
    <input type="text" name="info" placeholder="请输入要修改的信息"><br><br>
    <input type="button" value="返回" onclick="window.location.href = 'http://localhost:8080/JDBC/select.jsp'">
    <input type="submit" value="修改"><br><br>
    <input type="button" value="用户注销" onclick="window.location.href = 'http://localhost:8080/JDBC/logout.jsp'">
</form>
</body>
</html>
