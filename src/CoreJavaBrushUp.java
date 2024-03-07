import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBrushUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myNum = 5;
		//string is an object representing sequence of characters //string literal
		String website = "rahulshettyacademy";
		
		//new memory allocate operator
		//String s1 = new String("Welcome");
		
		char letter = 'r';
		float dec = myNum;
		double dec2 = 1.4456;
		boolean myCard = true;
		
		System.out.println(myNum + " is the integer value stored in myNum variable");
		System.out.println(website);
		System.out.println(letter);
		System.out.println(dec);
		System.out.println(dec2);
		System.out.println(myCard);
		System.out.println("Git updates in GitDemo");
		
		int arr[] = new int[5];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 5;
		arr[3] = 7;
		arr[4] = 9;
		
		int arr1[] = {2, 4, 6, 8, 10};
		String arr2[] = {"murali", "sweatha", "vaishithaa"};
		List<String> nameArrayList = Arrays.asList(arr2);
		
		for (int i=0;i<nameArrayList.size();i++) {
			System.out.println(nameArrayList.get(i));
		}
		
		int arr3[] = {1,2,4,5,6,7,8,9,10,122};
		
		//System.out.println(arr);
		System.out.println(arr1[0]);
		
		for (int i=0; i<arr.length; i++) {	
			System.out.println(arr[i]);	
		}
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr1[i]);	
		}
		
		for (String s: arr2) {
			System.out.println(s);
		}
		
		for (int s: arr3) {
			if (s%2==0) {
				System.out.println(s);
				break;
			}
			else {
				System.out.println(s+" is not a multiple of 2");
			}
		}
		
		List<String> a = new ArrayList<String>();
		a.add("raju");
		a.add("navamani");
		a.add("ramya");
		
		System.out.println(a.get(0));
		
		for (int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));	
		}
		
		for (String s: a) {
			System.out.println(s);
		}
		
		System.out.println(a.contains("ramya"));
		
		//String operation
		String spl = "Rahul Shetty Academy";
		String[] splt = spl.split("Shetty");
		for (String str: splt) {
			System.out.println(str.trim());
		}
		
		for (int k=spl.length()-1;k>=0;k--) {
			System.out.println(spl.charAt(k));
		}
		
	}

}
