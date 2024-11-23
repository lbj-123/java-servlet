package com.example.javaservlet.dao;

import com.example.javaservlet.pojo.Info;

public interface InfoDao {
    void addInfo(Info info);
    void updateInfo(Info info);
    void deleteInfo(int id);
}
