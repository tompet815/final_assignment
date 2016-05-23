package com.mycompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.mockito.Mockito.*;
import com.mycompany.interfaces.Mapper;
import com.mycompany.mavenproject.Book;
import com.mycompany.mavenproject.Controller;
import com.mycompany.mavenproject.User;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Tomoe
 */

@RunWith(MockitoJUnitRunner.class)
public class TestLibraryController {

    @Mock
    private static Mapper mapperMock;

    @InjectMocks
    private static Controller c;

    @Test
    public void testRegisterUser() {
        String cpr = "1234567890";
        String name = "Tomoe";
        String pw = "testpassword";

        when(mapperMock.registerUser(cpr, name, pw)).thenReturn(new User(cpr, name, pw));

        User result = c.register(cpr, name, pw);

        verify(mapperMock).registerUser(Matchers.eq(cpr), Matchers.eq(name), Matchers.eq(pw));
        assertNotNull(result);
        assertEquals(cpr, result.getCpr());
        assertEquals(name, result.getName());
        assertEquals(pw, result.getPw());
    }

    @Test
    public void testBorrow() {
        String cpr = "12345";
        String ISBN = "67890";
        String title = "some title";

        Date todayplus7 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(todayplus7);
        cal.add(Calendar.DATE, 7);
        todayplus7 = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");

        when(mapperMock.borrow(cpr, ISBN)).thenReturn(new Book(ISBN, title, cpr, todayplus7));

        Book b = c.borrow(cpr, ISBN);

        verify(mapperMock).borrow(Matchers.eq(cpr), Matchers.eq(ISBN));
        String todayString = ft.format(todayplus7);
        String resultString = ft.format(b.getDueDate());

        assertEquals(ISBN, b.getISBN());
        assertEquals(cpr, b.getBorrowedByCpr());
        assertEquals(todayString, resultString);
        assertEquals(title, b.getTitle());

    }

    @Test
    public void testReturn() {

        String ISBN = "67890";
        String title = "some title";

        when(mapperMock.returnBook(ISBN)).thenReturn(new Book(ISBN, title, "", null));
        Controller c = new Controller(mapperMock);
        Book b = c.returnBook(ISBN);

        verify(mapperMock).returnBook(Matchers.eq(ISBN));

        assertEquals(ISBN, b.getISBN());
        assertEquals("", b.getBorrowedByCpr());
        assertEquals(null, b.getDueDate());
        assertEquals(title, b.getTitle());

    }
}
