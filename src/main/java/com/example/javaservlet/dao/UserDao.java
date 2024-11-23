package com.example.javaservlet.dao;

import com.example.javaservlet.pojo.User;

public interface UserDao {
    // 登录
    User login(String username, String password);

    // 注册
    Boolean register(User user);
}
