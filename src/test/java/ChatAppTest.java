/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClass;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.chatapp1.Login;

/**
 *
 * @author Student
 */
public class ChatAppTest {
    
 @Test
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertEquals("Username successfully captured.", login.getUsernameMessage("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertEquals(
                "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                login.getUsernameMessage("kyle!!!!!!")
        );
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertEquals("Password successfully captured.", login.getPasswordMessage("Ch^&s&c@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login login = new Login("Kyle", "Smith");
        assertEquals(
                "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                login.getPasswordMessage("password")
        );
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertEquals("Cell phone number successfully added.", login.getCellPhoneMessage("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login("Kyle", "Smith");
        assertEquals(
                "Cell phone number incorrectly formatted or does not contain international code.",
                login.getCellPhoneMessage("08966553")
        );
    }

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch^&s&c@ke99!", "+27838968976");

        boolean result = login.loginUser("kyl_1", "Ch^&s&c@ke99!");
        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("Kyle", "Smith");
        login.registerUser("kyl_1", "Ch^&s&c@ke99!", "+27838968976");

        boolean result = login.loginUser("wrong_1", "wrongpass");
        assertFalse(result);
    }

    @Test
    public void testUsernameCorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordCorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity("Ch^&s&c@ke99!"));
    }

    @Test
    public void testPasswordIncorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectBoolean() {
        Login login = new Login("Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testReturnLoginStatusSuccess() {
        Login login = new Login("Kyle", "Smith");
        String result = login.returnLoginStatus(true);
        assertEquals("Welcome Kyle, Smith it is great to see you again.", result);
    }

    @Test
    public void testReturnLoginStatusFailure() {
        Login login = new Login("Kyle", "Smith");
        String result = login.returnLoginStatus(false);
        assertEquals("Username or password incorrect, please try again.", result);
    }
}
    
    

