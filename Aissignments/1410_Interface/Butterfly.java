package nuisance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Class Butterfly extends from the class Insect
 * @author Jefson S
 *
 */
public class Butterfly extends Insect{

	private List<String> colors;
	/**
	 * Butterfly constructor include the Species and a list
	 * of colors
	 * @param species of type String
	 * @param colors of type List
	 */
	public Butterfly(String species, List<String> colors) {
		super(species);
		this.colors = colors;
	}
	/**
	 * initializes the fields based on an existing Butterfly object
	 * @param butterfly of type Butterfly
	 */
	public Butterfly(Butterfly butterfly) {
		super(butterfly.getSpecies());
		this.colors = butterfly.getColors();

	}
	/**
	 * @return a list of colors
	 */
	public List<String> getColors() {
		return colors;
	}

	@Override
	public String toString() {
		return this.getSpecies() + " " + Arrays.toString(colors.toArray());
	}
	
}
