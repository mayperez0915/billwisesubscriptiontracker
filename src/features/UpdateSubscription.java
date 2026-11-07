package features;

import java.time.LocalDate;
import java.util.Scanner;
import model.Subscription;
import utility.DateHelper;

public class UpdateSubscription extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== UPDATE SUBSCRIPTION =====");

        try {
            System.out.print("Enter Subscription ID: ");
            int id = Integer.parseInt(sc.nextLine());

            Subscription subscription = service.findSubscription(id);

            if (subscription == null) {
                System.out.println("Subscription not found.");
                return;
            }

            System.out.println("1. App Name");
            System.out.println("2. Plan Name");
            System.out.println("3. Price");
            System.out.println("4. Billing Cycle");
            System.out.println("5. Next Payment Date");

            System.out.print("Choose what to update: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Enter New App Name: ");
                    subscription.setAppName(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter New Plan Name: ");
                    subscription.setPlanName(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter New Price: ");
                    subscription.setPrice(
                            Double.parseDouble(sc.nextLine()));
                    break;

                case 4:
                    System.out.print("Enter New Billing Cycle: ");
                    subscription.setBillingCycle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter New Date (YYYY-MM-DD): ");
                    LocalDate date = DateHelper.parseDate(sc.nextLine());
                    subscription.setNextPaymentDate(date);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            System.out.println("Subscription updated successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}