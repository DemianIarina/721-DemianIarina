package com.company;

public class Pair {
    private String ort;
    private int einkommen;

    public Pair(String ort, int einkommen) {
        this.ort = ort;
        this.einkommen = einkommen;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getEinkommen() {
        return einkommen;
    }

    public void setEinkommen(int einkommen) {
        this.einkommen = einkommen;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "ort='" + ort + '\'' +
                ", einkommen=" + einkommen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return ort == pair.ort && einkommen == pair.einkommen;
    }
}
