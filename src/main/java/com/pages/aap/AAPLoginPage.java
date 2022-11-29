package com.pages.aap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class AAPLoginPage extends ObjectsControl implements PageInterface {
	
	WebDriver driver;
	
	String loginPageTitle = "YouVisit - Login";
	
	@FindBy(xpath = "(//span[.='Experience Insights'])[1]")
	WebElement experienceInsightsBtn;
	
 	@FindBy(xpath = "//span[text()='Content Management']")
 	WebElement cmsManagementBtn;
	
	@FindBy(id = "email")
	WebElement userNameTxtBx;
	
	@FindBy(id = "password")
	WebElement passwordTxtBx;
	
	@FindBy(id = "submit")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[text()='Login with EAB SSO']")
 	WebElement eabSsoLoginBtn;
	
	@FindBy(xpath = "//div[text()='Sign in with Microsoft']")
 	WebElement microsoftSignInBtn;
	
	@FindBy(xpath = "//input[@name='loginfmt']")
 	WebElement msLoginTxtBx;
	
	@FindBy(xpath = "//input[@name='passwd']")
 	WebElement msPasswordBx;
 	
	@FindBy(xpath = "//div[text()='Sign in with Google']")
 	WebElement googleSignInBtn;

	@FindBy(xpath = "//span[text()='EAB Single Sign On']")
	WebElement eabSsoPageHeader;
	
	@FindBy(xpath = "//input[@value='Next']")
	WebElement msLoginNextBtn;
	
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement msLoginSignInBtn;
	
	@FindBy(xpath = "//input[@value='Yes']")
	WebElement msLoginYesBtn;
	
	@FindBy(xpath = "//input[@id='identifierId']")
 	WebElement googleUserNameTxtBx;
	
	@FindBy(name = "password")
 	WebElement googlePasswordBx;
	
	@FindBy(id = "identifierNext")
	WebElement googleUserNameNextBtn;
	
	@FindBy(id = "passwordNext")
	WebElement googlePasswordNextBtn;
	
 	String pageTitle = "YouVisit - Login";
	
 	

/*
 	@FindBy(xpath = xxx )
 	WebElement yyyy ;
 	
 */
	public AAPLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToAAPLogin(String url) {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
		while(!verifyPageTitle(pageTitle)) {
			deleteAllCookies();
			driver.get(url);
//			if(verifyPageTitle(pageTitle))
//				break;
		}
	}
	
	/**
	 * 
	 * @param url - prop.getProperty("cloud_env")+prop.getProperty("url_aap");
	 * @param userName
	 * @param password
	 * @throws Exception
	 */
	public void loginExperienceInsight(String userName, String password) throws Exception {
		if(verifyPageTitle(pageTitle)) {
			clickExperienceInsightBtn();
			enterUserName(userName);
			enterPassword(password);
			clickLoginButton();
		}
	}
	
	public boolean verifyLoginTitle(String title) {
		return verifyPageTitle(title);
	}
	
	public void clickExperienceInsightBtn() throws Exception {
		waitAndFindElementByVisibility(experienceInsightsBtn);
		click(experienceInsightsBtn);
	}
	
	/**
	 * 
	 * @param userName - prop.getproperty("aap_username")
	 */
	public void enterUserName(String userName) {
		clearTypeKeys(userNameTxtBx, userName);	
	}
	
	public void enterPassword(String password) {
		clearTypeKeys(passwordTxtBx, password);
		//prop.getproperty("aap_password")
	}

	public void clickLoginButton() throws Exception {
		click(loginBtn);
	}	
	
	public void verifyEabSsoLoginBtn() {
		isPresentAndVisible(eabSsoLoginBtn);
		ExtentTestManager.getTest().pass("Login with EAB SSO button displayed in Login page");
	}
//===	
	public void loginWithEabSSO() throws Exception {
		verifyEabSsoLoginBtn();
		clickEabSsoLoginBtn();
		verifySssoPage();
	}
	
	public void verifyMicrosoftSignInBtn() {
		isPresentAndVisible(microsoftSignInBtn);
		ExtentTestManager.getTest().pass("Sign in with Microsoft button displayed in Login page");
	}
	
	public void signInWithMicrosoftAccount() throws Exception {
		verifyMicrosoftSignInBtn();
		clickMicrosoftSignInBtn();
		submitMicrosoftCredentials();
	}
	
	public void verifyGoogleSignInBtn() {
		isPresentAndVisible(googleSignInBtn);
		//ExtentTestManager.getTest().pass("Sign in with Google button displayed in Login page");
	}
	
	public void signInWithGoogleAccount() throws Exception {
		verifyGoogleSignInBtn();
		clickGoogleSignInnBtn();
		submitGoogleCredentials();		
	}

//===//
	public void clickEabSsoLoginBtn() throws Exception {
		clickWithJavaScript(eabSsoLoginBtn);
		ExtentTestManager.getTest().pass("Login with EAB SSO button is displayed and Clicked on it");
		
	}
	
	public void clickMicrosoftSignInBtn() throws Exception {
		clickWithJavaScript(microsoftSignInBtn);
		ExtentTestManager.getTest().pass("Sign in with Microsoft button is displayed and Clicked on it");
	}
	
	public void clickGoogleSignInnBtn() throws Exception {
		clickWithJavaScript(googleSignInBtn);
		ExtentTestManager.getTest().pass("Sign in with Google button is displayed and Clicked on it");
	}
	
	public void verifySssoPage() {
		isPresentAndVisible(eabSsoPageHeader);
		ExtentTestManager.getTest().pass("Logged in to application and navigated to EAB Single Sign On page ");
	}
//==	
	public void submitMicrosoftCredentials() throws Exception {
		waitForElementInvisibility(msLoginTxtBx);
		clearTypeKeys(msLoginTxtBx, "itestbox@hotmail.com");
		clickWithJavaScript(msLoginNextBtn);
		ExtentTestManager.getTest().pass("Entered the Micosoft Account usename and clicked Next button");
		waitForElementInvisibility(msPasswordBx);
		clearTypeKeys(msPasswordBx, "test@930");
		clickWithJavaScript(msLoginSignInBtn);
		ExtentTestManager.getTest().pass("Entered the Micosoft Account password and clicked SignIn button");
		if(isPresentAndVisible(msLoginYesBtn)) {
			waits(3);	
			clickWithJavaScript(msLoginYesBtn);
		}	
		ExtentTestManager.getTest().pass("Clicked the Yes button on Stay SignedIn dialogue");
	}
	
	public void submitGoogleCredentials() throws Exception {
		clearTypeKeys(googleUserNameTxtBx, "yvconnector@gmail.com");
		clickWithJavaScript(googleUserNameNextBtn);
		type(googlePasswordBx, "Cactus#930");
		clickWithJavaScript(googlePasswordNextBtn);
		ExtentTestManager.getTest().pass("Entered the Google Account Credentials and clicked Next button");
	}
//==//	
}
