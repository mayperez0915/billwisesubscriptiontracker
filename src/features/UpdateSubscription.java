
package features;

import model.Subscription;
import model.BillingCycle;
import utility.InputHelper;
import java.time.LocalDate;
import java.util.Scanner;

public class UpdateSubscription extends SubsriptionFeature {

    public UpdateSubscription(SubscriptionManager manager, Scanner sc) {
        super(manager, sc);
    }

    @Override
    public void execute() {

        System.out.println("\n========== UPDATE SUBSCRIPTION ==========");

        int id = InputHelper.getInt(sc, "Enter Subscription ID: ");

        Subscription s = manager.findSubscription(id);

        if (s == null) {
            System.out.println("Subscription not found!");
            return;
        }

        System.out.println("\n1. App Name");
        System.out.println("2. Plan Name");
        System.out.println("3. Price");
        System.out.println("4. Billing Cycle");
        System.out.println("5. Payment Date");

        int choice = InputHelper.getInt(sc, "Enter choice: ");

        switch (choice) {

            case 1:
                s.setAppName(
                    InputHelper.getString(sc, "New App Name: ")
                );
                break;

            case 2:
                s.setPlanName(
                    InputHelper.getString(sc, "New Plan Name: ")
                );
                break;

            case 3:
                s.setPrice(
                    InputHelper.getDouble(sc, "New Price: PHP ")
                );
                break;

            case 4:

                while (true) {
                    try {
                        String input = InputHelper.getString(
                            sc, "New Billing Cycle: "
                        );

                        s.setBillingCycle(
                            BillingCycle.valueOf(
                                input.trim().toUpperCase()
                            )
                        );

                        break;

                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid billing cycle!");
                    }
                }
                break;

            case 5:

                while (true) {
                    try {
                        LocalDate date = LocalDate.parse(
                            InputHelper.getString(
                                sc, "New Payment Date (YYYY-MM-DD): "
                            )
                        );

                        s.setNextPaymentDate(date);
                        break;

                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Invalid date format!");
                    }
                }
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Subscription updated successfully!");
    }
}
