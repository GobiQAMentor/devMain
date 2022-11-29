package com.pages.desktopCIF;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
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
import com.utils.UtilityClass;

public class OtherPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	UtilityClass util;
	Faker faker = new Faker(new Locale("en-US"));
	@FindBy(xpath = "//h1")
	WebElement welcomeTextStonybrook;
	@FindBy(id = "iframe-modal-iframe")
	WebElement virtualTouriframe;
	@FindBy(xpath = "//button[@value='other']")
	WebElement otherButton;
	@FindBy(xpath = "//label[text()='WHAT BEST DESCRIBES YOU?']")
	WebElement whatDescribeYouText;
	@FindBy(xpath = "//label[text()='WHAT BEST DESCRIBES YOUR CHILD?']")
	WebElement whatDescribeYourChildText;
	@FindBy(xpath = "//button[@value='counselor']")
	WebElement counselorButton;
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement emailTextbox;
	@FindBy(xpath = "//input[contains(@id,'firstname')]")
	WebElement firstnameTextbox;
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dobField;
	@FindBy(xpath = "//button[.='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyLink;
	@FindBy(xpath = "//a[contains(text(),'Terms of Use')]")
	WebElement termsOfUseLink;
	@FindBy(xpath = "//div[contains(@class,'Component-barContainer')]")
	WebElement almostDoneMessageBar;
	@FindBy(xpath = "//div[contains(text(),'Almost done!')]")
	WebElement almostDoneMessage;
	@FindBy(xpath = "//input[@placeholder='School name']")
	WebElement whichSchoolDoYouWorkWithSchoolName;
	@FindBy(xpath = "//button[.='Done']")
	WebElement doneButton;
	@FindBy(xpath = "//p[text()='Get ready']")
	WebElement getReadyMessage;
	@FindBy(xpath = "//button[.='General Visitor']")
	WebElement generalVisitorButton;
	@FindBy(xpath = "//button[@value='alumni']")
	WebElement alumnusButton;
	@FindBy(xpath = "//button[@value='faculty']")
	WebElement facultyButton;
	@FindBy(xpath = "//button[@value='current_student']")
	WebElement currentStudentButton;
	@FindBy(xpath = "//button[@value='veteran']")
	WebElement veteranbutton;
	@FindBy(id = "postal")
	WebElement postalCode;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> SchoolNameOptions;
	@FindBy(xpath = "//div[contains(@class,'completionBar')]")
	WebElement completionStatusBar;
	
	public OtherPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		util = new UtilityClass();
	}

	public boolean verifyWelcomeStonybrookHeader() throws Exception {
		return isPresentAndVisibleVersion2(welcomeTextStonybrook);
	}
	public void switchToTheVirtualtourFrame() throws Exception {
		switchToFrame(virtualTouriframe);
	}
	public void clickOtherButton() throws Exception {
		click(otherButton);
	}
	public void verifyWhatDescribeYouText() throws Exception {
		waitAndFindElementByVisibility(whatDescribeYouText);
		isPresentAndVisible(whatDescribeYouText);
	}
	public void verifyWhatDescribeYourChildText() throws Exception {
		isPresentAndVisible(whatDescribeYourChildText);
	}
	public void clickCounselorButton() throws Exception {
		click(counselorButton);
	}
	public void clickNextButton() throws Exception {
		Thread.sleep(2000);
		waitAndFindElementByVisibility(nextButton);
		click(nextButton);
		Thread.sleep(5000);
	}
	public void verifyTermsOfUseLink() throws Exception {
		isPresentAndVisible(termsOfUseLink);
	}
	public void verifyPrivacyPolicyLink() throws Exception {
		isPresentAndVisible(privacyPolicyLink);
	}
	public void verifyAlmostDoneMessageBar() throws Exception {
		isPresentAndVisible(almostDoneMessageBar);
	}
	public void verifyAlmostDoneMessage() throws Exception {
		isPresentAndVisible(almostDoneMessage);
	}
	public void enterWhichSchoolDoYouWorkWithSchoolName() throws Exception {
		clearTypeKeys(whichSchoolDoYouWorkWithSchoolName, "Wellstone Paul David");
	}
	public void clickDoneButton() throws Exception {
		clickWithJavaScript(doneButton);
	}
	public void verifyGetReadyMessage() throws Exception {
		isPresentAndVisible(getReadyMessage);
	}
	public void clickAlumnusButton() throws Exception {
		click(alumnusButton);
	}
	public void clickFacultyButton() throws Exception {
		click(facultyButton);
	}
	public void clickCurrentStudentButton() throws Exception {
		click(currentStudentButton);
	}
	public void clickGeneralVisitorButton() throws Exception {
		click(generalVisitorButton);
	}
	public void verifyCounselorButton() throws Exception {
		isPresentAndVisible(counselorButton);
	}
	public void verifyAlumnusButton() throws Exception {
		isPresentAndVisible(alumnusButton);
	}
	public void verifyCurrentStudentButton() throws Exception {
		isPresentAndVisible(currentStudentButton);
	}
	public void verifyFacultyButton() throws Exception {
		isPresentAndVisible(facultyButton);
	}
	public void verifyVeteranbutton() throws Exception {
		isPresentAndVisible(veteranbutton);
	}
	public void verifyGeneralVisitorButton() throws Exception {
		isPresentAndVisible(generalVisitorButton);
	}
	public void mouseHoverGeneralVisitorButton() throws Exception {
		mouseHoverElement(generalVisitorButton);
	}
	public void mouseHoverCounselorButton() throws Exception {
		mouseHoverElement(counselorButton);
	}
	public void mouseHoverAlumnusButton() throws Exception {
		mouseHoverElement(alumnusButton);
	}
	public void mouseHoverCurrentStudentButton() throws Exception {
		mouseHoverElement(currentStudentButton);
	}
	public void mouseHoverVeteranbutton() throws Exception {
		mouseHoverElement(veteranbutton);
	}
	public void mouseHoverFacultyButton() throws Exception {
		mouseHoverElement(facultyButton);
	}	
	public  Map<String, String> setData() throws Exception{
		Map<String, String> cifData = new HashMap<>();	
		cifData.put("FirstName", faker.name().firstName());
		cifData.put("LastName",faker.name().lastName());
		cifData.put("EmailID", faker.name().firstName()+"@eab.com");
		cifData.put("DoB", enterDobBelow18Yrs());
		cifData.put("PhoneNo", faker.number().digits(10).toString());
		//cifData.put("PostalCode", faker.address().zipCodeByState("Alabama"));
		//cifData.put("PostalCode", faker.country().countryCode2());
		cifData.put("PostalCode", faker.address().zipCode());
		cifData.put("GpaScore", randomDecimalValue());
		cifData.put("ParentPhoneNumber", faker.number().digits(10).toString());
		return cifData;
	}
	public void enterEmail(String email) throws Exception {
		isPresentAndVisible(emailTextbox);
		clearTypeKeys(emailTextbox, email);
		ExtentTestManager.getTest().pass("EMAIL---"+email);
	}
	public void enterFirstName(String firstName) throws Exception {
		clearTypeKeys(firstnameTextbox, firstName);
		ExtentTestManager.getTest().pass("Firstname---"+firstName);
		//System.out.println("FIRSTNAME"+firstName);
	}
	public void enterLastName(String lastName) throws Exception {
		clearTypeKeys(lastnameTextbox, lastName);
		ExtentTestManager.getTest().pass("LastName---"+lastName);
		//System.out.println("lastName"+lastName);
	}

	public void enterDOB(String Value) throws Exception {
		scrollToPageBottom();
		clearTypeKeys(dobField, Value);
	}
	public String enterDobBelow18Yrs() throws ParseException {
		Date date = faker.date().birthday(18, 21);
		System.out.println("Fake Date ==================== " +date);
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("RanDom Date ==================== " +formatter.format(date));
		return formatter.format(date);
	}
	public void switchToVirtualtourFrame() throws Exception {
		driver.switchTo().frame("iframe-modal-iframe");
	}
	public void enterPostalCode(String Value) throws Exception {
		clearTypeKeys(postalCode, Value);
	}
	public void enterTheWhichSchoolDoYouWorkWithSchoolName() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String searchString = "School";
		clickWithJavaScript(whichSchoolDoYouWorkWithSchoolName);
		type(whichSchoolDoYouWorkWithSchoolName,searchString);
		waits(1);
		optionSize = SchoolNameOptions.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
			waits(2);
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public String randomDecimalValue(){
        double lower = 0.2d;
        double upper =4.0d;
        int decimalPlaces=1;
        double result = (double) (Math.random() * (upper - lower)) + lower;
        return( String.format("%."+ decimalPlaces +"f",result));
	}
}