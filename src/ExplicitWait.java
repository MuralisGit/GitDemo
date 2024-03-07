import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] product = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		addItems(driver, product);
		driver.findElement(By.cssSelector("a[class='cart-icon']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))).getText());

	}

	public static void addItems(WebDriver driver, String[] product) {

		List<WebElement> elements = driver.findElements(By.xpath("//div/h4"));
		int j=0;
		for (int i=0;i<elements.size();i++) {
			
			String name = elements.get(i).getText().split(" ")[0];
			List<String> veggies = new ArrayList<String>(Arrays.asList(product));
			
			if(veggies.contains(name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if(j==veggies.size()) {
					System.out.println("All veggies in list are added to cart");
					break;
				}
			}
		}
		
	
	}
}
