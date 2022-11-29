package com.pages.desktopRegistrationLegacyForm;

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

import com.controls.ObjectsControl;
import com.driver.DriverInstance;
import com.github.javafaker.Faker;
import com.pages.PageInterface;

public class DesktopRegistrationLegacyFormPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	Faker faker = new Faker();
	@FindBy(id = "gpa")
	WebElement gpaScoreTextbox;
	@FindBy(id = "act")
	WebElement actScoreTextbox;
	@FindBy(id = "sat")
	WebElement satScoreTextbox;
	@FindBy(xpath = "//label[contains(text(),'HIGH SCHOOL GRADUATION YEAR')]/following-sibling::button[contains(text(),'2022')]")
	WebElement highSchoolGraduationYearDropdownDefaultValue;
	@FindBy(xpath = "//label[contains(text(),'INTENDED ENROLLMENT YEAR & TERM')]/following-sibling::button[contains(text(),'2023')]")
	WebElement intendedEnrollmentYearAndTermDropdownDefaultValue;
	@FindBy(xpath = "//label[contains(text(),'HIGH SCHOOL GRADUATION YEAR')]")
	WebElement childHighSchoolGraduationYearLabel;
	@FindBy(xpath = "//label[contains(text(),'INTENDED ENROLLMENT YEAR & TERM')]")
	WebElement childIndendedEnrollmentYearTermLabel;
	@FindBy(xpath = "//label[text()='SHOW YOUR CHILD’S NUMBERS!' or text()='Share your scores']")
	WebElement shareYourScoreLabel;
	@FindBy(xpath = "//div[contains(@class,'Component-barContainer')]")
	WebElement almostDoneMessageBar;
	@FindBy(xpath = "//label[contains(text(),'ETHNICITY')]")
	WebElement childEthnicityLabel;
	@FindBy(xpath = "//label[contains(text(),'ETHNICITY')]/following-sibling::label/following-sibling::button[contains(text(),'Select')]")
	WebElement childEthnicityDropdown;
	@FindBy(css = "iframe[id='iframe-modal-iframe']")
	WebElement virtualTourFrame;
	@FindBy(css = "//button[@name='enrolltermyear']")
	WebElement childsIntendedEnrollmentYearAndTermDropdown;
	@FindBy(xpath = "//button[@name='gender_more']")
	WebElement genderDropdown;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> genderDropdownOptions;
	@FindBy(xpath = "//button[@name='enrolltermyear']")
	WebElement childrensIntendedEnrollmentYearAndTermDropdown;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> optionsField;
	@FindBy(xpath = "//input[contains(@id,'parent_phone')]")
	WebElement yourPhoneTextbox;
	@FindBy(xpath = "//button[@name='graduationyear']")
	WebElement childrensHighSchoolGraduationYearDropdown;
	
	public DesktopRegistrationLegacyFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToDesktopRegistrationLegacyFormPageLogin(String url) throws Exception {
		deleteAllCookies();
		//		refreshPage();
		driver.get(url);
		//		deleteAllCookies();
		//		driver.get(url);
	}

	public void findVirtualTourFrame() throws Exception {
		while(!isPresentAndVisibleVersion2(virtualTourFrame)) {
			navigateToDesktopRegistrationLegacyFormPageLogin(DriverInstance.prop.getProperty("env1")+DriverInstance.prop.getProperty("url_vt1"));
		}
	}

	public void enterSatScoreTextbox() throws Exception {
		isPresentAndVisible(shareYourScoreLabel);
		clearTypeKeys(satScoreTextbox, "400");
	}
	public void enterActScoreTextbox() throws Exception {
		clearTypeKeys(actScoreTextbox, "2");
	}
	public void enterGpaScoreTextbox() throws Exception {
		clearTypeKeys(gpaScoreTextbox, ".3");
	}
	public void verifyHighSchoolGraduationYearDropdownDefaultValue() throws Exception {
		isPresentAndVisible(highSchoolGraduationYearDropdownDefaultValue);
	}
	public void verifyIntendedEnrollmentYearAndTermDropdownDefaultValue() throws Exception {
		isPresentAndVisible(intendedEnrollmentYearAndTermDropdownDefaultValue);
	}
	public void verifyChildHighSchoolGraduationYearLabel() throws Exception {
		isPresentAndVisible(childHighSchoolGraduationYearLabel);
	}
	public void verifyChildIndendedEnrollmentYearTermLabel() throws Exception {
		isPresentAndVisible(childIndendedEnrollmentYearTermLabel);
	}
	public void verifyAlmostDoneMessageBar() throws Exception {
		isPresentAndVisible(almostDoneMessageBar);
	}
	public void verifyChildEthnicityLabel() throws Exception {
		isPresentAndVisible(childEthnicityLabel);
	}
	public void verifyChildEthnicityDropdown() throws Exception {
		isPresentAndVisible(childEthnicityDropdown);
	}
	public void verifyChildIntendedEnrollmentYearAndTermDropdown() throws Exception {
		isPresentAndVisibleVersion2(childsIntendedEnrollmentYearAndTermDropdown);
	}
	public static int getRandomValue(int Min, int Max)
	{
		return ThreadLocalRandom.current().nextInt(Min, Max + 1);
	}

	public void selectGenderDropdownOptionDynamic() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(genderDropdown);
		optionSize = genderDropdownOptions.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}

	public void enterGenderDropdown(String Value) throws Exception {
		selectGenderDropdownOptionDynamic();
	}
	public void selectEthnicityDropdownOptionDynamic() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(childEthnicityDropdown);
		optionSize = genderDropdownOptions.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}

	public void selectSATScore() throws Exception {
		Random r = new Random();
		int value  = ThreadLocalRandom.current().nextInt(400, 1600);
		clickWithJavaScript(satScoreTextbox);
		type(satScoreTextbox,Integer.toString(value));
	}
	public void selectACTScore() throws Exception {
		Random r = new Random();
		int value  = ThreadLocalRandom.current().nextInt(1, 36);
		clickWithJavaScript(actScoreTextbox);
		type(actScoreTextbox,Integer.toString(value));
	}
	public void selectGPAScore(String value) throws Exception {
		clickWithJavaScript(gpaScoreTextbox);
		type(gpaScoreTextbox,value);

	}

	public void intendedenrollmentYearAndTermsDropdown() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(childrensIntendedEnrollmentYearAndTermDropdown);
		optionSize = optionsField.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
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
	public  Map<String, String> setData() throws Exception{
		Map<String, String> data = new HashMap<>();	
		data.put("ParentPhoneNumber", faker.number().digits(10).toString());
		//data.put("ParentPhoneNumber", faker.phoneNumber().subscriberNumber(10));	
		return data;
	}
	public void enterParentPhoneNumber(String phoneNo) throws Exception {
		type(yourPhoneTextbox,phoneNo);

	}
	public void childrensHighSchoolGraduationYearDropdown() throws Exception {
		int optionSize = 0;
		clickWithJavaScript(childrensHighSchoolGraduationYearDropdown);
		optionSize = optionsField.size();
		if(optionSize > 0) {
			int optionNo = getRandomValue(1, optionSize);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
}	
