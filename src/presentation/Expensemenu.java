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

                int featureChoice = 0;

                switch (choice) {
                    case 1:
                        featureChoice = 6;
                        break;

                    case 2:
                        featureChoice = 7;
                        break;

                    case 3:
                        featureChoice = 8;
                        break;

                    case 0:
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

                if (featureChoice != 0) {

                    SubscriptionFeature feature =
                            factory.createFeature(featureChoice);

                    feature.execute(sc);
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