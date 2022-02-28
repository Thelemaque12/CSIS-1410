package nuisance;
/**
 * 
 * @author Jefson S
 *
 */
public class Insect {

	private String species;
	/**
	 * Constructs an insect with a unique parameter: species
	 * @param species of type String
	 */
	public Insect(String species) {
		this.species = species;
	}
	/**
	 * Getter returns species
	 * @return of type String
	 */
	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": " + species;
	}
	
	
}
