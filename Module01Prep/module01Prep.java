package m01;

public class module01Prep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {20,10};
		
		System.out.println(challenge1(numbers));

	}
	
	/**
	 * Creates and returns a new string based on the integer
	 * array provided as an argument  
	 * 
	 * @param numbers
	 * @return String based on the array elements 
	 */
	
	public static String challenge1(int[] numbers) {
		if(numbers == null) {
			return null;
		}

		if(numbers.length == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("*");
		
		for(int  i =  numbers.length -1; i >= 0; i--) {
			sb.append(numbers[i]).append("*");
		}


		return sb.toString();
	}	

}
