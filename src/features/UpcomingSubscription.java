package features;

import java.time.LocalDate;
import java.util.Scanner;
import model.Subscription;
import model.SubscriptionArray;

public class UpcomingSubscription extends SubscriptionFeature {

    @Override
    public void execute(Scanner sc) {

        System.out.println("\n===== UPCOMING SUBSCRIPTIONS =====");

        SubscriptionArray subscriptions =
        service.getSubscriptionsAsArray();

        int subscriptionLength = subscriptions.getLength();

        Subscription[] upcoming =
                new Subscription[subscriptionLength];

        int count = 0;

        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusDays(7);

        for (int i = 0; i < subscriptions.getLength(); i++) {

            Subscription subscription = subscriptions.getSubscription(i);

            LocalDate paymentDate =
                    subscription.getNextPaymentDate();

            if (!paymentDate.isBefore(today)
                    && !paymentDate.isAfter(nextWeek)) {

                upcoming[count] = subscription;
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No upcoming subscriptions within 7 days.");
            return;
        }

        for (int i = 0; i < count; i++) {

            Subscription subscription = upcoming[i];

            System.out.println("-----------------------------");
            System.out.println("App: " + subscription.getAppName());
            System.out.println("Payment Date: " +
                    subscription.getNextPaymentDate());
            System.out.println("Days Remaining: " +
                    java.time.temporal.ChronoUnit.DAYS.between(
                            today, subscription.getNextPaymentDate()));
        }

        System.out.print("\033[H\033[2J");
    }
}