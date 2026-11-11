package features;

import java.util.Scanner;
import service.SubscriptionService;

public abstract class SubscriptionFeature {

    protected SubscriptionService service;

    public SubscriptionFeature() {
        service = new SubscriptionService();
    }

    public abstract void execute(Scanner sc);

    
}