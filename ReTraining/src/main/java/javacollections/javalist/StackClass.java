package javacollections.javalist;

import java.util.Stack;

/**
 * The Java collections framework has a class named Stack that provides the
 * functionality of the stack data structure. The Stack class extends the Vector
 * class.
 * 
 * In stack, elements are stored and accessed in Last In First Out manner
 *
 * Use ArrayDeque Instead of Stack
 * The Stack class provides the direct implementation of the stack data structure. 
 * However, it is recommended not to use it. 
 * Instead, use the ArrayDeque class (implements the Deque interface) 
 * to implement the stack data structure in Java.
 */
public class StackClass {
	public static void main(String[] args) {
		Stack<String> animals = new Stack<>();
		
		// Add elements to Stack
		animals.add("Dog");
		animals.add("Cat");
		animals.add("Horse");
		
		System.out.println("Stack: " + animals);
		
		Stack<String> mammals = new Stack<>();
		
		// Add elements to Stack
		mammals.push("Dog");
		mammals.push("Horse");
		mammals.push("Cat");
		
		System.out.println("Stack mammals: " + mammals);
		
		// Remove element stacks
		String element = mammals.pop();
		System.out.println("Removed element: " + element);
		System.out.println("Stack after pop(): " + mammals);
		
		// Access element from the top
		String ePeek = mammals.peek();
		System.out.println("Element at top: " + ePeek);
		
		mammals.push("Zebra");
		mammals.push("Cat");
		mammals.push("Lion");
		mammals.push("Bear");
		mammals.push("Fox");
		System.out.println("Mammals: " + mammals);
		
		// Search an element
		// It returns the position of the element from the top of the stack
		int position = mammals.search("Dog");
		System.out.println("Position of Bear: " + position);
		
		// Check if stack is empty
		boolean result = mammals.empty();
		System.out.println("Is the stack empty? " + result);
		
	}
}
