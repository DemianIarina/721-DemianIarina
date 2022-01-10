package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repository {
    public static List<Kunde> lesenKundenAusDatei(String dateiName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dateiName));

        String line;

        int id = 0;
        String unternehmensname = null;
        Unternehmensgrosse unternehmensgrosse = null;
        int anzahlMitarbeiter = 0;
        int einkommenKunde = 0;
        String ort = null;
        Kunde geleseneKunde;

        List<Kunde> geleseneKunden = new ArrayList<>();  //eine leere Liste fur die gelesene Kunden erstellen

        int poz;

        while((line = br.readLine()) != null) {
            poz = 1;
            for (String word : line.split(",")) {
                switch (poz) {
                    case 1:
                        id = Integer.parseInt(word);
                        break;
                    case 2:
                        unternehmensname = word;
                        break;
                    case 3:
                        Unternehmensgrosse[] alleGrosse = Unternehmensgrosse.values();
                        for(Unternehmensgrosse moglichGrosse : alleGrosse){
                            if(Objects.equals(moglichGrosse.getLabel(), word)){   //finden die equivalenten Enum fur den text in den Label
                                unternehmensgrosse = moglichGrosse;
                            }
                        }
                        break;
                    case 4:
                        anzahlMitarbeiter = Integer.parseInt(word);
                        break;
                    case 5:
                        einkommenKunde = Integer.parseInt(word);
                        break;
                    case 6:
                        ort = word;
                        break;
                }
                poz++;
            }
            geleseneKunde = new Kunde(id, unternehmensname, unternehmensgrosse,anzahlMitarbeiter,einkommenKunde,ort);
            geleseneKunden.add(geleseneKunde);
        }
        return geleseneKunden;
    }

    public static void schreibenInDatei(List<Kunde> kundeZuSchreiben, String dateiname){
        try {
            File myObj = new File(dateiname);

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

                FileWriter myWriter = new FileWriter(dateiname);
                for(Kunde kunde : kundeZuSchreiben){
                    myWriter.write(kunde.getId() + "," + kunde.getUnternehmensname() + ","
                            + kunde.getUnternehmensgröße().getLabel() + "," + kunde.getAnzahlMitarbeiter() + "," + kunde.getEinkommenKunde() + ","+kunde.getOrt() +"\n");
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while using the files");
            e.printStackTrace();
        }
    }

}
