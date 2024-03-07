package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day3 {
	
	
	@Test(dataProvider="getData")
	public void webLoginCarLoan(String name, String paswd) {
		System.out.println("Car Loan Web Login");
		System.out.println(name);
		System.out.println(paswd);
	}
	
	@Test
	public void mobileLoginCarLoan() {
		System.out.println("Car Loan Mobile Login");
	}
	
	@Test
	public void apiLoginCarLoan() {
		System.out.println("Car Loan API Login");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "firstusername";
		data[0][1] = "firstpassword";
		
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		
		return data;
	}

}
