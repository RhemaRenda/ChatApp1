package com.mycompany.chatapp1;

import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessages = 0;

    private static ArrayList<String> storedMessages = new ArrayList<>();

    public Message(int messageNumber, String recipient, String messageText) {

        this.messageID = generateMessageID();
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {

        Random random = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {
            id += random.nextInt(10);
        }

        return id;
    }
     // Validates generated message ID
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    public String checkRecipientCell() {

        if (recipient.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
    // Ensure message does not exceed 250 characters
    public String checkMessageLength() {

        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {

            int extraCharacters = messageText.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + ", please reduce the size.";
        }
    }
     //Generates unique message hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    public String sentMessage(int choice) {

        switch (choice) {

            case 1:

                totalMessages++;

                return "Message successfully sent.";

            case 2:

                return "Press 0 to delete the message.";

            case 3:

                storedMessages.add(messageText);

                totalMessages++;

                return "Message successfully stored.";

            default:

                return "Invalid choice.";
        }
    }

    public String printMessage() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {

        return totalMessages;
    }

    public static ArrayList<String> getStoredMessages() {

        return storedMessages;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getMessageID() {
        return messageID;
    }
}