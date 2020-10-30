package com.hemebiotech.analytics;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * Properties handler
 */
public class Configuration {

    private String symptomsFile;
    private String resultsFile;

    public Configuration() {
        this.symptomsFile = getProperty("application.properties", "symptomsFile");
        this.resultsFile = getProperty("application.properties", "resultsFile");
    }

    /**
     * This method looks for a value throughout a properties file
     * @param propertiesFileName a file containing parameters as key-value pairs
     * @param key the property needed
     * @return the value corresponding to a specified key or throw an exception if the key isn't in the properties
     */
    public String getProperty(String propertiesFileName, String key){
        ResourceHandler resourceHandler = new ResourceHandler();

        String value = "";
        Properties properties = new Properties();
        try {
            properties.load(resourceHandler.getFileFromResourcesAsStream(propertiesFileName));
            value = properties.getProperty(key);
            if (value == null){
                throw new InvalidParameterException("Missing value for key " +key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public String getSymptomsFile() {
        return symptomsFile;
    }

    public void setSymptomsFile(String symptomsFile) {
        this.symptomsFile = symptomsFile;
    }

    public String getResultsFile() {
        return resultsFile;
    }

    public void setResultsFile(String resultsFile) {
        this.resultsFile = resultsFile;
    }
}
