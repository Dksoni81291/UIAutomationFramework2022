package com.qa.opencart.tests;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	public WebDriver driver;
	
	@BeforeClass
	public void regPageSetup() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random random = new Random();
		String email = "JanAutomation"+random.nextInt(1000)+"@gmail.com";
		return email;
	}
	
//	@DataProvider
//	public Object[][] getRegisterData() {
//		return new Object[][] {
//			{"Nitesh", "Agarwal", "7718844550", "nitesh@123", "yes"},
//			{"Anu", "Patil", "7718844332", "anu@123", "yes"},
//			{"Gagan", "Tyagi", "7718844221", "gag@123", "no"},
//		};
//	}
	
	@DataProvider
	public Object[][] getRegisterData(){
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
	}

}
