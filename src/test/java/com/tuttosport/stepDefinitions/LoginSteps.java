package com.tuttosport.stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.tuttosport.pageObjectModel.ConnexionPage;
import com.tuttosport.pageObjectModel.HomePage;
import com.tuttosport.run.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	static WebDriver driver = TestRunner.driver;
	HomePage homePage = new HomePage(driver);
	ConnexionPage connexionPage = new ConnexionPage(driver);
	
	@After
	 public void tearDown(Scenario scenario)
	 {
	 if(scenario.isFailed()) {
		 final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 scenario.attach(screenshot, "image/png", scenario.getName());
	 }
	 
	 }

	@Given("I launch the TUTTO application #pré-conditions")
	public void i_launch_the_tutto_application_pré_conditions() {
	    // Write code here that turns the phrase above into concrete actions

	    driver.get("https://www.tuttosport.com.tn/");
	}

	@When("I click on login icon of nav-menu #action")
	public void i_click_on_login_icon_of_nav_menu_action() {
	    // Write code here that turns the phrase above into concrete actions
		//WebElement iconProfil = driver.findElement(By.id("_desktop_user_info"));
	
		homePage.iconProfil.click();
		//iconProfil.click();
	    
	}

	@Then("Connexion Page is opened #resultat attendu")
	public void connexion_page_is_opened_resultat_attendu() {
	    // Write code here that turns the phrase above into concrete actions
	    String expectedResult = "Connexion";
	    String actualResult = driver.getTitle();
	assertTrue("The connexion page is not opened", actualResult.equals(expectedResult));
	}

	@When("I enter the mail and password correct")
	public void i_enter_the_mail_and_password_correct() {
	    // Write code here that turns the phrase above into concrete actions
		

	    //WebElement email = driver.findElement(By.name("email"));
		//WebElement password = driver.findElement(By.name("password"));
	    
	    connexionPage.email.sendKeys("anis.fatnassi.c@gmail.com");	    
	    connexionPage.password.sendKeys("06061993");
	    
	}

	@When("I click on connect button")
	public void i_click_on_connect_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //WebElement connectButton = driver.findElement(By.xpath("//button[@data-link-action='sign-in']"));
	  
		connexionPage.connectButton.click();
	}

	@Then("I connect to my application's account")
	public void i_connect_to_my_application_s_account() {
	    // Write code here that turns the phrase above into concrete actions
	    String expectedResult = "/mon-compte";
	    String actualResult = driver.getCurrentUrl();
	    assertTrue("My account page is not opened", actualResult.contains(expectedResult) );
	}
	@When("I enter the mail {string} and password {string}")
	public void i_enter_the_mail_and_password(String email, String password) {
	    // Write code here that turns the phrase above into concrete actions
	  connexionPage.email.sendKeys(email);
	  connexionPage.password.sendKeys(password);
	}

	@Then("An error {string} is dispalyed")
	public void an_error_is_dispalyed(String message) {
	    // Write code here that turns the phrase above into concrete actions
		String resultat_attendu = message;
		String resultat_obtenu = connexionPage.errorMessage.getText().trim();
	    assertTrue("Error message is not displayed",resultat_obtenu.contains(resultat_attendu) );
	}
}
