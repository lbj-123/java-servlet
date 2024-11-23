<%--
  Created by IntelliJ IDEA.
  User: 鲁本俊
  Date: 2024/6/10
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.sql.*"%>
<%@ page import="com.example.javaservlet.util.JDBCUtils" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查询</title>
    <link rel="stylesheet" type="text/css" href="../css/Info.css">
</head>
<body>
<%
    JDBCUtils jdbcUtils = new JDBCUtils();
    Connection connection=jdbcUtils.getConnection();
    Statement st = connection.createStatement();
    String sql = "select * from student";
    ResultSet rs = st.executeQuery(sql);
%>
<div class="Info-container">
    <table border="1" cellpadding="0" cellspacing="0">
        <caption>学生列表</caption>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>专业</td>
            <td>操作</td>
        </tr>
        <%while (rs.next()) { %>
        <tr>
            <td><%=rs.getInt("id") %>
            </td>
            <td><%=rs.getString("name") %>
            </td>
            <td><%=rs.getString("age") %>
            </td>
            <td><%=rs.getString("gender") %>
            </td>
            <td><%=rs.getString("major") %>
            </td>
            <td>
                <form action="/deleteInfo" method="post">
                    <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                    <button type="submit">删除</button>
                </form>
            </td>
        </tr>
        <%} %>
    </table>
</div>
</body>
</html>



