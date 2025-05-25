/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.quickchat.QuickChat;
import static com.mycompany.quickchat.QuickChat.checkRecipientCell;
import static com.mycompany.quickchat.QuickChat.generateMessageId();

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */


public class QuickChatTest {

    QuickChat quick = new QuickChat();
   
    @Test
    public void testValidCellphone() {
        assertTrue(quick.checkRecipientCell("+27123456789"));
        assertFalse(quick.checkRecipientCell("123456789"));
        assertFalse(quick.checkRecipientCell("+2787654321"));
    }

    @Test
    public void testcreateMessageHash() {
        assertEquals("00:0:HITONIGHT",quick.createMessageHash("0000000000","Hi Mike, can you join us for dinner tonight"));
       }
    
    
     @Test
    public void testCreateMessageID() {
        assertTrue(int,quick.generateMessageId());
       }
}
