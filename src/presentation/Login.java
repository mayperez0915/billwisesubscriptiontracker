package presentation;

import java.util.Scanner;
import service.LoginService;

public class Login {
    private LoginService loginService;
    private Scannner sc;

    public Login(LoginService loginService, Scanner sc){
        this.loginService = loginService;
        this.sc = sc;
    }

    public boolean execute  (){
        int attempts = 0;
        int maxAttempts = 3;

        System.out.println ("==========================================================");
        System.out.println ("                    BILLWISE LOGIN");
        System.out.println ("==========================================================");

        while (attempts < maxAttempts){
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (loginService.authenticate(username, password)){
                System.out.println("\nLogin successful!");
                System.out.println("Welcome to Billwise!");

                return true;
            } else {
                attempts++;

                 System.out.println("\nIncorrect username or password.");
                 System.out.println("Attempts remaining: "
                    + (maxAttempts - attempts));
            }
        }
        System.out.println("\nMaximum login attempts reached.");
        System.out.println("Access denied.");

        return false;
    }
}