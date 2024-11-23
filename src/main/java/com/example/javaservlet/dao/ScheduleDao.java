package com.example.javaservlet.dao;

import com.example.javaservlet.pojo.Schedule;

import java.sql.SQLException;
import java.util.List;

public interface ScheduleDao {
    void add(Schedule schedule);
    List<Schedule> findByUserId(int userId) throws SQLException;
}
