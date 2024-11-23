<%@ page import="com.example.javaservlet.pojo.User" %>
<%@ page import="com.example.javaservlet.pojo.Schedule" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/17
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日程安排</title>
    <style>
        .schedule-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        .schedule-container h1,.schedule-container h2 {
            text-align: center;
        }
        .schedule-container form p {
            margin: 10px 0;
        }
        .schedule-container ul {
            list-style-type: none;
            padding: 0;
        }
        .schedule-container li {
            background: #e0e0e0;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
        }
        .schedule-container .message {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="success.jsp"/>
<div class="schedule-container">
    <h1>日程安排</h1>
    <form action="/addSchedule" method="post">
        <p>日期: <input type="date" name="eventDate"></p>
        <p>时间: <input type="time" name="eventTime"></p>
        <p>描述: <input type="text" name="description"></p>
        <button type="submit">添加日程</button>
    </form>
    <h2>我的日程</h2>
    <ul>
        <%
            User user = (User) request.getSession().getAttribute("user");
            List<Schedule> schedules = (List<Schedule>) request.getAttribute("schedules");
            if (schedules == null || schedules.isEmpty()) {
        %>
        <p class="message">没有找到日程安排。</p>
        <%
        } else {
            for (Schedule schedule : schedules) {
        %>
        <li><%= schedule.getEventDate() %> <%= schedule.getEventTime() %> <%= schedule.getDescription() %></li>
        <%
                }
            }
        %>
    </ul>
    <button  type="button" onclick="redirectToHome()">回到首页</button>
</div>
</body>
<script>
    function redirectToHome(){
        window.location.href="/work1/success.jsp"
    }
</script>
</html>
