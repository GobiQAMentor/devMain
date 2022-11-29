package com.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;

public class AAPLeftFilterPage extends ObjectsControl implements PageInterface{


	@FindBy(xpath = "//label[.='Select Recency']/following-sibling::button")
 	WebElement recencyDropDownSelect;
	
	@FindBy(xpath = "//span[.='Inquiries']/preceding-sibling::span")
 	WebElement noOfInquiries;
	
	@FindBy(xpath = "//li[.='Within Last 365 Days']")
 	WebElement option365Days;

	@FindBy(xpath = "//span[.='Demographics ']")
 	WebElement demographicsMainFilter;
	
	@FindBy(xpath = "//span[.='Visitor Type']")
 	WebElement visitorTypeMainFilter;
	
	@FindBy(xpath = "//span[.='Geography']")
 	WebElement geographyMainFilter;
	
	@FindBy(xpath = "//span[.='Age']")
 	WebElement ageMainFilter;
	
	@FindBy(xpath = "//span[.='Gender']")
 	WebElement genderMainFilter;
	
	@FindBy(xpath = "//span[.='Ethnicity']")
 	WebElement ethinicityMainFilter;
	
	@FindBy(xpath = "//span[.='Prospective Student']")
 	WebElement prospectiveStudentMainFilter;
	
	@FindBy(xpath = "//span[.='Parent of Prospect']")
 	WebElement parentOfProspectMainFilter;
	
	@FindBy(xpath = "//span[.='Other']")
 	WebElement otherMainFilter;
	
	@FindBy(xpath = "//div[text()='Other']")
 	WebElement otherSubFilterOfUSRegions;
	
	@FindBy(xpath = "//input[@placeholder='Search State/Territory']")
 	WebElement searchByStateTxtBx;
	
	@FindBy(xpath = "//span[contains(text(),'Demographics')]//following::div[contains(@class,'rootAccordionIndicatorContainer')]")
	WebElement demographicsFilterCollapseIcon;
	
	@FindBy(xpath = "//div[text()='USA']")
 	WebElement usaSubFilterOfGeography;
	
	@FindBy(xpath = "//div[text()='International']")
 	WebElement internationalSubFilterOfGeography;
	
	@FindBy(xpath = "//div[text()='USA']/parent::div/div']")
	WebElement usaSubFilterChkBxofGeography;
	
	@FindBy(xpath = "//input[@placeholder='Search Country']")
 	WebElement searchCountriesTxtBx;
	
	@FindBy(xpath = "//button[.='Reset']")
 	WebElement resetFiltersButton;
	
	@FindBy(xpath = "//div[@class='simplebar-content-wrapper']")
 	WebElement ethnicityLeftMenuBarDiv;

	@FindBy(xpath = "//span[text()='Engagement (1)']")
 	WebElement engagementMainFilter;
	
	@FindBy(xpath = "//span[text()='Date Registered with My Institution']")
 	WebElement dateRegisteredWithMyInstitutionMainFilter;
	
	@FindBy(xpath = "//span[text()='Relative Engagement']")
 	WebElement relativeEngagementMainFilter;

	@FindBy(xpath = "//span[text()='Total Time Spent in My VT and/or IWC']")
 	WebElement totalTimeSpentOnVtAndOrIwcMainFilter;
	
	@FindBy(xpath = "//span[text()='Schedule Visit CTA Clicked']")
 	WebElement scheduleVisitCTAClickedMainFilter;
	
	@FindBy(xpath = "//span[text()='Apply Now CTA Clicked']")
 	WebElement applyNowCTAClickedMainFilter;
	
	@FindBy(xpath = "//span[text()='Activity with My Institution']")
 	WebElement activityWithMyInstitutionMainFilter;
	
	@FindBy(xpath = "//span[text()='Activity with EAB Network']")
 	WebElement activityWithEABNetworkMainFilter;

	@FindBy(xpath = "//label[.='Select VT and/or IWC']/following-sibling::button")
 	WebElement totalTimeSpentOnVtAndOrIwcDropDown;
	
	@FindBy(xpath = "//span[text()='List Membership ']")
 	WebElement listMembershipMainFilter;

	@FindBy(xpath = "//span[text()='List Membership ']")
 	WebElement listMembershipsearchListTxtBx;
	
	@FindBy(xpath = "//button[.='Add to List']")
 	WebElement addToListButton;
	
	@FindBy(xpath = "//label[.='Create New']")
 	WebElement createNewListChkBx;

	@FindBy(xpath = "//input[@placeholder='New list name']")
 	WebElement newListNameTxtBxInAddToList;
	
	@FindBy(xpath = "(//button[text()='Add to List'])[2]")
 	WebElement newAddToListButtonInAddToList;
	
	@FindBy(xpath = "//input[@placeholder='Search List']")
 	WebElement searchListTxtBxInExplorePage;
	
	@FindBy(xpath = "//span[.='Lists']")
 	WebElement listTab;
	
	@FindBy(xpath = "//button[@aria-label='open menu']")
	WebElement threeDotsButtonOfFirstListNameInListTab;
	
	@FindBy(xpath = "//*[.='Delete']")
	WebElement deleteMenuOfListNameThreeDots;
	
	@FindBy(xpath = "//span[text()='Prospect Profile ']")
 	WebElement prospectProfileMainFilter;
	
	@FindBy(xpath = "//span[text()='Intended Level of Study']")
 	WebElement intendedLevelOfStudySubFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Entry Term')]")
	WebElement entryTermSubfilter;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Select ')]")
	WebElement termYearTxtBxOfEntryTermFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Fall 2023')]")
 	WebElement termYearTxtBxAutofillOptionOfEntryTermFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Intended Major')]")
	WebElement intendedMajorSubfilterOfProspectProfile;
	
	@FindBy(xpath = "//input[@placeholder='Search Major']")
	WebElement IntendMajorSearchTxtBx;
	
	@FindBy(xpath = "//span[contains(text(),'GPA')]")
	WebElement gpaSubfilterOfProspectProfile;
//==	
	@FindBy(xpath = "//input[@aria-label='Select Year Range' and @id='handleOne']")
	WebElement specificGPAScrollbarStartRange;
	
	@FindBy(xpath = "//input[@aria-label='Select Year Range' and @id='handleTwo']")
	WebElement specificGPAScrollbarEndRange;
//==//	
	@FindBy(xpath = "//span[contains(text(),'Test Scores')]")
	WebElement testScoresSubfilterOfProspectProfile;
	
	@FindBy(xpath = "//*[.='Select SAT and/or ACT']//following-sibling::button")
	WebElement selectBoxOfTestScoresSubFilter;
	
	@FindBy(xpath = "//span[contains(text(),'Locations')]")
	WebElement locationsMainFilter;

	@FindBy(xpath = "//div[@id='table-body']//div[@style]/div[2]")
	WebElement firstRowFirstCellOnInquiriesTable;
	
	@FindBy(xpath = "(//div[@id='table-body']//div[@style]/div[2])[last()]")
	WebElement lastRowFirstCellOnInquiriesTable;
	
	@FindBy(xpath = "//button[@aria-label='previous page']")
	WebElement previousPageButton;
	
	@FindBy(xpath = "//button[@aria-label='next page']")
	WebElement nextPageButton;
	
	WebDriver driver;
	Page page = null;

	public AAPLeftFilterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		page = new Page(driver);
	}

	public boolean pageVerify(String title) {
		return verifyPageTitle(title);
	}
	
	public void selectRecency() throws Exception {
		waitAndFindElementByVisibility(recencyDropDownSelect);
		if(totalNumberOfInquiries()< 10) {
			click(recencyDropDownSelect);
			click(option365Days);
			Thread.sleep(1000);
			page.waitForInsightsPageToLoad();
		}
	}
	
	public boolean verifyFilterDisplayed(WebElement filterElement, String elementText) throws Exception{
		if(verifyFieldDisplayed(filterElement)) {
				ExtentTestManager.getTest().pass(elementText + " filter is displayed");
				return true;
		}else {
				ExtentTestManager.getTest().fail(elementText + " filter is not displayed");
				return false;
		}
	}
	
	public boolean verifyDemographicsMainFilterDisplayed() throws Exception {
		isPresentAndVisible(demographicsMainFilter);
		return verifyFilterDisplayed(demographicsMainFilter, "Demographics");
	}
	
	public void clickDemographicMainFilter() throws Exception {
		click(demographicsMainFilter);
		page.waitForInsightsPageToLoad();
	}
	
	public boolean verifyVisitorTypeMainFilterDisplayed() throws Exception {
		return verifyFilterDisplayed(visitorTypeMainFilter, "Visitor Type");
	}
	
	public void clickVisitorTypeMainFilter() throws Exception {
		click(visitorTypeMainFilter);
		page.waitForInsightsPageToLoad();
	}
	
	public boolean verifyGeographyMainFilterDisplayed() throws Exception {
		waitAndFindElementByVisibility(geographyMainFilter);
		return verifyFilterDisplayed(geographyMainFilter, "Geography");
	}
	
	public boolean verifyAgeMainFilterDisplayed() throws Exception {
		page.waitForInsightsPageToLoad();
		waitAndFindElementByVisibility(ageMainFilter);
		return verifyFilterDisplayed(ageMainFilter, "Age");
	}
	
	public boolean verifyGenderMainFilterDisplayed() throws Exception {
		waitAndFindElementByVisibility(genderMainFilter);
		return verifyFilterDisplayed(genderMainFilter, "Gender");
	}
	
	public boolean verifyEthinicityMainFilterDisplayed() throws Exception {
		waitAndFindElementByVisibility(ethinicityMainFilter);
		return verifyFilterDisplayed(ethinicityMainFilter, "Ethinicity");
	}
	
	public boolean verifyProspectiveStudentMainFilterDisplayed() throws Exception {
		return verifyFilterDisplayed(prospectiveStudentMainFilter, "Prospective Student");
	}
	
	public void clickProspectiveStudentMainFilter() throws Exception {
		click(prospectiveStudentMainFilter);
		page.waitForInsightsPageToLoad();
	}
	
	public boolean verifyParentOfProspecttMainFilterDisplayed() throws Exception {
		return verifyFilterDisplayed(parentOfProspectMainFilter, "Parent Of Prospect");
	}
	
	public void clickParentOfProspecttMainFilter() throws Exception {
		click(parentOfProspectMainFilter);
		page.waitForInsightsPageToLoad();
	}
	
	public boolean verifyOtherMainFilterDisplayed() throws Exception {
		return verifyFilterDisplayed(otherMainFilter, "Other");
	}
	
	public void clickOtherMainFilter() throws Exception {
		click(otherMainFilter);
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement verifyProspectiveStudentSubFilter(String subFilterName) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Prospective Student']/../../following-sibling::div//*[text()='"+subFilterName+"']"));
	}
	
	public WebElement verifyParentOfProspectSubFilter(String subFilterName) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Parent of Prospect']/../../following-sibling::div//*[text()='"+subFilterName+"']"));
	}
	
	public WebElement verifyOtherSubFilter(String subFilterName) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Other']/../../following-sibling::div//*[text()='"+subFilterName+"']"));
	}
	
	public void selectProspectiveStudentSubFilter(String subFilterName) throws Exception {
		click(verifyProspectiveStudentSubFilter(subFilterName));
		page.waitForInsightsPageToLoad();
	}
	
	public void selectParentOfProspectSubFilter(String subFilterName) throws Exception {
		page.waitForInsightsPageToLoad();
		click(verifyParentOfProspectSubFilter(subFilterName));
		page.waitForInsightsPageToLoad();
	}
	
	public void selectOtherSubFilter(String subFilterName) throws Exception {
		Thread.sleep(3000);
		click(verifyOtherSubFilter(subFilterName));
		page.waitForInsightsPageToLoad();
	}
	
	public boolean selectHSStudent(String parentFilterName) throws Exception {
 			if(parentFilterName == "Prospective Student")
				selectProspectiveStudentSubFilter("HS Student");
			else if(parentFilterName == "Parent of Prospect")
				selectParentOfProspectSubFilter("HS Student");
			else{
				ExtentTestManager.getTest().fail("Subfilter High School Student filter checkbox not displayed under ["+parentFilterName+"] filter");
				return false;
			}
 			ExtentTestManager.getTest().pass("Click on subfilter High School Student filter checkbox under ["+parentFilterName+"] filter");
 			
			return true;
	}

	public boolean selectHSGraduate(String parentFilterName) throws Exception {
			if(parentFilterName == "Prospective Student")
				selectProspectiveStudentSubFilter("HS Graduate");
			else if(parentFilterName == "Parent of Prospect")
				selectParentOfProspectSubFilter("HS Graduate");
			else{
				ExtentTestManager.getTest().fail("Subfilter High School Graduate filter checkbox not displayed under ["+parentFilterName+"] filter");
				return false;
			}
			ExtentTestManager.getTest().pass("Click on subfilter High School Graduate filter checkbox under ["+parentFilterName+"] filter");
			return true;
	}

	public boolean selectCollegeStudent(String parentFilterName) throws Exception {
		if(parentFilterName == "Prospective Student")
			selectProspectiveStudentSubFilter("College Student");
		else if(parentFilterName == "Parent of Prospect")
			selectParentOfProspectSubFilter("College Student");
		else{
			ExtentTestManager.getTest().fail("Subfilter College Student filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
		ExtentTestManager.getTest().pass("Click on subfilter College Student filter checkbox under ["+parentFilterName+"] filter");
		return true;
	}

	public boolean selectCollegeGraduate(String parentFilterName) throws Exception {
		if(parentFilterName == "Prospective Student")
			selectProspectiveStudentSubFilter("College Graduate");
		else if(parentFilterName == "Parent of Prospect")
			selectParentOfProspectSubFilter("College Graduate");
		else{
			ExtentTestManager.getTest().fail("Subfilter College Graduate filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
		ExtentTestManager.getTest().pass("Click on subfilter College Graduate filter checkbox under ["+parentFilterName+"] filter");
		return true;
	}
	
	public boolean selectAdultLearner(String parentFilterName) throws Exception {
		if(parentFilterName == "Prospective Student")
			selectProspectiveStudentSubFilter("Adult Learner");
		else if(parentFilterName == "Parent of Prospect")
			selectParentOfProspectSubFilter("Adult Learner");
		else{
			ExtentTestManager.getTest().fail("Subfilter Adult Learner filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}		
		ExtentTestManager.getTest().pass("Click on subfilter Adult Learner filter checkbox under ["+parentFilterName+"] filter");
		return true;
	}
	
	public boolean selectMiddleSchooler(String parentFilterName) throws Exception {
		if(parentFilterName == "Prospective Student")
			selectProspectiveStudentSubFilter("Middle Schooler");
		else if(parentFilterName == "Parent of Prospect")
			selectParentOfProspectSubFilter("Middle Schooler");
		else{
			ExtentTestManager.getTest().fail("Subfilter Middle Schooler filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}		
		ExtentTestManager.getTest().pass("Click on subfilter Middle Schooler filter checkbox under ["+parentFilterName+"] filter");
		return true;
	}
	
	public boolean selectCurrentStudent(String parentFilterName) throws Exception {
		if(parentFilterName == "Other"){
			selectOtherSubFilter("Current Student");
			ExtentTestManager.getTest().pass("Click on subfilter Current Student filter checkbox under ["+parentFilterName+"] filter");
			return true;
		}else{
			ExtentTestManager.getTest().fail("Subfilter Current Student filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
	}
	
	public boolean selectAlumni(String parentFilterName) throws Exception {
		if(parentFilterName == "Other"){
			selectOtherSubFilter("Alumni");
			ExtentTestManager.getTest().pass("Click on subfilter Alumni filter checkbox under ["+parentFilterName+"] filter");
			return true;
		}else{
			ExtentTestManager.getTest().fail("Subfilter Alumni filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
	}
	
	public boolean selectFaculty(String parentFilterName) throws Exception {
		if(parentFilterName == "Other"){
			selectOtherSubFilter("Faculty");
			ExtentTestManager.getTest().pass("Click on subfilter Faculty filter checkbox under ["+parentFilterName+"] filter");
			return true;
		}else{
			ExtentTestManager.getTest().fail("Subfilter Faculty filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
	}

	public boolean selectGuidanceCounselor(String parentFilterName) throws Exception {
		if(parentFilterName == "Other"){
			selectOtherSubFilter("Guidance Counselor");
			ExtentTestManager.getTest().pass("Click on subfilter Guidance Counselor filter checkbox under ["+parentFilterName+"] filter");
			return true;
		}else{
			ExtentTestManager.getTest().fail("Subfilter Guidance Counselor filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
	}
	
	public boolean selectVeteran(String parentFilterName) throws Exception {
		if(parentFilterName == "Other"){
			selectOtherSubFilter("Veteran");
			ExtentTestManager.getTest().pass("Click on subfilter Veteran filter checkbox under ["+parentFilterName+"] filter");
			return true;
		}else{
			ExtentTestManager.getTest().fail("Subfilter Veteran filter checkbox not displayed under ["+parentFilterName+"] filter");
			return false;
		}
	}
	
	public void clickGeographyMainFilter() throws Exception {
	
		click(geographyMainFilter);
	}
	
	public WebElement verifySubFilterOfGeographyFilter(String geographySubFilterName) {	
		return waitForAndFindElementByLocator(By.xpath("//label[.='"+geographySubFilterName+"']"));
	}
	
	public void clickSubFilterOfGeography(String geographySubFilterName) throws Exception {
		click(verifySubFilterOfGeographyFilter(geographySubFilterName));
		ExtentTestManager.getTest().pass("Clicked on the Subfilter "+geographySubFilterName+" under Geography parent filter ");
	}
	
	public WebElement verifySubFiltersOfUSRegions(String subFilterNameOfUSRegions) {
		return waitForAndFindElementByLocator(By.xpath("//*[text()='"+subFilterNameOfUSRegions+"']"));
	}
	
	public void clickOtherSubFilterOfUSRegions() throws Exception {
		isPresentAndVisible(otherSubFilterOfUSRegions);
		click(otherSubFilterOfUSRegions);
	}
	
	public void selectSubFiltersOfUSRegionChkBx(String subFilterNameOfUSRegions)  throws Exception  {
		click(verifySubFiltersOfUSRegions(subFilterNameOfUSRegions));
		ExtentTestManager.getTest().pass("Clicked on the Subfilter "+subFilterNameOfUSRegions+" under US Regions parent filter ");
	}
	
	public void typeOnSearchByStateTxtBx(String text){
		searchByStateTxtBx.sendKeys(text);
		ExtentTestManager.getTest().pass(text + " state entered in the Search By State field");
	}
	
	public void clickSearchByTxtBxAutofillOption(String text) throws Exception {
		waitForAndFindElementByLocator(By.xpath("//span[.='"+text+"']")).click();
		page.waitForInsightsPageToLoad();
		ExtentTestManager.getTest().pass(text +" state selected from auto-complete option in Search By State field");
	}
	
	public void clickDemographicsFilterCollapseIcon() throws Exception {
		click(demographicsFilterCollapseIcon);
	}
	
	public void scrollToDemographicsFilterCollapseIcon() {
		scrollToElement(demographicsFilterCollapseIcon);
	}
	
	public void clickUSASubFilterOfGeographyFilter() throws Exception {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv,usaSubFilterOfGeography);
		isPresentAndVisible(usaSubFilterOfGeography);
		//click(usaSubFilterChkBxofGeography);
		click(usaSubFilterOfGeography);
		ExtentTestManager.getTest().pass("Clicked on the USA sub filter of the Geography parent filter");
	}
	
	public void clickInternationalSubFilterOfGeographyFilter() throws Exception {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv,internationalSubFilterOfGeography);
		isPresentAndVisible(internationalSubFilterOfGeography);
		//click(usaSubFilterChkBxofGeography);
		click(internationalSubFilterOfGeography);
		ExtentTestManager.getTest().pass("Clicked on the International sub filter of the Geography parent filter");
	}
	
	public void typeSearchCountryTxtBx(String text) {
		searchCountriesTxtBx.sendKeys(text);
		ExtentTestManager.getTest().pass(text + " country name entered in the Search Countries field");
	}
	
	public void clickResetFiltersButton() throws Exception {
		isPresentAndVisible(resetFiltersButton);
		click(resetFiltersButton);
		ExtentTestManager.getTest().pass("Clicked on the Reset button of the filters");
		page.waitForInsightsPageToLoad();
	}
	
	public void scrollToAgeFilter() {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv, ageMainFilter);
	}
	
	public void clickAgeMainFilter()  throws Exception  {
		
		isPresentAndVisible(ageMainFilter);
		click(ageMainFilter);
	}
	
	public WebElement verifyAgeSubfilter(String subFilterNameOFAgeFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Age']/../../following-sibling::div//*[text()='"+subFilterNameOFAgeFilter+"']"));
	}
	
	public void selectSubFilterOfAge(String subFilterNameOFAgeFilter) throws Exception {
		click(verifyAgeSubfilter(subFilterNameOFAgeFilter));
		ExtentTestManager.getTest().pass("Clicked on the Subfilter "+subFilterNameOFAgeFilter+" under Age parent filter ");
	}
	
	public void scrollToGenderFilter() {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv, genderMainFilter);
	}
	
	public void clickGenderMainFilter()  throws Exception  {
		isPresentAndVisible(genderMainFilter);
		click(genderMainFilter);
	}
	
	public WebElement verifyGenderSubfilter(String subFilterNameOFGenderFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Gender']/../../following-sibling::div//*[text()='"+subFilterNameOFGenderFilter+"']"));
	}
	
	public void selectSubFilterOfGender(String subFilterNameOFGenderFilter) throws Exception {
		click(verifyGenderSubfilter(subFilterNameOFGenderFilter));
		ExtentTestManager.getTest().pass("Clicked on the Subfilter "+subFilterNameOFGenderFilter+" under Age parent filter ");
	}
	
	public void scrollToEthinicityFilter() {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv, ethinicityMainFilter);
	}
	
	public void clickEthnicityMainFilter()  throws Exception  {
		isPresentAndVisible(ethinicityMainFilter);
		click(ethinicityMainFilter);
	}
	
	public WebElement verifyEthnicitySubfilter(String subFilterNameOFEthnicityFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Ethnicity']/../../following-sibling::div//*[text()='"+subFilterNameOFEthnicityFilter+"']"));
	}
	
	public void selectSubFilterOfEthnicity(String subFilterNameOFEthnicityFilter) throws Exception {
		click(verifyEthnicitySubfilter(subFilterNameOFEthnicityFilter));
		ExtentTestManager.getTest().pass("Clicked on the Subfilter "+subFilterNameOFEthnicityFilter+" under Age parent filter ");
	}
	
	public boolean verifyEngagementFilter() throws Exception {
		return verifyFieldDisplayed(engagementMainFilter);
	}
	
	public boolean verifyDateRegisteredWithMyInstitutionFilter() throws Exception {
		waitAndFindElementByVisibility(dateRegisteredWithMyInstitutionMainFilter);
		return verifyFieldDisplayed(dateRegisteredWithMyInstitutionMainFilter);
	}
	
	public boolean verifyRelativeEngagementFilter() throws Exception {
		return verifyFieldDisplayed(relativeEngagementMainFilter);
	}
	
	public boolean verifyTotalTimeSpentInVTAndOrIWCFilter() throws Exception {
		return verifyFieldDisplayed(totalTimeSpentOnVtAndOrIwcMainFilter);
	}
	
	public boolean verifyScheduledVisitCtaClickedFilter() throws Exception {
		return verifyFieldDisplayed(scheduleVisitCTAClickedMainFilter);
	}
	
	public boolean verifyApplyNowCtaClickedFilter() throws Exception {
		return verifyFieldDisplayed(applyNowCTAClickedMainFilter);
	}
	
	public boolean verifyActivityWithMyInstitutionFilter() throws Exception {
		return verifyFieldDisplayed(activityWithMyInstitutionMainFilter);
	}
	
	public boolean verifyActivityWithEABNetworkFilter() throws Exception {
		return verifyFieldDisplayed(activityWithEABNetworkMainFilter);
	}
	
	public WebElement getDateRegisterdWithMyInstitutionSubfilter(String subFilterNameOFAgeFilter) throws Exception {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Date Registered with My Institution']/../../following-sibling::div//*[text()='"+subFilterNameOFAgeFilter+"']"));
	}
	
	public boolean verifyDateRegisterdWithMyInstitutionSubfilterDisplayed(String NameOFDateRegisterdWithMyInstitutionSubFilter) throws Exception {
		boolean flag = false;
		flag = verifyFieldDisplayed(getDateRegisterdWithMyInstitutionSubfilter(NameOFDateRegisterdWithMyInstitutionSubFilter));
		ExtentTestManager.getTest().pass("Subfilter "+NameOFDateRegisterdWithMyInstitutionSubFilter+" is displayed under Date Registered with My Institution parent filter ");
		return flag;
	}
	
	public boolean verifyAnySubfilterOfDateRegisterdWithMyInstitutionFilter() throws Exception {
		page.waitForInsightsPageToLoad();
		return verifyDateRegisterdWithMyInstitutionSubfilterDisplayed("Any");
	}
	
	public boolean verifySelectRecencySubfilterOfDateRegisterdWithMyInstitutionFilter() throws Exception {
		return verifyDateRegisterdWithMyInstitutionSubfilterDisplayed("Select Recency");
	}
	
	public boolean verifySpecificDateRangeSubfilterOfDateRegisterdWithMyInstitutionFilter() throws Exception {
		return verifyDateRegisterdWithMyInstitutionSubfilterDisplayed("Specific Date Range");
	}
	
	public void clickDateRegisterdWithMyInstitutionFilter() throws Exception {
		click(dateRegisteredWithMyInstitutionMainFilter);
		ExtentTestManager.getTest().pass("Clicked on the Date Registered with My Institution parent filter ");
	}
	
	public void clickRelativeEngagementFilter() throws Exception {
		click(relativeEngagementMainFilter);
		ExtentTestManager.getTest().pass("Click on Relative Engagement filter");
		page.waitForInsightsPageToLoad();
	}

	public WebElement getRelativeEngagementSubfilter(String subFilterNameOFRelativeEngagemenFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Relative Engagement']/../../following-sibling::div//*[text()='"+subFilterNameOFRelativeEngagemenFilter+"']"));
	}
	
	public void verifySubfilterOfRelativeEngagementFilter(String subFilterNameOFRelativeEngagementFilter) throws Exception {
		page.waitForInsightsPageToLoad();
		verifyFieldDisplayed(getRelativeEngagementSubfilter(subFilterNameOFRelativeEngagementFilter));
		ExtentTestManager.getTest().pass("Subfilter "+subFilterNameOFRelativeEngagementFilter+" is displayed under Relative Engagement parent filter ");
	}
	
	public void selectSubfilterOfRelativeEngagementFilter(String subFilterNameOFRelativeEngagementFilter) throws Exception {
		click(getRelativeEngagementSubfilter(subFilterNameOFRelativeEngagementFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subFilterNameOFRelativeEngagementFilter+" under Relative Engagement parent filter ");
	}
	
	public void clickTotalTimeSpentInVTAndOrIWCFilter() throws Exception{
		click(totalTimeSpentOnVtAndOrIwcMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Total Time Spent in My VT and/or IWC filter");
	}
	
	public WebElement getTotalTimeSpentInVTAndOrIwcSubFilter(String subfilterOfTotalTimeSpentInVTAndOrIWCFilter) throws Exception {
		page.waitForInsightsPageToLoad();
		return waitForAndFindElementByLocator(By.xpath("//span[.='Total Time Spent in My VT and/or IWC']/../../following-sibling::div//*[text()='"+subfilterOfTotalTimeSpentInVTAndOrIWCFilter+"']"));
	}
	
	public void verifySubfilterOfTotalTimeSpentInVTAndOrIWCFilter(String subfilterOfTotalTimeSpentInVTAndOrIWCFilter) throws Exception {
		verifyFieldDisplayed(getTotalTimeSpentInVTAndOrIwcSubFilter(subfilterOfTotalTimeSpentInVTAndOrIWCFilter));
		ExtentTestManager.getTest().pass(subfilterOfTotalTimeSpentInVTAndOrIWCFilter +" dropdown option in Total Time Spent in My VT and/or IWC is displayed in filters");
	}
	
	public void selectSubfilterOfTotalTimeSpentInVTAndOrIWCFilter(String subfilterOfTotalTimeSpentInVTAndOrIWCFilter) throws Exception {
		clicktotalTimeSpentOnVtAndOrIwcDropdown();
		click(getTotalTimeSpentInVTAndOrIwcSubFilter(subfilterOfTotalTimeSpentInVTAndOrIWCFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfTotalTimeSpentInVTAndOrIWCFilter+" under Total Time Spent in My VT and/or IWC parent filter ");
	}
	
	public void clicktotalTimeSpentOnVtAndOrIwcDropdown() throws Exception {
		click(totalTimeSpentOnVtAndOrIwcDropDown);
		ExtentTestManager.getTest().pass("Clicked on Total Time Spent in My VT and/or IWC filter Drop down");
	}
	
	public void clickScheduleVisitCTAClickedFilter() throws Exception{
		click(scheduleVisitCTAClickedMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Schedule Visit CTA Clicked filter");
	}
	
	public WebElement getScheduleVisitCTAClickedSubFilter(String subfilterOfScheduleVisitCTAClickedFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Schedule Visit CTA Clicked']/../../following-sibling::div//*[text()='"+subfilterOfScheduleVisitCTAClickedFilter+"']"));
	}
	
	public void verifySubfilterOfScheduleVisitCTAClickedFilter(String subfilterOfScheduleVisitCTAClickedFilter) throws Exception {
		verifyFieldDisplayed(getScheduleVisitCTAClickedSubFilter(subfilterOfScheduleVisitCTAClickedFilter));
		ExtentTestManager.getTest().pass(subfilterOfScheduleVisitCTAClickedFilter +" subfilter is displayed under Schedule Visit CTA Clicked parent filters");
	}
	
	public void selectSubfilterOfScheduleVisitCTAClickedFilter(String subfilterOfScheduleVisitCTAClickedFilter) throws Exception {
		click(getScheduleVisitCTAClickedSubFilter(subfilterOfScheduleVisitCTAClickedFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfScheduleVisitCTAClickedFilter+" under Schedule Visit CTA Clicked parent filter ");
	}
	
	public void scrollToApplyNewCTAilter() {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv, applyNowCTAClickedMainFilter);
	}
	
	public void clickApplyNowCTAClickedFilter() throws Exception{
		click(applyNowCTAClickedMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Apply Now CTA Clicked filter");
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement getApplyNowCTAClickedSubFilter(String subfilterOfApplyNowCTAClickedFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Apply Now CTA Clicked']/../../following-sibling::div//*[text()='"+subfilterOfApplyNowCTAClickedFilter+"']"));
	}
	
	public void verifySubfilterOfApplyNowCTAClickedFilter(String subfilterOfApplyNowCTAClickedFilter) throws Exception {
		verifyFieldDisplayed(getApplyNowCTAClickedSubFilter(subfilterOfApplyNowCTAClickedFilter));
		ExtentTestManager.getTest().pass(subfilterOfApplyNowCTAClickedFilter +" subfilter is displayed under Apply Now CTA Clicked parent filters");
	}
	
	public void selectSubfilterOfApplyNowCTAClickedFilter(String subfilterOfApplyNowCTAClickedFilter) throws Exception {
		click(getApplyNowCTAClickedSubFilter(subfilterOfApplyNowCTAClickedFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfApplyNowCTAClickedFilter+" under Apply Now CTA Clicked parent filter ");
		page.waitForInsightsPageToLoad();
	}
	
	public void clickActivityWithMyInstitutionMainFilter() throws Exception{
		click(activityWithMyInstitutionMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Activity with My Institution filter");
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement getActivityWithMyInstitutionSubFilter(String subfilterOfActivityWithMyInstitutionFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Activity with My Institution']/../../following-sibling::div//*[text()='"+subfilterOfActivityWithMyInstitutionFilter+"']"));
	}
	
	public void verifySubfilterOfActivityWithMyInstitutionFilter(String subfilterOfActivityWithMyInstitutionFilter) throws Exception {
		verifyFieldDisplayed(getActivityWithMyInstitutionSubFilter(subfilterOfActivityWithMyInstitutionFilter));
		ExtentTestManager.getTest().pass(subfilterOfActivityWithMyInstitutionFilter +" subfilter is displayed under Activity with My Institution parent filters");
	}
	
	public void selectSubfilterOfActivityWithMyInstitutionFilter(String subfilterOfActivityWithMyInstitutionFilter) throws Exception {
		click(getActivityWithMyInstitutionSubFilter(subfilterOfActivityWithMyInstitutionFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfActivityWithMyInstitutionFilter+" under Activity with My Institution parent filter ");
	}
	
	public void clickActivityWithEABNetworkMainFilter() throws Exception{
		click(activityWithEABNetworkMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Activity with EAB Network filter");
	}
	
	public WebElement getActivityWithEABNetworkSubFilter(String subfilterOfActivityWithEABNetworkFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Activity with EAB Network']/../../following-sibling::div//*[text()='"+subfilterOfActivityWithEABNetworkFilter+"']"));
	}
	
	public void verifySubfilterOfActivityWithEABNetworkFilter(String subfilterOfActivityWithEABNetworkFilter) throws Exception {
		verifyFieldDisplayed(getActivityWithEABNetworkSubFilter(subfilterOfActivityWithEABNetworkFilter));
		ExtentTestManager.getTest().pass(subfilterOfActivityWithEABNetworkFilter +" subfilter is displayed under Activity with EAB Network parent filters");
	}
	
	public void selectSubfilterOfActivityWithEABNetworkFilter(String subfilterOfActivityWithEABNetworkFilter) throws Exception {
		click(getActivityWithEABNetworkSubFilter(subfilterOfActivityWithEABNetworkFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfActivityWithEABNetworkFilter+" under Activity with EAB Network parent filter ");
	}
	
	public boolean verifyListMembershipFilter() throws Exception {
		return verifyFieldDisplayed(listMembershipMainFilter);
	}
	
	public void clickListMembershipMainFilter() throws Exception {
		click(listMembershipMainFilter);
		ExtentTestManager.getTest().pass("Clicked on List Membership filter");
	}
	
	public boolean verifyListMembershipSearchListTxtBxFilter() throws Exception {
		waitAndFindElementByVisibility(listMembershipsearchListTxtBx);
		return verifyFieldDisplayed(listMembershipsearchListTxtBx);
	}
	
	public void clickAddToListBtn() throws Exception {
		click(addToListButton);
		ExtentTestManager.getTest().pass("Click on Add to List button");
	}
	
	public void clickCreateNewListChkBxInAddToList() throws Exception {
		waitAndFindElementByVisibility(createNewListChkBx);
		clickWithJavaScript(createNewListChkBx);
		ExtentTestManager.getTest().pass("Check Create New List checkbox");
	}
	
	public WebElement verifyNewListNameTxtBxInAddToList() {
		return waitAndFindElementByVisibility(newListNameTxtBxInAddToList);
	}
	
	public void typeNewListNameTxtBxInAddToList(String newListName) {
		verifyNewListNameTxtBxInAddToList().sendKeys(newListName);
		ExtentTestManager.getTest().pass("Enter List name as ["+newListName+"] in the textbox");
	}
	
	public void clickAddToListBtnInAddToList() throws Exception {
		click(newAddToListButtonInAddToList);
		ExtentTestManager.getTest().pass("Click on Add to List button in the Add To List popup");
	}
	
	public WebElement verifySearchListTxtBxInExplorePage() {
		return waitAndFindElementByVisibility(searchListTxtBxInExplorePage);
	}
	
	public void typeSearchListTxtBxInExplorePage(String searchListName) throws Exception {
		waitAndFindElementByVisibility(searchListTxtBxInExplorePage);
		click(verifySearchListTxtBxInExplorePage());
		verifySearchListTxtBxInExplorePage().sendKeys(searchListName);
		ExtentTestManager.getTest().pass("Enter List name as ["+searchListName+"] in the Search textbox");
	}
	
	public WebElement getSearchListNameTxtBxDropdownElement(String searchListName) {
		return waitForAndFindElementByLocator(By.xpath("//span[@aria-label='"+searchListName+"']"));
	}
	
	public void clickSearchListNameDropdownOption(String searchListName) throws Exception {
		click(getSearchListNameTxtBxDropdownElement(searchListName));
		ExtentTestManager.getTest().pass("List ["+searchListName+"] is displayed in the dropdown");
	}
	
	public void verifyListNameOptionInSearchListNameTxtBx(String searchListName) throws Exception {
		isPresentAndVisible(getSearchListNameTxtBxDropdownElement(searchListName));
		if(verifyFieldDisplayed(getSearchListNameTxtBxDropdownElement(searchListName))) {
			ExtentTestManager.getTest().pass("List ["+searchListName+"] is displayed in the dropdown");
		}else {
			System.err.println("List ["+searchListName+"] is not displayed in the dropdown");
			ExtentTestManager.getTest().fail("List ["+searchListName+"] is not displayed in the dropdown");
		}		
	}
	
	public void verifyTotalInquriesAndInquiriesList(int numOfInquiriesList) throws Exception {
		if(totalNumberOfInquiries()==numOfInquiriesList){
			System.out.println("Number of inquiries displayed ["+numOfInquiriesList+"] is equal to number of inquiries in the list");
			ExtentTestManager.getTest().pass("Number of inquiries displayed ["+numOfInquiriesList+"] is equal to number of inquiries in the list");
		}else {
			System.err.println("Number of inquiries displayed ["+totalNumberOfInquiries()+"] is not equal to number of inquiries in the list["+numOfInquiriesList+"]");
			ExtentTestManager.getTest().fail("Number of inquiries displayed ["+totalNumberOfInquiries()+"] is not equal to number of inquiries in the list["+numOfInquiriesList+"]");
		}
	}
	
	public void deleteCreatedListNameInLisTab(String searchListName) throws Exception {
		click(listTab);
		ExtentTestManager.getTest().pass("Clicked on List Tab");
		click(waitForAndFindElementByLocator(By.xpath("//div[text()='"+searchListName+"']")));
		ExtentTestManager.getTest().pass("Clicked on the created List name in the List tab page");
		
		click(threeDotsButtonOfFirstListNameInListTab);
		ExtentTestManager.getTest().pass("Clicked Three Dots button of the List");
		click(deleteMenuOfListNameThreeDots);
		ExtentTestManager.getTest().pass("Clicked on Delete button in the dropdown");
		click(deleteMenuOfListNameThreeDots);
		ExtentTestManager.getTest().pass("Clicked on Delete button in the alert");
	}
	
	public void scrollToProspectProfileFilter() {
		page.scrollToElementInDiv(ethnicityLeftMenuBarDiv, prospectProfileMainFilter);
	}
	
	public boolean verifyProspectProfileFilter() throws Exception {
		return verifyFieldDisplayed(prospectProfileMainFilter);
	}
	
	public void clickProspectProfileFilter() throws Exception{
		clickWithJavaScript(prospectProfileMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Prospect Profile Filter");
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement getSubFiltersOfProspectProfileFilter(String subfilterOfProspectProfileFilter) throws Exception {
		page.waitForInsightsPageToLoad();
		return waitForAndFindElementByLocator(By.xpath("//span[.='Prospect Profile ']/../../following-sibling::div//*[text()='"+subfilterOfProspectProfileFilter+"']"));
	}
	
	public void verifySubfilterOfProspectProfileFilter(String subfilterOfProspectProfileFilter) throws Exception {
		verifyFieldDisplayed(getSubFiltersOfProspectProfileFilter(subfilterOfProspectProfileFilter));
		ExtentTestManager.getTest().pass(subfilterOfProspectProfileFilter +" subfilter is displayed under Prospect Profile parent filters");
	}
		
	public void clickIntendedLevelofStudySubFilterOfProspectProfile() throws Exception{
		click(intendedLevelOfStudySubFilter);
		ExtentTestManager.getTest().pass("Clicked on Intended Level of Study filter");
	}
	
	public WebElement getIntendedLevelofStudySubFilter(String subfilterOfIntendedLevelofStudyFilter) throws Exception {
		page.waitForInsightsPageToLoad();
		return waitForAndFindElementByLocator(By.xpath("//span[.='Intended Level of Study']/../../following-sibling::div//*[text()='"+subfilterOfIntendedLevelofStudyFilter+"']"));
	}
	
	public void verifySubfilterOfIntendedLevelofStudyFilter(String subfilterOfIntendedLevelofStudyFilter) throws Exception {
		verifyFieldDisplayed(getIntendedLevelofStudySubFilter(subfilterOfIntendedLevelofStudyFilter));
		ExtentTestManager.getTest().pass(subfilterOfIntendedLevelofStudyFilter +" subfilter is displayed under Intended Level of Study parent filters");
	}
	
	public void selectSubfilterOfIntendedLevelofStudyFilter(String subfilterOfIntendedLevelofStudyFilter) throws Exception {
		click(getIntendedLevelofStudySubFilter(subfilterOfIntendedLevelofStudyFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfIntendedLevelofStudyFilter+" under Intended Level of Study parent filter ");
	}
	
	public void clickEntryTermSubFilterOfProspectProfile() throws Exception{
		waitAndFindElementByVisibility(entryTermSubfilter);
		clickWithJavaScript(entryTermSubfilter);
		ExtentTestManager.getTest().pass("Clicked on Entry Term filter");
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement getEntryTermSubFilter(String subfilterOfEntryTermFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='Entry Term']/../../following-sibling::div//*[text()='"+subfilterOfEntryTermFilter+"']"));
	}
	
	public void verifySubfilterOfEntryTermFilter(String subfilterOfEntryTermFilter) throws Exception {
		page.waitForInsightsPageToLoad();
		verifyFieldDisplayed(getEntryTermSubFilter(subfilterOfEntryTermFilter));
		ExtentTestManager.getTest().pass(subfilterOfEntryTermFilter +" subfilter is displayed under Entry Term parent filters");
	}
	
	public void selectSubfilterOfEntryTermFilter(String subfilterOfEntryTermFilter) throws Exception {
		click(getEntryTermSubFilter(subfilterOfEntryTermFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfEntryTermFilter+" under Entry Term parent filter ");
		page.waitForInsightsPageToLoad();
	}
	
	public WebElement getTermYearTxtBxElement() {
		return waitAndFindElementByVisibility(termYearTxtBxOfEntryTermFilter);
	}
	
	public void typeTermYearTxtBxOfEntryTermFilter(String termYearValue) {
		getTermYearTxtBxElement().sendKeys(termYearValue);
		ExtentTestManager.getTest().pass("Enter "+termYearValue+" in Term Year textbox");
	}
	
	public void clickTermYearTxtBxAutofill() throws Exception {
		click(termYearTxtBxAutofillOptionOfEntryTermFilter);
		ExtentTestManager.getTest().pass("Click to select auto complete value Fall 2023 in Term Year");
	}
	
	public WebElement verifySubFilterOfTermFilter(String subFilterOfTermFilter) throws Exception {
		return waitForAndFindElementByLocator(By.xpath("//*[contains(text(),'"+subFilterOfTermFilter+"')]"));
	}
		
	public void selectSubfilterOfTermFilter(String subFilterOfTermFilter) throws Exception {
		click(verifySubFilterOfTermFilter(subFilterOfTermFilter));
		ExtentTestManager.getTest().pass("Clicked to select subfilter "+subFilterOfTermFilter+" in Term Filter");
	}
	
	public void clickIntendedMajorSubFilterOfProspectProfile() throws Exception{
		click(intendedMajorSubfilterOfProspectProfile);
		ExtentTestManager.getTest().pass("Clicked on Intended Major filter");
	}
	
	public WebElement getIntendedMajorSearchTxtBxElement() {
		return waitAndFindElementByVisibility(IntendMajorSearchTxtBx);
	}
	
	public void typeIntendedMajorSearchTxtBx(String intendedMajor) {
		getIntendedMajorSearchTxtBxElement().sendKeys(intendedMajor);
		ExtentTestManager.getTest().pass("Enter "+intendedMajor+" in Major search textbox");
	}
	
	public void selectAutofillOnIntendedMajorSearchTxtBx(String intendedMajorAutoFill) throws Exception {
		click(waitForAndFindElementByLocator(By.xpath("//span[contains(text(),'"+intendedMajorAutoFill+"')]")));
		ExtentTestManager.getTest().pass("Select Sociology in Intended Major autofill dropdown");
	}
	
	public void verifyintendedMajorSearchTxtBx() throws Exception {
		verifyFieldDisplayed(getIntendedMajorSearchTxtBxElement());
		ExtentTestManager.getTest().pass("Search Major textbox in Intended major is displayed");
	}
	
	public void clickGPASubFilterOfProspectProfile() throws Exception{
		click(gpaSubfilterOfProspectProfile);
		ExtentTestManager.getTest().pass("Clicked on GPA filter sub filter in PropectProfile");
	}

	public WebElement getGPASubFilter(String subfilterOfGPAFilter) {
		return waitForAndFindElementByLocator(By.xpath("//span[.='GPA']/../../following-sibling::div//*[text()='"+subfilterOfGPAFilter+"']"));
	}

	public void verifySubfilterOfGPAFilter(String subfilterOfGPAFilter) throws Exception {
		verifyFieldDisplayed(getGPASubFilter(subfilterOfGPAFilter));
		ExtentTestManager.getTest().pass(subfilterOfGPAFilter +" subfilter is displayed under GPA parent filters");
	}
//==	
	public void scrollToSetSpecifiGPAFilterStartRange(String value) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", specificGPAScrollbarEndRange, "value", value);
		ExtentTestManager.getTest().pass("Specific GPA Range set from "+specificGPAScrollbarStartRange.getAttribute("value")
		+ " to " + specificGPAScrollbarEndRange.getAttribute("value"));
	}
	
	public void scrollToSetSpecifiGPAFilterEndRange(String value) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", specificGPAScrollbarStartRange, "value", value);
		ExtentTestManager.getTest().pass("Specific GPA Range set from "+specificGPAScrollbarStartRange.getAttribute("value")
		+ " to " + specificGPAScrollbarEndRange.getAttribute("value"));
	}
//==//
	
	public void selectSubfilterOfGPAFilter(String subFilterOfGPAFilter) throws Exception {
		click(getGPASubFilter(subFilterOfGPAFilter));
		ExtentTestManager.getTest().pass("Clicked to select subfilter "+subFilterOfGPAFilter+" in GPA Filter");
	}
	
	public void clickTestScoresSubFilterOfProspectProfile() throws Exception{
		click(testScoresSubfilterOfProspectProfile);
		ExtentTestManager.getTest().pass("Clicked on Test Scores sub filter in PropectProfile");
	}
	
	public WebElement getTestScoresSubFilter(String subfilterOfTestScoresFilter) {
		return waitForAndFindElementByLocator(By.xpath("//*[.='Test Scores']/../following-sibling::div//*[text()='"+subfilterOfTestScoresFilter+"']"));
	}
	
	public void verifySubfilterOfTestScoresFilter(String subfilterOfTestScoresFilter) throws Exception {
		verifyFieldDisplayed(getTestScoresSubFilter(subfilterOfTestScoresFilter));
		ExtentTestManager.getTest().pass(subfilterOfTestScoresFilter +" dropdown option in Test Scores is displayed in filters");
	}
	
	public void selectSubfilterOfTestScoresFilter(String subfilterOfTestScoresFilter) throws Exception {
		clickTestScoresDropdown();
		click(getTestScoresSubFilter(subfilterOfTestScoresFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfTestScoresFilter+" under Test Scores parent filter ");
	}
	
	public void clickTestScoresDropdown() throws Exception {
		waitAndFindElementByVisibility(selectBoxOfTestScoresSubFilter);
		click(selectBoxOfTestScoresSubFilter);
		ExtentTestManager.getTest().pass("Clicked on Test Scores filter Drop down");
	}
	
	public void clickLocationsMainFilter() throws Exception{
		click(locationsMainFilter);
		ExtentTestManager.getTest().pass("Clicked on Locations Filter");
	}
	
	public WebElement getSubfiltersOfLocationFilter(String subFilterOfLocationFilter) {
		return waitForAndFindElementByLocator(By.xpath("//label[.='"+subFilterOfLocationFilter+"']"));
	}
	
	public void selectSubfilterInLocationsFilter(String subfilterOfLocationsFilter) throws Exception {
		click(getSubfiltersOfLocationFilter(subfilterOfLocationsFilter));
		ExtentTestManager.getTest().pass("Selected the Subfilter "+subfilterOfLocationsFilter+" under Locations parent filter ");
	}
	
	public void verifySubfilterOfLocationsFilter(String subfilterOfLocationsFilter) throws Exception {
		verifyFieldDisplayed(getSubfiltersOfLocationFilter(subfilterOfLocationsFilter));
		ExtentTestManager.getTest().pass(subfilterOfLocationsFilter +" subfilter in Locationss is displayed in filters");
	}
	
	public WebElement getColumnNameOnInquiriesList(String columnName) {
		return waitForAndFindElementByLocator(By.xpath("//div[text()='"+columnName+"']"));
	}
	
	public void verifyColumnNameOnInquiries(String columnName) throws Exception {
		Assert.assertTrue(verifyFieldDisplayed(getColumnNameOnInquiriesList(columnName)), columnName+" in Inquiry Lists is not displayed");
		ExtentTestManager.getTest().pass(columnName+" in Inquiry Lists is displayed");
	}
	
	public void clickColumnNameOnInquiriesList(String columnName) throws Exception{
		waitAndFindElementByVisibility(getColumnNameOnInquiriesList(columnName));
		click(getColumnNameOnInquiriesList(columnName));
		ExtentTestManager.getTest().pass("Clicked on the inquirer ["+columnName+"] from Inquiries list");
	}
	
	public void verifyfirstRowFirstCellOnInquiriesTablePresence() {
		waitAndFindElementByVisibility(firstRowFirstCellOnInquiriesTable);
	}
	
	public String getfirstRowFirstCellText() {
		isPresentAndVisible(firstRowFirstCellOnInquiriesTable);
		return firstRowFirstCellOnInquiriesTable.getText();
	}
	
	public void verifylastRowFirstCellOnInquiriesTablePresence() {
		isPresentAndVisible(lastRowFirstCellOnInquiriesTable);
	}
	
	public String getlastRowFirstCellText() {
		isPresentAndVisible(lastRowFirstCellOnInquiriesTable);
		return lastRowFirstCellOnInquiriesTable.getText();
	}
	
	public void clickPreviousPageButton() throws Exception {
		click(previousPageButton);
	}
	
	public void clickNextPageButton() throws Exception {
		click(nextPageButton);
	}
	
	public int totalNumberOfInquiries() throws Exception {
		page.waitForInsightsPageToLoad();
		isPresentAndVisible(noOfInquiries);
		return Integer.parseInt(noOfInquiries.getText().replace(",", ""));
	}
	
	public void verifyNumOfInquiries(String filterName, String filterNameCsv, String filterContentCsv, String browserName) throws Exception {
		int inquiriesDisplayed= totalNumberOfInquiries();
		int inquiriesInCsv=numOfInquiriesForCsv(filterNameCsv,filterContentCsv,browserName);
		if(inquiriesDisplayed == inquiriesInCsv) {
			System.out.println("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
			ExtentTestManager.getTest().pass("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
		}else if(inquiriesDisplayed == (inquiriesInCsv+1)) {
			System.out.println("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are equal to number of inquiries["+(inquiriesInCsv+1)+"] in CSV file");
			ExtentTestManager.getTest().pass("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are equal to number of inquiries["+(inquiriesInCsv+1)+"] in CSV file");
		}else if((inquiriesDisplayed+1) == inquiriesInCsv) {
			System.out.println("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+(inquiriesDisplayed+1)+"] are equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
			ExtentTestManager.getTest().pass("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+(inquiriesDisplayed+1)+"] are equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
		}else {
			System.err.println("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are not equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
			ExtentTestManager.getTest().fail("For filter ["+filterName+" = "+filterContentCsv+"] number of inquiries displayed ["+inquiriesDisplayed+"] are not equal to number of inquiries["+inquiriesInCsv+"] in CSV file");
		}
	}
	
	public int numOfInquiriesForCsv(String columnName,String columnValue, String browserName) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads";

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		String fileName = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".csv")) {
				//System.out.println("File = " + listOfFiles[i].getName());
				fileName = listOfFiles[i].getName();
			}
		}
		File file  = null;
		BufferedReader br = null;
		try {
			file = new File(path + File.separator + fileName);
			br = new BufferedReader(new FileReader(file));
		}catch(Exception ex) {
			throw new RuntimeException("Exception caused by "+ex.getClass().getName()+" and message is "+ex.getMessage());
		}
		String line,line1 = br.readLine();
		String[] header = line1.split(",");
		//System.out.println(line1);
		//System.out.println(" I No. of Column ======= "+header.length);
		Map<Object, Object> datamap = new HashMap<Object, Object>();
		int numOfInq=0;//,totalRowsInCsv=0;
		if(columnValue.equalsIgnoreCase("other") || columnValue.equalsIgnoreCase("TRUE") || columnValue.equalsIgnoreCase("FALSE")) {
			for(int j=0;j<(getRowCount(file)-1);j++) {
				line = br.readLine();
				String[] inquiry = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				//line=line.replaceAll("(\".?),(.?\")", "$1$2");
				//String[] inquiry = line.split(",");
				//System.out.println(line);
				//System.out.println(" II No. of Column ======= "+header.length);
				for(int i=0;i<(header.length-1);i++) {
					try {
						datamap.put(header[i], inquiry[i]);
					}catch (ArrayIndexOutOfBoundsException e) {
						datamap.put(header[i], "");
					}
				}//totalRowsInCsv++;
				if(datamap.get(columnName)!=null) {
					if((datamap.get(columnName).toString()).equalsIgnoreCase(columnValue)) {
						numOfInq++;
						//System.out.println("full name = "+datamap.get(columnName).toString() +"column value : "+columnValue+ "Count : "+numOfInq );    //For Debugging
					}
				}else {//System.out.println(columnName+" : "+columnValue+" : "+numOfInq++);}
					
				}
			}
			//System.out.println("Total inquiries in CSV = "+numOfInq);
			//System.out.println("Total rows in CSV = "+totalRowsInCsv);
		}else {
			for(int j=0;j<(getRowCount(file)-1);j++) {
				line = br.readLine();
				String[] inquiry = line.split(",");
				//System.out.println(line);
				//System.out.println("III No. of Column ======= "+header.length);
				for(int i=0;i<(header.length-1);i++) {
					if(inquiry[i].equalsIgnoreCase(columnValue))
						numOfInq++;
				}
				/*try {
		    		//System.out.println("header["+i+"]="+header[i]+" :: inquiry["+i+"]="+inquiry[i]);
		    		datamap.put(header[i], inquiry[i]);
		    	}catch (ArrayIndexOutOfBoundsException e) {
		    		datamap.put(header[i], "");
				}*/
			}/*totalRowsInCsv++;
	    	if(datamap.get(columnName).toString().equalsIgnoreCase(columnValue)) {
	    		numOfInq++;
	    		//System.out.println("full name = "+datamap.get("name_full").toString());    //For Debugging
	    	}
	    }*/
			//System.out.println("Total rows in CSV = "+totalRowsInCsv);
		}
		br.close();
		//System.out.println("Number of Inquiries for "+columnName+"="+columnValue+" is "+numOfInq);
		return numOfInq;
	}
	
	public int getRowCount(File file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		//String input;
		int count = 0;
		while((bufferedReader.readLine()) != null)
		{
			count++;
		}
		//System.out.println("Count : "+count);
		bufferedReader.close();
		return count;
	}
		
}
