package com.tests.apiAnalyticsTests;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.pages.Page;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.tests.BaseTest;
import com.utils.ElementUtil;

public class AnalyticsTests extends BaseTest{
	
	Date ExpectedTimeInGMT = null;
	String GMT_Time_Expected = null;
	String url = null;
	Page page = null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	AnalyticsNavigationPages analyticsNavigationPage = null;
	JMeterAPIAnalyticsTests jmxApi;
	ElementUtil eUtil = null;
	String response = null;
	
	@BeforeClass
	public void classSetUp() throws Exception {
		url = prop.getProperty("env1")+prop.getProperty("url_vt1");
		page = new Page(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		eUtil = new ElementUtil(remoteDriver);
		analyticsNavigationPage = new AnalyticsNavigationPages(remoteDriver);
		jmxApi = new JMeterAPIAnalyticsTests();
	}
	
	@Test   
	@Parameters({"browser"})	
	public void jmeterTest(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("Verify the Jmeter API Test [JMeter]");
		//ExtentTestManager.getTest().assignCategory("IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching");
		//ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC01_Desktop_InteractiveMap_VerifyLaunching", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor("JMeter");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "VerifytheJmeterAPITest ");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("ExecutingUsingJMeterTool", ExtentColor.RED));
		jmxApi.runJMeterTest();
		jmxApi.readJmeterResultCSVFile();
	}
	
	@Test
	@Parameters({"browser"})
	public void AnalyticsAllTests(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("All Functional Tests in Analytics");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Running All functional Tests in Analytics");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("All Functional Tests in Analytics", ExtentColor.RED));
		
		GMT_Time_Expected = analyticsNavigationPage.getExpectedGMTTime();
		page.navigateToVT(url);
		ExtentTestManager.getTest().pass("Browser Launched and navigate to Url - "+url);
		page.waitForInsightsPageToLoad();
		analyticsNavigationPage.applicationNavigation(browser);
		response = analyticsNavigationPage.launchAPIValidationGetResponse(url);
	}	

	@Test
	@Parameters({"browser"})
	public void TC01_AnalyticsSession(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("TC01_AnalyticSession");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC01_AnalyticSession");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("User launches experience, verifies analytics_session has new entry for userkey and loc_id with start_time = now", ExtentColor.RED));
		String expectedTime = GMT_Time_Expected.substring(0, 10);
		analyticsNavigationPage.verifyAnalyticsSession(response, expectedTime);
	}
	
	@Test
	@Parameters({"browser"})
	public void TC02_AnalyticsActions(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("TC02_AnalyticActions");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC02_AnalyticActions");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("User clicks action button, verifies analytics_actions has new entry for userkey, loc_id, actionid with time = now", ExtentColor.RED));
		analyticsNavigationPage.verifyAnalyticsActions(response, GMT_Time_Expected);
	}
	
	@Test
	@Parameters({"browser"})
	public void TC03_AnalyticsRegistration(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("TC03_AnalyticRegistration");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC03_AnalyticRegistration");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("User registrations to experience,Verifies analytics_registration contain new entry for userkey, loc_id with creation_time = now", ExtentColor.RED));
		String expectedTime = GMT_Time_Expected.substring(0, 10);
		analyticsNavigationPage.verifyAnalyticsRegistration(response, expectedTime);
	}
	
	@Test
	@Parameters({"browser"})
	public void TC04_AnalyticsStops(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("TC04_AnalyticStops");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC04_AnalyticStops");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("User navigates to another stops, verify analytics_stops contain an entry for each stop with a start_time, end_time set based on how long user was in stop", ExtentColor.RED));
		String expectedTime = GMT_Time_Expected.substring(0, 10);
		analyticsNavigationPage.verifyAnalyticsStops(response, GMT_Time_Expected);
	}
	
	@Test
	@Parameters({"browser"})
	public void TC05_AnalyticsModules(@Optional("IamOptional")String browser) throws Exception {
		ExtentTestManager.getTest().assignAuthor("TC05_AnalyticModules");
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC05_AnalyticModules");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("This test case launches an experience, closes the experience and calculates the session length from start and end time and also checks that it is !=0", ExtentColor.RED));
		analyticsNavigationPage.verifyAnalyticsModules(response, GMT_Time_Expected);
	}
}