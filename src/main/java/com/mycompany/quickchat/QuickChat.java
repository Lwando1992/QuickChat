/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

/**
 *
 * @author User
 */

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class QuickChat {
    private static final String FILE_NAME = "messages.json";
    private static List<String> sentMessages = new ArrayList<>();
    private static List<String> discardedMessages = new ArrayList<>();
    private static List<String> storedMessages = new ArrayList<>();
    private static List<String> messageHashes = new ArrayList<>();
    private static List<String> messageIds = new ArrayList<>();
    private static int totalMessagesSent = 0;
    private static int maxMessages;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
        maxMessages = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of messages you wish to send:"));
        registerUser();
    }

    public static void registerUser() {
        String username = JOptionPane.showInputDialog("Enter username (must contain underscore and max 5 characters):");
        if (!isValidUsername(username)) {
            JOptionPane.showMessageDialog(null, "Username is not correct");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter password (at least 8 characters, 1 capital letter, 1 number, 1 special character):");
        if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password is not correct");
            return;
        }

        String cellphone = JOptionPane.showInputDialog("Enter South African cellphone number (must start with +27 and 9 digits):");
        if (!isValidCellphone(cellphone)) {
            JOptionPane.showMessageDialog(null, "Cellphone number is not correct");
            return;
        }

        JOptionPane.showMessageDialog(null, "User successfully captured");
        login(username, password);
    }

    public static void login(String username, String password) {
        String inputUsername = JOptionPane.showInputDialog("Enter username to login:");
        String inputPassword = JOptionPane.showInputDialog("Enter password to login:");

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successful");
            JOptionPane.showMessageDialog(null, "Welcome " + username + ", it is great to see you again");
            messageMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Login details incorrect");
        }
    }

    public static void messageMenu() {
        while (totalMessagesSent < maxMessages) {
            String choice = JOptionPane.showInputDialog("Choose an option:\n1 - Send message\n2 - Show recently sent messages (Coming soon)\n3 - Quit");
            switch (choice) {
                case "1":
                    sendMessage();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;
                case "3":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
        JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent);
    }
//This method send the message to the enters cellphone number.
    public static void sendMessage() {
//In this line we prompt the user to input the message body.
        String message = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
//In this line we check the length of the message agaist the max message length allowed on the program.        
        if (message.length() > 250) {
            JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters");
            return;
        }
//In this line we prompt the user to input the cellphone number of recipient.
        String recipientCell = JOptionPane.showInputDialog("Enter recipient's cellphone number:");
        
//In this line we do a validation check on the cellphne number the user enters and disply the apropriate message.        
        if (!checkRecipientCell(recipientCell)) {
            JOptionPane.showMessageDialog(null, "Recipient's cellphone number is not valid");
            return;
        }
// In this line we call the generate message Id function to get the messageID
        String messageId = generateMessageId();
        
//In this line we call the createhash method and pass the messageId and message body as params to get message hsah.    
        String messageHash = createMessageHash(messageId, message);
//        storeMessage(messageId, recipientCell, message, messageHash);
        JOptionPane.showMessageDialog(null, "Message sent: " + message);
    }
    
    
//This method validates the username by checking if the string matches the regex pattern.
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_]{1,5}$") && username.contains("_");
    }

//This method validates the password by checking if the string matches the regex pattern.
    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }
    
    
//This method validates the cellphone number by checking if the string matches the regex pattern.
    public static boolean isValidCellphone(String cellphone) {
        return cellphone.matches("^\\+27[0-9]{9}$");
    }
    
//This method creates the message Id using the random class.
    public static String generateMessageId() {
        Random rand = new Random();
        String messageId = String.valueOf(rand.nextInt(1000000000));
        messageIds.add(messageId);
        return messageId;
    }
    
    
//This is a method that creates the message hash by cocatenating two formated strings
    public static String createMessageHash(String messageId, String message) {
        String[] words = message.split(" ");
        String hash = messageId.substring(0, 2) + ":" + words[0].toUpperCase() + " " + words[words.length - 1].toUpperCase();
        messageHashes.add(hash);
        return hash;
    }
    
//This is a method that validatesthe cellphone number of the recipient.
    public static boolean checkRecipientCell(String recipientCell) {
        return recipientCell.matches("^\\+27[0-9]{9}$");
    }

  

}
