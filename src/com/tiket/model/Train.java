package com.tiket.model;

public class Train {
    private String namaKereta;
    private String tujuan;

    public Train(String namaKereta, String tujuan) {
        this.namaKereta = namaKereta;
        this.tujuan = tujuan;
    }

    public String getNamaKereta() {
        return namaKereta;
    }

    public String getTujuan() {
        return tujuan;
    }
}