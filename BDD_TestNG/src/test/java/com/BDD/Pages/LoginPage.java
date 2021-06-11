package com.BDD.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;

/*	
	public LoginPage(WebDriver driver) {	
		PageFactory.initElements(driver, LoginPage.class);
		this.driver=driver;
		System.out.println("Constructor init");
	}
*/	
	@FindBy(xpath="//a[normalize-space(text())='Sign in']")
	private WebElement Sign;
	
	@FindBy(id ="search_query_top")
	private WebElement search;

	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement SignIn;
	
	public void clickOnSignIn() {
		System.out.println("Sign in ..........");
		search.click();
		search.sendKeys("Suhas");
		Sign.click();
	}
	
	public void enterUsername(String user) {
		username.click();
		username.sendKeys(user);
		
	}
	public void enterPassword(String pass) {
		password.click();
		password.sendKeys(pass);
	}
	public void signIn() {
		SignIn.click();
	}
	
	

}
