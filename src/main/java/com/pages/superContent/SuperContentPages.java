package com.pages.superContent;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.driver.DriverInstance;
import com.pages.PageInterface;
import com.utils.ElementUtil;

public class SuperContentPages  extends ObjectsControl implements PageInterface{
	
	WebDriver driver;
	ElementUtil eleUtils;
	
	@FindBy(xpath = "//div[contains(@aria-label,'Close')]")
	WebElement closeRegistrationIcon;
	
	@FindBy(xpath = "//a[contains(@class,'e-linkContainer')][1]")
	WebElement firstVirtualTourLink;
	
	@FindBy(xpath = "//div[@data-test='SupplementalMediaInlineView']")
	WebElement supplementalMediaInlineViewButton;
	
	@FindBy(xpath = "//div[@data-test='Clamp']")
	WebElement sceneNameText;
	
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
	WebElement shareViaFaceBookButton;
	
	@FindBy(xpath = "//div[@id='toggle_description_button']")
	WebElement infoButton;
	
	@FindBy(xpath = "//div[@data-test='ContextMenu']")
	WebElement homeCanvasButton;

 	@FindBy(xpath = "//div[@id='scene-description']")
	WebElement iDescriptionBox;
	
	@FindBy(xpath = "//div[@id='context_audio_button_button']")
	WebElement audioButton;
	
	@FindBy(xpath = "//div[@id='accessible_version_button']")
	WebElement complianceButton;
	
	@FindBy(xpath = "//a[contains(@alt,'Register')]")
	WebElement registerButton;
	
	@FindBy(xpath = "//a[@alt='Schedule Visit']")
	WebElement scheduleVisitButton;
	
	@FindBy(xpath = "//a[@alt='Apply Online']")
	WebElement applyOnlineButton;

	@FindBy(xpath = "//div[@data-test='NextButton']")
	WebElement nextButton;

	@FindBy(xpath = "//div[@id='language_button']")
	WebElement languageIcon;
	
 	@FindBy(xpath = "//label[text()='English']")
	WebElement englishLangMenu;

	@FindBy(xpath = "//label[text()='Spanish']")
	WebElement spanishLangMenu;

	@FindBy(xpath = "//div[@id='overflow_button_button']")
	WebElement moreButton;

	@FindBy(xpath = "(//div[@data-test='Tag'])[1]")
	WebElement moreVRButton;
	
	@FindBy(xpath = "(//div[@data-test='Tag'])[2]")
//	@FindBy(xpath = "//div[@title='Expand fullscreen']")
	WebElement moreFullScreenButton;

	@FindBy(xpath = "//a[text()='inline-embed - 360 Content with hotspots']")
	WebElement inlineEmbed360ContentWithHotspotLink;
	
	@FindBy(css= "iframe[id='virtualtour_iframe_0']")
 	WebElement inlineVTiFrame;
	
 	@FindBy(xpath = "//label[text()='Korean']")
	WebElement koreanLangMenu;

 	@FindBy(xpath = "//label[text()='Japanese']")
	WebElement japaneseLangMenu;

 	@FindBy(xpath = "//label[text()='Mandarin']")
	WebElement mandarinLangMenu;

 	@FindBy(xpath = "//div[@id='accessible_version_button']")
	WebElement accessibilityButton;

	@FindBy(xpath = "//a[@href='2.php']")
	WebElement inlineEmbedStonyBrookLink;
	
	@FindBy(xpath = "//div[@id='Expand_fullscreen_button']")
	WebElement fullScreenButton;
	
	@FindBy(xpath = "//div[@data-test='Icon' and contains(@style,'icon_info')]")
	WebElement infoInterIcon;
	
 	@FindBy(xpath = "//label[text()='Chinese']")
	WebElement chineseLangMenu;
	
 	@FindBy(xpath = "//a[text()='inline-embed - Flat Content with interactive elements']")
	WebElement inlineEmbedFlatContentWithInteractiveElement;
 	
 	@FindBy(xpath = "//a[text()='immersive-banner + hoverpanel']")
	WebElement immersiveBannerHoverPanelLink;
 	
 	@FindBy(xpath = "//img[@class='play']")
	WebElement playButton;
 	
	@FindBy(css= "iframe[id='virtualtour_iframe']")
 	WebElement immersiveBannerHoverPanelVTiFrame;

	@FindBy(xpath = "//a[text()='immersive-banner + newtab']")
	WebElement immersiveBannerNewTabLink;
	
	@FindBy(xpath = "//a[@href='iwc-use-cases-desktop.php']")
	WebElement iwcDesktopUseCaseLink;
	
	@FindBy(xpath = "(//*[@id='accessible_version_button'])[1]")
	WebElement iwcAccessibilityButton;
	
	@FindBy(css= "iframe[id='virtualtour_iframe_1']")
 	WebElement iwcVTiFrame1;
	
	@FindBy(css= "iframe[id='virtualtour_iframe_2']")
 	WebElement iwcVTiFrame2;
	
	@FindBy(xpath = " //div[contains(@class,'info_desktop')]")
	WebElement infoVTButtonIcon;
	
	@FindBy(xpath = "//div[@id='share_menu']//div[@data-test='Tag'][1]")
	WebElement vrVtButton;
	
	@FindBy(xpath = "//div[@id='close_button']")
	WebElement vrCloseButton;
	
/*	@FindBy(xpath = "//div[@id='close_button']")
	WebElement x;
*/
	public SuperContentPages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleUtils = new ElementUtil(driver);
	}
	
	public void refreshSuperContentVTPage() {
		refreshPage();
	}
	
	public void clickCloseRegistrationIcon() throws Exception {
		int count =0;
		while(!isPresentAndVisibleVersion2(closeRegistrationIcon) && count<4) {
			deleteAllCookies();
			webDriver.get(DriverInstance.prop.getProperty("env1")+DriverInstance.prop.getProperty("url_vt"));
			Thread.sleep(3000);
			count++;
		}
		click(closeRegistrationIcon);
		ExtentTestManager.getTest().pass("Clicked on the Close Resgistration \"x\" icon");
	} 
	
	public void clickFirstTourOnExperience() throws Exception {
		click(firstVirtualTourLink);
		ExtentTestManager.getTest().pass("Selected the first tour on the Select Experience Page");
	}
	
	public void setWindowDimension(int width, int hight) {
		Dimension dime = new Dimension(width,hight);
		setWindowDimension(dime);
		ExtentTestManager.getTest().pass("Screen dimension set as "+width+"x"+hight);
	}
	
	public boolean verifySupplementalMediaInlineView() throws Exception{
		isPresentAndVisible(supplementalMediaInlineViewButton);
		ExtentTestManager.getTest().pass("Supplimental Media Inline View button displayed");
		return verifyFieldDisplayed(supplementalMediaInlineViewButton);
	}
	
	public void verifySceneNameText() throws Exception {
		isPresentAndVisible(sceneNameText);
		verifyFieldDisplayed(sceneNameText);
		ExtentTestManager.getTest().pass("Scene Name displayed on the Supplemental Media");
	}
	
	public void verifyShareButton() throws Exception {
		verifyFieldDisplayed(shareButton);
		ExtentTestManager.getTest().pass("Share button displyed");
	}
	
	public void clickShareButton() throws Exception{
		isPresentAndVisible(shareButton);
		clickWithJavaScript(shareButton);
		ExtentTestManager.getTest().pass("Clicked on the Share button");
	}
	
	public void verifyShareViaEmailButton() throws Exception {
		verifyFieldDisplayed(shareViaEmailButton);
		ExtentTestManager.getTest().pass("Share Via Email button displayed on Share Menu");
	}
	
	public void verifyShareViaLinkButton() throws Exception {
		verifyFieldDisplayed(shareViaLinkButton);
		ExtentTestManager.getTest().pass("Share Via Link button displayed on Share Menu");
	}
	
	public void verifyShareViaTwitterButton() throws Exception {
		verifyFieldDisplayed(shareViaTwitterButton);
		ExtentTestManager.getTest().pass("Share Via Twitter button displayed on Share Menu");
	}
	
	public void verifyShareViaLinkedInButton() throws Exception {
		verifyFieldDisplayed(shareViaLinkedInButton);
		ExtentTestManager.getTest().pass("Share Via LinkeIn button displayed on Share Menu");
	}
	
	public void verifyShareViaFaceBookButton() throws Exception {
		verifyFieldDisplayed(shareViaFaceBookButton);
		ExtentTestManager.getTest().pass("Share Via Facebook button displayed on Share Menu");
	}
	
	public void verifyInfoButton() throws Exception {
		verifyFieldDisplayed(infoButton);
		ExtentTestManager.getTest().pass("Info button displayed on Share Menu");
	}
	
	public void clickInfoButton() throws Exception{
		clickWithJavaScript(infoButton);
		ExtentTestManager.getTest().pass("Clicked on the Info button");
	}
	
	public void clickHomeCanvasButton() throws Exception{
		verifyFieldDisplayed(homeCanvasButton);
		clickWithJavaScript(homeCanvasButton);
		ExtentTestManager.getTest().pass("Clicked on the Home Canvas button");
	}
	
	public void verifyIDescriptionBox() throws Exception {
		verifyFieldDisplayed(iDescriptionBox);
		ExtentTestManager.getTest().pass("i Description box displayed");
	}
	
	public void verifyAudioButton() throws Exception {
		waitAndFindElementByVisibility(audioButton);
		verifyFieldDisplayed(audioButton);
		ExtentTestManager.getTest().pass("Audio button displayed");
	}
	
	public void verifyComplienceButton() throws Exception {
		verifyFieldDisplayed(complianceButton);
		ExtentTestManager.getTest().pass("Complience Button displayed");
	}
	
	public void verifyRegisterButton() throws Exception {
		verifyFieldDisplayed(registerButton);
		ExtentTestManager.getTest().pass("Register Button displayed");
	}
	
	public void clickRegisterButton() throws Exception{
		click(registerButton);
		ExtentTestManager.getTest().pass("Clicked on the Register button");
	}
	
	public void verifyScheduleVisitButton() throws Exception {
		verifyFieldDisplayed(scheduleVisitButton);
		ExtentTestManager.getTest().pass("ScheduleVisit Button button displayed");
	}
	
	public void verifyApplyOnlineButton() throws Exception {
		verifyFieldDisplayed(applyOnlineButton);
		ExtentTestManager.getTest().pass("ApplyOnline Button button displayed");
	}
	
	public void verifyNextButton() throws Exception {
		verifyFieldDisplayed(nextButton);
		ExtentTestManager.getTest().pass("Next Button button displayed");
	}
	
	public void verifyNextSceneTitleButton() throws Exception {
		verifyFieldDisplayed(nextButton);
		ExtentTestManager.getTest().pass("NextScene Button button displayed");
	}
	
	public void verifyLanguageButton() throws Exception {
		verifyFieldDisplayed(languageIcon);
		ExtentTestManager.getTest().pass("Language Button button displayed on Language Menu");
	}
	
	public void clickLanguageButton() throws Exception{
		clickWithJavaScript(languageIcon);
		ExtentTestManager.getTest().pass("Clicked on the Language button");
	}
	
	public void verifyEnglishLanguageButton() throws Exception{
		verifyFieldDisplayed(englishLangMenu);
		ExtentTestManager.getTest().pass("English Language Button button displayed on Language Menu");
	}
	
	public void verifySpanishLanguageButton() throws Exception{
		verifyFieldDisplayed(spanishLangMenu);
		ExtentTestManager.getTest().pass("Spanish Language Button button displayed on Language Menu");
	}
	
	public void verifyMoreButton() throws Exception {
		waitAndFindElementByVisibility(moreButton);
		verifyFieldDisplayed(moreButton);
		ExtentTestManager.getTest().pass("More Button button displayed ");
	}
	
	public void clickMoreButton() throws Exception {
		clickWithJavaScript(moreButton);
		ExtentTestManager.getTest().pass("Clicked on the More button");
	}
	
	public void verifyMoreVRMenuButton() throws Exception {
		verifyFieldDisplayed(moreVRButton);
		ExtentTestManager.getTest().pass("More VR menu button displayed ");
	}
	
	public void verifyMoreFullScreenButton() throws Exception {
		verifyFieldDisplayed(moreFullScreenButton);
		ExtentTestManager.getTest().pass("More Full Screen Menu button displayed ");
	}
	
	public void clickMoreFullScreenButton() throws Exception {
		clickWithJavaScript(moreFullScreenButton);
		ExtentTestManager.getTest().pass("Click on Exit Full Screen button");
	}
	
	public void verifyInline360ContentWithHotspotLink() throws Exception {
		verifyFieldDisplayed(inlineEmbed360ContentWithHotspotLink);
		ExtentTestManager.getTest().pass("Inline 360 Content with Hotspot Link displayed on Home Page");
	}
	
	public void clickInline360ContentWithHotspotLink() throws Exception{
		click(inlineEmbed360ContentWithHotspotLink);
		ExtentTestManager.getTest().pass("Clicked on the Inline 360 Content with Hotspot Link on Home page");
	}
	
	public void switchToInlineVTiFrame() {
		switchToFrame(inlineVTiFrame);
	}
	
	public void verifyFullScreenButton() throws Exception {
		verifyFieldDisplayed(fullScreenButton);
		ExtentTestManager.getTest().pass("Full Screen Expand button displayed ");
	}
	
	public void verifyInfoInterIcon() throws Exception {
		verifyFieldDisplayed(infoInterIcon);
		ExtentTestManager.getTest().pass("Info icon is displayed");
	}
	
	public void clickInfoInterIcon() throws Exception {
		infoInterIcon.click(); // This is the special case to perform click here
		ExtentTestManager.getTest().pass("Clicked on the Info icon");
	}
	
	public void verifyKoreanLanguageButton() throws Exception{
		verifyFieldDisplayed(koreanLangMenu);
		ExtentTestManager.getTest().pass("Korean Language Button button displayed on Language Menu");
	}
	
	public void verifyJapaneseLanguageButton() throws Exception{
		verifyFieldDisplayed(japaneseLangMenu);
		ExtentTestManager.getTest().pass("Japanese Language Button button displayed on Language Menu");
	}
	
	public void verifyMandarinLanguageButton() throws Exception{
		verifyFieldDisplayed(mandarinLangMenu);
		ExtentTestManager.getTest().pass("Mandarin Language Button button displayed on Language Menu");
	}
	
	public String getCurrentWindow() {
		return eleUtils.doGetCurrentWindow();
	}
	
	public void clickAccessibilityButton(String browserName)throws Exception{
		verifyFieldDisplayed(accessibilityButton);
		click(accessibilityButton);
		ExtentTestManager.getTest().pass("Clicked on the Accesssibility Button");
		if(browserName.equals("firefox")) {
			Thread.sleep(4000);
			refreshPage();
		}
			

		
	}
	
	public void switchToWindow(String windowHandle) {
		switchWindow(windowHandle);
	}
	
	public void clickInlineEmbedStonyBrookLink() throws Exception{
		verifyFieldDisplayed(inlineEmbedStonyBrookLink);
		click(inlineEmbedStonyBrookLink);
		ExtentTestManager.getTest().pass("Clicked on the Inline Embed Stony Brook Link on the home page");
	}
	
	public void switchToMainWindow() {
		switchToDefaultContent();
	}
	
	public void verifyChineseLanguageButton() throws Exception{
		verifyFieldDisplayed(chineseLangMenu);
		ExtentTestManager.getTest().pass("Chinese Language Button button displayed on Language Menu");
	}
	
	public void verifyPageNavigatedToStonyBrookAccessibility() {
		Boolean flag=false;
		for (String handle : eleUtils.doGetWindowHandles()) {
			switchWindow(handle);
			System.out.println(String.format("handle: %s, url: %s", handle, driver.getCurrentUrl()));
			if(driver.getCurrentUrl().contains("/ada/stonybrook/"))
				flag=true;
		} 
		if(flag)
			ExtentTestManager.getTest().pass("Navigated to [/ada/stonybrook/] after clicking on accesbility button");
		else
			ExtentTestManager.getTest().fail("Didn't Navigate to [/ada/stonybrook/] after clicking on accesbility button");
		Assert.assertTrue(flag, "Didn't Navigate to [/ada/stonybrook/] after clicking on accesbility button");
	}
	public void goToMainTabCloseOtherTabs(String browser) {
		closeAllTabsAndSwitchToMainTab(browser);
	}
	public void verifyInlineEmbedFlatContentWithInteractiveElementLink() throws Exception {
		verifyFieldDisplayed(inlineEmbedFlatContentWithInteractiveElement);
		ExtentTestManager.getTest().pass("Inline Embed Flat Content With Interactive Element Link displayed on Home Page");
	}
	
	public void clickInlineEmbedFlatContentWithInteractiveElementLink() throws Exception{
		verifyFieldDisplayed(inlineEmbedFlatContentWithInteractiveElement);
		click(inlineEmbedFlatContentWithInteractiveElement);
		ExtentTestManager.getTest().pass("Clicked on the Inline Embed Flat Content With Interactive Element Link on the home page");
	}
	
	public void verifyPageNavigatedToPatrickBoydlAccessibility() {
		Boolean flag=false;
		for (String handle : eleUtils.doGetWindowHandles()) {
			switchWindow(handle);
			System.out.println(String.format("handle: %s, url: %s", handle, driver.getCurrentUrl()));
			if(driver.getCurrentUrl().contains("/ada/patrick.boyd1/"))
				flag=true;
		} 
		if(flag)
			ExtentTestManager.getTest().pass("Navigated to [/ada/stonybrook//ada/patrick.boyd1/] after clicking on accesbility button");
		else
			ExtentTestManager.getTest().fail("Didn't Navigate to [/ada/patrick.boyd1/] after clicking on accesbility button");
		Assert.assertTrue(flag, "Didn't Navigate to [/ada/patrick.boyd1/] after clicking on accesbility button");
	}
	
	public void clickImmersiveBannerHoverPanelLink() throws Exception {
		maximizeWebPage();
		verifyFieldDisplayed(immersiveBannerHoverPanelLink);
		click(immersiveBannerHoverPanelLink);
		ExtentTestManager.getTest().pass("Clicked on the Immersive Banner Hover Panel Link on the home page");
	}
	
	public void clickPlayButton() throws Exception{
		verifyFieldDisplayed(playButton);
		click(playButton);
		ExtentTestManager.getTest().pass("Clicked on the Play Button");
	}
	
	public void verifyAndSwitchToImmersiveBannerHoverPanelVTiFrame() {
		waitAndFindElementByVisibility(immersiveBannerHoverPanelVTiFrame);
		switchToFrame(immersiveBannerHoverPanelVTiFrame);
	}
	
	public void verifyAccessibilityButton() throws Exception {
		verifyFieldDisplayed(accessibilityButton);
		ExtentTestManager.getTest().pass("Accessibility button is displayed");
	}
	
	public void verifyImmersiveBannerHoverPanelNewTabOpened(WebElement immersiveBanneriFrame) throws Exception {
		int previousSize = eleUtils.doGetWindowHandles().size();
		String firstHandle = eleUtils.doGetCurrentWindow();
		System.out.println("previous size is " +previousSize);
		switchToFrame(inlineVTiFrame);
		click(playButton);

		boolean tabsFlag = eleUtils.waitForNewWindowTabs(previousSize+2);
		if(tabsFlag)
			ExtentTestManager.getTest().pass("Immersive Banner Hover Panel is opened in new Tab as expected");
		else
			ExtentTestManager.getTest().fail("Immersive Banner Hover Panel is not opened in new Tab");
	
		switchWindow(firstHandle);
	}
	
	public void clickImmersiveBannerHoverPanelNewTabLink() throws Exception {
		verifyFieldDisplayed(immersiveBannerNewTabLink);
		click(immersiveBannerNewTabLink);
		ExtentTestManager.getTest().pass("Clicked on the Immersive Banner Hover Panel New Tab Link");
	}
	
	public void clickIwcDesktopUseCaseLink() throws Exception{
		maximizeWebPage();
		verifyFieldDisplayed(iwcDesktopUseCaseLink);
		click(iwcDesktopUseCaseLink);
		ExtentTestManager.getTest().pass("Clicked on the IWC Desktop UseCase Link on the home page");
	}
	
	public void navigateToPreviousPage(String browserName) {
		navigateBackToPreviousPage();
		if(browserName.equals("firefox"))
			refreshPage();
	}
	
	public void verifyIwcAccessibilityButton() throws Exception{
		waitAndFindElementByVisibility(iwcAccessibilityButton);
		verifyFieldDisplayed(iwcAccessibilityButton);
		ExtentTestManager.getTest().pass("Accessibility button is displayed on IWC");
	}
	
	public void switchToIwciFrame1() {
		scrollToElement(iwcVTiFrame1);
		switchToFrame(iwcVTiFrame1);
	}
	
	public void switchToIwciFrame2() {
		scrollToElement(iwcVTiFrame2);
		switchToFrame(iwcVTiFrame2);
	}
	
	public void verifyInfoVTButton() throws Exception{
		verifyFieldDisplayed(infoVTButtonIcon);
		ExtentTestManager.getTest().pass("Info Virtual Tour button is displayed");
	}
	
	public void verifyVrVtButton() throws Exception{
		verifyFieldDisplayed(vrVtButton);
		ExtentTestManager.getTest().pass("VR Virtual Tour button is displayed");
	}
	
	public void clickVrVtButton() throws Exception{
		clickWithJavaScript(vrVtButton);
		ExtentTestManager.getTest().pass("Clicked on the VR Virtual tour Button");
	}
	
	public void verifyVrCloseButton() throws Exception{
		verifyFieldDisplayed(vrCloseButton);
		ExtentTestManager.getTest().pass("VR Virtual Tour button is displayed");
	}
	
	public void clickVrCloseButton() throws Exception{
		clickWithJavaScript(vrCloseButton);
		ExtentTestManager.getTest().pass("Clicked on the VR Close Button");
	}
}
