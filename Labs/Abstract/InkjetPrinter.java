package abstractClass;

/**
 * Sets the value of remainingCartridge to 100, 
 * which indicates that the Cartridge is 100% full, 
 * and initializes the superclass.
 * @author Jefson S
 *
 */

public class InkjetPrinter extends Printer {
	private int remainingCartridge;
	
	public InkjetPrinter(String model) {
		super(model);
		remainingCartridge = 100;
	}

	/**
	 * Calculates the Cartridge left 
	 * @return remainingCartridge of type integer 
	 */
	public int getRemainingCartridge() {
		return remainingCartridge;
	}
	
	/**
	 * refilling the Cartridge back to 100 
	 */
	public void refillCartridge() {
		remainingCartridge = 100;
	}
	
	@Override 
	public void print() {
		if(remainingCartridge == 0) {
			System.out.println("The cartridge is empty.");
		}
		
		else {
			remainingCartridge -=10;
			 System.out.println(getModel()+" is printing. Remaining cartridge: "+remainingCartridge+"%");
		}
	}

}
