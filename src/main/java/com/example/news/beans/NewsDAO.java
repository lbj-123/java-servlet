package com.example.news.beans;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.example.news.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsDAO {
	public static void main(String[] args) {
		NewsDAO nd = new NewsDAO();
		System.out.print(nd.getTop5());
	}

	/**
	 * 点击数加1
	 * 
	 * @param id
	 * @return
	 */
	public boolean increaseAc(String id) {
		boolean result = false;
		News news = getByID(id);

		news.setAcnumber(news.getAcnumber() + 1);

		modify(news);

		return result;
	}

	public ArrayList<News> getRelate(int id) {
		ArrayList<News> na = null;
		News news = null;
		int newsid;

		news = getByID(new Integer(id).toString());

		na = new ArrayList<News>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from news where keyword='" + news.getKeyword() + "'";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				newsid = rs.getInt("id");
				if (newsid != id) {
					news = new News();
					news.setId(rs.getInt("id"));
					news.setTitle(rs.getString("title"));
					news.setContent(rs.getString("content"));
					news.setAuthor(rs.getString("author"));
					news.setPubtime(rs.getString("pubtime"));
					news.setKeyword(rs.getString("keyword"));
					news.setAcnumber(rs.getInt("acnumber"));

					na.add(news);
				}
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}

		return na;
	}

	/**
	 * 取出点击数最高的5条新闻
	 * 
	 * @return
	 */
	public ArrayList<News> getTop5() {
		ArrayList<News> na = null;
		News news = null;

		na = new ArrayList<News>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			//String sql = "SELECT * from news order by acnumber desc limit 5";
			String sql = "SELECT top 5 * from news order by acnumber desc";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setPubtime(rs.getString("pubtime"));
				news.setKeyword(rs.getString("keyword"));
				news.setAcnumber(rs.getInt("acnumber"));

				na.add(news);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}

		return na;
	}

	/*
	 * 插入一条新闻
	 */
	public boolean insert(News news) {
		boolean result = false;
		int n = 0;
		news.setPubtime(getNowStr());
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into news (title, content, author,pubtime, keyword, newstype) " + "values ('"
					+ news.getTitle() + "','" + news.getContent() + "','" + news.getAuthor() + "','" + news.getPubtime()
					+ "','" + news.getKeyword() + "'," + news.getNewstype() + ")";
			n = stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			DBGet.closeConnection(conn);
		}
		if (n > 0)
			result = true;
		return result;
	}

	/*
	 * 以yyyy-MM-dd HH:mm:SS格式返回当前时间字符串
	 */
	static public String getNowStr() {
		String resultStr = null;
		String pattern = "yyyy-MM-dd HH:mm:ss";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			resultStr = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	public boolean modify(News news) {
		boolean result = false;
		int n = 0;
		// news.setPubtime(DateTimeUtil.getNowStr());
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			// String sql="insert into news (title , content ,author,pubtime,keyword) "
			sql = "update news set title='" + news.getTitle() + "',content='" + news.getContent() + "' ,author='"
					+ news.getAuthor() + "',pubtime='" + news.getPubtime() + "',keyword='" + news.getKeyword()
					+ "',acnumber='" + news.getAcnumber() + "',newstype=" + news.getNewstype() + " where id="
					+ news.getId();
			n = stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			System.out.println(e1 + "dao：" + sql);
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		if (n > 0)
			result = true;
		return result;
	}

	public boolean deleteByID(String id) {
		boolean result = false;
		int n = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "delete from news where id=" + id;
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

	public News getByID(String id) {
		News news = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from news where id = " + id;
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			if (rs.next()) {
				news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setPubtime(rs.getString("pubtime"));
				news.setKeyword(rs.getString("keyword"));
				news.setAcnumber(rs.getInt("acnumber"));
				news.setNewstype(rs.getInt("newstype"));
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return news;
	}

	public ArrayList<News> getAllNews() {
		News news = null;
		ArrayList<News> newsList = new ArrayList<News>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from news";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setPubtime(rs.getString("pubtime"));
				news.setKeyword(rs.getString("keyword"));
				news.setAcnumber(rs.getInt("acnumber"));
				news.setNewstype(rs.getInt("newstype"));
				newsList.add(news);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return newsList;
	}

	/*
	 * 根据关键字查询相关新闻
	 */
	public ArrayList<News> getByKeyword(String keyword) {
		News news = null;
		ArrayList<News> newsList = new ArrayList<News>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from news where keyword = '" + keyword + "'";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setAuthor(rs.getString("author"));
				news.setPubtime(rs.getString("pubtime"));
				news.setKeyword(rs.getString("keyword"));
				news.setNewstype(rs.getInt("newstype"));
				newsList.add(news);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			DBGet.closeConnection(conn);
		}
		return newsList;
	}
}
