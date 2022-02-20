package phones;

/**
 * Extension of class DeskPhone
 * @author Jefson S
 *
 */
public class PushButtonPhone extends DeskPhone{

	public PushButtonPhone(String model, Dimension dimension, Voltage voltage) {
		
		super(model, dimension, voltage);

	}
	
	/**
	 * The method call should return 
	 * the following string:
	 * Pushing buttons to call {number}.
	 */
	public String call(long number) {
		return String.format("Pushing buttons to call %d", number);
	}

}
