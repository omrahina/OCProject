package com.hemebiotech.analytics;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SymptomStatisticsTest {

    SymptomStatistics symptomStatistics = new SymptomStatistics();

    @Test
    public void symptomCounter_ok(){
        List<String> symptoms = Arrays.asList("headache", "insomnia", "nausea", "insomnia");
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms);
        assertTrue(counts.size() == 3);
        assertEquals(2, counts.get("insomnia"));
    }

    @Test
    public void symptomContainingCounter_ok(){
        List<String> symptoms = Arrays.asList("headache", "constricted pupils", "pupils", "constricted pupils");
        Map<String, Long> counts = symptomStatistics.symptomCounter(symptoms, "pupils");
        assertTrue(counts.size() == 2);
        assertTrue(!counts.containsKey("headache"));
    }
}
