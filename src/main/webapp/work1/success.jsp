<%@ page import="com.example.javaservlet.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/5/22
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
    <link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
  <div class="main-container">
    <h1>个人事务信息系统</h1>
    <header>
      <nav>
        <ul>
          <li><a href="#" onclick="showInfo()">个人信息</a></li>
          <li><a href="#"onclick="showSchedule()">日程安排</a></li>
          <li><a href="#" onclick="ListToggle()">功能列表</a></li>
          <li id="logout-link"><a href="#">退出</a></li>
        </ul>
      </nav>
    </header>
    <!-- 隐藏的弹窗 -->
    <div id="logout-modal" class="modal">
      <div class="modal-content">
        <span class="close">&times;</span>
        <p>您确定要退出登录吗？</p>
        <button id="logout-confirm" >退出登录</button>
        <button id="logout-cancel">取消</button>
      </div>
    </div>
  </div>
</body>
<script>
  // 获取弹窗和相关的元素
  var modal = document.getElementById("logout-modal");
  var logoutLink = document.getElementById("logout-link");
  var logoutConfirm = document.getElementById("logout-confirm");
  var span = document.getElementsByClassName("close")[0];

  //展示个人信息
  function showInfo(){
    window.location.href='/work1/personnel.jsp';
  }
  //展示个人日程
  //展示个人日程
  function showSchedule(){
    window.location.href='/work1/schedule.jsp';
  }
  //展示功能列表
  function ListToggle(){
    window.location.href='/work1/list.jsp';
  }

  // 当点击“设置”链接时显示弹窗
  logoutLink.onclick = function() {
    modal.style.display = "block";
  }
  //点击退出登录按钮时返回到主页
  logoutConfirm.onclick=function (){
    // alert("正在退出登录...")
    fetch('/logout', {
      method: 'POST', // 使用POST方法发送请求
    }).then(response => {
              if (!response.ok) {
                throw new Error('退出失败');
              }
              // 退出成功，关闭模态窗口并重定向到登录页面
              modal.style.display = "none"; // 关闭模态窗口
              window.location.href = "/work1/login.jsp"; // 重定向到登录页面
            })
  }

  // 当点击弹窗的关闭按钮或背景时关闭弹窗
  span.onclick = function() {
    modal.style.display = "none";
  }

  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
</script>
</html>
