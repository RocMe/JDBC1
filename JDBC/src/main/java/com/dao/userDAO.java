package com.dao;

import com.action.connDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.entity.user;

public class userDAO extends connDB{
    public user getUser(String name){
        user new_user = null;
        String sql = "SELECT * FROM pro_user WHERE user_name = '" + name + "'";
        try{
            ResultSet rs = this.executeQuery(sql);
            if(rs.next()){
                new_user = new user();
                new_user.setName(rs.getString("user_name"));
                new_user.setPassword((rs.getString("user_password")));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        this.close();
        return new_user;
    }
    public boolean addUser(user new_user){
        boolean b = false;
        String sql = "INSERT INTO pro_user(user_name,user_password) VALUES('" + new_user.getName() + "','" + new_user.getPassword() + "')";
        try{
            int num = this.executeUpdate(sql);
            if(num > 0){
                b = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        this.close();
        return b;
    }
}
