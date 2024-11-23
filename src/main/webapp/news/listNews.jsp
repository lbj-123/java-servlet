<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
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
			<section class="news_list">
				<h1>新闻列表</h1>
				<ul>
				<c:forEach items="${requestScope.newsList}" var="news"> 
					<li><div class="dd_lm">[
							<c:choose>
							   <c:when test="${news.newstype == 1}">
							   		校内
							   </c:when>
							   <c:otherwise> 
							   		社会
							   </c:otherwise>
							 </c:choose>
					    ]
						</div> 
						<div class="dd_bt">
							<a href="dispNews.jsp?id=${news.id} ">${news.title} </a>
						</div>
						<div class="dd_time">${news.pubtime} </div>
					</li>
				</c:forEach>
				</ul> 
			</section>   		 
			<!--main end -->
		</main>
		<div class="blank20"></div>
		<div class="blank10"></div>
	</div>
	<%@include file="common/bottom.jsp"%>    
</body>
</html>