package com.railway.model;

public class Payment {

    private int paymentId;
    private double amount;
    private String status;

    public Payment(int paymentId, double amount) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.status = "PENDING";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayPayment() {

        System.out.println("\n----- PAYMENT DETAILS -----");
        System.out.println("Payment ID : " + paymentId);
        System.out.println("Amount     : ₹" + amount);
        System.out.println("Status     : " + status);
    }
}