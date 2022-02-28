package nuisance;
/**
 * class Telemarketer, this class extends class Person.
 * the constructor and additional Telemarketer methods are located here.
 * @author Jefson S
 *
 */
public class Telemarketer extends Person implements Nuisance{
	/**
	 * Extension of class Person.
	 * Remains with the same values
	 * in a different declaration.
	 * @param name of type String
	 * @param age of type integer.
	 */
	public Telemarketer(String name, int age) {
		super(name, age);

	}
	/**
	 * Displays a String with 
	 * the name + specified
	 * characters.
	 * @return of type String
	 */
	public String giveSalesPitch() {
		return this.getName() + " pressures others to buy stuff";
	}

	@Override
	public String annoy() {
		return this.getName() + " annoys by giving a sales pitch";
	}

}
