package recursion;


/**
 * Program evaluates an equal amount
 * of tests for each method in order 
 * to determine their accuracy,
 * and performance with JUnit.
 * 
 * @author Jefson S
 */

public class Recursion {
	/**
	 * This method returns the sum of all the digits. 
	 * Notice that the minus sign is ignored
	 * @param n numbers to add 
	 * @return the sum of all digits 
	 */
	public static int sumOfDigits(int n) {

		if(n == 0) {
			return 0;
		}
		else {
			return Math.abs(n) % 10 + sumOfDigits(n/10);
		}
	}

	/**
	 * Returns the string with all 
	 * characters in UpperCase,
	 * and with a space in between.
	 * 
	 * @param str of type String.
	 * @return <code>String</code>
	 * with spaces between characters
	 * and values in UpperCase.
	 */
	public static String toUpper(String str) {
		String splt = str.replaceAll(".(?=.)", "$0 ");
		
		return splt.toUpperCase();
		
	}
	
	/**
	 * Determines the number of smiles 
	 * <code>:)</code> in an array of different 
	 * types of characters and symbols.
	 * 
	 * @param letters of type char within array.
	 * @param index of type integer.
	 * @return <code>smileCounter</code> 
	 * of type integer as number of smiles.
	 * 
	 * NOTE: If there is a smile,
	 * then increment the counter
	 * – i.e. <code>smileCounter++</code>.
	 */
	
	public static int countSmiles(char[] letters, int index) {
		
		if (letters == null || index < 0 || (index + 1) >= letters.length) {
	            return 0;
		}

	    if (letters[index] == ':' && letters[index + 1] == ')') {
	        return 1 + countSmiles(letters, index + 2);

	    }

	    else {
	        return countSmiles(letters, index + 1);

	    }
	    

	 }
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static double harmonic (int n) { 
		   if (n == 0) 
		      throw new IllegalArgumentException("The argument n can't be zero."); 

		   if (n == 1) 
		      return 1; 
		   else if (n < 0) 
		      return -1 * harmonic(-n); 
		   else // n > 1 
		      return 1.0/n + harmonic (n - 1); 
		}

}
