package com.example.demo.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {
    ResultSet resultSet;
    Statement statement;
    Connection connection;
    final String url="jdbc:mysql://127.0.0.1/mytest";
    final String user="root";
    final String password="0417";
    final String sql="SELECT * FROM mytest.tempratures order by id desc limit 1 offset 0;";
    public DataBase(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection=DriverManager.getConnection(url, user, password);

            System.out.println("数据库连接成功");
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(0);
        }



    }


    public String fetchdata(){

        String data=" ";

        try {
            statement=connection.createStatement();

            resultSet=statement.executeQuery(sql);

            resultSet.next();

            data=resultSet.getString("value");
        } catch (Exception e) {

            e.printStackTrace();
            System.exit(0);
        }



        return data;
    }
}
