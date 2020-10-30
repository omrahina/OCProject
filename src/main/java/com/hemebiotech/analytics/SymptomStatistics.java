package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Implementation class
 */
public class SymptomStatistics implements ISymptomOperation {

    @Override
    public Map<String, Long> symptomCounter(List<String> symptoms) {
        return symptoms.stream()
                .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()));
    }

}
