
package features;

import java.util.ArrayList;
import java.util.Scanner;
import model.Subscription;
import utility.CurrencyFormatter;
import utility.ScreenHelper;

public class ViewAllSubscription extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== ALL SUBSCRIPTIONS =====");

        ArrayList<Subscription> list =
                service.getAllSubscriptions();

        if (list.isEmpty()) {

            System.out.println("No subscriptions found.");

        } else {

            for (Subscription subscription : list) {

                System.out.println("-----------------------------");
                System.out.println("ID: " + subscription.getId());
                System.out.println("App Name: " + subscription.getAppName());
                System.out.println("Plan: " + subscription.getPlanName());

                System.out.println("Price: " +
                        CurrencyFormatter.format(subscription.getPrice()));

                System.out.println("Billing Cycle: " +
                        subscription.getBillingCycle());

                System.out.println("Next Payment: " +
                        subscription.getNextPaymentDate());
            }

            System.out.println("-----------------------------");

            System.out.println("Total Subscriptions: " +
                    service.getTotalSubscriptions());
        }

        System.out.println("\nPress Enter to return to the menu...");
        sc.nextLine();

        ScreenHelper.pauseAndClear(sc);
    }
}
