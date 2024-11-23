package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.InfoDao;
import com.example.javaservlet.dao.impl.InfoDaoImpl;
import com.example.javaservlet.pojo.Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddInfo", value = "/AddInfo")
public class AddInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String gender = request.getParameter("gender");
        String major = request.getParameter("major");
        System.out.println(name);
        System.out.println(ageStr);
        System.out.println(gender);
        System.out.println(major);
        InfoDao infoDao=new InfoDaoImpl();
        // 将字符串年龄转换为整数
        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            // 年龄格式错误，发送错误响应给客户端
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid age format");
            return;
        }
            // 创建Info对象
        Info info = new Info(name, age, gender, major);

        try {
            infoDao.addInfo(info);
            // 重定向到添加页面并带上成功消息参数
            response.sendRedirect("/work1/list.jsp?AddSuccess=true");
        } catch (Exception e) {
            // 插入失败，发送错误响应给客户端
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "添加失败");
        }
    }
}
