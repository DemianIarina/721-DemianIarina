package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.Repository.lesenKundenAusDatei;
import static com.company.Repository.schreibenInDatei;

public class Main {

    public static void main(String[] args) {
        List<Kunde> kunden;
        try {
            kunden=lesenKundenAusDatei("src/com/company/kundendaten.txt");
            kunden.forEach(System.out::println);

            schreibenInDatei(kunden, "src/com/company/kundendatenumges.txt");



        } catch (IOException e) {
            System.out.println("Error occured while working with file");
        }
    }
}
