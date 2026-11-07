package features;

import java.util.ArrayList;
import model.Subscription;
import java.util.Scanner;
import java.util.Scanner;
public class SearchSubscription extends SubscriptionFeature {
    @Override 
    public void execute (Scanner sc){
        System.out.println("\n===== SEARCH SUBSCRIPTION =====");

        System.out.print("Enter App Name: ");
        String name = sc.nextLine();

        ArrayList<Subscription> list =
                service.getAllSubscriptions();


        boolean found = false;

        for (Subscription subscription : list){

            if (subscription.matches(name)){

                if (subscription.matches(name)){

                        System.out.println("-----------------------------");
                        System.out.println("ID: " + subscription.getId());
                        System.out.println("App Name: " +
                            subscription.getAppName());
                        System.out.println("Plan: " +
                            subscription.getPlanName());
                        System.out.println("Price: " +
                            subscription.getPrice());
                        System.out.println("Billing Cycle: " +
                            subscription.getBillingCycle());

                        found = true;
                    }
                }
                if (!found){
                    System.out.println("No matching subscription found");
                }
            }
        }
    
    }
}
