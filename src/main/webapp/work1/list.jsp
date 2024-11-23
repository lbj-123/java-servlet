<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/1
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>功能列表</title>
    <link rel="stylesheet" type="text/css" href="../css/list.css">
</head>
<body>
<jsp:include page="success.jsp" />
    <div class="list-container">
        <div class="sidebar">
            <h2>功能列表</h2>
            <ul>
                <li><button onclick="loadContent('addinfo.jsp')">添加信息</button></li>
                <li><button onclick="loadContent('updateInfo.jsp')">更新信息</button></li>
                <li><button onclick="loadContent('Info.jsp')">查询信息</button></li>
            </ul>
        </div>
        <div id="content-placeholder" class="content-placeholder">

        </div>
    </div>
</body>
<script>
    function loadContent(page) {
        const placeholder = document.getElementById('content-placeholder');
        fetch(page)
            .then(response => response.text())
            .then(data => {
                placeholder.innerHTML = data;
            })
            .catch(error => console.error('Error loading page:', error));
    }
    if (new URLSearchParams(window.location.search).has('AddSuccess')) {
        alert('添加成功!');
    }
    if (new URLSearchParams(window.location.search).has('UpdateSuccess')) {
        alert('更新成功!');
    }
    if (new URLSearchParams(window.location.search).has('DeleteSuccess')) {
        alert('删除成功!');
    }
</script>
</html>
