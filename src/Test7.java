import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://qaclickacademy.com/practice.php");
		List<WebElement> checkbox1 = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
		checkbox1.get(1).findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		String lbl = checkbox1.get(1).getText();
		Select sel = new Select(driver.findElement(By.id("dropdown-class-example")));
		sel.selectByVisibleText(lbl);
		driver.findElement(By.cssSelector("input#name")).sendKeys(lbl);
		driver.findElement(By.id("alertbtn")).click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		Assert.assertTrue(alertMsg.contains(lbl));
		
		
	}

}
