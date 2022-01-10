package com.company;

public enum Unternehmensgrosse {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String label;

    private Unternehmensgrosse(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
