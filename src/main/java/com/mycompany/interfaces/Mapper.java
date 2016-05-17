/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.mavenproject1.User;

/**
 *
 * @author Tomoe
 * Mapper class. talk to the DB
 */
public interface Mapper {
    //insert user in db. 
    User registerUser(String cpr,String name, String pw);
    
}
