package m02;
/**
 * Abstract class Printer with
 * fields and constructors with
 * the purpose of displaying the
 * correct format:
 * {class name} with {numberOfRooms} rooms
 * 
 * @author Jefson S
 *
 */
public abstract class Dwelling {

	private int numberOfRooms;

	/**
	 * Constructor for class Dwelling 
	 * @param numberOfRooms
	 */
	public Dwelling(int numberOfRooms) {
		//super();
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * provides the typical functionality of a getter
	 * @return of type Integer 
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	/**
	 * printing the heat for cave or house
	 */
	public abstract void heat();

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " with " + this.numberOfRooms + " rooms";
	}
	
	
}

