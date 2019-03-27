package com.task.leadsschool.in.LeadSchoolTask;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class ReadData {
	
	public static String ReadDataSource(String Key) throws Exception{
		Properties prop=new Properties();
		FileReader file=new FileReader(".\\Configuration\\Configuration.properties");
		prop.load(file);
		
	return prop.getProperty(Key);
		
	}
	
	

}
