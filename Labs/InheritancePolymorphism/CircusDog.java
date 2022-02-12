package labPolymorphism;

/**
 * Program evaluates a subclass of CircusDog 
 * to determine the Breed of the Dog, how the Dog communicate, and move.
 * 
 */

public class CircusDog extends Dog
{
	/**
	 * 
	 * @param b of type String 
	 */
    public CircusDog(String b)
    {
        super(b);
    }

    @Override
    public void move()
    {
        System.out.println("tightrope walking");
    }
}
