package com.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.driver.DriverInstance;
import com.executor.RunSuite;
import com.executor.RunTask;
import com.utils.UtilityClass;

@Listeners({ ExtentITestListenerClassAdapter.class })
public class BaseTest {
	public static Properties prop;
	public DriverInstance instance;
	public WebDriver remoteDriver;
	public String browserName;
	

	static {

//			System.setProperty("extent.reporter.spark.out", "reports/HtmlReport/"+UtilityClass.getDynamicReportName()+"_allSuites.html");
//			BrowsersDataEnum.dataInMap();
		prop = DriverInstance.setupCommonProperties();
	}

	@BeforeSuite
	public void beforeAll() throws Exception {
		
		System.out.println("prop from basetest"+ prop);
		System.out.println("if size greater than zero then execute "+RunTask.browserList.size());
			System.out.println(RunTask.getQueuedTaskCount());
			browserName = Thread.currentThread().getName();
			System.out.println("browsername given is "+browserName);
			DriverInstance.setInstance(browserName);
			this.remoteDriver = DriverInstance.getInstance().getDriver();
			DriverInstance.getWorkingDriversList().add(remoteDriver);
			
		
	}

	
//	@BeforeTest
//	    public void beforeTest() throws IOException {
//	    	System.out.println("starting suite");   
//	    }
	 
	
	public void init_setup()
	{


	}
	
	 @AfterMethod
	    public synchronized void afterMethod(ITestResult result) throws Exception {
	        switch (result.getStatus()) {
	        case ITestResult.FAILURE:
	            ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod");
	            ExtentTestManager.getTest(result).addScreenCaptureFromPath(UtilityClass.getFileScreenshot(), "");
	            break;
	        case ITestResult.SKIP:
	            ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
	            break;
	        default:
	            ExtentTestManager.getTest(result).pass("default, event afterMethod");
	            break;
	        }
	        
//	        if(result.getMethod().getMethodName().contains("aaapVerifyParentChildInfoRefelectedOnUpdatedParentProfile"))
//        		DriverInstance.getInstance().quitLocalDriver();
		 
	    }
	
	@AfterSuite
	public void tear_down()
	{

		if(browserName.equals("localchrome") || browserName.equals("edge") || browserName.equals("firefox"))
			remoteDriver.quit();
		
//			instance = null;
		
//		DriverInstance.isRemoteBrowserInitialised = false;
	}






}
