package presentation;

import java.util.Scanner;
import service.LoginService;

public class Login {

    private LoginService loginService;
    private Scanner sc;

    public Login(LoginService loginService, Scanner sc) {
        this.loginService = loginService;
        this.sc = sc;
    }

    public boolean execute() {

        int attempts = 0;
        int maxAttempts = 3;

        System.out.println("================================================");
        System.out.println("       BILLWISE SUBSCRIPTION EXPENSE TRACKER");
        System.out.println("                    LOGIN");
        System.out.println("================================================");

        while (attempts < maxAttempts) {

            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            if (loginService.authenticate(username, password)) {
                System.out.println("\nLogin successful!");
                return true;
            }

            attempts++;

            System.out.println("Incorrect username or password.");
            System.out.println("Attempts remaining: " +
                    (maxAttempts - attempts));
        }

        System.out.println("\nMaximum login attempts reached.");
        System.out.println("Program will now close.");

        return false;
    }
}