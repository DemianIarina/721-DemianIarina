package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static com.company.Repository.schreibenInDatei;

public class Controller {
    public static void sortNachAnzahlMitarbeiter(List<Kunde> kunden){
        List<Kunde> sortierteKunden = kunden.stream()
                .sorted(Comparator.comparing(Kunde::getAnzahlMitarbeiter)
                        .reversed())                                          //in fallender Reihenfolge
                .collect(Collectors.toList());                                 //eine neue List erstellen

        schreibenInDatei(sortierteKunden, "src/com/company/kundensortiert.txt");       //in die Datei speichern
    }

    public static void topOrtNachEinkommen(List<Kunde> kunden){
        List<Pair> list = new ArrayList<>();

        for(Kunde kunde : kunden){

            if( list.stream().anyMatch(obj -> obj.getOrt().equals(kunde.getOrt()))){
                Pair pairToUpdate = list.stream()
                        .filter(obj -> Objects.equals(obj.getOrt(), kunde.getOrt()))
                        .findFirst()
                        .orElseThrow();
                pairToUpdate.setEinkommen(pairToUpdate.getEinkommen()+kunde.getEinkommenKunde());
            }
            else{
                list.add(new Pair(kunde.getOrt(),kunde.getEinkommenKunde()));
            }
        }
        List<Pair> sortedList = list.stream()
                .sorted(Comparator.comparing(Pair::getEinkommen).reversed())
                .collect(Collectors.toList());

        sortedList.forEach(System.out::println);
    }
}
