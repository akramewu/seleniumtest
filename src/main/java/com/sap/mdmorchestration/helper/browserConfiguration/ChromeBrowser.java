package com.sap.mdmorchestration.helper.browserConfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.sap.mdmorchestration.helper.resource.ResourceHelper;

public class ChromeBrowser {

	public static String browser;

	public ChromeOptions getChromeOptions()
	{
		ChromeOptions option = new ChromeOptions();
		//option.setBinary("C:\\Users\\D073963\\eclipse-workspace\\chrome-win32\\chrome.exe");
		//option.addArguments("user-data-dir=C:\\Users\\D073963\\AppData\\Local\\Chromium\\User Data");
		option.addArguments("--test-type");
		option.addArguments("--disable-popup-blocking");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		
		option.setCapability(ChromeOptions.CAPABILITY,chrome);
		
		//Linux
		if (System.getProperty("os.name").contains("Linux")) {
			option.addArguments("--headless","window-size=104,768","--no-sandbox");
		}
		return option;
	}
	

	public WebDriver getChromeDriver(ChromeOptions cap)
	{
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		}
		else if (System.getProperty("os.name").contains("Window")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
			
		} else if (System.getProperty("os.name").contains("Linux")) {
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver"));
			return new ChromeDriver(cap);
		}
		return null;	
	}
	

 /*
	
	public WebDriver getChromeDriver(String browser)
	{
		WebDriver driver;
		
	       //compares the value of parameter name with Firefox, if its firefox then it will lauch firefox and run the script.
	        
	       if (browser.equalsIgnoreCase("chrome"))
	      {
	    	 System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("src/main/resources/drivers/chromedriver.exe"));
	         driver = new ChromeDriver();
	      }
		return null;
	}
	*/
	public static void main(String[] args) {
		ChromeBrowser obj = new ChromeBrowser();
		WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
		driver.get("https://www.zomato.com/bangalore/punjabi-nawabi-hsr/order/LoqDdXx");
	}
	
    
}
