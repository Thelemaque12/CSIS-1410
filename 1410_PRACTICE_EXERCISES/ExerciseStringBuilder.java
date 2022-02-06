package exerciseStringBuilder;

public class ExerciseStringBuilder {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("Cats live");
		/**
		 * Change the first character 
		 * from uppercase C to lowercase r
		 */
		sb.replace(0, 1, "r");
		
		/**
		 * Add the following string to the end of sb: " on "
		 */
		sb.append(" on ");
		//System.out.println(sb);
		
		/**
		 * Change the content of sb so that it includes 
		 * the original content followed by the reverse content. Like this: 
		 * current text => current texttxet tnerruc
		 */

		
		StringBuilder temp = new StringBuilder(sb);
		sb.append(temp.reverse());
		System.out.println(sb);
		
		/**
		 * find the first 2 occurrence of 2 consecutives spaces..
		 * save the index in a variable called double space
		 */
		
		int doubleSpace = sb.indexOf("  ");
		sb.deleteCharAt(doubleSpace);
		
		/**
		 * In a single statement do the following two things:
			Replace the first letter of the content 
			of sb with ‘C’ and add a period (.) 
			at the end of the sentence.
		 */
		
		sb.replace(0, 1, "C").append(".");
		System.out.println(sb);

	}

}
