package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 */
public class SymptomStatistics implements ISymptomOperation {
    /**
     * @param symptoms 
     * @return
     */
    @Override
    public Map<String, Long> symptomCounter(List<String> symptoms) {
        return symptoms.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public Map<String, Long> symptomCounter(List<String> symptoms, String keyword){
        return symptoms.stream().filter(e -> e.contains(keyword))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
    // TODO the equals method, new methodName or alter interface? ask Joffrey
}
