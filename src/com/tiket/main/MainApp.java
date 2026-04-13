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

        Train selectedTrain = null;
        while (selectedTrain == null) {
            try {
                System.out.print("Pilih kode kereta: ");
                String kode = input.nextLine().toUpperCase();

                selectedTrain = trainService.getTrain(kode);

                if (selectedTrain == null) {
                    throw new Exception("Kereta tidak ditemukan!");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String nama = "";
        while (true) {
            try {
                System.out.print("Masukkan nama: ");
                nama = input.nextLine();

                if (!nama.matches("[a-zA-Z ]+")) {
                    throw new Exception("Nu bener we!!");
                }

                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Customer customer = new Customer(nama, "12345");

        int jenis = 0;
        while (true) {
            try {
                System.out.print("Pilih jenis (1 = Ekonomi, 2 = Bisnis): ");
                jenis = input.nextInt();

                if (jenis != 1 && jenis != 2) {
                    throw new Exception("Pilihan hanya 1 atau 2!");
                }

                break;

            } catch (Exception e) {
                System.out.println("Input harus angka 1 atau 2!");
                input.nextLine(); 
            }
        }


        int jumlah = 0;
        while (true) {
            try {
                System.out.print("Jumlah tiket: ");
                jumlah = input.nextInt();

                if (jumlah <= 0) {
                    throw new Exception("Jumlah tiket harus lebih dari 0!");
                }

                break;

            } catch (Exception e) {
                System.out.println("Input harus angka yang valid!");
                input.nextLine(); // bersihkan buffer
            }
        }

        Seat seat = new Seat(1);

        Ticket tiket;

        if (jenis == 1) {
            tiket = new EconomyTicket("T001", customer, selectedTrain, seat);
        } else {
            tiket = new BusinessTicket("T002", customer, selectedTrain, seat);
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