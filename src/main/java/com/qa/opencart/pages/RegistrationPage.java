package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmpassword=By.id("input-confirm");
	private By subscribeYes = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '1']");
	private By subscribeNo = By.xpath("//label[@class='radio-inline']//input[@type='radio' and @value = '0']");
	private By agreeCheckbox = By.name("agree");
	private By continueBtn = By.xpath("//input[@type='submit' and @value = 'Continue']");
	private By successMsg = By.cssSelector("div#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public boolean accountRegistration(String fName, String lName, String email, String telephone, String password, 
			String subscribe) {
		eleUtil.waitForElementToBeVisible(this.firstName, Constants.DEFAULT_TIME_OUT).sendKeys(fName);
		eleUtil.doSendKeys(this.lastName, lName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		}else {
			eleUtil.doClick(subscribeNo);;
		}
		
		eleUtil.doClick(agreeCheckbox);
		eleUtil.doClick(continueBtn);
		
		if(getAccountRegisterSuccessMsg().contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			goToRegisterPage();
			return true;
		}
		return false;
	}
	
	private String getAccountRegisterSuccessMsg() {
		return eleUtil.waitForElementToBeVisible(successMsg, Constants.DEFAULT_TIME_OUT).getText();
	}
	
	private void goToRegisterPage() {
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
	}

}
