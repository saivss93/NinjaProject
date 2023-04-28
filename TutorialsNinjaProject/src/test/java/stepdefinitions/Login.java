package stepdefinitions;


import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	WebDriver driver;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	
	}

	@When("User enters valid email address {string}")
	public void user_enters_valid_email_address(String emailText) {
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
		
	}

	@And("User enters valid password {string}")
	public void user_enters_valid_password(String passwordText) {
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
	   
	}
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		driver.findElement(By.xpath("//input[@type='submit']"));

	}
	
	@Then("User should be successfully logged in")
	public void user_should_be_successfully_logged_in() {
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	   
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
	 
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(getEmailWithTimeStamp());
	}


	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials() {

		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(invalidPasswordText);
	}

	@And("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {

		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys();
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {

		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys();
	}
	
	 private String getEmailWithTimeStamp() {
	        Date date = new Date();
	        return "sai" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	    }
}
