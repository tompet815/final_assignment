/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.util.Date;

/**
 *
 * @author Tomoe
 */
public class Book {

    private String ISBN;
    private String title;
    private String borrowedByCpr;
    private Date dueDate ;

    public Book(String ISBN, String title, String borrowedByCpr, Date dueDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.borrowedByCpr = borrowedByCpr;
        this.dueDate = dueDate;
    }



    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBorrowedByCpr() {
        return borrowedByCpr;
    }

    public void setborrowedByCpr(String borrowedByCpr) {
        this.borrowedByCpr = borrowedByCpr;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

}
