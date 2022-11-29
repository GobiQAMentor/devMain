package com.tests.desktopRegistrationLegacyForm;
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
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.desktopRegistrationLegacyForm.DesktopRegistrationLegacyFormPage;
import com.tests.BaseTest;

public class DesktopRegistrationLegacyFormTests extends BaseTest{
	String url;
	DesktopRegistrationLegacyFormPage desktopRegistrationLegacyFormPage = null;
	ObjectsControl objectControl = null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	DesktopCIFLoginPage cifLogin = null;
	OtherPage otherPage = null;
	ParentAndGuardianPage parentAndGuardianPage = null;

	@BeforeClass
	public void classSetUp(@Optional("IamOptional")String browser) throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_vt1");
		desktopRegistrationLegacyFormPage = new DesktopRegistrationLegacyFormPage(remoteDriver);
		objectControl = new ObjectsControl(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);	
		cifLogin = new DesktopCIFLoginPage(remoteDriver);
		otherPage = new OtherPage(remoteDriver);
		parentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
	}

	@Test  
	@Parameters({"browser"})  
	public void TC01_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("DesktopRegistrationLegacyForm_TC01_DRLF1_DesktopRegistrationLegacy ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_TC01_DRLF1_DesktopRegistrationLegacy", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_TC01_DRLF1_DesktopRegistrationLegacy ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_TC01_DRLF1_DesktopRegistrationLegacy ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
//		prospectiveStudentPage.enterCurrentHighSchoolName("Walter Wellborn School (Anniston, AL)");
//		ExtentTestManager.getTest().pass("CurrentHighSchoolName is entered");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		ExtentTestManager.getTest().pass("IndendedMajorDropdown is entered");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})  
	public void TC02_RegisterAsCollegeGraduateByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("TC02_RegisterAsCollegeGraduateByFillingValidDetailsInAllTheFields ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_RegisterAsCollegeGraduateByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC02_RegisterAsCollegeGraduateByFillingValidDetailsInAllTheFields ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_RegisterAsCollegeGraduateByFillingValidDetailsInAllTheFields ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		otherPage.clickNextButton();
		prospectiveStudentPage.verifyNameOfTheCollegeGraduatedLabel();
		prospectiveStudentPage.enterNameOfTheCollegeGraduated();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		desktopRegistrationLegacyFormPage.selectACTScore();
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})  
	public void TC03_RegisterAsTransferStudentByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("TC03_RegisterAsTransferStudentByFillingValidDetailsInAllTheFields ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_RegisterAsTransferStudentByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "TC03_RegisterAsTransferStudentByFillingValidDetailsInAllTheFields ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_RegisterAsTransferStudentByFillingValidDetailsInAllTheFields ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolGraduateButton();
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
		prospectiveStudentPage.enterCurrentHighSchoolGraduated();
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		desktopRegistrationLegacyFormPage.selectACTScore();
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}
	
	@Test   
	@Parameters({"browser"})  
	public void C15772_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingValidDetails(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("C15772_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingValidDetails ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15772_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingValidDetails", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15772_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingValidDetails ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15772_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingValidDetails ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianHighSchoolStudentButton();
		desktopRegistrationLegacyFormPage.verifyHighSchoolGraduationYearDropdownDefaultValue();
		ExtentTestManager.getTest().pass("verifyHighSchoolGraduationYearDropdownDefaultValue is verified");
		desktopRegistrationLegacyFormPage.verifyIntendedEnrollmentYearAndTermDropdownDefaultValue();
		ExtentTestManager.getTest().pass("verifyIntendedEnrollmentYearAndTermDropdownDefaultValue is verified");
		desktopRegistrationLegacyFormPage.verifyChildHighSchoolGraduationYearLabel();
		ExtentTestManager.getTest().pass("verifyChildHighSchoolGraduationYearLabel is verified");
		desktopRegistrationLegacyFormPage.verifyChildIndendedEnrollmentYearTermLabel();
		ExtentTestManager.getTest().pass("verifyChildIndendedEnrollmentYearTermLabel is verified");
		desktopRegistrationLegacyFormPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("verifyAlmostDoneMessageBar is verified");
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
		desktopRegistrationLegacyFormPage.enterSatScoreTextbox();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.enterActScoreTextbox();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.enterGpaScoreTextbox();
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.verifyChildEthnicityLabel();
		ExtentTestManager.getTest().pass("verifyChildEthnicityLabel is verified");
		desktopRegistrationLegacyFormPage.verifyChildEthnicityDropdown();
		ExtentTestManager.getTest().pass("verifyChildEthnicityDropdown is verified");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})  
	public void C15773_VerifyTheUserCanRegisterAsParentCollegeGraduateByFillingValidDetails(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("C15773_VerifyTheUserCanRegisterAsParentCollegeGraduateByFillingValidDetails ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15773_VerifyTheUserCanRegisterAsParentCollegeGraduateByFillingValidDetails", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15773_VerifyTheUserCanRegisterAsParentCollegeGraduateByFillingValidDetails ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15773_VerifyTheUserCanRegisterAsParentCollegeGraduateByFillingValidDetails ["+browserName+"]", ExtentColor.RED));

		
		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})  
	public void C15774_VerifyTheUserCanRegisterAsParentTransferStudentByFillingValidDetails(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("C15774_VerifyTheUserCanRegisterAsParentTransferStudentByFillingValidDetails ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15774_VerifyTheUserCanRegisterAsParentTransferStudentByFillingValidDetails", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15774_VerifyTheUserCanRegisterAsParentTransferStudentByFillingValidDetails ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15774_VerifyTheUserCanRegisterAsParentTransferStudentByFillingValidDetails ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianHighSchoolGraduateButton();
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
		desktopRegistrationLegacyFormPage.enterSatScoreTextbox();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.enterActScoreTextbox();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.enterGpaScoreTextbox();
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
	public void C15776_RegisterAsOtherFacultyNameWithFillingValidData(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("C15776_RegisterAsOtherFacultyNameWithFillingValidData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15776_RegisterAsOtherFacultyNameWithFillingValidData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15776_RegisterAsOtherFacultyNameWithFillingValidData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15776_RegisterAsOtherFacultyNameWithFillingValidData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("Get ready message is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15777_RegisterAsOtherCounselorNameWithFillingValidData(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("C15777_RegisterAsOtherCounselorNameWithFillingValidData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15777_RegisterAsOtherCounselorNameWithFillingValidData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15777_RegisterAsOtherCounselorNameWithFillingValidData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15777_RegisterAsOtherCounselorNameWithFillingValidData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		//otherPage.enterTheWhichSchoolDoYouWorkWithSchoolName();
		//ExtentTestManager.getTest().pass("Enter the school_name");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15778_RegisterAsOtherCurrentStudentNameWithFillingValidData(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("C15778_RegisterAsOtherCurrentStudentNameWithFillingValidData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15778_RegisterAsOtherCurrentStudentNameWithFillingValidData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15778_RegisterAsOtherCurrentStudentNameWithFillingValidData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15778_RegisterAsOtherCurrentStudentNameWithFillingValidData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15779_RegisterAsAlumniWithFillingValidData(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("C15779_RegisterAsAlumniWithFillingValidData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15779_RegisterAsAlumniWithFillingValidData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15779_RegisterAsAlumniWithFillingValidData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15779_RegisterAsAlumniWithFillingValidData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		ExtentTestManager.getTest().pass("elcomeStonybrookHeader is verified");
		cifLogin.verifyAreYouLabel();
		ExtentTestManager.getTest().pass("AreYouLabel is verified");
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
		otherPage.verifyPrivacyPolicyLink();
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15780_RegisterAsStudentHighSchoolStudentByFillingValidMandatoryDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("C15780_RegisterAsStudentHighSchoolStudentByFillingValidMandatoryDetailsInAllTheFields ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15780_RegisterAsStudentHighSchoolStudentByFillingValidMandatoryDetailsInAllTheFields", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15780_RegisterAsStudentHighSchoolStudentByFillingValidMandatoryDetailsInAllTheFields ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15780_RegisterAsStudentHighSchoolStudentByFillingValidMandatoryDetailsInAllTheFields ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolStudentButton();
		prospectiveStudentPage.verifyHighSchoolGraduationYearDropdownDefaultValue();	
		prospectiveStudentPage.verifyHighSchoolGraduationYearLabel();
		ExtentTestManager.getTest().pass("High School Graduation Year label appears");
		prospectiveStudentPage.verifyHighSchoolIntendedEnrollmentYearTermLabel();
		ExtentTestManager.getTest().pass("High School INTENDED ENROLLMENT YEAR & TERM label appears");
		otherPage.clickNextButton();	
		ExtentTestManager.getTest().pass("Next button clicked on High School Graduation page");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button clicked without filling any value on Name & DOB page page");
		prospectiveStudentPage.verifyPleaseEnterValidFirstNameErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidFirstNameErrorMessage is verified");
		prospectiveStudentPage.verifyPleaseEnterValidLastNameErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidLastNameErrorMessage is verified");
		prospectiveStudentPage.verifyPleaseEnterValidEmailIDErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidEmailIDErrorMessage is verified");
		prospectiveStudentPage.verifyPleaseEnterValidDOBErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidDOBErrorMessage is verified");
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
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolName("Walter Wellborn School (Anniston, AL)");
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
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void C15781_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingMandatoryValidDetails(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("C15781_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingMandatoryValidDetails ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15781_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingMandatoryValidDetails", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15781_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingMandatoryValidDetails ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15781_VerifyTheUserCanRegisterAsParentHighSchoolStudentByFillingMandatoryValidDetails ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianHighSchoolStudentButton();
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
		//parentAndGuardianPage.enterIndendedMajorDropdown();;
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		desktopRegistrationLegacyFormPage.selectACTScore();
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})
	public void C15782_RegisterAsOtherFacultyNameWithFillingValidMandatoryData(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("DesktopRegistrationLegacyForm_C15782_RegisterAsOtherFacultyNameWithFillingValidMandatoryData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15782_RegisterAsOtherFacultyNameWithFillingValidMandatoryData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C15782_RegisterAsOtherFacultyNameWithFillingValidMandatoryData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C15782_RegisterAsOtherFacultyNameWithFillingValidMandatoryData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
	public void C15783_RegisterAsOtherCounselorNameWithFillingValidMandatoryData(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("DesktopRegistrationLegacyForm_C15783_RegisterAsOtherCounselorNameWithFillingValidMandatoryData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15783_RegisterAsOtherCounselorNameWithFillingValidMandatoryData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C15783_RegisterAsOtherCounselorNameWithFillingValidMandatoryData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C15783_RegisterAsOtherCounselorNameWithFillingValidMandatoryData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		//otherPage.enterDOB(setData.get("DoB"));
		otherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
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
	public void C15784_RegisterAsOtherCurrentStudentNameWithFillingValidMandatoryData(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("DesktopRegistrationLegacyForm_C15784_RegisterAsOtherCurrentStudentNameWithFillingValidMandatoryData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15784_RegisterAsOtherCurrentStudentNameWithFillingValidMandatoryData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C15784_RegisterAsOtherCurrentStudentNameWithFillingValidMandatoryData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C15784_RegisterAsOtherCurrentStudentNameWithFillingValidMandatoryData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15785_RegisterAsAlumniWithFillingValidMandatoryData(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("C15785_RegisterAsAlumniWithFillingValidMandatoryData ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15785_RegisterAsAlumniWithFillingValidMandatoryData", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "C15785_RegisterAsAlumniWithFillingValidMandatoryData ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15785_RegisterAsAlumniWithFillingValidMandatoryData ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		otherPage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		otherPage.verifyWhatDescribeYouText();
		otherPage.clickAlumnusButton();
		ExtentTestManager.getTest().pass("Alumnus button is clicked");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		otherPage.clickNextButton();
		ExtentTestManager.getTest().pass("Next button clicked without filling any value on Name & DOB page page");
		prospectiveStudentPage.verifyPleaseEnterValidFirstNameErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidFirstNameErrorMessage is verified");
		prospectiveStudentPage.verifyPleaseEnterValidLastNameErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidLastNameErrorMessage is verified");
		prospectiveStudentPage.verifyPleaseEnterValidEmailIDErrorMessage();
		ExtentTestManager.getTest().pass("PleaseEnterValidEmailIDErrorMessage is verified");

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
		ExtentTestManager.getTest().pass("PrivacyPolicyLink is verified");
		otherPage.verifyTermsOfUseLink();
		ExtentTestManager.getTest().pass("TermsOfUseLink is verified");
		otherPage.verifyAlmostDoneMessage();
		ExtentTestManager.getTest().pass("AlmostDoneMessage is verified");
		otherPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("AlmostDoneMessage bar is verified");
		otherPage.clickDoneButton();
		ExtentTestManager.getTest().pass("Done button is clicked");
		otherPage.verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
	}

	@Test   
	@Parameters({"browser"})  
	public void C15771_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("DesktopRegistrationLegacyForm_C15771_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15771_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C15771_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C15771_RegisterAsStudentHighSchoolStudentByFillingValidDetailsInAllTheFields ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
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
		//prospectiveStudentPage.enterCurrentHighSchoolName("Walter Wellborn School (Anniston, AL)");
		otherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("Sat Score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("Act Score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		ExtentTestManager.getTest().pass("Gpa Score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		ExtentTestManager.getTest().pass("Phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}

	@Test   
	@Parameters({"browser"})  
	public void C15775_VerifyTheUserCanRegisterAsParentHighSchoolGraduateByFillingValidDetails(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("DesktopRegistrationLegacyForm_C15775_VerifyTheUserCanRegisterAsParentHighSchoolGraduateByFillingValidDetails ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C15775_VerifyTheUserCanRegisterAsParentHighSchoolGraduateByFillingValidDetails", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C15775_VerifyTheUserCanRegisterAsParentHighSchoolGraduateByFillingValidDetails ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C15775_VerifyTheUserCanRegisterAsParentHighSchoolGraduateByFillingValidDetails ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianHighSchoolGraduateButton();
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
		ExtentTestManager.getTest().pass("Sat Score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("Act Score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		ExtentTestManager.getTest().pass("Gpa Score is entered");
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
	public void C32577_VerifyTheEthnicityDropdown(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("DesktopRegistrationLegacyForm_C32577_VerifyTheEthnicityDropdown ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("C32577_VerifyTheEthnicityDropdown", ExtentColor.BLUE));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "DesktopRegistrationLegacyForm_C32577_VerifyTheEthnicityDropdown ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("DesktopRegistrationLegacyForm_C32577_VerifyTheEthnicityDropdown ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		desktopRegistrationLegacyFormPage.findVirtualTourFrame();
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		ExtentTestManager.getTest().pass("parent_guardian_button label displayed on the Registration page");
		ExtentTestManager.getTest().pass("ParentGuardianButton is clicked");
		parentAndGuardianPage.clickParentGuardianHighSchoolStudentButton();
		ExtentTestManager.getTest().pass("parent_guardian_high_school_student_button is clicked");
		desktopRegistrationLegacyFormPage.verifyHighSchoolGraduationYearDropdownDefaultValue();
		ExtentTestManager.getTest().pass("verifyHighSchoolGraduationYearDropdownDefaultValue is verified");
		desktopRegistrationLegacyFormPage.verifyIntendedEnrollmentYearAndTermDropdownDefaultValue();
		ExtentTestManager.getTest().pass("verifyIntendedEnrollmentYearAndTermDropdownDefaultValue is verified");
		desktopRegistrationLegacyFormPage.verifyChildHighSchoolGraduationYearLabel();
		ExtentTestManager.getTest().pass("verifyChildHighSchoolGraduationYearLabel is verified");
		desktopRegistrationLegacyFormPage.verifyChildIndendedEnrollmentYearTermLabel();
		ExtentTestManager.getTest().pass("verifyChildIndendedEnrollmentYearTermLabel is verified");
		desktopRegistrationLegacyFormPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("verifyAlmostDoneMessageBar is verified");
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
		desktopRegistrationLegacyFormPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("verifyAlmostDoneMessageBar is verified");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Postal code is entered");
		desktopRegistrationLegacyFormPage.verifyAlmostDoneMessageBar();
		ExtentTestManager.getTest().pass("verifyAlmostDoneMessageBar is verified");
		otherPage.clickNextButton();
		//prospectiveStudentPage.enterCurrentHighSchoolName("Walter Wellborn School (Anniston, AL)");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		//prospectiveStudentPage.clickIndendedMajorDropdown();
		//prospectiveStudentPage.enterIndendedMajorDropdown("Anthropology");
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("Sat Score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("Act Score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		ExtentTestManager.getTest().pass("Gpa Score is entered");
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.verifyChildEthnicityLabel();
		ExtentTestManager.getTest().pass("verifyChildEthnicityLabel is verified");
		desktopRegistrationLegacyFormPage.verifyChildEthnicityDropdown();
		ExtentTestManager.getTest().pass("verifyChildEthnicityDropdown is verified");
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}
	
	@Test   
	@Parameters({"browser"})
	public void ParentGaurdianMiddleSchoolStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("ParentGaurdianMiddleSchoolStudentAdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		otherPage.switchToTheVirtualtourFrame();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
			otherPage.switchToTheVirtualtourFrame();
		}
		cifLogin.verifyAreYouLabel();
		parentAndGuardianPage.clickParentGuardianButton();
		parentAndGuardianPage.clickParentGuardianMiddleSchoolButton();
		desktopRegistrationLegacyFormPage.verifyChildIndendedEnrollmentYearTermLabel();
		ExtentTestManager.getTest().pass("verifyChildIndendedEnrollmentYearTermLabel is verified");
		
		desktopRegistrationLegacyFormPage.verifyChildIntendedEnrollmentYearAndTermDropdown();
		ExtentTestManager.getTest().pass("verifyChildIndendedEnrollmentYearTermDropdown is verified");
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
		otherPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Enter the postal code");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}
	
	@Test   
	@Parameters({"browser"})
	public void ParentGuardianCollageStudentAdditionalInformation(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("CS_AdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "P_CS_AdditionalInformation ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("P_CS_AdditionalInformation ["+browserName+"]", ExtentColor.RED));

		Map<String, String> setData = otherPage.setData();
		desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
		ExtentTestManager.getTest().pass("DesktopRegistrationLegacyForm is logged in");
		otherPage.switchToTheVirtualtourFrame();
		otherPage.verifyWelcomeStonybrookHeader();
		while(!otherPage.verifyWelcomeStonybrookHeader()) {
			desktopRegistrationLegacyFormPage.navigateToDesktopRegistrationLegacyFormPageLogin(url);
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
		otherPage.enterPostalCode(setData.get("PostalCode"));
		ExtentTestManager.getTest().pass("Enter the postal code");
		otherPage.clickNextButton();
		//parentAndGuardianPage.enterNameOfTheChildsCollageGraduate();
		otherPage.clickNextButton();
		parentAndGuardianPage.enterIndendedMajorDropdown();
		otherPage.clickNextButton();
		desktopRegistrationLegacyFormPage.selectSATScore();
		ExtentTestManager.getTest().pass("SAT score is entered");
		desktopRegistrationLegacyFormPage.selectACTScore();
		ExtentTestManager.getTest().pass("ACT score is entered");
		desktopRegistrationLegacyFormPage.selectGPAScore(setData.get("GpaScore"));;
		ExtentTestManager.getTest().pass("GPA score is entered");
		otherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		desktopRegistrationLegacyFormPage.enterParentPhoneNumber(setData.get("ParentPhoneNumber"));
		ExtentTestManager.getTest().pass("Parent phone number is entered");
		//parentAndGuardianPage.clickGenderDropdown();
		//parentAndGuardianPage.selectGenderMaleOption();
		desktopRegistrationLegacyFormPage.selectGenderDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Gender is selected");
		desktopRegistrationLegacyFormPage.selectEthnicityDropdownOptionDynamic();
		ExtentTestManager.getTest().pass("Ethnicity is selected");
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		otherPage.clickDoneButton();
		otherPage.verifyGetReadyMessage();
	}
}