package com.tests.imap;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.desktopCIF.DesktopCIFLoginPage;
import com.pages.desktopCIF.OtherPage;
import com.pages.desktopCIF.ParentAndGuardianPage;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.imap.ImapPage;
import com.tests.BaseTest;

public class ImapTest extends BaseTest{
	String url;
	String maristURL;
	ImapPage imapPage = null;
	ObjectsControl objectControl = null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	DesktopCIFLoginPage cifLogin = null;
	OtherPage imapOtherPage = null;
	ParentAndGuardianPage parentAndGuardianPage = null;
	String urlImap;

	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_vt1");
		imapPage = new ImapPage(remoteDriver);
		objectControl = new ObjectsControl(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);	
		cifLogin = new DesktopCIFLoginPage(remoteDriver);
		imapOtherPage = new OtherPage(remoteDriver);
		parentAndGuardianPage = new ParentAndGuardianPage(remoteDriver);
		maristURL = prop.getProperty("env1")+"/tour/map/marist";
		urlImap = prop.getProperty("env1")+prop.getProperty("url_imap");
	}

	@Test   
	@Parameters({"browser"})  
	public void IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching");
		//ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC01_Desktop_InteractiveMap_VerifyLaunching", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP1_TC01_Desktop_InteractiveMap_VerifyLaunching ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLink");
		imapPage.verifyMapMinArrowButton();
		ExtentTestManager.getTest().pass("MapMinArrowButton is verified");
		imapPage.mouseHoverInteractiveMapButton();	
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map full screen Button");
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map exit full screen Button");
		imapPage.clickInteractiveMapButton();
		ExtentTestManager.getTest().pass("Click Interactive Map Button");
		imapPage.switchToTheNewTab();
		imapPage.clickShareIcon();
		ExtentTestManager.getTest().pass("Click on share Button");
		imapPage.verifyShareChainIcon();
		ExtentTestManager.getTest().pass("ShareChainIcon is verified");
		imapPage.verifyShareTwitterIcon();
		ExtentTestManager.getTest().pass("ShareTwitterIcon is verified");
		imapPage.verifyShareFacebookIcon();
		ExtentTestManager.getTest().pass("ShareFacebookIcon is verified");
		imapPage.verifySharePinterestIcon();
		ExtentTestManager.getTest().pass("SharePinterestIcon is verified");
		imapPage.navigateToMaristUrl(maristURL);
		imapPage.clickGoogleMapField();
		ExtentTestManager.getTest().pass("Click on Google Map Button");
		imapPage.clickCampusMapField();
		ExtentTestManager.getTest().pass("Click on Campus Green to select");
		imapPage.goToMainTabCloseOtherTabs(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void IMAP2_TC02_DesktopInteractiveMapVerifyDestinationSideBar(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP2_TC02_Desktop_InteractiveMap_VerifyDestinationSideBar ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP2_TC02_Desktop_InteractiveMap_VerifyDestinationSideBar");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_Desktop_InteractiveMap_VerifyDestinationSideBar", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP2_TC02_Desktop_InteractiveMap_VerifyDestinationSideBar ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP2_TC02_Desktop_InteractiveMap_VerifyDestinationSideBar ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		imapPage.verifyMapMinArrowButton();
		ExtentTestManager.getTest().pass("VerifyMapMinArrowButton is verified");
		imapPage.mouseHoverInteractiveMapButton();	
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map full screen Button");
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map exit full screen Button");
		imapPage.clickInteractiveMapButton();
		ExtentTestManager.getTest().pass("Click Interactive Map Button");
		imapPage.switchToTheNewTab();
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsList();
		imapPage.goToMainTabCloseOtherTabs(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void IMAP3_TC03_Desktop_InteractiveMap_VerifyVisitedStatus(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP3_TC03_Desktop_InteractiveMap_VerifyVisitedStatus ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP2_TC02_Desktop_InteractiveMap_VerifyDestinationSideBar");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_Desktop_InteractiveMap_VerifyVisitedStatus", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP3_TC03_Desktop_InteractiveMap_VerifyVisitedStatus ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP3_TC03_Desktop_InteractiveMap_VerifyVisitedStatus ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		prospectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLink");
		imapPage.verifyMapMinArrowButton();
		ExtentTestManager.getTest().pass("VerifyMapMinArrowButton is verified");
		imapPage.mouseHoverInteractiveMapButton();	
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map full screen Button");
		imapPage.clickInteractiveMapFullScreenButton();
		ExtentTestManager.getTest().pass("Click Interactive Map exit full screen Button");
		imapPage.clickInteractiveMapButton();
		ExtentTestManager.getTest().pass("Click Interactive Map Button");
		imapPage.switchToTheNewTab();
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");	
		String colour1=imapPage.destinationsListOption4ColorBeforeClick("color");
		System.out.println("colour1 "+colour1);
		imapPage.clickDestinationsListOption4();
		ExtentTestManager.getTest().pass("Click on Destinations list4");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");	
		String colour2=imapPage.destinationsListOption4ColorAfterClick("color");
		System.out.println("colour2 "+colour2);
		if(colour1==colour2) 
			ExtentTestManager.getTest().fail("Visual state does not change upon selection");
		else 
			ExtentTestManager.getTest().pass("Visual state change upon selection");
		imapPage.goToMainTabCloseOtherTabs(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void IMAP4_TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP4_TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP4_TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP4_TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP4_TC04_Desktop_InteractiveMap_VerifyDestinationInfoModal ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption4();
		ExtentTestManager.getTest().pass("Click on Destinations list4");
		imapPage.verifyDestinationsDescription();
		ExtentTestManager.getTest().pass("DestinationsDescription is verified");
		imapPage.verifyDestinationsAudioPlayButton();
		ExtentTestManager.getTest().pass("DestinationsAudioPlayButton is verified");
		imapPage.verifyDestinationsVideoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsVideoDescriptionImap is verified");
		imapPage.verifyDestinationsPanoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsPanoDescriptionImap is verified");
		imapPage.verifyDestinationsPhotoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsPhotoDescriptionImap is verified");
	}
	
	@Test   
	@Parameters({"browser"})
	public void IMAP_TC05_Desktop_InteractiveMap_VerifySupplementalMedia(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC05_Desktop_InteractiveMap_VerifySupplementalMedia ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC05_Desktop_InteractiveMap_VerifySupplementalMedia");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC05_Desktop_InteractiveMap_VerifySupplementalMedia", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC05_Desktop_InteractiveMap_VerifySupplementalMedia ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC05_Desktop_InteractiveMap_VerifySupplementalMedia ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption1();
		ExtentTestManager.getTest().pass("Click on Destinations list1");
		imapPage.verifyDestinationsDescription();
		ExtentTestManager.getTest().pass("DestinationsDescription is verified");
		imapPage.verifyDestinationsAudioPlayButton();
		ExtentTestManager.getTest().pass("DestinationsAudioPlayButton is verified");
		imapPage.verifyDestinationsVideoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsVideoDescriptionImap is verified");
		imapPage.verifyDestinationsPanoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsPanoDescriptionImap is verified");
		imapPage.verifyDestinationsPhotoDescriptionImap();
		ExtentTestManager.getTest().pass("DestinationsPhotoDescriptionImap is verified");
		imapPage.clickCloseIconDescriptionImap();
		ExtentTestManager.getTest().pass("Click on Close description button");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption1();
		ExtentTestManager.getTest().pass("Click on Destinations list1");
		imapPage.verifySupplimentalButtonImap();
		ExtentTestManager.getTest().pass("SupplimentalButton is verified");
		imapPage.verifySupplimentalPhotosIconImap();
		ExtentTestManager.getTest().pass("SupplimentalPhotosIcon is verified");
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC08_InteractiveMap_VerifyPhotoMediaContents ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption1();
		ExtentTestManager.getTest().pass("Click on Destinations list1");
		imapPage.verifyDestinationsDescription();
		ExtentTestManager.getTest().pass("DestinationsDescription is verified");
		imapPage.clickDestinationsPhotoDescriptionImap();
		ExtentTestManager.getTest().pass("Click on Destinations Photo");
		imapPage.verifyRightArrowButton();
		ExtentTestManager.getTest().pass("RightArrowButton is verified");
		imapPage.verifyLeftArrowButton();
		ExtentTestManager.getTest().pass("LeftArrowButton is verified");
		imapPage.verifyCarouselImapFrame();
		ExtentTestManager.getTest().pass("CarouselImapFrame is verified");
		imapPage.clickRightArrowButton();
		ExtentTestManager.getTest().pass("Right ArrowButton is clicked");
		imapPage.clickLeftArrowButton();
		ExtentTestManager.getTest().pass("Left ArrowButton is clicked");	
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC12_Desktop_VerifyView_ScreenSize(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("IMAP_TC12_Desktop_VerifyView_ScreenSize ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC12_Desktop_VerifyView_ScreenSize");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC12_Desktop_VerifyView_ScreenSize", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC12_Desktop_VerifyView_ScreenSize ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC12_Desktop_VerifyView_ScreenSize ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.changeScreenSize1();
		imapPage.verifySatelliteViewButton();
		ExtentTestManager.getTest().pass("SatelliteViewButton is verified");
		imapPage.verifyDestinationsButton();
		ExtentTestManager.getTest().pass("DestinationsButton is verified");
		imapPage.changeScreenSize2();
		imapPage.verifyGeoLocation();
		ExtentTestManager.getTest().pass("GeoLocation is verified");
		imapPage.verifyDestinationMobileIcon();
		ExtentTestManager.getTest().pass("DestinationMobileIcon is verified");
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC13_Desktop_VerifyRegistrationOnIMAP(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC13_Desktop_VerifyRegistrationOnIMAP ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC13_Desktop_VerifyRegistrationOnIMAP");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC13_Desktop_VerifyRegistrationOnIMAP", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC13_Desktop_VerifyRegistrationOnIMAP ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC13_Desktop_VerifyRegistrationOnIMAP ["+browserName+"]", ExtentColor.RED));
		Map<String, String> setData = imapOtherPage.setData();
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
		imapPage.switchToTheVirtualtourFrame();
		cifLogin.clickProspectiveStudentButton();
		ExtentTestManager.getTest().pass("prospective_student is clicked");
		prospectiveStudentPage.clickProspectiveStudentHighSchoolGraduateButton();
		imapOtherPage.clickNextButton();
		imapOtherPage.enterEmail(setData.get("EmailID"));
		ExtentTestManager.getTest().pass("Enter the email");
		imapOtherPage.enterFirstName(setData.get("FirstName"));
		ExtentTestManager.getTest().pass("Enter the firstname");
		imapOtherPage.enterLastName(setData.get("LastName"));
		ExtentTestManager.getTest().pass("Enter the lastname");
		imapOtherPage.enterDOB(setData.get("DoB"));
		ExtentTestManager.getTest().pass("Enter the dob");
		imapOtherPage.clickNextButton();
		parentAndGuardianPage.enterPostalCode("99620");
		imapOtherPage.clickNextButton();
		prospectiveStudentPage.enterCurrentHighSchoolGraduated();
		imapOtherPage.clickNextButton();
		prospectiveStudentPage.clickIntendedMajorDropdown();
		prospectiveStudentPage.enterIntendedMajorDropdown("Anthropology");
		imapOtherPage.clickNextButton();
		parentAndGuardianPage.enterSatScoreTextbox();
		ExtentTestManager.getTest().pass("SAT score is entered");
		parentAndGuardianPage.enterActScoreTextbox();
		ExtentTestManager.getTest().pass("ACT score is entered");
		parentAndGuardianPage.enterGpaScoreTextbox();
		ExtentTestManager.getTest().pass("GPA score is entered");
		imapOtherPage.clickNextButton();
		parentAndGuardianPage.enterPhoneNumber(setData.get("PhoneNo"));
		parentAndGuardianPage.clickGenderDropdown();
		parentAndGuardianPage.selectGenderMaleOption();
		parentAndGuardianPage.clickAcknowledgementCheckbox();
		imapOtherPage.clickDoneButton();
		imapOtherPage.verifyGetReadyMessage();	
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC11_Desktop_InteractiveMap_VerifyCTAButtons ["+browserName+"]", ExtentColor.RED));
		Map<String, String> setData = imapOtherPage.setData();
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.verifyRegisterButton();
		ExtentTestManager.getTest().pass("RegisterButton is verified");
		imapPage.verifyScheduleVisitButton();
		ExtentTestManager.getTest().pass("ScheduleVisitButton is verified");
		imapPage.verifyApplyOnlinetButton();
		ExtentTestManager.getTest().pass("ApplyOnlinetButton is verified");
		imapPage.verifyScheduleVisitRegisterAndApplyOnlineButtonColor();
		ExtentTestManager.getTest().pass("ScheduleVisit Register AndA pplyOn line Button Color is verified");
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC06_Desktop_InteractiveMap_VerifyPanoramaMediaContents ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption1();
		ExtentTestManager.getTest().pass("Click on Destinations list1");
		imapPage.verifyDestinationsDescription();
		ExtentTestManager.getTest().pass("DestinationsDescription is verified");
		imapPage.clickDestinationsPanoDescriptionImap();
		ExtentTestManager.getTest().pass("Click on Destinations pano field");
		imapPage.verifyRightArrowButton();
		ExtentTestManager.getTest().pass("RightArrowButton is verified");
		imapPage.verifyLeftArrowButton();
		ExtentTestManager.getTest().pass("LeftArrowButton is verified");
		imapPage.verifyCarouselImapFrame();
		ExtentTestManager.getTest().pass("CarouselImapFrame is verified");
		imapPage.verifyinfoIcon();
		ExtentTestManager.getTest().pass("Info icon is verified");
		imapPage.verifyPanoFrameHeightAndWidth();
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC07_InteractiveMap_VerifyVideoMediaContents(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC07_InteractiveMap_VerifyVideoMediaContents ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC07_InteractiveMap_VerifyVideoMediaContents");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC07_InteractiveMap_VerifyVideoMediaContents", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC07_InteractiveMap_VerifyVideoMediaContents ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC07_InteractiveMap_VerifyVideoMediaContents ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		imapPage.clickDestinationsListOption1();
		ExtentTestManager.getTest().pass("Click on Destinations list1");
		imapPage.verifyDestinationsDescription();
		ExtentTestManager.getTest().pass("DestinationsDescription is verified");
		imapPage.clickDestinationsVideoDescriptionImap();
		ExtentTestManager.getTest().pass("Click on Destinations video field");
		imapPage.verifyRightArrowButton();
		ExtentTestManager.getTest().pass("RightArrowButton is verified");
		imapPage.verifyLeftArrowButton();
		ExtentTestManager.getTest().pass("LeftArrowButton is verified");
		imapPage.verifyCarouselImapFrame();
		ExtentTestManager.getTest().pass("CarouselImapFrame is verified");
		imapPage.clickRightArrowButton();
		ExtentTestManager.getTest().pass("Right ArrowButton is clicked");
		imapPage.clickLeftArrowButton();
		ExtentTestManager.getTest().pass("Left ArrowButton is clicked");	
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC09_InteractiveMap_VerifyTrials(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC09_InteractiveMap_VerifyTrials ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC09_InteractiveMap_VerifyTrials");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC09_InteractiveMap_VerifyTrials", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC09_InteractiveMap_VerifyTrials ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC09_InteractiveMap_VerifyTrials ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickTrailsIcon();
		ExtentTestManager.getTest().pass("TrailsIcon is clicked");
		imapPage.clickCustomTrailsAIcon();
		ExtentTestManager.getTest().pass("Click on a trail A displayed in the list");
		imapPage.clickCustomTrailsBIcon();
		ExtentTestManager.getTest().pass("Click on a trail B displayed in the list");
		imapPage.clickTrailsCloseLink();
		ExtentTestManager.getTest().pass("Click on close link");
		imapPage.clickTrailsIcon();
		ExtentTestManager.getTest().pass("TrailsIcon is clicked");
		imapPage.clickDirectionsIcon();
		ExtentTestManager.getTest().pass("DirectionsIcon is clicked");
		imapPage.verifyStartDestinationField();
		ExtentTestManager.getTest().pass("StartDestination Field is verified");	
	}

	@Test   
	@Parameters({"browser"}) 
	public void IMAP_TC10_DesktopInteractiveMapVerifyDirectionsModal(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("IMAP_TC10_Desktop_InteractiveMap_VerifyDirectionsModal ["+browserName+"]");
//		ExtentTestManager.getTest().assignCategory("IMAP_TC10_Desktop_InteractiveMap_VerifyDirectionsModal");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC10_Desktop_InteractiveMap_VerifyDirectionsModal", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "IMAP_TC10_Desktop_InteractiveMap_VerifyDirectionsModal ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("IMAP_TC10_Desktop_InteractiveMap_VerifyDirectionsModal ["+browserName+"]", ExtentColor.RED));
		imapPage.navigateToImapLoginPage(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		imapPage.clickTrailsIcon();
		ExtentTestManager.getTest().pass("TrailsIcon is clicked");
		imapPage.clickDirectionsIcon();
		ExtentTestManager.getTest().pass("DirectionsIcon is clicked");
		imapPage.verifyStartDestinationField();
		ExtentTestManager.getTest().pass("StartDestination Field is verified");	
		imapPage.verifyLocation1InDirectionsField();
		ExtentTestManager.getTest().pass("Location1 In Directions Field is verified");	
		imapPage.verifyLocation2InDirectionsField();
		ExtentTestManager.getTest().pass("Location2 In Directions Field is verified");
		imapPage.verifyLocation3InDirectionsField();
		ExtentTestManager.getTest().pass("Location3 In Directions Field is verified");
	}
}
