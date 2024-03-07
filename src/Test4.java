import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		Thread.sleep(2000);
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Muralidharan Raju");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("murlisms@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("#exampleInputPassword1"));
		password.sendKeys("Murali@123");
		WebElement checkbox = driver.findElement(By.cssSelector("input[class='form-check-input']"));
		checkbox.click();
		Select option = new Select(driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
		option.selectByIndex(1);
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("05/21/1991");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		System.out.println(driver.findElement(By.className("alert")).getText());
	
		
	}

}
