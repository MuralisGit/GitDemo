import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://qaclickacademy.com/practice.php");
		js.executeScript("window.scrollBy(0,600)");
		List<WebElement> tableRows = driver.findElements(By.cssSelector("table.table-display tbody tr"));
		int rowCount = tableRows.size();
		System.out.println(rowCount);
		List<WebElement> tableColms = driver.findElements(By.cssSelector("table.table-display tbody tr:nth-child(1) th"));
		int colmCount = tableColms.size();
		System.out.println(colmCount);
		
		for (int i=0;i<colmCount;i++) {
			System.out.println(driver.findElements(By.cssSelector("table.table-display tbody tr:nth-child(3) td")).get(i).getText());
		}
		
		

	}

}
