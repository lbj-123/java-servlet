package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.InfoDao;
import com.example.javaservlet.dao.impl.InfoDaoImpl;
import com.example.javaservlet.pojo.Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateInfo", value = "/UpdateInfo")
public class UpdateInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name=request.getParameter("name");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        String idStr =request.getParameter("id");

        int age = Integer.parseInt(ageStr);
        int id = Integer.parseInt(idStr);


        InfoDao infoDao=new InfoDaoImpl();
        // 创建Info对象
        Info info = new Info(name, age, gender, major,id);
        info.setName(name);
        info.setAge(Integer.parseInt(ageStr));
        info.setGender(gender);
        info.setMajor(major);

        try {
            infoDao.updateInfo(info);
            // 重定向到添加页面并带上成功消息参数
            response.sendRedirect("/work1/list.jsp?UpdateSuccess=true");
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "更新失败");
        }

    }
}