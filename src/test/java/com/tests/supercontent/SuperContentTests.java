package com.tests.supercontent;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.pages.Page;
import com.pages.superContent.SuperContentPages;
import com.tests.BaseTest;

public class SuperContentTests extends BaseTest {

	String vtElementvisibilityURL;
	String interactiveVTURL;
	Page page = null;
	SuperContentPages superContentPage = null;
	
	@BeforeClass
	public void classSetUp() {
		vtElementvisibilityURL = prop.getProperty("env1")+prop.getProperty("url_vt");
		interactiveVTURL = prop.getProperty("env1")+prop.getProperty("url_interactive");
		page = new Page(remoteDriver);
		superContentPage = new SuperContentPages(remoteDriver);
	}
	
	@Test   
	@Parameters({"browser"})
	public void superContent01VerifyElementOnScreenSizeW1110xH623(@Optional("IamOptional")String browser) throws Exception	{
		
		System.err.println("SuperContent_W1110_H623-Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent_W1110_H623-Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent_W1110_H623-Verify Name,Email,Go To CMS,Go To Aria Optimizer,Help and Profile icon in Account Page ["+browserName+"]", ExtentColor.RED));


		page.navigateToVT(vtElementvisibilityURL);
		ExtentTestManager.getTest().pass("Browser Launched and navigate to Url - "+vtElementvisibilityURL);
		
		superContentPage.clickCloseRegistrationIcon();
		superContentPage.clickFirstTourOnExperience();
		superContentPage.setWindowDimension(1110, 623);
		//superContentPage.verifySupplementalMediaInlineView();
		superContentPage.verifySceneNameText();
		superContentPage.verifyShareButton();
		superContentPage.clickShareButton();
		superContentPage.verifyShareViaEmailButton();
		superContentPage.verifyShareViaLinkButton();
		superContentPage.verifyShareViaTwitterButton();
		superContentPage.verifyShareViaLinkedInButton();
		superContentPage.verifyShareViaFaceBookButton();
		superContentPage.verifyInfoButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickInfoButton();
		superContentPage.verifyIDescriptionBox();
		superContentPage.verifyAudioButton();
		superContentPage.verifyComplienceButton();
		superContentPage.verifyRegisterButton();
		superContentPage.verifyScheduleVisitButton();
		superContentPage.verifyApplyOnlineButton();
		superContentPage.verifyNextButton();
		superContentPage.verifyNextSceneTitleButton();
		superContentPage.verifyLanguageButton();
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		superContentPage.verifySpanishLanguageButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.verifyMoreVRMenuButton();
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.clickHomeCanvasButton();
	}
	
	@Test   
	@Parameters({"browser"})
	public void superContent01aVerifyElementOnScreenSizeW920xH552(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("SuperContent_This test case verifies if the elements are displayed for the screen size 920*552 ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("This test case verifies if the elements are displayed for the screen size 920*552", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent_This test case verifies if the elements are displayed for the screen size 920*552 ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent_This test case verifies if the elements are displayed for the screen size 920*552 ["+browserName+"]", ExtentColor.RED));

		
		page.navigateToVT(vtElementvisibilityURL);
		ExtentTestManager.getTest().pass("Browser Launched and navigate to Url - "+vtElementvisibilityURL);
		
		superContentPage.clickCloseRegistrationIcon();
		superContentPage.clickFirstTourOnExperience();
		superContentPage.setWindowDimension(920, 552);
		//superContentPage.verifySupplementalMediaInlineView();
		superContentPage.verifySceneNameText();
		superContentPage.verifyShareButton();
		superContentPage.clickShareButton();
		superContentPage.verifyShareViaEmailButton();
		superContentPage.verifyShareViaLinkButton();
		superContentPage.verifyShareViaTwitterButton();
		superContentPage.verifyShareViaLinkedInButton();
		superContentPage.verifyShareViaFaceBookButton();
		superContentPage.verifyInfoButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickInfoButton();
		superContentPage.verifyIDescriptionBox();
		superContentPage.verifyAudioButton();
		superContentPage.verifyComplienceButton();
		superContentPage.verifyRegisterButton();
		superContentPage.verifyScheduleVisitButton();
		superContentPage.verifyApplyOnlineButton();
		superContentPage.verifyNextButton();
		superContentPage.verifyNextSceneTitleButton();
		superContentPage.verifyLanguageButton();
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		superContentPage.verifySpanishLanguageButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.verifyMoreVRMenuButton();
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.clickHomeCanvasButton();
	}
	
	@Test
	@Parameters({"browser"})
	public void superContent02VerifyElementsOnInlineEmbed_360ContentWithHotspots(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("SuperContent2_Verify if the following elements are displayed for InlineEmbed_360ContentWithHotspots ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify if the following elements are displayed for InlineEmbed_360ContentWithHotspots", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent2_Verify if the following elements are displayed for InlineEmbed_360ContentWithHotspots ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent2_Verify if the following elements are displayed for InlineEmbed_360ContentWithHotspots ["+browserName+"]", ExtentColor.RED));

		page.navigateToVT(interactiveVTURL);
		superContentPage.verifyInline360ContentWithHotspotLink();
		superContentPage.clickInline360ContentWithHotspotLink();
//		Thread.sleep(10000);
		superContentPage.switchToInlineVTiFrame();
		
		superContentPage.verifyAudioButton();
		superContentPage.verifyFullScreenButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();
//		Thread.sleep(5000);
		superContentPage.navigateToPreviousPage(browserName);
		Thread.sleep(10000);
		superContentPage.verifyInline360ContentWithHotspotLink();
		superContentPage.clickInline360ContentWithHotspotLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.clickMoreButton();
		superContentPage.verifyShareButton();
		superContentPage.verifyLanguageButton();
		superContentPage.verifyInfoInterIcon();
		superContentPage.verifyMoreVRMenuButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.verifyIDescriptionBox();
		superContentPage.clickMoreButton();
		superContentPage.clickShareButton();
		superContentPage.verifyShareViaEmailButton();
		superContentPage.verifyShareViaLinkButton();
		superContentPage.verifyShareViaTwitterButton();
		superContentPage.verifyShareViaLinkedInButton();
		superContentPage.verifyShareViaFaceBookButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		superContentPage.verifyKoreanLanguageButton();
		superContentPage.verifyJapaneseLanguageButton();
		superContentPage.verifyMandarinLanguageButton();
		String homeWindow = superContentPage.getCurrentWindow();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.clickAccessibilityButton(browserName);
		superContentPage.switchToWindow(homeWindow);
	}
	
	@Test 
	@Parameters({"browser"})
	public void superContent03VerifyElementsOnInlineEmbedStonyBrook(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("superContent03VerifyElementsOnInlineEmbedStonyBrook["+browserName+"]");
		//System.err.println("SuperContent_Verify if the following elements are displayed for InlineEmbed_StonyBrook ["+browserName+"]");
		//ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify if the following elements are displayed for InlineEmbed_StonyBrook", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent_Verify if the following elements are displayed for InlineEmbed_StonyBrook ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent_Verify if the following elements are displayed for InlineEmbed_StonyBrook ["+browserName+"]", ExtentColor.RED));

		page.navigateToVT(interactiveVTURL);
		superContentPage.clickInlineEmbedStonyBrookLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.verifyMoreButton();
		superContentPage.verifyAudioButton();
		superContentPage.verifyFullScreenButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();
		
		superContentPage.switchToMainWindow();
		superContentPage.navigateToPreviousPage(browserName);
		superContentPage.clickInlineEmbedStonyBrookLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.clickMoreButton();
		superContentPage.verifyShareButton();
		superContentPage.verifyLanguageButton();
		superContentPage.verifyInfoInterIcon();
		superContentPage.verifyMoreVRMenuButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.verifyIDescriptionBox();
		superContentPage.clickMoreButton();
		superContentPage.clickShareButton();
		superContentPage.verifyShareViaEmailButton();
		superContentPage.verifyShareViaLinkButton();
		superContentPage.verifyShareViaTwitterButton();
		superContentPage.verifyShareViaLinkedInButton();
		superContentPage.verifyShareViaFaceBookButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		superContentPage.verifySpanishLanguageButton();
		superContentPage.verifyChineseLanguageButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.clickAccessibilityButton(browserName);
		superContentPage.verifyPageNavigatedToStonyBrookAccessibility();
		superContentPage.goToMainTabCloseOtherTabs(browser);
	}
	
	@Test
	@Parameters({"browser"})
	public void superContent04VerifyInlineEmbed_FlatContentWithInteractiveElements(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("SuperContent04VerifyInlineEmbed_FlatContentWithInteractiveElements["+browserName+"]");
		//System.err.println("SuperContent_Verify if the following elements are displayed for InlineEmbed_FlatContentWithInteractiveElements ["+browserName+"]");
		//ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify if the following elements are displayed for InlineEmbed_FlatContentWithInteractiveElements", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent_Verify if the following elements are displayed for InlineEmbed_FlatContentWithInteractiveElements ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent_Verify if the following elements are displayed for InlineEmbed_FlatContentWithInteractiveElements ["+browserName+"]", ExtentColor.RED));

		page.navigateToVT(interactiveVTURL);
		superContentPage.verifyInlineEmbedFlatContentWithInteractiveElementLink();
		superContentPage.clickInlineEmbedFlatContentWithInteractiveElementLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.verifyMoreButton();
		//superContentPage.verifyAudioButton();
		superContentPage.verifyFullScreenButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();
		
		superContentPage.switchToMainWindow();
		superContentPage.navigateToPreviousPage(browserName);
		superContentPage.clickInlineEmbedFlatContentWithInteractiveElementLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.clickMoreButton();
		superContentPage.verifyShareButton();
		superContentPage.verifyInfoInterIcon();
		superContentPage.verifyMoreVRMenuButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.verifyIDescriptionBox();
		superContentPage.clickMoreButton();
		superContentPage.clickShareButton();
		superContentPage.verifyShareViaEmailButton();
		superContentPage.verifyShareViaLinkButton();
		superContentPage.verifyShareViaTwitterButton();
		superContentPage.verifyShareViaLinkedInButton();
		superContentPage.verifyShareViaFaceBookButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.clickMoreButton();
		superContentPage.clickInfoInterIcon();
		superContentPage.clickAccessibilityButton(browserName);
		superContentPage.verifyPageNavigatedToPatrickBoydlAccessibility();	
		superContentPage.goToMainTabCloseOtherTabs(browser);
	}
	
	@Test
	@Parameters({"browser"})
	public void superContent05VerifyElementsOnImmersiveBannerHoverPanel(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("SuperContent05VerifyElementsOnImmersiveBannerHoverPanel["+browserName+"]");
//		System.err.println("SuperContent_Verify if the following elements are displayed for ImmersiveBanner_HoverPanel ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify if the following elements are displayed for ImmersiveBanner_HoverPanel", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "SuperContent_Verify if the following elements are displayed for ImmersiveBanner_HoverPanel ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("SuperContent_Verify if the following elements are displayed for ImmersiveBanner_HoverPanel ["+browserName+"]", ExtentColor.RED));

		page.navigateToVT(interactiveVTURL);
		superContentPage.clickImmersiveBannerHoverPanelLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.clickPlayButton();
		superContentPage.switchToMainWindow();
		superContentPage.verifyAndSwitchToImmersiveBannerHoverPanelVTiFrame();
		
		superContentPage.verifyAudioButton();
		superContentPage.verifyShareButton();
		superContentPage.verifyInfoButton();
		superContentPage.verifyMoreButton();
		superContentPage.verifyAccessibilityButton();
		superContentPage.verifyNextButton();
		
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify if number of tabs after clicking on 'Play' button is more than before clicking on 'Play' button", ExtentColor.RED));
		
		superContentPage.switchToMainWindow();
		superContentPage.navigateToPreviousPage(browserName);
		superContentPage.clickImmersiveBannerHoverPanelNewTabLink();
		superContentPage.goToMainTabCloseOtherTabs(browser);
	}
	
	@Test
	@Parameters({"browser"})
	public void superContent06VerifyFeaturesWithScreenSize731px(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, Apply Online features and they work as expected ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
//				+ "Apply Online features and they work as expected", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
				+ "Apply Online features and they work as expected ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
				+ "Apply Online features and they work as expected ["+browserName+"]", ExtentColor.RED));
		
		page.navigateToVT(interactiveVTURL);
		superContentPage.clickIwcDesktopUseCaseLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.verifyIwcAccessibilityButton();
		superContentPage.switchToMainWindow();
		superContentPage.refreshSuperContentVTPage();
		superContentPage.switchToIwciFrame1();
		superContentPage.verifyIwcAccessibilityButton();
		superContentPage.switchToMainWindow();
		superContentPage.refreshSuperContentVTPage();
		superContentPage.switchToIwciFrame2();
		superContentPage.verifyIwcAccessibilityButton();
		//superContentPage.verifyInfoVTButton();
		superContentPage.verifyAudioButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.verifyVrVtButton();
		superContentPage.verifyScheduleVisitButton();
		superContentPage.verifyRegisterButton();
		superContentPage.verifyApplyOnlineButton();
		superContentPage.clickMoreButton();
		superContentPage.clickVrVtButton();
		superContentPage.clickVrCloseButton();
		superContentPage.clickMoreButton();		
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		//superContentPage.verifySpanishLanguageButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.verifyMoreButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();		
		
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.clickMoreFullScreenButton();
		Thread.sleep(4000);
		superContentPage.clickRegisterButton();
		
	}
	
	@Test
	@Parameters({"browser"})
	public void superContent07VerifyFeaturesOnScreenSize731px(@Optional("IamOptional")String browser) throws Exception {
		System.err.println("SuperContent_Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, Apply Online features and they work as expected ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
//				+ "Apply Online features and they work as expected ", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
				+ "Apply Online features and they work as expected ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Verify size 731px has Accessibility, Info, Audio, More, Full Screen, Register Now, Schedule Visit, "
				+ "Apply Online features and they work as expected ["+browserName+"]", ExtentColor.RED));

		page.navigateToVT(interactiveVTURL);
		superContentPage.clickIwcDesktopUseCaseLink();
		superContentPage.switchToInlineVTiFrame();
		superContentPage.verifyIwcAccessibilityButton();
		superContentPage.switchToMainWindow();
		superContentPage.refreshSuperContentVTPage();
		superContentPage.switchToIwciFrame1();
		superContentPage.verifyIwcAccessibilityButton();
		superContentPage.switchToMainWindow();
		superContentPage.refreshSuperContentVTPage();
		superContentPage.switchToIwciFrame2();
		superContentPage.verifyIwcAccessibilityButton();
		//superContentPage.verifyInfoVTButton();
		superContentPage.verifyAudioButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.verifyVrVtButton();
		//superContentPage.verifyScheduleVisitButton();
		superContentPage.verifyRegisterButton();
		//superContentPage.verifyApplyOnlineButton();
		superContentPage.clickLanguageButton();
		superContentPage.verifyEnglishLanguageButton();
		//superContentPage.verifySpanishLanguageButton();
		superContentPage.verifyMoreButton();
		//superContentPage.clickVrVtButton();
		//superContentPage.clickVrCloseButton();
		superContentPage.clickHomeCanvasButton();
		superContentPage.verifyMoreButton();
		superContentPage.clickMoreButton();	
		superContentPage.verifyMoreFullScreenButton();
		superContentPage.clickMoreFullScreenButton();
		Thread.sleep(4000);
		superContentPage.clickRegisterButton();

	}
}
