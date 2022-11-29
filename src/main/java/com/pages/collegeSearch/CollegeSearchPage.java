package com.pages.collegeSearch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
import com.utils.ElementUtil;

public class CollegeSearchPage extends ObjectsControl implements PageInterface{
	WebDriver driver;
	ElementUtil eleUtils;
	@FindBy(xpath = "//h2[contains(text(),'Find the right college for you')]")
	WebElement collegeSearchHeader;
	@FindBy(xpath = "//div[contains(@class,'v-oval')]")
	WebElement collegeSearchYourAccountIcon;
	@FindBy(xpath = "//span[contains(text(),'Continue with Google')]")
	WebElement continueWithGoogleLink;
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailTextbox;
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextButton;
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordTextbox;
	@FindBy(xpath = "//span[contains(text(),'Continue with Email')]")
	WebElement continueWithEmailLink;
	@FindBy(xpath = "//h1[contains(text(),'Sign up to visit 1000s of schools on YouVisit')]")
	WebElement signupToVisit1000SchoolHeader;
	@FindBy(id = "virtualtour_iframe")
	WebElement virtualTouriframe;
	@FindBy(xpath = "//button[@value='parent_hs_grad']")
	WebElement highSchoolGraduateButton;
	@FindBy(xpath = "//input[@name='Search Colleges']")
	WebElement searchCollegesTextbox;
	@FindBy(xpath = "//button[@data-id='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//div[contains(text(),'Hofstra University')]")
	WebElement hofstraUniversityHeader;
	@FindBy(xpath = "//h2[contains(text(),'Top Most Visited Colleges')]")
	WebElement topMostVisitedCollegesHeader;
	@FindBys(@FindBy(xpath = "//button[contains(@class,'v-school')]"))
	List<WebElement> searchCollegeResult;
	@FindBy(xpath = "//div[contains(text(),'LIKES')]")
	WebElement likesHeader;
	@FindBy(xpath = "//div[contains(text(),'FILTERS')]")
	WebElement filtersHeader;
	@FindBy(xpath = "//span[contains(text(),'Institution ')]")
	WebElement institutionHeader;
	@FindBy(xpath = "//span[contains(text(),'Tuition ')]")
	WebElement tuitionHeader;
	@FindBy(xpath = "//input[@name='Search Colleges']")
	WebElement enteredCollegeOrUniversityName;
	@FindBy(xpath = "(//div[contains(text(),'All')]//preceding-sibling::div)[1]")
	WebElement institutionTypeAllCheckbox;
	@FindBy(xpath = "//button[@aria-label='Reset']")
	WebElement resetButton;
	@FindBy(xpath = "//div[contains(@class,'g-iconHolder')]")
	WebElement leftSideFunnelIcon;
	@FindBy(xpath = "//span[contains(text(),'Geography ')]")
	WebElement geographyHeader;
	@FindBy(xpath = "//div[contains(@class,'g-iconHolder')]")
	WebElement leftArrowIcon;
	@FindBy(xpath = "//input[@name='selectionInput']")
	WebElement geographyTextbox;
	@FindBys(@FindBy(xpath = "//input[@name='selectionInput']"))
	List<WebElement> optionsField;
	@FindBy(xpath = "(//div[contains(text(),'All')]//preceding-sibling::div)[2]")
	WebElement institutionYearAllCheckbox;
	@FindBy(xpath = "(//div[contains(text(),'All')]//preceding-sibling::div)[3]")
	WebElement institutionCampusSettingsAllCheckbox;
	@FindBy(xpath = "//span[contains(text(),'Enrollment')]")
	WebElement enrollmentHeader;
	@FindBy(xpath = "(//div[contains(@style,'margin')]//div[@id='0'])[3]/div[3]")
	WebElement searchedCollegeOrUniversity;
	@FindBy(xpath = "//div[contains(text(),'Two Year')]")
	WebElement institutionTwoYearOption;
	@FindBy(xpath = "//div[contains(text(),'Four Year')]")
	WebElement institutionFourYearOption;
	@FindBy(xpath = "//div[contains(text(),'Rural')]")
	WebElement campusSettingsRuralOption;
	@FindBy(xpath = "//div[contains(text(),'Suburb')]")
	WebElement campusSettingsSuburbOption;
	@FindBy(xpath = "//div[contains(text(),'Town')]")
	WebElement campusSettingsTownOption;
	@FindBy(xpath = "//div[contains(text(),'City')]")
	WebElement campusSettingsCityOption;
	@FindBy(xpath = "//div[text()='Public']")
	WebElement institutionPublicCheckbox;
	@FindBy(xpath = "//div[text()='Private']")
	WebElement institutionPrivateCheckbox;
	@FindBy(xpath = "//div[contains(text(),'Two Year')]")
	WebElement enrollmentLastValue;
	@FindBy(xpath = "//div[contains(text(),'Four Year')]")
	WebElement enrollmentFirstValue;
	@FindBy(xpath = "//div[text()='Public']")
	WebElement tuitionInStateFirstvalue;
	@FindBy(xpath = "//div[text()='Private']")
	WebElement tuitionInStateLastvalue;
	@FindBy(xpath = "//div[contains(text(),'Town')]")
	WebElement tuitionOutOfStateFirstvalue;
	@FindBy(xpath = "//div[contains(text(),'City')]")
	WebElement tuitionOutOfStateLastvalue;
	@FindBy(xpath = "(//input[@name='selectionInput']/parent::div/following::div[2]/div)[1]")
	WebElement geographyOption;
	@FindBy(xpath = "//input[@value='1 State/Territory']")
	WebElement oneStateOrTerritorySelectedMessage;
	@FindBy(xpath = "//span[contains(text(),'Geography (1)')]")
	WebElement geographyCount;
	@FindBy(xpath = "(//span[text()='Select All'])[3]")
	WebElement institutionTypeSelectAllButton;
	@FindBy(xpath = "(//span[text()='Clear'])[1]")
	WebElement clearButton;

	@FindBy(xpath = "//input[@id='handleTwo' and @value='60000']")
	WebElement enrollmentLastValuee;
	@FindBy(xpath = "(//input[@id='handleOne' and @value='0'])[1]")
	WebElement enrollmentFirstValuee;
	@FindBy(xpath = "(//input[@id='handleOne' and @value='0'])[2]")
	WebElement tutionInStateFirstvalue;
	@FindBy(xpath = "(//input[@id='handleTwo' and @value='80000'])[1]")
	WebElement tutionInStateLastvalue;
	@FindBy(xpath = "(//input[@id='handleOne' and @value='0'])[3]")
	WebElement tutionOutOfStateFirstvalue;
	@FindBy(xpath = "(//input[@id='handleTwo' and @value='80000'])[2]")
	WebElement tutionOutOfStateLastvalue;
	@FindBy(xpath = "//button[.='Enter']")
	WebElement enterButton;
	@FindBy(xpath = "//label[contains(text(),'Select up to 10 colleges that you are interested in')]")
	WebElement selectUpTo10CollegesHeader;
	@FindBy(xpath = "//input[@placeholder='Search schools']")
	WebElement searchSchoolTextbox;
	@FindBys(@FindBy(xpath = "//div[contains(@id,'downshift')]"))
	List<WebElement> SchoolNameOptions;
	@FindBy(xpath = "(//span[text()='Like'])[1]")
	WebElement likeButton;
	@FindBy(xpath = "(//span[text()='Like'])[1]/parent::button/parent::div/following-sibling::div[1]")
	WebElement collegeName;
	@FindBy(xpath = "//div[contains(@class,'u-schoolName')]")
	WebElement likesCollegeName;
	@FindBy(xpath = "//span[text()='Liked']")
	WebElement likedButton;
	@FindBy(xpath="//input[@name='schools_interested']")
	WebElement searchTenCollegesTxtBx;
	@FindBy(xpath="//span[contains(@class,'Component-flexPill')]/span[1]")
	WebElement schoolsList;
	@FindBys(@FindBy(xpath= "//label[text()='Select up to 10 colleges that you are interested in']//following::div//span[contains(@class,'Component-flexPill')]"))
	List<WebElement> selectedColleges;
	@FindBy(xpath = "//p[text()='You did it!']")
	WebElement youDidItMessage;
	@FindBy(xpath = "//a[contains(text(),'California Privacy Notice; Sale Opt Out')]")
	WebElement californiaPrivacyNoticeLink;
	@FindBy(xpath = "//label[contains(text(),'CHILD')]/following-sibling::input[@type='email']")
	WebElement childEmailTextbox;
	@FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
	WebElement dobField;
	@FindBy(xpath = "//span[contains(text(),'Institution Type')]")
	WebElement institutionTypeHeader;

	public CollegeSearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		eleUtils = new ElementUtil(driver);
	}
	public void verifyTuitionHeader() throws Exception {
		isPresentAndVisible(tuitionHeader);
	}
	public void verifyLikesHeader() throws Exception {
		isPresentAndVisible(likesHeader);
	}
	public void verifyFiltersHeader() throws Exception {
		isPresentAndVisible(filtersHeader);
	}
	public void verifyInstitutionHeader() throws Exception {
		isPresentAndVisible(institutionHeader);
	}
	public void verifyHofstraUniversityHeader() throws Exception {
		isPresentAndVisible(hofstraUniversityHeader);
	}
	public void verifTopMostVisitedCollegesHeader() throws Exception {
		isPresentAndVisible(topMostVisitedCollegesHeader);
	}
	public void navigateCollegeSearchPage(String url) throws Exception {
		deleteAllCookies();
		deleteAllCookies();
		driver.get(url);
	}
	public void enterCollegesNameAndSearch(String Value) throws Exception {

		type(searchCollegesTextbox, Value);
		clickWithJavaScript(searchButton);
		Thread.sleep(1000);
	}
	public void switchToTheVirtualtourFrame() throws Exception {
		switchToFrame(virtualTouriframe);
	}
	public void verifyCollegeSearchHeader() throws Exception {
		isPresentAndVisible(collegeSearchHeader);
	}
	public void clickCollegeSearchYourAccountIcon() throws Exception {
		clickWithJavaScript(collegeSearchYourAccountIcon);
	}
	public void clickContinueWithGoogleLink() throws Exception {
		clickWithJavaScript(continueWithGoogleLink);
		waits(2);
	}
	public void verifySignupToVisit1000SchoolHeader() throws Exception {
		isPresentAndVisible(signupToVisit1000SchoolHeader);
	}
	public void enterGmailCredentialAndLogin() throws Exception {
		waits(2);
		int previousSize = eleUtils.doGetWindowHandles().size();
		String firstHandle = eleUtils.doGetCurrentWindow();
		System.out.println("previous size is " +previousSize);
		//switchWindow(firstHandle);
		eleUtils.doGetChildWindow(1);
		WebElement languageDropdown = waitForAndFindElementByLocator(By.xpath("//div[@id='lang-chooser']/div/div"));
		click(languageDropdown);
		click(waitForAndFindElementByLocator(By.xpath("(//span[contains(text(),'English (United Kingdom')])[2]")));
		isPresentAndVisible(nextButton);
		waitAndFindElementByVisibility(emailTextbox);
		type(emailTextbox, "yvconnector@gmail.com");
		clickWithJavaScript(nextButton);
		isPresentAndVisible(nextButton);
		waitAndFindElementByVisibility(passwordTextbox);
		type(passwordTextbox, "Cactus#930");
		clickWithJavaScript(nextButton);
		eleUtils.doGetParentWindow();
	}
	public void mouseHoverHighSchoolGraduateButton() throws Exception {
		mouseHoverElement(highSchoolGraduateButton);
	}
	public void clickContinueWithEmailLink() throws Exception {
		clickWithJavaScript(continueWithEmailLink);
	}
	public String enterCollegeOrUniversity() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String searchString = "sch";
		clickWithJavaScript(searchCollegesTextbox);
		type(searchCollegesTextbox,searchString);
		optionSize = searchCollegeResult.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			clickWithJavaScript(waitForAndFindElementByLocator(By.xpath("(//button[contains(@class,'v-school')])["+optionNo+"]")));

		} else {
			sendModifierKeys(Keys.TAB);
		}
		return searchCollegesTextbox.getAttribute("value");
	}

	public void clickInstitutionTypeAllCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionTypeAllCheckbox);
	}
	public void verifyResetButton() throws Exception 
	{
		isPresentAndVisible(resetButton);
	}
	public void verifyGeographyHeader() throws Exception 
	{
		isPresentAndVisible(geographyHeader);
	}
	public void clickLeftArrowIcon() throws Exception {
		clickWithJavaScript(leftArrowIcon);
	}
	public void verifyLeftSideFunnelIcon() throws Exception {
		isPresentAndVisible(leftSideFunnelIcon);
	}
	public void clickLeftSideFunnelIcon() throws Exception {
		clickWithJavaScript(leftSideFunnelIcon);
	}
	public void verifyLeftArrowIcon() throws Exception {
		isPresentAndVisible(leftArrowIcon);
	}
	public void verifyResetButtonIsnotVisible() throws Exception {	
		try 
		{
			isPresentAndVisible(resetButton);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().pass("Reset button is Not visible");
		}
	}
	public void clickInstitutionYearAllCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionYearAllCheckbox);
	}
	public void clickInstitutionCampusSettingsAllCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionCampusSettingsAllCheckbox);
	}
	public void verifyEnrollmentHeader() throws Exception {
		isPresentAndVisible(enrollmentHeader);
	}

	public void enterTheGeograoghyName() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		int value = r.nextInt(26) + 'a';
		clickWithJavaScript(geographyTextbox);
		type(geographyTextbox,Integer.toString(value));
		optionSize = optionsField.size();
		if(optionSize > 0) {
			int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
			clickWithJavaScript(waitForAndFindElementByLocator(By.xpath("(//div[contains(@class,'Component-whiteBox-')])["+optionNo+"]")));
		} else {
			sendModifierKeys(Keys.TAB);
		}
	}
	public void verifySearchedCollegeOrUniversityResult() throws Exception {
		String enteredName = searchCollegesTextbox.getAttribute("value");
		System.out.println("Entered Name = "+ enteredName);
		String searchedResult = getText(searchedCollegeOrUniversity);
		System.out.println("Searched Name = "+ searchedResult);
		if(enteredName.equalsIgnoreCase(searchedResult));
		{
			ExtentTestManager.getTest().pass("Results are matched");
		}
	}
	public void clickInstitutionTypePublicCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionPublicCheckbox);
		ExtentTestManager.getTest().pass("Institution public checkbox is clicked");
	}
	public void clickInstitutionTypePrivateCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionPrivateCheckbox);
		ExtentTestManager.getTest().pass("Institution private checkbox is clicked");
	}
	public void clickInstitutionTypeTwoYearOptionCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionTwoYearOption);
		ExtentTestManager.getTest().pass("Institution two year checkbox is clicked");
	}
	public void clickInstitutionTypeFourYearOptionCheckbox() throws Exception 
	{
		clickWithJavaScript(institutionFourYearOption);
		ExtentTestManager.getTest().pass("Institution four year checkbox is clicked");
	}
	public void clickCampusSettingsRuralCheckbox() throws Exception 
	{
		clickWithJavaScript(campusSettingsRuralOption);
		ExtentTestManager.getTest().pass("Rural checkbox is clicked");
	}
	public void clickCampusSettingsSuburbCheckbox() throws Exception 
	{
		clickWithJavaScript(campusSettingsSuburbOption);
		ExtentTestManager.getTest().pass("Suburb checkbox is clicked");
	}
	public void clickCampusSettingsTownCheckbox() throws Exception 
	{
		clickWithJavaScript(campusSettingsTownOption);
		ExtentTestManager.getTest().pass("Town checkbox is clicked");
	}
	public void clickCampusSettingsCityCheckbox() throws Exception 
	{
		clickWithJavaScript(campusSettingsCityOption);
		ExtentTestManager.getTest().pass("City checkbox is clicked");
	}
	public void clickEnrollmentField() throws Exception 
	{
		clickWithJavaScript(enrollmentLastValue);
		//scrollToElement(tutionOutOfStateFirstvalue);
		//dragAndDrop(enrollmentFirstValuee, enrollmentLastValuee);
		
		ExtentTestManager.getTest().pass("Enrollment value is clicked");
		ExtentTestManager.getTest().pass("Enrollment horizontal bar value is changed");
	}
	
	public void clickAndChangeTheTuitionInstateField() throws Exception 
	{
		clickWithJavaScript(tuitionInStateFirstvalue);
		ExtentTestManager.getTest().pass("Tuition value is clicked");
		ExtentTestManager.getTest().pass("Tuition instate horizontal bar value is changed");
	}
	public void clickAndChangeTheTuitionOutOfStatesField() throws Exception 
	{
		clickWithJavaScript(tuitionOutOfStateFirstvalue);
		ExtentTestManager.getTest().pass("Tuition value is clicked");
		ExtentTestManager.getTest().pass("Tuition out of state horizontal bar value is changed");
	}
	public void enterGeograoghyName() throws Exception {
		clickWithJavaScript(geographyTextbox);
		type(geographyTextbox,"Maine");
		clickWithJavaScript(geographyOption);		
		ExtentTestManager.getTest().pass("Geography name is entered");
	}
	public void verifyOneStateOrTerritorySelectedMessage() throws Exception 
	{
		isPresentAndVisible(oneStateOrTerritorySelectedMessage);
	}
	public void verifyGeographyCount() throws Exception 
	{
		isPresentAndVisible(geographyCount);
	}
	public void clickAndVerifySelectAllButton() throws Exception 
	{
		waits(2);
		scrollToElement(institutionHeader);
		mouseHoverElement(institutionHeader);
		clickWithJavaScript(institutionTypeSelectAllButton);
		ExtentTestManager.getTest().pass("Select all button is clicked");
	}
	public void verifyClearButton() throws Exception 
	{
		clickWithJavaScript(clearButton);
		ExtentTestManager.getTest().pass("Clear button is clicked and  verified");
	}
	public void clickEnterButton() throws Exception {
		//waitAndFindElementByVisibility(enterButton);
		clickWithJavaScript(enterButton);
		ExtentTestManager.getTest().pass("Enter button is clicked");
		waits(2);
	}
	public void verifySelectUpTo10CollegesHeader() throws Exception 
	{
		isPresentAndVisible(selectUpTo10CollegesHeader);
		ExtentTestManager.getTest().pass("Select up to 10 colleges that you are interested in header is verified");

	}
	public void enterTheWhichSchoolDoYouWorkWithSchoolName() throws Exception {

		Random r = new Random();
		int optionSize = 0;
		String input= "eng";
		//int index = r.nextInt(input.length);
		//int index =0;
		clickWithJavaScript(searchTenCollegesTxtBx);
		type(searchTenCollegesTxtBx, input);
		optionSize = SchoolNameOptions.size();
		{
			if(optionSize > 0) {
				int optionNo = ThreadLocalRandom.current().nextInt(1, optionSize + 1);
				clickWithJavaScript(waitForAndFindElementByLocator(By.xpath("//div[contains(@id,'downshift')]["+optionNo+"]")));
				waits(2);
			}
			else {
				sendModifierKeys(Keys.TAB);
			}}
	}
	public void clickLikeButton() throws Exception 
	{
		//waits(1000);
		waitAndFindElementByVisibility(likeButton);
		clickWithJavaScript(likeButton);
		ExtentTestManager.getTest().pass("Like button is clicked");
	}

	public void clickLikeButtonAndCompareActualLikesResultWithLikedCollegeName() throws Exception {
		String likedCollegeName = getText(collegeName);
		ExtentTestManager.getTest().pass("Like the College "+ likedCollegeName);
		waitAndFindElementByVisibility(likeButton);
		clickWithJavaScript(likeButton);
		ExtentTestManager.getTest().pass("Like button is clicked for the "+ likedCollegeName);		
		String likedResult = getText(likesCollegeName);
		ExtentTestManager.getTest().pass(likedResult + " appears under LIKES section on the left side above Filters section");
		if(likedCollegeName.equalsIgnoreCase(likedResult)){
			ExtentTestManager.getTest().pass("Verified likes icon selected for the institute " + likedCollegeName + " and the same institute name appeared above the Filter section");
		}
	}
	public void enterTheWhichSchoolDoYouWorkWithSchoolNames() throws Exception {
		Random r = new Random();
		int optionSize = 0;
		String[] input= {"uni", "sch"};
		int index = r.nextInt(input.length);
		clearTypeKeys(searchTenCollegesTxtBx, input[1]);
		optionSize = SchoolNameOptions.size();
		System.out.println("optionSize = "+optionSize);

		int selectionSize = 0;
		System.out.println("selectionSize = "+selectionSize);
		String collegeName;
		boolean flag = false;
		selectionSize = selectedColleges.size();
		int increment = 2;
		int count = 0;
		while(selectionSize < 10)
		{
			optionSize = SchoolNameOptions.size();
			System.out.println("optionSize = "+optionSize);
			selectionSize = selectedColleges.size();
			System.out.println("selectionSize = "+selectionSize);
			if(optionSize > 0) 
			{
				int optionNo = increment;
				WebElement options = waitForAndFindElementByLocator(By.xpath("(//input[@name='schools_interested']//following::div/div/following-sibling::div)["+optionNo+"]"));

				collegeName = options.getText();
				System.out.println("College Name = "+collegeName);
				if(selectionSize>0)
					flag = Arrays.asList(getSelectedCollegeName(selectionSize)).contains(collegeName);
				if(!flag)
				{
					//waitAndFindElementByVisibility(options);
					clickWithJavaScript(options);
					count++;
					ExtentTestManager.getTest().pass(collegeName+" is selected for 10 interested colleges field");
					waits(1);
				}
				selectionSize = selectedColleges.size();
				System.out.println("selectionSize = "+selectionSize);
			} 
			flag = false;
			increment++;
			if(count<5)
				index=1;
			else if(count>5)
				index = 0;
			if(selectionSize<10)				
				clearTypeKeys(searchTenCollegesTxtBx, input[index]);
			waits(2);
			if(increment>5 && selectionSize<10)
				increment=1;
		}	
		verifyTenCollegesTextBoxDisplayed();
	}

	public boolean verifyTenCollegesTextBoxDisplayed()
	{
		try
		{
			waitForElementInvisibility(searchTenCollegesTxtBx);
			ExtentTestManager.getTest().pass("The 10 interested colleges entry textbox appears as expected");
			return true;
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().pass(" After 10 interested colleges entry the textbox disappears as expected");
		}
		return false;
	}
	public String[] getSelectedCollegeName(int noOfCollege){
		//String[] collegesList = new String[noOfCollege];
		String[] collegesList = null;
		collegesList = new String[noOfCollege];
		for (int i = 1; i<noOfCollege; i++)
			collegesList[i] =  waitForAndFindElementByLocator(By.xpath("(//label[text()='Select up to 10 colleges that you are interested in']//following::div//span[contains(@class,'Component-flexPill')])["+i+"]")).getText();

		//collegesList[i] =  waitForAndFindElementByLocator(By.xpath("(//label[@id='downshift-0-label']//following::div//span[contains(@class,'Component-pill')])["+i+"]")).getText();
		return collegesList;
	}
	public void verifyYouDisItMessage() throws Exception {
		isPresentAndVisible(youDidItMessage);
	}
	public void switchToTheTabWithCollegeSearcgUrl() throws Exception {
		switchToTabWithUrl("https://staging.youvisit.com/collegesearch/");
	}
	public void verifyCaliforniaPrivacyNoticeLink() throws Exception 
	{
		isPresentAndVisible(californiaPrivacyNoticeLink);
		ExtentTestManager.getTest().pass("California Privacy Notice Link is verified");
	}
	public void enterChildEmail(String email) throws Exception {
		isPresentAndVisible(childEmailTextbox);
		clearTypeKeys(childEmailTextbox, email);
	}
	public void scrollToDOB() throws Exception {
		scrollToElement(dobField);
	}
	public void verifyLikedButton() throws Exception {
		isPresentAndVisible(likedButton);
		ExtentTestManager.getTest().pass("Liked button is verified");
		//waits(2000);
	}
	public void clickLikedButton() throws Exception 
	{
		clickWithJavaScript(likedButton);
		ExtentTestManager.getTest().pass("Liked button is clicked");
	}
	public void verifyLikeButton() throws Exception {
		isPresentAndVisible(likeButton);
		ExtentTestManager.getTest().pass("Like button is verified");
	}
}