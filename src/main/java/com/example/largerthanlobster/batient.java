package com.example.largerthanlobster;

import java.util.ArrayList;

public class batient {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public batient(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        mytor=new ArrayList<rshema>();
        mystories= new ArrayList<add_story>();
    }

    public batient(){ }
    private String name;
    private String phone;
    private String email;
    private ArrayList<rshema> mytor;
    private ArrayList<add_story> mystories;

    public ArrayList<add_story> getMystories() {
        return mystories;
    }

    public void setMystories(ArrayList<add_story> mystories) {
        this.mystories = mystories;
    }

    public ArrayList<rshema> getMytor() {
        return mytor;
    }

    public void setMytor(ArrayList<rshema> mytor) {
        this.mytor = mytor;
    }


}
