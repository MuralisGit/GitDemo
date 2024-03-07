import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement element1 = driver.findElement(By.id("inputUsername"));
		element1.sendKeys(name);
		WebElement element2 = driver.findElement(By.name("inputPassword"));
		element2.sendKeys("hello123");
		WebElement element3 = driver.findElement(By.className("signInBtn"));
		element3.click();
		WebElement element4 = driver.findElement(By.cssSelector("p.error"));
		System.out.println(element4.getText());
		WebElement element5 = driver.findElement(By.linkText("Forgot your password?"));
		element5.click();
		Thread.sleep(1000);
		WebElement element6 = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		element6.sendKeys("John");
		WebElement element7 = driver.findElement(By.cssSelector("input[placeholder='Email']"));
		element7.sendKeys("john@rsa.com");
		WebElement element8 = driver.findElement(By.xpath("//input[@type='text'][2]"));
		element8.clear();
		WebElement element9 = driver.findElement(By.cssSelector("input[type='text']:nth-child(3)"));
		element9.sendKeys("john@gmail.com");
		WebElement element10 = driver.findElement(By.xpath("//form/input[3]"));
		element10.sendKeys("8976453678");
		WebElement element11 = driver.findElement(By.cssSelector(".reset-pwd-btn"));
		element11.click();
		WebElement element12 = driver.findElement(By.cssSelector("form p"));
		System.out.println(element12.getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		WebElement element13 = driver.findElement(By.cssSelector("#inputUsername"));
		element13.sendKeys(name);
		WebElement element14 = driver.findElement(By.cssSelector("input[type*='pass']"));
		element14.sendKeys("rahulshettyacademy");
		WebElement element15 = driver.findElement(By.id("chkboxOne"));
		element15.click();
		WebElement element16 = driver.findElement(By.xpath("//button[contains(@class,'submit')]"));
		element16.click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		WebElement element17 = driver.findElement(By.xpath("//*[text()='Log Out']"));
		element17.click();
		driver.close();
		
	}
	
	public String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		//String[] passwordArray = passwordText.split("'");
		String password = passwordText.split("'")[1];
		return password;
		
	}

}
