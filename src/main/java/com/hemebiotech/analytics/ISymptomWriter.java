package com.hemebiotech.analytics;

import java.util.Map;

/**
 * All about writing data regarding symptoms
 */
public interface ISymptomWriter {

   /**
    * Writes plain key-value pairs into the results file
    * @param occurrences a map containing symptoms as keys and frequencies as values
    */
   void printSymptomOccurrences(Map<String, Long> occurrences);
}
