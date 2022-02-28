package nuisance;
/**
 * Class Friend, this class builds off of Person.
 * The constructor and additional methods for Friend 
 * are located here.
 * @author Jefson S
 *
 */
public class Friend extends Person{

	private Hobby hobby;
	/**
	 * Creates new friend w/ {name}{age}{hobby}
	 * Hobbies to choose from include:
	 * MUSIC, SPORTS, GAMES
	 * @param name of type String
	 * @param age of type Integer
	 * @param hobby of type Hobby
	 */
	public Friend(String name, int age, Hobby hobby) {
		super(name, age);
		this.hobby = hobby;
	}
	/**
	 * 
	 * @return {name} is chilling
	 */
	public String chill() {
		return super.getName() + " is chilling";
	}
	
	public String play(Friend[] friends) {
		if (friends == null || friends.length == 0) {
			return "playing " + hobby;
		} else if (friends.length == 1) {
			return "playing " + hobby + " with " + friends[0].getName();
		} else if (friends.length == 2) {
			return "playing " + hobby + " with " + friends[0].getName() + " and " + friends[1].getName();
		} else {
			String message = "playing " + hobby + " with ";
			String friendsData = "";
			for (int i = 0; i < friends.length - 1; i++) {
				friendsData += friends[i].getName() + ", ";
			}
			friendsData += "and " + friends[friends.length - 1].getName();
			return message + friendsData;
		}
	}
	@Override
	public String toString() {
		return super.getName() + "(" + super.getAge() + ")" + " " + hobby;
	}
	
}
