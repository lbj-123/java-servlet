<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/22
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <style>
        .container{
            display: flex;
            justify-content: center;
        }
        .container a{
            text-align: center;
            font-family: Arial, sans-serif;
            font-size: 16px;
            text-decoration: none;
        }
        .container font{
            text-align: center;
            font-family: Arial, sans-serif;
            font-size: 16px;
        }
    </style>
</head>
<body background="../image/1.jpg">
<div class="container">
    <a href="/work1/login.jsp">重新登录</a>
    <br>
    <font color="red">
        <%
            if(request.getAttribute("message")!= null){
                response.setContentType("text/html;charset=UTF-8");
                out.print(request.getAttribute("message"));
            }
        %>
    </font>
</div>
</body>
</html>
