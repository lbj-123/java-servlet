package com.example.news.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.news.beans.CommentDAO;
import com.example.news.util.DateTimeUtil;

public class CommentDAOImpl implements CommentDAO {
	public ArrayList<Comment> getByNewsID(int newsid) {
		Comment comment = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from comment where newsid=" + newsid + " order by commenttime desc";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				comment = new Comment();
				comment.setId((rs.getInt("id")));
				comment.setComment(rs.getString("comment"));
				comment.setCommentauthor(rs.getString("commentauthor"));
				comment.setCommenttime(rs.getString("commenttime"));
				comment.setNewsid(rs.getInt("newsid"));

				commentList.add(comment);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		return commentList;
	}

	public boolean insert(Comment comment) {
		// TODO Auto-generated method stubboolean result = false;
		boolean result = false;
		int n = 0;
		Connection conn = null;
		Statement stmt = null;

		comment.setCommenttime(DateTimeUtil.getNowStr());

		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "insert into comment (comment,commentauthor, commenttime,newsid) " + "values ('"
					+ comment.getComment() + "','" + comment.getCommentauthor() + "','" + comment.getCommenttime()
					+ "','" + comment.getNewsid() + "')";
			n = stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		if (n > 0)
			result = true;
		return result;

	}

	public boolean deleteById(String id) {
		// TODO Auto-generated method stubboolean result = false;
		boolean result = false;
		int n = 0;
		Connection conn = null;
		Statement stmt = null;

		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "delete from comment where id=" + id;
			n = stmt.executeUpdate(sql);
		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		if (n > 0)
			result = true;
		return result;

	}

	public ArrayList<Comment> getTop5() {
		Comment comment = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			// String sql="SELECT top 5 * from comment order by commenttime desc";
			//String sql = "SELECT * from comment order by commenttime desc limit 5";
			//String sql = "SELECT top 5 * from comment order by commenttime desc";
			String sql = "SELECT top 5 * from comment order by commenttime desc";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				comment = new Comment();
				comment.setId((rs.getInt("id")));
				comment.setComment(rs.getString("comment"));
				comment.setCommentauthor(rs.getString("commentauthor"));
				comment.setCommenttime(rs.getString("commenttime"));
				comment.setNewsid(rs.getInt("newsid"));

				commentList.add(comment);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		return commentList;
	}

	/**
	 * 根据用户名取出该用户的所有评论，供用户评论管理用
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<Comment> getByUsername(String username) {
		Comment comment = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from comment where commentauthor='" + username + "' order by commenttime desc";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				comment = new Comment();
				comment.setId((rs.getInt("id")));
				comment.setComment(rs.getString("comment"));
				comment.setCommentauthor(rs.getString("commentauthor"));
				comment.setCommenttime(rs.getString("commenttime"));
				comment.setNewsid(rs.getInt("newsid"));

				commentList.add(comment);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		return commentList;
	}

	/**
	 * 取出所有评论，供管理员评论管理用
	 * 
	 * @return
	 */
	public ArrayList<Comment> getAll() {
		Comment comment = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {

			conn = com.example.news.beans.DBGet.getConnection();
			// 4 创建Statement对象
			stmt = conn.createStatement();

			// 5 执行sql语句
			String sql = "SELECT * from comment order by commenttime desc";
			rs = stmt.executeQuery(sql);

			// 6 处理结果
			while (rs.next()) {
				comment = new Comment();
				comment.setId((rs.getInt("id")));
				comment.setComment(rs.getString("comment"));
				comment.setCommentauthor(rs.getString("commentauthor"));
				comment.setCommenttime(rs.getString("commenttime"));
				comment.setNewsid(rs.getInt("newsid"));

				commentList.add(comment);
			}

		} catch (SQLException e1) {
			System.out.println(e1 + "dao");
		} finally {
			// 7 关闭链接
			com.example.news.beans.DBGet.closeConnection(conn);
		}
		return commentList;
	}

}
