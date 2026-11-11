package features;

import java.util.ArrayList;
import java.util.Scanner;
import model.Subscription;
import utility.CurrencyFormatter;

public class MonthlyExpense extends SubscriptionFeature{

    @Override  

    public void execute (Scanner sc){
         System.out.println("\n===== MONTHLY EXPENSES =====");

        ArrayList<Subscription> list =
                service.getAllSubscriptions();

        double total = 0;

        for (Subscription subscription : list){
            if (subscription.getBillingCycle().equalsIgnoreCase("Monthly")) {
                total += subscription.getPrice();
            } else {
                total += subscription.getPrice() / 12;
            }
        }
        System.out.println("Total Monthly Expenses: " +
                CurrencyFormatter.format(total));
        
        System.out.print("\033[H\033[2J");
    }
}