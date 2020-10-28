package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
     * @param propertiesFileName a file containing parameters as key-value pairs
     * @param key the property needed
     * @return the value corresponding to a specified key or throw an exception if the key isn't in the properties
     */
    public static String getProperty(String propertiesFileName, String key){

        String value = "";
        Properties properties = new Properties();
        try {
            properties.load(getFileFromResourcesAsStream(propertiesFileName));
            value = properties.getProperty(key);
            if (value == null){
                throw new InvalidParameterException("Missing value for key " +key);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * @param filename a string that represents a file in the resources folder
     * @return a stream retrieved from the classLoader or throw an exception if the file doesn't exist
     * @throws FileNotFoundException
     */
    public static InputStream getFileFromResourcesAsStream(String filename) throws FileNotFoundException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(filename);
        if(inputStream == null){
            throw new FileNotFoundException("File not found "+filename);
        }
        return inputStream;
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
