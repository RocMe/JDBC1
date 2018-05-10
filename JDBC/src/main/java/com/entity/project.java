package com.entity;

public class project {
    private int pro_id;
    private String pro_name;
    private String pro_type;
    private double pro_fare;
    private String pro_status;
    private String pro_srartdate;
    private String pro_enddate;
    public int getID() { return pro_id; }
    public void setID(int pro_id){
        this.pro_id = pro_id;
    }
    public String getName() { return pro_name; }
    public void setName(String pro_name){ this.pro_name = pro_name; }
    public String getType() { return pro_type; }
    public void setType(String pro_type) { this.pro_type = pro_type; }
    public double getFare() { return pro_fare; }
    public void setFare(double pro_fare) { this.pro_fare = pro_fare; }
    public String getStatus() { return pro_status; }
    public void setStatus(String pro_status){ this.pro_status = pro_status; }
    public String getSrartdate() { return pro_srartdate; }
    public void setSrartdate(String pro_srartdate){ this.pro_srartdate = pro_srartdate; }
    public String getEnddate() { return pro_enddate; }
    public void setEnddate(String pro_enddate){ this.pro_enddate = pro_enddate; }
}
