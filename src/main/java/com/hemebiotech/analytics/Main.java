package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Mainly used for runtime testing
 */
public class Main {

    public static void main(String[] args){

        String propertiesFileName = "application.properties";
        String symptomsFile = ReadSymptomDataFromFile.getProperty(propertiesFileName, "symptomsFile");
        String resultsFile = ReadSymptomDataFromFile.getProperty(propertiesFileName, "resultsFile");

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFile);
        SymptomStatistics symptomStatistics = new SymptomStatistics();
        WriteSymptomStatistics writer = new WriteSymptomStatistics(resultsFile);

        List<String> symptoms = reader.GetSymptoms();
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);

        System.out.println("Printing results into "+resultsFile+" ...");
        writer.printSymptomOccurrences(counts);
    }
}
