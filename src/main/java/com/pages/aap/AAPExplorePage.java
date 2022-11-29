package com.pages.aap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.Page;
import com.pages.PageInterface;
import com.utils.ElementUtil;

public class AAPExplorePage  extends ObjectsControl implements PageInterface {

	WebDriver driver;
	ElementUtil eleUtils;
	Page page;
	
	String pageTitle = "Audience Analytics Portal";
	
	@FindBy(xpath="//button[@aria-label='Inquiries Configuration']")
	WebElement configurationSettingsButton;
	
	@FindBy(xpath="//span[contains(@class,'-checkedColumnName')]")
	WebElement checkedColumnNamesChkBxs;
	
	@FindBy(xpath="//div[contains(@class,'-uncheckedColumns')]//span")
	WebElement uncheckedColumnNamesChkBxs;
	
	@FindBy(xpath="//span[contains(@class,'-checkedColumnName')][.='")
	WebElement checkedColumnNameChkBx;
	
	@FindBy(xpath="//*[.='Revert to Default']")
	WebElement revertToDefaultButton;
	
	@FindBy(xpath="//button[.='Apply']")
	WebElement applyButton;
	
	@FindBy(xpath="//button[.='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[.='Add to List']")
	WebElement addToListButton;
	
	@FindBy(xpath="//button[@aria-label='Inquiries Configuration']/following-sibling::div//div[contains(@class,'simplebar-track simplebar-vertical')]")
	WebElement configurationSettingsScrollbar;
	
	@FindBy(xpath="//div[@id='table-body']//div[@role='button']")
	WebElement firstRowOnInquiriesList;
	
	@FindBy(xpath="//button[@aria-label='Field Configuration']")
	WebElement fieldConfigurationSettingsIcon;
	
	@FindBy(xpath="//input[@placeholder='Search by Name']")
	WebElement exploreSearchTxtBx;

	@FindBy(xpath="//div[contains(@class,'-oval')]")
	WebElement xButtonOnExploreSearchTxtBx;
	
	@FindBy(xpath="(//input[@placeholder='Search by Name'])[2]")
	WebElement exploreAddToListSearchTxtBx;
	
	@FindBy(xpath="(//input[@placeholder='Search by Name'])[2]/following-sibling::div/div[contains(@class,'-oval')]")
	WebElement xButtonOnExploreAddToListSearchTxtBx;
	
	public AAPExplorePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		page = new Page(driver);
		eleUtils = new ElementUtil(driver);
	}
	
	public void clickConfigurationSettingsButton() throws Exception {
		isPresentAndVisible(configurationSettingsButton);
		clickWithJavaScript(configurationSettingsButton);
		ExtentTestManager.getTest().pass("Clicked on the configuration Settings button");
	}
	
	public void verifyColumnNamesWithCheckkBoxesChecked() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(checkedColumnNamesChkBxs), "Checked Column Names are not displayed");
		ExtentTestManager.getTest().pass("Checked Column Names are displayed");
	}
	
	public void verifyColumnNamesWithUncheckkBoxesChecked() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(uncheckedColumnNamesChkBxs), "Unchecked Column Names are not displayed");
		ExtentTestManager.getTest().pass("Unchecked Column Names are displayed");
	}
	
	public WebElement getCheckedSpecificColumnNameChkBxElement(String columnName) {
		return waitForAndFindElementByLocator(By.xpath("//span[contains(@class,'-checkedColumnName') and (contains(text(),'"+columnName+"'))]"));
	}
	
	public void verifyCheckedColumnNameList(String[] checkedColumnNamesList) throws Exception {
		for(String checkedColumnName:checkedColumnNamesList) {
			Assert.assertTrue(verifyFieldDisplayed(getCheckedSpecificColumnNameChkBxElement(checkedColumnName)), checkedColumnName+" Column Name is not checked");
			ExtentTestManager.getTest().pass(checkedColumnName+" Column Name is checked");
		}
	}
	
	public WebElement getUnCheckedSpecificColumnNameChkBxElement(String columnName) {
		try {
			return waitForAndFindElementByLocator(By.xpath("//div[@role='checkbox']//span[(not(contains(@class,'-checkedColumnName'))) and (contains(text(),\""+columnName+"\"))]"));
		}catch(Exception e) {
			WebElement divElement = waitForAndFindElementByLocator(By.xpath("//div[@data-simplebar='init']//div[@class='simplebar-content-wrapper']"));
			page.scrollToElementInDiv(divElement, 
					waitForAndFindElementByLocator(By.xpath("//div[@role='checkbox']//span[(not(contains(@class,'-checkedColumnName'))) and (contains(text(),\""+columnName+"\"))]")));	
		 return waitForAndFindElementByLocator(By.xpath("//div[@role='checkbox']//span[(not(contains(@class,'-checkedColumnName'))) and (contains(text(),\""+columnName+"\"))]"));
		}
	}
	
	public void verifyUnCheckedColumnNameList(String[] unCheckedColumnNamesList) throws Exception {
		for(String unCheckedColumnName:unCheckedColumnNamesList) {
			Assert.assertTrue(verifyFieldDisplayed(getUnCheckedSpecificColumnNameChkBxElement(unCheckedColumnName)), unCheckedColumnName+" Column Name is not checked");
			ExtentTestManager.getTest().pass(unCheckedColumnName +" Column Name is unchecked");
		}
	}
	
	public void verifyRevertToDefaultButtonDisplayed() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(revertToDefaultButton), "Revert to Default is not displayed");
		ExtentTestManager.getTest().pass("Revert to Default button is displayed");
	}
	
	public void verifyApplyButtonDisplayed() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(applyButton), "Apply button is not displayed");
		ExtentTestManager.getTest().pass("Apply button is displayed");
	}
	
	public void verifyCancelButtonDisplayed() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(cancelButton), "Cancel button is not displayed");
		ExtentTestManager.getTest().pass("Cancel button is displayed");
	}

	public void verifyUnCheckedColumNamesGotChecked(String[] uncheckedColumnNameList, String columnName) throws Exception {
		for(String unCheckedColumnName:uncheckedColumnNameList) {
//			clickWithJavaScript(getUnCheckedSpecificColumnNameChkBxElement(unCheckedColumnName));
//			ExtentTestManager.getTest().pass("Check "+unCheckedColumnName+" Column Name");
			if(unCheckedColumnName.equalsIgnoreCase(columnName)) {
				//u.mouseHover(driver1, getElement(driver1,"configuration_settings_slider_xpath",ext_test), ext_test);
				Actions actions = new Actions(driver);
				Action dragAndDrop = actions.clickAndHold(configurationSettingsScrollbar)
						.moveToElement(applyButton)
						.release(applyButton)
						.build(); 
				dragAndDrop.perform();
			}
		}
	}
	
	public void clickApplyButton() throws Exception {
		clickWithJavaScript(applyButton);
		ExtentTestManager.getTest().pass("Clicked on the Apply button");
	}
	
	public void clickFirstRowOnInquiriesList() throws Exception {
		click(firstRowOnInquiriesList);
		ExtentTestManager.getTest().pass("Clicked on the first row in Inquiries");
	}
	
	public void clickFieldConfigurationSettingsIcon() throws Exception {
		click(fieldConfigurationSettingsIcon);
		ExtentTestManager.getTest().pass("Clicked on the field configuration settings button");
	}
	
	public boolean verifyRevertToDefaultButtonEnabled() {
		return eleUtils.isEnabled(revertToDefaultButton);
	}
	
	public void clickRevertToDefaultButton() throws Exception{
		if(verifyRevertToDefaultButtonEnabled()) {
			click(revertToDefaultButton);
			ExtentTestManager.getTest().pass("Clicked on the Revert To Default button");
		}
	}
	
	public WebElement getFieldConfigurationCheckedSpecificColumnName(String columnName) {
		return waitForAndFindElementByLocator(By.xpath("//*[.='"+columnName+"']/../div[@aria-checked='true']"));
	}
	
	public void verifyFieldConfigurationCheckedList(String[] fieldConfigurationCheckedList) throws Exception {
		for(String checkedColumnName:fieldConfigurationCheckedList) {
			Assert.assertTrue(verifyFieldDisplayed(getFieldConfigurationCheckedSpecificColumnName(checkedColumnName)), checkedColumnName+" Column Name is not checked");
			ExtentTestManager.getTest().pass(checkedColumnName+" Column Name check box is checked");
		}
	}
	
	public void clickFieldConfigurationColumnNameChkBx(String columnName) throws Exception {
		click(waitForAndFindElementByLocator(By.xpath("//*[.='"+columnName+"']/../div[@aria-checked='true']")));
		ExtentTestManager.getTest().pass("Clicked on the "+columnName+" checkbox");
	}
	
	public void clickCancelButton() throws Exception {
		isPresentAndVisible(cancelButton);
		clickWithJavaScript(cancelButton);
		ExtentTestManager.getTest().pass("Clicked on the Cancel button");
	}
	
	public void clickAddToListButton() throws Exception{
		click(addToListButton);
		ExtentTestManager.getTest().pass("Clicked on te Add to list button");
	}
	
	public void verifyExploreSearchTxtBx() throws Exception {
		isPresentAndVisible(exploreSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(exploreSearchTxtBx), "Search textbox in Add to Explore page is not displayed");
	}
	
	public void typeExploreSearchTxtBx(String inquirerName) throws Exception {
		click(exploreSearchTxtBx);
		clearTypeKeys(exploreSearchTxtBx, inquirerName);
		//exploreSearchTxtBx.sendKeys(inquirerName);
		ExtentTestManager.getTest().pass("Enter "+inquirerName+" on the search text box in Explore page");
	}
	
	public void pressEnterOnExploreSearchTxtBx() {
		exploreSearchTxtBx.sendKeys(Keys.ENTER);
	}
	
	public void verifyXbuttonOnExploreSearchTxtBx() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(xButtonOnExploreSearchTxtBx), "x button in Search textbox is not displayed");
		ExtentTestManager.getTest().pass("\"x button in Explore Search textbox is not displayed");
	}
	
	public void clickXButtonOnExploreSearchTxtBx() throws Exception{
		click(xButtonOnExploreSearchTxtBx);
		ExtentTestManager.getTest().pass("Clicked the x button on search text box in Explore Page");
	}
	
	public void verifyExploreAddToListSearchTxtBx() throws Exception {
		isPresentAndVisible(exploreAddToListSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(exploreAddToListSearchTxtBx), "Search textbox in Add to List page is not displayed");
	}
	
	public void typeExploreAddToListSearchTxtBx(String listName) {
		exploreAddToListSearchTxtBx.sendKeys(listName);
		ExtentTestManager.getTest().pass("Enter "+listName+" on the search text box in Explore page");
	}
	
	public void pressEnterOnExploreAddToListSearchTxtBx() {
		exploreAddToListSearchTxtBx.sendKeys(Keys.ENTER);
	}
	
	public void verifyXbuttonOnExploreAddToListSearchTxtBx() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(xButtonOnExploreAddToListSearchTxtBx), "x button in Search textbox is not displayed");
		ExtentTestManager.getTest().pass("\"x button in Explore Search textbox is not displayed");
	}
	
	public void clickXButtonOnExploreAddToListSearchTxtBx() throws Exception{
		click(xButtonOnExploreAddToListSearchTxtBx);
		ExtentTestManager.getTest().pass("Clicked the x button on search text box in Explore Page");
	}

}
