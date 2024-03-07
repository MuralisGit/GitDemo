import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreaming {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		regular();

	}*/
	
	//@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		namesWithA(names);
		
	}
	
	public void namesWithA(ArrayList<String> names) {
		int count =0;
		for (int i=0;i<names.size();i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	//@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		Long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
	}
	
	//@Test
	public void streamDisplay() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	//@Test
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Man");
		names.add("Dona");
		names.add("Women");
	
		Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		String[] names1 = {"Abhijeet","Don","Alekhya","Adam","Rama"};
		List<String> list = Arrays.asList(names1);
		list.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> newStream = Stream.concat(names.stream(), list.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean val = newStream.anyMatch(s->s.equalsIgnoreCase("Adam77"));
		System.out.println(val);
		Assert.assertTrue(val);
		
	}
	
	@Test
	public void streamCollect() {
	
		List<String> ls = Stream.of("Abhijeet","Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> nmbr = Arrays.asList(3,2,2,7,5,1,9,7);
		//nmbr.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> values = nmbr.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(values.get(2));
		
	}
	

	

}
