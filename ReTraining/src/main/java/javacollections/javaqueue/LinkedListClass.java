package javacollections.javaqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class LinkedListClass {
	public static void main(String[] args) {
		// Creating Queue using the LinkedList class
		Queue<Integer> numbers = new LinkedList<>();
		
		// Offer elements to the Queue
		numbers.offer(1);
		numbers.offer(2);
		numbers.offer(3);
		System.out.println("Queue: " + numbers);
		
		// Access elements of the Queue
		int accessedNumber = numbers.peek();
		System.out.println("Accessed Element: " + accessedNumber);
		
		// Remove elements from the Queue
		int removedNumber = numbers.poll();
		System.out.println("Removed Element: " + removedNumber);
		
		System.out.println("Updated Queue: " + numbers);
		System.out.println();
		
		// Creating List using the LinkedList
		List<String> animals = new LinkedList<>();
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		
		System.out.println("LinkedList animals: " + animals);
		
		// Add elements: using listIterator() method
		List<String> mammals = new LinkedList<>();
		
		// Creating an object of ListIterator
		ListIterator<String> listIterate = mammals.listIterator();
		listIterate.add("Dog");
		listIterate.add("Cat");
		listIterate.add("Bear");
		
		System.out.println("LinkedList: " + mammals);
		
	}
}
