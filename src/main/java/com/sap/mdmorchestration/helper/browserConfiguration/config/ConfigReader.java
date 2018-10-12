package com.sap.mdmorchestration.helper.browserConfiguration.config;

import com.sap.mdmorchestration.helper.browserConfiguration.BrowserType;

public interface ConfigReader {

	public int getImpliciteWait();
	public int getExpliciteWait();
	public int getPageLoadTime();
	public int getSleepWait();
	public BrowserType getBrowserType();
	public String getUrl();
	public String getUserName();
	public String getPassword();
}
