package com.railway.payment;

public class CardPayment implements Payable {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount + " completed using Card.");
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "Refund of ₹" + amount + " processed to Card.");
    }
}