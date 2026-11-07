package features;

import java.util.Scanner;

public abstract class SubscriptionFeature {

    protected SubscriptionManager manager;
    protected Scanner sc;

    public SubscriptionFeature(
            SubscriptionManager manager, Scanner sc) {

        this.manager = manager;
        this.sc = sc;
    }

    public abstract void execute();

}
