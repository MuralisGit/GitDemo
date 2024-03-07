import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-remote-allow-origins=*");
		option.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		int outsize = driver.findElements(By.tagName("frame")).size();
		for (int i=0;i<outsize;i++) {
			driver.switchTo().frame(i);
			//System.out.println(driver.findElements(By.tagName("frame")).size());
			int insize = driver.findElements(By.tagName("frame")).size();
			if (insize>1) {
				for (int j=0;j<insize;j++) {
					driver.switchTo().frame(j);
					System.out.println(driver.findElement(By.xpath("//body")).getText());
					driver.switchTo().parentFrame();
				}
				
			} else {
				System.out.println(driver.findElement(By.xpath("//body")).getText());
			}
		}
		
		driver.switchTo().defaultContent();

	}

}
