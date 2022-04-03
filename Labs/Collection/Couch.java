package labCollection;

import java.awt.Color;
import java.util.Objects;

/**
 * 
 * @author Jefson S
 *
 */
public class Couch {

	Color color;
	Material material;
	
	/**
	 * Initialization of the fields,
	 * due to the constructor.
	 * @param color
	 * @param mat
	 */
	public Couch(Color color, Material material) {
		super();
		this.color = color;
		this.material = material;
	}
	
	/**
	 * Retrieves the couch's color.
	 * @return color of type Color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Retrieves the couch's material.
	 * @return mat of type Material - ENUM
	 */
	public Material getMaterial() {
		return material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, material);
	}

	/**
	 * Makes Couches equal if their 
	 * colors & materials are the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couch other = (Couch) obj;
		return other.getColor() == color && other.getMaterial() == material;
	}

	/**
	 * Strings out a description representing the Couch
	 * @return "Couch: {color in hexadecimal} {material}"
	 */
	@Override
	public String toString() {
		String mat = "" + material;
		String colorHex = String.format("#%02x%02x%02x", 
				color.getRed(), color.getGreen(), color.getBlue());
		return "Couch: " + colorHex + " " + mat.toLowerCase();
	}
	
	
	
}
