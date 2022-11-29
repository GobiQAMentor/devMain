package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.utils.UtilityClass;

public class Page extends ObjectsControl implements PageInterface{
	WebDriver driver;
	
	public Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean pageVerify(String title) {
		return verifyPageTitle(title);
	}
	
	public void scrollToBottom() {
		scrollToPageBottom();
		ExtentTestManager.getTest().pass("Scroll to the bottom of the webpage");
	}
	
	public void scrollToTop() {
		scrollToPageTop();
		ExtentTestManager.getTest().pass("Scroll to the top of the webpage");
	}
	
	public void scrollToElementInDiv(WebElement divWithScrollbarElement, WebElement elementToScrollTo) {
		((JavascriptExecutor) driver).executeScript(
			    "arguments[0].scrollTop=arguments[1].offsetTop",
			    divWithScrollbarElement,
			    elementToScrollTo);
		ExtentTestManager.getTest().pass("Scroll to the element on the scrollable element");
	}
	
	public void waitForInsightsPageToLoad() throws Exception {
		waitForElementInvisibilityWithBy(loadingBy);
	}
	
	public void waitFor(int seconds) throws InterruptedException {
		waits(seconds);
	}
	
	public void waitInvisibilityOfLoadingIndicator() throws Exception {
		waitForElementInvisibilityWithBy(By.xpath("//div[contains(@class,'loadingIndicator')]"));
	}
	
	public String getDynamicNameString() {
		return "Automation"+UtilityClass.dynamicString();
	}
	
	//===============Login to VTElementVisibility===================//
	public void navigateToVT(String url) throws Exception {
		deleteAllCookies();
		refreshPage();
		driver.get(url);
	}
}