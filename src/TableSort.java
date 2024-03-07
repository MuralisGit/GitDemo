import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th")).click();
		
		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> actualList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortdList = actualList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(actualList, sortdList);
		
		List<String> str;
		do {
			
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			str = rows.stream().filter(s->s.getText().contains("Rice")).
					map(s->getPriceVeggie(s)).collect(Collectors.toList());
			str.forEach(a->System.out.println(a));
			if (str.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
			
		} while (str.size()<1);
		
	}
	
	public static String getPriceVeggie(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
