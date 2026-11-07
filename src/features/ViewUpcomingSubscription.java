package features;

import model.Subscription;
import model.SubscriptionArray;
import java.time.LocalDate;
import java.util.Scanner;

public class ViewUpcomingSubscription extends SubscriptionFeature {
    @Override

    public void execute (Scanner sc){
        System.out.println("\n===== UPCOMING SUBSCRIPTIONS =====");

        SubscriptionArray array =
            service.getSubscriptionsAsArray();

        Subscription [] upcoming =
            new Subscription[array.getLength()];

        int count = 0;

        LocalDate today = LocalDate.now();
        LocalDate nextweek = today.plusDays(7);

        for (int i = 0; i < array.getLength(); i++ ){

            Subscription subscription = array.getSubscription(i);

            LocalDate paymenDate =
                subscription.getNextPaymentDate();

                if (!paymenDate.isBefore(today) &&
                    !paymentDate.isAfter(nextWeek)){

                        upcoming[count] = subscription;
                        count++;
                }
        }
        if (count == 0){
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
    }
}
