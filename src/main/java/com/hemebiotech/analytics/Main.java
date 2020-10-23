package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
        SymptomStatistics symptomStatistics = new SymptomStatistics();
        WriteSymptomStatistics writer = new WriteSymptomStatistics();
        List<String> symptoms = reader.GetSymptoms();
        //Case print all symptoms
        //Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);
        //Print symptoms containing keyword
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms, "pressure");
        System.out.println("Printing the result... ");
        writer.printSymptomOccurrences(counts);
    }
}
