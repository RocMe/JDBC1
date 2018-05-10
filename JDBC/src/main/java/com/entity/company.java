package com.entity;

public class company {
    private int c_id;
    private String c_name;
    private String c_type;
    private String c_contact;
    private String c_phone;
    private String c_email;
    public int getID() { return c_id; }
    public void setID(int c_id){
        this.c_id = c_id;
    }
    public String getName() { return c_name; }
    public void setName(String c_name){ this.c_name = c_name; }
    public String getType() { return c_type; }
    public void setType(String c_type) { this.c_type = c_type; }
    public String getContact() { return c_contact; }
    public void setContact(String c_contact){ this.c_contact = c_contact; }
    public String getPhone() { return c_phone; }
    public void setPhone(String c_phone){ this.c_phone = c_phone; }
    public String getEmail() { return c_email; }
    public void setEmail(String c_email){ this.c_email = c_email; }
}
