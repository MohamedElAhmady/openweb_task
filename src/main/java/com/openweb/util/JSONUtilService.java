package com.openweb.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.openweb.domainobject.Employees;

/**
 * @author by Mohamed
 */

@Service
public class JSONUtilService {

	/**
	 * A method to load the JSON as string
	 * 
	 * @param String the JSON URL
	 * @return the String of JSON
	 * 
	 */
	public String readJSONStringFromURL(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	/**
	 * A Method to return a JSON from Object
	 * @param src
	 * @return
	 */
	public String getJson(Object src) {
		return new Gson().toJson(src);
	}
	
	
	/**
	 * A method to return object from a JsonString
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public <T> T getObjectfromJson(String json, Class<T> classOfT)  {
		Gson gson = new Gson();
		return 	gson.fromJson(json, classOfT);
	  }
	

}
