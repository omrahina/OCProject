package com.hemebiotech.analytics;

import java.util.Map;

/**
 *
 */
public interface ISymptomWriter {

   void printSymptomOccurrences(Map<String, Long> occurrences);
}
