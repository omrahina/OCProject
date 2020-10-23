package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface ISymptomOperation {

    Map<String, Long> symptomCounter(List<String> symptoms);
}
