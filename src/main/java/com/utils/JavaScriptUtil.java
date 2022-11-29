package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	private WebDriver driver;
	JavascriptExecutor js;

	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) (driver);
	}

	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element);// 1
			changeColor(bgcolor, element);// 2
		}
	}

	private void changeColor(String color, WebElement element) {

		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void doScrollDownByLength(int length) {
		js.executeScript("window.scrollBy(" + length + ")");
	}

	public void doScrollDownTo() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void doScrollUpTo() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollIntoView(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void drawBorder(WebElement element) {

		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public String getPageInnerText() {

		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	public void clickElementByJS(WebElement element) {

		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingWithId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
	public String waitUntilDonwloadCompleted() throws InterruptedException {
	      // Store the current window handle
	      String mainWindow = driver.getWindowHandle();
	      
	      js.executeScript("window.open()");
	     // switch to new tab
	    // Switch to new window opened
	      for(String winHandle : driver.getWindowHandles()){
	          driver.switchTo().window(winHandle);
	      }
	     // navigate to chrome downloads
	    //  ((JavascriptExecutor)driver).executeScript("window.location.href = 'about://downloads';");
	      driver.get("chrome://downloads");
//	      driver.navigate().to("about://downloads");
	      
	      JavascriptExecutor js1 = (JavascriptExecutor)driver;
	      // wait until the file is downloaded
	      Long percentage = (long) 0;
	      while ( percentage!= 100) {
	          try {
	              percentage = (Long) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
	              //System.out.println(percentage);
	          }catch (Exception e) {
	            // Nothing to do just wait
	        }
	          Thread.sleep(1000);
	      }
	     // get the latest downloaded file name
	      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
	     // get the latest downloaded file url
	      String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
	      // file downloaded location
	      String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
	      System.out.println("Download deatils");
	      System.out.println("File Name :-" + fileName);
	      System.out.println("Donwloaded path :- " + donwloadedAt);
	      System.out.println("Downloaded from url :- " + sourceURL);
	     // print the details
	      System.out.println(fileName);
	      System.out.println(sourceURL);
	     // close the downloads tab2
	      driver.close();
	     // switch back to main window
	      driver.switchTo().window(mainWindow);
	      return fileName;
	  }
	public void sendKeysUsingWithXapth(String xpath, String value) {
		js.executeScript("document.getElementById('" + xpath + "').value='" + value + "'");
	}
	
}
