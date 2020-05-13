package javacollections.javalist;

import java.util.Iterator;
import java.util.Vector;

// See more: https://www.programiz.com/java-programming/vector
/**
 * The Vector class is an implementation of the List interface 
 * that allows us to create resizable-arrays similar to the ArrayList class.
 */
public class VectorClass {
	public static void main(String[] args) {
		Vector<String> mammals = new Vector<>();
		
		// Using the add() method
		mammals.add("Dog");
		mammals.add("Horse");
		
		// Using index number
		mammals.add(2, "Cat");
		System.out.println("Vector mammals: " + mammals);
		
		// Using addAll()
		Vector<String> animals = new Vector<String>();
		animals.add("Crocodile");
		animals.addAll(mammals);
		System.out.println("Vector animals: " + animals);
		
		// Using get()
		String element = animals.get(2);
		System.out.println("Element at index 2: " + element);
		
		// Using iterator()
		Iterator<String> iterate = animals.iterator();
		System.out.print("Vector animals: ");
		while(iterate.hasNext()) {
			System.out.print(iterate.next() + "  ");
		}
		System.out.println();
		
		// Using for loop
		System.out.print("Vector animals: ");
		for (int i = 0; i < animals.size(); i++) {
			System.out.print(animals.get(i) + "  ");
		}
		System.out.println();
	}
}
