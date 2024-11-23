<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/3
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../css/update.css">
<div class="updateInfo-container">
        <form action="/UpdateInfo" method="post">
            <h2>更新信息</h2>
            <label for="id">ID:</label>
            <input type="number" id="id" name="id" required><br>

            <label for="name">姓名:</label>
            <input type="text" id="name" name="name" required><br>

            <label for="age">年龄:</label>
            <input type="number" id="age" name="age" required><br>

            <label for="gender">性别:</label>
            <input type="text" id="gender" name="gender" required><br>

            <label for="major">专业:</label>
            <input type="text" id="major" name="major" required><br>

            <input type="submit" value="更新">
        </form>
</div>
