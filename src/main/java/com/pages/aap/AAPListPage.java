package com.pages.aap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AAPListPage  extends ObjectsControl implements PageInterface {

	WebDriver driver;
	ElementUtil eleUtils;
	Page page;
	
	String pageTitle = "Audience Analytics Portal";
	
	@FindBy(xpath="//button[.='Add to List']")
	WebElement addToListButton;
	
	@FindBy(xpath="//label[.='Create New']")
	WebElement createNewRadioButtonOnAddToList;
	
	@FindBy(xpath="//input[@placeholder='New list name']")
	WebElement createNewListNameTxtBxOnAddToList;
	
	@FindBy(xpath="(//button[text()='Add to List'])[2]")
	WebElement addToListButtonOnAddToList;
	
	@FindBy(xpath="//span[.='Lists']")
	WebElement listTabOnAddToList;
	
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
	
	@FindBy(xpath="//button[@aria-label='Inquiries Configuration']/following-sibling::div//div[contains(@class,'simplebar-track simplebar-vertical')]")
//	@FindBy(xpath="(//div[@data-simplebar='init']//div[@class='simplebar-content-wrapper'])[2]")
	WebElement configurationSettingsScrollbar;
	
	@FindBy(xpath="//div[@id='table-body']//div[@role='button']")
	WebElement firstRowOnInquiriesList;
	
	@FindBy(xpath="//button[@aria-label='Field Configuration']")
	WebElement fieldConfigurationSettingsIcon;
	
	@FindBy(xpath="//input[@placeholder='Search by Name']")
	WebElement inquiriesSearchTxtBx;
	
	@FindBy(xpath="//input[@placeholder='Search by List Name or Created By']")
	WebElement listSearchTxtBx;

	@FindBy(xpath="//div[contains(@class,'-oval')]")
	WebElement xButtonOnListSearchTxtBx;
	
	@FindBy(xpath="(//input[@placeholder='Search by Name'])[2]")
	WebElement listAddToListSearchTxtBx;
	
	@FindBy(xpath="(//input[@placeholder='Search by Name'])[2]/following-sibling::div/div[contains(@class,'-oval')]")
	WebElement xButtonOnListAddToListSearchTxtBx;
	

	public AAPListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleUtils = new ElementUtil(driver);
		page = new Page(driver);
	}
	
	public void clickAddToListButton() throws Exception{
		click(addToListButton);
		ExtentTestManager.getTest().pass("Clicked on te Add to list button");
	}
	
	public void clickCreateNewRadioButton() throws Exception {
		click(createNewRadioButtonOnAddToList);
		ExtentTestManager.getTest().pass("Clicked on te Create New radio button");
	}
	
	public WebElement getNewListNameTxtBxOnAddToList() {
		return waitAndFindElementByVisibility(createNewListNameTxtBxOnAddToList);
	}
	
	public void typeNewListNameTxtBxOfAddToList(String newListName) {
		getNewListNameTxtBxOnAddToList().sendKeys(newListName);
		ExtentTestManager.getTest().pass("Enter as ["+newListName+"] in the New List Name text box");
	}
//==	
	public void addColumnNamesForHrizontalScrollBar() throws Exception {
		
		clickConfigurationSettingsButton();
		try {
			getCheckedSpecificColumnNameChkBxElement("Gender");
			clickRevertToDefaultButton();
			clickApplyButton();
			clickConfigurationSettingsButton();
		}catch(Exception e) {
			//	clickConfigurationSettingsButton();
			System.err.println("Horizontal Scroll not enabled So selecting one more column Name...");
		}	
		clickUncheckedFieldConfigurationColumnNameChkBx("Gender");
		clickApplyButton();
	}
	
	public void scrollHorizontalLeft()  throws Exception {
		String jscript = "document.querySelector(\"div[class*='tableDiv']\").scrollLeft=1000";
		waits(3);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		ExtentTestManager.getTest().pass("Inquiries results table scrolled horizontally");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		js.executeScript(jscript);
		Thread.sleep(10000);
		ExtentTestManager.getTest().pass("Inquiries result table scrolled horizontally");
		clickConfigurationSettingsButton();
		clickRevertToDefaultButton();
		clickApplyButton();
	}
	public void scrollHorizontalRight()  throws Exception {
		String jscript = "document.querySelector(\"div[class*='tableDiv']\").scrollLeft=200";
		waits(3);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		ExtentTestManager.getTest().pass("Inquiries results table scrolled to left horizontally ");
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		js.executeScript(jscript);
		Thread.sleep(10000);
		ExtentTestManager.getTest().pass("Inquiries result table scrolled to left horizontally ");
		clickConfigurationSettingsButton();
		clickRevertToDefaultButton();
		clickApplyButton();
	}
//==//	
	
	public void clickAddToListButtonOnAddToList() throws Exception {
		click(addToListButtonOnAddToList);
		ExtentTestManager.getTest().pass("Clicked on Add to List button in Add To List popup");
	}
	
	public void clickListTab() throws Exception {
		waitAndFindElementByVisibility(listTabOnAddToList);
		clickWithJavaScript(listTabOnAddToList);
		ExtentTestManager.getTest().pass("Clicked on the List Tab");
		
	}

	public WebElement getInquirerNameListedOnInquiries(String nameOfTheInquirer) {
		return waitForAndFindElementByLocator(By.xpath("//div[text()='"+nameOfTheInquirer+"']"));
	}
	
	public void verifyInquirerNameListedOnInquiries(String nameOfTheInquirer) throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(getInquirerNameListedOnInquiries(nameOfTheInquirer)), nameOfTheInquirer+" in Inquiry Lists is not displayed");
		ExtentTestManager.getTest().pass(nameOfTheInquirer+" in Inquiry Lists is displayed");
	}
	
	public void clickInquirerNameFromInquiriesList(String nameOfTheInquirer) throws Exception{
		clickWithJavaScript(getInquirerNameListedOnInquiries(nameOfTheInquirer));
		ExtentTestManager.getTest().pass("Clicked on the inquirer ["+nameOfTheInquirer+"] from Inquiries list");
	}
	
	public void clickConfigurationSettingsButton() throws Exception {
		isPresentAndVisible(configurationSettingsButton);
		clickWithJavaScript(configurationSettingsButton);
		ExtentTestManager.getTest().pass("Clicked on the configuration Settings button");
	}
	
	public void verifyColumnNamesWithCheckedBoxesChecked() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(checkedColumnNamesChkBxs), "Checked Column Names are not displayed");
		ExtentTestManager.getTest().pass("Checked Column Names are displayed");
	}
	
	public void verifyColumnNamesWithUncheckedBoxesChecked() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(uncheckedColumnNamesChkBxs), "Unchecked Column Names are not displayed");
		ExtentTestManager.getTest().pass("Unchecked Column Names are displayed");
	}
	
	public WebElement getCheckedSpecificColumnNameChkBxElement(String columnName) {
		return waitForAndFindElementByLocator(By.xpath("//span[(contains(@class,'-checkedColumnName')) and (contains(text(),'"+columnName+"'))]"));
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
			ExtentTestManager.getTest().pass(unCheckedColumnName +" Column Name is checked");
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

	public void verifyUnCheckedSpecificColumName(String[] uncheckedColumnNameList, String columnName) throws Exception {
		for(String unCheckedColumnName:uncheckedColumnNameList) {
			clickWithJavaScript(getUnCheckedSpecificColumnNameChkBxElement(unCheckedColumnName));
			ExtentTestManager.getTest().pass("Check "+unCheckedColumnName+" Column Name");
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
	
	public void verifyListTabPresence() {
		isPresentAndVisible(listTabOnAddToList);
	}
	
	public void clickFirstRowOnInquiriesList() throws Exception {
		page.waitForInsightsPageToLoad();
		waitAndFindElementByVisibility(firstRowOnInquiriesList);
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
	
	public void clickUncheckedFieldConfigurationColumnNameChkBx(String columnName) throws Exception {
		click(waitForAndFindElementByLocator(By.xpath("//*[.='"+columnName+"']/../div[@aria-checked='false']")));
		ExtentTestManager.getTest().pass("Clicked on the unchecked "+columnName+" checkbox");
	}
	
	public void clickCancelButton() throws Exception {
		waitAndFindElementByVisibility(cancelButton);
		clickWithJavaScript(cancelButton);
		ExtentTestManager.getTest().pass("Clicked on the Cancel button");
	}
	
	public void verifyInquiriesSearchTxtBx() throws Exception {
		isPresentAndVisible(inquiriesSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(inquiriesSearchTxtBx), "Search textbox in Inquiries page is not displayed");
	}
	
	public void typeInquiriesSearchTxtBx(String inquirerName) throws Exception {
		clickWithJavaScript(inquiriesSearchTxtBx);
		typeKeysWithActions(inquiriesSearchTxtBx, inquirerName);
		//inquiriesSearchTxtBx.sendKeys(inquirerName);
		ExtentTestManager.getTest().pass("Enter "+inquirerName+" on the search text box in Inquiries page");
		page.waitForInsightsPageToLoad();
	}
	
	public void pressEnterOnInquiriesSearchTxtBx() {
		inquiriesSearchTxtBx.sendKeys(Keys.ENTER);
	}
	
	public void verifyListSearchTxtBx() throws Exception {
		page.waitForInsightsPageToLoad();
		isPresentAndVisible(listSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(listSearchTxtBx), "Search textbox in Add to Explore page is not displayed");
	}
	
	public void typeListSearchTxtBx(String inquirerName) {
		clearTypeKeys(listSearchTxtBx,inquirerName);
		ExtentTestManager.getTest().pass("Enter "+inquirerName+" on the search text box in Explore page");
	}
	
	public void pressEnterOnListSearchTxtBx() {
		listSearchTxtBx.sendKeys(Keys.ENTER);
	}
	
	public void verifyXbuttonOnListSearchTxtBx() throws Exception {
		page.waitForInsightsPageToLoad();
		//waitAndFindElementByVisibility(xButtonOnListSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(xButtonOnListSearchTxtBx), "x button in Search textbox is not displayed");
		ExtentTestManager.getTest().pass("\"x\" button in Explore Search textbox is not displayed");
	}
	
	public void clickXButtonOnListSearchTxtBx() throws Exception{
		page.waitForInsightsPageToLoad();
		click(xButtonOnListSearchTxtBx);
		ExtentTestManager.getTest().pass("Clicked the x button on search text box in Explore Page");
		page.waitForInsightsPageToLoad();
	}
	
	public void verifyListAddToListSearchTxtBx() throws Exception {
		isPresentAndVisible(listAddToListSearchTxtBx);
		Assert.assertTrue(verifyFieldDisplayed(listAddToListSearchTxtBx), "Search textbox in Add to List page is not displayed");
	}
	
	public void typeListAddToListSearchTxtBx(String listName) {
		listAddToListSearchTxtBx.sendKeys(listName);
		ExtentTestManager.getTest().pass("Enter "+listName+" on the search text box in ListPage page");
	}
	
	public void pressEnterOnListAddToListSearchTxtBx() {
		listAddToListSearchTxtBx.sendKeys(Keys.ENTER);
	}
	
	public void verifyXbuttonOnListAddToListSearchTxtBx() throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(xButtonOnListAddToListSearchTxtBx), "x button in Search textbox is not displayed");
		ExtentTestManager.getTest().pass("\"x button in List Search textbox is not displayed");
	}
	
	public void clickXButtonOnListAddToListSearchTxtBx() throws Exception{
		click(xButtonOnListAddToListSearchTxtBx);
		ExtentTestManager.getTest().pass("Clicked the x button on search text box in ListPage Page");
	}
	
}
