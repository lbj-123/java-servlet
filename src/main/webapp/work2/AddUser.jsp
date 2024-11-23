<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/13
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<div align="center">
    <form name="addUserForm" method="post" action="/AddUser">
        <font face="宋体" size="6"><strong>添加用户</strong></font><br/><hr/><br/>
        用户名：<input name="username" type="text" required /><br/><br/>
        密&nbsp;&nbsp;码：<input name="password" type="password" required /><br/><br/>
        <input type="submit" name="add" value="添加用户" />
    </form>
    <hr/>
    <a href="SearchAndModify.jsp">返回查询修改页面</a><br/>
</div>
</body>
</html>
