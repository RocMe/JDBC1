package com.entity;

public class manage {
    private int pro_id;
    private int c_id;
    private String contract;
    private double fare;
    public int getPID() { return pro_id; }
    public void setPID(int pro_id){
        this.pro_id = pro_id;
    }
    public int getCID() { return c_id; }
    public void setCID(int c_id){
        this.c_id = c_id;
    }
    public String getContract() { return contract; }
    public void setContract(String contract) { this.contract = contract; }
    public double getFare() { return fare; }
    public void setFare(double fare) { this.fare = fare; }
}
