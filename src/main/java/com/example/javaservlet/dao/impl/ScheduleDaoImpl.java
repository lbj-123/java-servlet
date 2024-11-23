package com.example.javaservlet.dao.impl;

import com.example.javaservlet.dao.ScheduleDao;
import com.example.javaservlet.pojo.Schedule;
import com.example.javaservlet.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void add(Schedule schedule) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO schedule(userId, eventDate, eventTime, description) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数值
            preparedStatement.setInt(1, schedule.getUserId());
            preparedStatement.setString(2, schedule.getEventDate());
            preparedStatement.setString(3, schedule.getEventTime());
            preparedStatement.setString(4, schedule.getDescription());
            // 执行SQL语句
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(connection, preparedStatement);
        }
    }

    @Override
    public List<Schedule> findByUserId(int userId){
        List<Schedule> schedules = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM schedule WHERE userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getInt("id"));
                schedule.setUserId(resultSet.getInt("userId"));
                schedule.setEventDate(resultSet.getString("eventDate"));
                schedule.setEventTime(resultSet.getString("eventTime"));
                schedule.setDescription(resultSet.getString("description"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(connection, preparedStatement,resultSet );
        }
        return schedules;
    }
}
