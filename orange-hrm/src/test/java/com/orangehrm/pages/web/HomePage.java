package com.orangehrm.pages.web;

import java.util.concurrent.TimeUnit;

import org.iqa.suite.commons.TestMetaData;
import org.iqa.suite.commons.applitool.ApplitoolEyesWeb;
import org.iqa.test.base.BasePageBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.google.common.util.concurrent.Uninterruptibles;

public class HomePage extends BasePageBrowser {

	//BasePage provides driver object, logger object
	
	@FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")
	private WebElement welComeText;

	public HomePage verifyWelcomeText(String strWelComeText) throws InterruptedException {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		logger.info("********** In verify welcome message method");
		logger.info("********** Run time data stored check - Title "+getRunTimeTestData("BrowserTitle"));
		Assert.assertEquals(welComeText.getText(), strWelComeText,"Test case failed because expected data not found");
		return this;
	}

	public HomePage isPageLoaded() {
		if (TestMetaData.getTestTags().contains("@ScreenValidation") && ApplitoolEyesWeb.enabled) {
            ApplitoolEyesWeb.getEyes().checkWindow("Home Page");
        }
		return this;
	}
}
