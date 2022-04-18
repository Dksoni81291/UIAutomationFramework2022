package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.getBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.getBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.getBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		if(Boolean.getBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		return fo;
	}
}
