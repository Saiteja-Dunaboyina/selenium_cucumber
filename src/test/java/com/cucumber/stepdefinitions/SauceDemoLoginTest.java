package com.cucumber.stepdefinitions;

import static org.junit.Assert.assertEquals;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pages.AddToCartPage;
import com.cucumber.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLoginTest {
	public LoginPage loginPage;
	public static WebDriver driver;
	public AddToCartPage addToCartPage;
	
	
	@Given("User is on the sauce demo login page")
	public void user_is_on_the_sauce_demo_login_page() {
	    driver = new ChromeDriver();
	    WebDriverManager.chromedriver().setup();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@When("/^User enters the (.*) and (.*)$/")
	public void user_enters_the_username_and_password(String username,String password) {
	    loginPage = new LoginPage(driver);
	    loginPage.enterUsernameAndPassword(username,password);
	}

	@And("Click on login button")
	public void click_on_login_button() {
	    loginPage.clickOnLoginButton();
	}

	@Then("User navigates to home page")
	public void user_navigates_to_home_page() throws Exception {
	  String headerText = loginPage.getHeaderText();
	  Thread.sleep(3000);
	  assertEquals(headerText, "Swag Labs");
	}
	
	@And("Logout from the application")
	public void logout_from_the_application() {
	    loginPage.logout();
	}
	
	@And("browser closes automatically")
	public void browser_closes_automatically() {
	   driver.quit();
	}

}
