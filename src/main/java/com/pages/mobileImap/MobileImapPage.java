package com.pages.mobileImap;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.github.javafaker.Faker;
import com.pages.PageInterface;
import com.utils.UtilityClass;

public class MobileImapPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	UtilityClass util;
	Faker faker = new Faker();

	@FindBy(xpath = "(//div[@id='trailslist']/div)[1]/button")
	WebElement customTrailATrailsIconImap;
	@FindBy(xpath = "(//div[@id='trailslist']/div)[2]/button")
	WebElement customTrailBTrailsIconImap;
	@FindBy(xpath = "(//*[@id='arrowLeftIcon'])[1]")
	WebElement trailsBackbuttonMobileImap;
	@FindBy(xpath = "(//*[@id='directionsIcon'])[1]")
	WebElement trailsDirectionsIconMobileImap;
	@FindBy(xpath = "//*[@id='destinationMobileIcon']//following::*[@id='trailsIcon']")
	WebElement trailsIcon;
	@FindBy(xpath = "//div[contains(@style,'/media/interactive_map')]/parent::a")
	WebElement mobileImapIcon;
	@FindBy(xpath = "//div[@id='campusMap']")
	WebElement campusMapImapMobile;
	@FindBy(xpath = "//*[@id='destinationMobileIcon']")
	WebElement detinationsImapMobileIcon;
	@FindBy(xpath = "//*[@id='destinationMobileIcon']//following::*[@id='trailsIcon']")
	WebElement trailsImapMobileIcon;
	@FindBy(xpath = "//a[@rel='noopener noreferrer nofollow']")
	List<WebElement> cta1ImapMobileButton;
	@FindBy(xpath = "//button[@id='geolocation']")
	WebElement geolocationImapMobile;
	@FindBy(xpath = "//button[@aria-label='Switch map view to satellite']")
	WebElement switchSatelliteModeIcon;
	@FindBy(xpath = "//li[2]//a[contains(@class,'e-linkContainer')]")
	WebElement secondTourLink;
	@FindBy(xpath = "//div[contains(@style,'/media/icon_map2')]/parent::a")
	WebElement mobileImapSecondIcon;
	@FindBy(xpath = "//div[text()='Campus Map']")
	WebElement campusMapField;
	@FindBy(xpath = "//div[text()='Google Map']")
	WebElement googleMapField;
	@FindBy(xpath = "//*[@id='destinationMobileIcon']")
	WebElement destinationsButton;
	@FindBy(xpath = "//button[@id='currentLabel' and text()='Destinations']")
	WebElement destinationsLink;
	@FindBy(xpath = "(//*[@id='trailsIcon'])[2]")
	WebElement trailsMobileSearchIcon;
	@FindBy(xpath = "(//*[@id='closeIcon'])[2]")
	WebElement trailsMobileCloseIcon;
	@FindBy(xpath = "//button/div[contains(@style,'/media/80175/panoramas/')]")
	WebElement detinationsMobileList;
	@FindBy(xpath = "//a[@rel='noopener noreferrer nofollow']")
	WebElement cta1ImapMobileLink;
	@FindBy(xpath = "//div[contains(@class,'directions')]//button[contains(@class,'flex')][2]/div[contains(@class,'suggestionName')]")
	WebElement location2DirectionsImap;
	@FindBy(xpath = "//div[contains(@class,'directions')]//button[contains(@class,'flex')][3]/div[contains(@class,'suggestionName')]")
	WebElement location3DirectionsImap;
	@FindBy(xpath = "//input[@placeholder='Choose starting point']")
	WebElement directionsStartingPointImap;
	@FindBy(xpath = "//input[@placeholder='Choose destination']")
	WebElement directionsDestinationPointImap;
	@FindBy(xpath = "//button[contains(@class,'clear-test-class clearText')]")
	WebElement directionsStartingPointClearButton;
	@FindBy(xpath = "//button[contains(@class,'clear-test-class clearText')]")
	WebElement directionsStartingPointClearButtonImap;
	@FindBy(xpath = "//button[@id='currentLabel' and text()='Trails']")
	WebElement trailsTitleMobileImap;
	@FindBy(xpath = "(//button[@id='currentLabel' and text()='Destinations'])[2]")
	WebElement destinationsMobileSearch;
	@FindBy(xpath = "(//div[@id='trailslist']/div//div[contains(@class,'suggestionName')])[2]")
	WebElement trailsSecondName;
	@FindBy(xpath = "//button[contains(@class,'arrowButton')]")
	WebElement trailsRightArrow;
	@FindBy(xpath = "//div[@aria-label='Map']")
	WebElement trailsFullMap;
	@FindBy(xpath = "//div[@id='currentLabel']/button[@id='currentLabel' and text()='Custom Trails B']")
	WebElement trailsSelectedNameHeader;
	@FindBy(xpath = "(//button[@id='currentLabel' and text()='Destinations'])")
	WebElement destinationsMobileBurgerIcon;
	@FindBy(xpath = "(//button/div[contains(@style,'/media/80175/panoramas/')]/following::div[contains(@class,'text')])[2]")
	WebElement secondDestinationsInMobileList;
	@FindBy(xpath = "//span[contains(@class,'smallTitle')]	")
	WebElement smallTitleInDescriptionField;
	@FindBy(xpath = "//div[contains(@class,'mainImageContainer')]/img")
	WebElement supplimentalProfileImage;
	@FindBy(xpath = "(//span[contains(@class,'title')])[2]")
	WebElement supplimentalNameTitle;
	@FindBy(xpath = "(//button[@data-testid='audioPlayer'])[2]")
	WebElement supplimentalAudioplayer;
	@FindBy(xpath = "(//div[contains(@class,'description')])[2]")
	WebElement supplimentalWrittenSummary;
	@FindBy(xpath = "(//div[contains(@class,'mediaContainer')])[2]")
	WebElement supplimentalMedia;
	@FindBy(xpath = "(//span[contains(@class,'closeContainerTitle')]/following::span)[1]")
	WebElement supplimentalCloseButton;
	@FindBy(xpath = "(//*[@id='closeIcon'])[3]")
	WebElement trailCloseIcon;
	@FindBy(xpath = "(//button[@id='currentLabel' and text()='Destinations'])[2]")
	WebElement destinationHeader;
	@FindBy(xpath = "//button/div[contains(@style,'/media/80175/panoramas/')]")
	WebElement destinationList;
	@FindBy(xpath = "//div[@id='destinationslist']//button[2]")
	WebElement destinationList2;
	@FindBy(xpath = "//button/div[contains(@style,'/media/80175/panoramas/')]")
	List<WebElement> detinationsMobileLists;

	public MobileImapPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToMobileImapPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void navigateToMobileCifPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void navigateToImapPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void clickMobileImapIcon() throws Exception {
		clickWithJavaScript(mobileImapIcon);
	}
	public void verifyDestinationsMobileSearch() throws Exception {
		isPresentAndVisible(destinationsMobileSearch);
	}
	public void verifyCampusMapImapMobile() throws Exception {
		isPresentAndVisible(campusMapImapMobile);
	}
	public void verifyTrailsImapMobileIcon() throws Exception {
		isPresentAndVisible(trailsImapMobileIcon);
	}
	public void verifyGeolocationImapMobile() throws Exception {
		isPresentAndVisible(geolocationImapMobile);
	}
	public void verifyCta1ImapMobileButton() throws Exception {
		isPresentAndVisible(cta1ImapMobileLink);
	}
	public void clickSwitchSatelliteModeIcon() throws Exception {
		clickWithJavaScript(switchSatelliteModeIcon);
	}
	public void clickSeconfBookLink() throws Exception {
		click(secondTourLink);
	}
	public void clickMobileImapSecondIcon() throws Exception {
		clickWithJavaScript(mobileImapSecondIcon);
	}
	public void navigateToMaristUrl(String url)
	{
		navigateTo(url);
	}
	public void verifyCampusMapField() throws Exception {
		isPresentAndVisible(campusMapField);
	}
	public void verifiyGoogleMapField() throws Exception {
		isPresentAndVisible(googleMapField);
	}
	public void clickDestinationsButton() throws Exception {
		isPresentAndVisible(destinationsButton);
		click(destinationsButton);
	}
	public void verifyDestinationsField() throws Exception {
		isPresentAndVisible(destinationHeader);
	}
	public void verifyTrailsMobileSearchIcon() throws Exception {
		isPresentAndVisible(trailsMobileSearchIcon);
	}
	public void verifyTrailsMobileCloseIcon() throws Exception {
		isPresentAndVisible(trailsMobileCloseIcon);
	}
	public boolean verifyNoOfCtaButtonsVisibleOnMobile(WebDriver driver, ExtentTest ext_test) {
		boolean flag = false;
		List<WebElement> buttonsCount = cta1ImapMobileButton;
		int noOfButtonsVisible = 0;
		for (WebElement element : buttonsCount) {
			if(element.isDisplayed())
				noOfButtonsVisible++;
		}
		if(noOfButtonsVisible==1) {
			ext_test.pass("Only one cta button visible as expected");
			flag = true;
		}else
			ext_test.fail("More than one cta button visible");
		return flag;
	}
	public void clickTrailsIcon() throws Exception {
		click(trailsIcon);
	}
	public void clickTrailsDirectionsIconMobileImap() throws Exception {
		click(trailsDirectionsIconMobileImap);
	}
	public void verifyTrailsDirectionsIconMobileImap() throws Exception {
		isPresentAndVisible(trailsDirectionsIconMobileImap);
	}

	public void verifyStartingAndEndingPoints() throws Exception
	{
		String StartingPoint = location2DirectionsImap.getText();
		//System.out.println("StartingPoint "+StartingPoint);
		String EndingPoint = location3DirectionsImap.getText();
		//System.out.println("EndingPoint "+EndingPoint);
		click(location2DirectionsImap);
		//getElement(driver,"location2_directions_imap_xpath",ExtentTestManager.getTest()).click();
		ExtentTestManager.getTest().pass("Click on location["+StartingPoint+"]");
		//getElement(driver,"location3_directions_imap_xpath",ExtentTestManager.getTest()).click();
		ExtentTestManager.getTest().pass("Click on location["+EndingPoint+"]");
		click(location3DirectionsImap);
		String direction_StartingPoint = directionsStartingPointImap.getAttribute("value");
		System.out.println("direction_StartingPoint "+direction_StartingPoint);
		String direction_EndingPoint = directionsDestinationPointImap.getAttribute("value");
		System.out.println("direction_EndingPoint "+direction_EndingPoint);
		if((StartingPoint.equals(direction_StartingPoint))&&(EndingPoint.equals(direction_EndingPoint))) 
			ExtentTestManager.getTest().pass("Actual Starting and Ending points are same as Expected");
		else 
			ExtentTestManager.getTest().fail("Actual Starting and Ending points are not same as Expected");
		click(directionsStartingPointClearButtonImap);
		ExtentTestManager.getTest().pass("Click on clear starting point icon");
		click(location3DirectionsImap);
		ExtentTestManager.getTest().pass("Click on location["+EndingPoint+"]");
	}

	public void verifyTrailsBackbuttonMobileImap() throws Exception {
		isPresentAndVisible(trailsBackbuttonMobileImap);
	}
	public void verifyTrailsTitleMobileImap() throws Exception {
		isPresentAndVisible(trailsTitleMobileImap);
	}
	public void verifyCustomTrailATrailsIconImap() throws Exception {
		isPresentAndVisible(customTrailATrailsIconImap);
	}
	public void verifyCustomTrailBTrailsIconImap() throws Exception {
		isPresentAndVisible(customTrailBTrailsIconImap);
	}
	public void verifySelectedTrailNameAndSeletedTrailNameHeader() throws Exception {
		click(customTrailBTrailsIconImap);
		ExtentTestManager.getTest().pass("Clicked on second saved trail displayed in the list");
		String trailsName = trailsSecondName.getText();
		System.out.println("############# Trails Name : "+ trailsName);
		isPresentAndVisible(trailsRightArrow);
		ExtentTestManager.getTest().pass("Right arrow icon displayed for the selected trail");
		click(trailsRightArrow);
		ExtentTestManager.getTest().pass("Clicked on right-arrow of the selected trail displayed in the list");
		//click(trailsFullMap);
		//ExtentTestManager.getTest().pass("full map displayed as expected");
		String selectedTrailsName = trailsSelectedNameHeader.getText();
		System.out.println("############# Trails Name : "+ trailsName);
		if(trailsName.equalsIgnoreCase(selectedTrailsName))
			ExtentTestManager.getTest().pass("Selected name displayed in the header");
		else
			ExtentTestManager.getTest().fail("Selected name is not displayed in the header");
	}
	public void clickDestinationsMobileBurgerIcon() throws Exception {
		clickWithJavaScript(destinationsMobileBurgerIcon);
	}
	public void clickSecondDestinationsInMobileList() throws Exception {
		clickWithJavaScript(secondDestinationsInMobileList);
	}
	public void clickSmallTitleInDescriptionField() throws Exception {
		isPresentAndVisible(smallTitleInDescriptionField);
		clickWithJavaScript(smallTitleInDescriptionField);
	}
	public void verifySupplimentalProfileImage() throws Exception {
		isPresentAndVisible(supplimentalProfileImage);
	}
	public void verifySupplimentalNameTitle() throws Exception {
		isPresentAndVisible(supplimentalNameTitle);
	}
	public void clickSupplimentalAudioplayer() throws Exception {
		isPresentAndVisible(supplimentalAudioplayer);
		clickWithJavaScript(supplimentalAudioplayer);
	}
	public void verifySupplimentalWrittenSummary() throws Exception {
		isPresentAndVisible(supplimentalWrittenSummary);
	}
	public void verifySupplimentalMedia() throws Exception {
		isPresentAndVisible(supplimentalMedia);
	}
	public void verifySupplimentalCloseButton() throws Exception {
		isPresentAndVisible(supplimentalCloseButton);
	}
	public void clickTrailsCloseIcon() throws Exception {
		click(trailCloseIcon);
	}
	public void clickDestinationList2() throws Exception {
		click(destinationList2);
	}
	
	public void verifyDestinationLists() throws Exception {
		List<WebElement> destinationSideBarList = null;
		destinationSideBarList = detinationsMobileLists;
		System.out.println("LISTS = "+destinationSideBarList);
		int index = 2;
		click(destinationSideBarList.get(index));
		ExtentTestManager.getTest().pass("Second destination list is clicked");
	}
}
