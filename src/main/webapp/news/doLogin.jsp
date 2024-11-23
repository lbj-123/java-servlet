<%@page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="userDAO" class="com.example.news.beans.UserDAO" scope="page"/>
<%  // news.beans.UserDAO userDAO=new news.beans.UserDAO();
    String userName =request.getParameter("username");
    String pwd=request.getParameter("password");
	out.print(userName);
   if (userDAO.queryByNamePwd(userName,pwd)){
		session.setAttribute("username",userName);
				//免密码自动登录
		String nopwd = request.getParameter("nopwd");
		if (nopwd != null) {
			Cookie cookie = new Cookie("autologin", userName + "-" + pwd);
			cookie.setMaxAge(Integer.parseInt(nopwd));
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			System.out.println(nopwd);
		}
		response.sendRedirect("/news/index.jsp");
	}else{
		response.sendRedirect("/news/userLogin.jsp");
	}
%>
<!-- setMaxAge(int seconds) 该方法用于设置cookie的有效时间，传入的参数表示有效时间(秒)，是int型的秒数值 -->
<!--(1) seconds<0  cookie.setMaxAge(-1); 
设置负数的秒值，等同于--添加cookie时没有调用该方法，则浏览器默认将cookie保存在内存里，当浏览器关闭时，cookie从内存中释放（没有了）。
注：这种情况下，只要浏览器不关，cookie就会一直存在-->
<!-- (2) seconds=0  cookie.setMaxAge(0);这种设置用于删除同名的cookie，在servlet中创建一个与已存在的cookie同名的cookie，
设置该cookie生存时间为0，将该cookie添加进去，将覆盖原cookie，但因该cookie生存时间为0，所以会马上消失，起到了删除特定cookie的作用。-->
<!-- (3) seconds>0：cookie.setMaxAge(120); 表示将cookie在硬盘上存放seconds秒
该cookie将在硬盘中保存120秒，期间不管浏览器有没有关闭，该cookie都存在，但过了120秒后，该cookie将消失。 -->
<!-- 
cookie.setPath("/")或cookie.setPath(request.getContextPath()),可以调用在响应cookie之前设置cookie的携带路径，代表
所有路径下都会携带此cookie信息。
 -->
