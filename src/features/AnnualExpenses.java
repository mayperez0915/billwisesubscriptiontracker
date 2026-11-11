package features;

import java.util.ArrayList;
import java.util.Scanner;
import model.Subscription;
import utility.CurrencyFormatter;

public class AnnualExpenses extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== ANNUAL EXPENSES =====");

        ArrayList<Subscription> list =
                service.getAllSubscriptions();

        double total = 0;

        for (Subscription subscription : list) {

            if (subscription.getBillingCycle().equalsIgnoreCase("Monthly")) {
                total += subscription.getPrice() * 12;
            } else {
                total += subscription.getPrice();
            }
        }

        System.out.println("Total Annual Expenses: " +
                CurrencyFormatter.format(total));
    }
}