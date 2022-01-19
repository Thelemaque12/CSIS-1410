package docComments;

public class Car {
	
	private String make;
	private String model;
	private int mpg;
	
	/**
	 * Constructor of class Car 
	 * 
	 * @param make		make of the car 
	 * @param model		model of the car
	 * @param mpg 		mpg of the car
	 */
	
	public Car(String make, String model, int mpg) {
		this.make = make;
		this.model = model;
		this.mpg = mpg;
	}
	
	/**
	 * @return make of the car
	 */
	
	public String getMake() {
		return make;
	}
	
	/**
	 * @return model of the car
	 */
	
	public String getModel() {
		return model;
	}
	
	/**
	 * @return mpg of the car 
	 */
	
	public int getMpg() {
		return mpg;
	}


}
