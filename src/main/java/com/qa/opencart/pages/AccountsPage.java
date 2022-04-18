package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//1. Private by locators
	private By search = By.name("search");
	private By searchBtn = By.cssSelector("div#search button");
	private By header = By.cssSelector("div#logo a");
	private By accountsList = By.cssSelector("div#content h2");
	
	//2. public constructor
	
	public AccountsPage(WebDriver driver) {
		this.driver= driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		//return driver.getTitle();
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNTS_PAGE_TITLE);
	}
	
	public boolean isAccountPageHeaderExist() {
		//return driver.findElement(header).isDisplayed();
		return eleUtil.doIsDisplayed(header);
	}
	
	public boolean isSearchExist() {
		//return driver.findElement(search).isDisplayed();
		return eleUtil.doIsDisplayed(search);
	}
	
	public SearchResultsPage doSearch(String productName) {
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, productName);
			eleUtil.doClick(searchBtn);
			return new SearchResultsPage(driver);
		}
		return null;
	}
	
	public List<String> getAccountsPageSectionList() {
		//List<WebElement> secList = driver.findElements(accountsList);
		List<WebElement> secList = eleUtil.getElements(accountsList);
		List<String> accSecValList = new ArrayList<String>();
		
		for(WebElement e : secList) {
			String text = e.getText();
			accSecValList.add(text);
		}
		
		return accSecValList;
	}
	

}
