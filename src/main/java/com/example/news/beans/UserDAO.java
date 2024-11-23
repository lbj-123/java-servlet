package com.example.news.beans;

import com.example.news.beans.DBGet;

import java.sql.*;

public class UserDAO {
	public boolean queryByNamePwd(String uName, String up) {
		boolean result = false;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();
			// 5 执行sql语句
			String sql = "select * from [user] where username= '" + uName 
					+ "' and password = '" + up + "'";
			rs = stmt.executeQuery(sql);
			// 6 处理结果
			if (rs != null && rs.next())
				result = true;
		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return result;
	}

	public boolean addUser(User user) {
		boolean result = false;
		int n = 0;
		Connection conn = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "INSERT INTO [user] VALUES(null,'" + user.getUsername() + "','" 
					+ user.getPassword() + "','"
					+ user.getGender() + "','" 
					+ user.getResume() + "')";
			n = stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		if (n > 0)
			result = true;
		return result;
	}

}
