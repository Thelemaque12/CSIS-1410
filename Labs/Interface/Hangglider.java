package labInterface;
/**
 * 
 * @author Jefson S
 *
 */

public class Hangglider implements Flyable
{
	private final boolean isRigidWing;

	/**
	 * 
	 * @param rigidWing of type boolean
	 */
	public Hangglider(boolean rigidWing)
	{
		isRigidWing = rigidWing;
	}

	/**
	 * Displays the information as a String
	 */
	@Override
	public String toString()
	{
		return String.format(isRigidWing ? "Rigid-wing" : "Flex-wing");
	}

	/**
	 * Display specified Strings.
	 * @return methods as Strings
	 */
	@Override
	public void launch() {
		System.out.println("Running until take-off");
		
	}

	@Override
	public void land() {
		System.out.println("Gliding to a land");
		
	}
}
