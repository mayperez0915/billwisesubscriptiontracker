package service;

import java.util.ArrayList;
import model.Subscription;
import model.SubscriptionArray;
import repository.SubscriptionRepository;

public class SubscriptionService {

    private SubscriptionRepository repository;

    public SubscriptionService() {
        repository = SubscriptionRepository.getInstance();
    }

    public void addSubscription(Subscription subscription) {
        if (repository.isIdExists(subscription.getId())) {
            throw new IllegalArgumentException("ID already exists.");
        }

        repository.add(subscription);
    }

    public ArrayList<Subscription> getAllSubscriptions() {
        return repository.getAll();
    }

    public Subscription findSubscription(int id) {
        return repository.findById(id);
    }

    public boolean deleteSubscription(int id) {
        return repository.delete(id);
    }

    public boolean isIdExists(int id) {
        return repository.isIdExists(id);
    }

    public int getTotalSubscriptions() {
        return repository.getTotal();
    }

    public SubscriptionArray getSubscriptionsAsArray() {
        return repository.getAsArray();
    }
}