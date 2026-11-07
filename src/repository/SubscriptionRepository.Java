package repository;

import model.Subscription;
import model.SubscrptionArry;
import java.util.Arraylist;

public class SubscriptionRepository{
     private static final SubscriptionRepository instance =
            new SubscriptionRepository();

    private ArrayList<Subscription> subscriptions;

    private SubscriptionRepository() {
        subscriptions = new ArrayList<>();
    }

    public static SubscriptionRepository getInstance() {
        return instance;
    }

    public void add(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public ArrayList<Subscription> getAll() {
        return new ArrayList<>(subscriptions);
    }

    public Subscription findById(int id) {

        for (Subscription subscription : subscriptions) {

            if (subscription.getId() == id) {
                return subscription;
            }
        }

        return null;
    }

    public boolean delete(int id) {

        Subscription subscription = findById(id);

        if (subscription != null) {
            subscriptions.remove(subscription);
            return true;
        }

        return false;
    }

    public boolean isIdExists(int id) {
        return findById(id) != null;
    }

    public int getTotal() {
        return subscriptions.size();
    }

    public SubscriptionArray getAsArray() {

        Subscription[] array =
                subscriptions.toArray(new Subscription[0]);

        return new SubscriptionArray(array);
    }
}