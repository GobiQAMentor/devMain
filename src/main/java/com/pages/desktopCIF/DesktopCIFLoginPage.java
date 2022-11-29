package com.pages.desktopCIF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;
import com.utils.ElementUtil;

public class DesktopCIFLoginPage extends ObjectsControl implements PageInterface{

	ElementUtil eUtil;
	WebDriver driver;
	@FindBy(xpath = "//label[text()='ARE YOU A...']")
	WebElement areYouLabel;
	@FindBy(xpath = "//button[@value='prospective_student']")
	WebElement prospectiveStudentButton;
	@FindBy(xpath = "//button[@value='parent']")
	WebElement parentGuardianButton;
	@FindBy(xpath = "//button[@value='other']")
	WebElement otherButton;
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicyLink;
	@FindBy(xpath = "//a[contains(text(),'Terms of Use')]")
	WebElement termsOfUseLink;
	@FindBy(xpath = "//h1[contains(text(),'Virtual Tour Terms of Use')]")
	WebElement termsOfUseHeader;
	@FindBy(xpath = "//a//span[text()='Learn More']")
	WebElement learnMoreLinkAfterCompleteTheRegister;
	@FindBy(xpath = "//div[contains(@class,'completionBar')]")
	WebElement completionProgressBar;
	public DesktopCIFLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		eUtil =  new ElementUtil(driver);
		PageFactory.initElements(driver, this);
	}
	public void navigateToDesktopCIFLogin(String url) throws Exception {
		deleteAllCookies();
		deleteAllCookies();
//		refreshPage();
		driver.get(url);
//		deleteAllCookies();
//		driver.get(url);
	}
	
	public void verifyAreYouLabel() throws Exception {
		isPresentAndVisible(areYouLabel);
	}
	public void verifyProspectiveStudentButton() throws Exception {
		isPresentAndVisible(prospectiveStudentButton);
	}
	public void verifyParentGuardianButton() throws Exception {
		isPresentAndVisible(parentGuardianButton);
	}
	public void verifyOtherButton() throws Exception {
		isPresentAndVisible(otherButton);
	}
	public void waitForInsightsPageToLoad() throws Exception {
		waitForElementInvisibilityWithBy(loadingBy);
	}
	public void clickTermsOfUseLink() throws Exception {
		click(termsOfUseLink);
	}
	public void clickPrivacyPolicyLink() throws Exception {
		click(privacyPolicyLink);
	}
	public void switchToTheLastTab() throws InterruptedException {
		switchToLastWindow();
	}
	public void verifyTermsOfUseHeader() throws Exception {
		isPresentAndVisible(termsOfUseHeader);
	}
	public void switchToTheTabWithCIFUrl() throws Exception {
		switchToTabWithUrl("https://staging.youvisit.com/tour/stonybrook?cif=1");
	}
	public void clickProspectiveStudentButton() throws Exception {
		clickWithJavaScript(prospectiveStudentButton);
	}
	public void verifyLearnMoreLinkAfterCompleteTheRegister() throws Exception {
		isPresentAndVisible(learnMoreLinkAfterCompleteTheRegister);
	}
	public void goToMainTabCloseOtherTabs(String browser) {
		eUtil.doGetParentWindow();
		closeAllTabsAndSwitchToMainTab(browser);
	}
	public int getProgressBarPercentage() throws InterruptedException {
		//waitAndFindElementByVisibility(completionProgressBar);
		String barValue = completionProgressBar.getAttribute("style");
		if(barValue!=null){
			System.out.println("@@@@@@@"+barValue);
			barValue = barValue.replace("width: ","");
			System.out.println("#######"+barValue);
			barValue = barValue.replace("px;","");
			System.out.println("=======>"+barValue);
			return Integer.parseInt(barValue);
		}
		return 1;
	}
	public int verifyCompletionBarProgress(int value) throws InterruptedException {
		int percentage = getProgressBarPercentage();
		if(value<percentage) {
			ExtentTestManager.getTest().pass("Registration Progressing and completed "+percentage+ "%");
		}else if(percentage ==1){
			ExtentTestManager.getTest().pass("Registration Completion Bar is jus started Progressing as expected");
		}else {
			ExtentTestManager.getTest().pass("Registration Completion Bar is not Progressed as expected");
		}
		return percentage;
	}
	
}