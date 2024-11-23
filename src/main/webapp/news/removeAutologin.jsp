<%@page language="java" contentType="text/html;charset=utf-8"%>
<%
	Cookie cookie = new Cookie("autologin","msg");
	cookie.setMaxAge(0);
	cookie.setPath(request.getContextPath());
	response.addCookie(cookie);
	response.sendRedirect("index.jsp");
%>