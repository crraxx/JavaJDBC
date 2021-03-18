package com.ff.javajdbc;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Demo1 {

    /*
    jdbc搭建步骤
    1.导入数据库开发商提供的数据库连接实现类的jar文件
    2.加载驱动
    3.建立与数据库的连接
    4.向数据库发送信息
    5.执行完毕后,关闭与数据库的连接
     */

    public static void main(String[] args) {
        //java反射机制,动态加载类
       /* Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.registerDriver(new Driver());*/
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        try {
            //建立与数据库的连接,返回connection对象
            Connection connection = DriverManager.getConnection(url,"root","wyf523");
            //statement用于向数据库发送sql语句
            Statement st = connection.createStatement();
            st.executeUpdate("insert into grade (name) value('四年级')");

            st.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
