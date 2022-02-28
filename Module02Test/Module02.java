package m02;
/**
 * the test client and it includes the main method
 * @author Jefson S
 *
 */
public class Module02 {

	public static void main(String[] args) {
		Dwelling[] dwellings = {
				   new House(5, Leed.GOLD, true),
				   new Cave(2),
				   new House(4, Leed.NONE, false),
				   new House(3, Leed.SILVER, true)
				};
		
		for(Dwelling d: dwellings) {
			System.out.println(d.toString());
			d.heat();
			if(d instanceof House && ((House) d).hasPool()) {
				((House)d).poolParty();
			}
			System.out.println();
		}

	}

}
