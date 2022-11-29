package com.pages.embedCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;

public class EmbedCodePage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	@FindBy(xpath = "//div[contains(@class,'profile')]")
	WebElement profileIcon;
	@FindBy(xpath = "//a")
	WebElement anchor_link;
	@FindBys(@FindBy(xpath = "//a"))
	List<WebElement> totalLinksList;
	int total_links;
	int total_links1;

	public EmbedCodePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void totalLinks() throws Exception {
		
		total_links = totalLinksList.size();
		System.out.println("total_links = "+total_links);
		ExtentTestManager.getTest().pass("Total links displayed : "+total_links);
	}

	public void appendChild() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("var s=window.document.createElement('a');" + 
				"s.type = 'text/javascript';" + "s.text = function foo() {console.log('foo')};" + 
				"window.document.head.appendChild(s);");
	}

	public void totalLinks1() throws Exception {
		
		total_links1 = totalLinksList.size();
		System.out.println("total_links = "+total_links);
		ExtentTestManager.getTest().pass("Total links displayed : "+total_links);
	}

	public void totalLinks11() throws Exception {
		if(total_links!=total_links1)
			ExtentTestManager.getTest().pass("Dynamically injecting anchors is successful");
		else
			ExtentTestManager.getTest().fail("Dynamically injecting anchors is unsuccessful");
	}
	
}
