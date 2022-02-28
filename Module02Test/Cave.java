package m02;
/**
 * 
 * @author Jefson S
 *
 */
public class Cave extends Dwelling{

	/**
	 * extends the super class Dwelling
	 * @param numberOfRooms
	 */
	public Cave(int numberOfRooms) {
		super(numberOfRooms);

	}
	
	public void heat() {
		System.out.println("Heating with an open fire.");
	}

}
