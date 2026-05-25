package com.mycompany.chatapp1;

import java.util.Scanner;

public class ChatApp1 {

    public static void main(String[] args) {
     // Scanner used for user input
        Scanner input = new Scanner(System.in);
     // QuickChat registration section
        System.out.println("===== QUICKCHAT REGISTRATION =====");

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        // Created login object
        Login login = new Login(firstName, lastName);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.println(login.getUsernameMessage(username));

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.println(login.getPasswordMessage(password));

        System.out.print("Enter cell number (+27): ");
        String cell = input.nextLine();

        System.out.println(login.getCellPhoneMessage(cell));

        String registrationMessage
                = login.registerUser(username, password, cell);

        System.out.println(registrationMessage);

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        boolean loginSuccess
                = login.loginUser(enteredUsername, enteredPassword);

        System.out.println(login.returnLoginStatus(loginSuccess));

        if (loginSuccess) {

            System.out.println("\nWelcome to QuickChat.");

            boolean running = true;
         // Main QuickChat menu loop
            while (running) {

                System.out.println("\nChoose an option:");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("3) Quit");

                int option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1:

                        System.out.print("How many messages would you like to send? ");

                        int numberOfMessages = input.nextInt();
                        input.nextLine();

                        for (int i = 1; i <= numberOfMessages; i++) {

                            System.out.println("\nMessage " + i);

                            System.out.print("Enter recipient number: ");
                            String recipient = input.nextLine();

                            System.out.print("Enter message: ");
                            String messageText = input.nextLine();

                            Message message
                                    = new Message(i, recipient, messageText);

                            System.out.println(message.checkRecipientCell());

                            System.out.println(message.checkMessageLength());

                            if (!message.checkRecipientCell()
                                    .equals("Cell phone number successfully captured.")
                                    || !message.checkMessageLength()
                                            .equals("Message ready to send.")) {

                                System.out.println("Message failed.");

                                continue;
                            }
                             //allows user to choose message action
                            System.out.println("\nChoose option:");
                            System.out.println("1) Send Message");
                            System.out.println("2) Disregard Message");
                            System.out.println("3) Store Message");

                            int sendChoice = input.nextInt();
                            input.nextLine();

                            System.out.println(
                                    message.sentMessage(sendChoice));

                            if (sendChoice == 1
                                    || sendChoice == 3) {

                                System.out.println(
                                        "\n" + message.printMessage());
                            }
                        }

                        System.out.println(
                                "\nTotal messages sent: "
                                + Message.returnTotalMessages());

                        break;

                    case 2:

                        System.out.println("Coming Soon.");

                        break;

                    case 3:

                        running = false;

                        System.out.println("Exiting QuickChat.");

                        break;

                    default:

                        System.out.println("Invalid option.");
                }
            }
        }

        input.close();
    }
}
