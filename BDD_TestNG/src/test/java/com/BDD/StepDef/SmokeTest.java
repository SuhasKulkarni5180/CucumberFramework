package com.BDD.StepDef;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import com.BDD.Pages.*;


public class SmokeTest {
	
	WebDriver driver = null;
	LoginPage login;

	@Before
	public void everyTime() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/suhas/Desktop/IBS/BDD/src/test/resources/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		//login =PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
	

	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		//System.setProperty("webdriver.chrome.driver","/Users/suhas/Desktop/IBS/BDD/src/test/resources/drivers/chromedriver");
		//driver= new ChromeDriver();

		driver.navigate().to("http://automationpractice.com/index.php");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//a['normalize-space(text())=Sign in']")).click();
		
		//driver.findElement(By.className("login")).click();
		login.clickOnSignIn();
		
		

	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		//driver.findElement(By.id("email")).click();
		
		login.enterUsername(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.enterPassword(password);

		
		
		//driver.findElement(By.id("email")).sendKeys(username);
		//driver.findElement(By.id("continue")).click();
	
		//driver.findElement(By.id("passwd")).click();
		//driver.findElement(By.id("passwd")).sendKeys(password);
		
		

	}

	@And("^clicks on submit button$")
	public void clicks_on_submit_button() {
		//driver.findElement(By.id("SubmitLogin")).click();
		login.signIn();

	}

	@SuppressWarnings("deprecation")
	@Then("^verify user is on home page$")
	public void verify_user_is_on_home_page() {
		
		String s =driver.findElement(By.xpath("//span[\"Suhas Kulkarni\"]")).getText();
		Assert.assertEquals("Suhas Kulkarni", s);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}



}
