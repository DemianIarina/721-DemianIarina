package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.company.Repository.schreibenInDatei;

public class Controller {
    public static void sortNachAnzahlMitarbeiter(List<Kunde> kunden){
        List<Kunde> sortierteKunden = kunden.stream()
                .sorted(Comparator.comparing(Kunde::getAnzahlMitarbeiter)
                        .reversed())
                .collect(Collectors.toList());
        schreibenInDatei(sortierteKunden, "src/com/company/kundensortiert.txt");
    }
}
