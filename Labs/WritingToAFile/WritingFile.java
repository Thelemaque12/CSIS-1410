package writing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WritingFile {

	public static void main(String[] args) {
		try {
			PrintWriter writer = new PrintWriter("./src/writing/TimeTables.txt");
			
			for(int i = 1; i <= 10; i = i+2) {
				for(int j = 1; j <=10; j++) {
					String result = String.format("%2d * %2d = %2d \t%2d * %2d = %2d\n",j,i,i*j,j,(i+1),(i+1)*j);

					writer.write(result);					
				}
				writer.write("\n");				
			}
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
