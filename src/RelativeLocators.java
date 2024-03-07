import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice");
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name"));
		driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		WebElement chkbox = driver.findElement(By.xpath("//label[@class='form-check-label']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(chkbox)).click();
		WebElement radioBtn = driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		driver.findElement(with(By.tagName("input")).toRightOf(radioBtn)).click();
				
	}

}
