package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filename;
	
	/**
	 * 
	 * @param filename a partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filename) {
		this.filename = filename;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		ResourceHandler resourceHandler = new ResourceHandler();
		
		if (filename != null) {
			try {
				InputStream inputStream = resourceHandler.getFileFromResourcesAsStream(filename);
				BufferedReader reader = new BufferedReader (new InputStreamReader(inputStream));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}


}
