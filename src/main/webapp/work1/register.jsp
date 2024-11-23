<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/22
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="../css/register.css">
</head>
<body>
<div class="form-container">
    <h2>注册</h2>
    <form action="/register" method="post">
        <input type="text" placeholder="Username" name="username" required>
        <input type="password" placeholder="Password" name="password" required>
        <button type="submit">注册</button>
    </form>
</div>
</body>
</html>
