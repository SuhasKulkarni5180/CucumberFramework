package com.BDD.General;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class general {
	
	public String readURL() throws IOException {
		Properties p = new Properties();
		FileReader f = new FileReader("src/test/resources/data/data.properties");
		p.load(f);
		
		String url =p.getProperty("applicationname");
		
		return url;
	}

}
