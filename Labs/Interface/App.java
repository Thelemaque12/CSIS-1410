package labInterface;

import java.util.ArrayList;

/**
 * 
 * @author Jefson S
 *
 */
public class App
{

	/**
	 * Displays all the information,
	 * and helps us test the functionality.
	 */
	public static void main(String[] args)
	{
		Plane myPlane = new Plane(4, "Boing 747");
		System.out.printf("myPlane: %s%n", myPlane);

		Hangglider myHangglider = new Hangglider(true);
		System.out.printf("myHangglider: %s%n", myHangglider);

		Bird myBird = new Bird("Swallow");
		System.out.printf("myBird: %s%n", myBird);
		
		System.out.println();
		
		ArrayList<Flyable> flyingThings = new ArrayList<>();
		flyingThings.add(myPlane);
		flyingThings.add(myHangglider);
		flyingThings.add(myBird);
		
		for(Flyable flyable: flyingThings) {
			System.out.println(flyable);
			flyable.launch();
			flyable.land();
			System.out.println();
		}
	}

}
