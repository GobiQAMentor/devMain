package com.tests.mobileRegistrationLegacyForm;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.desktopRegistrationLegacyForm.DesktopRegistrationLegacyFormPage;
import com.pages.mobileRegistrationLegacyForm.MobileRegistrationLegacyFormPage;
import com.tests.BaseTest;

public class MobileRegistrationLegacyFormTest extends BaseTest{
	String url;
	String urlVT;
	ObjectsControl objectControl = null;
	ProspectiveStudentPage mobileProspectiveStudentPage = null;
	MobileRegistrationLegacyFormPage mobileRegistrationLoginPage = null;
	DesktopCIFLoginPage mobileCifLogin = null;
	OtherPage mobileOtherPage = null;
	DesktopRegistrationLegacyFormPage mobileRegistrationLegacyFormPage = null;
	String urlVtNa;
	OtherPage mobileRegistrationOtherPage = null;
	ParentAndGuardianPage mobileParentAndGuardianPage = null;
	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_vt1");
		urlVT = prop.getProperty("env1")+prop.getProperty("url_vt");
		objectControl = new ObjectsControl(remoteDriver);
		mobileProspectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		mobileRegistrationLoginPage = new MobileRegistrationLegacyFormPage(remoteDriver);
		mobileCifLogin = new DesktopCIFLoginPage(remoteDriver);
		mobileOtherPage = new OtherPage(remoteDriver);
		mobileRegistrationLegacyFormPage = new DesktopRegistrationLegacyFormPage(remoteDriver);
		urlVtNa = prop.getProperty("env1")+prop.getProperty("url_vt");
		mobileRegistrationOtherPage = new OtherPage(remoteDriver);
		mobileParentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
	}

	@Test   
	@Parameters({"browser"})
	public void MRLF_TC01_VerifyHighSchoolStudentRegistrationWithValidData(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC01_VerifyHighSchoolStudentRegistrationWithValidData");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC01_VerifyHighSchoolStudentRegistrationWithValidData", ExtentColor.BLUE));
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");		
		mobileRegistrationLoginPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLink");
		mobileRegistrationLoginPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		mobileRegistrationLoginPage.clickHighSchoolStudentLink();
		ExtentTestManager.getTest().pass("Click on high_school_student_link");
		ExtentTestManager.getTest().pass("Prospective HighSchoolStudentButton is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void MRLF_TC02_RegisterAsStudentCollegeGraduateByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC02_RegisterAsStudentCollegeGraduateByFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_RegisterAsStudentCollegeGraduateByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVT);
		mobileRegistrationLoginPage.enableMotionBasedViewingForiosSafari(browser);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		mobileRegistrationLoginPage.clickCollageGraduateIcon();
		ExtentTestManager.getTest().pass("Click on Collage Graduate Icon");
		mobileRegistrationLoginPage.enterWhatSchoolDoYouAttend("Test");
		ExtentTestManager.getTest().pass("Enter the what_school_do_you_attend");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.enterPhoneField(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		mobileRegistrationLoginPage.selectStartYearField("2023");
		ExtentTestManager.getTest().pass("Start Year Field is entered");		
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}	

	@Test   
	@Parameters({"browser"})
	public void MRLF_TC03_RegisterAsFacultyOrStaff(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC03_RegisterAsFacultyOrStaff");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_RegisterAsFacultyOrStaff", ExtentColor.BLUE));
		Map<String, String> setData = mobileOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVT);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickFacultyOrStaffLink();
		ExtentTestManager.getTest().pass("Click on faculty_or_staff_link");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the faculty_first_name");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the faculty_last_name");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on faculty_get_started_button_id");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void MRLF_TC04_RegisterAsCounsellorByFillingValidDetailsInMandatoryFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC04_RegisterAsCounsellorByFillingValidDetailsInMandatoryFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("MRLF_TC04", ExtentColor.BLUE));
		Map<String, String> setData = mobileOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVT);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickCounselorLink();
		ExtentTestManager.getTest().pass("Click on clickCounselorLink");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter first_name");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the last_name");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button_id");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void MRLF_TC05_RegisterAsAlumniByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MRLF_TC05_RegisterAsAlumniByFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("MRLF_TC05_RegisterAsAlumniByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVT);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickAlumniLink();
		ExtentTestManager.getTest().pass("Click on clickAlumniLink");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter first_name");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the last_name");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button_id");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void MRLF_TC06_RegisterAsCurrentStudentByFillingValidDetailsInMandatoryFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MRLF_TC06_RegisterAsCurrentStudentByFillingValidDetailsInMandatoryFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("MRLF_TC06_RegisterAsCurrentStudentByFillingValidDetailsInMandatoryFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVT);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickCurrentStudentLink();
		ExtentTestManager.getTest().pass("Click on clickCurrentStudentLink");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter first_name");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the last_name");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button_id");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test  
	@Parameters({"browser"})
	public void MRLF_TC07_RegisterAsCurrentStudentByFillingValidDetailsInAllFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MRLF_TC07_RegisterAsCurrentStudentByFillingValidDetailsInAllFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("MRLF_TC07_RegisterAsCurrentStudentByFillingValidDetailsInAllFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		mobileRegistrationLoginPage.clickHighSchoolStudentLink();
		ExtentTestManager.getTest().pass("Click on high_school_student_link");
		mobileRegistrationLoginPage.enterWhatSchoolDoYouAttend("Test");
		ExtentTestManager.getTest().pass("Enter the what_school_do_you_attend");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test  
	@Parameters({"browser"})
	public void MRLF_TC08_RegisterAsStudentTransferStudenteByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MRLF_TC08_RegisterAsStudentTransferStudenteByFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Testcase no C16487", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		mobileRegistrationLoginPage.clickTransferStudentIcon();
		ExtentTestManager.getTest().pass("Click on Transfer Student Icon");
		mobileRegistrationLoginPage.enterWhatSchoolDoYouAttend("Test");
		ExtentTestManager.getTest().pass("Enter the what_school_do_you_attend");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EAB Main Page is verified");
	}

	@Test  
	@Parameters({"browser"})
	public void MRLF_TC09VerifyRegisterAsParentHighSchoolStudentByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MRLF_TC09_VerifyRegisterAsParentHighSchoolStudentByFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Testcase no C16489 and C16498", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		mobileRegistrationLoginPage.clickHighSchoolStudentLink();
		ExtentTestManager.getTest().pass("Click on high_school_student_link");
		mobileRegistrationLoginPage.enterWhatSchoolDoYouAttend("Test");
		ExtentTestManager.getTest().pass("Enter the what_school_do_you_attend");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test  
	@Parameters({"browser"})
	public void MRLF_TC10VerifyRegisterAsParentCollegeGraduateFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC10_VerifyRegisterAsParentCollegeGraduateFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC10_VerifyRegisterAsParentCollegeGraduateFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickParentButton();
		ExtentTestManager.getTest().pass("Click on ParentButton");
		mobileRegistrationLoginPage.clickCollageGraduateButton();
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test
	@Parameters({"browser"})
	public void MRLF_TC11_VerifyRegisterAsParentTransferStudentFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC11_VerifyRegisterAsParentTransferStudentFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC11_VerifyRegisterAsParentTransferStudentFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickParentButton();
		ExtentTestManager.getTest().pass("Click on ParentButton");
		mobileRegistrationLoginPage.clickParentTransferStudentIcon();
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}

	@Test  
	@Parameters({"browser"})
	public void MRLF_TC12_RegisterAsParentHighSchoolGraduateByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("MobileRegistrationLegacyForm_MRLF_TC12_RegisterAsParentHighSchoolGraduateByFillingValidDetailsInAllTheFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC12_RegisterAsParentHighSchoolGraduateByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		Map<String, String> setData = mobileRegistrationOtherPage.setData();
		mobileRegistrationLoginPage.navigateToMobileRegistrationLegacyFormurlVTPageLogin(urlVtNa);
		mobileRegistrationLoginPage.clickMobileStartButton();
		ExtentTestManager.getTest().pass("Click on mobile_start_button");
		mobileRegistrationLoginPage.clickIAmATextbox();
		ExtentTestManager.getTest().pass("Click on i_am_a_textbox_xpath");
		mobileRegistrationLoginPage.clickParentButton();
		ExtentTestManager.getTest().pass("Click on ParentButton");
		mobileRegistrationLoginPage.clickParentHighSchoolGraduateIcon();
		ExtentTestManager.getTest().pass("Click on ParentHighSchoolGraduateIcon");
		mobileRegistrationLoginPage.enterWhatSchoolDoYouAttend("Test");
		ExtentTestManager.getTest().pass("Enter the what_school_do_you_attend");
		mobileRegistrationLoginPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		mobileRegistrationLoginPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		mobileRegistrationLoginPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		mobileRegistrationLoginPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		mobileRegistrationLoginPage.clickCountryField();
		ExtentTestManager.getTest().pass("Country field is entered");
		mobileRegistrationLoginPage.enterStreetField();
		ExtentTestManager.getTest().pass("Street field is entered");
		mobileRegistrationLoginPage.enterZipCode();
		ExtentTestManager.getTest().pass("Zip code is entered");
		mobileRegistrationLoginPage.clickGetStartedButton();
		ExtentTestManager.getTest().pass("Click on get_started_button");
		mobileRegistrationLoginPage.verifyEABMainPage();
		ExtentTestManager.getTest().pass("EABMainPage is verified");
	}
}
