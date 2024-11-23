<%@page language="java" contentType="text/html;charset=utf-8"%>
<header>
	<div id="logo_main"></div>
</header>
<div id="menu">
	<div id="user">
		<%
			String username = (String) session.getAttribute("username");
			boolean logined = false;
			boolean autologin = false;

			Cookie[] cookies = request.getCookies();
			for (int i = 0; (cookies != null) && (i < cookies.length); i++) {
				if ("autologin".equals(cookies[i].getName())) {
					autologin = true;
					username = cookies[i].getValue().split("-")[0];
					break;
				}
			}

			if (username != null) {
				logined = true;
			} else if (autologin) {
				logined = true;
			}

			if (!logined) {
		%>
		<a href="/news/userLogin.jsp">用户登录</a>
		<%
			} else {
		%>
		当前用户：<%=username%>|
			<%
				if (autologin) {
			%>
			<a href="/news/removeAutologin.jsp">取消自动登录</a>
			<%
				} else {
			%>
			<a href="doLogout.jsp">退出登录</a>
			<%
				}
			}
		%>
	</div>
	<nav>
		<ul>
			<%
				if (username != null && username.equals("admin")) { //管理员功能
			%>
			<li><a href="#">新闻管理</a></li>|
			<li><a href="#">评论管理</a></li>|
			<li><a href="manageUser.jsp">用户管理</a></li>|
			<%
				} else if (username != null) {//普通用户功能
			%>
			<li><a href="#">评论管理</a></li>|
			<li><a href="modiUser.jsp">用户管理</a></li>|
			<%
				}
			%>
			<li><a href="index.jsp"> 首 页</a></li>
		</ul>
	</nav>
</div>