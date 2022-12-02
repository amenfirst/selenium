package Selenium_Bases;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeNavigate {

public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	String url = "https://www.google.com/";
	driver.navigate().to(url);
	
}

}
