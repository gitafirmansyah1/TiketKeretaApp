package com.tiket.service;

public class EWalletPayment implements Payment {

    @Override
    public void bayar(double jumlah) {
        System.out.println("Bayar via E-Wallet: " + jumlah);
    }
}