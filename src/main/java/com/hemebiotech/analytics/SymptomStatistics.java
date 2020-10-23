package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Implementation class
 */
public class SymptomStatistics implements ISymptomOperation {
    /**
     * @param symptoms
     * @return a map containing all symptoms paired with their frequency
     */
    @Override
    public Map<String, Long> symptomCounter(List<String> symptoms) {
        return symptoms.stream()
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()));
    }

    /**
     * @param symptoms
     * @param keyword
     * @return a map containing only symptoms that match a certain
     * keyword along with their occurrence
     */
    public Map<String, Long> symptomCounter(List<String> symptoms, String keyword){
        return symptoms.stream().filter(e -> e.contains(keyword))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }
    // TODO the equals method, new methodName or alter interface? ask Joffrey
}
