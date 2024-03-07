import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-remote-allow-origins=*");
		option.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://amazon.com");
		driver.findElement(By.id("captchacharacters")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("button.a-button-text")).click();
		WebElement txtbox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement accntSignin = driver.findElement(By.id("nav-link-accountList"));
		
		Actions a = new Actions(driver);
		a.moveToElement(txtbox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		a.moveToElement(accntSignin).contextClick().build().perform();

	}

}
