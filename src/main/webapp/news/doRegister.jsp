<%@page language="java" import="java.util.*"
	contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<!--1 导入JDBC API -->
<%@ page  import="java.sql.*"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%
	Connection conn = null;
	Statement stmt = null;
	//连接时设置：serverTimezone=GMT%2B8表示北京当地时间，也可以使用serverTimezone=Asia/Shanghai
	String dbDrive="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //private final String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=sy_users";
    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=RC_users";
    String userName = "sa";
    String password = "07201011";

	//2 装载驱动程序
	try {
		Class.forName(dbDrive);
	} catch (ClassNotFoundException ex) {
		System.err.println(ex.getMessage());
	}

	try {
		//3 建立数据库连接
		conn = DriverManager.getConnection(url, userName, password);

		//4 创建Statement对象

		stmt = conn.createStatement();

		//5 执行sql语句
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		String gender = request.getParameter("gender");
		String resume = request.getParameter("resume");

		String sql = "INSERT INTO userr VALUES('" + uname + "','" + pwd + "','" + gender + "','" + resume
				+ "')";
		int result = stmt.executeUpdate(sql);

		//6 处理结果
		if (result == 1) {
			out.println("用户注册成功，请登录使用。");
		} else {
			out.println("用户注册失败，请联系管理员！");
		}
		out.println("<a href='userLogin.jsp'>登录</a>");
	} catch (SQLException e1) {
		out.println(e1);
	} finally {
		//7 关闭链接
		if(conn!=null)
			conn.close();
	}
%>

