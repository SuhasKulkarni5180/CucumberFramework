package com.CucumberBDD.StepDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.CucumberBDD.Pages.HomePage;
import com.CucumberBDD.Pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class SmokeTest {
	
	WebDriver driver = null;
	LoginPage login;
	HomePage home;
	
	
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {

		driver.navigate().to("http://automationpractice.com/index.php");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
		login.clickOnSignIn();
		
		

	}
	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		//driver.findElement(By.id("email")).click();
		
		login.enterUsername(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.enterPassword(password);

}
	
	@And("^clicks on submit button$")
	public void clicks_on_submit_button() {
		//driver.findElement(By.id("SubmitLogin")).click();
		login.signIn();

	}
	
	@Then("^verify user is on home page$")
	public void verify_user_is_on_home_page() {
		
		String s =driver.findElement(By.xpath("//span[\"Suhas Kulkarni\"]")).getText();
		Assert.assertEquals("Suhas Kulkarni", s);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@Then("user verify below tabs:")
	public void verifyTabs(DataTable data) {
		List<String> tabs=data.asList();
		for(String tab:tabs) {
			
		}
	}
	
	
	
	
	@Before
	public void everyTime() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/suhas/Desktop/IBS/Cucumber-BDD/src/test/resources/drivers/chromedriver");
		
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
}	
	
