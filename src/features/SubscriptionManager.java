package features;

import java.util.ArrayList;
import model.Subscription;

public class SubscriptionManager {

    ArrayList<Subscription> subscriptions = new ArrayList<>();

    public void addSubscription(Subscription s) {

        subscriptions.add(s);

        System.out.println("Subscription saved!");
    }
}