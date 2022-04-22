package labSerialization;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * LabSerialization demonstrates how to serialize and deserialize
 * a custom object that references other objects on the heap.
 * Author(s): Starter Code + ........... // fill in your name
 */
public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo demo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));

                //displayListAndSet(demo);
        serialize(demo, "src/labSerialization/Demo.ser");
        ListVsSetDemo newDemo = deserialize("src/labSerialization/Demo.ser");
        displayListAndSet(newDemo);

    };

    /**
     * Displays the elements of the list and the set.
     */
    private static void displayListAndSet(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }

    /**
     * Serializes ListVsSetDemo to a File.
     * 
     * @param demo
     * @param filename
     */
    public static void serialize(ListVsSetDemo demo, String filename) {

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filename)))) {
            out.writeObject(demo);
            out.close();
            System.out.println("serialization is complete.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
    
    /**
     * Returns a deserialized
     * ListVsSetDemo from a File.
     * 
     * @param filename
     */
    public static ListVsSetDemo deserialize(String filename) {
    	ListVsSetDemo data = null;
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(filename)))){
    		data = (ListVsSetDemo)in.readObject();
    		in.close();
    		
    	} catch (Exception e) {
    		 System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		} 
    	return data;
    }
}
