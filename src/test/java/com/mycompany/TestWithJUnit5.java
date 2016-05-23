/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.interfaces.Mapper;
import com.mycompany.mavenproject.Controller;
import com.mycompany.mavenproject.TestClassForJUnit5;
import com.mycompany.mavenproject.User;
import java.util.ArrayList;
import static org.junit.gen5.api.Assertions.*;
import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Test;
import org.junit.gen5.api.extension.ExtendWith;
import org.mockito.Matchers;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author Tomoe
 */
@ExtendWith(MockitoExtension.class)
public class TestWithJUnit5 {

    @Test
    @DisplayName("Test if the given user is registered")
    public void testRegisterUser(@InjectMock Mapper mapperMock) {
        String cpr = "1234567890";
        String name = "Tomoe";
        String pw = "testpassword";
        Controller c = new Controller(mapperMock);
        when(mapperMock.registerUser(cpr, name, pw)).thenReturn(new User(cpr, name, pw));

        User result = c.register(cpr, name, pw);

        verify(mapperMock).registerUser(Matchers.eq(cpr), Matchers.eq(name), Matchers.eq(pw));

        assertAll("User",
                () -> assertNotNull(result),
                () -> assertEquals(cpr, result.getCpr()),
                () -> assertEquals(name, result.getName()),//even though this fails, it proceeds to the next assertion
                () -> assertEquals(pw, result.getPw())
        );
    }

    @Test
    @DisplayName("Test getFirstValue from empty ArrayList")
    public void testGetFirstValue() {
        ArrayList<Object> array = new ArrayList();
        TestClassForJUnit5 testClass = new TestClassForJUnit5();

        expectThrows(IndexOutOfBoundsException.class, () -> {
            testClass.getFirstValue(array);
        });

    }

    @Test
    @DisplayName("Test custom exception message")
    public void testCustomExceptionMessage() {

        TestClassForJUnit5 testClass = new TestClassForJUnit5();

        Throwable exception = expectThrows(NullPointerException.class, () -> {
            testClass.throwExeption();
        });
        assertEquals("This is a custom message", exception.getMessage());
    }

}
