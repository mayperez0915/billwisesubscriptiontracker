package presentation;

import java.util.Scanner;
import utility.ScreenHelper;

public class Mainmenu {

    private final SubscriptionMenu subscriptionMenu;
    private final  Expensemenu expenseMenu;

    public Mainmenu() {
        subscriptionMenu = new SubscriptionMenu();
        expenseMenu = new Expensemenu();
    }

    public void display(Scanner sc) {

        int choice = -1;

        while (choice != 3) {

            System.out.println("\n================================================");
            System.out.println("       BILLWISE SUBSCRIPTION EXPENSE TRACKER");
            System.out.println("================================================");
            System.out.println("1. Subscription Management");
            System.out.println("2. Expense Management");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        subscriptionMenu.display(sc);
                        break;

                    case 2:
                        expenseMenu.display(sc);
                        break;

                    case 3:
                        System.out.println("Thank you for using Billwise!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }

            ScreenHelper.pauseAndClear(sc);
        }
    }
}