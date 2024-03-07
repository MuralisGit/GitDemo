
public class Methodsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methodsdemo method = new Methodsdemo();
		String out = method.getData();
		System.out.println(out);
		Methodsdemo2 method1 = new Methodsdemo2();
		String out1 = method1.getUserData();
		System.out.println(out1);
		getData1();
		
	}
	
	public String getData() {
		System.out.println("Hello World");
		System.out.println("Hello World1");
		return "rahul shetty";
	}
	
	public static void getData1() {
		System.out.println("Hello World!");
	}

}
