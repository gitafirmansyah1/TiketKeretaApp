package com.tiket.service;

import com.tiket.model.Train;
import java.util.HashMap;
import java.util.Map;

public class TrainService {

    private Map<String, Train> daftarKereta = new HashMap<>();

    public TrainService() {
        daftarKereta.put("1", new Train("Argo Bromo", "Surabaya"));
        daftarKereta.put("2", new Train("Taksaka", "Yogyakarta"));
        daftarKereta.put("3", new Train("Matarmaja", "Malang"));
    }

    public Train getTrain(String kode) {
        return daftarKereta.get(kode);
    }

    public void showAllTrain() {
        for (String kode : daftarKereta.keySet()) {
            Train t = daftarKereta.get(kode);
            System.out.println(kode + " - " + t.getNamaKereta() + " (" + t.getTujuan() + ")");
        }
    }
}