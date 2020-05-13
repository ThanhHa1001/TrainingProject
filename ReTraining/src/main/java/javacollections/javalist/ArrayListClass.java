package javacollections.javalist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// See more: https://www.programiz.com/java-programming/arraylist
public class ArrayListClass {
	public static void main(String[] args) {

		System.out.println("========Start: Insert ===========");
		List<String> animals = new ArrayList<>();
		// Add elements
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		System.out.println("ArrayList: " + animals);

		// Inserts the specified element at the 1 position in animals list.
		animals.add(1, "Crocodile");
		System.out.println("ArrayList after add element into index 1: " + animals);
		System.out.println("\n========End===========");

		System.out.println("\n========Start: Add all===========");
		// Add elements of an array list to another array list
		List<String> mammals = new ArrayList<>();
		mammals.add("Dog");
		mammals.add("Cat");
		mammals.add("Horse");
		System.out.println("Mammals: " + mammals);

		List<String> animals2 = new ArrayList<>();
		animals2.add("Crocodile");

		// Add all elements of mammals in animalsNew
		animals2.addAll(mammals);
		System.out.println("AnimalsNew: " + animals2);

		animals2.clear();
		animals2.addAll(0, mammals);
		animals2.add("Crocodile");
		System.out.println("AnimalsNew: " + animals2);
		System.out.println("\n========End===========");

		System.out.println("\n========Start: Initialize an ArrayList Using asList()===========");
		// Initialize an ArrayList Using asList()
		// Creating an array list
		List<String> animals3 = new ArrayList<>(Arrays.asList("Cat", "Cow", "Dog"));
		System.out.println(animals3);

		List<String> animals4 = new ArrayList<String>() {
			{
				add("Dog");
				add("Cat");
				add("Cow");
				add("Horse");
			}
		};
		System.out.println(animals4);

		// Access ArrayList Elements
		// Get the element from the array list
		String name = animals4.get(0);
		System.out.println("Element at index 0: " + name);
		System.out.println("\n========End===========");

		System.out.println("\n========Start: Get elements of array===========");
		// Get elements of array
		List<String> animals5 = new ArrayList<>();
		// Add elements in the array list
		animals5.add("Dog");
		animals5.add("Cat");
		animals5.add("Horse");
		animals5.add("Zebra");

		// Using for loop
		System.out.println("\n-Use for");
		for (int i = 0; i < animals5.size(); i++) {
			System.out.print(animals5.get(i) + "  ");
		}

		// Using the forEach loop
		System.out.println("\n\n-Use foreach");
		for (String animal : animals5) {
			System.out.print(animal + "  ");
		}

		// Using iterator() method
		System.out.println("\n\n-Using iterator() method");
		// Create an object of iterator
		Iterator<String> iterate = animals.iterator();
		// Use methods of Iterator to access elements
		while (iterate.hasNext()) {
			System.out.print(iterate.next() + " ");
		}

		// Using lambda
		System.out.println("\n\n-Using lambda");
		animals5.forEach(t -> {
			System.out.print(t + "  ");
		});

		// Using method references (java 8)
		System.out.println("\n\n-Using method references");
		animals5.forEach(System.out::println);
		System.out.println("\n========End===========");

		System.out.println("\n========Start: Remove element===========");
		// Remove element from index 2
		System.out.println("Initial ArrayList: " + animals5);
		String str = animals5.remove(2);
		System.out.println("Final ArrayList: " + animals5);
		System.out.println("Removed Elements: " + str);
		System.out.println("\n========End===========");

		System.out.println("\n========Start: removeAll()===========");
		// Using removeAll() method
		// Restore element from index 2 in animals5 list
		animals5.add(2, str);
		System.out.println("Initial ArrayList: " + animals5);
		animals5.removeAll(animals5);
		System.out.println("Final ArrayList: " + animals5);
		System.out.println("Note:");
		System.out.println("We can also use the clear() method to remove all elements from an array list.");
		System.out.println("The clear() method is more efficient than the removeAll() method.");
		System.out.println("The time complexity of ArrayList.clear() is O(n) and of removeAll is O(n^2).");
		System.out.println("\n========End===========");

		System.out.println("\n========Start: Sort elements===========");
		// Sort Elements of an ArrayList
		// Add elements in the array list
		animals5.add("Dog");
		animals5.add("Cat");
		animals5.add("Horse");
		animals5.add("Zebra");
		
		System.out.println("Insorted ArrayList: " + animals5);
		// Sort the array list
		Collections.sort(animals5);
		System.out.println("Sorted ArrayList: " + animals5);
		
		System.out.println("\n========End===========");

		System.out.println("\n========Start===========");
	}
}
