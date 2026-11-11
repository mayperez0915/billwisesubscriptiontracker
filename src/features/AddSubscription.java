package features;

import java.time.LocalDate;
import java.util.Scanner;
import model.Subscription;
import utility.CurrencyFormatter;
import utility.DateHelper;
import utility.InputValidator;
import utility.ScreenHelper;

public class AddSubscription extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== ADD SUBSCRIPTION =====");

        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());

            boolean isInValid = !InputValidator.isValid(id) || service.isIdExists(id);
            String invalidText = !InputValidator.isValid(id) ? "Invalid ID" : service.isIdExists(id) ? "ID already exists" : "";

            if (isInValid) {
                System.out.println(invalidText);
            }

            

            System.out.print("Enter App Name: ");
            String appName = sc.nextLine();

            System.out.print("Enter Plan Name: ");
            String planName = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            if (!InputValidator.isValid(price)) {
                System.out.println("Invalid price.");
                return;
            }

            System.out.print("Enter Billing Cycle (Monthly/Annual): ");
            String billingCycle = sc.nextLine();

            System.out.print("Enter Next Payment Date (YYYY-MM-DD): ");
            LocalDate date = DateHelper.parseDate(sc.nextLine());

            Subscription subscription = new Subscription(
                    id, appName, planName, price, billingCycle, date);

            service.addSubscription(subscription);

            System.out.println("\nSubscription added successfully!");
            System.out.println("Price: " + CurrencyFormatter.format(price));

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        ScreenHelper.pauseAndClear(sc);
    }
}