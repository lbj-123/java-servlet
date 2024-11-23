package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.InfoDao;
import com.example.javaservlet.dao.impl.InfoDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/deleteInfo")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取要删除的信息的id参数
        String idString = request.getParameter("id");
        if (idString == null || idString.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID parameter is missing");
            return;
        }

        int id = Integer.parseInt(idString);

        InfoDao infoDao = new InfoDaoImpl();
        infoDao.deleteInfo(id);

        // 假设删除成功后，重定向到信息列表页面或其他页面
        response.sendRedirect("/work1/list.jsp?DeleteSuccess=true");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}