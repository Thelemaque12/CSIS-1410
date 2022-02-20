package phones;

import java.util.Random;

/**
 * Extension of class Phone,
 * with the addition of the integer 
 * @author Jefson S
 *
 */

public class SmartPhone extends Phone{

	private int storage;
	
	/**
	 * Only positive values are allowed for the field storage 
	 * @param model of type String
	 * @param dimension of type Dimension
	 * @param storage of type integer 
	 */
	public SmartPhone(String model, Dimension dimension, int storage) {
		super(model, dimension);
		
		if(storage <= 0) {
			throw new IllegalArgumentException("Storage needs to be assigned a positive value.");
		}
		else {
			this.storage = storage;
			
		}
		
	}
	
	public String call(long number) {
		return String.format("Calling %d by selecting the number", number);
	}
	
	public String browse() {
		return "Browsing the web";
	}
	
	public String takePicture() {
		Random rand = new Random();
		
		return String.format("Taking a %s picture",(rand.nextDouble() < 0.5 ? "vertical" : "horizontal"));
	}
	
	@Override 
	public String toString() {
		return super.toString() + " " + this.storage + "GB";
		
	}
}
