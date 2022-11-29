package com.tests.apiAnalyticsTests;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.PageInterface;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class AnalyticsNavigationPages extends ObjectsControl implements PageInterface{
	WebDriver driver;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//	======Methods related locators==================

	@FindBy(css = "div[class* = 'tableDiv'")
	WebElement exploreInquiriesTable;

	@FindBys(@FindBy(xpath = "//div[@data-test='Thumbnail']"))
	List<WebElement> videoThumbnails;

	@FindBy(xpath = "//div[contains(@class,'h-dropdown-')]")
	WebElement universityNameDropdownOptions;

	@FindBy(xpath = "//div[contains(@class,'vjs-playing')]")
	WebElement videoPlaying;

	@FindBy(xpath = "//div[contains(@class,'vjs-pause')]")
	WebElement videoPause;

	//	======Analytics functional tests related locators==================

	@FindBy(xpath = "//li[1]//a[contains(@class,'linkContainer')]")
	WebElement stonyBrookSelectExperiene;

	@FindBy(xpath = "//div[@id='open_experience selection screen_button']")
	WebElement OpenExperienceClampButton;

	@FindBy(xpath = "//div[@alt='Academic Mall Fountain']")
	WebElement firstExperienceSpotList;

	@FindBy(xpath = "//span[contains(.,'Join Community') or contains(.,'Schedule Visit')]")
	WebElement ScheduleVisitButton;

	@FindBy(xpath = "//div[contains(@class,'closeButton')]/img")
	WebElement closeButton;

//	//div[@data-test='NextButton']")	
	@FindBy(xpath = "//div[contains(@class,'withProps') and contains(@class,'arrow')]")
	WebElement nextStopArrow;

	@FindBy(xpath = "//div[@id='application']")
	WebElement pageSessionDetails;
	
	@FindBy(tagName = "pre")
	WebElement responseBody;
	@FindBy(id = "iframe-modal-iframe")
	WebElement virtualTouriframe;
	@FindBy(xpath = "//button[@value='other']")
	WebElement otherButton;
	@FindBy(xpath = "//button[@value='counselor']")
	WebElement counselorButton;
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement emailTextbox;
	@FindBy(xpath = "//input[contains(@id,'firstname')]")
	WebElement firstnameTextbox;
	@FindBy(xpath = "//input[contains(@id,'lastname')]")
	WebElement lastnameTextbox;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dobField;
	@FindBy(xpath = "//button[.='Next']")
	WebElement nextButton;
	@FindBy(xpath = "//div[contains(text(),'Almost done!')]")
	WebElement almostDoneMessage;
	@FindBy(xpath = "//input[@placeholder='School name']")
	WebElement whichSchoolDoYouWorkWithSchoolName;
	@FindBy(xpath = "//button[.='Done']")
	WebElement doneButton;
	@FindBy(xpath = "//p[text()='Get ready']")
	WebElement getReadyMessage;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> SchoolNameOptions;
	
	public AnalyticsNavigationPages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//	================Methods related methods========================
	public WebElement getVideoElement(String nth) {
		return waitForAndFindElementByLocator(By.xpath("(//video[@alt='video guide for Enhanced Experience.'])["+nth+"]"));
	}

	public void scrollToVideo(WebElement element) {
		scrollTo(driver, element);
	}

	public void clickVideo(String nth) throws Exception {
		clickElementWithLocator(By.xpath("(//video[@alt='video guide for Enhanced Experience.'])["+nth+"]"));
	}

	public boolean verifyVideoPlaying() {
		return isPresentAndVisible(videoPlaying);
	}

	public boolean verifyVideoPause() {
		return isPresentAndVisible(videoPause);
	}

	public void clickSupplimentVideo() throws Exception {
		waits(10l);
		//eUtil.doMoveToElementUsingAction(By.xpath("//div[@data-test='BottomRightOptions']/div"));
		//WebElement e = waitAndFindElementByVisibility();
		int size = videoThumbnails.size();
		if(size <= 0) 
			ExtentTestManager.getTest().pass("No suppliment video is found on this page");
		else {
			waitForAndFindElementByLocator(By.xpath("(//div[@data-test='Thumbnail'])["+size+"]"));
			if(size>=3)
				waitForAndFindElementByLocator(By.xpath("(//div[@data-test='Thumbnail'])[2]"));
			else if (size==2)
				waitForAndFindElementByLocator(By.xpath("(//div[@data-test='Thumbnail'])[1]"));
			else if(size==1)
				waitForAndFindElementByLocator(By.xpath("//div[@data-test='Thumbnail']"));
		}

	}


	//	============mthods for Analytics functional Testcases ===========
	
	public String getExpectedGMTTime() {
		Date currentTime = new Date();
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println("GMT time: " + sdf.format(currentTime));
		Date addedHours = new Date(currentTime.getTime() + TimeUnit.HOURS.toMillis(4));
		Date ExpectedTimeInGMT = new Date(addedHours.getTime() + TimeUnit.SECONDS.toMillis(0));
		System.out.println("GMT time: " + sdf.format(ExpectedTimeInGMT));
		return sdf.format(ExpectedTimeInGMT);
	}
	
	public void switchToTheVirtualtourFrame() throws Exception {
		switchToFrame(virtualTouriframe);
	}
	
	public void clickOtherButton() throws Exception {
		click(otherButton);
	}
	public void clickCounselorButton() throws Exception {
		click(counselorButton);
	}
	public void clickNextButton() throws Exception {
		Thread.sleep(2000);
		waitAndFindElementByVisibility(nextButton);
		click(nextButton);
		Thread.sleep(5000);
	}
	public void verifyAlmostDoneMessage() throws Exception {
		isPresentAndVisible(almostDoneMessage);
	}
	public void enterWhichSchoolDoYouWorkWithSchoolName() throws Exception {
		clearTypeKeys(whichSchoolDoYouWorkWithSchoolName, "Wellstone Paul David");
	}
	public void clickDoneButton() throws Exception {
		clickWithJavaScript(doneButton);
	}
	public void verifyGetReadyMessage() throws Exception {
		isPresentAndVisible(getReadyMessage);
	}
	
	public void clickCloseButton() throws Exception {
		waitAndFindElementByVisibility(closeButton);
		clickWithJavaScript(closeButton);
	}

	public void selectStonyBrookExperiene() throws Exception {
		clickWithJavaScript(stonyBrookSelectExperiene);
	}

	public void clickExperienceClampButton() throws Exception {
		waitAndFindElementByVisibility(OpenExperienceClampButton);
		clickWithJavaScript(OpenExperienceClampButton);
	}
	
	public void enterEmail(String email) throws Exception {
		isPresentAndVisible(emailTextbox);
		clearTypeKeys(emailTextbox, email);
		System.out.println("EMAIL---"+email);
	}
	public void enterFirstName(String firstName) throws Exception {
		clearTypeKeys(firstnameTextbox, firstName);
		//System.out.println("FIRSTNAME"+firstName);
	}
	public void enterLastName(String lastName) throws Exception {
		clearTypeKeys(lastnameTextbox, lastName);
		//System.out.println("lastName"+lastName);
	}

	public void enterDOB(String Value) throws Exception {
		scrollToPageBottom();
		clearTypeKeys(dobField, Value);
	}
	
	public void enterTheWhichSchoolDoYouWorkWithSchoolName() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		int count = 0;
		String value=null;
		clickWithJavaScript(whichSchoolDoYouWorkWithSchoolName);
		do {
			value = getRandomChar();
			clearTypeKeys(whichSchoolDoYouWorkWithSchoolName,value);
			optionSize = SchoolNameOptions.size();
			count++;
		}while(optionSize > 2 || count<5);
		if(optionSize>0){	
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			click(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	
	public String getRandomChar() {
		Random r = new Random();
		StringBuilder sr = new StringBuilder();
		for(int i=0; i<3; i++) {
			int c = r.nextInt(26) + (byte)'a';
			sr.append((char)c);
		}
		return sr.toString();
	}

	public void clickScheduleVisitButton() throws Exception {
		clickWithJavaScript(ScheduleVisitButton);
		waits(5);
	}
	
	public void waitInvisibilityOfLoadingIndicator() throws Exception {
		waitForElementInvisibilityWithBy(By.xpath("//div[@class='loadingIndicator']"));
	}

	public void switchToMainPage() {
		switchToLastWindow();
	}
	
	public void closeNewTab(String browser) {
		closeAllTabsAndSwitchToMainTab(browser);
	}

	public void clickNextStopArrow() throws Exception {
		waitAndFindElementByVisibility(nextStopArrow);
		clickWithJavaScript(nextStopArrow);
		ExtentTestManager.getTest().pass("Clicked the Next Stop Arrow");
		waits(5);
	}

	public String getSessionUserKey() {
		String dataRegistration = pageSessionDetails.getAttribute("data-registration");
		String [] info = dataRegistration.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
		String userkey = null;
		for(String entry : info) {
			ExtentTestManager.getTest().pass("Userkey of the session : " + entry);
			if(entry.startsWith("\"userkey\"")) {
				String[] value = entry.split(":");
				userkey = value[1];
			}		
		}
		userkey = userkey.replace("\"", "");
		ExtentTestManager.getTest().pass("USER KEY is : "+userkey);
		return userkey;
	}

	public String getMd5Hash()  
	{  
		String input = getExpectedGMTTime().substring(0,10);
		ExtentTestManager.getTest().pass("Date input for Auth generation:"+input);
		input = "YVAuto-"+input;		
		try   
		{  
			//static getInstance() method is called with hashing MD5  
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			//calculating message digest of an input that return array of byte  
			byte[] messageDigest = md.digest(input.getBytes());  
			//converting byte array into signum representation  
			BigInteger no = new BigInteger(1, messageDigest);  
			//converting message digest into hex value  
			String hashtext = no.toString(16);  
			while (hashtext.length() < 32)   
			{  
				hashtext = "0" + hashtext;  
			} 
			System.out.println(hashtext);
			return hashtext;  
		}  
		//for specifying wrong message digest algorithms  
		catch (NoSuchAlgorithmException e)   
		{  
			throw new RuntimeException(e);  
		}  
	}
	
	public String openAnalyticValidationURL(String url, String userKey, String authKey) throws MalformedURLException, InterruptedException {
		
		URL address = new URL(url);
		String validationURL = "https://"+address.getHost()+"/internals/validator/analytics/"+userKey+"?auth="+authKey;
		ExtentTestManager.getTest().pass(validationURL);
		//openNewTabWithURL(validationURL);
		navigateTo(validationURL);
		waits(5);
		navigateTo(validationURL);
		waits(5);
		//switchToNewTab();
		waitAndFindElementByVisibility(responseBody);
		//navigateTo(validationURL);
		waitAndFindElementByVisibility(responseBody);
		String response = responseBody.getText();
		ExtentTestManager.getTest().pass("Response : "+response);
		System.err.println("Response : "+response);
		return response;
	}
	
	public String[] parseJsonString(String response, String apiTable, String key) {		
	String[] value = null;
		try {
			JSONParser parse = new JSONParser();
			JSONObject data_obj = (JSONObject) parse.parse(response);

			//Get the required object from the above created object
			JSONObject obj = (JSONObject) data_obj.get("payload");

			//Get the required data using its key
			JSONArray arr = (JSONArray) obj.get(apiTable);
			ExtentTestManager.getTest().pass(apiTable +" values from API response : " +obj.get(apiTable));					 
			ExtentTestManager.getTest().pass("Size of "+apiTable+" values"+arr.size());
    		value = new String[arr.size()];
			 for (int i = 0; i < arr.size(); i++) {
                 JSONObject new_obj = (JSONObject) arr.get(i);
                 if(new_obj.get(key)!=null) {
                	 value[i] = (String) new_obj.get(key);
                	 System.out.println(apiTable + " value for the key " + key + "is - " + value[i]);
                 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	
	public void applicationNavigation(String browser) throws Exception {
		switchToTheVirtualtourFrame();
		clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
		clickCounselorButton();
		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		enterEmail("testqa@eab.com");		
		ExtentTestManager.getTest().pass("Enter the email");
		enterFirstName("Alytics");
		ExtentTestManager.getTest().pass("Enter the firstname");
		enterLastName("QAtest");
		ExtentTestManager.getTest().pass("Enter the lastname");
		enterDOB("01/05/1994");
		ExtentTestManager.getTest().pass("Enter the dob");
		clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		clickNextButton();
		ExtentTestManager.getTest().pass("Next button is clicked");
		enterTheWhichSchoolDoYouWorkWithSchoolName();
		ExtentTestManager.getTest().pass("Enter the school_name");
		clickDoneButton();
		verifyGetReadyMessage();
		ExtentTestManager.getTest().pass("GetReadyMessage is verified");
		//clickCloseButton();
		//ExtentTestManager.getTest().pass("Click Close_Registration Button");
		waitInvisibilityOfLoadingIndicator();
		switchToMainPage();
		selectStonyBrookExperiene();
		ExtentTestManager.getTest().pass("Click on StonyBrook Experience");
		waits(10);
		clickExperienceClampButton();
		waits(10);
		//selectStonyBrookExperiene();
		clickScheduleVisitButton();
		closeAllTabsAndSwitchToMainTab(browser);
		clickNextStopArrow();
		closeNewTab(browser);
		System.out.println("Navigation Completed...");
	}
	
	public String launchAPIValidationGetResponse(String url) throws MalformedURLException, InterruptedException {
		String dataAnalytics = null;
		String auth = null;
		dataAnalytics =  getSessionUserKey();
		ExtentTestManager.getTest().pass(dataAnalytics.length()+" : "+dataAnalytics);
		auth = getMd5Hash();
		ExtentTestManager.getTest().pass("Auth token : "+ auth);
		return openAnalyticValidationURL(url, dataAnalytics, auth);
	}
	
	public void verifyAnalyticsSession(String response, String expectedGmtTime) {
		ExtentTestManager.getTest().pass("User launches experience, verifies analytics_session has new entry for userkey and loc_id with start_time = now");
		String[] sessionId;
		String[] startTime;
		sessionId = parseJsonString(response, "session", "id");
		ExtentTestManager.getTest().pass("Session ID : "+ sessionId[0]);
		startTime = parseJsonString(response, "session", "start_time");
		ExtentTestManager.getTest().pass("Session Sart Time : "+ startTime[0]);
		ExtentTestManager.getTest().pass("GMT Time Expected : "+ expectedGmtTime);
		if(startTime[0].contains(expectedGmtTime) && Integer.parseInt(sessionId[0])>0) {
			ExtentTestManager.getTest().pass("Passed_TC01 : There is a new entry for userkey and loc_id with start_time = now()");
		}else {
			ExtentTestManager.getTest().fail("Failed_TC01 : There is NO new entry for userkey and loc_id with start_time = now()");
		}
		
	}
	
	public void verifyAnalyticsActions(String response, String expectedGmtTime) {
		ExtentTestManager.getTest().pass("User clicks action button, verifies analytics_actions has new entry for userkey, loc_id, actionid with time = now()");
		String actionId[] = null;
		String createdTime[] = null;
		actionId = parseJsonString(response, "actions", "id");
		ExtentTestManager.getTest().pass("Actions ID : "+ actionId[0]);
		createdTime = parseJsonString(response, "actions", "create_date");
		ExtentTestManager.getTest().pass("Action Created Time : "+ createdTime[0]);
		ExtentTestManager.getTest().pass("GMT Time Expected : "+ expectedGmtTime);
		if(compareT1GreaterT2(createdTime[0], expectedGmtTime) && Integer.parseInt(actionId[0])>0) {
			ExtentTestManager.getTest().pass("Passed_TC02 : There is a new entry for userkey, loc_id, actionid with time = now()");
		}else {
			ExtentTestManager.getTest().fail("Failed_TC02 : There is NO new entry for userkey, loc_id, actionid with time = now()");
		}
	}
	
	public void verifyAnalyticsRegistration(String response, String expectedGmtTime) {
		ExtentTestManager.getTest().pass("User registrations to experience,Verifies analytics_registration contain new entry for userkey, loc_id with creation_time = now()");
		String[] registrationId = null;
		String[] creationTime = null;
		registrationId = parseJsonString(response, "registration", "id");
		ExtentTestManager.getTest().pass("Registration ID : "+ registrationId[0]);
		creationTime = parseJsonString(response, "registration", "creation_time");
		ExtentTestManager.getTest().pass("Registration Creation Time : "+ creationTime[0]);
		ExtentTestManager.getTest().pass("GMT Time Expected : "+ expectedGmtTime);		
		if(creationTime[0].substring(0,10).equalsIgnoreCase(expectedGmtTime) && Integer.parseInt(registrationId[0])>0) {
			ExtentTestManager.getTest().pass("Passed_TC03-RegistrationData contains new entry for userkey, loc_id with creation_time = now()");
		}else {
			ExtentTestManager.getTest().fail("Failed_TC03-RegistrationData does not contains any new entry for userkey, loc_id with creation_time = now()");
		}
	}
	
	public void verifyAnalyticsStops(String response, String expectedGmtTime) {
		ExtentTestManager.getTest().pass("User registrations to experience,Verifies analytics_registration contain new entry for userkey, loc_id with creation_time = now()");
		String[] stopIds = null;
		String[] startTimes = null;
		String[] endTimes = null;
		String firstStopId = null;
		String secondStopId = null;
		String firstStopStartTime = null;
		String secondStopStartTime = null;
		String firstStopEndTime = null;
		String secondStopEndTime = null;
		stopIds = parseJsonString(response, "stops", "stopid");
		startTimes = parseJsonString(response, "stops", "start_time");
		endTimes = parseJsonString(response, "stops", "end_time");
		int i;
		for(i=0;i<stopIds.length;i++)
			ExtentTestManager.getTest().pass("Stop-"+i+": Stop ID : "+ stopIds[i] + "; StartTime" + startTimes[i] + "; EndTime" + endTimes[i]);
		secondStopId = stopIds[1];
		secondStopStartTime  =  endTimes[1];
		secondStopEndTime =  endTimes[1];
		firstStopId	 = stopIds[0];
		firstStopStartTime  =  endTimes[0];
		firstStopEndTime  =  endTimes[0];
		ExtentTestManager.getTest().pass("GMT Time Expected : "+ expectedGmtTime);
		if(compareT1GreaterT2(firstStopStartTime, expectedGmtTime)&& compareT1GreaterT2(firstStopEndTime, expectedGmtTime)&&Integer.parseInt(firstStopId)>0) {
			if(compareT1GreaterT2(secondStopStartTime, expectedGmtTime)&& compareT1GreaterT2(secondStopEndTime, expectedGmtTime)&&Integer.parseInt(secondStopId)>0) 
				ExtentTestManager.getTest().pass("Passed_TC04-analytics_stops contain an entry for each stop with a start_time, end_time set based on how long user was in stop");
		}else {
			ExtentTestManager.getTest().fail("Failed_TC04-analytics_stops contain an entry for each stop with a start_time, end_time set based on how long user was in stop");
		}
	}
	
	public void verifyAnalyticsModules(String response, String expectedGmtTime) {
		ExtentTestManager.getTest().pass("This test case launches an experience, closes the experience and calculates the session length from start and end time and also checks that it is !=0");
		String[] sessionId;
		String[] startTime;
		sessionId = parseJsonString(response, "session", "id");
		ExtentTestManager.getTest().pass("Session ID : "+ sessionId[0]);
		startTime = parseJsonString(response, "session", "start_time");
		ExtentTestManager.getTest().pass("Session Sart Time : "+ startTime[0]);
		ExtentTestManager.getTest().pass("GMT Time Expected : "+ expectedGmtTime);
		if(compareT1GreaterT2(startTime[0], expectedGmtTime) && Integer.parseInt(sessionId[0])>0) {
			ExtentTestManager.getTest().pass("Passed_TC05 : There is a new entry for userkey and loc_id with start_time = now()");
		}else {
			ExtentTestManager.getTest().fail("Failed_TC05 : There is NO new entry for userkey and loc_id with start_time = now()");
		}
	}
	
	
	public boolean compareT1GreaterT2(String time1, String time2) {
		return convertStringToTimestamp(time1).before(convertStringToTimestamp(time2));
	}
	
	 public static Timestamp convertStringToTimestamp(String strDate) {
		    try {
		       // you can change format of date
		      Date date = sdf.parse(strDate);
		      Timestamp timeStampDate = new Timestamp(date.getTime());

		      return timeStampDate;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);
		      return null;
		    }
	}
}