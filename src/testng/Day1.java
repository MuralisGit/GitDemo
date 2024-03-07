package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {
	
	@AfterTest
	public void lastExecution() {
		System.out.println("Final Execution");
	}
	
	@Test
	public void demo() {
		System.out.println("Hello!");
		Assert.assertTrue(false);
	}
	
	@Test
	public void secondTest() {
		System.out.println("Bye!");
	}
	
	@Test
	public void fourthTest() {
		System.out.println("Fourth!");
	}


}
