package com.tiket.model;

public class EconomyTicket extends Ticket {

    public EconomyTicket(String kode, Customer c, Train t, Seat s) {
        super(kode, c, t, s);
    }

    @Override
    public double hitungHarga() {
        return 50000;
    }
}