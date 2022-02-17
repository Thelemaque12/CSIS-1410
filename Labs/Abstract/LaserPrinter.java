package abstractClass;

/**
 * Sets the value of remainingToner to 100, 
 * which indicates that the toner is 100% full, 
 * and initializes the superclass.
 * @author Jefson S
 *
 */
public class LaserPrinter extends Printer {
	private int remainingToner;
	
	public LaserPrinter(String model) {
		super(model);
		remainingToner = 100;
		
	}

	/**
	 * Calculates the toner left 
	 * @return remainingToner of type integer 
	 */
	public int getRemainingToner() {
		return remainingToner;
	}

	/**
	 * refilling to the Toner back to 100
	 */
	public void refillToner() {
		remainingToner = 100;
	}
	
	@Override 
	public void print() {
		if(remainingToner == 0) {
			System.out.println("The toner is empty.");
		}
		
		else {
			remainingToner -= 10;
			System.out.println(getModel()+" is printing. Remaining toner: "+remainingToner+"%");
		}
	}
}
