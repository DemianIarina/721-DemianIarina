package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static com.company.Repository.schreibenInDatei;
import static com.company.Repository.schreibenTopInDatei;

/**
 * Alle operationen die auf eine liste von Kunden gemacht sein konnen
 */
public class Controller {
    /**
     * Sortieren alle Kunden in eine liste nach Anzahl der Mitarbeiter in fallende reihenfolge
     * Es speichert die daten in eine Datei
     * @param kunden die Liste mit alle Kunden
     */
    public static void sortNachAnzahlMitarbeiter(List<Kunde> kunden){
        List<Kunde> sortierteKunden = kunden.stream()
                .sorted(Comparator.comparing(Kunde::getAnzahlMitarbeiter)
                        .reversed())                                          //in fallender Reihenfolge
                .collect(Collectors.toList());                                 //eine neue List erstellen

        schreibenInDatei(sortierteKunden, "src/com/company/kundensortiert.txt");       //in die Datei speichern
    }

    /**
     * macht einem Top der Orte nach Einkommen und speichert sie in eine datei
     * @param kunden die Liste mit alle Kunden
     */
    public static void topOrtNachEinkommen(List<Kunde> kunden){
        List<Pair> list = new ArrayList<>();

        for(Kunde kunde : kunden){

            if( list.stream().anyMatch(obj -> obj.getOrt().equals(kunde.getOrt()))){    //ob der Pair schon existiert
                Pair pairToUpdate = list.stream()
                        .filter(obj -> Objects.equals(obj.getOrt(), kunde.getOrt()))
                        .findFirst()
                        .orElseThrow();
                pairToUpdate.setEinkommen(pairToUpdate.getEinkommen()+kunde.getEinkommenKunde());   //wird der Einkmmen vergrossert
            }
            else{
                list.add(new Pair(kunde.getOrt(),kunde.getEinkommenKunde()));
            }
        }
        List<Pair> sortedList = list.stream()
                .sorted(Comparator.comparing(Pair::getEinkommen).reversed())    //in fallende reihenfolge sortieren
                .collect(Collectors.toList());

        schreibenTopInDatei(sortedList, "src/com/company/statistik.txt");
    }
}
