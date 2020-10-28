package com.hemebiotech.analytics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Implementation class related to writing symptoms statistics to a file
 *
 */
public class WriteSymptomStatistics implements ISymptomWriter{

    private String filename;

    public WriteSymptomStatistics(String filename) {
        this.filename = filename;
    }

    /**
     * @param occurrences write plain key-value pairs into a file
     */
    @Override
    public void printSymptomOccurrences(Map<String, Long> occurrences) {
        try {
            Files.write(Path.of(filename), () -> occurrences.entrySet().stream()
                    .<CharSequence>map(e -> e.getKey() + " " + e.getValue())
                    .iterator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
