package com.example.largerthanlobster;

import java.io.Serializable;

public class rshema implements Serializable  {
    private String tor,place,date,hour ;

    public rshema(){}
    public String getTor() {
        return tor;
    }

    public void setTor(String tor) {this.tor = tor; }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) { this.place = place; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String tostring(){
        return "tor:" + tor +"  date:" + date + "  place:" + place +"  hour:"+hour;
    }

}
