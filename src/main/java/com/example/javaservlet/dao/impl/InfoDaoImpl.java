package com.example.javaservlet.dao.impl;

import com.example.javaservlet.dao.InfoDao;
import com.example.javaservlet.pojo.Info;
import com.example.javaservlet.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoDaoImpl implements InfoDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void addInfo(Info info) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into student(name,age,gender,major) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数值
            preparedStatement.setString(1, info.getName());
            preparedStatement.setInt(2, info.getAge());
            preparedStatement.setString(3, info.getGender());
            preparedStatement.setString(4, info.getMajor());

            //执行插入
            int rowsAffected = preparedStatement.executeUpdate();
            // 检查是否成功插入数据
            if (rowsAffected > 0) {
                // 插入成功，可以打印日志或执行其他操作
                System.out.println("Info added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection, preparedStatement);
        }
    }

    @Override
    public void updateInfo(Info info) {
        try {
            connection=JDBCUtils.getConnection();
            String sql="UPDATE student SET name = ?, age = ?, gender = ?, major = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数值
            preparedStatement.setString(1, info.getName());
            preparedStatement.setInt(2, info.getAge());
            preparedStatement.setString(3, info.getGender());
            preparedStatement.setString(4, info.getMajor());
            preparedStatement.setInt(5,info.getId());

            // 执行更新
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                // 插入成功，可以打印日志或执行其他操作
                System.out.println("Info updated successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(connection, preparedStatement);
        }
    }

    @Override
    public void deleteInfo(int id) {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "DELETE FROM student WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            // 执行删除
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("信息删除成功");
            } else {
                System.out.println("没有找到匹配的信息");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,preparedStatement);
        }
    }
}
