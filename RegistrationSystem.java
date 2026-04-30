/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationsystem;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class RegistrationSystem {

   private User currentUser = null;
    private final Scanner sc;
    
    public RegistrationSystem(Scanner scanner) {
        this.sc = scanner;
    }
    
    public void register() {
        System.out.println("=== REGISTRATION ===");
        
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        
        System.out.print("Enter username (must contain '_' and be ≤5 chars): ");
        String username = sc.nextLine();
        
        if (!Login.verifyUserName(username)) {
            System.out.println(" Username is not correctly formatted.");
            return;
        }
        System.out.println(" Username successfully captured.");
        
        System.out.print("Enter password (≥8 chars, 1 uppercase, 1 digit, 1 special): ");
        String password = sc.nextLine();
        
        if (!Login.verifyPassword(password)) {
            System.out.println(" Password is not correctly formatted.");
            return;
        }
        System.out.println(" Password successfully captured.");
        
        System.out.print("Enter cell phone (+27...): ");
        String phone = sc.nextLine();
        
        if (!Login.checkPhone(phone)) {
            System.out.println(" Cell phone number incorrectly formatted.");
            return;
        }
        System.out.println("Cell phone number successfully added.");
        
        // Save user
        currentUser = new User(username, password, phone, firstName, lastName);
        System.out.println(" Registration successful!\n");
    }
    
    public void login() {
        if (currentUser == null) {
            System.out.println(" No registered user found. Please register first.");
            return;
        }
        
        System.out.println("=== LOGIN ===");
        
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        boolean loginSuccess = username.equals(currentUser.getStoredUsername()) && 
                              password.equals(currentUser.getStoredPassword());
        
        System.out.println(loginStatus(loginSuccess, currentUser.getLastName()));
    }
    
    public String loginStatus(boolean loginSuccess, String lastName) {
        if (loginSuccess) {
            return " Welcome " + currentUser.getFirstName() + " " + lastName + 
                   ", it is great to see you again!";
        } else {
            return " Username or password invalid, please try again.";
        }
    }
    
    public void showMenu() {
        int choice;
        
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-3): ");
                sc.next(); // consume invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println(" Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        } while (choice != 3);
    }
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            RegistrationSystem system = new RegistrationSystem(sc);
            system.showMenu();
        }
    }
    
}
