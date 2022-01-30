/**
 * 
 */
package a01;

/**
 * WarmUp class. A team assignment as a basic review of 
 * Objects, Arrays, and ArrayLists.
 * 
 * @authors: Jefson Simeus, Carl Hulbert
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

public class WarmUp {

	/**
	 * Main method for Warmup used for testing
	 * @param args
	 */
	public static void main(String[] args) {
		Point p1 = new Point(4,3);
		Point p2 = new Point(3,-1);
		Point p3 = new Point(3,-4);
		Point p4 = new Point(6,3);
		Point p5 = new Point(1,3);
		
		Point[] points = {p1,p2,p3,p4};
		
		ArrayList<String> aListTest = new ArrayList<String>();
		aListTest.add("syl");
		aListTest.add("lab");
		aListTest.add("les");
		
		char charTester = 'j';
		
		ArrayList<Point> pArrayList = new ArrayList<Point>();
		pArrayList.add(p1);
		pArrayList.add(p2);
		pArrayList.add(p3);
		pArrayList.add(p4);
		pArrayList.add(p5);
		
		double distance = distance(p1,p2);
		double greatestDistance = greatestDistanceFromOrigin(p1, p2, p3);
		double area = area(p4);
		int []testArray = firstEightMultiples(3);
		String[] testStringArray = {"Hello", "my", "name", "is", "Jeff"};
		
		//TESTING Print stuff
		System.out.printf("\n01. Distance Test Point1%s Point2%s: %.1f\n\n",p1,p2, distance);
		System.out.printf("02. Greatest Distance Test: %.0f\n\n", greatestDistance);
		System.out.printf("03. Area Test: %.0f\n\n", area);
		System.out.printf("04. First eight mult Test: %s \n\n",Arrays.toString(testArray));
		firstAndLastToXXX(testStringArray);
		System.out.printf("05. First and Last to 'XXX':%s\n\n",Arrays.toString(testStringArray));
		System.out.printf("06. Content Test: %s\n\n",content(points));
		System.out.printf("07. Hyphenation Test: %s\n\n",hyphenate(aListTest));
		System.out.printf("08. More of the Same Test:%s\n\n",moreOfTheSame(charTester));
		System.out.printf("09. Take Test: %s",take(pArrayList, 3));

	}
	
	
	//REVIEW OBJECTS METHODS
	/**
	 * This method returns the distance between p1 and p2
	 * @param p1	point1
	 * @param p2	point2
	 * @return the distance between p1 and p2
	 */
	public static double distance(Point p1, Point p2) {
		double distance = p1.distance(p2);
		return distance;
	}
	
	/**
	 * This method determines the greatest distance between any of 
	 * the points and the origin (0, 0). 
	 * @param p1 distance of Point 1
	 * @param p2 distance of Point 2
	 * @param p3 distance of Point 3 
	 * @return the largest distance from the Origin 
	 */
	public static double greatestDistanceFromOrigin(Point p1, Point p2, Point p3) {
		double distance1 = p1.distance();
		double distance2 = p2.distance();
		double distance3 = p3.distance();
		double largest = 0.0;
		
		if(distance1 > distance2 && distance1 > distance3) {
			largest = distance1;
		}
		if(distance2 > distance1 && distance2 > distance3) {
			largest = distance2;
		}
		if(distance3 > distance1 && distance3 > distance2) {
			largest = distance3;
		}
		if(distance1 == distance2 || distance1 == distance3) {
			largest = distance1;
		}
		if(distance2 == distance1 || distance2 == distance3) {
			largest = distance2;
		}
		if(distance3 == distance1 || distance3 == distance2) {
			largest = distance3;
		}

		return largest;
	}
	
	/**
	 * This method returns the area of the rectangle that extends 
	 * from the origin along the x-axis and y-axis to the point p
	 * @param p
	 * @return
	 */
	public static double area(Point p) {
		double area = Math.abs(p.getX() * p.getY());
		return area;
	}
	
	
	//REVIEW ARRAYS METHODS
	/**
	 * this method returns an array that includes the first eight 
	 * multiples of n
	 * @param n	number you want to see multiplied by 8
	 * @return returns an integer array
	 */
	public static int[] firstEightMultiples(int n) {
		int eightMultiples[] = new  int[8];
		for(int i=1; i<= eightMultiples.length; i++) {
			eightMultiples[i-1]  = i * n;
		}
		return eightMultiples;
	}
	
	/**
	 * this method replace the first and last element of the array
	 * to XXX
	 * @param strings list of words you want add to this method 
	 */
	public static void firstAndLastToXXX(String[] strings) {
		if(strings.length !=0) {
			strings[0] = "XXX";
			strings[strings.length - 1] = "XXX";
		}
	}
	
	/**
	 * This method creates a string that includes all 
	 * points of the array separated by a period. 
	 * 
	 * @param points
	 * @return
	 */
	public static String content(Point[] points) {
		StringBuilder sb = new StringBuilder();
		for(Point el: points) {
			if(sb.length() > 0) {
				sb.append(".");
			}						
			sb.append(el);
		}
		return sb.toString();
		
	}
	
	
	//ARRAYLIST METHODS
	/**
	 * 
	 * This method creates a string that includes all 
	 * syllables of the list separated by dashes. 
	 * If the list is empty, an empty string 
	 * should be returned.
	 * 
	 * @param syllables
	 * @return
	 */
	public static String hyphenate(ArrayList<String> syllables) {
		StringBuilder sb =  new StringBuilder();
		
		for(String words: syllables) {
			if(sb.length() > 0) {
				sb.append("-");
			}
			sb.append(words);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * This method creates and returns a list of type ArrayList<String> 
	 * that includes five strings. The first string 
	 * has length 1 and includes the character provided once. 
	 * The second string has length 2 
	 * and includes the character twice, etc.
	 * 
	 * @param c
	 * @return
	 */
	public static ArrayList<String> moreOfTheSame(char c){
		ArrayList<String> moreSameArr = new ArrayList<String>();
		String strHold = "";
		strHold = Character.toString(c);
		moreSameArr.add(strHold);
		moreSameArr.add(strHold+strHold);
		moreSameArr.add(strHold+strHold+strHold);
		moreSameArr.add(strHold+strHold+strHold+strHold);
		moreSameArr.add(strHold+strHold+strHold+strHold+strHold);
		
		return moreSameArr;
	}
	
	/**
	 * This method creates and returns a new list that includes the 
	 * first n points from the list provided as an argument. 
	 * The list provided as arguments should not be changed. 
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	public static ArrayList<Point> take(ArrayList<Point> list, int n){
		ArrayList<Point> takeArr = new ArrayList<Point>();
		
		if(n == 0) {return takeArr;}
		else if(n<0 || n>list.size()) {
			throw new IllegalArgumentException("The list doesn't have " + n + " elements.");
		}
		else {
			for(int i = 0; i<n;i++) {
				takeArr.add(list.get(i));
			}
		}
		return takeArr;
	}
	

}
