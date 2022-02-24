package labInterface;

/**
 * 
 * @author Jefson S
 *
 */
public class Plane implements Flyable
{
	private final int numberOfEngines;
	private final String model;

	/**
	 * Constructs the integer parameter engines,
	 * and String m – related to the model.
	 * @param engines of type integer
	 * @param m of type String
	 */
	public Plane(int engines, String m)
	{
		numberOfEngines = engines;
		model = m;
	}

	/**
	 * Displays the information as a String
	 */
	@Override
	public String toString()
	{
		return String.format("%s with %d engines", model, numberOfEngines);
	}

	/**
	 * Display specified Strings.
	 * @return methods as Strings
	 */
	@Override
	public void launch() {
		System.out.println("Rolling until take-off");
		
	}

	@Override
	public void land() {
		System.out.println("Rolling to a stop");
		
	}
}
