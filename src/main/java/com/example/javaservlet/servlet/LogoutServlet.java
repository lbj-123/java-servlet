package com.example.javaservlet.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取会话对象
        HttpSession session = request.getSession(false);

        if (session != null) {
            // 清除会话中的用户信息（如果有的话）
            session.removeAttribute("username");
            // 使会话无效
            session.invalidate();
        }
    }
}