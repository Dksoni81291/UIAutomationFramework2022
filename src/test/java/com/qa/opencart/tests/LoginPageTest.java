package com.qa.opencart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100 - Design Login page for opencart application.")
@Story("US101 - Design Login Page Features")
public class LoginPageTest extends BaseTest{
	
//	public LoginPage loginPage;
	public WebDriver driver;
	
	@Test
	@Description("Login Page Title Test..")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageTitleTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println("page title is: "+actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE, Errors.LOGIN_PAGE_TITLE_MISMATCHED);
	}
	
	@Test
	@Description("Login Page URL Test..")
	@Severity(SeverityLevel.NORMAL)
	public void loginPageUrlTest() {
		String actualUrl = loginPage.getLoginPageUrl();
		System.out.println("Login page url is: "+actualUrl);
		Assert.assertTrue(actualUrl.contains(Constants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	@Description("Check forgot password link Test..")
	@Severity(SeverityLevel.CRITICAL)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	@Test
	@Description("Login Test- Positive Scenario..")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}
	
	
	@Test
	@Description("Check Register Link test..")
	@Severity(SeverityLevel.CRITICAL)
	public void isRegistrationLinkExist() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

}
