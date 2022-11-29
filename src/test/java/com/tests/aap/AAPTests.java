package com.tests.aap;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.driver.DriverInstance;
import com.pages.AAPLeftFilterPage;
import com.pages.Page;
import com.pages.aap.AAPAnalyticsPage;
import com.pages.aap.AAPExperienceInsightPage;
import com.pages.aap.AAPExplorePage;
import com.pages.aap.AAPListPage;
import com.pages.aap.AAPLoginPage;
import com.tests.BaseTest;
import com.utils.Constants;
import com.utils.ReadRemoteDownloads;
import com.utils.UtilityClass;

@Test
public class AAPTests extends BaseTest {
	
	String url;
	Page page = null;
	AAPLoginPage loginPage = null;
	AAPExperienceInsightPage insightPage = null;
	AAPLeftFilterPage filterPage;
	AAPAnalyticsPage analyticsPage;
	AAPExplorePage	explorePage;
	AAPListPage listPage;
	
	@BeforeClass
	public void classSetUp() throws Exception {

		url = prop.getProperty("cloud_env")+prop.getProperty("url_aap");

		page = new Page(remoteDriver);
		loginPage = new AAPLoginPage(remoteDriver);
		insightPage = new AAPExperienceInsightPage(remoteDriver);
		filterPage = new AAPLeftFilterPage(remoteDriver);
		analyticsPage = new AAPAnalyticsPage(remoteDriver);
		explorePage = new AAPExplorePage(remoteDriver);
		listPage = new AAPListPage(remoteDriver);
	}

	
	public void initializeLocalHeadlessDownload() throws Exception {
			//============Download csv file================
		WebDriver downloadDriver = DriverInstance.initializeLocalDownloadDriver();
		System.out.println(downloadDriver.toString());
		//			url = prop.getProperty("cloud_env")+prop.getProperty("url_aap");
//		Page page1 = new Page(downloadDriver);
		AAPLoginPage loginPage1 = new AAPLoginPage(downloadDriver);
		AAPExperienceInsightPage insightPage1 = new AAPExperienceInsightPage(downloadDriver);
		AAPLeftFilterPage filterPage1 = new AAPLeftFilterPage(downloadDriver);

		loginPage1.navigateToAAPLogin(url);
		loginPage1.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage1.verifyInsightsPageTitle();
		insightPage1.waitForInsightsPageToLoad();
		loginPage.navigateToAAPLogin(url);
		System.out.println("Logged in to application and navigated to Experience Insight page in headless mode");


		insightPage1.verifyProfileIcon();
		insightPage1.clickProfileIcon();
		System.out.println("Profile icon is displayed and Clicked on it");
		loginPage.navigateToAAPLogin(url);
		insightPage1.selectInstitutionName(Constants.univName, browserName);
		System.out.println("Select institution as "+ Constants.univName+ " in headless mode");
		insightPage1.waitForInsightsPageToLoad();
		loginPage.navigateToAAPLogin(url);
		filterPage1.selectRecency();
		System.out.println("Modified the recency filter to 365 days, Since no results available for 7 days");
		loginPage.navigateToAAPLogin(url);
		UtilityClass.deleteCsvFile(browserName);
		ExtentTestManager.getTest().pass("CSV file deleted if it exist");
		insightPage1.clickDownload();
		System.out.println("Download button clicked, file downloaded and headless execution over");
		DriverInstance.quitLocalDownloadDriver();
			
	}

	@Test   
	@Parameters({"browser"})
	public void aapVerifyAccoutPage(@Optional("IamOptional")String browser) throws Exception	{
//		this.remoteDriver = DriverInstance.getInstance().getDriver();
		System.err.println("AAP_Verify Account Page ["+browserName+"]");
		//ExtentTestManager.getTest().pass("Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]", ExtentColor.RED));
//==SS
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.verifyNameDisplayed();
		ExtentTestManager.getTest().pass("Profile name is displayed");
		insightPage.verifyEmailDisplayed();
		ExtentTestManager.getTest().pass("Profile email is displayed");
		insightPage.verifyAriaOtimizerLink();
		ExtentTestManager.getTest().pass("Go To Aria Optimize link is displayed");
		insightPage.verifyCmsLink();
		ExtentTestManager.getTest().pass("Go To YouVisit CMS link is displayed");
		//insightPage.selectInstitutionName("Brown University", browser);
		insightPage.scrollInstitutionNameAutoFilOptions("Brown University", browser);
		insightPage.waitForInsightsPageToLoad();
		insightPage.clickProfileIcon();
		insightPage.clickLogoutBtn();
		ExtentTestManager.getTest().pass("Logout button is clicked");
		insightPage.waitForInsightsPageToLoad();
		loginPage.navigateToAAPLogin(url);
		loginPage.loginWithEabSSO();
		loginPage.navigateToAAPLogin(url);
		loginPage.signInWithMicrosoftAccount();
		//insightPage.verifyInsighsPage();
		loginPage.navigateToAAPLogin(url);
		loginPage.signInWithGoogleAccount();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application using Google Account and navigated to Experience Insight page");
		//insightPage.verifyProfileIcon();
		loginPage.navigateToAAPLogin(url);
		ExtentTestManager.getTest().pass("Logged out and navaigated to AAP login page");
//==EE		
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifyAllColumnNames(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("AAP_Verify All Column Names["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		loginPage.navigateToAAPLogin(url);
		if(!browserName.equals("winchrome") && !browserName.equals("localchrome")) {
			initializeLocalHeadlessDownload();
		}
		

		
		ExtentTestManager.getTest().generateLog(Status.INFO, "Verify All Column Names ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify All Column Names ["+browserName+"]", ExtentColor.RED));
			//============Download csv file================
			loginPage.navigateToAAPLogin(url);
			loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
			insightPage.verifyInsightsPageTitle();
			insightPage.waitForInsightsPageToLoad();
			ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
			
			ExtentTestManager.getTest().pass("Select institution as "+ Constants.univName);
			insightPage.verifyProfileIcon();
			insightPage.clickProfileIcon();
			ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
			insightPage.selectInstitutionName(Constants.univName, browserName);
			insightPage.waitForInsightsPageToLoad();
			filterPage.selectRecency();
			ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
			Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
			
//			JavaScriptUtil jsUtil = new JavaScriptUtil(remoteDriver);
//			String fileName = jsUtil.waitUntilDonwloadCompleted();
			if(browserName.equals("winchrome") || browserName.equals("localchrome")) {
				UtilityClass.deleteCsvFile(browserName);
				ExtentTestManager.getTest().pass("CSV file deleted if it exist");
				insightPage.clickDownload();
				ExtentTestManager.getTest().pass("Download button clicked");
				ReadRemoteDownloads remDL = new ReadRemoteDownloads((RemoteWebDriver)remoteDriver);
				ArrayList<String> fileList = remDL.get_downloaded_files(browserName);
				if(fileList!=null)
					System.out.println("size of file list "+fileList.size());
				for(String fileName:fileList) {
					System.out.println("Actual filename "+fileName);
				}
				String fileNamePath = fileList.get(0);
				
				String fileContent = null;
				if(!browserName.equals("localchrome"))
				fileContent = remDL.get_file_content(fileNamePath, browserName);
				
				
				//DriverInstance.getInstance().quitLocalDriver();
				
				String[] listOfColumnsExpected = insightPage.columnNamesListExpected();
				String[] listOfColumnsNotExpected = insightPage.columnNamesListNotExpected();
				for(String listItem:listOfColumnsExpected) {
					if(insightPage.verifyColumnName2(listItem, browserName)) {
						System.out.println("Column Name["+listItem+"] exist in the Exported CSV file");
						ExtentTestManager.getTest().pass("Column Name["+listItem+"] exist in the Exported CSV file");
					}else {
						System.err.println("Column Name["+listItem+"] doesn't exist in the Exported CSV file");
						ExtentTestManager.getTest().fail("Column Name["+listItem+"] doesn't exist in the Exported CSV file");
					}
				}
				if(listOfColumnsNotExpected.length>0) {
					for(String listItem:listOfColumnsNotExpected) {
						if(!insightPage.verifyColumnName2(listItem, browserName)) {
							System.err.println("Column Name["+listItem+"] exist in the Exported CSV file");
							ExtentTestManager.getTest().fail("Column Name["+listItem+"] exist in the Exported CSV file");
						}else {
							System.out.println("Column Name["+listItem+"] doesn't exist in the Exported CSV file");
							ExtentTestManager.getTest().pass("Column Name["+listItem+"] doesn't exist in the Exported CSV file");
						}
					}
				}
			}
	}
	
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifyParentChildInfoRefelectedOnUpdatedParentProfile(@Optional("IamOptional")String browser) throws Exception{	
		System.err.println("AAP_VerifyParentChildInfoRefelectedOnUpdatedParentProfile["+browserName+"]");
//		ExtentTestManager.getTest().pass("AAP_VerifyParentChildInfoRefelectedOnUpdatedParentProfile["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Parent Child Info Refelected  OnUpdated Parent Profile", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_VerifyParentChildInfoRefelectedOnUpdatedParentProfile["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_VerifyParentChildInfoRefelectedOnUpdatedParentProfile["+browserName+"]", ExtentColor.RED));

		//============Download csv file================//
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest()	.pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
//		UtilityClass.deleteCsvFile(browserName);
//		ExtentTestManager.getTest().pass("CSV file deleted if it exist");
//		insightPage.clickDownload();
//		ExtentTestManager.getTest().pass("Download button clicked");
		//DriverInstance.getInstance().quitLocalDriver();
			//============Verify Column headers================
			String[] listOfColumnsExpected = new String[] {"location_name", "location_id", "name_first", "name_last", "name_full",
					"parent_name_first", "parent_name_last", "parent_name_full", "email", "parent_email", "phone", "parent_phone", 
					"geo_postal_code", "geo_city", "geo_state", "geo_country", "geo_street","date_of_birth", "gender", "ethnicity",
					"visitor_type", "visitor_type_hs_level_as_of_today", "visitor_type_hs_level_as_of_reg_date", "grad_year", "entry_term_year",
					"entry_term", "entry_year", "level_of_study", "major_intended", "school_name", "school_ceeb_code", "gpa", "sat", "act",
					"date_registered", "relative_engagement", "mode_of_study", "grad_programs", "adult_grad_programs",  "is_cif", "schedule_visit_cta_clicked", 
					"apply_now_cta_clicked", "register_now_cta_clicked", "date_last_active_with_my_institution", "date_last_active_in_eab_network",
					"citizenship", "needs_visa", "tcpa"};
			/*String[] listOfColumnsExpected = new String[] {"location_name", "location_id", "name_first", "name_last", "name_full", "email",
												   "phone", "geo_postal_code", "geo_city", "geo_state", "geo_country", "geo_street",
												   "date_of_birth", "gender", "ethnicity", "visitor_type", 
												   "visitor_type_hs_level_as_of_today", "visitor_type_hs_level_as_of_reg_date", 
												   "grad_year", "entry_term_year", "entry_term", "entry_year", "level_of_study", 
												   "major_intended", "school_name", "school_ceeb_code", "gpa", "sat", "act", 
												   "date_registered", "relative_engagement", "mode_of_study", "grad_programs", 
												   "adult_grad_programs", "schedule_visit_cta_clicked", "apply_now_cta_clicked", 
												   "register_now_cta_clicked", "date_last_active_with_my_institution", 
												   "date_last_active_in_eab_network", "citizenship", "needs_visa"};*/
			//String[] listOfColumnsNotExpected = new String[] {" "};
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifyAnalyticsGoodData(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("AAP_Verify Analytics Good Data ["+browserName+"]");
//		ExtentTestManager.getTest().pass("AAP_Verify Analytics Good Data ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify content displayed in [Content Performance] and [Your EDU vs. Network]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Verify Analytics Good Data ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify Analytics Good Data ["+browserName+"]", ExtentColor.RED));

		this.remoteDriver = DriverInstance.getInstance().getDriver();
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		insightPage.verifyProfileIcon();
		analyticsPage.clickAnalyticsTabLink();
		insightPage.waitForInsightsPageToLoad();
		Assert.assertTrue(analyticsPage.verifyContentPerformenceLinkDisplayed(), "Content Performence Page is not Displayed");
		Assert.assertTrue(analyticsPage.verifyYourEduVsNetworkLinkDisplayed(), "Your EDU Vs. NetWork tab link is not displayed");
		analyticsPage.switchToAnalyticsCpVtOverviewFrame();
		insightPage.waitForInsightsPageToLoad();
		Assert.assertTrue(analyticsPage.verifyVTDashboardHeaderDisplayed(), "Vitual Tours dashboard header is is not displayed");
		Assert.assertTrue(analyticsPage.verifyVtFirstLocationNameDisplayed(), "Vitual Tours dashboard results not displayed");
		analyticsPage.clickVtFirstLocationNameLink();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Click on first row in Virtual Tours dashboard");
		analyticsPage.switchToDefaultFrame();
		analyticsPage.clickCloseVtButton();
		ExtentTestManager.getTest().pass("Click Virtual Tours close button");
		analyticsPage.switchToAnalyticsCpVtOverviewFrame();
		Assert.assertTrue(analyticsPage.verifyYourEduVsNetworkDashboardHeaderDisplayed(), "Your Virtual Tours Vs.Network dashboard header is not displayed");
		analyticsPage.switchToDefaultFrame();
		analyticsPage.switchToAnalyticsCpIwcOverviewFrame();
		Assert.assertTrue(analyticsPage.verifyIwcFirstLocationNameDisplayed(), "Interactive Web Content (IWC) dashboard results not displayed");
		analyticsPage.clickIwcFirstRowContentLocationName();
		insightPage.waitForInsightsPageToLoad();
		analyticsPage.switchToDefaultFrame();
		analyticsPage.clickCloseVtButton();
		ExtentTestManager.getTest().pass("Click Virtual Tours close button");
		analyticsPage.switchToAnalyticsCpIwcOverviewFrame();
		Assert.assertTrue(analyticsPage.verifyYourIwcVsNetworkDashboardHeaderDisplayed(), "Your IWC Vs.Network dashboard header is not displayed");
		analyticsPage.switchToDefaultFrame();
		analyticsPage.clickYourEduVsNetworkTabLink();
		ExtentTestManager.getTest().pass("Click on Your EDU vs. Network tab");
		analyticsPage.switchToYourEduVsNetworkDashboardFrame();
		
		Assert.assertEquals(analyticsPage.getYourContentToCompareDropdownText(),"All");
		ExtentTestManager.getTest().pass("All option is selected on YOUR CONTENT TO COMPARE dropdown by default");
		analyticsPage.clickYourContentToCompareDropdown();
		ExtentTestManager.getTest().pass("YOUR CONTENT TO COMPARE dropdown options are listed");
		Assert.assertTrue(analyticsPage.verifyAllVTsOptionDisplayed(), "Verify All VTs option is not displayed in the  YOUR CONTENT TO COMPARE dropdown");
		Assert.assertTrue(analyticsPage.verifyAllIWCsOptionDisplayed(), "Verify All IWCs option is not displayed in the  YOUR CONTENT TO COMPARE dropdown");
		analyticsPage.clickYourContentToCompareDropdown();
		ExtentTestManager.getTest().pass("YOUR CONTENT TO COMPARE dropdown option list closed and dropdown selected with default value All");
		Assert.assertEquals(analyticsPage.getInstitutionSectorDropdownText(),"All");
		ExtentTestManager.getTest().pass("All option is selected on Institution Sector dropdown by default");
		Assert.assertEquals(analyticsPage.getInstitutionSizeDropdownText(),"All");
		ExtentTestManager.getTest().pass("All option is selected on Institution Size dropdown by default");
		Assert.assertEquals(analyticsPage.getInstitutionRegionDropdownText(),"All");
		ExtentTestManager.getTest().pass("All option is selected on Institution Region dropdown by default");
		Assert.assertTrue(analyticsPage.verifyNoOfVisitorsDashboardHeaderDisplayed(), "#. of Visitors dashboard header is not displayed");
		Assert.assertTrue(analyticsPage.verifyNoOfVisitorsOvertimeDashboardHeaderDisplayed(), "#. of Visitors Over Time dashboard header is not displayed");
		Assert.assertTrue(analyticsPage.verifyAvgTimeSpentDashboardHeaderDisplayed(), "Average Time Spent (Mins) dashboard header is not displayed");
		Assert.assertTrue(analyticsPage.verifyNoOfVisitorsDashboardHeaderDisplayed(), "#. of Visitors dashboard header is not displayed");
		Assert.assertEquals(analyticsPage.getNoOfYourEduVsNetworkMapsDisplayed(),2);
		ExtentTestManager.getTest().pass("Verify maps displayed in the YOUR Edu vs Network");
		analyticsPage.switchToDefaultFrame();
		analyticsPage.clickDateRangeDropdown();
		Assert.assertTrue(analyticsPage.verifyLast7DaysOptionDisplayed(), "Last 7 days option option is not displayed in the Date Range dropdown");
		Assert.assertTrue(analyticsPage.verifyLast30DaysOptionDisplayed(), "Last 30 days option option is not displayed in the Date Range dropdown");
		Assert.assertTrue(analyticsPage.verifyLast90DaysOptionDisplayed(), "Last 90 days option option is not displayed in the Date Range dropdown");
		Assert.assertTrue(analyticsPage.verifyLast365DaysOptionDisplayed(), "Last 365 days option option is not displayed in the Date Range dropdown");
		analyticsPage.clickCustomeDateOption();
		ExtentTestManager.getTest().pass("Select Custom Date option in Date Range dropdown");
		analyticsPage.clickCustomeStartDateOption();
		ExtentTestManager.getTest().pass("Select Custom Start Date option in Date Range dropdown");
		int selectedStartDate = analyticsPage.getSelectedNextDayCustomeStartDate();
		System.out.println("Selected start date = "+selectedStartDate);
		analyticsPage.clickSelectedNextDayCustomStartDate();
		ExtentTestManager.getTest().pass("Select next day to the default selected date in calendar displayed");
		int selectedEndDate = analyticsPage.getSelectedPreviousDayCustomeEndDate();
		System.out.println("Selected start date = "+selectedEndDate);
		analyticsPage.clickSelectedPreviousDayCustomEndDate();
		ExtentTestManager.getTest().pass("Select previous day to the default selected end date in calendar displayed");
		analyticsPage.clickCustomeDateOption();
		analyticsPage.clickCustomeDateOption();
		ExtentTestManager.getTest().pass("Select Custom Date option in Date Range dropdown");
		String[] fromAndToDates = analyticsPage.getFromAndToDates();
		System.out.println("from date = "+fromAndToDates[0]);
		System.out.println("To date = "+fromAndToDates[1]);
		if(selectedStartDate==Integer.parseInt(fromAndToDates[0]))
			ExtentTestManager.getTest().pass("Selected Start Date "+selectedStartDate+" is equal to the displayed start date");
		else
			ExtentTestManager.getTest().fail("Selected Start Date "+selectedStartDate+" is not equal to the displayed start date["+fromAndToDates[0]);
		if(selectedEndDate==Integer.parseInt(fromAndToDates[1]))
			ExtentTestManager.getTest().pass("Selected End Date "+selectedEndDate+" is equal to the displayed End date");
		else
			ExtentTestManager.getTest().fail("Selected End Date "+selectedEndDate+" is not equal to the displayed End date"+fromAndToDates[1]);
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifySubFiltersProspectiveStudentParentOfProspectAndOtherOfDemographics(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Demographics Prospective Student, Parents Of Prospect and Other Filter Inquiries ["+browserName+"]");
//		ExtentTestManager.getTest().pass("AAP_Verify Demographics PS, Parents and Other Filter Inquiries ["+browserName+"]");
//		ExtentTestManager.getTest().info("AAP_Demographics Prospective Student, Parents Of Prospect and Other Filter Inquiries");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for PS, Parent and  Other filters in [Demographics]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Demographics Prospective Student, Parents Of Prospect and Other Filter Inquiries ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Demographics Prospective Student, Parents Of Prospect and Other Filter Inquiries ["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		filterPage.verifyDemographicsMainFilterDisplayed();
		ExtentTestManager.getTest().pass("Demographics is displayed in filter");
		filterPage.clickDemographicMainFilter();
		ExtentTestManager.getTest().pass("Clicked on the Demographics filter");
		filterPage.verifyVisitorTypeMainFilterDisplayed();
		ExtentTestManager.getTest().pass("Visitor Type is displayed in filter");
		filterPage.verifyGeographyMainFilterDisplayed();
		ExtentTestManager.getTest().pass("Geography is displayed in filter");
		filterPage.verifyAgeMainFilterDisplayed();
		ExtentTestManager.getTest().pass("Age is displayed in filter");
		filterPage.verifyGenderMainFilterDisplayed();
		filterPage.verifyEthinicityMainFilterDisplayed();
		filterPage.clickVisitorTypeMainFilter();
		ExtentTestManager.getTest().pass("Clicked on the Visitor Type filter");
		
		filterPage.clickProspectiveStudentMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Prospective Student filter");		
		//==================HS Student=====================	
		filterPage.selectHSStudent("Prospective Student");
		filterPage.verifyNumOfInquiries("HS Student", "visitor_type", "hs_student", browserName);
		filterPage.selectHSStudent("Prospective Student");
		//==================HS Graduate=====================
		filterPage.selectHSGraduate("Prospective Student");
		filterPage.verifyNumOfInquiries("HS Graduate", "visitor_type", "hs_grad", browserName);
		filterPage.selectHSGraduate("Prospective Student");
		//==================College Student=================
		filterPage.selectCollegeStudent("Prospective Student");
		filterPage.verifyNumOfInquiries("College Student", "visitor_type", "college_student", browserName);
		filterPage.selectCollegeStudent("Prospective Student");
		//==================College Graduate=================
		filterPage.selectCollegeGraduate("Prospective Student");
		filterPage.verifyNumOfInquiries("College Graduate", "visitor_type", "college_grad", browserName);
		filterPage.selectCollegeGraduate("Prospective Student");
		//==================Adult Learner====================
		filterPage.selectAdultLearner("Prospective Student");
		filterPage.verifyNumOfInquiries("Adult Learner", "visitor_type", "adult_learner", browserName);
		filterPage.selectAdultLearner("Prospective Student");
		//==================Middle Schooler==================
		filterPage.selectMiddleSchooler("Prospective Student");
		filterPage.verifyNumOfInquiries("Middle Schooler", "visitor_type", "middle_school", browserName);
		filterPage.selectMiddleSchooler("Prospective Student");
		
		filterPage.verifyProspectiveStudentMainFilterDisplayed();
		filterPage.clickProspectiveStudentMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Prospective Student filter");
		
		//============================Parent of Prospect===================		
		filterPage.verifyParentOfProspecttMainFilterDisplayed();
		filterPage.clickParentOfProspecttMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Parent of Prospect filter");
		
		//==================HS Student=====================	
		filterPage.selectHSStudent("Parent of Prospect");
		filterPage.verifyNumOfInquiries("HS Student", "visitor_type", "parent_hs_student", browserName);
		filterPage.selectHSStudent("Parent of Prospect");
		//==================HS Graduate=====================
		filterPage.selectHSGraduate("Parent of Prospect");
		filterPage.verifyNumOfInquiries("HS Graduate", "visitor_type", "parent_hs_grad", browserName);
		filterPage.selectHSGraduate("Parent of Prospect");
		//==================College Student=================
		filterPage.selectCollegeStudent("Parent of Prospect");
		filterPage.verifyNumOfInquiries("College Student", "visitor_type", "parent_college_student", browserName);
		filterPage.selectCollegeStudent("Parent of Prospect");
		//==================College Graduate=================
		filterPage.selectCollegeGraduate("Parent of Prospect");
		filterPage.verifyNumOfInquiries("College Graduate", "visitor_type", "parent_college_grad", browserName);
		filterPage.selectCollegeGraduate("Parent of Prospect");
		//==================Middle Schooler==================
		filterPage.selectMiddleSchooler("Parent of Prospect");
		filterPage.verifyNumOfInquiries("Middle Schooler", "visitor_type", "parent_middle_school", browserName);
		filterPage.selectMiddleSchooler("Parent of Prospect");		
		
		filterPage.verifyParentOfProspecttMainFilterDisplayed();
		filterPage.clickParentOfProspecttMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Parent of Prospect filter");
		
		//============================Other===================
		filterPage.verifyOtherMainFilterDisplayed();
		filterPage.clickOtherMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Other filter");
		
		//==================HS Student=====================	
		filterPage.selectCurrentStudent("Other");
		filterPage.verifyNumOfInquiries("Other", "visitor_type", "current_student", browserName);
		filterPage.selectCurrentStudent("Other");
		//==================HS Graduate=====================
		filterPage.selectAlumni("Other");
		filterPage.verifyNumOfInquiries("Other", "visitor_type", "alumni", browserName);
		filterPage.selectAlumni("Other");
		//==================College Student=================
		filterPage.selectFaculty("Other");
		filterPage.verifyNumOfInquiries("Other", "visitor_type", "faculty", browserName);
		filterPage.selectFaculty("Other");
		//==================College Graduate=================
		filterPage.selectGuidanceCounselor("Other");
		filterPage.verifyNumOfInquiries("Other", "visitor_type", "counselor", browserName);
		filterPage.selectGuidanceCounselor("Other");
		//==================Middle Schooler==================
		filterPage.selectVeteran("Other");
		filterPage.verifyNumOfInquiries("Other", "visitor_type", "veteran", browserName);
		filterPage.selectVeteran("Other");		
		
		filterPage.verifyOtherMainFilterDisplayed();
		filterPage.clickOtherMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Other filter");
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifyGeographyAgeGenderEthinicitySubFiltersInquiriesOfDemographics(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Demographics Geography, Age, Gender and Ethinicity Filter Inquiries ["+browserName+"]");
//		ExtentTestManager.getTest().pass("AAP_Verify Demographics Geography, Age, Gender and Ethinicity Filter Inquiries ["+browserName+"]");
//		ExtentTestManager.getTest().info("AAP_Demographics Geography, Age, Gender and Ethinicity Filter Inquiries");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for Geography, Age, Gender and Ethinicity filters in [Demographics]", ExtentColor.RED));

		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Demographics Geography, Age, Gender and Ethinicity Filter Inquiries ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Demographics Geography, Age, Gender and Ethinicity Filter Inquiries ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");

		filterPage.verifyDemographicsMainFilterDisplayed();
		filterPage.clickDemographicMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Demographics filter");
		filterPage.verifyGeographyMainFilterDisplayed();
		filterPage.clickGeographyMainFilter();
		ExtentTestManager.getTest().pass("Clicked on Geography filter");
		filterPage.clickInternationalSubFilterOfGeographyFilter();
		filterPage.clickSubFilterOfGeography("US Regions");
		filterPage.selectSubFiltersOfUSRegionChkBx("Northeast");
		filterPage.selectSubFiltersOfUSRegionChkBx("Midwest");
		filterPage.selectSubFiltersOfUSRegionChkBx("Southwest");
		filterPage.selectSubFiltersOfUSRegionChkBx("West");
		filterPage.selectSubFiltersOfUSRegionChkBx("Southeast");
		filterPage.clickOtherSubFilterOfUSRegions();
		ExtentTestManager.getTest().pass("Clicked on the Other sub filter of the US Regions parent filter");
		filterPage.clickSubFilterOfGeography("In-State");
		filterPage.clickSubFilterOfGeography("Out-of-State");
		filterPage.clickSubFilterOfGeography("Specific States/Territories");
		filterPage.typeOnSearchByStateTxtBx("New York (NY)");
		page.waitForInsightsPageToLoad();
		filterPage.clickSearchByTxtBxAutofillOption("New York (NY)");
		page.waitForInsightsPageToLoad();
		filterPage.verifyNumOfInquiries("Specific States/Territories","geo_state","NY", browserName);
		filterPage.clickSearchByTxtBxAutofillOption("New York (NY)");
		page.waitForInsightsPageToLoad();
		filterPage.clickSubFilterOfGeography("Specific States/Territories");
		filterPage.scrollToDemographicsFilterCollapseIcon();
		filterPage.clickUSASubFilterOfGeographyFilter();
		filterPage.clickInternationalSubFilterOfGeographyFilter();
		filterPage.clickSubFilterOfGeography("Specific Countries");
		filterPage.typeSearchCountryTxtBx("India (IND)");
		filterPage.clickSearchByTxtBxAutofillOption("India (IND)");
		filterPage.verifyNumOfInquiries("Specific Countries","geo_country","IND", browserName);
		filterPage.clickSearchByTxtBxAutofillOption("India (IND)");
		filterPage.clickSubFilterOfGeography("All International");
		filterPage.clickResetFiltersButton();
		filterPage.selectRecency();
		
		//======================Age==========================//
		filterPage.scrollToAgeFilter();
		filterPage.clickAgeMainFilter();
		ExtentTestManager.getTest().pass("Clicked on the Age filter");
		filterPage.selectSubFilterOfAge("Specific Age Range");
		filterPage.selectSubFilterOfAge("Any");
		filterPage.clickAgeMainFilter();
		//filterPage.clickResetFiltersButton();
		//filterPage.selectRecency();

		//======================Gender==========================//
		filterPage.scrollToGenderFilter();
		filterPage.clickGenderMainFilter();
		ExtentTestManager.getTest().pass("Clicked on the Gender filter");
		filterPage.selectSubFilterOfGender("Female");
		filterPage.verifyNumOfInquiries("Gender","gender","female", browserName);
		filterPage.selectSubFilterOfGender("Female");
		filterPage.selectSubFilterOfGender("Male");
		filterPage.verifyNumOfInquiries("Gender","gender","male", browserName);
		filterPage.selectSubFilterOfGender("Male");
		filterPage.selectSubFilterOfGender("Non-Binary / Third Gender");
		filterPage.verifyNumOfInquiries("Gender","gender","non-bi", browserName);
		filterPage.selectSubFilterOfGender("Non-Binary / Third Gender");
		filterPage.clickGenderMainFilter();
		//filterPage.clickResetFiltersButton();
		//filterPage.selectRecency();
		
		//======================Ethnicity==========================//
		filterPage.scrollToEthinicityFilter();
		filterPage.clickEthnicityMainFilter();
		ExtentTestManager.getTest().pass("Clicked on the Ethnicity filter");
		filterPage.selectSubFilterOfEthnicity("American Indian or Alaska Native");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","American Indian or Alaska Native", browserName);
		filterPage.selectSubFilterOfEthnicity("American Indian or Alaska Native");
		filterPage.selectSubFilterOfEthnicity("Asian");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Asian", browserName);
		filterPage.selectSubFilterOfEthnicity("Asian");
		filterPage.selectSubFilterOfEthnicity("Black or African American");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Black or African American", browserName);
		filterPage.selectSubFilterOfEthnicity("Black or African American");
		filterPage.selectSubFilterOfEthnicity("Hispanic or Latin");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Hispanic or Latin", browserName);
		filterPage.selectSubFilterOfEthnicity("Hispanic or Latin");
		filterPage.selectSubFilterOfEthnicity("Native Hawaiian or Other Pacific Islander");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Native Hawaiian or Other Pacific Islander", browserName);
		filterPage.selectSubFilterOfEthnicity("Native Hawaiian or Other Pacific Islander");		
		filterPage.selectSubFilterOfEthnicity("White");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","White", browserName);
		filterPage.selectSubFilterOfEthnicity("White");		
		filterPage.selectSubFilterOfEthnicity("Mixed Race");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Mixed Race", browserName);
		filterPage.selectSubFilterOfEthnicity("Mixed Race");
		filterPage.selectSubFilterOfEthnicity("Other");
		filterPage.verifyNumOfInquiries("Ethnicity","ethnicity","Other", browserName);
		filterPage.selectSubFilterOfEthnicity("Other");		
	}
	

	@Test   
	@Parameters({"browser"})
	public void aapVerifyEngagementFilterInquiries(@Optional("IamOptional")String browser) throws Exception 
	{
		System.err.println("AAP_Engagement Filter Count["+browserName+"]");
		//engagement = 
//		ExtentTestManager.getTest().pass("AAP_Verify Engagement Filter Count["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for filters in [Engagement]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Engagement Filter Count["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Engagement Filter Count["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+ Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		filterPage.verifyEngagementFilter();
		ExtentTestManager.getTest().pass("Engagement filter is displayed in filters section ");
		filterPage.verifyDateRegisteredWithMyInstitutionFilter();
		ExtentTestManager.getTest().pass("Date Registered with My Institution is displayed in filters");
		filterPage.verifyRelativeEngagementFilter();
		ExtentTestManager.getTest().pass("Relative Engagement is displayed in filters");
		filterPage.verifyTotalTimeSpentInVTAndOrIWCFilter();
		ExtentTestManager.getTest().pass("Total Time Spent in My VT and/or IWC is displayed in filters");
		filterPage.verifyScheduledVisitCtaClickedFilter();
		ExtentTestManager.getTest().pass("Schedule Visit CTA Clicked is displayed in filters");		
		filterPage.verifyApplyNowCtaClickedFilter();
		ExtentTestManager.getTest().pass("Apply Now CTA Clicked is displayed in filters");
		filterPage.verifyActivityWithMyInstitutionFilter();
		ExtentTestManager.getTest().pass("Activity with My Institution is displayed in filters");
		filterPage.verifyActivityWithEABNetworkFilter();
		ExtentTestManager.getTest().pass("Activity with EAB Network is displayed in filters");
		
		
		//=================Date Registered with My Institution==================//
		Assert.assertTrue(filterPage.verifyAnySubfilterOfDateRegisterdWithMyInstitutionFilter(), "Any fileter in Date Registered with My Institution is not displayed in filters");
		Assert.assertTrue(filterPage.verifySelectRecencySubfilterOfDateRegisterdWithMyInstitutionFilter(), "Select Recency fileter in Date Registered with My Institution is not displayed in filters");
		Assert.assertTrue(filterPage.verifySpecificDateRangeSubfilterOfDateRegisterdWithMyInstitutionFilter(), "Specific Date Range fileter in Date Registered with My Institution is not displayed in filters");
		filterPage.clickDateRegisterdWithMyInstitutionFilter();
		
		//=================Relative Engagement==================//
		filterPage.clickRelativeEngagementFilter();
		filterPage.verifySubfilterOfRelativeEngagementFilter("High");
		filterPage.verifySubfilterOfRelativeEngagementFilter("Medium");
		filterPage.verifySubfilterOfRelativeEngagementFilter("Low");

		filterPage.selectSubfilterOfRelativeEngagementFilter("High");
		filterPage.verifyNumOfInquiries("Relative Engagement","relative_ExtentTestManager.getTest()","high", browserName);
		filterPage.selectSubfilterOfRelativeEngagementFilter("High");
		filterPage.selectSubfilterOfRelativeEngagementFilter("Medium");
		filterPage.verifyNumOfInquiries("Relative Engagement","relative_ExtentTestManager.getTest()","medium", browserName);
		filterPage.selectSubfilterOfRelativeEngagementFilter("Medium");
		filterPage.selectSubfilterOfRelativeEngagementFilter("Low");
		filterPage.verifyNumOfInquiries("Relative Engagement","relative_ExtentTestManager.getTest()","low", browserName);
		filterPage.selectSubfilterOfRelativeEngagementFilter("Low");
		filterPage.clickRelativeEngagementFilter();
		
		//=================Total Time Spent in My VT and/or IWC==================//
		filterPage.clickTotalTimeSpentInVTAndOrIWCFilter();
		filterPage.verifySubfilterOfTotalTimeSpentInVTAndOrIWCFilter("Any");
		filterPage.selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter("VT");
		filterPage.selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter("IWC");
		filterPage.selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter("VT or IWC");
		filterPage.selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter("VT and IWC");
		filterPage.selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter("Any");
		filterPage.clickTotalTimeSpentInVTAndOrIWCFilter();
		
		//=================Schedule Visit CTA Clicked==================//
		
		filterPage.clickScheduleVisitCTAClickedFilter();
		filterPage.verifySubfilterOfScheduleVisitCTAClickedFilter("Any");
		filterPage.verifySubfilterOfScheduleVisitCTAClickedFilter("Yes");
		filterPage.verifySubfilterOfScheduleVisitCTAClickedFilter("No");
		
		filterPage.selectSubfilterOfScheduleVisitCTAClickedFilter("Yes");
		filterPage.verifyNumOfInquiries("Schedule Visit CTA Clicked", "schedule_visit_cta_clicked", "TRUE", browserName);
		filterPage.selectSubfilterOfScheduleVisitCTAClickedFilter("Yes");
		filterPage.selectSubfilterOfScheduleVisitCTAClickedFilter("No");
		filterPage.verifyNumOfInquiries("Schedule Visit CTA Clicked", "schedule_visit_cta_clicked", "FALSE", browserName);
		filterPage.selectSubfilterOfScheduleVisitCTAClickedFilter("Any");
		filterPage.clickScheduleVisitCTAClickedFilter();
		
		//=================Apply Now CTA Clicked==================//
		
		filterPage.clickApplyNowCTAClickedFilter();
		filterPage.verifySubfilterOfApplyNowCTAClickedFilter("Any");
		filterPage.verifySubfilterOfApplyNowCTAClickedFilter("Yes");
		filterPage.verifySubfilterOfApplyNowCTAClickedFilter("No");
		
		filterPage.selectSubfilterOfApplyNowCTAClickedFilter("Yes");
		filterPage.verifyNumOfInquiries("Apply Now CTA Clicked", "apply_now_cta_clicked", "TRUE", browserName);
		filterPage.selectSubfilterOfApplyNowCTAClickedFilter("Yes");
		filterPage.selectSubfilterOfApplyNowCTAClickedFilter("No");
		filterPage.verifyNumOfInquiries("Apply Now CTA Clicked", "apply_now_cta_clicked", "FALSE", browserName);
		filterPage.selectSubfilterOfApplyNowCTAClickedFilter("No");
		filterPage.selectSubfilterOfApplyNowCTAClickedFilter("Any");
		filterPage.clickApplyNowCTAClickedFilter();
		
		//=================Activity with My Institution==================//

		filterPage.clickActivityWithMyInstitutionMainFilter();
		filterPage.verifySubfilterOfActivityWithMyInstitutionFilter("Any");
		filterPage.verifySubfilterOfActivityWithMyInstitutionFilter("Active");
		filterPage.verifySubfilterOfActivityWithMyInstitutionFilter("Inactive");
		
		filterPage.selectSubfilterOfActivityWithMyInstitutionFilter("Active");
		//filterPage.verifyNumOfInquiries("Activity with My Institution", "date_last_active_with_my_institution", "TRUE", browserName);
		filterPage.selectSubfilterOfActivityWithMyInstitutionFilter("Active");
		//filterPage.verifyNumOfInquiries("Activity with My Institution", "date_last_active_with_my_institution", "FALSE", browserName);
		filterPage.verifySubfilterOfActivityWithMyInstitutionFilter("Any");
		filterPage.clickActivityWithMyInstitutionMainFilter();

		//=================Activity with EAB Network==================//

		filterPage.clickActivityWithEABNetworkMainFilter();
		filterPage.verifySubfilterOfActivityWithEABNetworkFilter("Any");
		filterPage.verifySubfilterOfActivityWithEABNetworkFilter("Active");
		filterPage.verifySubfilterOfActivityWithEABNetworkFilter("Inactive");
		
		filterPage.selectSubfilterOfActivityWithEABNetworkFilter("Active");
		//filterPage.verifyNumOfInquiries("Activity with My Institution", "date_last_active_with_my_institution", "TRUE", browserName);
		filterPage.selectSubfilterOfActivityWithEABNetworkFilter("Active");
		//filterPage.verifyNumOfInquiries("Activity with My Institution", "date_last_active_with_my_institution", "FALSE", browserName);
		filterPage.verifySubfilterOfActivityWithEABNetworkFilter("Any");
		filterPage.clickActivityWithEABNetworkMainFilter();

		//=============================List Membership =========================================//
		
		filterPage.verifyListMembershipFilter();
		filterPage.verifyListMembershipSearchListTxtBxFilter();
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVrifyListMembershipFilterInquiries(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_List Membership Filter Count ["+browserName+"]");
		//list_membership = 
//		ExtentTestManager.getTest().pass("AAP_List Membership Filter Count ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for filters in List Membership", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_List Membership Filter Count ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_List Membership Filter Count ["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		filterPage.clickListMembershipMainFilter();
		filterPage.verifyListMembershipSearchListTxtBxFilter();
		ExtentTestManager.getTest().pass("Search List textbox in List Membership filter is displayed");
		
		//=============Create List===========
		int numOfInq = filterPage.totalNumberOfInquiries();
		filterPage.clickAddToListBtn();
		filterPage.clickCreateNewListChkBxInAddToList();
		String newListName = page.getDynamicNameString();
		filterPage.typeNewListNameTxtBxInAddToList(newListName);
		filterPage.clickAddToListBtnInAddToList();
		filterPage.typeSearchListTxtBxInExplorePage(newListName);
		page.waitForInsightsPageToLoad();
		filterPage.verifyListNameOptionInSearchListNameTxtBx(newListName);
		filterPage.clickSearchListNameDropdownOption(newListName);
		filterPage.verifyTotalInquriesAndInquiriesList(numOfInq);
		
		//===============Delete the list===============//
		filterPage.deleteCreatedListNameInLisTab(newListName);
	}
	
	@Test   
	@Parameters({"browser"})  
	public void aapVerifyProspectProfileFilter(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Verify Prospect Profile Filter Inquiries Count ["+browserName+"]");
		//prospect_profile = 
//		ExtentTestManager.getTest().pass("AAP_Verify Prospect Profile Filter Inquiries Count ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for filters in [Prospect Profile]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_HoverImmersiveHoverPanelSmallStaticSize ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify Prospect Profile Filter Inquiries Count ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		filterPage.verifyProspectProfileFilter();
		filterPage.clickProspectProfileFilter();
		filterPage.verifySubfilterOfProspectProfileFilter("Intended Level of Study");
		filterPage.verifySubfilterOfProspectProfileFilter("Entry Term");
		filterPage.verifySubfilterOfProspectProfileFilter("Intended Major");
		filterPage.verifySubfilterOfProspectProfileFilter("GPA");
		filterPage.verifySubfilterOfProspectProfileFilter("Test Scores");
		
		//=================Intended Level of Study==================//
		
		filterPage.clickIntendedLevelofStudySubFilterOfProspectProfile();
		filterPage.verifySubfilterOfIntendedLevelofStudyFilter("Any");
		filterPage.verifySubfilterOfIntendedLevelofStudyFilter("Undergraduate");
		filterPage.verifySubfilterOfIntendedLevelofStudyFilter("Graduate");
		
		filterPage.selectSubfilterOfIntendedLevelofStudyFilter("Undergraduate");
		filterPage.verifyNumOfInquiries("Intended Level of Study", "level_of_study", "undergraduate", browserName);
		filterPage.selectSubfilterOfIntendedLevelofStudyFilter("Undergraduate");
		filterPage.selectSubfilterOfIntendedLevelofStudyFilter("Graduate");
		filterPage.verifyNumOfInquiries("Intended Level of Study", "level_of_study", "graduate", browserName);
		filterPage.selectSubfilterOfIntendedLevelofStudyFilter("Any");
		filterPage.clickIntendedLevelofStudySubFilterOfProspectProfile();
		
		//=================Entry Term==================//
		//filterPage.clickResetFiltersButton();
		page.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		page.waitForInsightsPageToLoad();
		filterPage.scrollToProspectProfileFilter();
		filterPage.verifyProspectProfileFilter();
		filterPage.clickEntryTermSubFilterOfProspectProfile();
		filterPage.verifySubfilterOfEntryTermFilter("Any");
		filterPage.verifySubfilterOfEntryTermFilter("Term-Year");
		filterPage.verifySubfilterOfEntryTermFilter("Term");
		filterPage.verifySubfilterOfEntryTermFilter("Year");
		
		filterPage.selectSubfilterOfEntryTermFilter("Term-Year");
		filterPage.typeTermYearTxtBxOfEntryTermFilter("Fall 2023");
		filterPage.clickTermYearTxtBxAutofill();
		filterPage.verifyNumOfInquiries("Term-Year", "entry_term_year", "fall 2023", browserName);
		filterPage.clickTermYearTxtBxAutofill();
		filterPage.selectSubfilterOfEntryTermFilter("Term");
		filterPage.selectSubfilterOfTermFilter("Fall");
		filterPage.verifyNumOfInquiries("Term", "entry_term", "fall", browserName);
		filterPage.selectSubfilterOfEntryTermFilter("Year");
		filterPage.selectSubfilterOfEntryTermFilter("Any");
		filterPage.clickEntryTermSubFilterOfProspectProfile();
		
		//=================Intended Major==================//

		filterPage.clickIntendedMajorSubFilterOfProspectProfile();
		filterPage.verifyintendedMajorSearchTxtBx();
		filterPage.typeIntendedMajorSearchTxtBx("Sociology");
		filterPage.selectAutofillOnIntendedMajorSearchTxtBx("Sociology");
		filterPage.verifyNumOfInquiries("Intended Major", "major_intended", "Sociology", browserName);
		filterPage.selectAutofillOnIntendedMajorSearchTxtBx("Sociology");
		filterPage.clickIntendedMajorSubFilterOfProspectProfile();
		
		//=================GPA==================//
		
		filterPage.clickGPASubFilterOfProspectProfile();
		filterPage.verifySubfilterOfGPAFilter("Any");
		filterPage.verifySubfilterOfGPAFilter("Specific GPA Range");
//--//		
		filterPage.selectSubfilterOfGPAFilter("Specific GPA Range");
		filterPage.scrollToSetSpecifiGPAFilterStartRange("0.3");
		page.waitForInsightsPageToLoad();
		filterPage.selectSubfilterOfGPAFilter("Any");
		filterPage.clickGPASubFilterOfProspectProfile();	

		//=================Test Scores==================//
		
		filterPage.clickTestScoresSubFilterOfProspectProfile();
		filterPage.verifySubfilterOfTestScoresFilter("Any");
		filterPage.selectSubfilterOfTestScoresFilter("SAT");
		filterPage.selectSubfilterOfTestScoresFilter("ACT");
		filterPage.selectSubfilterOfTestScoresFilter("SAT or ACT");
		filterPage.selectSubfilterOfTestScoresFilter("SAT and ACT");
		filterPage.clickTestScoresSubFilterOfProspectProfile();
	}
	
	@Test   
	@Parameters({"browser"}) 
	public void aapVerifyLocationsFilters(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Verify Locations Filter Count ["+browserName+"]");
		//locations = 
//		ExtentTestManager.getTest().pass("AAP_Verify Locations Filter Count ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Filter Count for filters in [Locations]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Verify Locations Filter Count ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify Locations Filter Count ["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		filterPage.clickLocationsMainFilter();
		filterPage.verifySubfilterOfLocationsFilter("ALL");
		filterPage.verifySubfilterOfLocationsFilter("VT");
		filterPage.verifySubfilterOfLocationsFilter("IWC");
		
		filterPage.selectSubfilterInLocationsFilter("VT");
		filterPage.selectSubfilterInLocationsFilter("IWC");
		filterPage.selectSubfilterInLocationsFilter("ALL");
	}
	
	@Test   
	@Parameters({"browser"})  
	public void aapVerifyExplorePageColumnAndFieldConfiguration(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Verify Explore Page Column And Field Configuration ["+browserName+"]");
		//explorepage_col_fieldconfig = 
//		ExtentTestManager.getTest().pass("AAP_Verify Explore Page Column And Field Configuration ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify checked and unchecked fields in Explore Page Column And Field Configuration", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Verify Explore Page Column And Field Configuration ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify Explore Page Column And Field Configuration ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		String[] checkedList={"Name","Intended Major","Visitor Type","Entry Term","State","Country","Date Registered"};
		String[] uncheckedList={"Gender","Ethnicity","Relative Engagement","Schedule Visit CTA Clicked","Apply Now CTA Clicked",
				"Date Last Visited My Institution","City", "Date of Birth","Date Last Active in EAB\'s Network","SAT","ACT","GPA",
				"Phone","Email","School Name","Postal Code","Level of Study","Location Registered","Guardian Name", "Guardian Email", "Guardian Phone"};
		
		explorePage.clickConfigurationSettingsButton();
		explorePage.clickRevertToDefaultButton();
		//explorePage.clickApplyButton();
		//explorePage.clickConfigurationSettingsButton();	
		explorePage.verifyColumnNamesWithCheckkBoxesChecked();
		explorePage.verifyColumnNamesWithUncheckkBoxesChecked();
		explorePage.verifyCheckedColumnNameList(checkedList);
		explorePage.verifyUnCheckedColumnNameList(uncheckedList);
		explorePage.verifyRevertToDefaultButtonDisplayed();
		explorePage.verifyApplyButtonDisplayed();
		explorePage.verifyCancelButtonDisplayed();
		explorePage.verifyUnCheckedColumNamesGotChecked(uncheckedList, "City");
		explorePage.clickApplyButton();
		
		//============Profile Details==================//
		explorePage.clickFirstRowOnInquiriesList();
		explorePage.clickFieldConfigurationSettingsIcon();
		explorePage.verifyRevertToDefaultButtonDisplayed();
		explorePage.clickRevertToDefaultButton();
		String[] fieldConfigurationCheckedList={"Contact","First Name","Last Name","Email","Phone Number","Location","Country","State",
				"City","Postal Code","Demographic","Date of Birth","Gender","Ethnicity","Academic","Intended Level of Study",
				"Intended Entry Term","Intended Major","Current/Recent School","Date Registered","Location Registered","Score","SAT",
				"ACT","GPA (u/w)"};
		explorePage.verifyFieldConfigurationCheckedList(fieldConfigurationCheckedList);
		explorePage.clickFieldConfigurationColumnNameChkBx("Score");
		explorePage.clickFieldConfigurationColumnNameChkBx("Academic");
		explorePage.clickApplyButton();
		page.scrollToTop();
		explorePage.clickFieldConfigurationSettingsIcon();
		explorePage.clickRevertToDefaultButton();
		explorePage.clickApplyButton();
		page.scrollToTop();
		explorePage.clickFieldConfigurationSettingsIcon();
		page.waitForInsightsPageToLoad();
		explorePage.clickCancelButton();		
	}
	
	@Test   
	@Parameters({"browser"}) 
	public void aapVerifyListPageColumnAndFieldConfiguration(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("AAP_Verify List Page Column And Field Configuration ["+browserName+"]");
		//listpage_col_fieldconfig = 
//		ExtentTestManager.getTest().pass("AAP_Verify List Page Column And Field Configuration ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify checked and unchecked fields in List Page Column And Field Configuration", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Verify List Page Column And Field Configuration ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify List Page Column And Field Configuration ["+browserName+"]", ExtentColor.RED));
		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
//==SS		
		page.waitForInsightsPageToLoad();
		listPage.addColumnNamesForHrizontalScrollBar();
		listPage.scrollHorizontalLeft();
//==EE		
		page.waitForInsightsPageToLoad();
		listPage.clickAddToListButton();
		listPage.clickCreateNewRadioButton();
		String newListName = page.getDynamicNameString();
		listPage.typeNewListNameTxtBxOfAddToList(newListName);
		listPage.clickAddToListButtonOnAddToList();
		listPage.clickListTab();
		listPage.verifyInquirerNameListedOnInquiries(newListName);
		listPage.clickInquirerNameFromInquiriesList(newListName);
		String[] checkedList={"Name","Intended Major","Visitor Type","Entry Term","State","Country","Date Registered"};
		String[] uncheckedList={"Gender","Ethnicity","Relative Engagement","Schedule Visit CTA Clicked","Apply Now CTA Clicked",
				"City","Date Last Visited My Institution","Date of Birth","Date Last Active in EAB\'s Network",
				"SAT","ACT","GPA","Phone","Email","School Name","Postal Code","Level of Study"}; // , "Location Registered"};
		
		listPage.clickConfigurationSettingsButton();
		listPage.clickRevertToDefaultButton();
		
		listPage.verifyColumnNamesWithCheckedBoxesChecked();
		listPage.verifyColumnNamesWithUncheckedBoxesChecked();
		listPage.verifyCheckedColumnNameList(checkedList);
		listPage.verifyUnCheckedColumnNameList(uncheckedList);
		listPage.verifyRevertToDefaultButtonDisplayed();
		listPage.verifyApplyButtonDisplayed();
		listPage.verifyCancelButtonDisplayed();
		listPage.verifyUnCheckedSpecificColumName(uncheckedList, "City");
		listPage.clickApplyButton();
		
		listPage.verifyListTabPresence();
		listPage.clickListTab();
		listPage.clickInquirerNameFromInquiriesList(newListName);
		
		listPage.clickFirstRowOnInquiriesList();
		listPage.clickFieldConfigurationSettingsIcon();
		listPage.verifyRevertToDefaultButtonDisplayed();
		listPage.clickRevertToDefaultButton();
		String[] fieldConfigurationCheckedList={"Contact","First Name","Last Name","Email","Phone Number","Location","Country","State",
				"City","Postal Code","Demographic","Date of Birth","Gender","Ethnicity","Academic","Intended Level of Study",
				"Intended Entry Term","Intended Major","Current/Recent School","Date Registered","Location Registered","Score","SAT",
				"ACT","GPA (u/w)"};
		listPage.verifyFieldConfigurationCheckedList(fieldConfigurationCheckedList);
		listPage.clickFieldConfigurationColumnNameChkBx("Score");
		listPage.clickFieldConfigurationColumnNameChkBx("Academic");
		listPage.clickApplyButton();
		page.scrollToTop();
		listPage.clickFieldConfigurationSettingsIcon();
		listPage.clickRevertToDefaultButton();
		listPage.clickApplyButton();
		page.scrollToTop();
		listPage.clickFieldConfigurationSettingsIcon();
		listPage.clickCancelButton();
		listPage.clickListTab();
		page.waitForInsightsPageToLoad();
		//===============Delete the list===============//
		filterPage.deleteCreatedListNameInLisTab(newListName);
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifySearchOnInquiriesList(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_VerifySearchOnInquiriesList ["+browserName+"]");
		//search = 
//		ExtentTestManager.getTest().pass("AAP_VerifySearchOnInquiriesList ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("VerifySearchOnInquiriesList", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_VerifySearchOnInquiriesList ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_VerifySearchOnInquiriesList ["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");
		
		//==============Explore Search=======================
		explorePage.verifyExploreSearchTxtBx();
		explorePage.typeExploreSearchTxtBx("Sha");
		explorePage.verifyXbuttonOnExploreSearchTxtBx();
		explorePage.pressEnterOnExploreSearchTxtBx();
		explorePage.verifyXbuttonOnExploreSearchTxtBx();
		explorePage.clickXButtonOnExploreSearchTxtBx();
		explorePage.typeExploreSearchTxtBx("Mor");
		explorePage.clickXButtonOnExploreSearchTxtBx();
		
		//==============Explore Add to List Modal search======
		explorePage.clickAddToListButton();
		explorePage.verifyExploreAddToListSearchTxtBx();
		explorePage.typeExploreAddToListSearchTxtBx("Test");
		explorePage.verifyXbuttonOnExploreAddToListSearchTxtBx();
		explorePage.pressEnterOnExploreAddToListSearchTxtBx();
		explorePage.verifyXbuttonOnExploreAddToListSearchTxtBx();
		explorePage.clickXButtonOnExploreAddToListSearchTxtBx();
		explorePage.typeExploreAddToListSearchTxtBx("New");
		explorePage.pressEnterOnExploreAddToListSearchTxtBx();
		explorePage.clickCancelButton();	
		
		//==============List Page Search====================
		listPage.clickListTab();
		listPage.verifyListSearchTxtBx();
		listPage.typeListSearchTxtBx("Test");
		listPage.verifyXbuttonOnListSearchTxtBx();
		listPage.clickXButtonOnListSearchTxtBx();
		listPage.pressEnterOnListSearchTxtBx();
		listPage.typeListSearchTxtBx("New");
		listPage.pressEnterOnListSearchTxtBx();
		listPage.verifyXbuttonOnListSearchTxtBx();
		listPage.clickXButtonOnListSearchTxtBx();
		
		//==============List Page Individual Inquiry list Search===========
		listPage.clickFirstRowOnInquiriesList();
		listPage.verifyInquiriesSearchTxtBx();
		listPage.typeInquiriesSearchTxtBx("Sha");
		listPage.verifyXbuttonOnListSearchTxtBx();
		listPage.pressEnterOnInquiriesSearchTxtBx();
		listPage.verifyXbuttonOnListSearchTxtBx();
		listPage.clickXButtonOnListSearchTxtBx();
		listPage.verifyInquiriesSearchTxtBx();
		listPage.typeInquiriesSearchTxtBx("Mor");
		listPage.pressEnterOnInquiriesSearchTxtBx();
		listPage.verifyInquiriesSearchTxtBx();
		listPage.verifyXbuttonOnListSearchTxtBx();
		listPage.clickXButtonOnListSearchTxtBx();
		
		//==============List Page Individual Inquiry Add to List Modal Search===========
		listPage.clickAddToListButton();
		listPage.verifyListAddToListSearchTxtBx();
		listPage.typeListAddToListSearchTxtBx("Test");
		listPage.verifyXbuttonOnListAddToListSearchTxtBx();
		listPage.pressEnterOnListAddToListSearchTxtBx();
		listPage.verifyXbuttonOnListAddToListSearchTxtBx();
		listPage.clickXButtonOnListAddToListSearchTxtBx();
		listPage.typeListAddToListSearchTxtBx("New");
		listPage.pressEnterOnListAddToListSearchTxtBx();
		listPage.clickCancelButton();		
	}
	
	@Test   
	@Parameters({"browser"})
	public void aapVerifySortingInquiriesListList(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("AAP_Verify Sorting Inquiries List ["+browserName+"]");
		//sorting = 
//		ExtentTestManager.getTest().pass("AAP_Verify Sorting Inquiries List ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Sorting Inquiries Lis", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "AAP_Verify Sorting Inquiries List ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("AAP_Verify Sorting Inquiries List ["+browserName+"]", ExtentColor.RED));

		
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass("Logged in to application and navigated to Experience Insight page");
		
		ExtentTestManager.getTest().pass("Select institution as "+Constants.univName);
		insightPage.verifyProfileIcon();
		insightPage.clickProfileIcon();
		ExtentTestManager.getTest().pass("Profile icon is displayed and Clicked on it");
		insightPage.selectInstitutionName(Constants.univName, browserName);
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		ExtentTestManager.getTest().pass("Modified the recency filter to 365 days, Since no results available for 7 days");
		Assert.assertTrue(insightPage.verifyDownloadButton(), "Download button is not enabled");

		String columnName = "Name";
		String firstItemDec = null;
		String lastItemDec = null;
		String firstItemAsc = null;
		String lastItemAsc = null;
		
		filterPage.clickColumnNameOnInquiriesList(columnName);
		if(filterPage.totalNumberOfInquiries()>10) {
			filterPage.verifyfirstRowFirstCellOnInquiriesTablePresence();
			page.waitForInsightsPageToLoad();
			firstItemDec = filterPage.getfirstRowFirstCellText();
			System.out.println("firstItemDec :"+firstItemDec);	
			filterPage.clickPreviousPageButton();
			page.waitForInsightsPageToLoad();
			lastItemDec = filterPage.getlastRowFirstCellText();
			System.out.println("lastItemDec :"+lastItemDec);
			filterPage.clickNextPageButton();
			filterPage.clickColumnNameOnInquiriesList(columnName);
			page.waitForInsightsPageToLoad();
			firstItemAsc = filterPage.getfirstRowFirstCellText();
			System.out.println("firstItemDec :"+firstItemDec);	
			filterPage.clickPreviousPageButton();
			page.waitForInsightsPageToLoad();
			lastItemAsc = filterPage.getlastRowFirstCellText();
			System.out.println("lastItemDec :"+lastItemDec);
		}else if(filterPage.totalNumberOfInquiries()>2) {
			filterPage.verifyfirstRowFirstCellOnInquiriesTablePresence();
			firstItemDec = filterPage.getfirstRowFirstCellText();
			System.out.println("firstItemDec :"+firstItemDec);	
			lastItemDec = filterPage.getlastRowFirstCellText();
			System.out.println("lastItemDec :"+lastItemDec);
			filterPage.clickColumnNameOnInquiriesList(columnName);
			filterPage.verifyfirstRowFirstCellOnInquiriesTablePresence();
			firstItemAsc = filterPage.getfirstRowFirstCellText();
			System.out.println("firstItemDec :"+firstItemDec);
			lastItemAsc = filterPage.getlastRowFirstCellText();
			System.out.println("lastItemDec :"+lastItemDec);			
		}
		System.out.println("firstItemAsc("+firstItemAsc+") = lastItemDec("+lastItemDec+")");
		System.out.println("lastItemAsc("+lastItemAsc+") = firstItemDec("+firstItemDec+")");
		if(filterPage.totalNumberOfInquiries()<=1) {
			System.out.println("Insufficient inquiries to perform sorting For Column name ["+columnName+"]");
			ExtentTestManager.getTest().pass("Insufficient inquiries to perform sorting For Column name ["+columnName+"]");
		}else if(firstItemAsc.equalsIgnoreCase(lastItemDec) && lastItemAsc.equalsIgnoreCase(firstItemDec)) {
			System.out.println("For Column name ["+columnName+"] sorting funtionality is working");
			ExtentTestManager.getTest().pass("For Column name ["+columnName+"] sorting funtionality is working");
		}else {
			System.err.println("For Column name ["+columnName+"] sorting funtionality is not working");
			ExtentTestManager.getTest().fail("For Column name ["+columnName+"] sorting funtionality is working");
		}
	}
}