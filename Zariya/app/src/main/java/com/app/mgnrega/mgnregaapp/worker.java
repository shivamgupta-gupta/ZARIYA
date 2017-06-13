package com.app.mgnrega.mgnregaapp;

/**
 * Created by Admin on 3/17/2017.
 */

public class worker {
    public String password;
    public String email_id;

    public worker(String password, String email_id) {
        this.password = password;
        this.email_id = email_id;
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


}
