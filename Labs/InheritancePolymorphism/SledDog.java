package labPolymorphism;

/**
 * Program evaluates a subclass of SledDog
 * to determine the Breed of the Dog, how the Dog communicate, and move.
 * 
 */

public class SledDog extends Dog
{
	/**
	 * subclass of the super class Dog 
	 * @param b of type String 
	 */
    public SledDog(String b)
    {
        super(b);
    }
    /**
     * print the activity that the dog is doing
     */
    public void pullSled()
    {
        System.out.println("pulling the sled");
    }
}
