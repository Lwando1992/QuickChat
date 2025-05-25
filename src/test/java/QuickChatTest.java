/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.quickchat.QuickChat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */


public class QuickChatTest {

    QuickChat quick = new QuickChat();
    @Test
    public void testValidUsername() {
        assertTrue(quick.isValidUsername("user_name"));
        assertFalse(quick.isValidUsername("username"));
        assertFalse(quick.isValidUsername("user"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(quick.isValidPassword("Password1!"));
        assertFalse(quick.isValidPassword("password"));
        assertFalse(quick.isValidPassword("Pass1"));
    }

    @Test
    public void testValidCellphone() {
        assertTrue(quick.isValidCellphone("+27123456789"));
        assertFalse(quick.isValidCellphone("123456789"));
        assertFalse(quick.isValidCellphone("+2787654321"));
    }

     @Test
    public void testcreateMessageHash() {
        assertEquals("00:0:HITONIGHT",quick.createMessageHash("0000000000","Hi Mike, can you join us for dinner tonight"));
       
    }
}
