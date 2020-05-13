package generics;

/**
 * This means T can only work with data types 
 * that are children of Number (Integer, Double, and so on).
 * 
 */
public class BoundedTypes <T extends Number> {
	public void display() {
		System.out.println("This is a bounded type generics class.");
	}
}
