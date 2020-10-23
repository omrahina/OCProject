package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 *
 *
 */
public class WriteSymptomStatistics implements ISymptomWriter{

    private static final String DATA_SEPARATOR = " ==> ";
    private static final String RESULT_FILE = "result.out";

    @Override
    public void printSymptomOccurrences(Map<String, Long> occurrences) {
        try {
            Files.write(Path.of(RESULT_FILE), () -> occurrences.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + DATA_SEPARATOR + e.getValue())
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
