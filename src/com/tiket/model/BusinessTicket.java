package com.tiket.model;

public class BusinessTicket extends Ticket {

    public BusinessTicket(String kode, Customer c, Train t, Seat s) {
        super(kode, c, t, s);
    }

    @Override
    public double hitungHarga() {
        return 120000;
    }
}