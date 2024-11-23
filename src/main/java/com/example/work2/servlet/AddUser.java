package com.example.work2.servlet;

import com.example.work2.pojo.User;
import com.example.work2.util.AccessUserFromDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddUser", value = "/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //避免往数据库中写数据出现乱码，可以用两种方式避免：
        //request.setCharacterEncoding("gbk");
        //String username=new String(request.getParameter("username").getBytes("ISO8859_1"),"gbk");
        if(username==null||username.equals("")||password==null||password.equals(""))
        {
            out.print("用户名或密码不能为空！");
            out.print(goBack);
            return;
        }

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        AccessUserFromDB userDB = null;
        try {
            userDB = new AccessUserFromDB();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(userDB.exists(user.getUsername()))
        {
            out.print("用户名已存在！");
            out.print(goBack);
            return;
        }
        try {
            userDB.Add(user);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("添加失败:"+e.getLocalizedMessage());
            out.print(goBack);
            return;
        }
        out.print("添加成功！");
        out.print(goBack);
        out.close();
    }
}
