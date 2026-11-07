package features;

import model.Subscription;
import java.util.ArrayList;
import java.util.Scanner;
import utility.CurrencyFormatter;

public class ViewAllSubscription extends Subscriptionfeature{
    @Override 

    public void execute(Scanner sc){
        System.out.println("\\n===== ALL SUBSCRIPTIONS =====");

        ArrayList<Subscription> list =
            service.getAllSubscription();

        if (list.isEmpty()){
            System.out.println("No Subscription found.");
            return;
        }
        for (Subscription subscription : list){
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
}
