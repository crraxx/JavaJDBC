package com.ff.javajdbc;

import java.sql.*;
import java.util.Date;

public class Demo4 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&serverTimezone=UTC";
        //与数据库键连接
        Connection connection = DriverManager.getConnection(url, "root", "wyf523");
        try {
            //获取statement
            Statement st = connection.createStatement();

            String name = "tom";
            String sex = "女";
            String birthday = "1999-05-23";
            int grade = 4;
            int score = 90;
            String phone = "15333333333";
            String adress = "旬邑";

            String sql = "insert into student(name,sex,birthday,grade,score,phone,address,reg_time) "
                    + "values(?,?,?,?,?,?,?,?)";//?表示占位符，表示一个值的位置
            //预先将sql语句编译到PreparedStatement对象中
            PreparedStatement ps = connection.prepareStatement(sql);

            //向sql中占位符进行赋值操作
            ps.setString(1, name);
            ps.setString(2, sex);
            ps.setString(3, birthday);
            ps.setInt(4, grade);
            ps.setInt(5, score);
            ps.setString(6, phone);
            ps.setString(7, adress);
            ps.setObject(8, new Date());
            ps.executeUpdate();

            /*
            Statement：
                1.静态SQL执行，没操作一次向数据库编译发送一次，效率低
                2.将变量以字符串形式拼接进去，书写麻烦
                3.不能防止sql注入，安全性低


             PreparedStatement：
                1.预先将sql语句编译到PreparedStatement对象中可以重复使用，效率高
                2.使用set方法向占位符处进行设置值，书写方便
                3.可以防止SQL注入，安全性高
             */

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
