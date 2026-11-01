package com.railway.payment;

public interface Payable {

    void pay(double amount);

    void refund(double amount);
}