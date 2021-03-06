/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interfaces;

import com.mycompany.mavenproject.Book;
import com.mycompany.mavenproject.User;

/**
 *
 * @author Tomoe
 * Mapper class. talk to the DB
 */
public interface Mapper {
    //insert user in db. 
    User registerUser(String cpr,String name, String pw);
    //set borrower cpr and due date in db. 
    Book borrow(String cpr,String ISBN);
    //remove borrower cpr and reset due date in db. 
    Book returnBook(String ISBN);
    
}
