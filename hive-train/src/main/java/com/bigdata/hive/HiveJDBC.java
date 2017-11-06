package com.bigdata.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/10/16 0016.
 * hive JDBC JAVA API访问
 */
public class HiveJDBC {
    public static String driverName="org.apache.hive.jdbc.HiveDriver";
    public static String url="jdbc:hive2://192.168.38.180:14000/default";
    public static String username="hadoop";
    public static String password="";

    public static void main(String[] args) throws Exception{
        try {
            Class.forName(driverName);
        }catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        Connection connection=DriverManager.getConnection(url,username,password);
        Statement stms=connection.createStatement();
        ResultSet rs=stms.executeQuery("select * from student");
        while (rs.next()){
            System.out.println(rs.getString(1)+"---"+rs.getInt(2)+"!!!"+rs.getString(3));
        }
        rs.close();
        stms.close();
        connection.close();
    }

}
