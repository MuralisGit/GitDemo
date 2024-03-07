package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class PS {

	public void doThis() {	
		System.out.println("I am here");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method in Parent Class");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method in Parent Class");
	}
	
	
}
