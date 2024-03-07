import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://spicejet.com/");
		
		WebElement element01 = driver.findElement(By.xpath("//div[contains(text(),'From')]"));
		element01.click();
		WebElement element02 = driver.findElement(By.xpath("//div[contains(text(),'From')]/following-sibling::div[1]/input"));
		element02.sendKeys("MAA");
		Thread.sleep(2000L);
		//WebElement element03 = driver.findElement(By.xpath("//div[contains(text(),'MAA')]"));
		//element03.click();
		
		//WebElement element04 = driver.findElement(By.xpath("//div[contains(text(),'To')]"));
		//element04.click();
		WebElement element05 = driver.findElement(By.xpath("//div[contains(text(),'To')]/following-sibling::div[1]/input"));
		element05.sendKeys("BLR");
		Thread.sleep(2000L);
		//WebElement element06 = driver.findElement(By.xpath("//div[contains(text(),'BLR')]"));
		//element06.click();

	}

}
