package com.railway.payment;

public class UpiPayment implements Payable {

    @Override
    public void pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount + " completed using UPI.");
    }

    @Override
    public void refund(double amount) {

        System.out.println(
                "Refund of ₹" + amount + " processed through UPI.");
    }
}