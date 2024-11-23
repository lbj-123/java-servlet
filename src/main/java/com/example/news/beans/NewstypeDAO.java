package com.example.news.beans;

import com.example.news.beans.DBGet;
import com.example.news.beans.Newstype;

import java.util.ArrayList;
import java.sql.*;

public class NewstypeDAO {
	public static void main(String[] args) {
		NewstypeDAO nd = new NewstypeDAO();

	}

	public Newstype getByID(String id) {
		Newstype newstype = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from newstype where id = " + id;
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			if (rs.next()) {
				newstype = new Newstype();
				newstype.setId(rs.getInt("id"));
				newstype.setNewstype(rs.getString("newstype"));
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return newstype;
	}

	public ArrayList<Newstype> getAllNewstype() {
		Newstype newstype = null;
		ArrayList<Newstype> newstypeList = new ArrayList<Newstype>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from newstype";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				newstype = new Newstype();
				newstype.setId(rs.getInt("id"));
				newstype.setNewstype(rs.getString("newstype"));

				newstypeList.add(newstype);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return newstypeList;
	}

}
