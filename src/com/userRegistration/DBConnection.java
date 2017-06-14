package com.userRegistration;

import java.sql.*;

public class DBConnection {


    public static Connection getConnection(){

        Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user-management", "root", "");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException Ex) {
                Ex.printStackTrace();

            }


        return con;
    }
}
