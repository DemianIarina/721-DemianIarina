package com.company;

/**
 * Ein Kunde der ein id, ein name, eine grosse, ein anzahl von mitarbeiter, ein einkomme von Kunden, und ein ort hat
 */
public class Kunde {
    private int id;
    private String unternehmensname;
    private Unternehmensgrosse unternehmensgröße;
    private int anzahlMitarbeiter;
    private int einkommenKunde;
    private String ort;

    public Kunde(int id, String unternehmensname, Unternehmensgrosse unternehmensgröße, int anzahlMitarbeiter, int einkommenKunde, String ort) {
        this.id = id;
        this.unternehmensname = unternehmensname;
        this.unternehmensgröße = unternehmensgröße;
        this.anzahlMitarbeiter = anzahlMitarbeiter;
        this.einkommenKunde = einkommenKunde;
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnternehmensname() {
        return unternehmensname;
    }

    public void setUnternehmensname(String unternehmensname) {
        this.unternehmensname = unternehmensname;
    }

    public Unternehmensgrosse getUnternehmensgröße() {
        return unternehmensgröße;
    }

    public void setUnternehmensgröße(Unternehmensgrosse unternehmensgröße) {
        this.unternehmensgröße = unternehmensgröße;
    }

    public int getAnzahlMitarbeiter() {
        return anzahlMitarbeiter;
    }

    public void setAnzahlMitarbeiter(int anzahlMitarbeiter) {
        this.anzahlMitarbeiter = anzahlMitarbeiter;
    }

    public int getEinkommenKunde() {
        return einkommenKunde;
    }

    public void setEinkommenKunde(int einkommenKunde) {
        this.einkommenKunde = einkommenKunde;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Kunden{" +
                "id=" + id +
                ", unternehmensname='" + unternehmensname + '\'' +
                ", unternehmensgröße=" + unternehmensgröße +
                ", anzahlMitarbeiter=" + anzahlMitarbeiter +
                ", einkommenKunde=" + einkommenKunde +
                ", ort='" + ort + '\'' +
                '}';
    }
}
