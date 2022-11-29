package com.pages.desktopCIF;

import java.util.List;
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
import com.pages.PageInterface;

public class ParentAndGuardianPage  extends ObjectsControl implements PageInterface{
	WebDriver driver;
	@FindBy(xpath = "//button[@value='parent']")
	WebElement parentGuardianButton;
	@FindBy(xpath = "//button[@value='parent_college_grad']")
	WebElement parentGuardianCollegeGraduateButton;
	@FindBy(id = "postal")
	WebElement postalCode;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement nameOfTheChildsCollageGraduate;
	@FindBys(@FindBy(xpath = "//input[contains(@id,'downshift')]"))
	List<WebElement> indendedMajorDropdownsize;
	@FindBy(xpath = "//input[contains(@id,'downshift')]")
	WebElement indendedMajorDropdown;
	@FindBy(xpath = "//button[@aria-label='open menu']")
	WebElement indendedMajorDropdownButton;
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
	@FindBy(xpath = "//button[@value='parent_middle_school']")
	WebElement parentGuardianMiddleSchoolButton;
	@FindBy(xpath = "//button[@value='parent_hs_student']")
	WebElement parentGuardianHighSchoolStudentButton;
	@FindBy(xpath = "//button[@value='parent_hs_grad']")
	WebElement parentGuardianHighSchoolGraduateButton;
	@FindBy(xpath = "//button[@value='parent_xfer_student']")
	WebElement parentGuardianCollegeStudentButton;
	@FindBy(xpath = "//button[@value='veteran']")
	WebElement veteranButton;
//	@FindBy(xpath = "//label[text()='Share your scores']")
	@FindBy(xpath = "//label[text()='SHOW YOUR CHILD’S NUMBERS!' or text()='Share your scores']")
	WebElement shareYourScoreLabel;
	
	@FindBy(xpath = "//button[.='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  sat')]")
	WebElement enterValidSatAlertMessage;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  act')]")
	WebElement enterValidActAlertMessage;
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid  gpa')]")
	WebElement enterValidGpaAlertMessage;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> optionsField;
	public ParentAndGuardianPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickParentGuardianButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianButton);
		clickWithJavaScript(parentGuardianButton);
	}
	public void clickParentGuardianCollegeGraduateButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianCollegeGraduateButton);
		clickWithJavaScript(parentGuardianCollegeGraduateButton);
	}
	public void enterPostalCode(String Value) throws Exception {
		clearTypeKeys(postalCode, Value);
	}
	public void enterNameOfTheChildsCollageGraduate() throws Exception {
		waitAndFindElementByVisibility(nameOfTheChildsCollageGraduate);
		clickWithJavaScript(nameOfTheChildsCollageGraduate);
		typeKeys(nameOfTheChildsCollageGraduate, "My School Is Not Listed - Domestic");
	}
	public void selectintendedDropdownOptionDynamic() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(indendedMajorDropdownButton);
		optionSize = indendedMajorDropdownsize.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void enterIndendedMajorDropdown() throws Exception {
		isPresentAndVisible(indendedMajorDropdown);
		click(indendedMajorDropdown);
		selectintendedDropdownOptionDynamic();
	}
	public static int getRandomValue(int Min, int Max)
    {
        return ThreadLocalRandom.current().nextInt(Min, Max + 1);
    }
	public void enterSatScoreTextbox() throws Exception {
//		Thread.sleep(2000);
		isPresentAndVisible(shareYourScoreLabel);	
		clickWithJavaScript(satScoreTextbox);
		clearTypeKeys(satScoreTextbox, "400");
	}
	public void enterActScoreTextbox() throws Exception {
		clearTypeKeys(actScoreTextbox, "2");
	}
	public void enterGpaScoreTextbox() throws Exception {
		clearTypeKeys(gpaScoreTextbox, ".3");
	}
	public void enterPhoneNumber(String phoneNo) throws Exception {
		type(phoneTextbox, phoneNo);
	}
	public void clickGenderDropdown() throws Exception {
		isPresentAndVisible(genderDropdown);
		clickWithJavaScript(genderDropdown);
	}
	public void selectGenderMaleOption() throws Exception {
		clickWithJavaScript(genderMaleOption);
	}
	public void clickAcknowledgementCheckbox() throws Exception {
		clickWithJavaScript(acknowledgementCheckbox);
	}
	public void clickParentGuardianMiddleSchoolButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianMiddleSchoolButton);
		clickWithJavaScript(parentGuardianMiddleSchoolButton);
	}
	public void clickParentGuardianHighSchoolStudentButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianHighSchoolStudentButton);
		clickWithJavaScript(parentGuardianHighSchoolStudentButton);
	}
	public void clickParentGuardianHighSchoolGraduateButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianHighSchoolGraduateButton);
		clickWithJavaScript(parentGuardianHighSchoolGraduateButton);
	}
	public void clickParentGuardianCollegeStudentButton() throws Exception {
		waitAndFindElementByVisibility(parentGuardianCollegeStudentButton);
		clickWithJavaScript(parentGuardianCollegeStudentButton);
	}
	public void clickVeteranButton() throws Exception {
		click(veteranButton);
	}
	public void mouseHoverParentGuardianHighSchoolStudentButton() throws Exception {
		mouseHoverElement(parentGuardianHighSchoolStudentButton);
	}
	public void mouseHoverParentGuardianHighSchoolGraduateButton() throws Exception {
		mouseHoverElement(parentGuardianHighSchoolGraduateButton);
	}
	public void mouseHoverParentGuardianCollegeStudentButton() throws Exception {
		mouseHoverElement(parentGuardianCollegeStudentButton);
	}
	public void mouseHoveParentGuardianCollegeGraduateButton() throws Exception {
		mouseHoverElement(parentGuardianCollegeGraduateButton);
	}
	public void mouseHoverParentGuardianMiddleSchoolButton() throws Exception {
		mouseHoverElement(parentGuardianMiddleSchoolButton);
	}
	public void clickNextButton() throws Exception {
		click(nextButton);
		Thread.sleep(2000);
	}
	public void enterInvalidSatScoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid sat score");
		clearTypeKeys(satScoreTextbox, "300");
		clickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
		clearTypeKeys(satScoreTextbox, "1601");
		clickNextButton();
		isPresentAndVisible(enterValidSatAlertMessage);	
	}
	public void enterInvalidActScoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid ACT score");
		clearTypeKeys(actScoreTextbox, "0");
		clickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
		clearTypeKeys(actScoreTextbox, "37");
		clickNextButton();
		isPresentAndVisible(enterValidActAlertMessage);	
	}
	public void enterInvalidGpacoreAndVerifyTheErrorMessage() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);	
		ExtentTestManager.getTest().pass("Enter the invalid GPA score");
		clearTypeKeys(gpaScoreTextbox, "4.1");
		clickNextButton();
		isPresentAndVisible(enterValidGpaAlertMessage);	
	}
	public void enterTheNameOfTheChildsCollageGraduate() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(nameOfTheChildsCollageGraduate);
		optionSize = optionsField.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
}