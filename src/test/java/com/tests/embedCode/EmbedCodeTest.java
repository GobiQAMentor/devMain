package com.tests.embedCode;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.driver.DriverInstance;
import com.pages.embedCode.EmbedCodeLoginPage;
import com.pages.embedCode.EmbedCodePage;
import com.tests.BaseTest;


@Listeners({ ExtentITestListenerClassAdapter.class })
public class EmbedCodeTest extends BaseTest{
	String url;
	String smartScriptMix1;
	String smartScriptMix2;
	String smartScriptThirdParty;
	String smartScriptNoParasUrl;
	String smartScriptLatestIndexUrl;

	EmbedCodeLoginPage loginPage = null;
	EmbedCodePage embedCodePage = null;

	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_embedded");
		loginPage = new EmbedCodeLoginPage(remoteDriver);
		smartScriptMix1 = prop.getProperty("staging_env")+"/SmartScript/latest/mix-vte-anchor.html";
		smartScriptMix2 = prop.getProperty("staging_env")+"/SmartScript/latest/mix-vte-anchor-2.html";
		smartScriptThirdParty = prop.getProperty("staging_env")+"/SmartScript/latest/3rdparty.html";
		smartScriptNoParasUrl = prop.getProperty("staging_env")+"/SmartScript/latest/no-params.html";
		smartScriptLatestIndexUrl = prop.getProperty("staging_env")+"/SmartScript/latest/index.html";
		embedCodePage = new EmbedCodePage(remoteDriver);
	}


	@Test   
	@Parameters({"browser"})
	public void EmbedCode1_HoverImmersiveHoverPanelSmallStaticSize(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_HoverImmersiveHoverPanelSmallStaticSize ["+browserName+"]");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
//		ExtentService.getInstance().addTestRunnerOutput((browserName)+"123");
//		ExtentTestManager.getTest().assignDevice(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_HoverImmersiveHoverPanelSmallStaticSize ["+browserName+"]");
		
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_HoverImmersiveHoverPanelSmallStaticSize["+browserName+"]", ExtentColor.RED));
		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickMixVteAnchor1Button();
		ExtentTestManager.getTest().pass("MixVteAnchor1Button is clicked");
		loginPage.verifyAndClickHoverLagacyImageButtonDisplayed();
		ExtentTestManager.getTest().pass("HoverLagacyImageButton is clicked");
		loginPage.navigateSmartScriptUrl2(smartScriptMix1);
		loginPage.clickVirtualFrameButton();
		ExtentTestManager.getTest().pass("VirtualFrameButton is clicked");
		loginPage.closeOtherTabAndSwitchToMain(browserName);
		ExtentTestManager.getTest().pass("Sub tabs are closed and main tab is opened");
		loginPage.navigateToPreviousPage();
		loginPage.clickMixVteAnchor2Button();
		ExtentTestManager.getTest().pass("MixVteAnchor2Button is clicked");
		loginPage.verifyAndClickHoverLagacyImageButtonDisplayed();
		loginPage.navigateSmartScriptUrl3(smartScriptMix2);
		loginPage.navigateToPreviousPage();
		loginPage.clickMixVteAnchor3Button();
		ExtentTestManager.getTest().pass("MixVteAnchor3Button is clicked");
		loginPage.verifyAndClickHoverCustomTextLaunchButton();
	}


	@Test   
	@Parameters({"browser"})
	public void EmbedCode2_InlineEmbed(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_Inline Embed (inline-embed) ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Inline - Embed (inline-embed) ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Inline Embed (inline-embed) ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Inline Embed (inline-embed) ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickMixVteAnchor3Button();
		ExtentTestManager.getTest().pass("Click on mix_vte_anchor3 button");
		loginPage.verifyInlineEmbedHeader();
		ExtentTestManager.getTest().pass("InlineEmbedHeader is verified");
		loginPage.switchToTheVirtualtourFrame1();
		ExtentTestManager.getTest().pass("VirtualFrame1 is switched");
		loginPage.verifyViewAccesibleVersionButtonEmbed();
		ExtentTestManager.getTest().pass("ViewAccesibleVersionButton is verified");
		loginPage.verifyInfoDesktopButtonEmbed();
		ExtentTestManager.getTest().pass("InfoDesktopButton is verified");
		loginPage.verifyContextAudioButtonEmbed();
		ExtentTestManager.getTest().pass("ContextAudioButton is verified");
		loginPage.verifyOverflowButtonEmbed();
		ExtentTestManager.getTest().pass("OverflowButton is verified");
		loginPage.switchToTheDefaultContent();
		loginPage.switchToTheVirtualtourFrame0();
		ExtentTestManager.getTest().pass("Frame is switched");
		loginPage.clickStartVitualExperienceEmbed();
		ExtentTestManager.getTest().pass("StartVitualExperience is clicked");
		loginPage.closeOtherTabAndSwitchToMain(browserName);
		ExtentTestManager.getTest().pass("Sub tabs are closed and main tab is opened");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode3_NewTabCustomorText(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab)["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("New - Tab : Custom or Text(Custom Text : New Tab) ["+browserName+"]", ExtentColor.RED));
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Hover : Animations", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab)["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab)["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickMixVteAnchor3Button();
		ExtentTestManager.getTest().pass("Click on mix_vte_anchor3 button");
		loginPage.verifyInlineEmbedHeader();
		ExtentTestManager.getTest().pass("InlineEmbedHeader is verified");
		loginPage.clickNewTabCustomTextLaunchButton();
		ExtentTestManager.getTest().pass("Click on NewTabCustomTextLaunch button");
		loginPage.switchToTheNewTab();
		loginPage.clickCloseRegistrationButton2();
		ExtentTestManager.getTest().pass("CloseRegistration button is clicked");
		loginPage.closeOtherTabAndSwitchToMain(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode6_StopOnly(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab) ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("New - Tab : Custom or Text(Custom Text : New Tab)", ExtentColor.RED));
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Hover : Animations", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab) ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_New - Tab : Custom or Text(Custom Text : New Tab) ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickStopStopOnlyLink();
		ExtentTestManager.getTest().pass("Click Stop only Button");
		loginPage.verifyStopOnlyDewaldChapelHeader();
		ExtentTestManager.getTest().pass("StopOnlyDewaldChapelHeader is verified");
		loginPage.switchToTheVirtualtourFrame1();
		loginPage.clickThirdpartyRoundButtonEmbed();
		ExtentTestManager.getTest().pass("ThirdpartyRound button is clicked");
		ExtentTestManager.getTest().pass("Click round Button");
		this.remoteDriver.switchTo().defaultContent();
		loginPage.switchToTheVirtualtourFrame();
		loginPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click on close Button");
		loginPage.closeOtherTabAndSwitchToMain(browser);
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode7_Stop(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_Stop ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Stop ["+browserName+"]", ExtentColor.RED));
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Hover : Animations ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Stop ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Stop ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickStopStopOnlyLink();
		ExtentTestManager.getTest().pass("Click Stop only Button");
		loginPage.verifyStopOnlyDewaldChapelHeader();
		ExtentTestManager.getTest().pass("StopOnlyDewaldChapelHeader is verified");
		loginPage.switchToTheVirtualtourFrame1();
		loginPage.clickThirdpartyRoundButtonEmbed();
		ExtentTestManager.getTest().pass("Click on round Button");
		loginPage.switchToTheDefaultContent();
		loginPage.switchToTheVirtualtourFrame();
		ExtentTestManager.getTest().pass("Frame is switched");
		loginPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode4_EmbedCodeValidThirdParty(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_Valid : Third Party ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Valid : Third Party ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Valid : Third Party ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Valid : Third Party ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickThirdPartyLinks1();
		ExtentTestManager.getTest().pass("Click Third Party Links1 Button");
		loginPage.navigateSmartScriptThirdPartyUrl(smartScriptThirdParty);
		loginPage.navigateToPreviousPage();
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Not Valid : Third Party", ExtentColor.RED));
		loginPage.clickThirdPartyLinks2();
		ExtentTestManager.getTest().pass("Click Third Party Links2 Button");
		loginPage.verifyMustNotrenderHeader();
		ExtentTestManager.getTest().pass("MustNotrenderHeader is verified");
		loginPage.navigateToPreviousPage();
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Immersive Banner : Default", ExtentColor.RED));
		loginPage.clickDefaultLinkGenerationLink();
		ExtentTestManager.getTest().pass("Click Default Link Generation Button");
		loginPage.verifyDefaultImmersiveBanner();
		ExtentTestManager.getTest().pass("DefaultImmersiveBanner is verified");
		loginPage.switchToTheVirtualtourFrame1();
		loginPage.navigateSmartScriptNoParamsUrl(smartScriptNoParasUrl);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Inline-Embed : Default", ExtentColor.RED));
		loginPage.switchToTheVirtualtourFrame0();
		loginPage.verifyViewAccesibleVersionButtonEmbed();
		ExtentTestManager.getTest().pass("ViewAccesibleVersion Button is verified");
		loginPage.verifyInfoDesktopButtonEmbed();
		ExtentTestManager.getTest().pass("InfoDesktop Button is verified");
		loginPage.verifyContextAudioButtonEmbed();
		ExtentTestManager.getTest().pass("ContextAudio Button is verified");
		loginPage.verifyOverflowButtonEmbed();
		ExtentTestManager.getTest().pass("Overflow Button is verified");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode5_RenderedLinkInvalidDefault(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("EmbedCode_rendered link - Invalid: Default ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("rendered link - Invalid: Default ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_rendered link - Invalid: Default ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_rendered link - Invalid: Default ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickDefaultLinkGenerationLink();
		ExtentTestManager.getTest().pass("Click Default Link Generation Button");
		loginPage.verifyWrongLinkAnchorEmbed();
		ExtentTestManager.getTest().pass("WrongLinkAnchor Button is verified");
		loginPage.clickVirtualTourLinkEmbed();
		ExtentTestManager.getTest().pass("Click VirtualTourLink");
		loginPage.switchToTheVirtualtourFrame();
		loginPage.clickCloseButton();
		ExtentTestManager.getTest().pass("Click Close_Registration Button");
		loginPage.navigateSmartScriptNoParamsUrl(smartScriptNoParasUrl);
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode_ResettingTheEmbedNoReRender(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("EmbedCode_ResettingTheEmbedNoReRender ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Resetting the Embed : No Re Render ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_ResettingTheEmbedNoReRender ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_ResettingTheEmbedNoReRender ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickStopStopOnlyLink();
		ExtentTestManager.getTest().pass("Click Stop only Button");
		loginPage.resetEmbedsTrue();
		loginPage.switchToTheVirtualtourFrame0();
		loginPage.clickEmbedPage();	
		ExtentTestManager.getTest().pass("Click EmbedPage ");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode9_IdenticalBehaviourToVTE(@Optional("IamOptional")String browser) throws Exception{
		System.err.println("EmbedCode_Identical Behaviour to VTE ["+browserName+"]");
		//ExtentTestManager.getTest().info(MarkupHelper.createLabel("Identical Behaviour to VTE ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Identical Behaviour to VTE ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Identical Behaviour to VTE ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickLegacyEmbedClassLink();
		ExtentTestManager.getTest().pass("Click on Legacy Embed Class Link");
		loginPage.switchToTheVirtualtourFrame0();
		loginPage.clickThirdpartyRoundButton();
		ExtentTestManager.getTest().pass("Click round Button");
		loginPage.switchToTheDefaultContent();
		loginPage.switchToTheVirtualtourFrame();
		ExtentTestManager.getTest().pass("Frame is switched");
		loginPage.clickCloseRegistrationButton2();
		ExtentTestManager.getTest().pass("Click on CloseRegistrationButton2");
		loginPage.navigatesmartScriptLatestIndexUrl(smartScriptLatestIndexUrl);
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Immediate Launch", ExtentColor.RED));
		loginPage.clickImmediateLaunchLink();
		ExtentTestManager.getTest().pass("Click on Immediate Launch Link");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode_Resetting1EmbedLink(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_Resetting1EmbedLink ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Resetting 1 Embed Link ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Resetting1EmbedLink ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Resetting1EmbedLink ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickMixVteAnchor1Button();
		ExtentTestManager.getTest().pass("Click on mix_vte_anchor1 button");
		loginPage.resetEmbedsByIndex0();
		ExtentTestManager.getTest().pass("Embeds resetted by index 0");
		loginPage.switchToTheVirtualtourFrame0();
		ExtentTestManager.getTest().pass("Frame is switched");
		loginPage.clickEmbedPage();
		ExtentTestManager.getTest().pass("Click on EmbedPage");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCodeResettingTheEmbedScanEmbedAgain(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCodeResettingTheEmbedScanEmbedAgain ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Resetting the Embed : Scan Embed again ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCodeResettingTheEmbedScanEmbedAgain ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCodeResettingTheEmbedScanEmbedAgain ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickStopStopOnlyLink();
		ExtentTestManager.getTest().pass("Click Stop only Button");
		loginPage.resetEmbedsFalse();
		loginPage.switchToTheVirtualtourFrame0();
		ExtentTestManager.getTest().pass("Frame is switched");
		loginPage.clickEmbedPage();
		ExtentTestManager.getTest().pass("Click on EmbedPage");
	}

	@Test   
	@Parameters({"browser"})
	public void EmbedCode10_RenderedLinkInvalidDefault(@Optional("IamOptional")String browser) throws Exception{

		System.err.println("EmbedCode_Dynamically injecting anchors ["+browserName+"]");
//		ExtentTestManager.getTest().info(MarkupHelper.createLabel("Dynamically injecting anchors ["+browserName+"]", ExtentColor.RED));
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "EmbedCode_Dynamically injecting anchors ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("EmbedCode_Dynamically injecting anchors ["+browserName+"]", ExtentColor.RED));

		loginPage.navigateToEmbedLogin(url);
		ExtentTestManager.getTest().pass("Login to application and navigated to Smart script page");
		loginPage.clickStopStopOnlyLink();
		ExtentTestManager.getTest().pass("Click Stop only Button");
		embedCodePage.totalLinks();
		embedCodePage.appendChild();
		embedCodePage.totalLinks1();
		embedCodePage.totalLinks11();
	}
}