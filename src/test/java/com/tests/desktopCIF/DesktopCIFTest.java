package com.tests.desktopCIF;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.github.javafaker.Faker;
import com.pages.Page;
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.desktopRegistrationLegacyForm.DesktopRegistrationLegacyFormPage;
import com.pages.embedCode.EmbedCodeLoginPage;
import com.tests.BaseTest;
public class DesktopCIFTest extends BaseTest{
	String url;
	DesktopCIFLoginPage cifLogin = null;
	OtherPage otherPage = null;
	ParentAndGuardianPage parentAndGuardianPage = null;
	EmbedCodeLoginPage loginPage = null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	ObjectsControl objectControl = null;
	int completionBarValue = 0;
	Faker faker = new Faker();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String emailID = faker.name().firstName();
	DesktopRegistrationLegacyFormPage desktopRegistrationLegacyFormPage = null;
	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("staging_env")+prop.getProperty("url_cif");
		cifLogin = new DesktopCIFLoginPage(remoteDriver);
		otherPage = new OtherPage(remoteDriver);
		parentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
		loginPage = new EmbedCodeLoginPage(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		objectControl = new ObjectsControl(remoteDriver);
		desktopRegistrationLegacyFormPage = new DesktopRegistrationLegacyFormPage(remoteDriver);
	}
	@Test   
	@Parameters({"browser"})
	public void TC11OtherCounselorSchool(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("DesktopCIF-TC11_OtherCounselorSchool ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("DesktopCIF-TC11_OtherCounselorSchool");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC11_OtherCounselorSchool ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC11_OtherCounselorSchool ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		completionBarValue = 1;
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickCounselorButton();
		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		cifLogin.waitForInsightsPageToLoad();
		completionBarValue = cifLogin.verifyCompletionBarProgress(completionBarValue);
		otherPage.enterEmail(setData.get("EmailID"));		
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		cifLogin.waitForInsightsPageToLoad();
		completionBarValue = cifLogin.verifyCompletionBarProgress(completionBarValue);
		prospectiveStudentPage.verifyWhereDoYouWorkLabel();
		ExtentTestManager.getTest().pass("WhereDoYouWorkLabel is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		cifLogin.waitForInsightsPageToLoad();
		completionBarValue = cifLogin.verifyCompletionBarProgress(completionBarValue);
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		cifLogin.waitForInsightsPageToLoad();
		completionBarValue = cifLogin.verifyCompletionBarProgress(completionBarValue);
		otherPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC08_OtherAlumniName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC08_OtherAlumniName ["+browserName+"]");
		//		ExtentTestManager.getTest().assignCategory("DesktopCIF-TC08_OtherAlumniName");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC08_OtherAlumniName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC08_OtherAlumniName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		otherPage.clickAlumnusButton();
		ExtentTestManager.getTest().pass("Alumnus button is clicked");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC07_OtherCounselorName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC07_OtherCounselorName ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("DesktopCIF-TC07_OtherCounselorNam");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC07_OtherCounselorName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC07_OtherCounselorName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickCounselorButton();
		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		prospectiveStudentPage.verifyWhereDoYouWorkLabel();
		ExtentTestManager.getTest().pass("WhereDoYouWorkLabel is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC06_OtherFacultyName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC06_OtherFacultyName ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("DesktopCIF-TC06_OtherFacultyName[");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC06_OtherFacultyName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC06_OtherFacultyName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickFacultyButton();
		ExtentTestManager.getTest().pass("FacultyButton is clicked");
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.verifyPrivacyPolicyLink();
		otherPage.verifyTermsOfUseLink();
		otherPage.verifyAlmostDoneMessage();
		otherPage.verifyAlmostDoneMessageBar();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC05_OtherCurrentStudentName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIFTC05_OtherCurrentStudentName ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("DesktopCIFTC05_OtherCurrentStudentName");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIFTC05_OtherCurrentStudentName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIFTC05_OtherCurrentStudentName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickCurrentStudentButton();
		ExtentTestManager.getTest().pass("CurrentStudentButton is clicked");
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.verifyPrivacyPolicyLink();
		otherPage.verifyTermsOfUseLink();
		otherPage.verifyAlmostDoneMessage();
		otherPage.verifyAlmostDoneMessageBar();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC10_OtherGeneralVisitorName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC10_OtherGeneralVisitorName ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("DesktopCIF-TC10_OtherGeneralVisitorName");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC10_OtherGeneralVisitorName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC10_OtherGeneralVisitorName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickGeneralVisitorButton();
		ExtentTestManager.getTest().pass("GeneralVisitorButton is clicked");
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		otherPage.verifyPrivacyPolicyLink();
		otherPage.verifyTermsOfUseLink();
		otherPage.verifyAlmostDoneMessage();
		otherPage.verifyAlmostDoneMessageBar();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC22_CollageGraduateAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC22_P_CG_AdditionalInformation ["+browserName+"]");
		//		ExtentTestManager.getTest().assignCategory("TC22_P_CG_AdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC22_P_CG_AdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC22_P_CG_AdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianCollegeGraduateButton();
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//parentAndGuardianPage.enterNameOfTheChildsCollageGraduate();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC23_ParentGaurdianMiddleSchoolStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC23_ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC23_ParentGaurdianMiddleSchoolStudentAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC23_ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC23_ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianMiddleSchoolButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC19_ParentGuardianHSSAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC19_ParentGuardianHSSAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC19_ParentGuardianHSSAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC19_ParentGuardianHSSAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC19_ParentGuardianHSSAdditionalInformation["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		ExtentTestManager.getTest().pass("ParentGuardianButton is clicked");
		parentAndGuardianPage.clickParentGuardianHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("parent_guardian_high_school_student_button is clicked");
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//parentAndGuardianPage.enterNameOfTheChildsCollageGraduate();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC20_ParentGuardianHighSchoolGraduateAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC20_ParentGuardianHSGAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC20_ParentGuardianHSGAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC20_ParentGuardianHSGAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC20_ParentGuardianHSGAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianHighSchoolGraduateButton();
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//parentAndGuardianPage.enterNameOfTheChildsCollageGraduate();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC21_ParentGuardianCollageStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC21_P_CS_AdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC21_P_CS_AdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC21_P_CS_AdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC21_P_CS_AdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianCollegeStudentButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//parentAndGuardianPage.enterNameOfTheChildsCollageGraduate();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC01_WelcomePageVisitorType(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC01_WelcomePageVisitorType ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC01_WelcomePageVisitorType");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC01_WelcomePageVisitorType ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC01_WelcomePageVisitorType ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.verifyProspectiveStudentButton();
		cifLogin.verifyParentGuardianButton();
		cifLogin.verifyOtherButton();
		cifLogin.goToMainTabCloseOtherTabs(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void TC02_TermsConditionsOnWelcomePageUS(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC02_TermsConditionsOnWelcomePageUS ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC02_TermsConditionsOnWelcomePageUS");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC02_TermsConditionsOnWelcomePageUS ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_TermsConditionsOnWelcomePageUS ["+browserName+"]", ExtentColor.RED));

		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.verifyProspectiveStudentButton();
		cifLogin.verifyParentGuardianButton();
		cifLogin.verifyOtherButton();
		cifLogin.clickTermsOfUseLink();
		ExtentTestManager.getTest().pass("Terms of Use link is clicked");
		loginPage.switchToTheNewTab();
		ExtentTestManager.getTest().pass("Terms of Use Page opened on the new tab");
		cifLogin.verifyTermsOfUseHeader();
		cifLogin.switchToTheTabWithCIFUrl();
		otherPage.switchToTheVirtualtourFrame();
		cifLogin.verifyProspectiveStudentButton();
		cifLogin.clickPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("Privacy Policy link is clicked");
		loginPage.switchToTheNewTab();
		ExtentTestManager.getTest().pass("Privacy Policy Page opened on the new tab");
		cifLogin.switchToTheLastTab();
		cifLogin.goToMainTabCloseOtherTabs(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void TC09_OtherVeteranName(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC09_OtherVeteranName ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("DesktopCIF-TC09_OtherVeteranName");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC09_OtherVeteranName ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC09_OtherVeteranName ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		parentAndGuardianPage.clickVeteranButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC03_VisitorTypeOtherOptionsPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC03_03_VisitorType_OtherOptionsPage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC03_03_VisitorType_OtherOptionsPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC03_03_VisitorType_OtherOptionsPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_03_VisitorType_OtherOptionsPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.mouseHoverCounselorButton();
		otherPage.verifyCounselorButton();
		ExtentTestManager.getTest().pass("Counselor button displayed on the Registration page");
		otherPage.mouseHoverAlumnusButton();
		otherPage.verifyAlumnusButton();
		ExtentTestManager.getTest().pass("Alumnus button displayed on the Registration page");
		otherPage.mouseHoverCurrentStudentButton();
		otherPage.verifyCurrentStudentButton();
		ExtentTestManager.getTest().pass("Current Student button displayed on the Registration page");
		otherPage.mouseHoverFacultyButton();
		otherPage.verifyFacultyButton();
		ExtentTestManager.getTest().pass("Faculty button displayed on the Registration page");
		otherPage.mouseHoverGeneralVisitorButton();
		otherPage.verifyGeneralVisitorButton();
		ExtentTestManager.getTest().pass("General Visitor button displayed on the Registration page");
		otherPage.mouseHoverVeteranbutton();
		otherPage.verifyVeteranbutton();
		ExtentTestManager.getTest().pass("Veteran button displayed on the Registration page");
	}

	@Test   
	@Parameters({"browser"})
	public void TC15_ProspectiveStudentCollageStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC15_ProspectiveStudentCollageStudentAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC15_ProspectiveStudentCollageStudentAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC15_ProspectiveStudentCollageStudentAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC15_ProspectiveStudentCollageStudentAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.ClickProspectiveStudentCollegeStudentButton();
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyNameOfCurrentCollegeLabel();
		prospectiveStudentPage.enterTheNameOfTheCollegeGraduated();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC16_ProspectiveStudentCollegeGraduateAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC16_ProspectiveStudentCollegeGraduateAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC16_ProspectiveStudentCollegeGraduateAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC16_ProspectiveStudentCollegeGraduateAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC16_ProspectiveStudentCollegeGraduateAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickCollegeGraduateButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Postal code is entered");
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyNameOfTheCollegeGraduatedLabel();
		prospectiveStudentPage.enterTheNameOfTheCollegeGraduated();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		ExtentTestManager.getTest().pass("Intended major is selected");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC17_ProspectiveStudentAdultAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC17_ProspectiveStudentAdultAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC17_ProspectiveStudentAdultAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC17_ProspectiveStudentAdultAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC17_ProspectiveStudentAdultAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentAdultLearnerButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Postal code is entered");
		otherPage.clickNextButton();
//		prospectiveStudentPage.verifyNameOfTheCollegeGraduatedLabel();
//		prospectiveStudentPage.enterNameOfTheCollegeGraduated("Mcdowell Technical Community Clg (Marion, NC)");
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
/*		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
*/		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC18_ProspectiveStudentMiddleSchoolStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("DesktopCIF-TC18_PS_MSS_AdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("DesktopCIF-TC18_PS_MSS_AdditionalInformation[");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopCIF-TC18_PS_MSS_AdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopCIF-TC18_PS_MSS_AdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentMiddleSchoolStudentButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();	
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();	
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC13_ProspectiveStudentHSSAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC13_PSHSSAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC13_PSHSSAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC13_PSHSSAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC13_PSHSSAdditionalInformation ["+browserName+"]", ExtentColor.RED));
	
		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolName;
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC14_ProspectiveStudentHSGAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC14_PS_HSGAdditionalInformation ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC14_PS_HSGAdditionalInformation");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC14_PS_HSGAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC14_PS_HSGAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolGraduateButton();
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolGraduated("Walter Wellborn School (Anniston, AL)");
		prospectiveStudentPage.enterTheNameOfTheCollegeGraduated();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC27_AdditionalInfoPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC27_AdditionalInfoPage ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("TC27_AdditionalInfoPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC27_AdditionalInfoPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC27_AdditionalInfoPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.enterCurrentHighSchoolName();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC03_VisitorTypeProspectiveStudentOptionsPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC03_VisitorTypeProspectiveStudentOptionsPage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC03_VisitorTypeProspectiveStudentOptionsPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC03_VisitorTypeProspectiveStudentOptionsPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_VisitorTypeProspectiveStudentOptionsPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		otherPage.verifyWhatDescribeYouText();
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
		prospectiveStudentPage.mouseHoverProspectiveStudentMiddleSchoolStudentButton();
		ExtentTestManager.getTest().pass("MiddleSchoolStudentButton displayed on the ProspectiveStudentOptions Page");

	}

	@Test   
	@Parameters({"browser"})
	public void TC03_VisitorTypeParentOptionsPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC03_VisitorTypeParentOptionsPage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC03_VisitorTypeParentOptionsPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC03_VisitorTypeParentOptionsPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_VisitorTypeParentOptionsPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		ExtentTestManager.getTest().pass("clickParentGuardianButton is clicked");
		otherPage.verifyWhatDescribeYourChildText();
		ExtentTestManager.getTest().pass("What Best Describes Your child? Text displayed on the ParentGuardian Page");
		parentAndGuardianPage.mouseHoverParentGuardianHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ParentGuardianHighSchoolStudentButton displayed on the ParentGuardian page");
		parentAndGuardianPage.mouseHoverParentGuardianHighSchoolGraduateButton();
		ExtentTestManager.getTest().pass("arentGuardianHighSchoolGraduateButton displayed on the ParentGuardian Page");
		parentAndGuardianPage.mouseHoverParentGuardianCollegeStudentButton();
		ExtentTestManager.getTest().pass("ParentGuardianCollegeStudentButton displayed on the ParentGuardian Page");
		parentAndGuardianPage.mouseHoveParentGuardianCollegeGraduateButton();
		ExtentTestManager.getTest().pass("arentGuardianCollegeGraduateButton displayed on the ParentGuardian Page");
		parentAndGuardianPage.mouseHoverParentGuardianMiddleSchoolButton();
		ExtentTestManager.getTest().pass("ParentGuardianMiddleSchoolButton displayed on the ParentGuardian Page");
	}

	@Test   
	@Parameters({"browser"})
	public void TC25_ScorePage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC25_ScorePage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC25_ScorePage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC25_ScorePage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC25_ScorePage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.enterCurrentHighSchoolName();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterInvalidSatScoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterSatScoreTextbox();
		parentAndGuardianPage.enterInvalidActScoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterActScoreTextbox();
		parentAndGuardianPage.enterInvalidGpacoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterGpaScoreTextbox();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC24_WhoTheyIntendToBe(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC24_WhoTheyIntendToBe ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC24_WhoTheyIntendToBe");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC24_WhoTheyIntendToBe ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC24_WhoTheyIntendToBe ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ProspectiveStudentHighSchoolStudentButton is clicked");
		prospectiveStudentPage.verifyHighSchoolGraduationYearDropdownDefaultValue();
		prospectiveStudentPage.verifyHighSchoolGraduationYearLabel();
		prospectiveStudentPage.verifyHighSchoolIntendedEnrollmentYearTermLabel();
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();		
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.enterCurrentHighSchoolName();
		ExtentTestManager.getTest().pass("CurrentHighSchoolName is entered");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("IndendedMajorDropdown is entered");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC36_VerifyThatCIFIsAbortedIfUserIsInCAAndHasGPCEnabled(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC36_VerifyThatCIFIsAbortedIfUserIsInCAAndHasGPCEnabled ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC36_VerifyThatCIFIsAbortedIfUserIsInCAAndHasGPCEnabled");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC36_VerifyThatCIFIsAbortedIfUserIsInCAAndHasGPCEnabled ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC36_VerifyThatCIFIsAbortedIfUserIsInCAAndHasGPCEnabled ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.ClickProspectiveStudentCollegeStudentButton();
		
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB("06/19/2012");
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		//parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		//otherPage.clickNextButton();
		prospectiveStudentPage.verifyThanksMessageForUnder16DOB();
	}

	@Test   
	@Parameters({"browser"})
	public void VerifytheCIFFormAccessibility(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("VerifytheCIFFormAccessibility ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("VerifytheCIFFormAccessibility");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "VerifytheCIFFormAccessibility ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("VerifytheCIFFormAccessibility ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.tabAndEnterProspectiveStudentHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ProspectiveStudentHighSchoolStudentButton is clicked");
		prospectiveStudentPage.keyboardEnterNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		prospectiveStudentPage.tabFirstnameTextbox();
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterFirstName(setData.get("FirstName"));
		prospectiveStudentPage.tabLastnameTextbox();
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		prospectiveStudentPage.tabDOBField();
		otherPage.enterDOB("06/19/2008");
		ExtentTestManager.getTest().pass("Enter the dob");
		prospectiveStudentPage.keyboardEnterNextButton();
		prospectiveStudentPage.tabPostalCodeTextbox();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		prospectiveStudentPage.tabNextButton();
		prospectiveStudentPage.keyboardEnterNextButton();
		prospectiveStudentPage.tabCurrentHighSchoolNameTextbox();
		//prospectiveStudentPage.enterCurrentHighSchoolName;
		//ExtentTestManager.getTest().pass("CurrentHighSchoolName is entered");
		prospectiveStudentPage.tabNextButton();
		prospectiveStudentPage.keyboardEnterNextButton();
		prospectiveStudentPage.tabintendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		//prospectiveStudentPage.tabNextButton();
		prospectiveStudentPage.keyboardEnterNextButton();
		//prospectiveStudentPage.typeIntentedMajorValue();
		//prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		//prospectiveStudentPage.tabNextButton();
		//prospectiveStudentPage.keyboardEnterNextButton();
		prospectiveStudentPage.tabSatScoreTextbox();
		desktopRegistrationLegacyFormPage.selectSATScore();		
		ExtentTestManager.getTest().pass("SAT score is entered");	
		prospectiveStudentPage.tabActScoreTextbox();
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");		
		prospectiveStudentPage.tabGpaScoreTextbox();
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		prospectiveStudentPage.tabNextButton();
		//prospectiveStudentPage.keyboardEnterNextButton();
		prospectiveStudentPage.pressEnterKey();
		prospectiveStudentPage.tabPhoneTextbox();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		prospectiveStudentPage.tabGenderDropdown();
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		ExtentTestManager.getTest().pass("Gender option is selected");
		prospectiveStudentPage.tabAcknowledgementCheckbox();
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		prospectiveStudentPage.tabDoneButton();
		prospectiveStudentPage.pressEnterKey();
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("Get ready message is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void TC30_VerifySchoolSelectionList(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC30_VerifySchoolSelectionList ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC30_VerifySchoolSelectionList");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC30_VerifySchoolSelectionList ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC30_VerifySchoolSelectionList ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.ClickProspectiveStudentCollegeStudentButton();
		ExtentTestManager.getTest().pass("ProspectiveStudentHighSchoolStudentButton is clicked");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();		
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyWhereAreYouFromLabel();
		prospectiveStudentPage.verifyCountryDropdown();
		prospectiveStudentPage.verifyCountryTextbox();
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolName;
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterInvalidSatScoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterSatScoreTextbox();
		parentAndGuardianPage.enterInvalidActScoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterActScoreTextbox();
		parentAndGuardianPage.enterInvalidGpacoreAndVerifyTheErrorMessage();
		parentAndGuardianPage.enterGpaScoreTextbox();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC31_VerifyCollegeSelectionList(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC31_VerifyCollegeSelectionList ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC31_VerifyCollegeSelectionList");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC31_VerifyCollegeSelectionList ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC31_VerifyCollegeSelectionList ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.ClickProspectiveStudentCollegeStudentButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		prospectiveStudentPage.verifyWhereAreYouFromLabel();
		prospectiveStudentPage.verifyCountryDropdown();
		prospectiveStudentPage.verifyCountryTextbox();
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyNameOfCurrentCollegeLabel();
		//prospectiveStudentPage.enterNameOfCurrentCollege("Wells College (Aurora, NY)");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC28_OptionalFields(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC28_OptionalFields ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC28_OptionalFields");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC28_OptionalFields ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC28_OptionalFields ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.ClickProspectiveStudentCollegeStudentButton();
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Enter postal code and click Next button");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Skip NAME OF CURRENT COLLEGE field and click the Next button");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Skip Intended Major field and click the Next button");
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC04_NameInformationPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC04_NameInformationPage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC04_NameInformationPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC04_NameInformationPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC04_NameInformationPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		prospectiveStudentPage.verifyHighSchoolGraduationYearDropdownDefaultValue();	
		prospectiveStudentPage.verifyHighSchoolGraduationYearLabel();
		ExtentTestManager.getTest().pass("High School Graduation Year label appears");
		prospectiveStudentPage.verifyHighSchoolIntendedEnrollmentYearTermLabel();
		ExtentTestManager.getTest().pass("High School INTENDED ENROLLMENT YEAR & TERM label appears");
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();	
		ExtentTestManager.getTest().pass("Next button clicked on High School Graduation page");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button clicked without filling any value on Name & DOB page page");
		prospectiveStudentPage.verifyPleaseEnterValidFirstNameErrorMessage();
		prospectiveStudentPage.verifyPleaseEnterValidLastNameErrorMessage();
		prospectiveStudentPage.verifyPleaseEnterValidEmailIDErrorMessage();
		prospectiveStudentPage.verifyPleaseEnterValidDOBErrorMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC26_DemographicPage(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC26_DemographicPage ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC26_DemographicPage");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC26_DemographicPage ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC26_DemographicPage ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ProspectiveStudentHighSchoolStudentButton is clicked");
		desktopRegistrationLegacyFormPage.childrensHighSchoolGraduationYearDropdown();
		ExtentTestManager.getTest().pass("childrensHighSchoolGraduationYearDropdown is selected");
		desktopRegistrationLegacyFormPage.intendedenrollmentYearAndTermsDropdown();
		ExtentTestManager.getTest().pass("Intended enrollment is selected");
		otherPage.clickNextButton();		
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Click next without enter postal code");
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyEnterValidPostalCodeAlertMessage();
		ExtentTestManager.getTest().pass("Enter ValidPostalCodeAlertMessage is verified");
		parentAndGuardianPage.enterPostalCode("9");
		ExtentTestManager.getTest().pass("Enter invalid postal code and click next button");
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyEnterValidPostalCodeAlertMessage();
		ExtentTestManager.getTest().pass("Enter ValidPostalCodeAlertMessage is verified");
		parentAndGuardianPage.enterPostalCode("9@");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Enter invalid postal code and click next button");
		prospectiveStudentPage.verifyEnterValidPostalCodeAlertMessage();
		ExtentTestManager.getTest().pass("Enter ValidPostalCodeAlertMessage is verified");
		parentAndGuardianPage.enterPostalCode("H1H1H1");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Enter invalid postal code and click next button");
		prospectiveStudentPage.verifyEnterValidPostalCodeAlertMessage();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolName;
		//ExtentTestManager.getTest().pass("CurrentHighSchoolName is entered");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("IndendedMajorDropdown is entered");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void TC29_ClosedButton(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("TC29_ClosedButton ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("TC29_ClosedButton");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC29_ClosedButton ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC29_ClosedButton ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.switchToTheDefaultContent();
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		prospectiveStudentPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		otherPage.switchToTheVirtualtourFrame();
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("ProspectiveStudentHighSchoolStudentButton is clicked");
		//otherPage.clickNextButton();
		prospectiveStudentPage.switchToTheDefaultContent();
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		otherPage.switchToTheVirtualtourFrame();
		otherPage.clickNextButton();
		otherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		prospectiveStudentPage.switchToTheDefaultContent();
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		otherPage.switchToTheVirtualtourFrame();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		prospectiveStudentPage.switchToTheDefaultContent();
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		otherPage.switchToTheVirtualtourFrame();
		//prospectiveStudentPage.enterCurrentHighSchoolName;
		//ExtentTestManager.getTest().pass("CurrentHighSchoolName is entered");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("IndendedMajorDropdown is entered");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("PhoneNumber is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Click on Done button");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
		prospectiveStudentPage.switchToTheDefaultContent();
		cifLogin.verifyLearnMoreLinkAfterCompleteTheRegister();
		ExtentTestManager.getTest().pass("LearnMoreLinkAfterCompleteTheRegister button is verified");
	}
	
	@Test   
	@Parameters({"browser"})
	public void TC12_OtherCounselorDemographic(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("TC12_OtherCounselorDemographic ["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC12_OtherCounselorDemographic ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC12_OtherCounselorDemographic ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		cifLogin.navigateToDesktopCIFLogin(url);
		otherPage.switchToTheVirtualtourFrame();
		//otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			cifLogin.navigateToDesktopCIFLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		ExtentTestManager.getTest().pass("What Best Describes You? Text displayed on the Registration page");
		otherPage.clickCounselorButton();
		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("Privacy Policy Link is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.enterEmail(setData.get("EmailID"));		
		ExtentTestManager.getTest().pass("Enter the email");
		otherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		otherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		prospectiveStudentPage.verifyWhereDoYouWorkLabel();
		ExtentTestManager.getTest().pass("WhereDoYouWorkLabel is verified");
		prospectiveStudentPage.verifyCountryDropdown();
		ExtentTestManager.getTest().pass("CountryDropdown is verified");
		prospectiveStudentPage.verifyUSACountryDefaultSelection();
		ExtentTestManager.getTest().pass("USA Country Default Selection is verified");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("Privacy Policy Link is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		prospectiveStudentPage.switchToTheDefaultContent();
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		prospectiveStudentPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		otherPage.switchToTheVirtualtourFrame();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}
}