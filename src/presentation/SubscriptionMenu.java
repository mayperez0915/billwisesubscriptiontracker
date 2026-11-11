package presentation;

import features.BillwiseFeatureFactory;
import features.FeatureFactory;
import features.SubscriptionFeature;
import java.util.Scanner;

public class SubscriptionMenu {

    private final FeatureFactory factory;

    public SubscriptionMenu() {
        factory = new BillwiseFeatureFactory();
    }

    public void display(Scanner sc) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== SUBSCRIPTION MANAGEMENT =====");
            System.out.println("1. Add Subscription");
            System.out.println("2. Update Subscription");
            System.out.println("3. View All Subscriptions");
            System.out.println("4. Delete Subscription");
            System.out.println("5. Search Subscription");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                if (choice >= 1 && choice <= 5) {

                    SubscriptionFeature feature =
                            factory.createFeature(choice);

                    feature.execute(sc);

                } else if (choice != 0) {
                    System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }
}