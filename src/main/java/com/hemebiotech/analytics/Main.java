package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Entry point of the application
 */
public class Main {

    public static void main(String[] args){

        Configuration configuration = new Configuration();

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(configuration.getSymptomsFile());
        WriteSymptomStatistics writer = new WriteSymptomStatistics(configuration.getResultsFile());
        SymptomStatistics symptomStatistics = new SymptomStatistics();

        List<String> symptoms = reader.getSymptoms();
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);

        System.out.println("Printing results into "+configuration.getResultsFile()+" ...");
        writer.printSymptomOccurrences(counts);
    }
}
