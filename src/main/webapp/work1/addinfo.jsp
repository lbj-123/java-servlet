<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/28
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="../css/addInfo.css">

<div class="addinfo-container" >
        <form action="/AddInfo" method="post">
            <h2>添加信息</h2>
            <label for="name">姓名:</label>
            <input type="text" id="name" name="name" required><br>

            <label for="age">年龄:</label>
            <input type="number" id="age" name="age" required><br>

            <label for="gender">性别:</label>
            <input type="text" id="gender" name="gender" required><br>

            <label for="major">专业:</label>
            <input type="text" id="major" name="major" required><br>

            <input type="submit" value="Submit">
        </form>
</div>

