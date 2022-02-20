package phones;

/**
 * The constructor includes 2 parameters 
 * to initialize the superclass Phone,
 * and a third parameter to initialize 
 * the field voltage. There is no parameter 
 * to initialize the field connected. 
 *  
 * @author Jefson S
 *
 */

public abstract class DeskPhone extends Phone{

	public boolean connected;
	private Voltage voltage;
	
	public DeskPhone(String model, Dimension dimension, Voltage voltage) {
		super(model, dimension);
		this.voltage = voltage;

	}
	
	public void plugIn() {
		connected = true;
	}
	
	public void unplug() {
		connected = false;
	}
	
	public boolean isConnected() {
		return connected;
	}

	@Override 
	public String toString() {
		
		 return String.format("%s %s %s",super.toString(),voltage,(connected) ? "connected" : "not connected");
	}
	

}
