package com.example.javaservlet.servlet;

import com.example.javaservlet.dao.ScheduleDao;
import com.example.javaservlet.dao.impl.ScheduleDaoImpl;
import com.example.javaservlet.pojo.Schedule;
import com.example.javaservlet.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ScheduleServlet", value = "/addSchedule")
public class ScheduleServlet extends HttpServlet {
    private ScheduleDao scheduleDao = new ScheduleDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            resp.sendRedirect("/work1/login.jsp");
            return;
        }

        try {
            List<Schedule> schedules = scheduleDao.findByUserId(user.getId());
            req.setAttribute("schedules", schedules);
            req.getRequestDispatcher("/work1/schedule.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");
//        System.out.println(user);
        if (user == null) {
            response.sendRedirect("/work1/login.jsp");
            return;
        }

        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String description = request.getParameter("description");
        if (eventDate == null || eventDate.isEmpty() || eventTime == null || eventTime.isEmpty()) {
            // Handle the error appropriately, e.g., return an error message to the user
            request.setAttribute("error", "日期和时间不能为空");
            request.getRequestDispatcher("/work1/schedule.jsp").forward(request, response);
            return;
        }

        Schedule schedule = new Schedule();
        schedule.setUserId(user.getId());
        schedule.setEventDate(eventDate);
        schedule.setEventTime(eventTime);
        schedule.setDescription(description);
        scheduleDao.add(schedule);
        response.sendRedirect("/addSchedule");
    }
}