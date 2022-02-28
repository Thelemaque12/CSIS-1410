package nuisance;
/**
 * Class Mosquito, extends class Insect and
 * implemnts the Nuisance interface.
 * @author Jefson S
 *
 */
public class Mosquito extends Insect implements Nuisance{
	/**
	 * Species of insect to be included
	 * @param species of type String
	 */
	public Mosquito(String species) {
		super(species);

	}
	/**
	 * Displays the specified String,
	 * with the format:
	 * {species}{message}
	 * @return of type String 
	 */
	public String buzz() {
		return this.getSpecies() + " buzzing around" ;
	}
	
	@Override
	public String annoy() {
		return "buzz buzz buzz";
	}

}
