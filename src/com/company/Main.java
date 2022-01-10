package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.Controller.sortNachAnzahlMitarbeiter;
import static com.company.Repository.lesenKundenAusDatei;
import static com.company.Repository.schreibenInDatei;

public class Main {

    public static void main(String[] args) {
        List<Kunde> kunden;
        try {
            kunden=lesenKundenAusDatei("src/com/company/kundendaten.txt");
            kunden.forEach(System.out::println);

            sortNachAnzahlMitarbeiter(kunden);



        } catch (IOException e) {
            System.out.println("Error occured while working with file");
        }
    }
}
