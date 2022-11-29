package com.pages.mobileRegistrationLegacyForm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.github.javafaker.Faker;
import com.pages.PageInterface;
import com.utils.JavaScriptUtil;
import com.utils.UtilityClass;

public class MobileRegistrationLegacyFormPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	UtilityClass util;
	JavaScriptUtil jsUtil;
	Faker faker = new Faker();
	JavaScriptUtil jUtil;
	String browser = null;
	@FindBy(xpath = "//div[contains(@class,'e-mobileLinearGradient')]")
	WebElement eabMainPage;
	@FindBy(xpath = "//span[text()='Get Started']")
	WebElement getStartedButton;
	@FindBy(xpath = "//td[@item-value='faculty']")
	WebElement facultyOrStaffLink;
	@FindBy(xpath = "//div[@id='main']//a[contains(@href,'/tour/nau?wph')]")
	WebElement mobileStartButton;
	@FindBy(xpath = "//div[@class='visible_area']")
	WebElement iAmATextbox;
	@FindBy(xpath = "//td[@item-value='prospective_student']//div[3]")
	WebElement prospectiveStudentButton;
	@FindBy(xpath = "//td[contains(@item-value,'college_grad')]//div[2]")
	WebElement collageGraduateIcon;
	@FindBy(xpath = "//td[@item-value='parent']")
	WebElement parentButton;
	@FindBy(xpath = "//td[contains(@item-value, 'college_grad')]")
	WebElement collegeGraduateButton;
	@FindBy(xpath = "//input[@class='input ui-autocomplete-input']")
	WebElement whatSchoolDoYouAttend;
	@FindBys(@FindBy(xpath = "//li[@class='ui-menu-item']"))
	List<WebElement> whatSchoolDoYouAttendOptions;
	@FindBy(xpath = "//select[@id='major']")
	WebElement intendedMajor;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTextbox;
	@FindBy(xpath = "//div[@id='registration-firstname']")
	WebElement firstnameTxtField;
	@FindBy(xpath = "//input[contains(@id,'firstname')]")
	WebElement firstnameTextbox;
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastnameTextbox;
	@FindBy(xpath = "//input[contains(@aria-label,'Date of Birth')]")
	WebElement dateOfBirth;
	@FindBy(xpath = "//div[@title='Country']")
	WebElement countryFieldDiv;
	@FindBy(xpath = "//select[@id='country']")
	WebElement countryField;
	@FindBy(xpath = "//select[@id='country']//option[@value='USA']")
	WebElement usaCountryOption;
	@FindBy(xpath = "//div[contains(text(),'Counselor')]")
	WebElement counselorLink;
	@FindBy(xpath = "//td[@item-value='alumni']")
	WebElement alumniLink;
	@FindBy(xpath = "//td[@item-value='current_student']")
	WebElement currentStudentLink;
	@FindBy(xpath = "//td[@item-value='xfer_student']//div[2]")
	WebElement transferStudentIcon;
	@FindBy(xpath = "//td[@item-value='hs_student']//div[2]")
	WebElement highSchoolStudentLink;
	@FindBy(xpath = "//td[@item-value='parent_xfer_student']//div[2]")
	WebElement parentTransferStudentIcon;
	@FindBy(xpath = "//td[@item-value='parent_hs_grad']//div[3]")
	WebElement parentHighSchoolGraduateIcon;
	@FindBy(xpath = "//a[contains(@alt,'Register Now')]/span[contains(text(),'Register Now')][1]")
	WebElement registerNowButton;
	@FindBy(xpath = "//button[@value='prospective_student']")
	WebElement prospectiveStudentLink;
	@FindBy(xpath = "//button[@value='hs_student']")
	WebElement highSchoolStudentButton;
	@FindBy(xpath = "//div[@title='Street']")
	WebElement streetFieldDiv;
	@FindBy(xpath = "//input[@aria-label ='Street']")	
	WebElement streetFieldTxtBx;
	@FindBy(xpath = "//div[@title='Zip Code']")
	WebElement zipCodeFieldDiv;
	@FindBy(xpath = "//input[@id='us_postal']")
	WebElement zipCodeTextbox;
	@FindBy(xpath = "//div[@title ='Phone']")
	WebElement phoneFieldDiv;
	@FindBy(xpath = "//input[@aria-label ='Phone']")	
	WebElement phoneTxtBx;
	@FindBy(xpath = "//div[@title='Start Year']")
	WebElement startYearFieldDiv;
	@FindBy(xpath = "//div[contains(@class,'closeButton')]/div")
	WebElement closeButton;
	@FindBys(@FindBy(xpath = "//button[contains(@class,'swal-button--confirm')]"))
	List<WebElement> iphoneEnableMotionBasedOkButton;

	public MobileRegistrationLegacyFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		jsUtil = new JavaScriptUtil(driver);
	}
	public void navigateToMobileRegistrationLegacyFormPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void navigateToMobileRegistrationLegacyFormurlVTPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}

	public void verifyEABMainPage() throws Exception {
		isPresentAndVisible(eabMainPage);
	}
	public void clickGetStartedButton() throws Exception {
		isPresentAndVisible(getStartedButton);
		click(getStartedButton);
	}
	public void clickCollageGraduateIcon() throws Exception {
		click(collageGraduateIcon);
	}
	public void clickCollageGraduateButton() throws Exception {
		clickWithJavaScript(collegeGraduateButton);
	}	
	public void clickProspectiveStudentButton() throws Exception {
		click(prospectiveStudentButton);
	}

	public void clickParentButton() throws Exception {
		clickWithJavaScript(parentButton);
	}

	public void enterWhatSchoolDoYouAttend(String school) throws Exception {
		type(whatSchoolDoYouAttend, school);
		selectWhatSchoolDoYouAttendAutoComplete();
	}
	public void selectWhatSchoolDoYouAttendAutoComplete() throws Exception {
		int noOfOptions = whatSchoolDoYouAttendOptions.size();
		if(noOfOptions>0) {
			clickWithJavaScript(whatSchoolDoYouAttendOptions.get(0));
		}
	}

	public void enterIntendedMajor(String intentMajor) throws Exception {
		typeKeys(intendedMajor, intentMajor);
	}
	public void clickMobileStartButton() throws Exception {
		click(mobileStartButton);
	}

	public void clickIAmATextbox() throws Exception {
		click(iAmATextbox);
	}
	public  Map<String, String> setData() throws Exception{
		Map<String, String> cifData = new HashMap<>();	
		cifData.put("FirstName", faker.name().firstName());
		cifData.put("LastName",faker.name().lastName());
		cifData.put("EmailID", faker.name().firstName()+"@eab.com");
		cifData.put("DoB", enterDobBelow18Yrs());
		cifData.put("PhoneNo", faker.phoneNumber().phoneNumber());
		return cifData;
	}
	public void enterEmail(String email) throws Exception {
		scrollToElement(emailTextbox);
		isPresentAndVisible(emailTextbox);
		type(emailTextbox, email);
		System.out.println("EMAIL---"+email);
	}
	public void enterFirstName(String firstName) throws Exception {
		//scrollToElement(firstnameTextbox);
		//Thread.sleep(2000);
		click(firstnameTxtField);
		type(firstnameTextbox, firstName);
		//System.out.println("FIRSTNAME"+firstName);
	}
	public void enterLastName(String lastName) throws Exception {
		scrollToElement(lastnameTextbox);
		click(lastnameTextbox);
		type(lastnameTextbox, lastName);
		//System.out.println("lastName"+lastName);
	}
	public void enterDOB(String Value) throws Exception {
		scrollToElement(dateOfBirth);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String elementId = dateOfBirth.getAttribute("id");
		System.out.println("DOB element ID ========== " + elementId);
		js.executeScript("document.getElementById('"+ elementId +"').setAttribute(\"type\",\"text\")", "");
		scrollToElement(dateOfBirth);
		click(dateOfBirth);
		type(dateOfBirth, Value);
	}
	public String enterDobBelow18Yrs() throws ParseException {
		Date date = faker.date().birthday(18, 21);
		System.out.println("Fake Date ==================== " +date);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("RanDom Date ==================== " +formatter.format(date));
		return formatter.format(date);
	}
	public void clickCountryField() throws Exception {
		scrollToElement(countryField);
		click(countryFieldDiv);
		click(usaCountryOption);
	}
	public void clickFacultyOrStaffLink() throws Exception {
		click(facultyOrStaffLink);
	}
	public void clickCounselorLink() throws Exception {
		click(counselorLink);
	}
	public void clickAlumniLink() throws Exception {
		click(alumniLink);
	}
	public void clickCurrentStudentLink() throws Exception {
		click(currentStudentLink);
	}
	public void clickTransferStudentIcon() throws Exception {
		click(transferStudentIcon);
	}
	public void clickHighSchoolStudentLink() throws Exception {
		click(highSchoolStudentLink);
	}
	public void clickParentTransferStudentIcon() throws Exception {
		click(parentTransferStudentIcon);
	}
	public void clickParentHighSchoolGraduateIcon() throws Exception {
		click(parentHighSchoolGraduateIcon);
	}
	public void pressEsc() throws Exception {
		sendModifierKeys(Keys.ESCAPE);
	}
	public void clickRegisterButton() throws Exception {
		waitAndFindElementByVisibility(registerNowButton);
		clickWithJavaScript(registerNowButton);
	}
	public void clickOnProspectiveStudentButton() throws Exception {
		clickWithJavaScript(prospectiveStudentLink);
	}
	public void verifyProspectiveStudentHighSchoolStudentButton() throws Exception {
		isPresentAndVisible(highSchoolStudentButton);
	}
	public void enterStreetField() throws Exception {
		scrollToElement(streetFieldDiv);
		click(streetFieldDiv);
		type(streetFieldTxtBx,"Test");
	}
	public void enterZipCode() throws Exception {
		isPresentAndVisible(zipCodeFieldDiv);
		scrollToElement(zipCodeFieldDiv);
		click(zipCodeFieldDiv);
		isPresentAndVisible(zipCodeTextbox);
		scrollToElement(zipCodeTextbox);
		type(zipCodeTextbox, "60546");
	}

	public void enterPhoneField(String value) throws Exception {
		scrollToElement(phoneFieldDiv);
		click(phoneFieldDiv);
		type(phoneTxtBx, value);
	}
	public void selectStartYearField(String value) throws Exception {
		scrollToElement(startYearFieldDiv);
		click(startYearFieldDiv);
		click(startYearOption(value));
	}
	public WebElement startYearOption(String value) {
		return waitForAndFindElementByLocator(By.xpath("//select[@id='enrollyear']//option[@value='2023']"));
	}
	public void clickCloseButton() throws Exception {
		waitAndFindElementByVisibility(closeButton);
		clickWithJavaScript(closeButton);
	}

	public void enableMotionBasedViewingForiosSafari(String browserName) throws Exception {
		if(browserName.contains("iossafari")) {
			System.out.println("*****Browser Name***** : "+browserName);
			int noOfElement = iphoneEnableMotionBasedOkButton.size();
			System.out.println("########No of Elemet ----- "+noOfElement);
			if(noOfElement > 0) {
				System.out.println("Before Motion Based..........");
				waitAndFindElementByVisibility(iphoneEnableMotionBasedOkButton.get(0));
				clickWithJavaScript(iphoneEnableMotionBasedOkButton.get(0));
				ExtentTestManager.getTest().pass("Motion-Based viewing is enabled.");
			}
		}
	}

}
