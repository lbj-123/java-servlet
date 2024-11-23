package com.example.news.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.news.beans.Comment;
import com.example.news.beans.CommentDAO;
import com.example.news.beans.CommentDAOImpl;
import com.example.news.beans.News;
import com.example.news.beans.NewsDAO;

public class NewsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//增加，显示最新的5条评论
		CommentDAO commentDAO = new CommentDAOImpl();
		ArrayList<Comment> newComment = new ArrayList<Comment>();
		newComment = commentDAO.getTop5();
		System.out.println(newComment.size());
		request.setAttribute("newComment", newComment);
		
		ArrayList<News> newsList = new ArrayList<News>();
		NewsDAO newsDAO = new NewsDAO();
		String func = request.getParameter("action1");
		if (func == null) {
			func = "";
		}
		if (func.equals("query")) {// 按关键字查询
			String keyword = request.getParameter("keyword");
			newsList = newsDAO.getByKeyword(keyword);
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher("listNews.jsp").forward(request, response);
		} else {  // 所有新闻
			newsList = newsDAO.getAllNews();
			request.setAttribute("newsList", newsList);
			request.getRequestDispatcher("listNews.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}