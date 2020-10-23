package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]){

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        SymptomStatistics symptomStatistics = new SymptomStatistics();
        List<String> symptoms = reader.GetSymptoms();
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);
        System.out.println("test " + counts.get("insomnia") );
    }
}
