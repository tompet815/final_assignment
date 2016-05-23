/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

/**
 *
 * @author Tomoe
 */
public class User {
    
    String cpr;
    String name;
    String pw;

    public User(String cpr, String name, String pw) {
        this.cpr = cpr;
        this.name = name;
        this.pw = pw;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
    
    
    
    
    
}
