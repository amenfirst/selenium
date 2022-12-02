package WaitsSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement cookies = driver.findElement(By.xpath("//*[@data-cookiebanner='accept_button']"));
		cookies.click();
		
		
		WebElement createAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		createAccount.click();
		
		//Thread.sleep(2000);
	
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(10)) //ceci temps total d’attendre
		.pollingEvery(Duration.ofMillis(500)) // ceci définit la fréquence d'interrogation  
		.ignoring(Exception.class); // ceci définit l’exception à ignorer   
		WebElement firstName= (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
	
		//WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Hanen");
		
		Thread.sleep(5000);
		
	}

}
