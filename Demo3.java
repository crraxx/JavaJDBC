package com.ff.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&serverTimezone=UTC";
        //与数据库键连接
        Connection connection = DriverManager.getConnection(url,"root","wyf523");
        try {
            //获取statement
            Statement st = connection.createStatement();

            String name = "jim";
            String sex = "女";
            String birthday = "1999-05-23";
            int grade = 4;
            int score = 90;
            String phone = "15333333333";
            String adress = "旬邑";

            st.executeUpdate("insert into student(name,sex,birthday,grade,score,phone,address,reg_time) "
                            +"values('"+name+"','"+sex+"','"+birthday+"',"+grade+","+score+",'"+phone+"','"+adress+"',new DATE ())");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
