package Selenium_Bases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeManager {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();;
		String url = "https://www.google.com/";
		driver.get("file:///C:/Users/YUZER/Documents/Archivage_Doc/DOC_Perso_Anis/Formations/Selenium-formation-pro/java-formation/axesxpath.html");
		String titre = driver.getTitle();
		System.out.println(titre);
		
		String urlGet = driver.getCurrentUrl();
		System.out.println(urlGet);
		
		//String source = driver.getPageSource();
		//System.out.println(source);
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);
		driver.quit();
	}

}
