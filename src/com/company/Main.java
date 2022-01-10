package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.Repository.lesenKundenAusDatei;

public class Main {

    public static void main(String[] args) {
        List<Kunde> kunden;
        try {
            kunden=lesenKundenAusDatei("src/com/company/kundendaten.txt");
            kunden.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
