package com.tiket.model;

public abstract class Ticket {

    protected String kode;
    protected Customer customer;
    protected Train train;
    protected Seat seat;

    public Ticket(String kode, Customer customer, Train train, Seat seat) {
        this.kode = kode;
        this.customer = customer;
        this.train = train;
        this.seat = seat;
    }

    public abstract double hitungHarga();

    public void printInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Customer: " + customer.getNama());
        System.out.println("Kereta: " + train.getNamaKereta());
    }
}