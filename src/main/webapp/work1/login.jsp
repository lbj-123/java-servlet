<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/22
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<div class="form-container">
    <h2>登录</h2>
    <form id="loginForm" action="/login" method="post" onsubmit="return setAutoLoginCookies()">
        <input type="text" placeholder="Username" name="username" id="username" autocomplete="username" required>
        <input type="password" placeholder="Password" name="password" id="password" autocomplete="current-password" required><br>
        <div class="radio-group">
            <span class="auto-login-text">免密：</span>
            <label><input type="radio" name="nopwd" value="<%=60*60*24*7%>"> 一周</label>
            <label><input type="radio" name="nopwd" value="<%=60*60*24*15%>"> 半个月</label>
            <label><input type="radio" name="nopwd" value="<%=60*60*24*31%>"> 一个月</label>
            <label><input type="radio" name="nopwd" value="<%=0%>"> 不启用</label>
        </div>
        <br><br>
<%--        <input type="checkbox" name="cancelAutoLogin" value="true"> 取消自动登录<br><br>--%>
        <button type="submit" onclick="setAutoLoginCookies()">Login</button>
        <a href="register.jsp">去注册</a>
    </form>
</div>
</body>
<script>
    // 从Cookies中获取值并填充到表单中
    window.onload = function() {
        var username = getCookie("username");
        var password = getCookie("password");

        if (username) {
            document.getElementById('username').value = username;
        }
        if (password) {
            document.getElementById('password').value = password;
        }
    }

    function getCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) === ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    // 设置自动登录的 Cookie
    function setAutoLoginCookies() {
        var usernameElement = document.getElementById('username');
        var passwordElement = document.getElementById('password');

        // 检查用户名和密码是否为空
        if (usernameElement && passwordElement) {
            var username = usernameElement.value;
            var password = passwordElement.value;
            var nopwd = document.querySelector('input[name="nopwd"]:checked').value;

            // 设置用户名和密码的 Cookie
            document.cookie = "username=" + username + "; max-age=" + nopwd + "; path=/";
            document.cookie = "password=" + password + "; max-age=" + nopwd + "; path=/";
            return true; // 允许表单提交
        }
        return false; // 阻止表单提交
    }
</script>
</html>
