package keyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClient {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Part 1:");
		System.out.println("----------");
		
		KeyValuePair<String, Integer> city1 = new KeyValuePair<>("SLC", 189899);
		KeyValuePair<String, Integer> city2 = new KeyValuePair<>("NY", 8244910);
		KeyValuePair<String, Integer> city3 = new KeyValuePair<>("NY", 8244910);
		
		System.out.println("city1: " + city1);
		System.out.println("city2: " + city2);
		System.out.println("city1.equals(city2): " + city1.equals(city2) +"\n");
		
		System.out.println("city3: " + city3);
		System.out.println("city2.equals(city3): " + city2.equals(city3) +"\n");
		
		System.out.println("Part 2:");
		System.out.println("----------");
		
		KeyValuePair<String, Integer> city4 = new KeyValuePair<>("LA", 3819702);
		KeyValuePair<String, Integer> city5 = new KeyValuePair<>("SF", 812826);
		
		List<KeyValuePair<String, Integer>> cities = new ArrayList<>();
		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		cities.add(city4);
		cities.add(city5);
		
		System.out.println("Original List:");
		cities.forEach(System.out::println);

		System.out.println("\nSorted List:");
		Collections.sort(cities);
		cities.forEach(System.out::println);
		
		System.out.println("\nPart 3:");
		System.out.println("----------");
		
		System.out.println("Cities with margin 5: ");
		printWithMargin(cities, 5);
		
		Set<KeyValuePair<Integer, String>> countryCodes = new HashSet<>();
		 countryCodes.add(new KeyValuePair<Integer, String>(30, "Greece"));
		 countryCodes.add(new KeyValuePair<Integer, String>(33, "France"));
		 countryCodes.add(new KeyValuePair<Integer, String>(43, "Austria"));
		 
		 System.out.println("\nCountry codes with margin 3:");
		 printWithMargin(countryCodes, 3);

	}
	
	
	public static <T> void printWithMargin(Collection<T> collection, int indentation) {
		String space = "";

		for(int i = 0; i < indentation; i++) {
			space += " ";
		}
		
		for(T item: collection) {
			System.out.println(space + item);

		}
	}

}
