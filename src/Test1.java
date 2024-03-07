import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[id*='checkBoxOption']"));
		
		System.out.println("Total checkboxes: "+ checkboxes.size());
		
		for (WebElement e: checkboxes) {
			e.click();
			break;
		}
		
		int i=1;
		for (WebElement e: checkboxes) {
			if (i==1) {
				Assert.assertTrue(e.isSelected());
			} else {
				Assert.assertFalse(e.isSelected());
			}
		}
		
		for (WebElement e: checkboxes) {
			e.click();
			break;
		}
		
		for (WebElement e: checkboxes) {
			Assert.assertFalse(e.isSelected());
		}
		
	}

}
