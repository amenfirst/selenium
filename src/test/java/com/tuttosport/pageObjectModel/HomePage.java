package com.tuttosport.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement iconProfil = driver.findElement(By.id("_desktop_user_info"));
	@FindBy(id="_desktop_user_info") 
	public WebElement iconProfil;
	


	
}
