package LocalisationsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalisationPartialLinkText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://"+ System.getProperty("user.dir") +"/src/main/resources/applications/interaction.html");
		
		WebElement titreElement = driver.findElement(By.partialLinkText("Google"));
		System.out.println(titreElement.getText());
	}

}
