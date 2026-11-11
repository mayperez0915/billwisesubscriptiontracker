
package model;

import java.time.LocalDate;

public class Subscription {

    private int id;
    private String appName;
    private String planName;
    private double price;
    private String billingCycle;
    private LocalDate nextPaymentDate;

    public Subscription(int id, String appName, String planName,
            double price, String billingCycle, LocalDate nextPaymentDate) {

        this.id = id;
        this.appName = appName;
        this.planName = planName;
        this.price = price;
        this.billingCycle = billingCycle;
        this.nextPaymentDate = nextPaymentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than zero.");
        }
        this.id = id;
    }

    public boolean isNameValid(String value) {
    return value != null && !value.trim().isEmpty();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        if (isNameValid(appName)) {
            throw new IllegalArgumentException("App name cannot be empty.");
        }
        this.appName = appName;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        if (isNameValid(planName)) {
            throw new IllegalArgumentException("Plan name cannot be empty.");
        }
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        if (billingCycle == null ||
            (!billingCycle.equalsIgnoreCase("Monthly") &&
             !billingCycle.equalsIgnoreCase("Annual"))) {

            throw new IllegalArgumentException(
                "Billing cycle must be Monthly or Annual.");
        }

        this.billingCycle = billingCycle.substring(0, 1).toUpperCase()
                + billingCycle.substring(1).toLowerCase();
    }

    public LocalDate getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(LocalDate nextPaymentDate) {
        if (nextPaymentDate == null) {
            throw new IllegalArgumentException("Payment date cannot be empty.");
        }
        this.nextPaymentDate = nextPaymentDate;
    }

    public boolean matches(String name) {
        return appName.toLowerCase().contains(name.toLowerCase());
    }

    public boolean matches(int subscriptionId) {
        return id == subscriptionId;
    }
}
