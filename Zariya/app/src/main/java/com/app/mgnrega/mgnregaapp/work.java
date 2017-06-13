package com.app.mgnrega.mgnregaapp;

/**
 * Created by Anuj Munjal on 02-04-2017.
 */

public class work {
    public String address;
    public String work_id;
    public String area;
    public String govt_off_id;
    public int no_of_employees;

    public work(String address, String work_id, String area, String govt_off_id, int no_of_employees) {
        this.address = address;
        this.work_id = work_id;
        this.area = area;
        this.govt_off_id = govt_off_id;
        this.no_of_employees = no_of_employees;
    }

}
