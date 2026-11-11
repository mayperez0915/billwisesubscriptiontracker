package features;

import java.util.Scanner;
import model.Subscription;

public class DeleteSubscription extends SubscriptionFeature {
    
    @Override 
    public void execute (Scanner sc){
        System.out.println("\n===== DELETE SUBSCRIPTION =====");

        try {
            System.out.print("Enter Subscription ID: ");
            int id = Integer.parseInt(sc.nextLine());

            Subscription subscription = service.findSubscription(id);

            if (subscription == null){
                System.out.println("Subscription not found.");
                return;
            }
            System.out.println("App Name: " + subscription.getAppName());

            System.out.println("Are you sure you want to delete it?");
            System.out.println("1. Yes");
            System.out.println("2. No");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1){
                service.deleteSubscription(id);
                System.out.println("Subscription deleted successfully!");
            } else if (choice == 2) {
                System.out.println("Deletion cancelled.");
            } else {
                System.out.println("Invalid Choice.");
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}