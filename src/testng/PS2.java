package testng;

public class PS2 extends PS3 {
	
	int a;
	public PS2(int a) {
		super(a); // invoke parent class constructor.
		this.a=a;
	}

	public int increment() {
		return a+=1;
	}
	
	public int decrement() {
		return a-=1;
	}

}
