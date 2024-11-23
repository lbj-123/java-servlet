<%@page language="java" contentType="text/html;charset=utf-8"%>
<%--<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>--%>
<%@page import="com.example.news.beans.News"%>
<!DOCTYPE html>
<html>
<head>
	<title>新闻发布系统V3</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<jsp:include page="common/top.jsp" />
	<div id="content">
		<aside>
			<jsp:include page="common/left.jsp" />
		</aside>
		<main>
			<!-- main begin -->
			<jsp:useBean id="newsDAO" class="com.example.news.beans.NewsDAO" scope="page"/>
			<% 
				String id = request.getParameter("id");
				newsDAO.increaseAc(id);
				News news=newsDAO.getByID(id);
			%>
			<article>
			  <h1><%=news.getTitle()%></h1>
			  <div class="news_time">
				<span class="left-t"><%=news.getPubtime() %></span>
				<span class="right-t">(点击：<%=news.getAcnumber() %>)
					<img src="image/1.png"/>
					<a href="comment?action1=disp&newsid=<%=news.getId() %>">查看评论</a>
				</span>
				<div class="clear"></div>
			  </div>

			  <!--正文start-->
			  <div class="left_zw" style="position:relative"> 
			  <%=news.getContent() %>
			  </div>
		 
			  <!--相关新闻-->
			  <div class="div624 border-top-darshd">        
				<h4 class="padding-left20" style="margin-top:0px;color: rgb(30, 80, 162);">
					<img src="image/titlebg2.gif"/>&nbsp&nbsp相关新闻：
				</h4>
				<ul class="padding-left20"  style="margin-top:-20px;">
				<%
					request.setAttribute("relateNews",newsDAO.getRelate(news.getId()));
				%>
				<c:forEach items="${requestScope.relateNews}" var="rnews"> 
					<li>.<a href="dispNews.jsp?id=${rnews.id}">${rnews.title}</a></li>
				</c:forEach>				
				</ul>
			  </div>
			  <!--相关新闻结束-->
			</article>    				 
			<!--main end -->
		</main>
		<div class="blank20"></div>
		<div class="blank10"></div>
	</div>
	<%@include file="common/bottom.jsp"%>    
</body>
</html>
