package com.hemebiotech.analytics;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
		
		if (filename != null) {
			try {
				InputStream inputStream = Configuration.getFileFromResourcesAsStream(filename);
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
