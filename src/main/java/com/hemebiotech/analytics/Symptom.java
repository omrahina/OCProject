package com.hemebiotech.analytics;

public class Symptom {

    private String name;
    private int occurrence;

    public Symptom(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }
}
