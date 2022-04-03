package labCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jefson S
 *
 */
public class WarmUp {

	/**
	 * Creates a List of all even numbers between 2-50, 
	 * and performs mutations on it.
	 */
	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 2; i <= 50; i+=2) {
			numbers.add(i);
		}
		System.out.println("Numbers: ");
		printNumbers(numbers);
		
		System.out.println("\nRemoving all multiples of three...");
		numbers.removeIf(x -> x % 3 == 0);
		printNumbers(numbers);
	}

	/**
	 * Prints all elements of a List<Integer>
	 * @param numbers
	 */
	private static void printNumbers(List<Integer> numbers) {
		numbers.forEach(System.out::println);
	}
}
