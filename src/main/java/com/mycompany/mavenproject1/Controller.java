/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.interfaces.Mapper;
import java.util.Calendar;

/**
 *
 * @author Tomoe
 */
public class Controller {

    Mapper mapper;

    public Controller(Mapper mapper) {
        this.mapper = mapper;
    }
  public Controller() {
      
    }
    public User register(String cpr, String name, String pw) {

        return mapper.registerUser(cpr, name, pw);
    }
   public Book borrow(String cpr, String ISBN) {

      return mapper.borrow(cpr, ISBN);
    }

}
