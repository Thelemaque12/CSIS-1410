package m01;

import java.util.Arrays;

/**
 * Module 01 Test 
 * @author Jefson S
 *
 */

public class Module01 {

	public static void main(String[] args) {

		System.out.println("First letter of Ho Ho Ho! should now be the last letter: " + challenge1("Ho Ho Ho!"));
		int[] a = {11,2,333,4,6,555,8,777};
		System.out.println("print all the single digits numbers and the total count of single digits numbers: " + challenge2(a));

	}
	/**
	 *change all uppercase letter to lowercase letter move the 
	 *first letter from the beginning to the end of the string 
	 * @param str of type String 
	 * @return string based on the string provided as an argument
	 */
	public static String challenge1(String str) {
		
		if(str == "") {
			return "["+str+"]";
		}
		
		StringBuilder sb = new StringBuilder();
		String str1 = str.substring(0,1).toLowerCase();
		String str2 = str.substring(1, str.length()).toLowerCase();
		
		sb.append(str2).append(str1);
		
		if(sb.length() <= 3) {
			return "["+sb+"]";
			
		}
		
		return sb.toString();

		
	}
	/**
	 *  create and return a new string based on the array that is provided as an argument. 
	 *  return only the single digits numbers.. 
	 * @param numbers of type integer 
	 * @return return a new string based on the array that is provided as an argument
	 */
	public static String challenge2(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		if(numbers == null) {
			return null;
		}
		
		if(numbers.length == 0) {
			return "("+count+")";
		}
		
		for(int n: numbers) {
			if(n >= 0 && n <=9) {
				count += 1;
				sb.append(n).append("-");
			}
		}
		
		
		return sb.toString() + "(" + count + ")";
	}
}
