package com.pages.desktopCIF;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class ProspectiveStudentPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	@FindBy(xpath = "//button[@value='xfer_student']")
	WebElement ProspectiveStudentCollegeStudentButton;
	@FindBy(xpath = "//label[text()='NAME OF CURRENT COLLEGE']")
	WebElement nameOfCurrentCollegeLabel;
	@FindBy(xpath = "//input[@name='school']")
	WebElement nameOfCurrentCollegeTextbox;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> intendedMajorDropdownsize;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement intendedMajorDropdown;
	@FindBy(xpath = "//input[@name='major']")
	WebElement intendedMajorTextbox;
	@FindBy(xpath = "//button[@aria-label='open menu']")
	WebElement intendedMajorDropdownButton;
	@FindBy(xpath = "//button[@value='college_grad']")
	WebElement collegeGraduateButton;
	@FindBy(xpath = "//label[text()='NAME OF COLLEGE GRADUATED']")
	WebElement nameOfTheCollegeGraduatedLabel;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement nameOfTheCollegeGraduatedTextbox;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> collegeNameOptions;
	@FindBy(xpath = "//button[@value='adult_learner']")
	WebElement prospectiveStudentAdultLearnerButton;
	@FindBy(xpath = "//button[@value='middle_school']")
	WebElement prospectiveStudentMiddleSchoolStudentButton;
	@FindBy(xpath = "//button[@value='hs_student']")
	WebElement prospectiveStudentHighSchoolStudentButton;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement currentHighSchoolNameTextbox;
	@FindBy(xpath = "//button[@value='hs_grad']")
	WebElement highSchoolGraduateButton;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement currentHighSchoolGraduatedTextbox;
	@FindBy(xpath = "//label[text()='HIGH SCHOOL GRADUATION YEAR']")
	WebElement highSchoolGraduationYearLabel;
	@FindBy(xpath = "//label[text()='INTENDED ENROLLMENT YEAR & TERM']")
	WebElement highSchoolIntendedEnrollmentYearTermLabel;
	@FindBy(xpath = "//label[contains(text(),'HIGH SCHOOL GRADUATION YEAR')]/following-sibling::button[contains(text(),'2022')]")
	WebElement highSchoolGraduationYearDropdownDefaultValue;
	@FindBy(xpath = "//*[contains(text(),'Thanks and enjoy the ride')]")
	WebElement thanksMessageForUnder6DOB;
	@FindBy(xpath = "//button[.='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//input[contains(@id,'firstname')]")
	WebElement firstnameTextbox;
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dobField;
	@FindBy(id = "postal")
	WebElement postalCode;
	@FindBy(id = "gpa")
	WebElement gpaScoreTextbox;
	@FindBy(id = "act")
	WebElement actScoreTextbox;
	@FindBy(id = "sat")
	WebElement satScoreTextbox;
	@FindBy(xpath = "//button[@name='gender_more']")
	WebElement genderDropdown;
	@FindBy(xpath = "//div[text()='Male']")
	WebElement genderMaleOption;
	@FindBy(id = "checkbox")
	WebElement acknowledgementCheckbox;
	@FindBy(xpath = "//input[contains(@id,'phone')]")
	WebElement phoneTextbox;
	@FindBy(xpath = "//button[.='Done']")
	WebElement doneButton;
	@FindBy(xpath = "//label[text()='WHERE ARE YOU FROM?']")
	WebElement whereAreYouFromLabel;
	@FindBy(xpath = "//button[@name='country']")
	WebElement countryDropdown;
	@FindBy(xpath = "//div[contains(@id,'downshift-2-item-')]")
	WebElement countryTextbox;
	@FindBy(xpath = "//button[contains(text(),'United States (USA)')]")
	WebElement usaCountryDefaultSelection;
	@FindBy(xpath = "//div[text()='Please enter a valid  first name']")
	WebElement pleaseEnterValidFirstNameErrorMessage;
	@FindBy(xpath = "//div[text()='Please enter a valid  last name']")
	WebElement pleaseEnterValidLastNameErrorMessage;
	@FindBy(xpath = "//div[text()='Please enter a valid  birth date']")
	WebElement pleaseEnterValidDOBErrorMessage;
	@FindBy(xpath = "//div[text()='Please enter a valid  email']")
	WebElement pleaseEnterValidEmailIDErrorMessage;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  postal')]")
	WebElement enterValidPostalCodeAlertMessage;
	@FindBy(xpath = "//div[contains(@class,'closeButton')]/img")
	WebElement closeButton;
	@FindBy(xpath = "//div[@id='close_button']")
	WebElement closeVRButton;
	@FindBy(xpath = "//li[1]//a[contains(@class,'e-linkContainer')]")
	WebElement bookLink;
	@FindBy(xpath = "//a[contains(@alt,'Register')]")
	WebElement registerButton;
	@FindBy(xpath = "//label[text()='WHERE DO YOU WORK?']")
	WebElement whereDoYouWorkLabel;
	@FindBys(@FindBy(xpath = "//input[contains(@id,'downshift')]"))
	List<WebElement> nameOfTheCollegeGraduatedTextboxField;
	public ProspectiveStudentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickProspectiveStudentCollegeStudentButton() throws Exception {
		click(ProspectiveStudentCollegeStudentButton);
	}
	public void verifyNameOfCurrentCollegeLabel() throws Exception {
		isPresentAndVisible(nameOfCurrentCollegeLabel);
	}
	public void enterNameOfCurrentCollege() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String searchString = "sch";
		clickWithJavaScript(nameOfCurrentCollegeTextbox);
		type(nameOfCurrentCollegeTextbox,searchString);
		waits(2);
		optionSize = collegeNameOptions.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			WebElement options = waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]"));
			clickWithJavaScript(options);

		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void clickIntendedMajorDropdown() throws Exception {
		waitAndFindElementByVisibility(intendedMajorDropdown);
		clickWithJavaScript(intendedMajorDropdown);
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
	public void enterIntendedMajorDropdown(String Value) throws Exception {
		selectintendedDropdownOptionDynamic();
	}
	public void clickCollegeGraduateButton() throws Exception {
		click(collegeGraduateButton);
	}
	public void verifyNameOfTheCollegeGraduatedLabel() throws Exception {
		waitAndFindElementByVisibility(nameOfTheCollegeGraduatedLabel);
		isPresentAndVisible(nameOfTheCollegeGraduatedLabel);
	}
	public void enterNameOfTheCollegeGraduated() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String[] searchString= {"uni", "sch"};
		int index = r.nextInt(searchString.length);
		clickWithJavaScript(nameOfTheCollegeGraduatedTextbox);
		type(nameOfTheCollegeGraduatedTextbox,searchString[index]);
		optionSize = nameOfTheCollegeGraduatedTextboxField.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
			waits(2);
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void clickProspectiveStudentAdultLearnerButton() throws Exception {
		click(prospectiveStudentAdultLearnerButton);
	}
	public void clickProspectiveStudentMiddleSchoolStudentButton() throws Exception {
		click(prospectiveStudentMiddleSchoolStudentButton);
	}
	public void clickProspectiveStudentHighSchoolStudentButton() throws Exception {
		clickWithJavaScript(prospectiveStudentHighSchoolStudentButton);
	}
	public void enterCurrentHighSchoolName(String Value) throws Exception {
		clickWithJavaScript(currentHighSchoolNameTextbox);
		typeKeys(currentHighSchoolNameTextbox, Value);
		//typeKeysWithActions(currentHighSchoolNameTextbox, Value);
	}
	public void clickProspectiveStudentHighSchoolGraduateButton() throws Exception {
		click(highSchoolGraduateButton);
	}
	public void enterCurrentHighSchoolGraduated(String Value) throws Exception {
		//typeKeys(currentHighSchoolGraduatedTextbox, "Walter Wellborn School (Anniston, AL)");
		clickWithJavaScript(currentHighSchoolGraduatedTextbox);
		typeKeys(currentHighSchoolGraduatedTextbox, Value);
	}
	public void mouseHoverProspectiveStudentHighSchoolStudentButton() throws Exception {
		mouseHoverElement(prospectiveStudentHighSchoolStudentButton);
	}
	public void mouseHoverHighSchoolGraduateButton() throws Exception {
		mouseHoverElement(highSchoolGraduateButton);
	}
	public void mouseHoverProspectiveStudentCollegeStudentButton() throws Exception {
		mouseHoverElement(ProspectiveStudentCollegeStudentButton);
	}
	public void mouseHoverProspectiveStudentCollegeGraduateButton() throws Exception {
		mouseHoverElement(collegeGraduateButton);
	}
	public void mouseHoverProspectiveStudentAdultLearnerButton() throws Exception {
		mouseHoverElement(prospectiveStudentAdultLearnerButton);
	}
	public void mouseHoverProspectiveStudentMiddleSchoolStudentButton() throws Exception {
		mouseHoverElement(prospectiveStudentMiddleSchoolStudentButton);
	}
	public void verifyHighSchoolGraduationYearLabel() throws Exception {
		isPresentAndVisible(highSchoolGraduationYearLabel);
	}	
	public void verifyHighSchoolIntendedEnrollmentYearTermLabel() throws Exception {
		isPresentAndVisible(highSchoolIntendedEnrollmentYearTermLabel);
	}
	public void verifyHighSchoolGraduationYearDropdownDefaultValue() throws Exception {
		isPresentAndVisible(highSchoolGraduationYearDropdownDefaultValue);
	}
	public void verifyThanksMessageForUnder16DOB() throws Exception {
		isPresentAndVisible(thanksMessageForUnder6DOB);
	}
	public void tabAndEnterProspectiveStudentHighSchoolStudentButton() throws Exception {
		keyboardTab(prospectiveStudentHighSchoolStudentButton);
		keyboardEnter(prospectiveStudentHighSchoolStudentButton);
	}
	public void tabNextButton() throws Exception {
		waitAndFindElementByVisibility(nextButton);
		keyboardTab(nextButton);
	}
	public void keyboardEnterNextButton() throws Exception {
		waitAndFindElementByVisibility(nextButton);
		keyboardEnter(nextButton);
		Thread.sleep(3000);
	}
	public void pressEnterKey() {
		sendModifierKeys(Keys.ENTER);
	}
	public void tabFirstnameTextbox() throws Exception {
		keyboardTab(firstnameTextbox);
	}
	public void tabLastnameTextbox() throws Exception {
		keyboardTab(lastnameTextbox);
	}
	public void tabDOBField() throws Exception {
		keyboardTab(dobField);
	}
	public void tabPostalCodeTextbox() throws Exception {
		keyboardTab(postalCode);
	}
	public void tabCurrentHighSchoolNameTextbox() throws Exception {
		keyboardTab(currentHighSchoolNameTextbox);
	}
	public void tabintendedMajorDropdown() throws Exception {
		keyboardTab(intendedMajorDropdown);
	}
	public void tabintendedMajorTxtBx() throws Exception {
		keyboardTab(intendedMajorTextbox);
	}
	public void tabintendedMajorDropdownButton() throws Exception {
		keyboardTab(intendedMajorDropdownButton);
		keyboardEnter(intendedMajorDropdownButton);
	}
	public void typeIntentedMajorValue() throws Exception {
		int optionSize = 0;
		tabintendedMajorDropdown();
		tabintendedMajorTxtBx();
		tabintendedMajorDropdownButton();
		sendModifierKeys(Keys.SPACE);
		optionSize = intendedMajorDropdownsize.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			keyboardTab(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
			sendModifierKeys(Keys.ENTER);
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void tabGpaScoreTextbox() throws Exception {
		keyboardTab(gpaScoreTextbox);
	}
	public void tabActScoreTextbox() throws Exception {
		keyboardTab(actScoreTextbox);
	}
	public void tabSatScoreTextbox() throws Exception {
		keyboardTab(satScoreTextbox);
	}
	public void tabPhoneTextbox() throws Exception {
		keyboardTab(phoneTextbox);
	}
	public void tabGenderDropdown() throws Exception {
		keyboardTab(genderDropdown);
	}
	public void tabAcknowledgementCheckbox() throws Exception {
		keyboardTab(acknowledgementCheckbox);
	}
	public void tabDoneButton() throws Exception {
		isPresentAndVisible(doneButton);
		keyboardTab(doneButton);
		keyboardEnter(doneButton);
	}
	public void verifyWhereAreYouFromLabel() throws Exception {
		//waits(1000);
		isPresentAndVisible(whereAreYouFromLabel);
	}
	public void verifyCountryDropdown() throws Exception {
		isPresentAndVisible(countryDropdown);
	}
	public void verifyCountryTextbox() throws Exception {
		waitAndFindElementByVisibility(postalCode);
	}
	public void verifyUSACountryDefaultSelection() throws Exception {
		isPresentAndVisible(usaCountryDefaultSelection);
	}
	public void verifyPleaseEnterValidFirstNameErrorMessage() throws Exception {
		isPresentAndVisible(pleaseEnterValidFirstNameErrorMessage);
	}	
	public void verifyPleaseEnterValidLastNameErrorMessage() throws Exception {
		isPresentAndVisible(pleaseEnterValidLastNameErrorMessage);
	}
	public void verifyPleaseEnterValidDOBErrorMessage() throws Exception {
		isPresentAndVisible(pleaseEnterValidDOBErrorMessage);
	}
	public void verifyPleaseEnterValidEmailIDErrorMessage() throws Exception {
		isPresentAndVisible(pleaseEnterValidEmailIDErrorMessage);
	}
	public void verifyEnterValidPostalCodeAlertMessage() throws Exception {
		isPresentAndVisible(enterValidPostalCodeAlertMessage);
	}
	public void clickCloseButton() throws Exception {
		waitAndFindElementByVisibility(closeButton);
		clickWithJavaScript(closeButton);
	}
	public void clickCloseVRButton() throws Exception {
		click(closeVRButton);
	}
	public void switchToTheDefaultContent() throws Exception {
		switchToDefaultContent();
	}
	public void clickBookLink() throws Exception {
		clickWithJavaScript(bookLink);
	}
	public void clickRegisterButton() throws Exception {
		waitAndFindElementByVisibility(registerButton);
		click(registerButton);
	}
	public static int getRandomValue(int Min, int Max)
    {
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }
	public void typeCurrentHighSchoolName(String Value) throws Exception {
		//clickWithJavaScript(currentHighSchoolNameTextbox);
		clearTypeKeys(currentHighSchoolNameTextbox, Value);
		//typeKeysWithActions(currentHighSchoolNameTextbox, Value);
	}
	public void verifyWhereDoYouWorkLabel() throws Exception {
		isPresentAndVisible(whereDoYouWorkLabel);
	}
	public void enterTheNameOfTheCollegeGraduated() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String[] searchString= {"uni", "sch"};
		int index = r.nextInt(searchString.length);
		clickWithJavaScript(nameOfTheCollegeGraduatedTextbox);
		type(nameOfTheCollegeGraduatedTextbox,searchString[index]);
		optionSize = nameOfTheCollegeGraduatedTextboxField.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
			waits(2);
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void enterCurrentHighSchoolGraduated() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String searchString = "School";
		clickWithJavaScript(currentHighSchoolGraduatedTextbox);
		type(currentHighSchoolGraduatedTextbox,searchString);
		optionSize = nameOfTheCollegeGraduatedTextboxField.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void enterCurrentHighSchoolName() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String searchString = "School";
		clickWithJavaScript(currentHighSchoolNameTextbox);
		type(currentHighSchoolNameTextbox,searchString);
		waits(2);
		optionSize = nameOfTheCollegeGraduatedTextboxField.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
			waits(3);
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	}
