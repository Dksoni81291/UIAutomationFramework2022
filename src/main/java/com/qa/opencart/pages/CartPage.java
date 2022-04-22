package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	private By cart = By.id("Cart");
	
	public void addToCart() {
		System.out.println("Add to Cart is Done...");
	}

	public static void main(String[] args) {

		int i = 10;
		System.out.println(i);
		System.out.println("In Cart Page..");
		
		String f1 = "Feature 1";
		System.out.println(f1);
		
		String f2 = "Feature 2";
		System.out.println(f2);
	}

}
