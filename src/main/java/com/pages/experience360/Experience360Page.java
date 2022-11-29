package com.pages.experience360;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;
import com.utils.ElementUtil;

public class Experience360Page extends ObjectsControl implements PageInterface{
	ElementUtil eUtil;
	WebDriver driver;
//==
	JavascriptExecutor js = null;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Close')]")
	WebElement closeButton;
	@FindBy(xpath = "//div[@id='close_button']")
	WebElement closeVRButton;
	@FindBy(xpath = "//img[@alt='sbu logo']")
	WebElement stonybrookUniversityLogo;
	@FindBy(xpath = "//h1[contains(text(),'How to Apply')]")
	WebElement howToApplyHeader;
	@FindBy(xpath = "//div[contains(@class,'info_desktop')]")
	WebElement infoButton;
	@FindBy(xpath = "//div[@id='share_desktop_button']")
	WebElement shareButton;
	@FindBy(xpath = "//div[@class='email']")
	WebElement shareViaEmailButton;
	@FindBy(xpath = "//div[@class='link']")
	WebElement shareViaLinkButton;
	@FindBy(xpath = "//button[@class='twitter']")
	WebElement shareViaTwitterButton;
	@FindBy(xpath = "//button[@class='linkedin']")
	WebElement shareViaLinkedInButton;
	@FindBy(xpath = "//button[@class='facebook']")
	WebElement shareViaFacebookButton;
	@FindBy(xpath = "//div[@id='language_button']")
	WebElement languageButton;
	@FindBy(id = "skip_intro")
	WebElement skipIntroButton;
	@FindBy(xpath = "//div[contains(@class,'preview')]")
	WebElement degree360Icon;
	@FindBy(xpath = "//button[contains(@class,'playing')]")
	WebElement degree360IconVideoPlaying;
	@FindBy(xpath = "//button[contains(@class,'paused')]")
	WebElement degree360VideoPauseButton;
	@FindBy(xpath = "//li[text()='Plan a visit']")
	WebElement nauScheduleVisit;
	
	By shareButtonBy = By.xpath("//div[@id='share_desktop_button']");
	By langButtonBy = By.xpath("//div[@id='language_button']");
	By moreButtonBy = By.xpath("//div[@id='overflow_button_button']");
	By expandButtonBy = By.xpath("(//div[@data-test='Tag'])[2]");
	By videoPlayingBy = By.xpath("//button[contains(@class,'playing')]");
	
	public Experience360Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		js=(JavascriptExecutor)driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToExperience360PageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void navigateToExperience360ORPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void navigateToExperience360NauPageLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void verifyShareViaFacebookButton() throws Exception {
		isPresentAndVisible(shareViaFacebookButton);
	}
	public void verifyShareViaLinkedInButton() throws Exception {
		isPresentAndVisible(shareViaLinkedInButton);
	}
	public void verifyShareViaTwitterButton() throws Exception {
		isPresentAndVisible(shareViaTwitterButton);
	}
	public void verifyShareViaLinkButton() throws Exception {
		isPresentAndVisible(shareViaLinkButton);
	}
	public void verifyShareViaEmailButton() throws Exception {
		isPresentAndVisible(shareViaEmailButton);
	}
	public void verifyInfoButton() throws Exception {
		isPresentAndVisible(infoButton);
	}
	public void verifyAndClickShareButton() throws Exception {
		isPresentAndVisible(shareButton);
		waitForAndFindElementByLocator(shareButtonBy).click();
	}
	
	public void clickMoreButton() {
		waitForAndFindElementByLocator(moreButtonBy).click();
	}
	
	public void clickExpandFullscreenButton() {
		waitForAndFindElementByLocator(expandButtonBy).click();
	}
	
	public void clickCloseButton() throws Exception {
		clickWithJavaScript(closeButton);
		waits(5);
	}
	public void clickCloseVRButton() throws Exception {
		click(closeVRButton);
	}
	public void verifyStonybrookUniversityLogo() throws Exception {
		isPresentAndVisible(stonybrookUniversityLogo);
	}
	public void switchToTheOldTab() {
		switchToOldTab();
	}
	public void verifyHowToApplyHeader() throws Exception {
		isPresentAndVisible(howToApplyHeader);
	}
	public void clickLanguageButton() throws Exception {
		waitForAndFindElementByLocator(langButtonBy).click();
	}
	public void clickSkipIntroButton() throws Exception {
		click(skipIntroButton);
		waitInvisibilityOfLoadingIndicator();
	}
	public void clickDegree360Icon() throws Exception {
		click(degree360Icon);
		waitInvisibilityOfLoadingIndicator();
	}
	public void verifyAndClickDegree360IconVideoPlaying() throws Exception {
		//isPresentAndVisible(degree360IconVideoPlaying);
		//ExtentTestManager.getTest().pass("degree360IconVideoPlaying is verified");
		waitForAndFindElementByLocator(videoPlayingBy).click();
		ExtentTestManager.getTest().pass("360 Degree Video is Playing by clicking PlayIcon");
		verifyPlayPauseMediaInRenaissancehotelsEmpireSuite();
//		click(degree360IconVideoPlaying);
	}
	public void verifyAndClickDegree360VideoPauseButton() throws Exception {
		isPresentAndVisible(degree360VideoPauseButton);
		click(degree360VideoPauseButton);
		ExtentTestManager.getTest().pass("Verify Video Paused by clicking the PauseIcon");
		verify360Playing();
	}

//==
	public void verifyImageHotspot() throws InterruptedException {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[0].click()");
		ExtentTestManager.getTest().pass("Click on \'Image Hotspot\'");
		waits(3);
		js.executeScript("var meshes = get2DHitMeshes(); meshes[0].click()");
		ExtentTestManager.getTest().pass("Verify 'Image Hotpot' elements are displayed");		
	}
	
	public void verifyVideoPlaying() {
		js.executeScript("var meshes = $$$.getHitMeshes(); meshes[2].click()");
		ExtentTestManager.getTest().pass("Verify Video Playing using three muskteers");
	}
	
	public void verifyPlayPauseMedia() {
		js.executeScript("var meshes = $$$.getHitMeshes(); meshes[0].click()");
		ExtentTestManager.getTest().pass("Verify Video Paused using three muskteers");
	}
	
	public void verify360Playing() {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[1].click()");
		ExtentTestManager.getTest().pass("Verify Video Playing using get2DHitMeshes() of three muskteers");
	}
	
	public void verifyPlayPauseMediaInRenaissancehotelsEmpireSuite() {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[1].click()");
		ExtentTestManager.getTest().pass("Verify Video Paused using get2DHitMeshes() of three muskteers");
	}
//==//
	
	public void verifyNauScheduleVisit() throws Exception {
		isPresentAndVisible(nauScheduleVisit);
	}
	
	public void goToMainTabCloseOtherTabs(String browser) {
		eUtil.doGetParentWindow();
		closeAllTabsAndSwitchToMainTab(browser);
	}
	
	public void collapseFullScreenButton() throws Exception {
		Thread.sleep(5000);
		clickMoreButton();
		clickExpandFullscreenButton();
		ExtentTestManager.getTest().pass("Full Screen collapsed");
//		sendModifierKeys(Keys.ESCAPE);
	}
	
	public void waitInvisibilityOfLoadingIndicator() throws Exception {
		waitForElementInvisibilityWithBy(By.xpath("//div[contains(@class,'loadingIndicator')]"));
	}
}
