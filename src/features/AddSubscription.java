
package features;

import java.time.LocalDate;
import java.util.Scanner;
import model.Subscription;

public class AddSubscription {

    public void add(SubscriptionManager manager, Scanner sc) {

        System.out.println("====================== ADD SUBSCRIPTION ===================");

        System.out.print("Enter Subscription ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter App Name: ");
        String appName = sc.nextLine();

        System.out.print("Enter Plan Name: ");
        String planName = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Billing Cycle (Monthly/Annual): ");
        String billingCycle = sc.nextLine();

        System.out.print("Next Payment Date (YYYY-MM-DD): ");
        LocalDate nextPayment = LocalDate.parse(sc.nextLine());

        Subscription s = new Subscription(
            id, appName, planName, price, billingCycle, nextPayment
        );
        System.out.print("\033[H\033[2J");

        manager.addSubscription(s);

        System.out.println("\nSubscription added successfully!");

        System.out.println("--------------------------------------");
        System.out.println("Subscription ID : " + id);
        System.out.println("App Name : " + appName);
        System.out.println("Plan Name : " + planName);
        System.out.println("Price : " + price);
        System.out.println("Billing Cycle : " + billingCycle);
        System.out.println("Next Payment : " + nextPayment);
        System.out.println("--------------------------------------");
    }
}
