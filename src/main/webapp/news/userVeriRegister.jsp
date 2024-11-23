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
				<section class="inputform">
				<div class="top-bar">
					<h1>注册确认</h1>
					<div class="breadcrumbs"></div>
				</div>
				<br/>
				<%
					request.setCharacterEncoding("utf-8");
					String uName = request.getParameter("username");
					String uPwd = request.getParameter("password");
					String uGender = request.getParameter("gender");
					String uResume = request.getParameter("resume");
				%>

				<table>
					<tr>
						<td>用户名：</td>
						<td><%=uName%></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><%=uPwd%></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><%=uGender%></td>
					</tr>
					<tr>
						<td>个人简介:</td>
						<td><%=uResume%></td>
					</tr>
				</table>

				<form action="/news/doRegister.jsp" method="post">
					<div style="display: none">
						用户名：<input type="text" name="username"
							value="<%=request.getParameter("username")%>"></input>
						密&nbsp&nbsp码：<input type="text" name="password"
							value="<%=request.getParameter("password")%>"></input>
						性&nbsp&nbsp别：<input type="text" name="gender"
							value="<%=request.getParameter("gender")%>"></input>
						个人简介<textarea name="resume" cols="20" rows="6"><%=request.getParameter("resume")%></textarea>
					</div>

					<input class="btn" type="submit" value="注册"></input>
					<a href="javascript:history.go(-1)"
						style="text-decoration: underline;">返回</a><br/>
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