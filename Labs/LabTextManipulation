package textManipulation;
 
import java.util.ArrayList;
import java.util.Scanner;
 
/**
 * User enters their favorite national parks.
 * 
 * Program creates a string that includes all 
 * their favorite parks in a specified format 
 * with ArrayLists:
 * 
 * {park1} | {park2} | . . . | {parkN}
 * 
 * NOTE: We eliminate the last value of the 
 * ArrayList, since it would be the exit 
 * condition ("done").
 * 
 * @author Jefson S
 *
 */
public class LabTextManipulation {
 
	public static void main(String []args) {
		
	     ArrayList<String> parks = new ArrayList<String>();
	     String userWord = " ";
	     
	     while(!userWord.equalsIgnoreCase("done")) {
	    	 System.out.print("Please enter your favorite National Park or DONE to stop: ");
	    	 userWord = new Scanner(System.in).nextLine();
	    	 parks.add(userWord);
	     }
	     
	     parks.remove(parks.size() - 1);
	     String fancyString = toFancyString(parks);
	     System.out.print("\n" +  fancyString);
	}
	
	/**
	 * creates a string based on list elements
	 * @param	list	list of parks user enter 	
	 * @return the list of parks as strings with updated spelling 
	 * separated by a space, a vertical bar, and another space
	 */
	public static String toFancyString(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		
			for(String el : list) {
				
				if(sb.length() > 0) {
					sb.append(" | ");
				}
				sb.append(el);
			}
			
		//return sb.toString();
			return updateSpelling(sb.toString());
	}
 
	/**
	 * update the spelling of the list elements 
	 * <p>
	 * @return the user's input from the ArrayList will be sorted 
	 * in such way that the first letter of each string will be capitalized,
	 * while the rest remains lower case.
	 * </p>
	 */
	private static String updateSpelling(String text){  
		 char[] chars = text.toLowerCase().toCharArray();
		  boolean found = false;
		  for (int i = 0; i < chars.length; i++) {
		    if (!found && Character.isLetter(chars[i])) {
		      chars[i] = Character.toUpperCase(chars[i]);
		      found = true;
		    } 
		    else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { 
		      found = false;
		    }
		 }
		  return String.valueOf(chars).trim(); 
	}
	
}
