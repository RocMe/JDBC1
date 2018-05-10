package com.dao;

import com.action.connDB;
import com.entity.project;

public class projectDAO extends connDB{
    public boolean addProject(project pro){
        boolean b = false;
        String sql = "INSERT INTO pro_info VALUES(" + pro.getID() + ",'" + pro.getName() + "','" + pro.getType()
                + "'," + pro.getFare() + ",'" + pro.getStatus() + "','" + pro.getSrartdate() + "','" + pro.getEnddate() + "')";
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
