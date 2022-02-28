package nuisance;


import java.util.Arrays;

/**
 * Class NuisanceApp, class is used to create
 * various Persons and Insects. The app will also print
 * hem out and test the methods provided in the individual classes.
 * @author Jefson S
 *
 */
public class NuisanceApp {

	public static void main(String[] args) {
		Friend f1 = new Friend("Juan", 27, Hobby.MUSIC);
	    Friend f2 = new Friend("Kate", 27, Hobby.SPORTS);
	    Friend f3 = new Friend("Alex", 21, Hobby.MUSIC);
	    Friend newFriend = new Friend("Kate", 27, Hobby.SPORTS);
	    
	    Friend[] friends = {f1, f2, f3};
	    
	    System.out.println("3 Friends:");

	    int count = 1;
	    for(Friend friend: friends) {
	    	System.out.println("friend"+ count +": " + friend);
	    	count++;
	    }
	    System.out.println();
	    
	    System.out.println("friend1 equals friend2: " + f1.equals(f2));
	    System.out.println("friend1 equals friend3: " + f1.equals(f3));
	    System.out.println("friend2 equals new friend: " + f2.equals(newFriend));
	    
	    System.out.println();
	    
	    Telemarketer telemarketer1 = new Telemarketer("Fritz", 25);
	    System.out.println("telemarketer: " + telemarketer1);
	    
	    System.out.println();

	    Mosquito mosquito = new Mosquito("Aedes vexans");
	    PeskyMosquito pesky = new PeskyMosquito("Anopheles walkeri");
	    Butterfly butterfly =  new Butterfly("Swallowtail", Arrays.asList("yellow", "black", "blue"));
	    Butterfly butterfly2 =  new Butterfly(butterfly);
   
	    Insect[] insects = {mosquito, pesky, butterfly,butterfly2};
	    
	    System.out.println("4 Insects:");
	    for(Insect el: insects) {
	    	System.out.println(el);
	    }
	    
	    System.out.println();
	    Nuisance[] nuisance = {telemarketer1, mosquito, pesky};
	    System.out.println("3 Nuisances:");
	    
	    for(Nuisance n: nuisance) {
	    	if(n instanceof Mosquito) {
	    		System.out.println(((Mosquito) n).buzz());
	    	}
	    	
	    	if(n instanceof PeskyMosquito) {
	    		System.out.println(((PeskyMosquito) n).bite());
	    	}
	    	System.out.println(n.annoy());
	    	System.out.println();
	    }
	  
	}

}
