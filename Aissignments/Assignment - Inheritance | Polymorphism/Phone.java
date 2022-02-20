package phones;

/**
 * Abstract class Phone 
 * <code>model</code>.
 * @author Jefson S
 */
public abstract class Phone {

	private String model;
	private Dimension dimension;
	
	/**
	 * 
	 * @param model of type String
	 * @param dimension of type Dimension
	 */
	public Phone(String model, Dimension dimension) {
		this.model = model;
		this.dimension = dimension;
	}
	
	public abstract String call(long number);
	
	@Override 
	public String toString() {
		return model + " " + dimension;
	}
}
