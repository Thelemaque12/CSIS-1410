package m02;
/**
 * 
 * @author Jefson 
 *
 */
public class House extends Dwelling{

	private boolean hasPool;
	private Leed leed;
	/**
	 * Constructor provides input validation
	 * @param numberOfRooms of type Integer
	 * @param hasPool of type Boolean
	 * @param leed of type Enum 
	 */
	public House(int numberOfRooms, Leed leed, boolean hasPool) {
		super(numberOfRooms);
		this.hasPool = hasPool;
		this.leed = leed;
	}
	/**
	 * provides the typical functionality of a getter
	 * @return of type Boolean
	 */
	public boolean hasPool() {
		return hasPool;
		
	}
	/**
	 * If the house has a pool, it prints the following text: 
	 * Having fun at the pool party.
	 * If not it prints the following text: 
	 * No pool available.
	 */
	public void poolParty() {
		if(this.hasPool) {
			System.out.println("Having fun at the pool party.");
		}
		else {
			System.out.println("No pool available.");
		}
	}

	public void heat() {
		System.out.println("Heating with a furnace.");
	}

	@Override
	public String toString() {
		if(this.hasPool) {
			return "[P] " + this.getClass().getSimpleName() + " with " + super.getNumberOfRooms() + " rooms " + this.leed;
		}
		else {
			return "[-] " + this.getClass().getSimpleName() + " with " + super.getNumberOfRooms() + " rooms " + this.leed;
		}

	}
	
	

}
