package phones;

/**
 * Extension of class DeskPhone
 * @author Jefson S
 *
 */
public class RotaryPhone extends DeskPhone{

	public RotaryPhone(String model, Dimension dimension, Voltage voltage) {
		
		super(model, dimension, voltage);

	}


	/**
	 * The method call should return 
	 * the following string: 
	 * Rotating the dial to call {number}.
	 */
	public String call(long number) {
		return String.format("Rotating the dial to call %d", number);
	}
}
