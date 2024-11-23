package com.example.javaservlet.util;

import java.sql.*;

public class JDBCUtils {
    static final String url="jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    static final String user="root";
    static final String password="123456";
    private static Connection con;

    /**
     * 连接数据库
     * @return
     */
    public static Connection getConnection(){
        //添加驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 8.0以后版本加载驱动
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //进行连接
        try {
            con= DriverManager.getConnection(url, user, password);
            con.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    /**
     *对数据库的增加、修改和删除的操作
     * @param sql
     * @return
     */
    public boolean executeUpdate(String sql) {
        if (con == null) {
            getConnection();
        }
        try {
            Statement stmt = con.createStatement();
            int iCount = stmt.executeUpdate(sql);
            System.out.println("操作成功，所影响的记录数为" + String.valueOf(iCount));
            //if(iCount>0)
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 对数据库的查询操作
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        ResultSet rs;
        try {
            if (con == null) {
                getConnection();
            }
            Statement stmt = con.createStatement();
            try {
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("executeQueryError!");
            return null;
        }
        return rs;
    }

    /**
     * 关闭数据库
     */
    public static void  close(Connection con,Statement sta,ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement sta){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
