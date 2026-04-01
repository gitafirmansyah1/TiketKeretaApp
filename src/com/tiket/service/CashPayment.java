package com.tiket.service;

public class CashPayment implements Payment {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Bayar cash: " + jumlah);
    }
}