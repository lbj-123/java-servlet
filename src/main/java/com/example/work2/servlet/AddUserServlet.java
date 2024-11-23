package com.example.work2.servlet;


import com.example.work2.pojo.User;
import com.example.work2.util.AccessUserFromDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddUserServlet", value = "/AddUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 检查用户名和密码是否有效
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 创建 User 对象
            User user = new User(username,password);
            // 创建 AccessUserFromDB 对象并添加用户
            AccessUserFromDB dbUser = new AccessUserFromDB();
            try {
                dbUser.Add(user);
                // 添加成功，返回成功信息
                response.getWriter().println("添加成功！！！");
                out.print(goBack);
                out.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // 添加失败，返回错误信息
                response.getWriter().println("Failed to add user: " + e.getMessage());
            }
        } else {
            // 用户名或密码为空，返回错误信息
            response.getWriter().println("Username and password cannot be empty.");
        }
    }
}