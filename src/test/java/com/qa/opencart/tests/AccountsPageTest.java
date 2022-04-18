package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic 200 - Design Accounts page for open cart application")
@Story("US 101 - desgin login page features")
@Story("US 102 - desgin accounts page features")
public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	@Description("pre login for accounts page tests")
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	@Description("accounts Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void accountsPageTitle() {
		String actAccountPageTitle = accPage.getAccountPageTitle();
		Assert.assertEquals(actAccountPageTitle, Constants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	@Description("accounts Page header Test")
	@Severity(SeverityLevel.NORMAL)
	public void accPageHeaderTest() {
		Assert.assertTrue(accPage.isAccountPageHeaderExist());
	}
	
	@Test
	@Description("search Exist Test")
	@Severity(SeverityLevel.CRITICAL)
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
	@Description("acc Sections Test")
	@Severity(SeverityLevel.NORMAL)
	public void accSectionsTest() {
		List<String> actSecList	= accPage.getAccountsPageSectionList();
		System.out.println("Accounts Section list is: "+actSecList);
		Assert.assertEquals(actSecList, Constants.ACCOUNTS_SECTIONS_LIST);
	}
	
	@Test
	@Description("Search Header Test")
	@Severity(SeverityLevel.NORMAL)
	public void searchHeaderTest() {
		searchResultsPage=accPage.doSearch("Macbook");
		String actSearchHeader= searchResultsPage.getResultsPageHeaderValue();
		//Assert.assertEquals(actSearchHeader, "Search - "+"Macbook");
		Assert.assertTrue(actSearchHeader.contains("Macbook"));		
	}
	
	@Test
	@Description("check product count test after search")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProductTest() {
		searchResultsPage=accPage.doSearch("iMac");
		int actProductCount = searchResultsPage.getProductSearchCount();
		Assert.assertEquals(actProductCount, Constants.IMAC_PRODUCT_COUNT);
	}
	
	
	@Test
	@Description("check product list test after search")
	@Severity(SeverityLevel.CRITICAL)
	public void getSearchProductListTest() {
		searchResultsPage=accPage.doSearch("iMac");
		List<String> actProductList = searchResultsPage.getProductResultsList();
		System.out.println(actProductList);
	}
	
}
