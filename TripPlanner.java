package docComments;

public class TripPlanner {
	
	private String departure;
	private String arrival;
	private int distance;
	private Car car;
	
	/**
	 * Constructor initializes the fields 
	 * 
	 * @param departure		State departure 
	 * @param arrival		State Arrival 	
	 * @param distance		the distance to travel from departure to arrival 
	 * @param Car			name of vehicle 
	 */
	public TripPlanner(String departure, String arrival, int distance, Car car) {
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.car = car;
	}
	
	/**
	 * Method that calculate the fuel consumption
	 * and return the fuel consumption 
	 */
	
	public double fuelConsumption() {
		return this.distance /(double)car.getMpg();
		
	}
	
	@Override
	public String toString() {
		return "TripPlanner [departure="+this.departure+", "
				+ "arrival="+this.arrival+", "+"distance="+this.distance+
				 ", "+"car="+this.car.getModel()
						+"]";
		
	}


}
