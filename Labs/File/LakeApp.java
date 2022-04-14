package labFileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads in data records from the csv file and prints the lakes.
 * 
 * @author Jefson S
 *
 */
public class LakeApp {
	public static void main(String[] args) {
		List<Lake> lakes = new ArrayList<>();
		
		try(Scanner reader = new Scanner(LakeApp.class.getResourceAsStream("Lakes.csv"))) {
			  while(reader.hasNextLine()) {
				  Lake newLake = getLake(reader.nextLine());
				  if(newLake != null) {
					  lakes.add(newLake);
				  }
			  }
		}
		lakes.forEach(System.out::println);
//		for(Lake el: lakes) {
//			System.out.println(el);
//		}
	}

	/**
	* Creates a Lake object based on the data record passed as an argument.
	* The data record is expected to be of the following format: <br/>
	* {name of the lake},{depth},{has marina}<br/>
	* <p>
	* If the argument <code>line</code> doesn't match the expected format 
	* and the instance of Lake cannot be created, then the string "Error: " 
	* followed by the line should be printed to the standard error stream 
	* (<code>System.err</code>) and the method should return null.
	* 
	* @param line a line from a csv file that includes data about a lake
	* @return Lake object corresponding to the argument <code>line</code> 
	* or null if <code>line</code> didn't match the expected format.
	*/
	private static Lake getLake(String line) {
		String data[] = line.split(",");
		try {
			String name = data[0];
			int depth = Integer.parseInt(data[1]);
			boolean hasMarina = Boolean.parseBoolean(data[2]);
			
			return new Lake(name, depth, hasMarina);
			
		} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
			System.err.println("Error: " + line);
			return null;
		}
		
	}
}
