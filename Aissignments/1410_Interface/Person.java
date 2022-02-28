package nuisance;
/**
 *  Class Person, contains the constructor and getters
 *  for the Person class.
 * @author Jefson S
 *
 */
public class Person {

	private String name;
	private int age;
	/**
	 * Age needs to be a value between 1 and 150 (inclusive). 
	 * Throws an IllegalArgumentException if an invalid age 
	 * is provided and include an error message that states 
	 * that age needs to be from the range [1, 150].
	 * 
	 * @param name of type String
	 * @param age of type integer
	 * @throws IllegalArgumentException
	 */
	public Person(String name, int age) {

		if(age < 1 || age > 150) {
			throw new IllegalArgumentException("age needs to be from the range [1, 150]");
		}
		this.name = name;
		this.age = age;
	}
	/**
	 * Getters return the defined parameter.
	 * @return the name of type String
	 * @return the age of type integer
	 */
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	
	@Override
	public int hashCode() {
	       final int prime = 31;
	       int result = 1;
	       result = prime * result + age;
	       result = prime * result + ((name == null) ? 0 : name.hashCode());
	       return result;
	}

	@Override
	public boolean equals(Object obj) {
	       if (this == obj)
	           return true;
	       if (obj == null)
	           return false;
	       if (getClass() != obj.getClass())
	           return false;
	       Person other = (Person) obj;
	       if (age != other.age)
	           return false;
	       if (name == null) {
	           if (other.name != null)
	               return false;
	       } else if (!name.equals(other.name))
	           return false;
	       return true;
	}
	
}
