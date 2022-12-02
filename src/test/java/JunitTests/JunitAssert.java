package JunitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitAssert {

	static WebDriver driver;
	@AfterClass
	public static void afterClass() {
		System.out.println("après tous les cas de test");
		
	}
	@After
	public void afterTest() {
		driver.close();
		System.out.println("après chaque cas de test");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("avant tous les cas de test");
		WebDriverManager.chromedriver().setup();
	}
	@Before
	public void beforeTest() {
		System.out.println("avant chaque cas de test");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://"+ System.getProperty("user.dir") +"/src/main/resources/applications/interaction.html");
	}

	@Test
	public void Test01() {
		
		String title_obtenu = driver.getTitle();
		String title_attendu = "Interactive Elements";
		
		assertEquals("le titre n'est correct", title_obtenu, title_attendu);
		System.out.println("le test est succès");
		
		
	}
	
	@Test
	public void Test02() {
		
		String title_obtenu = driver.getTitle();
		String title_attendu = "Interactive Elements";
		
		
		assertTrue("le titre n'est pas correct", title_obtenu.contains(title_attendu));
		System.out.println("le test est succès");
		
	}
	@Test
	public void Test03() {

		String title_obtenu = driver.getTitle();
		String title_attendu = "Interactive Elements";
		
		assertSame("le titre n'est pas correct", 2,2);
		System.out.println("le test est succès");
		
	}

}
