package com.tiket.model;

public class Seat {
    private int nomor;
    private boolean tersedia;

    public Seat(int nomor) {
        this.nomor = nomor;
        this.tersedia = true;
    }

    public void booking() {
        tersedia = false;
    }

    public boolean isTersedia() {
        return tersedia;
    }
}