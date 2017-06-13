package com.app.mgnrega.mgnregaapp;

/**
 * Created by Admin on 3/21/2017.
 */

public class ApplicationFormDetails {

    public String applicant_name;
    public String applicant_id;
    public String applicant_area;
    public String applicant_from_date;
    public String applicant_to_date;
    public String mob;

    public ApplicationFormDetails(){}

    public ApplicationFormDetails(String applicant_name,String applicant_id, String applicant_area, String applicant_from_date, String applicant_to_date,String mob) {
        this.applicant_name = applicant_name;
        this.applicant_name = applicant_id;
        this.applicant_area = applicant_area;
        this.applicant_from_date = applicant_from_date;
        this.applicant_to_date = applicant_to_date;
        this.mob=mob;

    }

    public String getMob(){
        return mob;
    }
    public void setMob(String m){
        mob=m;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getApplicant_id() {
        return applicant_name;
    }

    public void setApplicant_id(String applicant_id) {
        this.applicant_id = applicant_id;
    }
    public String getApplicant_area() {
        return applicant_area;
    }

    public void setApplicant_area(String applicant_area) {
        this.applicant_area = applicant_area;
    }

    public String getApplicant_from_date() {
        return applicant_from_date;
    }

    public void setApplicant_from_date(String applicant_from_date) {
        this.applicant_from_date




                = applicant_from_date;
    }

    public String getApplicant_to_date() {
        return applicant_to_date;
    }

    public void setApplicant_to_date(String applicant_to_date) {
        this.applicant_to_date = applicant_to_date;
    }

    }
