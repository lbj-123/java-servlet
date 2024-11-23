<%@page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新闻发布系统 V3</title>
<meta charset="utf-8">
<!-- rel:定义当前文档与被链接文档之间的关系，在这里需要制定为“stylesheet”，表示被链接的文档是一个样式表文件
type: 定义所链接文档的类型，在这里需要指定为“text/css"，表示链接的外部文件为CSS样式表，可以省略。。
href：定义所链接外部样式表的url，可以是相对路径，也可以是绝对路径。-->
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<jsp:include page="common/top.jsp" />
	<div id="content">
		<aside>
			<jsp:include page="common/left.jsp" />
		</aside>
		<main> <!-- main begin -->
		<section class="inputform">
			<form action="/news/doLogin.jsp" method="post">
				<input type="text" name="username" placeholder="用户名"
					required="required" /> <br><br>
				 <input type="password" name="password" placeholder="登录密码"><br>
				 自动登录：
				 <input type="radio" name="nopwd" value="<%=60*60*24*7%>">一周
				 <input type="radio" name="nopwd" value="<%=60*60*24*15%>">半个月
				 <input type="radio" name="nopwd" value="<%=60*60*24*31%>">一个月
				 <input type="radio" name="nopwd" value="<%=0%>">不启用 
				  <br> <br>
				 <input type="submit" value="登录"></input>
				  <a href="/news/userRegister.jsp">用户注册</a><br>
			</form>
		</section>
		<!--main end --> 
		</main>
		<div class="blank20"></div>
		<div class="blank10"></div>
	</div>
	<%@include file="common/bottom.jsp"%>
</body>
</html>
