package com.tiket.main;

import com.tiket.model.*;
import com.tiket.service.*;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TrainService trainService = new TrainService();

        System.out.println("=== DAFTAR KERETA ===");
        trainService.showAllTrain();

        System.out.print("Pilih kode kereta: ");
        String kode = input.nextLine().toUpperCase();

        Train selectedTrain = trainService.getTrain(kode);

        if (selectedTrain == null) {
            System.out.println("Kereta tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        Customer customer = new Customer(nama, "12345");

        System.out.print("Pilih jenis (1 = Ekonomi, 2 = Bisnis): ");
        int jenis = input.nextInt();

        System.out.print("Jumlah tiket: ");
        int jumlah = input.nextInt();

        Seat seat = new Seat(1);

        Ticket tiket;

        if (jenis == 1) {
            tiket = new EconomyTicket("T001", customer, selectedTrain, seat);
        } else if (jenis == 2) {
            tiket = new BusinessTicket("T002", customer, selectedTrain, seat);
        } else {
            System.out.println("Jenis tidak valid!");
            return;
        }

        double total = tiket.hitungHarga() * jumlah;

        System.out.println("\n=== DETAIL PEMESANAN ===");
        System.out.println("Nama: " + nama);
        System.out.println("Kereta: " + selectedTrain.getNamaKereta());
        System.out.println("Jenis: " + (jenis == 1 ? "Ekonomi" : "Bisnis"));
        System.out.println("Jumlah tiket: " + jumlah);
        System.out.println("Total bayar: " + total);


        Payment bayar = new CashPayment();
        bayar.bayar(total);
    }
}