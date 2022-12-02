package com.tuttosport.run;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Helpers.ReportCucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" },
	glue = {"com.tuttosport.stepDefinitions"},
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"},
		tags = "@E2E")

public class TestRunner {
	
	public static WebDriver driver;
	@BeforeClass
	public static void setUp() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterClass
	public static void tearDown() {
		driver.quit();
		ReportCucumber.generateCucumberReport("Chrome");
	}
	
	

}
