package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.UserDao;
import com.example.javaservlet.dao.impl.UserDaoImpl;
import com.example.javaservlet.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "loginServlet",value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 检查Cookie中是否有免密登录的信息
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
//        System.out.println(cookies);
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();

                }
            }
        }
        // 如果找到免密登录的Cookie，则自动登录
        if (username != null && password != null) {
            UserDao userDao = new UserDaoImpl();
            User user = userDao.login(username, password);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("/work1/success.jsp").forward(request, response);
                return;
            }
        }
        // 否则转发到登录页面
        request.getRequestDispatcher("/work1/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取前端页面传过来的值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nopwd = request.getParameter("nopwd");
//        String cancelAutoLogin = request.getParameter("cancelAutoLogin");

        // 执行查询数据库逻辑
        UserDao userDao = new UserDaoImpl();
        User user = userDao.login(username, password);

        // 如果根据用户名和密码能查得到值
        if (user != null) {
            request.getSession().setAttribute("user", user);
//            // 处理自动登录的逻辑
//            if (cancelAutoLogin == null || !cancelAutoLogin.equals("true")) {
                // 用户未选择取消自动登录，设置自动登录的 Cookie
                if (nopwd != null && !nopwd.equals("0")) {
                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie passwordCookie = new Cookie("password", password);

                    usernameCookie.setMaxAge(Integer.parseInt(nopwd));
                    passwordCookie.setMaxAge(Integer.parseInt(nopwd));

                    usernameCookie.setPath(request.getContextPath());
                    passwordCookie.setPath(request.getContextPath());

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                }
            request.getRequestDispatcher("/work1/success.jsp").forward(request, response);
        } else {    // 用户名或者密码错误执行以下代码
            request.setAttribute("message", "用户名或者密码错误");
            request.getRequestDispatcher("/work1/error.jsp").forward(request, response);
        }

    }
}