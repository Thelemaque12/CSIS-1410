package docComments;

public class TravelApp {
	/**
	 * 
	 * @param args the command line arguments 
	 */

	public static void main(String[] args) {
		Car m4 = new Car("BMW", "M4", 25);
		Car civic = new Car("Honda", "Civic", 42);
		/**
		 * Print the information of both cars in the following format:
		 *  {make} {model} {mpg} mpg
		 */
		System.out.println("Cars:");
		System.out.println(m4.getMake()+ " "+ m4.getModel()+ " "+m4.getMpg()+" mph");
		System.out.println(civic.getMake()+ " "+ civic.getModel()+ " "+civic.getMpg()+" mpg\n");
		
		TripPlanner California_Trip = new TripPlanner("SF", "LA", 382, m4);
		TripPlanner Florida_Trip = new TripPlanner("Tampa", "Miami", 280, civic);
		/**
		 * Print the information about the fuel consumption in the following format: 
		 * {fuel consumption} gallons
		 */
		System.out.println("California Trip:");
		System.out.println(California_Trip);
		System.out.printf("fuel consumption: %.1f gallons %n\n",California_Trip.fuelConsumption());
		System.out.println("Florida Trip:");
		System.out.println(Florida_Trip);
		System.out.printf("fuel consumption: %.1f gallons %n",Florida_Trip.fuelConsumption());
	}

}
