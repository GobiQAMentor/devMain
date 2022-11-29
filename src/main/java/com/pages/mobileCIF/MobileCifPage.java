package com.pages.mobileCIF;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.github.javafaker.Faker;
import com.pages.PageInterface;

public class MobileCifPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	Faker faker = new Faker();
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyLink;
	@FindBy(xpath = "//a[contains(text(),'Terms of Use')]")
	WebElement termsOfUseLink;
	@FindBy(xpath = "//div[@data-test='TourButtonPanel']//a[contains(@alt,'Register')]")
	WebElement registerButton;
	@FindBy(xpath = "//select[@name='country']")
	WebElement whereAreYouFromDropdown;
	@FindBy(xpath = "//option[contains(text(),'Canada')]")
	WebElement canadaDropdownValue;
	@FindBy(xpath = "//input[contains(@placeholder,'com')]")
	WebElement yourEmailPlaceholderTextbox;
	@FindBy(xpath = "//input[contains(@placeholder,'') and @id='firstname']")
	WebElement firstnamePlaceholderTextbox;
	@FindBy(xpath = "//input[contains(@placeholder,'') and @id='lastname']")
	WebElement lastnamePlaceholderTextbox;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dobFieldMobile;
	@FindBy(xpath = "//button[@value='hs_grad']")
	WebElement highSchoolGraduateButton;
	@FindBy(xpath = "//button[@value='adult_learner']")
	WebElement prospectiveStudentAdultLearnerButton;
	@FindBy(xpath = "//button[@value='college_grad']")
	WebElement collegeGraduateButton;
	@FindBy(xpath = "//button[@value='xfer_student']")
	WebElement ProspectiveStudentCollegeStudentButton;
	@FindBy(xpath = "//button[@value='hs_student']")
	WebElement prospectiveStudentHighSchoolStudentButton;
	@FindBy(xpath = "//button[@value='middle_school']")
	WebElement prospectiveStudentMiddleSchoolStudentButton;
	@FindBy(xpath = "//input[@name='school']")
	WebElement nameOfCurrentCollegeTextbox;
	@FindBy(xpath = "//div[text()='Caldwell University (Caldwell, NJ)']")
	WebElement nameOfCurrentCollegeOption;
	@FindBy(xpath = "//label[text()='LAST NAME']")
	WebElement lastNameLabel;
	@FindBy(xpath = "//label[text()='FIRST NAME']")
	WebElement firstNameLabel;
	@FindBy(xpath = "//label[text()='YOUR EMAIL']")
	WebElement yourEmailLabel;
	@FindBy(xpath = "//label[text()='WHERE ARE YOU FROM?']")
	WebElement whereAreYouFromLabel;
	@FindBy(xpath = "//label[text()='Share your scores']")
	WebElement shareYourScoreLabel;
	@FindBy(xpath = "//label[contains(text(),'HIGH SCHOOL GRADUATION YEAR')]")
	WebElement highSchoolGraduationYearLabels;
	@FindBy(xpath = "//label[contains(text(),'INTENDED ENROLLMENT YEAR & TERM')]")
	WebElement intendedEnrollmentTearAndTermLabel;
	@FindBy(xpath = "//select//option[@value='Select']/following-sibling::option[@value='USA']")
	WebElement usaCountryDefaultSelection;
	@FindBy(xpath = "//input[contains(@placeholder,'') and @id='postal']")
	WebElement postalPlaceholderTextbox;
	@FindBy(xpath = "//input[contains(@placeholder,'') and @name='school']")
	WebElement schoolPlaceholderTextbox;
	@FindBy(xpath = "//select[option[contains(text(),'2022')]]")
	WebElement childsHighSchoolGraduationYearDropdownDefaultValue;
	@FindBy(xpath = "//label[contains(text(),'INTENDED ENROLLMENT YEAR & TERM')]")
	WebElement childsIntendedEnrollmentYearAndTermLabel;
	@FindBy(xpath = "//input[@id='postal']")
	WebElement postalCode;
	@FindBy(xpath = "//button[.='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//button[@aria-label='open menu']")
	WebElement intendedMajorDropdownButton;
	@FindBys(@FindBy(xpath = "//input[contains(@id,'downshift')]"))
	List<WebElement> intendedMajorDropdownsize;
	@FindBy(xpath = "//input[@id='sat']")
	WebElement satScoreTextbox;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  sat')]")
	WebElement enterValidSatAlertMessage;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  act')]")
	WebElement enterValidActAlertMessage;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  gpa')]")
	WebElement enterValidGpaAlertMessage;
	@FindBy(xpath = "//input[@id='gpa']")
	WebElement gpaScoreTextbox;
	@FindBy(xpath = "//input[@id='act']")
	WebElement actScoreTextbox;
	@FindBy(xpath = "//select[@name='gender_more']")
	WebElement genderDropdown;
	@FindBy(xpath = "//option[text()='Male']")
	WebElement genderMaleOption;
	@FindBy(xpath = "//div[@id='checkbox']")
	WebElement acknowledgementCheckbox;
	@FindBy(xpath = "//input[contains(@id,'phone')]")
	WebElement phoneTextbox;
	@FindBy(xpath = "//label[contains(text(),'SHOW YOUR CHILD’S NUMBERS!')]")
	WebElement showYourChildsNumberLabel;
	@FindBy(xpath = "//label[contains(text(),'ETHNICITY')]/following-sibling::img/following-sibling::select")
	WebElement childEthnicityDropdown;
	@FindBy(xpath = "//div[text()='Please enter a valid  parent_email']")
	WebElement pleaseEnterValidEmailIDErrorMessage;
	@FindBy(xpath = "//input[@id='parent_email']")
	WebElement parentEmailField;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement currentHighSchoolNameTextbox;
	@FindBy(xpath = "//a[@alt='Learn']")
	WebElement learnButtonLinkAfterCompleteTheRegister;
	
	public MobileCifPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToMobileCIFLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void verifyWhereAreYouFromLabel() throws Exception {
		isPresentAndVisible(whereAreYouFromLabel);
	}
	public void verifyYourEmailLabel() throws Exception {
		isPresentAndVisible(yourEmailLabel);
	}
	public void verifyFirstNameLabel() throws Exception {
		isPresentAndVisible(firstNameLabel);
	}
	public void verifyLastNameLabel() throws Exception {
		isPresentAndVisible(lastNameLabel);
	}
	public void verifyYourEmailPlaceholderTextbox() throws Exception {
		isPresentAndVisible(yourEmailPlaceholderTextbox);
	}
	public void verifyFirstnamePlaceholderTextbox() throws Exception {
		isPresentAndVisible(firstnamePlaceholderTextbox);
	}
	public void verifyLastnamePlaceholderTextbox() throws Exception {
		isPresentAndVisible(lastnamePlaceholderTextbox);
	}
	public void enterDOBMobile(String Value) throws Exception {
		scrollToElement(dobFieldMobile);
		typeKeysWithActions(dobFieldMobile, Value);
	}
	public void clickCanadaDropdownValue() throws Exception {
		clickWithJavaScript(canadaDropdownValue);
	}
	public void clickWhereAreYouFromDropdown() throws Exception {
		clickWithJavaScript(whereAreYouFromDropdown);
	}
	public void switchToTheVirtualtourFrame() throws Exception {
		driver.switchTo().frame("iframe-modal-iframe");
	}
	public void verifyTermsOfUseLink() throws Exception {
		isPresentAndVisible(termsOfUseLink);
	}
	public void verifyPrivacyPolicyLink() throws Exception {
		isPresentAndVisible(privacyPolicyLink);
	}
	public void clickRegisterButton() throws Exception {
		click(registerButton);
	}
	public void clickProspectiveStudentHighSchoolStudentButton() throws Exception {
		click(prospectiveStudentHighSchoolStudentButton);
	}
	public void verifyProspectiveStudentMiddleSchoolStudentButton() throws Exception {
		isPresentAndVisible(prospectiveStudentMiddleSchoolStudentButton);
	}
	
	public void verifyProspectiveStudentHighSchoolStudentButton() throws Exception {
		isPresentAndVisible(prospectiveStudentHighSchoolStudentButton);
	}
	
	public void verifyProspectiveStudentCollegeStudentButton() throws Exception {
		isPresentAndVisible(ProspectiveStudentCollegeStudentButton);
	}
	
	public void verifyCollegeGraduateButton() throws Exception {
		isPresentAndVisible(collegeGraduateButton);
	}
	
	public void verifyProspectiveStudentAdultLearnerButton() throws Exception {
		isPresentAndVisible(prospectiveStudentAdultLearnerButton);
	}
	
	public void verifyHighSchoolGraduateButton() throws Exception {
		isPresentAndVisible(highSchoolGraduateButton);
	}
	
	public void verifySatScoreLabel() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);
	}
	
	public void verifyHighSchoolGraduationYearLabel() throws Exception {
		isPresentAndVisible(highSchoolGraduationYearLabels);
	}
	public void verifyIntendedEnrollmentTearAndTermLabel() throws Exception {
		isPresentAndVisible(intendedEnrollmentTearAndTermLabel);
	}
	public void verifyUsaCountryDefaultSelection() throws Exception {
		isPresentAndVisible(usaCountryDefaultSelection);
	}
	public void verifyPostalPlaceholderTextbox() throws Exception {
		isPresentAndVisible(postalPlaceholderTextbox);
	}
	public void verifySchoolPlaceholderTextbox() throws Exception {
		isPresentAndVisible(schoolPlaceholderTextbox);
	}
	public void verifyChildsHighSchoolGraduationYearDropdownDefaultValue() throws Exception {
		isPresentAndVisible(childsHighSchoolGraduationYearDropdownDefaultValue);
	}
	public void verifyChildsIntendedEnrollmentYearAndTermLabel() throws Exception {
		isPresentAndVisible(childsIntendedEnrollmentYearAndTermLabel);
	}
	public void enterDOB(String Value) throws Exception {
		scrollToElement(dobFieldMobile);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String elementId = dobFieldMobile.getAttribute("id");
		System.out.println("DOB element ID ========== " + elementId);
		js.executeScript("document.getElementById('"+ elementId +"').setAttribute(\"type\",\"text\")", "");
		click(dobFieldMobile);
		type(dobFieldMobile, Value);
	}
	
	public void enterDOBUnder16() throws Exception {
		Date date;
		do{
			date = faker.date().birthday(10, 12);
			System.out.println("Fake Date ==================== " +date);
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println("RanDom Date ==================== " +formatter.format(date));
			System.out.println("Age ==================== " +getNoOfYearsFromGivenDate(date));
			enterDOB(formatter.format(date));
		}while(getNoOfYearsFromGivenDate(date)>13);
	}
	
	public int getNoOfYearsFromGivenDate(Date dob) {
		int yeardiff = 0;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate birthDate = LocalDate.parse(formatter.format(dob));
		LocalDate currentDate = LocalDate.now();
		Period diff = Period.between(birthDate, currentDate);
		return diff.getYears();
	}
	
	public void enterPostalCode(String Value) throws Exception {
		clearTypeKeys(postalCode, Value);
	}
	
	public void enterCurrentHighSchoolName(String Value) throws Exception {
		clickWithJavaScript(currentHighSchoolNameTextbox);
		type(currentHighSchoolNameTextbox, Value);
	}
	
	public void enterNameOfCurrentCollege(String Value) throws Exception {
		//typeKeys(nameOfCurrentCollegeTextbox, "Wells College (Aurora, NY)");
		Value = "Caldwell";
		click(nameOfCurrentCollegeTextbox);
		clearTypeKeys(nameOfCurrentCollegeTextbox, Value);
		clickWithJavaScript(nameOfCurrentCollegeOption);	
	}
	
	public void jsClickNextButton() throws Exception {
		Thread.sleep(2000);
		//waitAndFindElementByVisibility(nextButton);
		clickWithJavaScript(nextButton);
	}
	public static int getRandomValue(int Min, int Max)
    {
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }
	public void selectintendedDropdownOptionDynamic() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(intendedMajorDropdownButton);
		optionSize = intendedMajorDropdownsize.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void enterIntendedMajorDropdown() throws Exception {
		selectintendedDropdownOptionDynamic();
	}
	public void enterInvalidSatScoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid sat score");
		clearTypeKeys(satScoreTextbox, "300");
		jsClickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
		clearTypeKeys(satScoreTextbox, "1601");
		jsClickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
	}
	public void enterInvalidActScoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid ACT score");
		clearTypeKeys(actScoreTextbox, "0");
		jsClickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
		clearTypeKeys(actScoreTextbox, "37");
		jsClickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
	}
	public void enterInvalidGpacoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid GPA score");
		clearTypeKeys(gpaScoreTextbox, "4.1");
		jsClickNextButton();
		isPresentAndVisible(enterValidGpaAlertMessage);	
	}
	public void enterSatScoreTextbox() throws Exception {
//		Thread.sleep(2000);
		isPresentAndVisible(shareYourScoreLabel);		
		clearTypeKeys(satScoreTextbox, "400");
	}
	public void enterActScoreTextbox() throws Exception {
		clearTypeKeys(actScoreTextbox, "2");
	}
	public void enterGpaScoreTextbox() throws Exception {
		clearTypeKeys(gpaScoreTextbox, ".3");
	}
	public void clickGenderDropdown() throws Exception {
		click(genderDropdown);
	}
	public void selectGenderMaleOption() throws Exception {
		clickWithJavaScript(genderMaleOption);
	}
	public void clickAcknowledgementCheckbox() throws Exception {
		clickWithJavaScript(acknowledgementCheckbox);
	}

	public void enterPhoneNumber(String phoneNo) throws Exception {
		type(phoneTextbox, phoneNo);
	}
	public void enterChildsSatScoreTextbox() throws Exception {
		isPresentAndVisible(showYourChildsNumberLabel);		
		clearTypeKeys(satScoreTextbox, "400");
	}	
	public void verifyChildEthnicityDropdown() throws Exception {
		isPresentAndVisible(childEthnicityDropdown);
	}
	public void verifyPleaseEnterValidEmailErrorMessage() throws Exception {
		isPresentAndVisible(pleaseEnterValidEmailIDErrorMessage);
	}
	public void enterEmail(String email) throws Exception {
		isPresentAndVisible(parentEmailField);
		clearTypeKeys(parentEmailField, email);
		System.out.println("EMAIL---"+email);
	}
	public void enterInvalidSatScoreAndVerifyTheErrorMessageInParentSide() throws Exception {
		ExtentTestManager.getTest().pass("Enter the invalid sat score");
		clearTypeKeys(satScoreTextbox, "300");
		jsClickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
		clearTypeKeys(satScoreTextbox, "1601");
		jsClickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
	}
	public void enterInvalidActScoreAndVerifyTheErrorMessageInParentSide() throws Exception {
		ExtentTestManager.getTest().pass("Enter the invalid ACT score");
		clearTypeKeys(actScoreTextbox, "0");
		jsClickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
		clearTypeKeys(actScoreTextbox, "37");
		jsClickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
	}
	public void enterInvalidGpacoreAndVerifyTheErrorMessageInParentSide() throws Exception {
		ExtentTestManager.getTest().pass("Enter the invalid GPA score");
		clearTypeKeys(gpaScoreTextbox, "4.1");
		jsClickNextButton();
		isPresentAndVisible(enterValidGpaAlertMessage);	
	}
	public void verifyLearnButtonLinkAfterCompleteTheRegister() throws Exception {
		refreshPage();
		waitAndFindElementByVisibility(learnButtonLinkAfterCompleteTheRegister);
	}
}
