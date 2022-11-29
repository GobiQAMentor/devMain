package com.pages.imap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;
import com.utils.ElementUtil;

public class ImapPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	ElementUtil eUtil;
	@FindBy(xpath = "//div[text()='Interactive Map']")
	WebElement interactiveMapButton;
	@FindBy(id = "mapMinArrow_button")
	WebElement mapMinArrowButton;
	@FindBy(xpath = "//div[@id='mapFull_button']")
	WebElement interactiveMapFullScreenButton;
	@FindBy(xpath = "//button[contains(@class,'menuShare')]")
	WebElement shareIcon;
	@FindBy(xpath = "(//div[contains(@class,'iconCol')])[1]")
	WebElement shareChainIcon;
	@FindBy(xpath = "(//div[contains(@class,'iconCol')])[2]")
	WebElement shareFacebookIcon;
	@FindBy(xpath = "(//div[contains(@class,'iconCol')])[3]")
	WebElement shareTwitterIcon;
	@FindBy(xpath = "(//div[contains(@class,'iconCol')])[4]")
	WebElement sharePinterestIcon;
	@FindBy(xpath = "//div[text()='Campus Map']")
	WebElement campusMapField;
	@FindBy(xpath = "//div[text()='Google Map']")
	WebElement googleMapField;
	@FindBy(xpath = "//button[text()='Destinations']")
	WebElement destinationsButton;
	@FindBy(xpath = "//div[contains(@class,'destinationsContainer')]")
	WebElement destinationsList;
	@FindBy(xpath = "//div[@id='destinationslist']//button[3]")
	WebElement destinationsListButton4;
	@FindBy(xpath = "//div[contains(@class,'description')]")
	WebElement destinationsDescription;
	@FindBy(xpath = "//button[@data-testid='audioPlayer']")
	WebElement destinationsAudioPlayButton;
	@FindBy(xpath = "(//div[contains(@class,'mediaIcon')])[1]")
	WebElement destinationsPanoDescriptionImap;
	@FindBy(xpath = "(//div[contains(@class,'mediaIcon')])[2]")
	WebElement destinationsVideoDescriptionImap;
	@FindBy(xpath = "//img[contains(@alt,'photos')]")
	WebElement destinationsPhotoDescriptionImap;
	@FindBy(xpath = "//div[@id='destinationslist']//button[1]")
	WebElement destinationsListButton1;
	@FindBy(xpath = "//span[contains(@class,'closeIcon')]")
	WebElement closeIconDescriptionImap;
	@FindBy(xpath = "//span[contains(@class,'iconContainer')]")
	WebElement  supplimentalButtonImap;
	@FindBy(xpath = "//img[contains(@alt,'photos')]/following-sibling::div//span[contains(@class,'iconContainer')]")
	WebElement supplimentalPhotosIconImap;
	@FindBy(xpath = "//button[contains(@class,'rightArrow')]")
	WebElement rightArrowButton;
	@FindBy(xpath = "//button[contains(@class,'leftArrow')]")
	WebElement leftArrowButton;
	@FindBy(css = "[data-testid='carousel']")
	WebElement carouselImapFrame;
	@FindBy(xpath = "//button[@aria-label ='Switch map view to satellite' and @type='button']")
	WebElement satelliteViewButton;
	@FindBy(xpath = "//button[@aria-label ='Geolocation' and @type='button']")
	WebElement geoLocation;
	@FindBy(id = "destinationMobileIcon")
	WebElement destinationMobileIcon;
	@FindBy(xpath = "//a[text()='Register Now']")
	WebElement registerButton;
	@FindBy(xpath = "//iframe[contains(@class,'iframeContainer')]")
	WebElement virtualTouriframe;
	@FindBy(xpath = "//a[text()='Schedule Visit']")
	WebElement scheduleVisitButton;
	@FindBy(xpath = "//a[text()='Apply Online']")
	WebElement applyOnlinetButton;
	@FindBy(css = "[role='button'] circle")
	WebElement infoIcon;
	@FindBy(xpath = "//div[contains(@class,'desktop')]//canvas")
	WebElement desktopCanvasPanoFrame;
	@FindBy(xpath = "//div[contains(@class,'fullScreen')]")
	WebElement fullScreenButton;
	@FindBy(id = "trailsIcon")
	WebElement trailsIcon;
	@FindBy(xpath = "(//div[@id='trailslist']/div)[1]/button")
	WebElement customTrailsAIcon;
	@FindBy(xpath = "(//div[@id='trailslist']/div)[3]/button")
	WebElement customTrailsBIcon;
	@FindBy(xpath = "(//div[@id='slot3'])[2]")
	WebElement trailsCloseLink;
	@FindBy(xpath = "(//div[@title='Directions'])[1]")
	WebElement directionsIcon;
	@FindBy(xpath = "//div[@id='startDestination']")
	WebElement startDestinationField;
	@FindBy(xpath = "//div[contains(@class,'directions')]//button[contains(@class,'flex')][2]/div[contains(@class,'suggestionName')]")
	WebElement location2InDirectionsField;
	@FindBy(xpath = "//div[contains(@class,'directions')]//button[contains(@class,'flex')][3]/div[contains(@class,'suggestionName')]")
	WebElement location3InDirectionsField;
	@FindBy(xpath = "//div[contains(@class,'directions')]//button[contains(@class,'flex')][1]/div[contains(@class,'suggestionName')]")
	WebElement location1InDirectionsField;

	public ImapPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eUtil =  new ElementUtil(driver);
	}
	public void navigateToImapPageLogin(String url) throws Exception {
		deleteAllCookies();
		//refreshPage();
		//driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}

	public void navigateToImapLoginPage(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void clickDestinationsList() throws Exception {
		isPresentAndVisible(destinationsList);
		click(destinationsList);
	}
	public void clickDestinationsButton() throws Exception {
		waitAndFindElementByVisibility(destinationsButton);
		clickWithJavaScript(destinationsButton);
	}
	public void clickCampusMapField() throws Exception {
		isPresentAndVisible(campusMapField);
		click(campusMapField);
	}
	public void clickGoogleMapField() throws Exception {
		isPresentAndVisible(googleMapField);
		click(googleMapField);
	}
	public void clickInteractiveMapButton() throws Exception {
		waitAndFindElementByVisibility(interactiveMapButton);
		isPresentAndVisible(interactiveMapButton);
		clickWithJavaScript(interactiveMapButton);
	}
	public void verifyMapMinArrowButton() throws Exception {
		waits(2);
		waitAndFindElementByVisibility(mapMinArrowButton);
		isPresentAndVisible(mapMinArrowButton);
	}
	public void mouseHovermapMinArrowButton() throws Exception {
		mouseHoverElement(mapMinArrowButton);
	}
	public void clickInteractiveMapFullScreenButton() throws Exception {
		waits(1);
		waitAndFindElementByVisibility(interactiveMapFullScreenButton);
		clickWithJavaScript(interactiveMapFullScreenButton);
	}
	public void mouseHoverInteractiveMapButton() throws Exception {
		waitAndFindElementByVisibility(interactiveMapButton);
		mouseHoverElement(interactiveMapButton);
	}
	public void switchToTheNewTab() {
		switchToNewTab();
	}
	public void clickShareIcon() throws Exception {
		click(shareIcon);
	}
	public void verifyShareTwitterIcon() throws Exception {
		isPresentAndVisible(shareTwitterIcon);
	}
	public void verifyShareChainIcon() throws Exception {
		isPresentAndVisible(shareChainIcon);
	}
	public void verifyShareFacebookIcon() throws Exception {
		isPresentAndVisible(shareFacebookIcon);
	}
	public void verifySharePinterestIcon() throws Exception {
		isPresentAndVisible(sharePinterestIcon);
	}
	public void navigateToMaristUrl(String url)
	{
		navigateTo(url);
	}
	public void clickDestinationsListOption4() throws Exception
	{
		click(destinationsListButton4);
	}
	public String destinationsListOption4ColorBeforeClick(String value) throws Exception
	{
		return getCssValue(destinationsListButton4, value);
	}
	public String destinationsListOption4ColorAfterClick(String value) throws Exception
	{
		return getCssValue(destinationsListButton4, value);
	}
	public void verifyDestinationsDescription() throws Exception {
		isPresentAndVisible(destinationsDescription);
	}
	public void verifyDestinationsAudioPlayButton() throws Exception {
		isPresentAndVisible(destinationsAudioPlayButton);
	}
	public void verifyDestinationsVideoDescriptionImap() throws Exception {
		isPresentAndVisible(destinationsVideoDescriptionImap);
	}
	public void verifyDestinationsPhotoDescriptionImap() throws Exception {
		isPresentAndVisible(destinationsPhotoDescriptionImap);
	}
	public void verifyDestinationsPanoDescriptionImap() throws Exception {
		isPresentAndVisible(destinationsPanoDescriptionImap);
	}
	public void clickDestinationsListOption1() throws Exception
	{
		click(destinationsListButton1);
	}
	public void clickCloseIconDescriptionImap() throws Exception
	{
		click(closeIconDescriptionImap);
	}
	public void verifySupplimentalButtonImap() throws Exception {
		isPresentAndVisible(supplimentalButtonImap);
	}
	public void verifySupplimentalPhotosIconImap() throws Exception {
		isPresentAndVisible(supplimentalPhotosIconImap);
	}
	public void clickDestinationsPhotoDescriptionImap() throws Exception
	{
		clickWithJavaScript(destinationsPhotoDescriptionImap);
	}
	public void verifyRightArrowButton() throws Exception {
		isPresentAndVisible(rightArrowButton);
	}
	public void verifyLeftArrowButton() throws Exception {
		isPresentAndVisible(leftArrowButton);
	}
	public void verifyCarouselImapFrame() throws Exception {
		isPresentAndVisible(carouselImapFrame);
	}
	public void clickRightArrowButton() throws Exception {
		clickWithJavaScript(rightArrowButton);
	}
	public void clickLeftArrowButton() throws Exception {
		clickWithJavaScript(leftArrowButton);
	}

	public void changeScreenSize1() throws Exception {
		Dimension d= new Dimension(1220,700);
		driver.manage().window().setSize(d);	
	}
	public void verifySatelliteViewButton() throws Exception {
		isPresentAndVisible(satelliteViewButton);
	}
	public void verifyGeoLocation() throws Exception {
		isPresentAndVisible(geoLocation);
	}
	public void changeScreenSize2() throws Exception {
		Dimension d= new Dimension(1199,700);
		driver.manage().window().setSize(d);	
	}
	public void verifyDestinationsButton() throws Exception {
		isPresentAndVisible(destinationsButton);
	}
	public void verifyDestinationMobileIcon() throws Exception {
		isPresentAndVisible(destinationMobileIcon);
	}
	public void clickRegisterButton() throws Exception {
		click(registerButton);
	}
	public void switchToTheVirtualtourFrame() throws Exception {
		switchToFrame(virtualTouriframe);
	}
	public void verifyRegisterButton() throws Exception {
		isPresentAndVisible(registerButton);
	}
	public void verifyScheduleVisitButton() throws Exception {
		isPresentAndVisible(scheduleVisitButton);
	}
	public void verifyApplyOnlinetButton() throws Exception {
		isPresentAndVisible(applyOnlinetButton);
	}
	public void verifyScheduleVisitRegisterAndApplyOnlineButtonColor() throws Exception {
		String registerNowColor = registerButton.getCssValue("background-color");
		String applyOnlinecolor = applyOnlinetButton.getCssValue("background-color");
		String scheduleVisitColor = scheduleVisitButton.getCssValue("background-color");
		if((registerNowColor==scheduleVisitColor)&&(registerNowColor==applyOnlinecolor))
			ExtentTestManager.getTest().fail("All 3 CTA button colors are not different");
		else
			ExtentTestManager.getTest().pass("All 3 CTA button colors are different");
	}
	public void clickDestinationsPanoDescriptionImap() throws Exception {
		click(destinationsPanoDescriptionImap);
	}
	public void verifyinfoIcon() throws Exception {
		isPresentAndVisible(infoIcon);
	}
	public void verifyPanoFrameHeightAndWidth() throws Exception {
		String width1 = desktopCanvasPanoFrame.getCssValue("width");
		String height1 = desktopCanvasPanoFrame.getCssValue("height");
		click(fullScreenButton);
		String width2 = desktopCanvasPanoFrame.getCssValue("width");
		String height2 = desktopCanvasPanoFrame.getCssValue("height");
		if((width1==width2)&&(height1==height2)) 
			ExtentTestManager.getTest().fail("Panorama is not in Full Screen Mode as Expected");
		else 
			ExtentTestManager.getTest().pass("Panorama is in Full Screen Mode as Expected");
	}
	public void clickFullScreenButton() throws Exception {
		click(fullScreenButton);
	}
	public void clickDestinationsVideoDescriptionImap() throws Exception {
		click(destinationsVideoDescriptionImap);
	}
	public void clickTrailsIcon() throws Exception {
		click(trailsIcon);
	}
	public void clickCustomTrailsAIcon() throws Exception {
		click(customTrailsAIcon);
	}
	public void clickCustomTrailsBIcon() throws Exception {
		click(customTrailsBIcon);
	}
	public void clickTrailsCloseLink() throws Exception {
		click(trailsCloseLink);
	}
	public void clickDirectionsIcon() throws Exception {
		click(directionsIcon);
	}
	public void verifyStartDestinationField() throws Exception {
		isPresentAndVisible(startDestinationField);
	}
	public void verifyLocation1InDirectionsField() throws Exception {
		isPresentAndVisible(location1InDirectionsField);
	}
	public void verifyLocation2InDirectionsField() throws Exception {
		isPresentAndVisible(location2InDirectionsField);
	}
	public void verifyLocation3InDirectionsField() throws Exception {
		isPresentAndVisible(location3InDirectionsField);
	}
	public void goToMainTabCloseOtherTabs(String browser) {
		eUtil.doGetParentWindow();
		closeAllTabsAndSwitchToMainTab(browser);
	}
}

