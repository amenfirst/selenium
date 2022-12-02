package InteractionsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hoverOver {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://"+ System.getProperty("user.dir") +"/src/main/resources/applications/interaction.html");
		
		WebElement button = driver.findElement(By.id("hoverOver"));
		Actions actions = new Actions(driver);
		
		//actions.scrollToElement(button).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", button);
		
		Thread.sleep(2000);
		actions.moveToElement(button, 40, 16).contextClick().build().perform();
		
		//Thread.sleep(5000);
		//actions.moveByOffset(800, 200).build().perform();
	}

}
