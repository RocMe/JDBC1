package com.dao;

import com.action.connDB;
import com.entity.manage;

public class manageDAO extends connDB{
    public boolean addManage(manage man){
        boolean b = false;
        String sql = "INSERT INTO pro_manage VALUES(" + man.getPID() + "," + man.getCID() + ",'" + man.getContract() + "'," + man.getFare() + ")";
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
