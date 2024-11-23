<%@ page import="com.example.javaservlet.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/22
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('../image/1.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h1 {
            margin-bottom: 20px;
        }
        p {
            font-size: 16px;
            margin: 10px 0;
        }
        a {
            display: block;
            margin: 10px 0;
            font-size: 16px;
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>注册成功！</h1>
    <p>用户名: <%= ((User) request.getAttribute("user")).getUsername() %></p>
    <p>密码: <%= ((User) request.getAttribute("user")).getPassword() %></p>
    <br>
    <a href="/work1/login.jsp">跳转登录</a>
    <a href="/work1/register.jsp">继续注册</a>
</div>
</body>
</html>
