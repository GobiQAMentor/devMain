package com.tests.experience360;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.desktopCIF.ProspectiveStudentPage;
import com.pages.embedCode.EmbedCodeLoginPage;
import com.pages.experience360.Experience360Page;
import com.pages.iwcFormerSuperContent.IwcFormerSuperContentPage;
import com.tests.BaseTest;

public class Experience360Test extends BaseTest{
	String url;
	String oRUrl;
	String url_360_nau;
	Experience360Page experience360Page = null;
	ObjectsControl objectControl = null;
	ProspectiveStudentPage prospectiveStudentPage = null;
	IwcFormerSuperContentPage iwcFormerSuperContentPage = null;
	EmbedCodeLoginPage loginPage = null;
	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_360");
		oRUrl = prop.getProperty("env1")+prop.getProperty("url_360_OR");
		url_360_nau = prop.getProperty("env1")+prop.getProperty("url_360_nau");
		experience360Page = new Experience360Page(remoteDriver);
		objectControl = new ObjectsControl(remoteDriver);
		prospectiveStudentPage = new ProspectiveStudentPage(remoteDriver);
		iwcFormerSuperContentPage = new IwcFormerSuperContentPage(remoteDriver);
		loginPage = new EmbedCodeLoginPage(remoteDriver);
	}
	@Test   
	@Parameters({"browser"})
	public void Experience360_TC01TC02HomePageElementsStonybrook(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("Experience360_TC01TC02HomePageElementsStonybrook ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("Experience360_TC01TC02HomePageElementsStonybrook");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Experience360_TC01TC02HomePageElementsStonybrook ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Experience360_TC01TC02HomePageElementsStonybrook ["+browserName+"]", ExtentColor.RED));

		experience360Page.navigateToExperience360PageLogin(url);
		ExtentTestManager.getTest().pass("Experience360 is logged in");
		experience360Page.clickCloseButton();
		ExtentTestManager.getTest().pass("Close button is clicked");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		iwcFormerSuperContentPage.verifyScheduleVisitButton();
		ExtentTestManager.getTest().pass("ScheduleVisitButton is verified");
		iwcFormerSuperContentPage.verifyRegisterNowButton();
		ExtentTestManager.getTest().pass("RegisterNowButton is verified");
		iwcFormerSuperContentPage.verifyApplyOnlineButton();
		ExtentTestManager.getTest().pass("ApplyOnlineButton is verified");
		iwcFormerSuperContentPage.clickScheduleVisitButton();
		ExtentTestManager.getTest().pass("ScheduleVisit button is clicked");
		loginPage.switchToTheNewTab();
		experience360Page.verifyStonybrookUniversityLogo();
		ExtentTestManager.getTest().pass("StonybrookUniversityLogo is verified");
//		experience360Page.switchToTheOldTab();
		experience360Page.goToMainTabCloseOtherTabs(browser);
		Thread.sleep(3000);
		//loginPage.closeOtherTabAndSwitchToMain(browserName);
		iwcFormerSuperContentPage.clickApplyOnlineButton();
		ExtentTestManager.getTest().pass("Apply Online button is clicked");
		loginPage.switchToTheNewTab();
		experience360Page.verifyHowToApplyHeader();
		ExtentTestManager.getTest().pass("verifyHowToApplyHeader is verified");
//		experience360Page.switchToTheOldTab();
		experience360Page.goToMainTabCloseOtherTabs(browser);

		experience360Page.verifyInfoButton();
		ExtentTestManager.getTest().pass("InfoButton is verified");
		experience360Page.verifyAndClickShareButton();
		ExtentTestManager.getTest().pass("ShareButton is verified");
		experience360Page.verifyShareViaFacebookButton();
		ExtentTestManager.getTest().pass("FacebookButton is verified");
		experience360Page.verifyShareViaLinkedInButton();
		ExtentTestManager.getTest().pass("LinkedInButton is verified");
		experience360Page.verifyShareViaTwitterButton();
		ExtentTestManager.getTest().pass("TwitterButton is verified");
		experience360Page.verifyShareViaLinkButton();
		ExtentTestManager.getTest().pass("LinkButton is verified");
		experience360Page.verifyShareViaEmailButton();
		ExtentTestManager.getTest().pass("EmailButton is verified");
		iwcFormerSuperContentPage.pageRefresh();
		experience360Page.clickCloseButton();
		
		
		experience360Page.clickLanguageButton();
		ExtentTestManager.getTest().pass("LanguageButton is clicked");
		iwcFormerSuperContentPage.verifyEnglishLanguageField();
		ExtentTestManager.getTest().pass("EnglishLanguageField is verified");
		iwcFormerSuperContentPage.verifySpanishLanguageField();
		ExtentTestManager.getTest().pass("SpanishLanguageField is verified");
		iwcFormerSuperContentPage.verifyChineseLanguageField();
		ExtentTestManager.getTest().pass("ChineseLanguageField is verified");
		iwcFormerSuperContentPage.pageRefresh();
		experience360Page.clickCloseButton();
		
		experience360Page.clickMoreButton();
		ExtentTestManager.getTest().pass("MoreButton is clicked");
		experience360Page.clickExpandFullscreenButton();
		ExtentTestManager.getTest().pass("Click on expand_full_screen_icon");

		experience360Page.collapseFullScreenButton();
		ExtentTestManager.getTest().pass("CollapseFullScreenButton is clicked");
	}
	
	@Test   
	@Parameters({"browser"})
	public void Experience_360_TC04OaklandRennaisanceHotspots(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("Experience_360_TC04_OaklandRennaisanceHotspots ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("Experience_360_TC04_OaklandRennaisanceHotspots");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Experience_360_TC04_OaklandRennaisanceHotspots ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Experience_360_TC04_OaklandRennaisanceHotspots ["+browserName+"]", ExtentColor.RED));

		experience360Page.navigateToExperience360ORPageLogin(oRUrl);
		ExtentTestManager.getTest().pass("Experience360 is logged in");
		experience360Page.clickSkipIntroButton();
		ExtentTestManager.getTest().pass("skip_intro_button is clicked");
		experience360Page.clickDegree360Icon();
		ExtentTestManager.getTest().pass("360_degree_icon is clicked");
		experience360Page.verifyAndClickDegree360VideoPauseButton();
		experience360Page.verifyAndClickDegree360IconVideoPlaying();
		ExtentTestManager.getTest().pass("360_degree_video_playing is clicked");
		experience360Page.verifyAndClickDegree360VideoPauseButton();
		ExtentTestManager.getTest().pass("360_degree_video_close_icon is clicked");
	}
	
	@Test   
	@Parameters({"browser"})
	public void Experience_360_TC03NauVisitOaklandHotSpots(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("Experience_360_TC03_NauVisitOaklandHotSpots ["+browserName+"]");
		//ExtentTestManager.getTest().assignCategory("Experience_360_TC03_NauVisitOaklandHotSpots");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Experience_360_TC03_NauVisitOaklandHotSpots ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Experience_360_TC03_NauVisitOaklandHotSpots["+browserName+"]", ExtentColor.RED));

		experience360Page.navigateToExperience360NauPageLogin(url_360_nau);
		ExtentTestManager.getTest().pass("Experience360 is logged in");
		experience360Page.clickCloseButton();
		ExtentTestManager.getTest().pass("Close button is clicked");
		prospectiveStudentPage.clickBookLink();
		ExtentTestManager.getTest().pass("Click on BookLinkLink");
		ExtentTestManager.getTest().pass("ScheduleVisitButton is verified");
		iwcFormerSuperContentPage.verifyRegisterNowButton();
		ExtentTestManager.getTest().pass("RegisterNowButton is verified");
		iwcFormerSuperContentPage.verifyApplyOnlineButton();
		ExtentTestManager.getTest().pass("ApplyOnlineButton is verified");
		iwcFormerSuperContentPage.clickScheduleVisitButton();
		ExtentTestManager.getTest().pass("ScheduleVisit button is clicked");
		loginPage.switchToTheNewTab();
		experience360Page.verifyNauScheduleVisit();
		ExtentTestManager.getTest().pass("verifyNauScheduleVisit field is verified");
//		experience360Page.switchToTheOldTab();
		experience360Page.goToMainTabCloseOtherTabs(browser);
		//loginPage.closeOtherTabAndSwitchToMain(browserName);
		experience360Page.verifyInfoButton();
		ExtentTestManager.getTest().pass("InfoButton is verified");
		experience360Page.verifyAndClickShareButton();
		ExtentTestManager.getTest().pass("ShareButton is verified");
		experience360Page.verifyShareViaFacebookButton();
		ExtentTestManager.getTest().pass("FacebookButton is verified");
		experience360Page.verifyShareViaLinkedInButton();
		ExtentTestManager.getTest().pass("LinkedInButton is verified");
		experience360Page.verifyShareViaTwitterButton();
		ExtentTestManager.getTest().pass("TwitterButton is verified");
		experience360Page.verifyShareViaLinkButton();
		ExtentTestManager.getTest().pass("LinkButton is verified");
		experience360Page.verifyShareViaEmailButton();
		ExtentTestManager.getTest().pass("EmailButton is verified");
		iwcFormerSuperContentPage.pageRefresh();
		experience360Page.clickCloseButton();
		
		experience360Page.clickLanguageButton();
		ExtentTestManager.getTest().pass("LanguageButton is clicked");
		iwcFormerSuperContentPage.verifyEnglishLanguageField();
		ExtentTestManager.getTest().pass("EnglishLanguageField is verified");
		iwcFormerSuperContentPage.verifySpanishLanguageField();
		ExtentTestManager.getTest().pass("SpanishLanguageField is verified");
//		iwcFormerSuperContentPage.verifyChineseLanguageField();
//		ExtentTestManager.getTest().pass("ChineseLanguageField is verified");
		iwcFormerSuperContentPage.pageRefresh();
		experience360Page.clickCloseButton();
		
		experience360Page.clickMoreButton();
		ExtentTestManager.getTest().pass("MoreButton is clicked");
		experience360Page.clickExpandFullscreenButton();
		ExtentTestManager.getTest().pass("Click on expand_full_screen_icon");
		experience360Page.collapseFullScreenButton();
		ExtentTestManager.getTest().pass("CollapseFullScreenButton is clicked");
	}
}
