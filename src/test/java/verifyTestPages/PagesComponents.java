package verifyTestPages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.pages.AAPLeftFilterPage;
import com.pages.Page;
import com.pages.aap.AAPAnalyticsPage;
import com.pages.aap.AAPExperienceInsightPage;
import com.pages.aap.AAPExplorePage;
import com.pages.aap.AAPListPage;
import com.pages.aap.AAPLoginPage;
import com.pages.collegeSearch.CollegeSearchPage;
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.superContent.SuperContentPages;
import com.tests.BaseTest;
import com.tests.apiAnalyticsTests.AnalyticsNavigationPages;
import com.utils.ElementUtil;

public class PagesComponents extends BaseTest{
	
	AAPLoginPage loginPage = null;
	AAPListPage listPage = null;
	AAPLeftFilterPage filterPage = null;
	AAPExperienceInsightPage insightPage = null;
	SuperContentPages superContentPage = null;
	AnalyticsNavigationPages analyticsNavigationPage = null;
	
	String colurl;
	CollegeSearchPage collegeSearchPage = null;
	OtherPage collegeSearchProspectivePage = null;
	DesktopCIFLoginPage collegeSearchOptionsPage= null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	ParentAndGuardianPage parentAndGuardianPage = null;
	
	ElementUtil eUtil = null;
	Page page = null;
	String url; 
	String vtURL;
	JavascriptExecutor js = null;
	JavascriptExecutor jse = null;
	
	@FindBy(css = "div[class* = 'tableDiv'")
 	WebElement exploreInquiriesTable;
	
	@FindBys(@FindBy(xpath = "//div[@data-test='Thumbnail']"))
	List<WebElement> videoThumbnails;
	
	@FindBy(xpath = "//div[contains(@class,'h-dropdown-')]")
 	WebElement universityNameDropdownOptions;
	
	@FindBy(xpath = "//div[contains(@class,'vjs-playing')]")
 	WebElement videoPlaying;
	
	@FindBy(xpath="//input[@name='schools_interested']")
	WebElement searchTenCollegesTxtBx;
	
	@BeforeClass
	public void classSetUp() throws Exception {
		url = prop.getProperty("cloud_env")+prop.getProperty("url_aap");
		vtURL = prop.getProperty("env1")+prop.getProperty("url_vt");
		loginPage = new AAPLoginPage(remoteDriver);
		insightPage = new AAPExperienceInsightPage(remoteDriver);
		superContentPage = new SuperContentPages(remoteDriver);
		analyticsNavigationPage = new AnalyticsNavigationPages(remoteDriver);
		eUtil = new ElementUtil(remoteDriver);
		filterPage = new AAPLeftFilterPage(remoteDriver);
		listPage = new AAPListPage(remoteDriver);
		page = new Page(remoteDriver);
		js=(JavascriptExecutor)remoteDriver;
		jse=(JavascriptExecutor)remoteDriver;
		
		colurl = prop.getProperty("staging_env")+prop.getProperty("college_search");
		collegeSearchPage = new CollegeSearchPage(remoteDriver);
		collegeSearchProspectivePage = new OtherPage(remoteDriver);
		collegeSearchOptionsPage = new DesktopCIFLoginPage(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		parentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
	}
	
	public void navigateToAAPLoginpage() {
		loginPage.navigateToAAPLogin(url);
	}
	
	public void navigateAndLoginToAAP() throws Exception {
		loginPage.navigateToAAPLogin(url);
		loginPage.loginExperienceInsight(prop.getProperty("aap_username"), prop.getProperty("aap_password"));
	}
	
	public void loginWithEabSSO() throws Exception {
		loginPage.verifyEabSsoLoginBtn();
		loginPage.clickEabSsoLoginBtn();
		loginPage.verifySssoPage();
	}
	
	public void signInWithMicrosoftAccount() throws Exception {
		loginPage.verifyMicrosoftSignInBtn();
		loginPage.clickMicrosoftSignInBtn();
		loginPage.submitMicrosoftCredentials();
		insightPage.verifyInsightsPageTitle();
		insightPage.waitForInsightsPageToLoad();
		insightPage.verifyProfileIcon();
	}
	
	public void signInWithGoogleAccount() throws Exception {
		loginPage.verifyGoogleSignInBtn();
		loginPage.clickGoogleSignInnBtn();
		loginPage.submitGoogleCredentials();		
	}
	
	public void verifyImageHotspot() throws InterruptedException {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[0].click()");
		ExtentTestManager.getTest().pass("Click on \'Image Hotspot\'");
		page.waitFor(3);
		js.executeScript("var meshes = get2DHitMeshes(); meshes[0].click()");
		ExtentTestManager.getTest().pass("Verify 'Image Hotpot' elements are displayed");		
	}
	
	public void verifyVideoHotspot() {
		js.executeScript("var meshes = $$$.getHitMeshes(); meshes[2].click()");
	}
	
	public void verifyPlayPauseMedia() {
		js.executeScript("var meshes = $$$.getHitMeshes(); meshes[0].click()");
	}
	
	public void verify360Hotspot() {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[1].click()");
	}
	
	public void verifyPlayPauseMediaInRenaissancehotelsEmpireSuite() {
		js.executeScript("var meshes = get2DHitMeshes(); meshes[1].click()");
	}
	
	public void addColumnNamesForHrizontalScrollBar() throws Exception {
		insightPage.waitForInsightsPageToLoad();
		filterPage.selectRecency();
		System.out.println("Modified the recency filter to 365 days, Since no results available for 7 days");
		insightPage.waitForInsightsPageToLoad();
		listPage.clickConfigurationSettingsButton();
		try {
			listPage.getCheckedSpecificColumnNameChkBxElement("Gender");
			listPage.clickRevertToDefaultButton();
			listPage.clickApplyButton();
			listPage.clickConfigurationSettingsButton();
		}catch(Exception e) {
			//	listPage.clickConfigurationSettingsButton();
			System.err.println("Horizontal Scroll not enabled So selecting one more column Name...");
		}	
		listPage.clickUncheckedFieldConfigurationColumnNameChkBx("Gender");
		listPage.clickApplyButton();
	}
	
	public void scrollHorizontalLeft()  throws Exception {
		String jscript = "document.querySelector(\"div[class*='tableDiv']\").scrollLeft=1000";
		Thread.sleep(3000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");	
		js.executeScript(jscript);
		Thread.sleep(10000);
	}
	
	public void dragAndDropColumnName() throws Exception {
		page.waitForInsightsPageToLoad();
		listPage.clickConfigurationSettingsButton();
		WebElement draggableElement = listPage.getCheckedSpecificColumnNameChkBxElement("Date Registered");
		WebElement dropAboveToTheElement = listPage.getCheckedSpecificColumnNameChkBxElement("Intended Major");
		String [] columnNames = {"Date Registered" , "Intended Major"};
		listPage.verifyCheckedColumnNameList(columnNames);
		int xOffsetDrag = draggableElement.getLocation().getX();
		int yOffsetDrag = draggableElement.getLocation().getY();
		int xOffsetDrop = dropAboveToTheElement.getLocation().getX();
		int yOffsetDrop = dropAboveToTheElement.getLocation().getY();
		xOffsetDrop = (xOffsetDrop-xOffsetDrag)+10;
		yOffsetDrop = (yOffsetDrop-yOffsetDrag)+20;
		Actions builder = new Actions(remoteDriver);
		builder.dragAndDropBy(draggableElement, xOffsetDrop,yOffsetDrop).perform();	
		page.waitFor(5);
		listPage.clickCreateNewRadioButton();
		listPage.clickCancelButton();
	}
	
	
	
	public void selectUniversity() throws Exception {
		//click(universityNameDropdownOptions);
	}
	
	@Test
	@Parameters({"browser"})
	public void verifyDragAndDrop(@Optional("IamOptional")String browser) throws Exception {
		navigateAndLoginToAAP();
		dragAndDropColumnName();
	}
	
	@Test
	@Parameters({"browser"})
	public void VerifyEabSSOLogin(@Optional("IamOptional")String browser) throws Exception {
		navigateToAAPLoginpage();
		loginWithEabSSO();
	}
	
	@Test
	@Parameters({"browser"})
	public void verifyMicrosftSignIn(@Optional("IamOptional")String browser) throws Exception {
		navigateToAAPLoginpage();
		signInWithMicrosoftAccount();
	}

	@Test
	@Parameters({"browser"})
	public void verifyGoogleSignIn(@Optional("IamOptional")String browser) throws Exception {
		navigateToAAPLoginpage();
		signInWithGoogleAccount();
	}
	
	@Test
	@Parameters({"browser"})
	public void verifyHorizontalScroll(@Optional("IamOptional")String browser) throws Exception {
		navigateAndLoginToAAP();
		addColumnNamesForHrizontalScrollBar();
		scrollHorizontalLeft();
	}
	
	@Test
	@Parameters({"browser"})
	public void verifyVedio(@Optional("IamOptional")String browser) throws Exception {
		page.navigateToVT(vtURL);
		ExtentTestManager.getTest().pass("Browser Launched and navigate to Url - "+vtURL);
		superContentPage.clickCloseRegistrationIcon();
		//page.waitInvisibilityOfLoadingIndicator();
		superContentPage.clickFirstTourOnExperience();
		page.waitInvisibilityOfLoadingIndicator();
		page.waits(15l);
		//superContentPage.clickAccessibilityButton(browser);
		analyticsNavigationPage.clickSupplimentVideo();
		
		Object s = jse.executeScript("document.getElementsByTagName('video')");
		System.out.println(s);
		int i;
		for(i=0;i<=33;i++) {
			String j = Integer.toString(i);
			page.waits(2);
			jse.executeScript("document.getElementsByTagName('video')["+j+"].onplay = function(){console.log('playing')}");
		    page.waits(2000);
		    jse.executeScript("document.getElementsByTagName('video')["+j+"].onpause = function(){console.log('pause')}");
		    j=Integer.toString(i+1);
		    page.waits(2000);
		    analyticsNavigationPage.scrollToVideo(analyticsNavigationPage.getVideoElement(j));
		    page.waits(2000);
		    System.out.println("Playing Video Number = "+j);
		    ExtentTestManager.getTest().pass("Playing Video Number = "+j);
		    analyticsNavigationPage.clickVideo(j);
		    analyticsNavigationPage.verifyVideoPlaying();
		    page.waits(2000);
		    ExtentTestManager.getTest().pass("Pausing Video Number = "+j);
		    analyticsNavigationPage.clickVideo(j);
		    analyticsNavigationPage.verifyVideoPause();
		}
	}
	
	public void clickSupplimentVideo1() throws Exception {
		page.waits(10l);
		eUtil.doClick(By.xpath("(//div[@data-test='Thumbnail'])[1]"));
	}
	
	@Test   
	@Parameters({"browser"})
	public void TC3_VerifyCollegeSearchOtherButtonOptions(@Optional("IamOptional")String browser) throws Exception	{
		System.err.println("["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("["+browserName+"]", ExtentColor.RED));
		Map<String, String> setData = collegeSearchProspectivePage.setData();
		collegeSearchPage.navigateCollegeSearchPage(colurl);
		ExtentTestManager.getTest().pass("College Search page is opened");
		collegeSearchPage.clickCollegeSearchYourAccountIcon();
		ExtentTestManager.getTest().pass("College Search your account icon is clicked");
		collegeSearchPage.clickContinueWithEmailLink();
		ExtentTestManager.getTest().pass("Continue with email link is clicked");
		collegeSearchPage.switchToTheVirtualtourFrame();
		collegeSearchProspectivePage.clickOtherButton();
		ExtentTestManager.getTest().pass("other_button is clicked");
//		collegeSearchProspectivePage.clickCounselorButton();
//		ExtentTestManager.getTest().pass("counselor_btn is clicked");
		collegeSearchProspectivePage.clickGeneralVisitorButton();
		ExtentTestManager.getTest().pass("GeneralVisitorButton is clicked");
		collegeSearchProspectivePage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		collegeSearchProspectivePage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		collegeSearchProspectivePage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		collegeSearchPage.clickEnterButton();
		//collegeSearchPage.getShcoolNameText();
	
	}


}