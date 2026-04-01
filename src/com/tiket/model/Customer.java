package com.tiket.model;

public class Customer {
    private String nama;
    private String nik;

    public Customer(String nama, String nik) {
        this.nama = nama;
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public String getNik() {
        return nik;
    }
}