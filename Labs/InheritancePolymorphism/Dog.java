package labPolymorphism;

/**
 * Program creates a superclass of Dog 
 * to determine the Breed of the Dog, how the Dog communicate, and move.
 * 
 * @author CSIS Jefson S
 */

public class Dog
{
    private final String breed;
    /**
     * 
     * @param b of type String 
     */
    public Dog(String b)
    {
        breed = b;
    }

    /**
     * tells how the Dog communicate 
     */
    public void communicate()
    {
        System.out.println("bark bark");
    }

    /**
     * this method tells the Dog to run 
     */
    public void move()
    {
        System.out.println("run");
    }
    
    /**
     * 
     * @return the Breed of the Dog 
     */
    public String getBreed()
    {
        return breed;
    }
    
    @Override 
    public String toString() {
    	return this.getClass().getSimpleName() + ": " + this.breed;
    }
}
