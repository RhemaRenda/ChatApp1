/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp1;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class ChatApp1 {

    public static void main(String[] args) {
   




        Scanner input = new Scanner(System.in);

        System.out.println("=== Registration ===");

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        Login login = new Login(firstName, lastName);

        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.println(login.getUsernameMessage(username));

        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.println(login.getPasswordMessage(password));

        System.out.print("Enter South African cell number with international code: ");
        String cellPhone = input.nextLine();
        System.out.println(login.getCellPhoneMessage(cellPhone));

        String registrationResult = login.registerUser(username, password, cellPhone);
        System.out.println(registrationResult);

        if (!registrationResult.equals("User has been registered successfully.")) {
            System.out.println("Registration failed. Please restart and try again.");
            input.close();
            return;
        }

        System.out.println("\n=== Login ===");

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        boolean loginSuccess = login.loginUser(enteredUsername, enteredPassword);
        System.out.println(login.returnLoginStatus(loginSuccess));

        input.close();
    }
}
   

