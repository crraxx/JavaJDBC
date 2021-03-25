package com.ff.javajdbc;

import java.sql.*;
import java.util.ArrayList;

public class Demo8 {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/school_db?characterEncoding=utf8&serverTimezone=UTC";
        //与数据库键连接
        try {
            Connection connection = DriverManager.getConnection(url, "root", "wyf523");

            String sql = "select num,name,sex,birthday,grade,phone,address,reg_time from student ";

            PreparedStatement ps = connection.prepareStatement(sql);

            //executeQuery()用于执行查询语句，将查询到的结果封装到ResultSet对象中
            ResultSet rs = ps.executeQuery();

            ArrayList<Student> arrayList = new ArrayList<>();
            //可以将ResultSet中的对象，获取并转化为我们自己定义对象中
            //next() 判断结果集中是否还包含数据，如果包含返回true，将指针指向下一个数据
            while (rs.next()) {
                Student student = new Student();
                student.setNum(rs.getInt("num"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setBirthday(rs.getDate("birthday"));
                student.setGrade(rs.getInt("grade"));
                student.setPhone(rs.getString("phone"));
                student.setAddress(rs.getString("address"));
                student.setReg_time(rs.getTimestamp("reg_time"));
                arrayList.add(student);
            }

            for (Student student: arrayList) {
                System.out.println(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
