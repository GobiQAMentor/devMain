package com.pages.iwcFormerSuperContent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class IwcFormerSuperContentPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'inline-embed - Stonybrook w/ CIF')]")
	WebElement inlineEmbedStonybrookCifLink;
	@FindBy(xpath = "//div[contains(@class,'expand')]")
	WebElement expandFullScreenIcon;
	@FindBy(xpath = "//a[@alt='Schedule Visit']")
	WebElement scheduleVisitButton;
	@FindBy(xpath = "//a[contains(@alt,'Register')]")
	WebElement registerButton;
	@FindBy(xpath = "//div[@id='overflow_button_button']")
	WebElement moreButton;
	@FindBy(xpath = "//div[@id='Collapse_fullscreen_button']")
	WebElement collapseFullScreenButton;
	@FindBy(xpath = "//a[@alt='Apply Online']")
	WebElement applyOnlineButton;
	@FindBy(xpath = "//div[@id='language_button']")
	WebElement languageButton;
	@FindBy(xpath = "//label[text()='English']")
	WebElement englishLanguage;
	@FindBy(xpath = "//label[text()='Spanish']")
	WebElement spanishLanguage;
	@FindBy(xpath = "//label[text()='Chinese']")
	WebElement chineseLanguage;

	By moreButtonBy = By.xpath("//div[@id='overflow_button_button']");
	By langButtonBy = By.xpath("//div[@id='language_button']");
	By expandButtonBy = By.xpath("//div[contains(@class,'expand')]");
	By collapseButtonBy = By.xpath("//div[@id='Collapse_fullscreen_button']");
	
	public IwcFormerSuperContentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToIwcFormerSuperContentLogin(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		deleteAllCookies();
		driver.get(url);
	}
	public void clickInlineEmbedStonybrookCifLink() throws Exception {
		isPresentAndVisible(inlineEmbedStonybrookCifLink);
		click(inlineEmbedStonybrookCifLink);
		ExtentTestManager.getTest().pass("Click on inline_embed_stonybrook_cif_link");
	}
	public void clickExpandFullScreenIcon() throws Exception {
		isPresentAndVisible(expandFullScreenIcon);
		//clickWithJavaScript(expandFullScreenIcon);
		waitForAndFindElementByLocator(expandButtonBy).click();
	}
	public void verifyScheduleVisitButton() throws Exception {
		isPresentAndVisible(scheduleVisitButton);
	}
	public void verifyRegisterNowButton() throws Exception {
		isPresentAndVisible(registerButton);		
	}
	public void verifyApplyOnlineButton() throws Exception {
		isPresentAndVisible(applyOnlineButton);		
	}
	public void clickMoreButton() throws Exception {
		isPresentAndVisible(moreButton);
		waitForAndFindElementByLocator(moreButtonBy).click();
	}
	public void clickCollapseFullScreenButton() throws Exception {
		Thread.sleep(5000);
		clickWithJavaScript(collapseFullScreenButton);
		ExtentTestManager.getTest().pass("Full Screen collapsed");
		Thread.sleep(2000);
		//sendModifierKeys(Keys.F11);
	}
	public void clickLanguageButton() throws Exception {
		isPresentAndVisible(languageButton);
		waitForAndFindElementByLocator(langButtonBy).click();
	}
	public void verifyEnglishLanguageField() throws Exception {
		isPresentAndVisible(englishLanguage);		
	}
	public void verifySpanishLanguageField() throws Exception {
		isPresentAndVisible(spanishLanguage);		
	}
	public void verifyChineseLanguageField() throws Exception {
		isPresentAndVisible(chineseLanguage);		
	}
	public void pageRefresh() throws Exception {
		refreshPage();
	}
	public void clickScheduleVisitButton() throws Exception {
		click(scheduleVisitButton);
	}
	public void clickApplyOnlineButton() throws Exception {
		click(applyOnlineButton);
	}
	
}
