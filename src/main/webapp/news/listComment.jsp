<%@page language="java" contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
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
		<main id="main_l">
			<!-- main_L begin -->
			<div class="main_top">
				<h2>	
					<a href="dispNews.jsp?id=${requestScope.news.id}">
						${requestScope.news.title }
					</a>	
				</h2>
				<span class="jjs">
					网友评论仅供网友表达个人看法，并不表明本网站同意其观点或证实其描述
				</span>

				<div class="fbpl">
					<span class="fd"><img src="image/zt2.gif"></span>
					<span class="fd">发表评论</span>
					<span class="fdr">
						<img style="cursor: pointer;" id="btnSubmitBottom" src="image/an7_1.gif" onclick="form_pl.submit()">
					</span><br><br>
					 <form id="form_pl" action="comment" method="post">
						<input type="hidden" name="action1" value="add">
						<input type="hidden" name="newsid" value="${requestScope.news.id }">
						<input type="hidden" name="commentauthor" value="${sessionScope.username }">
						<textarea name="comment" id="commentMessage" name="message"></textarea>
					</form>
					<div class="blank10"></div>
				</div>
			</div>

			<div class="yc"></div>
			<div class="main">
				<c:forEach items="${requestScope.commentList}" var="comment"> 
				<div class="nr">
					<img class="fd" src="image/an16.gif">
					<span class="fd">评论人：[ ${comment.commentauthor} ]</span>
					&nbsp;&nbsp;${comment.commenttime }&nbsp;&nbsp;
					<div class="clear"></div>
					<div class="blank20"></div>
					<div class="comment_p">${comment.comment }</div>
				</div>					
				</c:forEach>
			</div> 
			<!--main_L end -->
		</main>
		<div class="blank20"></div>
		<div class="blank10"></div>
	</div>
	<%@include file="common/bottom.jsp"%>    
</body>
</html>