package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        SymptomStatistics symptomStatistics = new SymptomStatistics();
        WriteSymptomStatistics writer = new WriteSymptomStatistics();
        List<String> symptoms = reader.GetSymptoms();
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);
        writer.printSymptomOccurrences(counts);
        System.out.println("test " + counts.get("insomnia") );
    }
}
