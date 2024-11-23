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

public class CommentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		CommentDAO commentDAO = new CommentDAOImpl();
		ArrayList<Comment> newComment = new ArrayList<Comment>();
		newComment = commentDAO.getTop5();
		System.out.println(newComment.size());
		request.setAttribute("newComment", newComment);

		String func = request.getParameter("action1");
		if (func == null) {
			func = "";
		}
		if (func.equals("disp"))// 按newsid查询评论
		{
			NewsDAO newsDAO = new NewsDAO();

			String newsid = request.getParameter("newsid");
			commentList = commentDAO.getByNewsID(Integer.parseInt(newsid));
			request.setAttribute("commentList", commentList);

			News news = newsDAO.getByID(newsid);
			request.setAttribute("news", news);
			request.getRequestDispatcher("listComment.jsp").forward(request, response);
		} else if (func.equals("add")) {// 发表评论
			Comment comm = new Comment();
			String newsid = request.getParameter("newsid");
			String comment = request.getParameter("comment");
			String commentauthor = request.getParameter("commentauthor");
			comm.setComment(comment);
			comm.setCommentauthor(commentauthor);
			comm.setNewsid(Integer.parseInt(newsid));
            System.out.println(newsid);
            System.out.println(comment);
            System.out.println(commentauthor);
			if (commentDAO.insert(comm)) {
				request.getRequestDispatcher("comment?action1=disp&newsid=" + newsid).forward(request, response);
			} else {
				response.getWriter().print("评论失败，请联系管理员！<a href='allNews.jsp'>返回首页</a>");
			}
		} else if (func.equals("del")) {// 删除评论
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			if (commentDAO.deleteById(id)) {
				if ("admin".equals(username)) {
					request.getRequestDispatcher("comment?action1=manage").forward(request, response);
				} else {
					request.getRequestDispatcher("comment?action1=usermanage&username=" + username).forward(request,
							response);
				}
			} else {
				response.getWriter().print("评论删除失败，请联系管理员！<a href='allNews.jsp'>返回首页</a>");
			}
		} else if (func.equals("manage")) {// 管理员评论管理
			commentList = commentDAO.getAll();
			request.setAttribute("commentList", commentList);
			request.getRequestDispatcher("manageComment.jsp").forward(request, response);
		} else if (func.equals("usermanage")) {// 用户评论管理
			String username = request.getParameter("username");
			commentList = commentDAO.getByUsername(username);
			request.setAttribute("commentList", commentList);
			request.getRequestDispatcher("manageComment.jsp").forward(request, response);
		} else {// 返回首页
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
