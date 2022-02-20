package phones;

/**
 * Only positive values are allowed for height, 
 * width, and depth. If one or more of the 
 * parameter values are zero or negative, 
 * an IllegalArgumentException should be thrown.
 * 
 * @author Jefson S
 *
 */

public class Dimension {

	private double height; 
	private double width; 
	private double depth;
	
	/**
	 * Constructor provides input validation
	 * @param height of type double
	 * @param width of type double
	 * @param depth of type double 
	 * @throws IllegalArgumentException if value is less or equal to 0
	 */
	
	public Dimension(double height, double width, double depth) {
		//super();
		if(height > 0 && width > 0 && depth > 0) {
			this.height = height;
			this.width = width;
			this.depth = depth;
		}

		else {
			throw new IllegalArgumentException("The height, width, and depth of a dimension needs to be positive.");
		}
	}

	/**
	 *Implementation of getters
	 * @return the height 
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Implementation of getters 
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Implementation of getters 
	 * @return the depth 
	 */
	public double getDepth() {
		return depth;
	}
	
	@Override
	public String toString() {
		return String.format("(%.1f x %.1f x %.1f)",height, width, depth);
	}
}
