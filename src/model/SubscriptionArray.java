package model;

public class SubscriptionArray {
    
    private Subscription[] subscriptions;

    public SubscriptionArray() {
        subscriptions = new Subscription[100];
    }

    public SubscriptionArray(Subscription[] subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Subscription[] getSubscriptions() {
        return subscriptions.clone();
    }

    public Subscription getSubscription(int index) {
        return subscriptions[index];
    }

    public int getLength() {
        return subscriptions.length;
    }
}
