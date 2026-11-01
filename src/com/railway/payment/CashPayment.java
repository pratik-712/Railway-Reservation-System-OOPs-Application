package com.railway.payment;

public class CashPayment implements Payable {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount + " received in Cash.");
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "Cash refund of ₹" + amount + " processed.");
    }
}