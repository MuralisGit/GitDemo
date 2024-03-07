import java.util.Collections;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//JavascriptExecutor js = (JavascriptExecutor) driver; ul#ui-id-1 li.ui-menu-item
		
		driver.get("https://qaclickacademy.com/practice.php");
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		Thread.sleep(3000);
		int lstCount = driver.findElements(By.xpath("//li[@class='ui-menu-item']")).size();
		System.out.println(lstCount);
		
		for (int i=0;i<lstCount;i++) {
			if(driver.findElements(By.xpath("//li[@class='ui-menu-item']")).get(i).getText().contains("United Kingdom")) {
				driver.findElements(By.xpath("//li[@class='ui-menu-item']")).get(i).click();
			}
		}
		
		

	}

}
