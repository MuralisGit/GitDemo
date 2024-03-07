import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> windows = handles.iterator();
		String parentWindow = windows.next();
		String childWindow = windows.next();
		driver.switchTo().window(childWindow);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		String courseTitle = driver.findElement(By.xpath("//a //div[@class='course-listing-title']")).getText();
		driver.switchTo().window(parentWindow);
		WebElement element = driver.findElement(By.name("name"));
		element.sendKeys(courseTitle);
		File src = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Lenovo\\Downloads\\screenshot_020523.png"));
		System.out.println(element.getRect().getDimension().getHeight());
		System.out.println(element.getRect().getDimension().getWidth());

	}

}
