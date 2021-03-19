package com.ff.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&serverTimezone=UTC";
        //与数据库键连接
        Connection connection = DriverManager.getConnection(url,"root","wyf523");
        try {
            //获取statement
            Statement st = connection.createStatement();
            //executeUpdate发送sql到数据库,返回所操作的行数
            //int res = st.executeUpdate("create table test(id int)");//可执行ddl,dml
            //int res = st.executeUpdate("insert into test(id) value (1)");//可执行ddl,dml
            int res = st.executeUpdate("delete from test where id");//可执行ddl,dml
            System.out.println(res);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
