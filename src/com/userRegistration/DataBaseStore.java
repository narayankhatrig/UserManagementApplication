package com.userRegistration;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DataBaseStore {
    Map<Integer,User> m = new HashMap<Integer, User>();
    Connection con;

    public DataBaseStore(){
        this.con = DBConnection.getConnection();
    }
    public void addUser(User user){
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(name,address) VALUES (?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public void deleteUser(int id){
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id= ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUsers(User user,int id){
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE users SET name=?,"+"address=? WHERE id=?");
            System.out.println("update successful!");
            ps.setString(1,user.getName());
            ps.setString(2,user.getAddress());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Map display(){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();//executeQuery in SELECT and  in others executeUpdate
            System.out.println("connected to database\n");
            while (rs.next()){
                System.out.println( rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public Map searchByName(String name) {
        Map<Integer,User> tempMap = new HashMap<Integer, User>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE name like ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("id") + " " + rs.getString("name") + " "+ rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempMap;
    }
    public Map searchByAddress(String address) {
        Map<Integer,User> tempMap = new HashMap<Integer, User>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE address like ?");
            ps.setString(1,address);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("id") + " " + rs.getString("name") + " "+ rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempMap;
    }
}

