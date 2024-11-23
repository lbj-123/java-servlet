<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/7
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="com.example.work2.util.AccessUserFromDB" %>
<%@ page import="com.example.work2.pojo.User" %>
<%
  String username=request.getParameter("queryName");
  User user=new User();
  if(username!=null && username!="")
  {
    AccessUserFromDB dbUser=new AccessUserFromDB();
    User temp=dbUser.searchByUsername(username.trim());
    if(temp==null)
    {
      out.print("No this user");
    }
    else
      user=temp;//防止user为null，导致下文的user.getUsername()产生异常
  }

  System.out.println(user.getUsername());
  System.out.println(username);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>查询和修改用户</title>
</head>

<body>
<div align="center">
  <form name="query" method="post" action="">
    <font face="宋体" size="6"><strong>查询和修改用户</strong></font><br/><hr/><br/>
    输入查询的用户名：  <input name="queryName" type="text"/> <input type="submit" name="query" value="查询用户" /><br/><br/><hr/><br/>
  </form>

  <form name="modifyform" method="post" action="/ModifyUser">
    用户名：
    <input name="modifyName" type="text" value="<%=user.getUsername()%>" readonly="readonly" />
    <br/><br/>
    密&nbsp;&nbsp;码：
    <input name="password" type="text" value="<%=user.getPassword()%>"/>
    <br /><br />
    <input type="submit" name="modify" value="修改用户" />
  </form>
  <hr/>
  <a href="Delete.jsp">删除用户</a><br/>
  <a href="AddUser.jsp">添加用户</a><br/>
</div>
</body>
</html>
<!-- readonly 属性规定输入字段为只读。
readonly="readonly"-->
