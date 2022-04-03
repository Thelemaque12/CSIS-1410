package wrapperClass;

import java.util.Arrays;
import java.util.Random;

public class DemoWrapperClass {

	/**
	 * 
	 * @return of type String
	 */
	public static String minMax() {
		StringBuilder sb = new StringBuilder();
		sb.append("Byte   : [" + Byte.MIN_VALUE + " , " + Byte.MAX_VALUE + "]\n");
		sb.append("Short  : [" + Short.MIN_VALUE + " , " + Short.MAX_VALUE + "]\n");
		sb.append("Integer: [" + Integer.MIN_VALUE + " , " + Integer.MAX_VALUE + "]\n");
		sb.append("Long   : [" + Long.MIN_VALUE + " , " + Long.MAX_VALUE + "]\n");
		sb.append("Float  : [" + Float.MIN_VALUE + " , " + Float.MAX_VALUE + "]\n");
		sb.append("Double : [" + Double.MIN_VALUE + " , " + Double.MAX_VALUE + "]");
		return (sb.toString());
	}
	
	/**
	 * The string includes representations of the number in base 10, base 16, base 8, and base 2. 
	 * The representations in base 16, base 8, and base 2 need to be determined at runtime 
	 * and they need to be listed in left-aligned columns of width 7.
	 * @param of type Integer
	 * @return of type String 
	 */
	public static String numberRepresentations(int n) {
		return String.format("%-7s  %-7s  %-7s  %s","" + n,Integer.toHexString(n),Integer.toOctalString(n),
				Integer.toBinaryString(n));
	}
	
	/**
	 * If the character is a lowercase letter, an uppercase letter, a number, or a white space, 
	 * it should be stated next to the character (separated by a single space). 
	 * If the character is none of the above, 
	 * nothing should be stated next to the character.
	 * @param of type Char
	 * @return of type String 
	 */
	public static String charProperties(char c) {
		StringBuilder sb = new StringBuilder();
		if (Character.isDigit(c)) {
			sb.append(c + " number");
		} else if (Character.isUpperCase(c)) {
			sb.append(c + " uppercase letter");
		} else if (Character.isLowerCase(c)) {
			sb.append(c + " lowercase letter");
		} else if (Character.isSpaceChar(c)) {
			sb.append(c + " white space");
		} else {
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * If the array is empty or null return 0,
	 * convert the elements of type string into numbers
	 * @param of type String[]
	 * @return of type Double
	 */
	public static double parseSum(String a[]) {
		double sum = 0;
		if(a == null) {
			return sum;
		}
		
		for(int i = 0; i < a.length; i++) {
			sum+= Double.parseDouble(a[i]);
		}
		return sum;
	}
	
	/**
	 * Any number between 100 and 999 should have 
	 * the same likelihood to be returned.
	 * @return a random three digit number of type int
	 */
	public static int getRandomThreeDigitNumber() {
		Random rand = new Random();
		int x = rand.nextInt(900) + 100;
		return x;

	}
	
	/**
	 * if character is lowercase the value should return lowercase 
	 * if character is uppercase the value should return uppercase
	 * @return a random letter of type char
	 */
	public static char getRandomLetter() {
		Random rand = new Random();
		char c; 
		if(rand.nextInt(2) == 1) {
			c = (char) (rand.nextInt(26) + 'a');
		}
		else 
			c = (char) (rand.nextInt(26) + 'A');
		
		return c;
	}
	
	/**
	 * test method 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minMax());
		System.out.println();

		int[] numbers = {9, 17, getRandomThreeDigitNumber(), 9876, 12346};
		System.out.printf("%-7s %-7s %-6s %s%n", "Base 10", "Base 16", "Base 8", "Base 2");
		System.out.printf("%-7s %-7s %-6s %s%n", "-------", "-------", "------", "------");
		for(int n: numbers) {
			System.out.println(numberRepresentations(n));
		}
		
		System.out.println();
		char[] characters = {'8', ' ', '#', 'a', 'M', getRandomLetter()};
		for(char c : characters) {
			System.out.println(charProperties(c));
		}
		
	
		System.out.println();
		String[] array = {"1.1", "2.5", "3.14", "40.04", "5.325", "63.5"};
		System.out.println(Arrays.deepToString(array)+" .. sum = " + parseSum(array));
	}
}

