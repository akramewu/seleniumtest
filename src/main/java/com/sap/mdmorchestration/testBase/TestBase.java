package com.sap.mdmorchestration.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sap.mdmorchestration.helper.browserConfiguration.BrowserType;
import com.sap.mdmorchestration.helper.browserConfiguration.ChromeBrowser;
import com.sap.mdmorchestration.helper.browserConfiguration.FirefoxBrowser;
import com.sap.mdmorchestration.helper.browserConfiguration.config.ObjectReader;
import com.sap.mdmorchestration.helper.browserConfiguration.config.PropertyReader;
import com.sap.mdmorchestration.helper.logger.LoggerHelper;
import com.sap.mdmorchestration.helper.resource.ResourceHelper;
import com.sap.mdmorchestration.helper.wait.WaitHelper;
import com.sap.mdmorchestration.utils.ExtentManager;

public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	private Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectery;
	
	
	@BeforeSuite
	public void beforeSuite(){
		extent = ExtentManager.getInstance();
	}
	
	@BeforeTest
	public void beforeTest() throws Exception{
		ObjectReader.reader = new PropertyReader();
		reportDirectery = new File(ResourceHelper.getResourcePath("src/main/resources/screenShots"));
		setUpDriver(ObjectReader.reader.getBrowserType());
	}
	
	@BeforeClass
	public void beforeClass(){
		test = extent.createTest(getClass().getSimpleName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method method){
		test.log(Status.INFO,method.getName()+" test started");
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(Status.FAIL,result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS,result.getName()+" is pass");
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(Status.SKIP, result.getThrowable());
		}
		
		extent.flush();
	}
	
	@AfterTest
	public void afterTest()
	{
		if (driver!=null) {
			driver.quit();
		}
	}
	
	public WebDriver getBrowserObject(BrowserType btype) throws Exception{
		
		try{
			switch(btype){
			case Chrome:
				// get object of ChromeBrowser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);
				
				// get object of FirefoxBrowser class
			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);
			    
				// get object of IEBrowser class
			/*	
			case Iexplorer:
				IExploreBrowser ie = IExploreBrowser.class.newInstance();
				InternetExplorerOptions cap = ie.getIExplorerCapabilities();
				return ie.getIExplorerDriver(cap);
			*/	
			default:
				throw new Exception("Driver not Found: "+btype.name());
			}
		}
		catch(Exception e){
			log.info(e.getMessage());
			throw e;
		}
	}
	
	public void setUpDriver(BrowserType btype) throws Exception{
		Thread.sleep(10);
		driver = getBrowserObject(btype);
		log.info("Initialize Web driver: "+driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String fileName, WebDriver driver){
		if(driver == null){
			log.info("driver is null..");
			return null;
		}
		if(fileName==""){
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			destFile = new File(reportDirectery+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(screFile.toPath(), destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
    public void getNavigationScreen(WebDriver driver)
    {
    	log.info("capturing ui navigation screen... ");
    	String screen = captureScreen("", driver);
    	try 
    	{
			test.addScreenCaptureFromPath(screen);
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
    
    public static void logExtentReport(String s1)
    {
    	test.log(Status.INFO, s1);
    }
    
    public void getApplicationUrl(String url)
    {
    	driver.get(url);
    	logExtentReport("navigating to ..."+url);
    }
}
