package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.UserDao;
import com.example.javaservlet.dao.impl.UserDaoImpl;
import com.example.javaservlet.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register",value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 获取前端页面传过来的值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDao userDao = new UserDaoImpl();
        if (userDao.register(user)) {
            System.out.println("注册成功");
            // 注册成功，跳转登录页面
            // 注册成功，跳转并传递用户信息到注册成功页面
            req.setAttribute("user", user);
            req.setAttribute("password",password);
            req.getRequestDispatcher("/work1/register-success.jsp").forward(req,resp);
        } else {
            System.out.println("注册失败");
            req.setAttribute("message", "注册失败");
            req.getRequestDispatcher("/work1/register.jsp").forward(req,resp);
        }

    }
}