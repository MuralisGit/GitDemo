import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://path2usa.com/travel-companion");
		
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		Thread.sleep(1000);
		System.out.println("Current Month: " + driver.findElement(By.cssSelector("div.flatpickr-month div.flatpickr-current-month span")).getText());
		
		while(!driver.findElement(By.cssSelector("div.flatpickr-month div.flatpickr-current-month span")).getText().contains("April")) {
			System.out.println(driver.findElement(By.cssSelector("div.flatpickr-month div.flatpickr-current-month span")).getText());
			driver.findElement(By.cssSelector("div.flatpickr-month span.flatpickr-next-month")).click();
			Thread.sleep(3000);
		}

		List<WebElement> dayValue = driver.findElements(By.cssSelector(".flatpickr-day"));

		int count = dayValue.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			//System.out.println(dayValue.get(i).getText());
			System.out.println(driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText());
			if (driver.findElements(By.cssSelector(".flatpickr-day")).get(i).getText().equals("30")) {
				System.out.println("Date Found!");
				driver.findElements(By.cssSelector(".flatpickr-day")).get(i).click();
				break;
			}
		}
		

	}

}
