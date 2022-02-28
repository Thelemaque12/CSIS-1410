package nuisance;
/**
 * class PeskyMosquito, extends from the Mosquito class,
 * includes constructor and class specific method
 * @author Jefson S
 *
 */
public class PeskyMosquito extends Mosquito{
	/**
	 * Extension of the arguments implemented
	 * in class Mosquito, with no additions.
	 * @param species of type String
	 */
	public PeskyMosquito(String species) {
		super(species);

	}
	/**
	 * @return of type String
	 */
	public String bite() {
		return "sucking blood";
	}
}
