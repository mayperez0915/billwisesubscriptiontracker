
package model;

import java.time.LocalDate;

public class Subscription {

    private int id;
    private String appName;
    private String planName;
    private double price;
    private String billingCycle;
    private LocalDate nextPaymentDate;

    public Subscription(int id, String appName,
            String planName, double price,
            String billingCycle, LocalDate nextPaymentDate) {

        this.id = id;
        this.appName = appName;
        this.planName = planName;
        setPrice(price);
        this.billingCycle = billingCycle;
        this.nextPaymentDate = nextPaymentDate;
    }

    public int getId() {
        return id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if (price < 0) {
            throw new IllegalArgumentException(
                "Price cannot be negative."
            );
        }

        this.price = price;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }
}
