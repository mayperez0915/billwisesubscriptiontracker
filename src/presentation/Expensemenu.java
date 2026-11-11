
package presentation;

import features.BillwiseFeatureFactory;
import features.FeatureFactory;
import features.SubscriptionFeature;
import java.util.Scanner;

public class Expensemenu {

    private final FeatureFactory factory;

    public Expensemenu() {
        factory = new BillwiseFeatureFactory();
    }

    public void display(Scanner sc) {

        int choice = -1;

        while (choice != 0) {

            System.out.println("\n===== EXPENSE MANAGEMENT =====");
            System.out.println("1. View Upcoming Subscriptions");
            System.out.println("2. Calculate Monthly Expenses");
            System.out.println("3. Calculate Annual Expenses");
            System.out.println("0. Back to Main Menu");

            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                SubscriptionFeature feature = null;

                switch (choice) {

                    case 1:
                        feature = factory.createFeature(6);
                        break;

                    case 2:
                        feature = factory.createFeature(7);
                        break;

                    case 3:
                        feature = factory.createFeature(8);
                        break;

                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                if (feature != null) {

                    feature.execute(sc);

                    System.out.println("\nPress Enter to continue...");
                    sc.nextLine();
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
