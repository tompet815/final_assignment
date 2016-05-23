/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.util.ArrayList;

/**
 *
 * @author Tomoe
 */
public class TestClassForJUnit5 {

    public Object getFirstValue(ArrayList<Object> array) throws IndexOutOfBoundsException {

        Object obj = array.get(0);
        return obj;
    }

    public void throwExeption() throws NullPointerException {

        throw new NullPointerException("This is a custom message");

    }

}
