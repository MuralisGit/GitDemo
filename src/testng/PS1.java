package testng;

import org.testng.annotations.Test;

public class PS1 extends PS {
	
	@Test
	public void testRun() {
		
		PS2 ps = new PS2(3);
//		ps.doThis();
//		int a=3;
		doThis();
		System.out.println(ps.increment());
		System.out.println(ps.decrement());
		System.out.println(ps.multiplyThree());
			
	}

}
