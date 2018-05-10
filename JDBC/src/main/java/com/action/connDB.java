package com.action;

import java.sql.*;

public class connDB {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    public Connection getConnection(){
        String db_class_name = "com.mysql.jdbc.Driver";
        String db_url = "jdbc:mysql://localhost:3306/kyxi?user=root&password=database&useUnicode=true";
        try{
            Class.forName(db_class_name);
            conn = DriverManager.getConnection(db_url);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(conn == null){
            System.err.println("获得数据库连接失败");
        }
        return conn;
    }
    public ResultSet executeQuery(String sql){
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return  rs;
    }
    public int executeUpdate(String sql){
        int num = 0;
        try{
            ps = conn.prepareStatement(sql);
            num = ps.executeUpdate();
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return  num;
    }
    public void close(){
        try{
            if(rs != null){
                rs.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(ps != null){
                ps.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if(conn != null){
                conn.close();
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
