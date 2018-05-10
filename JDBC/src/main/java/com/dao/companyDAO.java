package com.dao;

import com.action.connDB;
import com.entity.company;

public class companyDAO extends connDB{
    public boolean addCompany(company com){
        boolean b = false;
        String sql = "INSERT INTO company VALUES(" + com.getID() + ",'" + com.getName() + "','" + com.getType()
                + "','" + com.getContact() + "','" + com.getPhone() + "','" + com.getEmail() + "')";
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
