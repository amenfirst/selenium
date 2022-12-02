package com.tuttosport.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnexionPage {
	
	WebDriver driver;
	
	public ConnexionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

    //WebElement email = driver.findElement(By.name("email"));
	@FindBy(name = "email") public WebElement email;
    //WebElement password = driver.findElement(By.name("password"));
	@FindBy(name = "password") public WebElement password;
	// WebElement connectButton = driver.findElement(By.xpath("//button[@data-link-action='sign-in']"))
	@FindBy(xpath = "//button[@data-link-action='sign-in']") public WebElement connectButton;


	@FindBy(xpath = "//*[contains(@class,'alert-danger')]") public WebElement errorMessage;
}
