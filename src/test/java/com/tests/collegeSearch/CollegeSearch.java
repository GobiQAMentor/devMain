package com.tests.collegeSearch;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.pages.Page;
import com.pages.collegeSearch.CollegeSearchPage;
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.desktopRegistrationLegacyForm.DesktopRegistrationLegacyFormPage;
import com.pages.embedCode.EmbedCodeLoginPage;
import com.pages.mobileCIF.MobileCifPage;
import com.tests.BaseTest;

public class CollegeSearch extends BaseTest
{
	String url;
	CollegeSearchPage collegeSearchPage = null;
	OtherPage collegeSearchProspectivePage = null;
	DesktopCIFLoginPage collegeSearchOptionsPage= null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	ParentAndGuardianPage parentAndGuardianPage = null;
	Page page = null;
	DesktopCIFLoginPage prospectiveFormPage = null;
	OtherPage otherPage = null;
	MobileCifPage collegeSearchCifLogin = null;
	DesktopRegistrationLegacyFormPage registrationLegacyFormPage = null;
	EmbedCodeLoginPage loginPage = null;
	@BeforeClass
	public void classSetUp() throws Exception
	{
		url = prop.getProperty("staging_env")+prop.getProperty("college_search");
		collegeSearchPage = new CollegeSearchPage(remoteDriver);
		collegeSearchProspectivePage = new OtherPage(remoteDriver);
		collegeSearchOptionsPage = new DesktopCIFLoginPage(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		parentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
		page = new Page(remoteDriver);
		prospectiveFormPage = new DesktopCIFLoginPage(remoteDriver);
		otherPage = new OtherPage(remoteDriver);
		registrationLegacyFormPage = new DesktopRegistrationLegacyFormPage(remoteDriver);
		collegeSearchCifLogin = new MobileCifPage(remoteDriver);
		loginPage = new EmbedCodeLoginPage(remoteDriver);
	}
	@Test   
	@Parameters({"browser"})
	public void TC5_CollegeSearchVerifyContinueWithGoogleOption(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithGoogleLink();
		ExtentTestManager.getTest().pass("Continue with google link is clicked");
		collegeSearchPage.enterGmailCredentialAndLogin();
		ExtentTestManager.getTest().pass("Gmail account is logged in");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		collegeSearchOptionsPage.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("Are you a lable is verified");
		collegeSearchOptionsPage.verifyProspectiveStudentButton();
		ExtentTestManager.getTest().pass("Prospective student button is verified");
		collegeSearchOptionsPage.verifyParentGuardianButton();
		ExtentTestManager.getTest().pass("Parent button is verified");
		collegeSearchOptionsPage.verifyOtherButton();
		ExtentTestManager.getTest().pass("Other button is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC1_VerifyCollegeSearchProspectiveStudentButtonOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		Map<String, String> setData = otherPage.setData();
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithEmailLink();
		ExtentTestManager.getTest().pass("Continue with email link is clicked");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		collegeSearchOptionsPage.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("Are you a lable is verified");
		collegeSearchOptionsPage.verifyProspectiveStudentButton();
		ExtentTestManager.getTest().pass("Prospective student button is verified");
		collegeSearchOptionsPage.verifyParentGuardianButton();
		ExtentTestManager.getTest().pass("Parent button is verified");
		collegeSearchOptionsPage.verifyOtherButton();
		ExtentTestManager.getTest().pass("Other button is verified");
		collegeSearchOptionsPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		collegeSearchProspectivePage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the ProspectiveStudentOptions Page");
		prospectiveStudentPage.mouseHoverHighSchoolGraduateButton();
		ExtentTestManager.getTest().pass("HighSchoolGraduateButton displayed on the ProspectiveStudentOptions page");
		prospectiveStudentPage.mouseHoverProspectiveStudentAdultLearnerButton();
		ExtentTestManager.getTest().pass("AdultLearnerButton displayed on the ProspectiveStudentOptions Page");
		prospectiveStudentPage.mouseHoverProspectiveStudentCollegeGraduateButton();
		ExtentTestManager.getTest().pass("StudentCollegeGraduateButton displayed on the ProspectiveStudentOptions Page");
		prospectiveStudentPage.mouseHoverProspectiveStudentCollegeStudentButton();
		ExtentTestManager.getTest().pass("CollegeStudentButton displayed on the ProspectiveStudentOptions Page");
		prospectiveStudentPage.mouseHoverProspectiveStudentHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("HighSchoolStudentButton displayed on the ProspectiveStudentOptions Page");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		collegeSearchPage.clickEnterButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		collegeSearchPage.clickEnterButton();
		collegeSearchPage.verifySelectUpTo10CollegesHeader();
		collegeSearchPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("SChool names are entered");
		collegeSearchPage.clickEnterButton();
		prospectiveStudentPage.verifyWhereAreYouFromLabel();
		ExtentTestManager.getTest().pass("Where are You Work Label is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		collegeSearchPage.verifyYouDisItMessage();
		ExtentTestManager.getTest().pass("You did it Message is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC2_VerifyCollegeSearchParentButtonOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		Map<String, String> setData = otherPage.setData();
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithEmailLink();
		ExtentTestManager.getTest().pass("Continue with email link is clicked");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		collegeSearchOptionsPage.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("Are you a lable is verified");
		parentAndGuardianPage.clickParentGuardianButton();
		ExtentTestManager.getTest().pass("ParentGuardianButton is clicked");
		collegeSearchPage.mouseHoverHighSchoolGraduateButton();
		ExtentTestManager.getTest().pass("HighSchoolGraduateButton displayed on the Parent page");
		parentAndGuardianPage.mouseHoverParentGuardianCollegeStudentButton();
		ExtentTestManager.getTest().pass("ParentGuardianCollegeStudentButton displayed on the Parent Page");
		parentAndGuardianPage.mouseHoverParentGuardianHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ParentHighSchoolStudentButton displayed on the Parent page");
		parentAndGuardianPage.clickParentGuardianHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("parent_guardian_high_school_student_button is clicked");
		registrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		registrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		collegeSearchPage.clickEnterButton();
		collegeSearchCifLogin.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		collegeSearchPage.enterChildEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		collegeSearchPage.clickEnterButton();
		collegeSearchPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		collegeSearchPage.clickEnterButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		collegeSearchPage.verifyYouDisItMessage();
		ExtentTestManager.getTest().pass("You did it Message is verified");
		}

	@Test   
	@Parameters({"browser"})
	public void TC3_VerifyCollegeSearchOtherButtonOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		Map<String, String> setData = otherPage.setData();
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithEmailLink();
		ExtentTestManager.getTest().pass("Continue with email link is clicked");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		collegeSearchOptionsPage.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("Are you a lable is verified");
		collegeSearchProspectivePage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		collegeSearchProspectivePage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		collegeSearchProspectivePage.mouseHoverCounselorButton();
		collegeSearchProspectivePage.verifyCounselorButton();
		ExtentTestManager.getTest().pass("Counselor button displayed on the Registration page");
		collegeSearchProspectivePage.mouseHoverAlumnusButton();
		collegeSearchProspectivePage.verifyAlumnusButton();
		ExtentTestManager.getTest().pass("Alumnus button displayed on the Registration page");
		collegeSearchProspectivePage.mouseHoverCurrentStudentButton();
		collegeSearchProspectivePage.verifyCurrentStudentButton();
		ExtentTestManager.getTest().pass("Current Student button displayed on the Registration page");
		collegeSearchProspectivePage.mouseHoverFacultyButton();
		collegeSearchProspectivePage.verifyFacultyButton();
		ExtentTestManager.getTest().pass("Faculty button displayed on the Registration page");
		collegeSearchProspectivePage.mouseHoverGeneralVisitorButton();
		collegeSearchProspectivePage.verifyGeneralVisitorButton();
		ExtentTestManager.getTest().pass("General Visitor button displayed on the Registration page");
		otherPage.clickCounselorButton();
		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		otherPage.enterEmail(setData.get("EmailID"));		
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		
		collegeSearchPage.clickEnterButton();
		ExtentTestManager.getTest().pass("Enter button is clicked");
		collegeSearchPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		collegeSearchPage.clickEnterButton();
		prospectiveStudentPage.verifyWhereDoYouWorkLabel();
		ExtentTestManager.getTest().pass("WhereDoYouWorkLabel is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Postal code is entered");
		collegeSearchPage.clickEnterButton();
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		collegeSearchPage.verifyYouDisItMessage();
		ExtentTestManager.getTest().pass("You did it Message is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC4_VerifyCollegeSearchButton(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.enterCollegeOrUniversity();
		ExtentTestManager.getTest().pass("College or University is entered");
		page.waitForInsightsPageToLoad();
		collegeSearchPage.verifySearchedCollegeOrUniversityResult();
		collegeSearchPage.verifTopMostVisitedCollegesHeader();
		ExtentTestManager.getTest().pass("Top most visited colleges header is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC6_VerifyCollegeSearchLeftSideOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyInstitutionHeader();
		ExtentTestManager.getTest().pass("Institution header is verified");
		collegeSearchPage.verifyLikesHeader();
		ExtentTestManager.getTest().pass("Likes header is verified");
		collegeSearchPage.verifyTuitionHeader();
		ExtentTestManager.getTest().pass("Tuition header is verified");
		collegeSearchPage.clickInstitutionTypeAllCheckbox();
		ExtentTestManager.getTest().pass("InstitutionTypeAllCheckbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");

	}

	@Test   
	@Parameters({"browser"})
	public void TC7_VerifyCollegeSearchFilterOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyInstitutionHeader();
		ExtentTestManager.getTest().pass("Institution header is verified");		
		collegeSearchPage.verifyTuitionHeader();
		ExtentTestManager.getTest().pass("Tuition header is verified");
		collegeSearchPage.verifyGeographyHeader();
		ExtentTestManager.getTest().pass("Geography header is verified");
		collegeSearchPage.clickInstitutionTypeAllCheckbox();
		ExtentTestManager.getTest().pass("Institution Type All Checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("Reset Button is verified");
		collegeSearchPage.clickInstitutionTypeAllCheckbox();
		ExtentTestManager.getTest().pass("Institution Type All Checkbox is clicked");
		page.waitForInsightsPageToLoad();		
		//collegeSearchPage.verifyResetButtonIsnotVisible();	
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickInstitutionYearAllCheckbox();
		ExtentTestManager.getTest().pass("Institution Year All Checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionYearAllCheckbox();
		ExtentTestManager.getTest().pass("Institution year All Checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickInstitutionCampusSettingsAllCheckbox();
		ExtentTestManager.getTest().pass("Institution Campus settings All Checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionYearAllCheckbox();
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		ExtentTestManager.getTest().pass("Institution campus settings All Checkbox is clicked");
		collegeSearchPage.verifyEnrollmentHeader();
		ExtentTestManager.getTest().pass("Enrollment header is verified");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
	}
	@Test   
	@Parameters({"browser"})
	public void TC8_VerifyCollegeSearchCollapseAndUncollapseSideBar(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickLeftArrowIcon();
		ExtentTestManager.getTest().pass("Left side arrow is clicked");
		collegeSearchPage.verifyLeftSideFunnelIcon();
		ExtentTestManager.getTest().pass("Left side funnel is verified");
		collegeSearchPage.clickLeftSideFunnelIcon();
		ExtentTestManager.getTest().pass("Left side funnel is clicked");
		collegeSearchPage.verifyLeftArrowIcon();
		ExtentTestManager.getTest().pass("Left side arrow is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC9_VerifyCollegeSearchInstitutionTypeOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyInstitutionHeader();
		ExtentTestManager.getTest().pass("Institution header is verified");
		collegeSearchPage.clickInstitutionTypePublicCheckbox();
		ExtentTestManager.getTest().pass("Institution type public checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionTypePublicCheckbox();
		ExtentTestManager.getTest().pass("Institution type public checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();	
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickInstitutionTypePrivateCheckbox();
		ExtentTestManager.getTest().pass("Institution type private checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionTypePrivateCheckbox();
		ExtentTestManager.getTest().pass("Institution type private checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
	}
	@Test   
	@Parameters({"browser"})
	public void TC10_VerifyCollegeSearchInstitutionYearsOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyInstitutionHeader();
		ExtentTestManager.getTest().pass("Institution header is verified");
		collegeSearchPage.clickInstitutionTypeTwoYearOptionCheckbox();
		ExtentTestManager.getTest().pass("Institution type two year checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionTypeTwoYearOptionCheckbox();
		ExtentTestManager.getTest().pass("Institution type two year checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickInstitutionTypeFourYearOptionCheckbox();
		ExtentTestManager.getTest().pass("Institution type four year checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickInstitutionTypeFourYearOptionCheckbox();
		ExtentTestManager.getTest().pass("Institution type four year checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
	}

	@Test   
	@Parameters({"browser"})
	public void TC11_VerifyCollegeSearchCampusSettingsOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyInstitutionHeader();
		ExtentTestManager.getTest().pass("Institution header is verified");
		collegeSearchPage.clickCampusSettingsRuralCheckbox();
		ExtentTestManager.getTest().pass("Campus settings rural checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickCampusSettingsRuralCheckbox();
		ExtentTestManager.getTest().pass("Campus settings rural checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickCampusSettingsSuburbCheckbox();
		ExtentTestManager.getTest().pass("Campus settings suburb checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickCampusSettingsSuburbCheckbox();
		ExtentTestManager.getTest().pass("Campus settings suburb checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickCampusSettingsTownCheckbox();
		ExtentTestManager.getTest().pass("Campus settings town checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickCampusSettingsTownCheckbox();
		ExtentTestManager.getTest().pass("Campus settings town checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();	
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickCampusSettingsCityCheckbox();
		ExtentTestManager.getTest().pass("Campus settings city checkbox is clicked");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickCampusSettingsCityCheckbox();
		ExtentTestManager.getTest().pass("Campus settings city checkbox is clicked");
		//collegeSearchPage.verifyResetButtonIsnotVisible();	
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickEnrollmentField();
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");	
	}

	@Test   
	@Parameters({"browser"})
	public void TC12_VerifyCollegeSearchTuitionFieldOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.clickAndChangeTheTuitionInstateField();
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickAndChangeTheTuitionInstateField();
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
		collegeSearchPage.clickAndChangeTheTuitionOutOfStatesField();
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.clickAndChangeTheTuitionOutOfStatesField();
		//collegeSearchPage.verifyResetButtonIsnotVisible();
		collegeSearchPage.verifyClearButton();
	}

	@Test   
	@Parameters({"browser"})
	public void TC13_VerifyCollegeSearchGeographyField(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.verifyGeographyHeader();
		ExtentTestManager.getTest().pass("Geography header is verified");
		collegeSearchPage.enterGeograoghyName();
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.verifyGeographyCount();
		ExtentTestManager.getTest().pass("Geography count is verified");
	}
	@Test   
	@Parameters({"browser"})
	public void TC14_VerifyCollegeSearchSelectAllAndClearButtons(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.verifyFiltersHeader();
		ExtentTestManager.getTest().pass("Filters header is verified");
		collegeSearchPage.clickAndVerifySelectAllButton();
		ExtentTestManager.getTest().pass("Select all button is verified");
		collegeSearchPage.verifyResetButton();
		ExtentTestManager.getTest().pass("ResetButton is verified");
		collegeSearchPage.verifyClearButton();
		
	}
	
	@Test   
	@Parameters({"browser"})
	public void verifyLikesField(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		Map<String, String> setData = otherPage.setData();
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithGoogleLink();
		ExtentTestManager.getTest().pass("Continue with google link is clicked");
		collegeSearchPage.enterGmailCredentialAndLogin();
		ExtentTestManager.getTest().pass("Gmail account is logged in");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		prospectiveFormPage.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		collegeSearchPage.clickEnterButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		collegeSearchPage.clickEnterButton();
		collegeSearchPage.verifySelectUpTo10CollegesHeader();
		collegeSearchPage.enterTheWhichSchoolDoYouWorkWithSchoolNames();
		ExtentTestManager.getTest().pass("Enter the school_name");
		collegeSearchPage.clickEnterButton();
		prospectiveStudentPage.verifyWhereAreYouFromLabel();
		ExtentTestManager.getTest().pass("Where are You Work Label is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickDoneButton();
		collegeSearchPage.clickLikeButtonAndCompareActualLikesResultWithLikedCollegeName();	
		collegeSearchPage.verifyLikedButton();
		collegeSearchPage.clickLikedButton();
		collegeSearchPage.verifyLikeButton();
	}
	
	@Test   
	@Parameters({"browser"})
	public void TC15_VerifyCollegeSearchTermsAndPolicyLinks(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		Map<String, String> setData = otherPage.setData();
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		collegeSearchPage.navigateCollegeSearchPage(url);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.verifyCollegeSearchHeader();
		ExtentTestManager.getTest().pass("College Search page header is verified");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithEmailLink();
		ExtentTestManager.getTest().pass("Continue with email link is clicked");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchPage.verifySignupToVisit1000SchoolHeader();
		ExtentTestManager.getTest().pass("Signup To Visit 1000 School Header is verified");
		collegeSearchOptionsPage.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("Are you a lable is verified");
		collegeSearchPage.verifyCaliforniaPrivacyNoticeLink();
		prospectiveFormPage.clickTermsOfUseLink();
		ExtentTestManager.getTest().pass("Terms of Use link is clicked");
		loginPage.switchToTheNewTab();
		ExtentTestManager.getTest().pass("Terms of Use Page opened on the new tab");
		prospectiveFormPage.verifyTermsOfUseHeader();
		collegeSearchPage.switchToTheTabWithCollegeSearcgUrl();
		collegeSearchPage.switchToTheVirtualtourFrame();
		prospectiveFormPage.clickPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("Privacy Policy link is clicked");
		loginPage.switchToTheNewTab();
		ExtentTestManager.getTest().pass("Privacy Policy Page opened on the new tab");
		prospectiveFormPage.switchToTheLastTab();
		prospectiveFormPage.goToMainTabCloseOtherTabs(browser);
		}
}