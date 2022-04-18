package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Errors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 100 - Design Login page for opencart application.")
@Story("US101 - Design Login Page Features")
public class LoginPageNegativeTest extends BaseTest{
	
	@DataProvider
	public Object[][] getLoginNegativeData() {
		return new Object[][] {
			{"testwert@gmail.com","test122"},
			{"naveen@gmail.com","test2233"},
			{" ", "test@123"},
			{" ", " "}
		};
	}
	
	@Test(dataProvider ="getLoginNegativeData" )
	@Description("Login Test- Negative Scenario..")
	@Severity(SeverityLevel.NORMAL)
	public void loginInvalidTest(String username, String password) {
		Assert.assertTrue(loginPage.doInvalidLogin(username, password), Errors.LOGIN_PAGE_ERROR_MESSAGE_NOT_DISPLAYED);
	}
	
//	@Test
//	public void test1() {
//		int a = 20;
//		int b = 10;
//		int sum = a + b ;
//		Assert.assertEquals(sum, 40, "Sum is not correct..");
//	}

}
