import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Updateddropdown {

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
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//div[text()='Senior Citizen']/parent::div/preceding-sibling::div[1]
		WebElement checkbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
		Assert.assertFalse(checkbox.isSelected());
		System.out.println(checkbox.isSelected());
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		System.out.println(checkbox.isSelected());
		
		//count the number of checkboxes
		List<WebElement> chkboxelements = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(chkboxelements.size());
		
		WebElement noOfPsngrs = driver.findElement(By.id("divpaxinfo"));
		System.out.println(noOfPsngrs.getText());
		noOfPsngrs.click();
		Thread.sleep(2000L);
		
		for (int i=1;i<5;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(noOfPsngrs.getText(),"5 Adult");
		System.out.println(noOfPsngrs.getText());

	}

}
