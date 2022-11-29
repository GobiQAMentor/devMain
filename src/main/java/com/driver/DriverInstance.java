package com.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {

	private static DriverInstance instance;

	private WebDriver remoteDriver;
	private static WebDriver localDownloadDriver;
	public static boolean isRemoteBrowserInitialised = false;
	private WebDriverWait wait;
	public static Properties prop;
	public static List<WebDriver> workingDriversList = new ArrayList<WebDriver>();
	static final String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads"+ File.separator + "chromedownloads";
	public static final String DURL = "https://us-west-desktop-hub.bitbar.com/wd/hub";
	public static final String MURL = "https://eu-mobile-hub.bitbar.com/wd/hub";
	
	
	private DriverInstance(String browser) throws MalformedURLException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM/dd_HH_mm_ss");
		String testRunTime = dtf.format(LocalDateTime.now());
		System.out.println("downloadFilepath = " + downloadFilepath);
		DesiredCapabilities caps = null;
		caps = new DesiredCapabilities();

		HashMap<String, String> cbtoptions = null;
		HashMap<String, String> iosoptions = null;
		HashMap<String, String> androidoptions = null;
		cbtoptions = new HashMap<String, String>();
		cbtoptions.put("screenResolution", "1920x1200");
		cbtoptions.put("record_video", "true");
		
		iosoptions = new HashMap<String, String>();
		iosoptions.put("deviceName", "iPhone 11");
		iosoptions.put("platformVersion", "13.1.3");
		iosoptions.put("deviceOrientation", "portrait");
		iosoptions.put("record_video", "true");
		
		androidoptions = new HashMap<String, String>();
		androidoptions.put("deviceName", "Pixel 5");
		androidoptions.put("platformVersion", "11.0");
		androidoptions.put("deviceOrientation", "portrait");
		androidoptions.put("record_video", "true");
		//		cbtoptions.put("download.default_directory", downloadFilepath);

		if(browser.equalsIgnoreCase("winchrome")) {
			caps.setCapability("platform", "Windows");
			caps.setCapability("osVersion", "10");
			caps.setCapability("browserName", "chrome");
			caps.setCapability("version", "106");
			caps.setCapability("resolution", "1920x1080");
			caps.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");
			caps.setCapability("bitbar_project", "YouVisit"+testRunTime);
			caps.setCapability("bitbar_testrun", "Win Chrome");

			this.remoteDriver = new RemoteWebDriver(new URL(DURL), caps);
			//this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
			//			((RemoteWebDriver) remoteDriver).setFileDetector(new LocalFileDetector());
			remoteDriver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")) {
//			caps.setCapability("platformName", "Windows 10");
//			caps.setCapability("browserName", "Firefox");
//			caps.setCapability("browserVersion", "95");
//			caps.setCapability("browser.download.folderList",2);
//			caps.setCapability("browser.download.manager.showWhenStarting",false);
//			//			caps.setCapability("browser.download.dir",getcwd());
//			caps.setCapability("browser.helperApps.neverAsk.saveToDisk","text/csv");
//			caps.setCapability("cbt:options", cbtoptions);
//			this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
//			remoteDriver.manage().window().maximize();
			
			WebDriverManager.firefoxdriver().setup();
			this.remoteDriver = new FirefoxDriver();
			// test.log(LogStatus.PASS, "Launching Chrome Browser");

			remoteDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			remoteDriver.manage().window().maximize();
			
			
		}else if(browser.equalsIgnoreCase("safari")) {
			caps.setCapability("platform", "macOS");
			caps.setCapability("osVersion", "13");
			caps.setCapability("browserName", "safari");
			caps.setCapability("version", "16");
			caps.setCapability("resolution", "2560x1920");
			caps.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");
			caps.setCapability("bitbar_project", "YouVisit"+testRunTime);
			caps.setCapability("bitbar_testrun", "MAC Safari");
			this.remoteDriver = new RemoteWebDriver(new URL(DURL), caps);
			//this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
			remoteDriver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("macchrome")) {
			caps.setCapability("platform", "macOS");
			caps.setCapability("osVersion", "13");
			caps.setCapability("browserName", "chrome");
			caps.setCapability("version", "106");
			caps.setCapability("resolution", "2560x1920");
			caps.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");
			caps.setCapability("bitbar_project", "YouVisit"+testRunTime);
			caps.setCapability("bitbar_testrun", "Mac Chrome");
			this.remoteDriver = new RemoteWebDriver(new URL(DURL), caps);
//			this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);

			remoteDriver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("edge")) {

//			caps.setCapability("platformName", "Windows 10");
//			caps.setCapability("browserName", "MicrosoftEdge");
//			caps.setCapability("browserVersion", "95");
//			caps.setCapability("cbt:options", cbtoptions);
//			this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
//			remoteDriver.manage().window().maximize();
			
			WebDriverManager.edgedriver().setup();
			this.remoteDriver = new EdgeDriver();
			// test.log(LogStatus.PASS, "Launching Chrome Browser");

			remoteDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			remoteDriver.manage().window().maximize();
			
		}
		else if(browser.equalsIgnoreCase("iossafari")) {
			caps.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");
			caps.setCapability("bitbar_device", "Apple iPhone 11 A2221 13.0");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPhone device");
			caps.setCapability("automationName", "XCUITest");
			caps.setCapability("browserName", "Safari");
			caps.setCapability("bitbar_project", "YouVisit"+testRunTime);
			caps.setCapability("bitbar_testrun", "iOS Safari");
			this.remoteDriver = new RemoteWebDriver(new URL(MURL), caps);
			//this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
			remoteDriver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("androidchrome")) {
			caps.setCapability("bitbar_apiKey", "vEWWB4cvDawU6SnJhDTli8qh7cCN9ArP");
			caps.setCapability("bitbar_device", "Google Pixel 5");
			caps.setCapability("platformName", "Android");
			caps.setCapability("deviceName", "Android Phone");
			caps.setCapability("automationName", "Appium");
			caps.setCapability("browserName", "Chrome");
			caps.setCapability("bitbar_project", "YouVisit"+testRunTime);
			caps.setCapability("bitbar_testrun", "Android Chrome");
			this.remoteDriver = new RemoteWebDriver(new URL(MURL), caps);
			//this.remoteDriver = new RemoteWebDriver(new URL("http://" +prop.getProperty("Username") + ":" + prop.getProperty("Password") +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
			remoteDriver.manage().window().maximize();
		} else if (browser.equals("localchrome")) {

			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("disable-infobars");
			//			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			//options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			options.setExperimentalOption("prefs", chromePrefs);

			WebDriverManager.chromedriver().setup();
			this.remoteDriver = new ChromeDriver(options);
			// test.log(LogStatus.PASS, "Launching Chrome Browser");

			remoteDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			remoteDriver.manage().window().maximize();
		}
		wait = new WebDriverWait(remoteDriver, 60);
		remoteDriver.manage().window().maximize();

		remoteDriver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
		remoteDriver.manage().deleteAllCookies();
		//		driver.get(prop.getProperty("url"));

	}
	
//	private DriverInstance() {
//		initializeLocalDownloadDriver();
//	}
	
	public static WebDriver initializeLocalDownloadDriver() throws Exception {

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("disable-infobars");
			//			options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
//		options.addArguments("--headless");
		options.addArguments("headless");
	    options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		options.setExperimentalOption("prefs", chromePrefs);
		if(Thread.currentThread().getName().equals("firefox"))
			Thread.sleep(5000);
		System.out.println("Downloading file in headless mode....................");
		WebDriverManager.chromedriver().setup();
		localDownloadDriver = new ChromeDriver(options);
		// test.log(LogStatus.PASS, "Launching Chrome Browser");

		localDownloadDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		localDownloadDriver.manage().deleteAllCookies();
		//		driver.get(prop.getProperty("url"));
		return localDownloadDriver;
	}
	
	public static void quitLocalDownloadDriver() throws InterruptedException {
		Thread.sleep(2000);
		localDownloadDriver.quit();
	}

	public static void setInstance(String browser) throws MalformedURLException {
		//		String browser = prop.getProperty("browser");
		instance = new DriverInstance(browser);
		//		test.log(Status.PASS, "executing test in "+browser);
	}

	public static DriverInstance getInstance() {

		return instance;
	}

	public WebDriver getDriver() {
		return remoteDriver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public static Properties setupCommonProperties() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("src/test/resources/config/environment.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}


	public void quitLocalDriver() throws InterruptedException {
		Thread.sleep(2000);
		remoteDriver.quit();
	}

	public static List<WebDriver> getWorkingDriversList() {
		return workingDriversList;
	}

	public static void setWorkingDriversList(List<WebDriver> workingDriversList) {
		DriverInstance.workingDriversList = workingDriversList;
	}

}
