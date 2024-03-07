import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://qaclickacademy.com/practice.php");
		//Actions act = new Actions(driver);
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.cssSelector("div#gf-BIG"));
		System.out.println(driver.findElements(By.cssSelector("div#gf-BIG a")).size());
		
		//cssSelector: table tbody tr td:nth-of-type(1) ul
		WebElement columdriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columdriver.findElements(By.tagName("a")).size());
		
		for (int i=1;i<columdriver.findElements(By.tagName("a")).size();i++) {
			columdriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
		Thread.sleep(5000);
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> itr = window.iterator();
		
		while(itr.hasNext()) {
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}

	}

}
