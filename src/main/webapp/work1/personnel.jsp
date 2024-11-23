<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/4
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.sql.*"%>
<%@ page import="com.example.javaservlet.util.JDBCUtils" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="../css/personnel.css">
</head>
<body>
<%
    JDBCUtils jdbcUtils = new JDBCUtils();
    Connection connection = jdbcUtils.getConnection();
    Statement st = connection.createStatement();
    String sql = "select * from admin";
    ResultSet rs = st.executeQuery(sql);
%>
<div class="table-container">
    <table>
        <thead>
        <tr>
            <th colspan="2">个人信息</th>
        </tr>
        </thead>
        <tbody>
        <%
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                String phone = rs.getString("phone");
                String major = rs.getString("major");
                String email = rs.getString("email");
                String hometown = rs.getString("nativePlace");
                String school = rs.getString("graduatedSchool");
                String politicalStatus = rs.getString("politicalStatus");
                String hobby =rs.getString("hobby");
        %>
        <tr>
            <td>姓名:</td>
            <td><%= name %></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><%= age %></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><%= gender %></td>
        </tr>
        <tr>
            <td>手机号:</td>
            <td><%= phone %></td>
        </tr>
        <tr>
            <td>专业:</td>
            <td><%= major %></td>
        </tr>
        <tr>
            <td>电子邮件:</td>
            <td><%= email %></td>
        </tr>
        <tr>
            <td>出生地:</td>
            <td><%= hometown %></td>
        </tr>
        <tr>
            <td>毕业学校:</td>
            <td><%= school %></td>
        </tr>
        <tr>
            <td>政治面貌:</td>
            <td><%= politicalStatus %></td>
        </tr>
        <tr>
            <td>兴趣爱好:</td>
            <td><%= hobby %></td>
        </tr>
        <%
            }
            rs.close();
            st.close();
            connection.close();
        %>
        </tbody>
    </table>
</div>
<div class="button-container">
    <button onclick="window.location.href='success.jsp'">返回首页</button>
</div>
</body>
</html>
