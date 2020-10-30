package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Resource handler
 */
public class ResourceHandler {

    /**
     * Gets a file as an input stream
     * @param filename a string that represents a file in the resources folder
     * @return a stream retrieved from the classLoader or throw an exception if the file doesn't exist
     * @throws FileNotFoundException
     */
    public InputStream getFileFromResourcesAsStream(String filename) throws FileNotFoundException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(filename);
        if(inputStream == null){
            throw new FileNotFoundException("File not found "+filename);
        }
        return inputStream;
    }
}
