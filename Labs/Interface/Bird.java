package labInterface;

/**
 * 
 * @author Jefson S
 *
 */
public class Bird implements Flyable
{
	private final String type;

	/**
	 * Constructs a String
	 * that will display
	 * the type of bird.
	 * @param t
	 */
	public Bird(String t)
	{
		type = t;
	}

	/**
	 * Displays the information as a String
	 */
	@Override
	public String toString()
	{
		return type;
	}

	/**
	 * Display specified Strings.
	 * @return methods as Strings
	 */
	@Override
	public void launch() {
		System.out.println("Flapping the wings to take-off");
		
	}

	@Override
	public void land() {
		System.out.println("Flapping the wings until landing");
		
	}
}
