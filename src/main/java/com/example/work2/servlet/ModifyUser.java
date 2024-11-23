package com.example.work2.servlet;

import com.example.work2.pojo.User;
import com.example.work2.util.AccessUserFromDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
@WebServlet(name = "ModifyUser", value = "/ModifyUser")
public class ModifyUser extends HttpServlet {
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

        //String name=request.getParameter("modify");
        //String name="aa";
        //System.out.println(name);
        //if(name!=null) //单击了‘修改用户’
        //{
        String username=request.getParameter("modifyName");
        String password=request.getParameter("password");
        //System.out.println(username);
        //System.out.println(password);
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        AccessUserFromDB dbUser = null;
        try {
            dbUser = new AccessUserFromDB();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            dbUser.Update(user);
        } catch (SQLException e) {
            e.printStackTrace();
            out.print("修改失败："+e.getLocalizedMessage());
            out.print(goBack);
            return;
        }
//}
        out.print("修改成功！");
        out.print(goBack);
        out.close();
    }

}
