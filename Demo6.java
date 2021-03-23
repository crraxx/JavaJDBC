package com.ff.javajdbc;

import java.sql.*;

public class Demo6 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&serverTimezone=UTC";
        //与数据库键连接
        Connection connection = DriverManager.getConnection(url, "root", "wyf523");
        try {
            //获取statement
            Statement st = connection.createStatement();

            String name = "'陕西省' or 1=1";//暴力的sql注入，直接将值拼接到字符串中的，没有做任何处理，不能防止sql注入
            PreparedStatement ps = connection.prepareStatement("delete from t_area where name = ?");
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
