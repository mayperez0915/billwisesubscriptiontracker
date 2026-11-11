
package features;

import java.util.ArrayList;
import java.util.Scanner;
import model.Subscription;
import utility.CurrencyFormatter;

public class ExpenseCalculator extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== EXPENSE CALCULATOR =====");
        System.out.println("1. Calculate Monthly Expenses");
        System.out.println("2. Calculate Annual Expenses");
        System.out.print("Enter choice: ");

        try {
            int choice = Integer.parseInt(sc.nextLine());

            ArrayList<Subscription> list =
                    service.getAllSubscriptions();

            double total = 0;

            if (choice == 1) {

                for (Subscription subscription : list) {
 
                    if (subscription.getBillingCycle()
                            .equalsIgnoreCase("Monthly")) {
                        total += subscription.getPrice();
                    } else {
                        total += subscription.getPrice() / 12;
                    }
                }

                System.out.println("Total Monthly Expenses: " +
                        CurrencyFormatter.format(total));

            } else if (choice == 2) {

                for (Subscription subscription : list) {

                    if (subscription.getBillingCycle()
                            .equalsIgnoreCase("Monthly")) {
                        total += subscription.getPrice() * 12;
                    } else {
                        total += subscription.getPrice();
                    }
                }

                System.out.println("Total Annual Expenses: " +
                        CurrencyFormatter.format(total));

            } else {
                System.out.println("Invalid choice.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}

