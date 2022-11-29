package verifyTestPages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SmartbearBitbarSampleTest {
	public static final String URL = "https://us-west-desktop-hub.bitbar.com/wd/hub";
	
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", "Windows");
		capabilities.setCapability("osVersion", "10");
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("version", "106");
		capabilities.setCapability("resolution", "1920x1080");
		capabilities.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");

		WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
//		WebDriver driver = new ChromeDriver();
		String appurl="http://app.box.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Dimension dim = new Dimension(500, 500);
		driver.manage().window().setSize(dim);
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		driver.get("http://app.box.com");
		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.name("login"));
		
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login")));
		element.sendKeys("qacult.demo@gmail.com");
		
		WebElement submitEmail = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit")));
		submitEmail.click();
		
		WebElement enterPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-login")));
		enterPassword.sendKeys("testing123");
		
		WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-submit-password")));
		login.click();
		wait.until(ExpectedConditions.titleContains("All Files | Powered by Box"));
		
		Thread.sleep(4000);
		String newBtncss ="button[class*=\"create-dropdown-menu-toggle-button\"]:not([class*='upload-button'])";
		WebElement newBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(newBtncss)));
		newBtn.click();
		
		String folderLinkCss = "li[aria-label='Create a new Folder']";
		WebElement folderLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(folderLinkCss)));
		folderLink.click();

		WebElement popupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-header")));
		
//		if(popupTitle.getText().equals("Create a New Folder")) 
//			System.out.println("Create Folder popup opened successfully");
//		else
//			System.out.println("Popup could not be opened");
		
		boolean popTitleFlag = popupTitle.getText().equals("Create a New Folder");
		Assert.assertTrue("Popup could not be opened", popTitleFlag);
		

		final String nameToBeInput = "new"+ (int)(Math.random()*((1000-1)+1))+1; 
		WebElement folderName =wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=\"folder-name\"]")));
		folderName.sendKeys(nameToBeInput);
		
		Thread.sleep(2000);
		WebElement selection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[name=\"invite-permission\"]")));
		Select permissionSelect = new Select(selection);
		permissionSelect.selectByVisibleText("Viewer");
//		Thread.sleep(3000);
//		List <WebElement> elementCount = permissionSelect.getOptions();
//		System.out.println(elementCount.size());
//		for(WebElement sample: elementCount) {
//			if(sample.getText().equals("Editor"))
//				permissionSelect.selectByVisibleText("Editor");
//		}
		
		permissionSelect.selectByVisibleText("Viewer");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-resin-target=\"primarybutton\"]"))).click();
		
		// To verify the success message and waiting for its invisibility
		WebElement succcessMessageNotification = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='notification info wrap']")));
		System.out.println(succcessMessageNotification.getText());
		String successMessageText = "\""+nameToBeInput+"\" was created successfully.";
		System.out.println(successMessageText);
		Assert.assertTrue("folder not created succcessfully", succcessMessageNotification.getText().equals(successMessageText));
		wait.until(ExpectedConditions.invisibilityOf(succcessMessageNotification));
		
		//select and delete folder row
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='row' and .//a[@title='"+nameToBeInput+"']]"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-resin-target=\"trash\"]"))).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-resin-target=\"primarybutton\"]"))).click();
		
		//verify deletion message
		WebElement succcessMessageNotification1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='notification info wrap']")));
		System.out.println(succcessMessageNotification1.getText());
		
		Assert.assertTrue("folder not deleted succcessfully", succcessMessageNotification1.getText().contains("Item successfully moved to trash."));
		wait.until(ExpectedConditions.invisibilityOf(succcessMessageNotification1));
		
		//logout from app
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-resin-target=\"accountmenu\"]"))).click();	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[data-resin-target=\"logout\"]"))).click();
		System.out.println("Loggedout from application");
		
		driver.quit();
	}
}
