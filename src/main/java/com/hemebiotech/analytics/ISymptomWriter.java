package com.hemebiotech.analytics;

import java.util.Map;

/**
 * All about writing data regarding symptoms
 */
public interface ISymptomWriter {

   void printSymptomOccurrences(Map<String, Long> occurrences);
}
