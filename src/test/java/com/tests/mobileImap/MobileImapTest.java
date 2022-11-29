package com.tests.mobileImap;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.imap.ImapPage;
import com.pages.mobileImap.MobileImapPage;
import com.tests.BaseTest;

public class MobileImapTest extends BaseTest{
	String url;
	String urlCif;
	String maristURL;
	MobileImapPage mobileImapPage = null;
	ImapPage imapPage = null;
	ProspectiveStudentPage mobileProspectiveStudentPage = null;
	String urlImap;
	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_vt1");
		urlCif = prop.getProperty("env1")+prop.getProperty("url_cif");
		mobileImapPage = new MobileImapPage(remoteDriver);
		mobileProspectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		maristURL = prop.getProperty("env1")+"/tour/map/marist";
		imapPage = new ImapPage(remoteDriver);
		urlImap = prop.getProperty("env1")+prop.getProperty("url_imap");
	}

	@Test  
	@Parameters({"browser"})
	public void TC01_VerifyLaunchingIMapOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("MobileIMAP_TC01_VerifyLaunchingIMapOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("MobileIMAP_TC01_VerifyLaunchingIMapOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC01_VerifyLaunching_InteractiveMap_OnMobile", ExtentColor.BLUE));
		mobileImapPage.navigateToMobileImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		mobileImapPage.clickMobileImapIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapIcon");
		mobileImapPage.verifyCampusMapImapMobile();
		ExtentTestManager.getTest().pass("CampusMap is verified");
		mobileImapPage.verifyTrailsImapMobileIcon();
		ExtentTestManager.getTest().pass("TrailsImapMobileIcon is verified");
		mobileImapPage.verifyGeolocationImapMobile();
		ExtentTestManager.getTest().pass("GeolocationImapMobile is verified");
		mobileImapPage.verifyCta1ImapMobileButton();
		ExtentTestManager.getTest().pass("Cta1ImapMobileButton is verified");
		mobileImapPage.clickSwitchSatelliteModeIcon();
		ExtentTestManager.getTest().pass("Click on witchSatelliteModeIcon");
		mobileImapPage.navigateToMobileCifPageLogin(urlCif);
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileImapPage.clickSeconfBookLink();
		ExtentTestManager.getTest().pass("Click on second BookLink");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileImapPage.clickMobileImapSecondIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapSecondIcon");
		mobileImapPage.verifyCampusMapImapMobile();
		ExtentTestManager.getTest().pass("CampusMap is verified");
		mobileImapPage.verifyGeolocationImapMobile();
		ExtentTestManager.getTest().pass("GeolocationImapMobile is verified");
		mobileImapPage.verifyCta1ImapMobileButton();
		ExtentTestManager.getTest().pass("Cta1ImapMobileButton is verified");
		mobileImapPage.clickSwitchSatelliteModeIcon();
		ExtentTestManager.getTest().pass("Click on witchSatelliteModeIcon");
		mobileImapPage.navigateToMaristUrl(maristURL);
		mobileImapPage.verifyCampusMapField();
		ExtentTestManager.getTest().pass("Verify Google Map Button");
		mobileImapPage.verifiyGoogleMapField();
		ExtentTestManager.getTest().pass("Verify Campus Green to select");
	}

	@Test  
	@Parameters({"browser"})
	public void TC02_VerifyImapDestinationSideBarOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("TC02_VerifyImapDestinationSideBarOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("TC02_VerifyImapDestinationSideBarOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC02_VerifyImapDestinationSideBarOnMobile", ExtentColor.BLUE));
		mobileImapPage.navigateToMobileImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on Book Link");
		mobileImapPage.clickMobileImapIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapIcon");
		mobileImapPage.clickDestinationsButton();
		ExtentTestManager.getTest().pass("Click on Destinations Button");
		mobileImapPage.verifyTrailsMobileSearchIcon();
		ExtentTestManager.getTest().pass("Verify TrailsMobileSearchIcon");
		mobileImapPage.verifyTrailsMobileCloseIcon();
		ExtentTestManager.getTest().pass("Verify TrailsMobileCloseIcon");
		mobileImapPage.verifyDestinationsField();
		ExtentTestManager.getTest().pass("Verify Destinations field label");
		mobileImapPage.clickDestinationList2();
		ExtentTestManager.getTest().pass("Click on DestinationList2");
	}

	@Test  
	@Parameters({"browser"})
	public void TC07_VerifyIMapCTAButtonOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("TC07_VerifyIMapCTAButtonOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("TC07_VerifyIMapCTAButtonOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC07_VerifyIMapCTAButtonOnMobile", ExtentColor.BLUE));
		mobileImapPage.navigateToImapPageLogin(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Virtual tour page");
		mobileImapPage.verifyNoOfCtaButtonsVisibleOnMobile(remoteDriver, ExtentTestManager.getTest());
		imapPage.clickRegisterButton();
		ExtentTestManager.getTest().pass("Click on Register button");
	}

	@Test
	@Parameters({"browser"})
	public void TC06_VerifyIMapDirectionsOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("MobileIMAP_TC06_VerifyIMapDirectionsOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("MobileIMAP_TC06_VerifyIMapDirectionsOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC06 InteractiveMap_VerifyDirections", ExtentColor.RED));
		mobileImapPage.navigateToImapPageLogin(urlImap);
		ExtentTestManager.getTest().pass("Login to application and navigated to Virtual tour page");
		mobileImapPage.clickTrailsIcon();
		ExtentTestManager.getTest().pass("Trails Icon is clicked");
		mobileImapPage.clickTrailsDirectionsIconMobileImap();
		ExtentTestManager.getTest().pass("Trails Directions Icon is clicked");
		mobileImapPage.verifyStartingAndEndingPoints();
	}

	@Test
	@Parameters({"browser"})
	public void TC05_VerifyIMapTrialsOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("MobileIMAP_TC05_VerifyIMapTrialsOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("MobileIMAP_TC05_VerifyIMapTrialsOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC05_InteractiveMap_VerifyTrials", ExtentColor.RED));
		mobileImapPage.navigateToMobileImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		mobileImapPage.clickMobileImapIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapIcon");
		mobileImapPage.clickTrailsIcon();
		ExtentTestManager.getTest().pass("TrailsIcon is clicked");
		mobileImapPage.verifyTrailsBackbuttonMobileImap();
		ExtentTestManager.getTest().pass("Verify Trails Back button");
		mobileImapPage.verifyTrailsTitleMobileImap();
		ExtentTestManager.getTest().pass("Verify TrailsTitleMobileImap");
		mobileImapPage.verifyTrailsDirectionsIconMobileImap();
		ExtentTestManager.getTest().pass("Verify TrailsDirectionsIconMobileImap");
		mobileImapPage.verifyCustomTrailATrailsIconImap();
		ExtentTestManager.getTest().pass("Verify CustomTrail A trailsIconImap");
		mobileImapPage.verifyCustomTrailBTrailsIconImap();
		ExtentTestManager.getTest().pass("Verify CustomTrail B trailsIconImap");
		mobileImapPage.verifySelectedTrailNameAndSeletedTrailNameHeader();
		mobileImapPage.clickTrailsCloseIcon();
		ExtentTestManager.getTest().pass("Close icon (x) displayed as expected");
	}

	@Test 
	@Parameters({"browser"})
	public void TC04_VerifyIMapSupplementalMediaOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("MobileIMAP_TC04_VerifyIMapSupplementalMediaOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("MobileIMAP_TC04_VerifyIMapSupplementalMediaOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC04_InteractiveMap_VerifySupplementalMedia", ExtentColor.RED));
		mobileImapPage.navigateToMobileImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		mobileImapPage.clickMobileImapIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapIcon");
		mobileImapPage.clickDestinationsMobileBurgerIcon();
		ExtentTestManager.getTest().pass("Click on DestinationsMobileBurgerIcon");
		mobileImapPage.clickSecondDestinationsInMobileList();
		ExtentTestManager.getTest().pass("Click on clickSecondDestinationsInMobileList");
		mobileImapPage.clickSmallTitleInDescriptionField();
		ExtentTestManager.getTest().pass("click on SmallTitleInDescriptionField");
		mobileImapPage.verifySupplimentalProfileImage();
		ExtentTestManager.getTest().pass("verify the  SupplimentalProfileImage");
		mobileImapPage.verifySupplimentalNameTitle();
		ExtentTestManager.getTest().pass("verify the SupplimentalNameTitle");
		mobileImapPage.clickSupplimentalAudioplayer();
		ExtentTestManager.getTest().pass("Click on SupplimentalAudioplayer");
		mobileImapPage.verifySupplimentalMedia();
		ExtentTestManager.getTest().pass("verify the SupplimentalMedia");
		mobileImapPage.verifySupplimentalWrittenSummary();
		ExtentTestManager.getTest().pass("verify the SupplimentalWrittenSummary");
		mobileImapPage.verifySupplimentalCloseButton();
		ExtentTestManager.getTest().pass("verify the SupplimentalCloseButton");
	}

	@Test
	@Parameters({"browser"})
	public void TC03_VerifyIMapDestinationInfoModalOnMobile(@Optional("IamOptional")String browser) throws Exception  
	{
		System.err.println("MobileIMAP_TC03_VerifyIMapDestinationInfoModalOnMobile");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().assignCategory("MobileIMAP_TC03_VerifyIMapDestinationInfoModalOnMobile");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("TC03_InteractiveMap_VerifyDestinationInfoModal", ExtentColor.RED));
		mobileImapPage.navigateToMobileImapPageLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		mobileProspectiveStudentPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		mobileProspectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		mobileImapPage.clickMobileImapIcon();
		ExtentTestManager.getTest().pass("Click on MobileImapIcon");
		mobileImapPage.clickDestinationsMobileBurgerIcon();
		ExtentTestManager.getTest().pass("Click on Destinations Mobile Burger Icon");
		mobileImapPage.verifyDestinationsMobileSearch();
		ExtentTestManager.getTest().pass("verify the  DestinationsMobileSearch");
		mobileImapPage.verifyDestinationLists();
		mobileImapPage.clickSmallTitleInDescriptionField();
		ExtentTestManager.getTest().pass("click on SmallTitleInDescriptionField");
		mobileImapPage.verifySupplimentalWrittenSummary();
		ExtentTestManager.getTest().pass("verify the SupplimentalWrittenSummary");
		mobileImapPage.clickSupplimentalAudioplayer();
		ExtentTestManager.getTest().pass("Click on SupplimentalAudioplayer");
		ExtentTestManager.getTest().pass("audio button appears with a \"Pause\" icon");
	}
}
