package presentation;

import features.AddSubscription;
import features.SubscriptionManager;
import java.util.Scanner;

public class Mainmenu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SubscriptionManager manager = new SubscriptionManager();

        int choice;

        AddSubscription addSubscription = new AddSubscription();

        do {

            System.out.println("==========================================================");
            System.out.println("                         BILLWISE                         ");
            System.out.println("               Subscription Expense Tracker               ");
            System.out.println("==========================================================");
            System.out.println("1. Add Subscription\t\t6. View Upcoming Subscriptions");
            System.out.println("2. Update Subscription\t\t7. Calculate Monthly Expenses");
            System.out.println("3. View All Subscriptions\t8. Calculate Annual Expenses");
            System.out.println("4. Delete Subscription\t\t9. Exit");
            System.out.println("5. Search Subscription");

            System.out.println("\n==========================================================");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();
            // Clear console
                System.out.print("\033[H\033[2J");
                System.out.flush();


            if (choice == 1) {

                addSubscription.add(manager, sc);

            } else if (choice == 9) {

                System.out.println("Thank you for using Billwise!");

            } else {

                System.out.println("Invalid choice! Try again.");

            }

            
        } while (choice != 9);

        sc.close();
    }
}