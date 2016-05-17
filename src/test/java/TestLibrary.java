/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.mockito.Mockito.*;
import com.mycompany.interfaces.Mapper;
import com.mycompany.mavenproject1.Book;
import com.mycompany.mavenproject1.Controller;
import com.mycompany.mavenproject1.User;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;

/**
 *
 * @author Tomoe
 */
public class TestLibrary {

    private static Mapper mapperMock;

    @BeforeClass
    public static void setUpClass() {
        mapperMock = mock(Mapper.class);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegisterUser() {
        String cpr = "1234567890";
        String name = "Tomoe";
        String pw = "testpassword";

        when(mapperMock.registerUser(cpr, name, pw)).thenReturn(new User(cpr, name, pw));

        Controller c = new Controller(mapperMock);
        User result = c.register(cpr, name, pw);

        verify(mapperMock).registerUser(Matchers.eq(cpr), Matchers.eq(name), Matchers.eq(pw));
        assertNotNull(result);
        assertEquals(cpr, result.getCpr());
        assertEquals(name, result.getName());
        assertEquals(pw, result.getPw());
    }

    @Test
    public void testBorrowUser() {
        String cpr = "12345";
        String ISBN = "67890";
        String title = "some title";
        
        Date todayplus7 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(todayplus7);
        cal.add(Calendar.DATE, 7);
        todayplus7 = cal.getTime();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        
        when(mapperMock.borrow(cpr, ISBN)).thenReturn(new Book(ISBN, title, cpr,todayplus7));
        Controller c = new Controller(mapperMock);
        Book b = c.borrow(cpr, ISBN);
        
        verify(mapperMock).borrow(Matchers.eq(cpr), Matchers.eq(ISBN));
        String todayString = ft.format(todayplus7);
        String resultString = ft.format(b.getDueDate());

        assertEquals(ISBN, b.getISBN());
        assertEquals(cpr, b.getBorrowedByCpr());
        assertEquals(todayString, resultString);
        assertEquals(title, b.getTitle());

    }
}
