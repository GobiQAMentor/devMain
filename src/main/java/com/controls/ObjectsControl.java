package com.controls;


import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ObjectsControl {
	public WebDriver webDriver;
	Long maxWaitTimeToFindElement = 120l;
	Long smallWaitTime = 45L;
	public WebDriverWait wait, wait2;
	public static final int finalTime= (int) (new Date().getTime()/1000);;
	String screenshot;

	JavascriptExecutor js;
	Actions act;


	public static Properties tepfinXProperties;

	public ObjectsControl(WebDriver webDriver){
		this.webDriver = webDriver;

		wait = new WebDriverWait(webDriver, maxWaitTimeToFindElement);
		wait2 = new WebDriverWait(webDriver, smallWaitTime);
		js = (JavascriptExecutor) webDriver;
		act=new Actions(webDriver);
		//		readTepfinXProperties();
	}


	public void maximizeWebPage() {
		webDriver.manage().window().maximize();
	}



	protected boolean verifyPageTitle(String expectedTitle){
		String message = "Waiting for the title :- " + expectedTitle
				+ ", will wait by " + smallWaitTime
				+ " seconds";

		boolean verifyFlag = false;
		try {
			System.out.println(message);
			Thread.sleep(2000);
			verifyFlag = wait2.until(ExpectedConditions.titleContains(expectedTitle));
			//			scenario.log(expectedTitle +" verified");
		} catch (Exception e) {
			verifyFlag = false;

			//			ExtentTestManager.getTest().addScreenCaptureFromPath(UtilityClass.getFileScreenshot(), "Home_verified");
			//			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected boolean verifyCurrentURL(String expectedURL){
		String message = "Waiting for the URL " + expectedURL
				+ ", will wait by " + maxWaitTimeToFindElement
				+ " seconds";

		boolean verifyFlag = false;
		try {
			System.out.println(message);
			Thread.sleep(2000);
			verifyFlag = wait.until(ExpectedConditions.urlToBe(expectedURL));
			//			scenario.log(expectedURL +" verified");
		} catch (Exception e) {
			verifyFlag = false;

			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no "+expectedURL);
			//			System.out.println("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected void navigateTo(String url) {
		webDriver.get(url);
		//		scenario.log("Navigated to "+url);
	}

	protected String getCssValue(WebElement element, String attrName){
		String cssValue=null;
		element= waitAndFindElementByVisibility(element);
		cssValue=element.getCssValue(attrName);
		return cssValue;
	}



	protected void typeKeys(WebElement element, String value) {
		element= waitAndFindElementByVisibility(element);
		element.sendKeys(Keys.END);
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
		element.sendKeys(Keys.TAB);
	}

	protected void clearTypeKeys(WebElement element, String value) {
		element= waitAndFindElementByVisibility(element);
		element.sendKeys(Keys.END);
		element.clear();
		element.sendKeys(value);
	}

	protected void click(WebElement element) throws Exception {
		element= waitAndFindElementByVisibility(element);
		//highLightElement(element);
		System.out.println("clicking");
		//		takeScreenshot();
		element.click();
	}

	protected void clickWithJavaScript(WebElement element) throws Exception {
		highLightElement(element);
		js.executeScript("arguments[0].click();", element);
	}

	protected void clickElementWithLocator(By locator) throws Exception {
		WebElement element = waitForAndFindElementByLocator(locator);
		highLightElement(element);
		// takeScreenshot();
		element.click();
	}

	protected void submit(WebElement element) {
		element=waitAndFindElementByVisibility(element);
		element.submit();
	}

	protected String getText(WebElement element) {
		String text = null;
		element= waitAndFindElementByVisibility(element);
		text = element.getText();
		return text;
	}
	//	protected List listDetailsForText(WebElement element) {
	//		String text = null;
	//		List allElementDetails= waitForListElements(element);
	//		return allElementDetails;
	//	}
	protected Boolean isSelected(WebElement element) {
		Boolean flag = true;
		element= waitAndFindElementByVisibility(element);
		flag = element.isSelected();
		return flag;
	}

	protected boolean isVisible(WebElement element) {

		return element.isEnabled();
	}


	protected List<WebElement> verifyNumberOfElementLessThen(By by,int count) {
		String message = "Searching elements list " + by.toString()
		+ " to be less than "+count+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		List<WebElement> elementList = null;
		try {
			System.out.println(message);
			elementList = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(by,count));
		} catch (Exception e) {
			elementList = null;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element  "+by.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return elementList;


	}

	protected List<WebElement> verifyNumberOfElementsMoreThan(By by, int number) {
		String message = "Searching elements list " + by.toString()
		+ " to be greater than "+number+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		List<WebElement> elementList = null;

		try {
			System.out.println(message);
			elementList = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,number));
		} catch (Exception e) {
			elementList = null;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element  "+by.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return elementList;
	}

	protected List<WebElement> verifyNumberOfElementsToBe(By by, int number) {
		String message = "Searching elements list " + by.toString()
		+ " to be greater than "+number+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";

		List<WebElement> elementList = null;
		try {
			System.out.println(message);
			elementList = wait.until(ExpectedConditions.numberOfElementsToBe(by,number));
		} catch (Exception e) {
			elementList = null;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element  "+by.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return elementList;
	}


	protected List<WebElement> waitForListElements(List<WebElement> elements) {
		String message = "Searching elements list " + elements.get(0).toString()
				+ "  will wait by " + maxWaitTimeToFindElement
				+ " seconds";
		List<WebElement> elementList = null;
		try {
			System.out.println(message);
			elementList = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			elementList = null;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element list not loaded "+elements.size());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return elementList;
	}


	protected boolean verifyElementByText(WebElement element, String textValue){
		String message = "Waiting element " + element.toString()
		+ " for its text "+textValue+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean verifyFlag = false;
		try {
			System.out.println(message);

			verifyFlag = wait.until(ExpectedConditions.textToBePresentInElement(element, textValue));
		} catch (Exception e) {
			verifyFlag = false;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element text  "+textValue);
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected boolean verifyElementInvisibility(WebElement element){
		String message = "Waiting for element's invisibility " + element.toString()
		+ "  will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean verifyFlag = false;
		try {
			System.out.println(message);

			verifyFlag = wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("Element invisible");
		} catch (Exception e) {
			verifyFlag = false;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element did not get invisible  "+element.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected boolean verifyElementByTextMatches(WebElement element , String textValue){
		String message = "Waiting element " + element.toString()
		+ " for its text "+textValue+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean verifyFlag = false;
		try {
			System.out.println(message);

			verifyFlag = wait.until(ExpectedConditions.textToBePresentInElementValue(element, textValue));
		} catch (Exception e) {
			verifyFlag = false;
			takeScreenshot();
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element text  "+textValue);
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected void waitForElementInvisibility(WebElement element){
		String message = "Waiting for element's invisibility " + element.toString()
		+ "  will wait by " + 1
		+ " seconds";
		boolean verifyFlag = element.isDisplayed();
		try {
			System.out.println(message);
			while(verifyFlag){
				System.out.println(verifyFlag);
				Thread.sleep(1500);
				verifyFlag= element.isDisplayed();
				System.out.println(verifyFlag);
			}

			//			verifyFlag = wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			System.out.println("Loading completed");
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element did not get invisible  "+element.toString());
			//			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}

	}

	protected boolean verifyElementByAttribute(WebElement element, String attributeName, String attrValue){
		String message = "Waiting element " + element.toString()
		+ " for its attribute "+attributeName+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean verifyFlag = false;
		try {
			System.out.println(message);
			verifyFlag = wait.until(ExpectedConditions.attributeToBe(element, attributeName, attrValue));
		} catch (Exception e) {
			verifyFlag = false;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element attribute  "+attrValue);
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected boolean verifyElementByAttribute(By elementBy, String attributeName, String attrValue){
		String message = "Waiting element " + elementBy.toString()
		+ " for its attribute "+attributeName+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean verifyFlag = false;
		try {
			System.out.println(message);
			verifyFlag = wait.until(ExpectedConditions.attributeToBe(elementBy, attributeName, attrValue));
		} catch (Exception e) {
			verifyFlag = false;
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "no element attribute  "+attrValue);
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected WebElement waitAndFindElementByVisibility(WebElement element) {
		String message = "Searching element " + element.toString()
		+ " for presence, will wait by " + maxWaitTimeToFindElement
		+ " seconds";

		try {
			System.out.println(message);
			element= wait.until(ExpectedConditions.visibilityOf(element));
			highLightElement(element);
		}catch(JsonException jse) {
			webDriver.navigate().refresh();
			System.out.println("catching jsonexception and setting urlto google");
			webDriver.get("https://google.com");
			throw new RuntimeException("This was caused by jsonException");
		} catch (Exception e) {
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element not visible  "+element.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return element;
	}

	protected WebElement waitForAndFindElementByLocator(By locator) {
		String message = "Searching element " + locator.toString()
		+ " for presence, will wait by " + maxWaitTimeToFindElement
		+ " seconds";

		WebElement element = null;
		try {
			System.out.println(message);
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(JsonException jse) {
			webDriver.navigate().refresh();
			System.out.println("catching jsonexception and setting urlto google");
			webDriver.get("https://google.com");
			throw new RuntimeException("This was caused by jsonException");

		} catch (Exception e) {
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element not visible  "+locator.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return element;
	}

	protected WebElement waitForAndFindElementAfterEnable(WebElement element) {
		String message = "Searching element " + element.toString()
		+ " for presence, will wait by " + maxWaitTimeToFindElement
		+ " seconds";


		try {
			System.out.println(message);
			element= wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element not visible  "+element.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return element;
	}

	protected String takeScreenshot() {

		screenshot = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+System.currentTimeMillis()+".png";
		File srcFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		System.out.println("Failed and Screen capture saved at location "
				+ screenshot);
		try {
			FileHandler.copy(srcFile, new File(screenshot));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshot;
	}

	protected void selectDropDownVisibleText(WebElement element, String text) {
		element= waitAndFindElementByVisibility(element);
		Select dropdown=new Select(element);
		dropdown.selectByVisibleText(text);


	}

	protected void dragAndDrop(WebElement drag,WebElement drop) {
		act.dragAndDrop(drag, drop).build().perform();

	}

	protected boolean verifyElementClicked(WebElement element) {
		String message = "Verifying element clicked " + element.toString()
		+ " or need to be clicked again";

		boolean present = true;
		try {
			System.out.println(message);
			while(!element.isDisplayed()) {
				element.click();
			}
		} catch (Exception e) {
			present = false;
			takeScreenshot();
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element not clicked  "+element.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return present;
	}

	protected boolean isPresentAndVisible(WebElement element) {
		String message = "Waiting for the visibility of element " + element.toString()
		+", will wait by " + maxWaitTimeToFindElement
		+ " seconds";
		boolean present = false;
		try {
			System.out.println(message);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			present = true;
			//			scenario.log(element.toString()+" visible");
		} catch (Exception e) {
			//			scenario.attach(UtilityClass.takeByteScreenshot(webDriver), "image/png", "element not visible  "+element.toString());
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		System.out.println(element.toString()+" verified");
		return present;
	}

	protected boolean isPresentAndVisibleVersion2(WebElement element) {
		String message = "Waiting for the visibility of element " + element.toString()
		+", will wait by " + smallWaitTime
		+ " seconds";
		boolean present = false;
		try {
			System.out.println(message);
			element = wait2.until(ExpectedConditions.visibilityOf(element));
			present = true;
			//			scenario.log(element.toString()+" visible");
		} catch (Exception e) {
			present = false;
			System.out.println("webelement is not there");
		}
		System.out.println(" returning boolean element state "+present );
		return present;
	}

	private void highLightElement(WebElement element) throws InterruptedException{
		//		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');", element);
		Thread.sleep(150);
		js.executeScript("arguments[0].style.border=''", element, "");
		//Thread.sleep(2000);
	}

	protected void scrollToElement(WebElement element){

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void scrollToPageBottom(){

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	protected void scrollToPageTop(){

		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}


	public void switchToFrame(WebElement element){
		String message = "Waiting to switch to frame"
				+ ", will wait by " + maxWaitTimeToFindElement
				+ " seconds";
		try {
			System.out.println(message);
			Thread.sleep(5000);
			this.webDriver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));

		} catch (Exception e) {
			takeScreenshot();
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		System.out.println("successfully switched to frame");
	}

	public Alert switchToAlert(){
		Alert alert= null;
		String message = "Waiting to switch to alert"
				+ ", will wait by " + maxWaitTimeToFindElement
				+ " seconds";
		try {
			System.out.println(message);
			Thread.sleep(2000);
			alert= wait.until(ExpectedConditions.alertIsPresent());

		} catch (Exception e) {
			takeScreenshot();
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return alert;
	}

	public void acceptAlert(Alert alert) {
		alert.accept();
	}

	protected void closeCurrentTab() {
		webDriver.close();
	}

	protected void returnFromFrame(){

		this.webDriver = webDriver.switchTo().parentFrame();
	}

	protected void switchToDefaultContent() {
		this.webDriver = webDriver.switchTo().defaultContent();
	}

	protected void actionClick(WebElement element){

		act.click(element).build().perform();
	}

	protected void mouseHoverElement(WebElement element) throws InterruptedException {
		highLightElement(element);
		act.moveToElement(element).build().perform();
	}

	protected void switchToLastWindow(){
		Set<String> handles = webDriver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);
		String handleToSwitch = handlesList.get(handlesList.size() - 1);
		webDriver.switchTo().window(handleToSwitch);
	}

	protected void switchWindow(String handle){

		webDriver.switchTo().window(handle);
	}

	protected void openNewTabWithURL(String url){

		js.executeScript("window.open('"+ url +"', '_blank');");
	}

	public void switchToTabWithUrl(String url) throws InterruptedException {
		//		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());

		for(String tab: tabs){
			webDriver.switchTo().window(tab);
			String currentURL=webDriver.getCurrentUrl();
			if(currentURL.contains(url))
				break;
		}
	}
	protected void pressKey(Keys key){

		act.keyDown(key).keyUp(key).build().perform();
	}

	protected void selectAll(){

		act.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
	}

	protected void pasteContentWithActions(String value){
		StringSelection strSel = new StringSelection(value);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);
		act.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();

		//		act.keyDown( Keys.CONTROL ).sendKeys( value ).keyUp( Keys.CONTROL ).build().perform();
	}

	protected void sendModifierKeys(Keys key){

		act.sendKeys(key).build().perform();
	}

	protected void typeKeysWithActions(WebElement element,String value){
		element= waitAndFindElementByVisibility(element);
		act.sendKeys(element, value).build().perform();
	}

	protected boolean waitForElementInvisibilityWithBy(By by) throws Exception{


		String message = "Waiting for the invisibility of :- " + by.toString()
		+ ", will wait by " + maxWaitTimeToFindElement + " seconds";

		boolean verifyFlag = false;
		try {
			System.out.println(message);
			verifyFlag = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			System.out.println("Element iinvisible");
		} catch (JsonException e) {
			Thread.sleep(5000);
			System.out.println("Json exception caught");
			//			verifyFlag = wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			System.out.println("Element iinvisible");
		} catch (Exception e) {
			verifyFlag = false;
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
		return verifyFlag;
	}

	protected boolean verifyFieldDisplayed(WebElement element) throws Exception {
		try {	
			return element.isDisplayed();
		} catch (Exception e) {
			throw new RuntimeException("Exception caused by "+e.getClass().getName()+" and message is "+e.getMessage());
		}
	}

	protected void deleteAllCookies() {
		webDriver.manage().deleteAllCookies();
	}

	protected void refreshPage() {
		webDriver.navigate().refresh();
	}

	protected void navigateBackToPreviousPage() {
		webDriver.navigate().back();
	}

	/********************** closeAllTabsAndSwitchToMainTab *************************/
	protected void closeAllTabsAndSwitchToMainTab(String browser) {
		String originalHandle = webDriver.getWindowHandle();

		List<String> handleSet = new ArrayList<String>(webDriver.getWindowHandles());
		if (browser.equals("firefox") || browser.equals("safari")) {
			if(handleSet.size()>1) {
				webDriver.switchTo().window(handleSet.get(handleSet.size()-1));
				webDriver.close();
				webDriver.switchTo().window(handleSet.get(0));
				refreshPage();
			}
			System.err.println("closed one extra tab and shifted to zero tab");
		}
		else if(handleSet.size()>1) {
			for(String handle : webDriver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					webDriver.switchTo().window(handle);
					webDriver.close();
				}   
			}
			webDriver.switchTo().window(originalHandle);
		}


	}

	/********************** switchToNewTab *************************/	
	public void switchToNewTab() {
		Set<String> s = webDriver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		//String w1 = (String) 
		itr.next();
		String w2 = (String) itr.next();
		webDriver.switchTo().window(w2);
	}

	protected void setWindowDimension(Dimension dime) {
		webDriver.manage().window().setSize(dime);
	}
	public void keyboardTab(WebElement element) {
		//element.sendKeys(Keys.TAB);
		sendModifierKeys(Keys.TAB);
	}
	protected void keyboardEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	protected void typeValue(WebElement element, String value) {
		element= waitAndFindElementByVisibility(element);
		element.sendKeys(value);
	}	
	/********************** switchToOldTab *************************/
	public void switchToOldTab() {
		Set s = webDriver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		webDriver.switchTo().window(w1);
	}

	//scroll to element
	public void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}
	public void type(WebElement element, String value)
	{
		element.sendKeys(value);
	}	
	public void waits(long waitInSec) throws InterruptedException {
		Thread.sleep(waitInSec*1000);
	}
}
