package com.tests.iwcFormerSuperContent;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.controls.ObjectsControl;
import com.pages.embedCode.EmbedCodeLoginPage;
import com.pages.iwcFormerSuperContent.IwcFormerSuperContentPage;
import com.tests.BaseTest;

public class IwcFormerSuperContentTest extends BaseTest{
	String url;
	IwcFormerSuperContentPage iwcFormerSuperContentPage = null;
	ObjectsControl objectControl = null;
	EmbedCodeLoginPage loginPage = null;
	@BeforeClass
	public void classSetUp() throws Exception{
		url = prop.getProperty("env1")+prop.getProperty("url_interactive");
		iwcFormerSuperContentPage = new IwcFormerSuperContentPage(remoteDriver);
		objectControl = new ObjectsControl(remoteDriver);
		loginPage = new EmbedCodeLoginPage(remoteDriver);
	}
	@Test   
	@Parameters({"browser"})
	public void IWCFormerSuperContent_VerifyTheElementsWhichAreIncludedForAllTheEmbedSizesThatAre731pxWidthorHigher(@Optional("IamOptional")String browser) throws Exception
	{
		System.err.println("VerifyTheElementsWhichAreIncludedForAllTheEmbedSizesThatAre731pxWidthorHigher");
		//ExtentTestManager.getTest().assignCategory("VerifyTheElementsWhichAreIncludedForAllTheEmbedSizesThatAre731pxWidthorHigher");
		ExtentTestManager.getTest().assignAuthor(browserName);
		ExtentTestManager.getTest().assignCategory(browserName);
		ExtentTestManager.getTest().generateLog(Status.INFO, "VerifyTheElementsWhichAreIncludedForAllTheEmbedSizesThatAre731pxWidthorHigher ["+browserName+"]");
		ExtentTestManager.getTest().info(MarkupHelper.createLabel("VerifyTheElementsWhichAreIncludedForAllTheEmbedSizesThatAre731pxWidthorHigher ["+browserName+"]", ExtentColor.RED));

		iwcFormerSuperContentPage.navigateToIwcFormerSuperContentLogin(url);
		ExtentTestManager.getTest().pass("IWC former super content is logged in");
		iwcFormerSuperContentPage.clickInlineEmbedStonybrookCifLink();
		iwcFormerSuperContentPage.pageRefresh();
		loginPage.switchToTheVirtualtourFrame0();
		ExtentTestManager.getTest().pass("Frame is switched");
		iwcFormerSuperContentPage.clickExpandFullScreenIcon();
		ExtentTestManager.getTest().pass("Click on expand_full_screen_icon");
		iwcFormerSuperContentPage.verifyScheduleVisitButton();
		ExtentTestManager.getTest().pass("ScheduleVisitButton is verified");
		iwcFormerSuperContentPage.verifyRegisterNowButton();
		ExtentTestManager.getTest().pass("RegisterNowButton is verified");
		iwcFormerSuperContentPage.verifyApplyOnlineButton();
		ExtentTestManager.getTest().pass("ApplyOnlineButton is verified");
		iwcFormerSuperContentPage.clickMoreButton();
		ExtentTestManager.getTest().pass("MoreButton is verified");
		iwcFormerSuperContentPage.clickCollapseFullScreenButton();
		ExtentTestManager.getTest().pass("CollapseFullScreenButton is clicked");
		loginPage.switchToTheVirtualtourFrame0();
		iwcFormerSuperContentPage.clickMoreButton();
		ExtentTestManager.getTest().pass("MoreButton is clicked");
		iwcFormerSuperContentPage.clickLanguageButton();
		ExtentTestManager.getTest().pass("Language button is clicked");
		iwcFormerSuperContentPage.verifyEnglishLanguageField();
		ExtentTestManager.getTest().pass("EnglishLanguageField is verified");
		iwcFormerSuperContentPage.verifySpanishLanguageField();
		ExtentTestManager.getTest().pass("SpanishLanguageField is verified");
		iwcFormerSuperContentPage.verifyChineseLanguageField();
		ExtentTestManager.getTest().pass("ChineseLanguageField is verified");		
	}
}
