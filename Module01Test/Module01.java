package m01;
/**
 * Module 01 Test 
 * @author Jefson S
 *
 */

public class Module01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(challenge1("Ho Ho Ho!"));
		int[] a = {11,2,333,4,6,555,8,777};
		System.out.println(challenge2(a));

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
		String str2 = ""; 
		
		for(int i = 1; i < str.length(); i++) {
			str2 = str2 + str.charAt(i);
		}
		str2 = str2 + str.charAt(0);
		str2 = str2.toLowerCase();
		if(str2.length() <= 3) {
			return "["+str2+"]";
		}
		return str2;

		
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
