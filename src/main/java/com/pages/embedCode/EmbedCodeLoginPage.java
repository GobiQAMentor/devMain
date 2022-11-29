package com.pages.embedCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class EmbedCodeLoginPage extends ObjectsControl implements PageInterface{
	WebDriver driver;


	@FindBy(xpath = "//h1[contains(text(),'Smart Script Test Cases')]")
	WebElement smartScriptHeader;

	@FindBy(xpath = "//a[contains(text(),'1 - mix-vte-anchor pt 1')]")
	WebElement mixvteAnchor1;

	@FindBy(xpath = "//h1[contains(text(),'Hover Panel')]/following-sibling::div[1]/iframe[1]")
	WebElement hoverLegacyImageButton;

	@FindBy(id = "virtualtour_iframe_2")
	WebElement virtualFrame2;

	@FindBy(xpath = "//a[contains(text(),'2 - mix-vte-anchor pt 2')]")
	WebElement mixVteAnchor2;

	@FindBy(xpath = "//a[contains(text(),'3 - mix-vte-anchor pt 3')]")
	WebElement mixvteanchor3;

	@FindBy(xpath = "(//a[@alt='Launch Experience'])[1]")
	WebElement hoverCustomTextLaunchButton;

	@FindBy(xpath = "//h1[contains(.,'inline-embed')]")
	WebElement inlineEmbedHeader;

	@FindBy(xpath = "//div[@alt='open accessible version']")
	WebElement viewAccesibleVersionButtonEmbed;

	@FindBy(xpath = "//div[@class='info_desktop_svg undefined puresvg']")
	WebElement infoDesktopButtonEmbed;

	@FindBy(xpath = "//div[@id='context_audio_button_button']")
	WebElement contextAudioButtonEmbed;

	@FindBy(xpath = "//div[@id='overflow_button_button']")
	WebElement overflowButtonEmbed;

	@FindBy(xpath = "(//div[contains(.,'START VIRTUAL EXPERIENCE')])[3]")
	WebElement startVitualExperienceEmbed;

	@FindBy(xpath = "(//a[contains(.,'Launch Experience')])[2]")
	WebElement newTabCustomTextLaunchButton;

	@FindBy(xpath = "//div[@aria-label='close conversational inquiry form']/img")
	WebElement closeRegistrationButton2embed;	

	@FindBy(xpath = "(//a[contains(text(),'Stop / stop only')])[1]")
	WebElement stopStopOnly;

	@FindBy(xpath = "//h1[contains(.,'STOP ONLY DEWALD CHAPEL -- hover --immersive')]")
	WebElement stopOnlyDewaldChapelHeader;

	@FindBy(xpath = "//div[@class='round_btn']")
	WebElement thirdPartyRoundButtonEmbed;

	@FindBy(xpath = "//div[contains(@class,'closeButton')]/img")
	WebElement closeButton;

	@FindBy(xpath = "//a[contains(text(),'7 - 3rd party links that need validation pt1')]")
	WebElement thirdPartyLinks1;

	@FindBy(xpath = "//a[contains(text(),'8 - 3rd party links that need validation pt2')]")
	WebElement thirdPartyLinks2;

	@FindBy(xpath = "//h1[contains(.,'Must Not Render / Validate')]")
	WebElement mustNoTrenderorValidateHeader;

	@FindBy(xpath = "//a[contains(text(),'Default link generation')]")
	WebElement defaultLinkGeneration;

	@FindBy(xpath = "//h1[contains(.,'DEFAULT IMMERSIVE BANNER :  http://youvisit.com/#/vte/b')]")
	WebElement defaulTimmersiveBanner;

	@FindBy(xpath = "//h1[.='wrong link should just be an anchor that can launch : http://youvisit.com/#/vte/nope']")
	WebElement wrongLinkAnchorEmbed;    

	@FindBy(xpath = "//a[.='virtual tour']")
	WebElement virtualTourLinkEmbed;  

	@FindBy(xpath = "//div[@class='round_btn']")
	WebElement embedPage;

	@FindBy(id = "virtualtour_iframe_1")
	WebElement virtualTouriframe1;

	@FindBy(id = "virtualtour_iframe_0")
	WebElement virtualTouriframe0;

	@FindBy(id = "virtualtour_iframe")
	WebElement virtualTouriframe;

	@FindBy(xpath = "//a[contains(text(),'legacy embed class')]")
	WebElement LegacyEmbedClassLink;

	@FindBy(xpath = "//div[@class='round_btn']")
	WebElement thirdpartyRoundButton;

	@FindBy(xpath = "//a[contains(text(),'Immediate Launch')]")
	WebElement Immediate_Launch_xpath;

	@FindBy(xpath = "//div[contains(@id,'close_button')]")
	WebElement closeSelectExperienceButton;

	@FindBy(xpath = "//div[@class='close_svg undefined puresvg']")
	WebElement closeTheSelectExperienceButton;
	
	By closeRegBtnBy = By.xpath("//div[@aria-label='close conversational inquiry form']/img");

	public EmbedCodeLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToEmbedLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		while(!verifyFieldDisplayed(smartScriptHeader)) {
			deleteAllCookies();
			driver.get(url);
		}
	}
	
	public void clickMixVteAnchor1Button() throws Exception {
		waitAndFindElementByVisibility(mixvteAnchor1);
		click(mixvteAnchor1);
	}
	
	public void verifyAndClickHoverLagacyImageButtonDisplayed() throws Exception {
		isPresentAndVisible(hoverLegacyImageButton);
		click(hoverLegacyImageButton);
	}
	
	public void navigateSmartScriptUrl2(String url)
	{
		navigateTo(url);

	}
	
	public void navigateSmartScriptUrl3(String url)
	{
		navigateTo(url);

	}
	
	public void clickVirtualFrameButton() throws Exception {
		waitAndFindElementByVisibility(virtualFrame2);
		click(virtualFrame2);
		Thread.sleep(2000);
	}
	
	public void closeOtherTabAndSwitchToMain(String browser) {
		closeAllTabsAndSwitchToMainTab(browser);
	}
	
	public void switchToTheNewTab() {
		switchToNewTab();
	}

	public void clickMixVteAnchor2Button() throws Exception {
		waitAndFindElementByVisibility(mixVteAnchor2);
		click(mixVteAnchor2);
	}
	
	public void clickMixVteAnchor3Button() throws Exception {
		waitAndFindElementByVisibility(mixvteanchor3);
		click(mixvteanchor3);
	}
	
	public void verifyAndClickHoverCustomTextLaunchButton() throws Exception {
		Thread.sleep(4000);
		isPresentAndVisible(hoverCustomTextLaunchButton);
		click(hoverCustomTextLaunchButton);
	}
	
	public void verifyInlineEmbedHeader() throws Exception {
		isPresentAndVisible(inlineEmbedHeader);
	}

	public void verifyViewAccesibleVersionButtonEmbed() throws Exception {
		isPresentAndVisible(viewAccesibleVersionButtonEmbed);
	}
	
	public void verifyInfoDesktopButtonEmbed() throws Exception {
		isPresentAndVisible(infoDesktopButtonEmbed);
	}
	
	public void verifyContextAudioButtonEmbed() throws Exception {
		isPresentAndVisible(contextAudioButtonEmbed);
	}
	
	public void verifyOverflowButtonEmbed() throws Exception {
		isPresentAndVisible(overflowButtonEmbed);
	}
	
	public void clickStartVitualExperienceEmbed() throws Exception {
		waitAndFindElementByVisibility(startVitualExperienceEmbed);
		click(startVitualExperienceEmbed);
	}
	
	public void clickNewTabCustomTextLaunchButton() throws Exception {
		waits(1);
		waitAndFindElementByVisibility(newTabCustomTextLaunchButton);
		click(newTabCustomTextLaunchButton);
	}
	
	public void clickCloseRegistrationButton2() throws Exception {
		int count =0;
		while(!isPresentAndVisibleVersion2(closeRegistrationButton2embed) && count<1) {
			deleteAllCookies();
			refreshPage();
			count++;
			Thread.sleep(8000);
		}
		Thread.sleep(8000);
		waitForAndFindElementByLocator(closeRegBtnBy).click();	
//		waitAndFindElementByVisibility(closeRegistrationButton2embed);
//		click(closeRegistrationButton2embed);
	}

	public void clickStopStopOnlyLink() throws Exception {
		waitAndFindElementByVisibility(stopStopOnly);
		click(stopStopOnly);
	}
	
	public void verifyStopOnlyDewaldChapelHeader() throws Exception {
		isPresentAndVisible(stopOnlyDewaldChapelHeader);
	}
	
	public void clickThirdpartyRoundButtonEmbed() throws Exception {
		click(thirdPartyRoundButtonEmbed);
	}

	public void switchToTheVirtualtourFrame1() throws Exception {
		switchToFrame(virtualTouriframe1);
	}

	/*public void switchToTheVirtualtourFrame1() throws Exception {
		driver.switchTo().frame("virtualtouriframe1");
	}

	public void switchToTheVirtualtourFrame1() throws Exception {
		switchToTheFrame(virtualTouriframe);
	}*/

	public void switchToTheVirtualtourFrame() throws Exception {
		switchToFrame(virtualTouriframe);
		waits(1);
	}
	
	public void clickCloseButton() throws Exception {
		click(closeButton);
	}
	
	public void switchToTheVirtualtourFrame0() throws Exception {
		while(!isPresentAndVisibleVersion2(virtualTouriframe0)) {
			refreshPage();		
		}
		switchToFrame(virtualTouriframe0);
	}
	
	public void clickThirdPartyLinks1() throws Exception {
		click(thirdPartyLinks1);
	}
	
	public void navigateSmartScriptThirdPartyUrl(String url)
	{
		navigateTo(url);
	}
	
	public void clickThirdPartyLinks2() throws Exception {
		clickWithJavaScript(thirdPartyLinks2);
	}
	
	public void verifyMustNotrenderHeader() throws Exception {
		click(mustNoTrenderorValidateHeader);
	}
	
	public void clickDefaultLinkGenerationLink() throws Exception {
		click(defaultLinkGeneration);
	}
	
	public void verifyDefaultImmersiveBanner() throws Exception {
		click(defaulTimmersiveBanner);
	}
	
	public void navigateSmartScriptNoParamsUrl(String url)
	{
		navigateTo(url);
	}
	
	public void verifyWrongLinkAnchorEmbed() throws Exception {
		clickWithJavaScript(wrongLinkAnchorEmbed);
	}
	
	public void clickVirtualTourLinkEmbed() throws Exception {
		click(virtualTourLinkEmbed);
	}
	
	public void clickEmbedPage() throws Exception {
		waitAndFindElementByVisibility(embedPage);
		click(embedPage);
	}

	public void switchToTheDefaultContent() throws Exception {
		switchToDefaultContent();
	}
	
	public void clickLegacyEmbedClassLink() throws Exception {
		waitAndFindElementByVisibility(LegacyEmbedClassLink);
		click(LegacyEmbedClassLink);
	}
	
	public void clickThirdpartyRoundButton() throws Exception {
		waitAndFindElementByVisibility(thirdpartyRoundButton);
		click(thirdpartyRoundButton);
	}
	
	public void navigatesmartScriptLatestIndexUrl(String url)
	{
		navigateTo(url);
	}
	
	public void clickImmediateLaunchLink() throws Exception {
		waitAndFindElementByVisibility(Immediate_Launch_xpath);
		click(Immediate_Launch_xpath);
	}
	
	public void clickCloseSelectExperienceButton() throws Exception {
		waitAndFindElementByVisibility(closeTheSelectExperienceButton);
		click(closeTheSelectExperienceButton);
	}
	
	public void navigateToPreviousPage() {
			navigateBackToPreviousPage();
	}
	
	public void resetEmbedsTrue() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("YVSmartScript.embed.resetEmbeds(true)");
	}
	
	public void resetEmbedsByIndex0() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("YVSmartScript.embed.reset_embed_by_index(0)");
	}
	
	public void resetEmbedsByIndex1() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("YVSmartScript.embed.reset_embed_by_index(1)");
	}
	
	public void resetEmbedsFalse() throws Exception {
		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("YVSmartScript.embed.resetEmbeds(false)");
		executor.executeScript("YVSmartScript.embed.scanEmbeds()");
	}
}