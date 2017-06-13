package com.app.mgnrega.mgnregaapp;

/**
 * Created by Admin on 3/17/2017.
 */

public class Official {

    public String official_id;
    public String aadhar_no;
    public String mobile_no;
    public String password;
    public String email_id;
    public String name;

    public Official(String official_id, String aadhar_no, String mobile_no, String password, String email_id, String name) {
        this.official_id = official_id;
        this.aadhar_no = aadhar_no;
        this.mobile_no = mobile_no;
        this.password = password;
        this.email_id = email_id;
        this.name = name;
    }

    public String getOfficial_id() {
        return official_id;
    }

    public void setOfficial_id(String official_id) {
        this.official_id = official_id;
    }

    public String getAadhar_no() {
        return aadhar_no;
    }

    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
