import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('div.tableFixHead').scrollTop=5000");
		
		List<WebElement> result = driver.findElements(By.cssSelector("div.tableFixHead table#product tbody tr td:nth-child(4)"));
		int sum = 0;
		for (int i=0;i<result.size();i++) {
			sum = sum + Integer.parseInt(result.get(i).getText());	
		}
		System.out.println("Total: " + sum);
		
		int totDisplayed = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(" ")[3]);
		
		Assert.assertEquals(sum, totDisplayed);
	}

}
