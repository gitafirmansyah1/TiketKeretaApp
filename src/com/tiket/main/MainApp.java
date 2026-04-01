package com.tiket.main;

import com.tiket.model.*;
import com.tiket.service.*;

public class MainApp {

    public static void main(String[] args) {

        Customer c = new Customer("Gita", "12345");
        Train t = new Train("Argo Bromo", "Surabaya");
        Seat s = new Seat(1);

        Ticket tiket;

        tiket = new EconomyTicket("T001", c, t, s);
        System.out.println("Harga Economy: " + tiket.hitungHarga());

        tiket = new BusinessTicket("T002", c, t, s);
        System.out.println("Harga Business: " + tiket.hitungHarga());

        Payment bayar = new EWalletPayment();
        bayar.bayar(tiket.hitungHarga());
    }
}