package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.Errors;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. private By locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwd =  By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//2. Public Page Constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. public page actions:
	@Step("getting login page title..")
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Step("getting login page url..")
	public String getLoginPageUrl() {
		//return driver.getCurrentUrl();
		return eleUtil.waitForUrl(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_FRACTION_URL);
	}
	
	@Step("Checking the forgot password link displayed or not..")
	public boolean isForgotPwdLinkExist() {
		//return driver.findElement(forgotPwd).isDisplayed();
		//return eleUtil.getElement(forgotPwd).isDisplayed();
		return eleUtil.doIsDisplayed(forgotPwd);
	}
	
	@Step("login to Application with username {0} and password {1}")
	public AccountsPage doLogin(String un, String pwd) {
		//	driver.findElement(emailId).sendKeys(un);
		//	driver.findElement(password).sendKeys(pwd);
		//	driver.findElement(loginBtn).click();

		eleUtil.waitForElementToBeVisible(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	@Step("login to Application with username {0} and password {1}")
	public boolean doInvalidLogin(String un, String pwd) {
		WebElement email_ele = eleUtil.waitForElementToBeVisible(emailId, Constants.DEFAULT_TIME_OUT);
		email_ele.clear();
		email_ele.sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		String actualErrorMessage = eleUtil.doElementGetText(loginErrorMessage);
		if(actualErrorMessage.contains(Errors.LOGIN_PAGE_ERROR_MESSAGE)) {
			return true;
		}
		return false;
	}
	
	@Step("Checking the registeration password link displayed or not..")
	public boolean isRegisterLinkExist() {
		//return driver.findElement(registerLink).isDisplayed();
		return eleUtil.waitForElementToBeVisible(registerLink, Constants.DEFAULT_TIME_OUT).isDisplayed();
	}
	
	@Step("Navigate to Register Page...")
	public RegistrationPage navigateToRegisterPage() {
		if(isRegisterLinkExist()) {
			//driver.findElement(registerLink).click();
			eleUtil.doClick(registerLink);
			return new RegistrationPage(driver);
		}
		return null;
	}
	
}
