<%@page language="java" contentType="text/html;charset=utf-8"%>
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
			<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
			 
			<section class="news_list">
				<div class="top-bar">
					  <h1>评论管理</h1>
					  <div class="breadcrumbs"></div>
				  </div><br/>
					  
				<table class="listing" cellpadding="0" cellspacing="0" width="600" border="1">
				<tbody>	
					<c:forEach items="${requestScope.commentList}" var="comt">
					<tr>
						<td>to:<a href="dispNews.jsp?id=${comt.newsid}">${comt.newsid}</a></td>
						<td style="text-align:left">${comt.comment}</td>
						<td>[by:${comt.commentauthor}]</td>
						<td>in:${comt.commenttime}</td>
						<td width="50">
							<a href="comment?action=del&username=${sessionScope.username}&id=${comt.id }"  onclick="return confirm('确定删除吗?')">	
								<img src="image/hr.gif" width="16" height="16" />
							</a>
						</td>
					</tr>
					</c:forEach>	
				</tbody>
				</table>			 
			</section>
			<!--main end -->
		</main>
		<div class="blank20"></div>
		<div class="blank10"></div>
	</div>
	<%@include file="common/bottom.jsp"%>   
</body>
</html>
