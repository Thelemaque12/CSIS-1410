package labPolymorphism;

/**
 * Program creates a superclass of Dog 
 * to determine the Breed of the Dog, how the Dog communicate, and move.
 * 
 * @author CSIS Jefson S
 */

public class DogApp
{
    public static void main(String[] args)
    {
        Dog myDog = new Dog("Greyhound");
        System.out.println(myDog);
        actAsDog(myDog);

        SledDog mySledDog = new SledDog("Husky");
        System.out.println(mySledDog);
        actAsDog(mySledDog);

        CircusDog myCircusDog = new CircusDog("Terrier");
        System.out.println(myCircusDog);
        actAsDog(myCircusDog);
        
        System.out.println("Using an Array:\n");
        
        Dog[] myDogs = {myDog, mySledDog, myCircusDog};
        
        for(Dog dog: myDogs) {
        	System.out.println(dog);
        	
        	if(dog instanceof SledDog) {
        		((SledDog) dog).pullSled();
        	}
        	actAsDog(dog);
        }
    }

    private static void actAsDog(Dog d)
    {
        d.communicate();
        d.move();
        System.out.println();
    }
}
