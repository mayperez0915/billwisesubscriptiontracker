package features;

import model.Subscription;
import utility.DateHelper;
import utility.CurrencyFormatter;
import utility.InputValidator;
import java.time.LocalDate;
import java.util.Scanner;

public class AddSubscription extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== ADD SUBSCRIPTION =====");

        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());

            if (!InputValidator.isValidId(id)) {
                System.out.println("Invalid ID.");
                return;
            }

            if (service.isIdExists(id)) {
                System.out.println("ID already exists.");
                return;
            }

            System.out.print("Enter App Name: ");
            String appName = sc.nextLine();

            System.out.print("Enter Plan Name: ");
            String planName = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(sc.nextLine());

            if (!InputValidator.isValidPrice(price)) {
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
            System.out.print("\033[H\033[2J");

            System.out.println("--------------------------------------");
            System.out.println("Subscription ID : " + id);
            System.out.println("App Name : " + appName);
            System.out.println("Plan Name : " + planName);
            System.out.println("Price : " + price);
            System.out.println("Billing Cycle : " + billingCycle);
            System.out.println("--------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }
}