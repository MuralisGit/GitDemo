import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-remote-allow-origins=*");
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> urls = driver.findElements(By.cssSelector("li.gf-li a"));
		SoftAssert a = new SoftAssert();
		System.out.println(urls.size());
		
		for (WebElement url: urls) {
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url.getAttribute("href")).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode<400,"The link with Text: " + url.getText() + " is broken with code "+ responseCode);
			
			/*if (responseCode>400) {
				
				System.out.println("The link with text: "+ url.getText() + " is broken with code "+ responseCode); 
				//Assert.assertTrue(false);
			}*/
			
		}
		
		a.assertAll();
		
	}

}
