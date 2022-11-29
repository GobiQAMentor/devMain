package com.pages.aap;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class AAPAnalyticsPage extends ObjectsControl implements PageInterface{
	
	WebDriver driver;
	String pageTitle = "Audience Analytics Portal";
	
	@FindBy(xpath = "//a[.='Analytics']")
 	WebElement analyticsTabLink;
	
	@FindBy(xpath = "//span[.='Content Performance']")
 	WebElement contentPerformenceTabLink;
	
	@FindBy(xpath = "//span[.='Your EDU vs. Network']")
 	WebElement yourEDUvsNetWorkTabLink;
	
	@FindBy(css= "iframe[id='analytics_cp_vt_overview_v2']")
 	WebElement vtContentPerformenceDashboardFrame;
	
	@FindBy(xpath = "//div[text()='Virtual Tours']")
 	WebElement vtDashboardHeader;
	
	@FindBy(xpath = "//div[text()='Virtual Tours']/../../following-sibling::div//div[@class='gridTab']//div[contains(@class,'element cell')]/span")
	WebElement vtDashboardFirstLocationNameLink;
	
	@FindBy(xpath = "//button[contains(@class,'crossMark')]")
 	WebElement closeVtButton;
	
	@FindBy(xpath = "//div[text()='Your Virtual Tour vs. Network']")
 	WebElement yourVtVsNetworkDashboardHeader;
	
	@FindBy(css= "iframe[name='analytics_cp_iwc_overview_v2']")
 	WebElement iwcContentPerformenceDashboardFrame;
	
	@FindBy(xpath = "//div[text()='Interactive Web Content (IWC)']")
 	WebElement iwcDashboardHeader;
	
	@FindBy(xpath = "//div[text()='Interactive Web Content (IWC)']/../../following-sibling::div[2]//div[@class='gridTab'][3]//span[@class]")
	WebElement iwcDashboardFirstLocationNameLink;
	
	@FindBy(xpath = "//div[text()='Your IWC vs. Network']")
 	WebElement yourIwcVsNetworkDashboardHeader;
	
	@FindBy(css= "iframe[id='your_edu_vs_network']")
 	WebElement yourEduVsNetworkDashboardFrame;
	
	@FindBy(xpath = "//span[.='YOUR CONTENT TO COMPARE']/../../following-sibling::button")
 	WebElement yourContentToCompareDropdown;
	
	@FindBy(xpath = "//span[.='All VTs']")
 	WebElement allVTsOption;
	
	@FindBy(xpath = "//span[.='All IWCs']")
 	WebElement allIWCsOption;
	
	@FindBy(xpath = "//span[.='Institution Sector']/../../following-sibling::button")
 	WebElement institutionSectorDropdown;
	
	@FindBy(xpath = "//span[.='Institution Size']/../../following-sibling::button")
 	WebElement institutionSizeDropdown;

	@FindBy(xpath = "//span[.='Institution Region']/../../following-sibling::button")
 	WebElement institutionRegionDropdown;
	
	@FindBy(xpath = "//div[text()='# of Visitors']")
 	WebElement noOfVisitorsDashboardHeader;
	
	@FindBy(xpath = "//div[text()='# of Visitors Over Time']")
 	WebElement noOfVisitorsOvertimeDashboardHeader;
	
	@FindBy(xpath = "//div[text()='Average Time Spent (Mins)']")
 	WebElement avgTimeSpentInMinsDashboardHeader;

	@FindBys(@FindBy(xpath = "//div[text()='# of Visitors']/../../..//canvas[1]"))
 	List<WebElement> youEduVsNetworkMaps;
	
	@FindBy(xpath = "//span[.='DATE RANGE']/following-sibling::div/button")
 	WebElement dateRangeDropdown;
	
	@FindBy(xpath = "//*[.='Last 7 days']")
 	WebElement last7DaysOption;
	
	@FindBy(xpath = "//*[.='Last 30 days']")
 	WebElement last30DaysOption;
	
	@FindBy(xpath = "//*[.='Last 90 days']")
 	WebElement last90DaysOption;
	
	@FindBy(xpath = "//*[.='Last 365 days']")
 	WebElement last365DaysOption;
	
	@FindBy(xpath = "//*[.='Custom Date']")
 	WebElement customDateOption;
	
	@FindBy(xpath = "//input[@placeholder='Start Date']")
 	WebElement customeStartDateOption;
	
	@FindBy(xpath = "//input[@placeholder='End Date']")
 	WebElement customEndDateOption;
	
	@FindBy(xpath = "//td[contains(@aria-label,'Selected as start date')]")
 	WebElement selectedCustomStartDate;
	
	@FindBy(xpath = "(//td[contains(@aria-label,'Selected.')])[1]")
 	WebElement nextdaySelectedCustomStartDate;
	
	@FindBy(xpath = "(//td[contains(@aria-label,'Selected.')])[last()]")
 	WebElement previousdaySelectedCustomEndDate;
	
	@FindBy(xpath = "//div[contains(@class,'dateDescription')]")
 	WebElement fromAndToCustomDates;
	
	public AAPAnalyticsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAnalyticsTabLink() throws Exception {
		click(analyticsTabLink);
	}
	
	public boolean verifyContentPerformenceLinkDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(contentPerformenceTabLink)) {
			ExtentTestManager.getTest().pass("Content Performence tab link is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Content Performence tab link is not displayed");
			return false;
		}
	}
	
	public boolean verifyYourEduVsNetworkLinkDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(yourEDUvsNetWorkTabLink)) {
			ExtentTestManager.getTest().pass("Your EDU Vs. NetWork tab link is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Your EDU Vs. NetWork tab link is not displayed");
			return false;
		}
	}
	
	public boolean verifyVTDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(vtDashboardHeader)) {
			ExtentTestManager.getTest().pass("Virtual Tours dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Virtual Tours dashboard header is not displayed");
			return false;
		}
	}
	
	public boolean verifyVtFirstLocationNameDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(vtDashboardFirstLocationNameLink)) {
			ExtentTestManager.getTest().pass("Virtual Tours dashboard first location name is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Virtual Tours dashboard results not displayed");
			return false;
		}
	}
	
	public void clickVtFirstLocationNameLink() throws Exception{
		Thread.sleep(8000);
		isPresentAndVisible(vtDashboardFirstLocationNameLink);
		click(vtDashboardFirstLocationNameLink);
	}
	
	public void switchToDefaultFrame() {
		switchToDefaultContent();
	}
	
	public void clickCloseVtButton() throws Exception{
		Thread.sleep(3000);
//		isPresentAndVisible(closeVtButton);
		int count=0;
		while(!isPresentAndVisibleVersion2(closeVtButton) && count<5) {
			switchToAnalyticsCpVtOverviewFrame();
			clickVtFirstLocationNameLink();
//			refreshPage();
			Thread.sleep(3000);
			switchToDefaultFrame();
			count++;
		}
		click(closeVtButton);
	}
		
	public void switchToAnalyticsCpVtOverviewFrame() {
		switchToFrame(vtContentPerformenceDashboardFrame);
	}

	public boolean verifyYourEduVsNetworkDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(yourVtVsNetworkDashboardHeader)) {
			ExtentTestManager.getTest().pass("Your Virtual Tours Vs.Network dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Your Virtual Tours Vs.Network dashboard header is not displayed");
			return false;
		}
	}
	
	public void switchToAnalyticsCpIwcOverviewFrame() {
		switchToFrame(iwcContentPerformenceDashboardFrame);
	}

	public boolean verifyiwcDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(iwcDashboardHeader)) {
			ExtentTestManager.getTest().pass("Interactive Web Content (IWC) dashboard is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Interactive Web Content (IWC) dashboard is not displayed");
			return false;
		}
	}

	public boolean verifyIwcFirstLocationNameDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(iwcDashboardFirstLocationNameLink)) {
			ExtentTestManager.getTest().pass("IWC results first row content displayed in the Dashboard");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Interactive Web Content (IWC) dashboard results not displayed");
			return false;
		}
	}
	
	public void clickIwcFirstRowContentLocationName() throws Exception{
		Thread.sleep(3000);
		click(iwcDashboardFirstLocationNameLink);
	}
	
	public boolean verifyYourIwcVsNetworkDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(yourIwcVsNetworkDashboardHeader)) {
			ExtentTestManager.getTest().pass("Your IWC Vs.Network dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Your IWC Vs.Network dashboard header is not displayed");
			return false;
		}
	}
	
	public void clickYourEduVsNetworkTabLink() throws Exception{
		waitAndFindElementByVisibility(yourEDUvsNetWorkTabLink);
		clickWithJavaScript(yourEDUvsNetWorkTabLink);
	}

	public void switchToYourEduVsNetworkDashboardFrame() {
		switchToFrame(yourEduVsNetworkDashboardFrame);
	}
	
	public String getYourContentToCompareDropdownText() {
		verifyPageTitle(pageTitle);
		isPresentAndVisible(yourContentToCompareDropdown);
		return yourContentToCompareDropdown.getText();
	}
	
	public void clickYourContentToCompareDropdown() throws Exception{
		clickWithJavaScript(yourContentToCompareDropdown);
	}
	
	public boolean verifyAllVTsOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(allVTsOption)) {
			ExtentTestManager.getTest().pass("All VTs option is displayed in the YOUR CONTENT TO COMPARE dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("All VTs option is not displayed in the  YOUR CONTENT TO COMPARE dropdown");
			return false;
		}
	}
	
	public boolean verifyAllIWCsOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(allIWCsOption)) {
			ExtentTestManager.getTest().pass("All IWCs option is displayed in the YOUR CONTENT TO COMPARE dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("All IWCs option is not displayed in the  YOUR CONTENT TO COMPARE dropdown");
			return false;
		}
	}
	
	public String getInstitutionSectorDropdownText() {
		return institutionSectorDropdown.getText();
	}
	
	public String getInstitutionSizeDropdownText() {
		return institutionSizeDropdown.getText();
	}
	
	public String getInstitutionRegionDropdownText() {
		return institutionRegionDropdown.getText();
	}
	
	public boolean verifyNoOfVisitorsDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(noOfVisitorsDashboardHeader)) {
			ExtentTestManager.getTest().pass("#. of Visitors dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("#. of Visitors dashboard header is not displayed");
			return false;
		}
	}
	
	public boolean verifyNoOfVisitorsOvertimeDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(noOfVisitorsOvertimeDashboardHeader)) {
			ExtentTestManager.getTest().pass("#. of Visitors Over Time dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("#. of Visitors Over Time dashboard header is not displayed");
			return false;
		}
	}
	
	public boolean verifyAvgTimeSpentDashboardHeaderDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(avgTimeSpentInMinsDashboardHeader)) {
			ExtentTestManager.getTest().pass("Average Time Spent (Mins) dashboard header is displayed");
			return true;
		}else {
			ExtentTestManager.getTest().fail("Average Time Spent (Mins) dashboard header is not displayed");
			return false;
		}
	}
	
	public int getNoOfYourEduVsNetworkMapsDisplayed() {
		verifyPageTitle(pageTitle);
		waitForListElements(youEduVsNetworkMaps);
		return youEduVsNetworkMaps.size();
	}
	
	public void clickDateRangeDropdown() throws Exception{
		verifyPageTitle(pageTitle);
		isPresentAndVisible(dateRangeDropdown);
		click(dateRangeDropdown);
	}
	
	public boolean verifyLast7DaysOptionDisplayed() throws Exception, InterruptedException {
		if(isPresentAndVisible(last7DaysOption)) {
			ExtentTestManager.getTest().pass("Last 7 days option is displayed in the Date Range dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("Last 7 days option option is not displayed in the Date Range dropdown");
			return false;
		}
	}
	
	public boolean verifyLast30DaysOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(last30DaysOption)) {
			ExtentTestManager.getTest().pass("Last 30 days option is displayed in the Date Range dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("Last 30 days option option is not displayed in the Date Range dropdown");
			return false;
		}
	}
	
	public boolean verifyLast90DaysOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(last90DaysOption)) {
			ExtentTestManager.getTest().pass("Last 90 days option is displayed in the Date Range dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("Last 90 days option option is not displayed in the Date Range dropdown");
			return false;
		}
	}
	
	public boolean verifyLast365DaysOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(last365DaysOption)) {
			ExtentTestManager.getTest().pass("Last 365 days option is displayed in the Date Range dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("Last 365 days option option is not displayed in the Date Range dropdown");
			return false;
		}
	}
	
	public boolean verifyLastCustomDateOptionDisplayed() throws Exception, InterruptedException {
		if(verifyFieldDisplayed(customDateOption)) {
			ExtentTestManager.getTest().pass("Custom Date option is displayed in the Date Range dropdown");
			return true;
		}else {
			ExtentTestManager.getTest().pass("Custom Date option option is not displayed in the Date Range dropdown");
			return false;
		}
	}
	
	public void clickCustomeDateOption() throws Exception{
		click(customDateOption);
	}
	
	public void clickCustomeStartDateOption() throws Exception{
		click(customeStartDateOption);
	}
	
	public int getSelectedNextDayCustomeStartDate() {
		return Integer.parseInt(nextdaySelectedCustomStartDate.getText());
	}
	
	public void clickSelectedNextDayCustomStartDate() throws Exception{
		click(nextdaySelectedCustomStartDate);
	}
	
	public int getSelectedPreviousDayCustomeEndDate() {
		return Integer.parseInt(previousdaySelectedCustomEndDate.getText());
	}
	
	public void clickSelectedPreviousDayCustomEndDate() throws Exception{
		click(previousdaySelectedCustomEndDate);
	}
	
	public String[] getFromAndToDates() {
		String[] Dates = fromAndToCustomDates.getText().split("/");
		String fromDate = Dates[1];
		String ToDate = Dates[3];
		String[] fromAndToDates = {fromDate, ToDate};
		return fromAndToDates;
	}
	
	public void waitForAnalyticsPageToLoad() throws Exception {
		waitForElementInvisibilityWithBy(loadingBy);
	}
	
	@FindBy(xpath = "//div[contains(@class='mask loading-icon')]")
 	WebElement loadIcon;
	
	public void waitForDataLoading() {
		waitForElementInvisibility(loadIcon);
	}
	
}
