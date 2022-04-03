package labCollection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Jefson S
 *
 */
public class CouchApp {

	/**
	 * Creates multiple Collection<Couch>
	 * & implements them in order to test
	 * Couch class methods.
	 * @param args
	 */
	public static void main(String[] args) {
		Color[] colors = {Color.BLACK, Color.BLUE, Color.DARK_GRAY, Color.GRAY,Color.GREEN, Color.LIGHT_GRAY, Color.RED, Color.WHITE};
		
		List<Couch> couches = new ArrayList<>();
		
		for(int i = 0; i < colors.length; i++) {
			couches.add(new Couch(colors[i], Material.FABRIC));
			couches.add(new Couch(colors[i], Material.LEATHER));
			couches.add(new Couch(colors[i], Material.VINYL));
		}

		List<Couch> favorites = new ArrayList<>();
		favorites.add(new Couch(Color.RED, Material.FABRIC));
		favorites.add(new Couch(Color.BLACK, Material.LEATHER));
		favorites.add(new Couch(Color.WHITE, Material.VINYL));
		
		printCouches(couches);
//		System.out.println("Number of elements in list of couches: " + couches.size());
		favoritesIn(couches, favorites);
		
		System.out.println("Removing all vinyl couches...\n");
		couches.removeIf(c -> (c.getMaterial() == Material.VINYL));
		printCouches(couches);
		favoritesIn(couches, favorites);
		
		System.out.println("Adding all favorites to the list couches...\n");
		couches.addAll(favorites);
		printCouches(couches);
		favoritesIn(couches, favorites);
		
		System.out.println("Adding all couches to a set...\n");
		Set<Couch> set = new HashSet<>(couches);
		List<Couch> noDups = new ArrayList<>(set);
		printCouches(noDups);
		favoritesIn(noDups, favorites);

	}

	/**
	 * Print all couches in the Collection
	 * @param c
	 */
	private static void printCouches(List<Couch> c) {
		c.forEach(System.out::println);
	}
	
	/**
	 * Prints number of elements, and whether or not
	 * all favorites are present.
	 * @param couches
	 * @param favorites
	 */
	private static void favoritesIn(List<Couch> c, List<Couch> fav) {
		System.out.println("Number of elements in list of couches: " + c.size());
		
		if(c.containsAll(fav)) {
			System.out.println("All favorites are in the list.\n");
		}
		else 
			System.out.println("Not all favorites are in the list\n");
	}
}

