package com.sap.mdmorchestration.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.sap.mdmorchestration.helper.browserConfiguration.BrowserType;
import com.sap.mdmorchestration.helper.resource.ResourceHelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;
	public static Properties OR1;

	public PropertyReader() {
		
		try {
			String filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);
			
			filePath = ResourceHelper.getResourcePath("src/main/resources/configfile/user.properties");
			file = new FileInputStream(new File(filePath));
			OR1 = new Properties();
			OR1.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExpliciteWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}
	
	public int getSleepWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("sleepwait"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}
	
	public String getUrl()
	{
		System.out.println(OR.getProperty("applicationUrl"));
		return OR.getProperty("applicationUrl");
		
	}
	
	public String getUserName()
	{
		return OR1.getProperty("userName");
		
	}
	
	public String getPassword()
	{
		return OR1.getProperty("password");
		
	}

	

}
