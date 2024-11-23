package com.example.work2.servlet;

import com.example.work2.util.AccessUserFromDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DeleteUser", value = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //返回上页
        String goBack="<br><a href='javascript:window.history.go(-1);'>返回上页</a>";
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username=request.getParameter("username");
        if(username==null||username.equals(""))
        {
            out.print("用户名不能为空！");
            out.print(goBack);
            return;
        }

        AccessUserFromDB userDB = null;
        try {
            userDB = new AccessUserFromDB();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(!userDB.exists(username))
        {
            out.print("用户名不存在！");
            out.print(goBack);
            return;
        }
        try {
            userDB.Delete(username);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("删除失败:"+e.getLocalizedMessage());
            out.print(goBack);
            return;
        }
        out.print("删除成功！");
        out.print(goBack);
        out.close();
    }

    }
