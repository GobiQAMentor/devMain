package com.pages.aap;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.Page;
import com.pages.PageInterface;


public class AAPExperienceInsightPage extends ObjectsControl implements PageInterface{

	WebDriver driver;
	Page page;

	@FindBy(xpath = "//div[contains(@class,'profile')]")
 	WebElement profileIcon;
	
	@FindBy(xpath = "//span[contains(text(),'Help')]")
 	WebElement helpLink;

	@FindBy(xpath = "//span[.='Account Settings']/../following-sibling::div[text()='Name']")
 	WebElement accountSettingName;
	
	@FindBy(xpath = "//span[.='Account Settings']/../following-sibling::div[text()='Email']")
 	WebElement accountSettingEmail;
	
	@FindBy(xpath = "//a[.='Go to YouVisit CMS']")
 	WebElement goToCmsLink;
	
	@FindBy(xpath = "//a[.='Go to Aria Optimize']")
 	WebElement goToAriaOptimizeLink;
	
	@FindBy(xpath = "//button[.='Logout']")
 	WebElement logoutBtn;
	
	@FindBy(xpath = "//input[@name='selectionInput']")
 	WebElement institutionNameDropDown;
	
//==
	@FindBy(xpath = "//input[@name='selectionInput']/div")
 	WebElement institutionNameDropDownScrollDiv;
//==//	
	@FindBy(xpath = "//input[@name='filterInput']")
 	WebElement institutionNameSearchTxtBx;
	
	@FindBy(xpath = "//button[.='Download']")
 	WebElement downloadBtn;;
	
	String pageTitle = "Audience Analytics Portal";
	
	public AAPExperienceInsightPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		page = new Page(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProfileIcon() {
		waitAndFindElementByVisibility(profileIcon);
		isPresentAndVisible(profileIcon);
	}
	
	public void clickProfileIcon() throws Exception {
		click(profileIcon);
	}
	
	public void verifyHelpLink() {
		isPresentAndVisible(helpLink);
	}
	
	public void verifyCmsLink() {
		isPresentAndVisible(goToCmsLink);
	}
	
	public void verifyAriaOtimizerLink() {
		isPresentAndVisible(goToAriaOptimizeLink);
	}
	
	public void clickLogoutBtn() throws Exception {
		click(logoutBtn);
	}
	
	public void verifyNameDisplayed() {
		isPresentAndVisible(accountSettingName);
	}

	public void verifyEmailDisplayed() {
		isPresentAndVisible(accountSettingEmail);
	}
//==
	public void verifyInsighsPage() throws Exception {
		verifyInsightsPageTitle();
		ExtentTestManager.getTest().pass("Audience Analytics Portal title appeared on Experience Insight Page");
		waitForInsightsPageToLoad();
		verifyProfileIcon();
		ExtentTestManager.getTest().pass("ProfileIcon displayed on Experience Insight Page");
	}
//==//	
	public boolean verifyInsightsPageTitle() {
		return verifyPageTitle(pageTitle);
	}
	
	public void waitForInsightsPageToLoad() throws Exception {
		waitForElementInvisibilityWithBy(loadingBy);
		Thread.sleep(2000);
		if( Thread.currentThread().getName().equals("macchrome")) {
			Thread.sleep(6000);
			System.err.println("This line is for waiting in case of macchrome");
		}
			
	}
	
	public void clickInstitutionNameDropdown() throws Exception {
		Thread.sleep(3000);
		waitAndFindElementByVisibility(institutionNameDropDown);
		click(institutionNameDropDown);
	}
	
	public WebElement institutionNameAutoFillOption(String institutionName) {
		return waitForAndFindElementByLocator(By.xpath("//span[contains(text(),'"+ institutionName +"')]"));
	}

	public void clickInstitutionNameAutofillOption(String universityName) throws Exception {
		click(institutionNameAutoFillOption(universityName));
	}
	

	public void selectInstitutionName(String universityName, String browserName) throws Exception {
		clickInstitutionNameDropdown();
		ExtentTestManager.getTest().pass("Click on Institution dropdown");
		if(browserName.equalsIgnoreCase("firefox")) {
			typeValue(institutionNameSearchTxtBx, universityName);
		}else
			typeKeysWithActions(institutionNameSearchTxtBx, universityName);
		ExtentTestManager.getTest().pass("Clear and enter University name as "+universityName+" in Institution name search box");
		clickInstitutionNameAutofillOption(universityName);
		ExtentTestManager.getTest().pass("Click the "+universityName+" from the auto-complete option displayed for the Institution name search box ");
	}
//==	
	public void scrollInstitutionNameAutoFilOptions(String universityName, String browserName) throws Exception {
		clickInstitutionNameDropdown();
		ExtentTestManager.getTest().pass("Click on Institution dropdown");
		if(browserName.equalsIgnoreCase("firefox")) {
			typeValue(institutionNameSearchTxtBx, universityName);
		}else
			typeKeysWithActions(institutionNameSearchTxtBx, universityName);
		//WebElement unversityNameAutoOption = waitForAndFindElementByLocator(By.xpath("//div[contains(@class,'h-dropdownItem')]//span[contains(text(),'"+universityName+"')]"));
		ExtentTestManager.getTest().pass("Scroll to the "+universityName+" in auto-complete options dropdown");
		clickInstitutionNameAutofillOption(universityName);
		ExtentTestManager.getTest().pass("Click the "+universityName+" from the auto-complete option displayed for the Institution name search box ");
		page.waitForInsightsPageToLoad();
	}
//==//	
	public void selectUniversityNameOptionFromDropdown(String universityName) throws Exception {
		click(waitForAndFindElementByLocator(By.xpath("//div[contains(@class,'h-dropdownItem')]//span[contains(text(),'"+universityName+"')]")));
		ExtentTestManager.getTest().pass("Selected the "+universityName+" from the dropdownOption");
	}
	
	public void clickDownload() throws Exception {
		click(downloadBtn);
		Thread.sleep(5000);
	}
	
	public boolean verifyDownloadButton() {
		return isPresentAndVisible(downloadBtn);
	}
	
	public String[] columnNamesListExpected() {
		String[] listOfColumnsExpected = new String[] {"location_name", "location_id", "name_first", "name_last", "name_full",
				"parent_name_first", "parent_name_last", "parent_name_full", "email", "parent_email", "phone", "parent_phone", 
				"geo_postal_code", "geo_city", "geo_state", "geo_country", "geo_street","date_of_birth", "gender", "ethnicity",
				"visitor_type", "visitor_type_hs_level_as_of_today", "visitor_type_hs_level_as_of_reg_date", "grad_year", "entry_term_year",
				"entry_term", "entry_year", "level_of_study", "major_intended", "school_name", "school_ceeb_code", "gpa", "sat", "act",
				"date_registered", "relative_engagement", "mode_of_study", "grad_programs", "adult_grad_programs",  "is_cif", "schedule_visit_cta_clicked", 
				"apply_now_cta_clicked", "register_now_cta_clicked", "date_last_active_with_my_institution", "date_last_active_in_eab_network",
				"citizenship", "needs_visa", "tcpa"};
		return listOfColumnsExpected;
	}
	
	public String[] columnNamesListNotExpected() {
		String[] listOfColumnsNotExpected = new String[0]; // {"is_cif"};
		return listOfColumnsNotExpected;
	}
	
	public Boolean verifyColumnName(String columnName) throws Exception {
		File folder = new File(System.getProperty("user.dir") + File.separator + "downloads");
		File[] listOfFiles = folder.listFiles();
		String fileName = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".csv")) {
				System.out.println("File = " + listOfFiles[i].getName());
				fileName = listOfFiles[i].getName();
			}
		}
		System.out.println(fileName);
		File file = new File(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line1 = br.readLine();
		String[] header = line1.split(",");
		Boolean flag = false;
		for(String columnHeader:header) {
			if(columnHeader.equalsIgnoreCase(columnName)) {
				flag = true;
				break;
			}
		}
		br.close();
		return flag;
	}

	public Boolean verifyColumnName2(String columnName, String browserName) throws Exception {
		File folder = new File(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads");

		File[] listOfFiles = folder.listFiles();
		
		File file = listOfFiles[0];
//		File[] listOfFiles = folder.listFiles();
//		String fileName = null;
//		for (int i = 0; i < listOfFiles.length; i++) {
//			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".csv")) {
//				System.out.println("File = " + listOfFiles[i].getName());
//				fileName = listOfFiles[i].getName();
//			}
//		}
//		File file =new File(System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads" + File.separator + "EAB"+finalTime+".csv");
	
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line1 = br.readLine();
		String[] header = line1.split(",");
		Boolean flag = false;
		for(String columnHeader:header) {
			if(columnHeader.equalsIgnoreCase(columnName)) {
				flag = true;
				break;
			}
		}
		br.close();
		return flag;
	}
}
