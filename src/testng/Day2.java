package testng;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day2 {
	
	@BeforeTest
	public void firstExecution() {
		System.out.println("First Execution!");
	}
	
	@Parameters({"URL","APIKey/Username"})
	@Test
	public void thirdTest(String url, String usrnm) {
		System.out.println("Third!");
		System.out.println(url);
		System.out.println(usrnm);
		
	}

}
