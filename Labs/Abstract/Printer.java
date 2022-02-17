package abstractClass;

/**
 * Abstract class Printer with
 * fields and constructors with
 * the purpose of displaying the
 * correct format:
 * 
 * {printer type} {serial number}
 * 
 * @author Jefson S
 *
 */

public abstract class Printer {
	
	private String model;
	private static int count = 12345;
	private int serialNumber;
	
	/**
	 * Constructor responsible of setting up the serial number
	 * @param model of type String
	 */
	protected Printer(String model) {
		count += 1;
		this.model = model;
		serialNumber = count; 
		//count++;
	}

	/**
	 * get the model of the printer
	 * @return model of type String
	 */
	public String getModel() {
		return model;
	}

	/**
	 * get the serialNumber 
	 * @return serialNumber of type integer 
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	/**
	 * checking to see if the Toner/Cartridge is empty 
	 * if it's not empty subtract 10 from the Toner/Cartridge 
	 */
	public abstract void print();
	
	   @Override
	public String toString() {
	        return getClass().getSimpleName()+": "+getModel()+" #"+getSerialNumber();
	 }
	
}
