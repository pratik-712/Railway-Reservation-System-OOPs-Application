package com.railway.service;

import com.railway.model.Payment;
import com.railway.payment.Payable;

public class PaymentService {

    public void processPayment(
            Payment payment,
            Payable paymentMethod) {

        paymentMethod.pay(payment.getAmount());

        payment.setStatus("SUCCESS");

        payment.displayPayment();
    }

    public void processRefund(
            Payment payment,
            Payable paymentMethod) {

        paymentMethod.refund(payment.getAmount());

        payment.setStatus("REFUNDED");

        payment.displayPayment();
    }
}