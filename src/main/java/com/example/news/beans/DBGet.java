package com.example.news.beans;
//1 数据库文件
import java.sql.*; 

public class DBGet {

    //数据库加载驱动
	static String sDBDriver = "com.mysql.cj.jdbc.Driver";
	static String sConnStr = "jdbc:mysql://localhost:3306/work2?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
	static String username = "root";
	static String password = "123456";
	
    public DBGet() {
    }
    //数据库连接
    public static Connection getConnection() {
        Connection conn = null;
        try {
        	//2 װ����������
            Class.forName(sDBDriver);  
            //3 �������ݿ�����
			conn = DriverManager.getConnection(sConnStr,username,password); 
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()+"dbget");
        }
        return conn;
    }

    //关闭数据库连接
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //关闭预编译
    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //  �ر�PreparedStatement����
    public static void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //关闭结果集
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
