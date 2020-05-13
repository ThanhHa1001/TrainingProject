package generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		// create an array list to store Integer data
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(4);
		list1.add(5);
		System.out.println("ArrayList of Integer: " + list1);

		// create an array list to store String data
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("Four");
		list2.add("Five");
		System.out.println("ArrayList of String: " + list2);

		// create an array list to store Double data
		ArrayList<Double> list3 = new ArrayList<>();
		list3.add(4.5);
		list3.add(6.5);
		System.out.println("ArrayList of Double: " + list3);

		// initialize generic class with Integer data
		GenericsClass<Integer> intObj = new GenericsClass<Integer>(5);
		System.out.println("Generic Class returns: " + intObj.getData());

		// initialize generic class with String data
		GenericsClass<String> stringObj = new GenericsClass<String>("Java Programming");
		System.out.println("Generic Class returns: " + stringObj.getData());

		System.out.println();

		// initialize the class with String data
		GenericsMethod demo = new GenericsMethod();
		demo.genericsMethod("Java Programming");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(100000);
		list.add(2);
		list.add(3);
		Integer firstElement = demo.getFirstElement(list);
		System.out.println("The first element is " + firstElement);
		
		System.out.println();

//		BoundedTypes<String> obj = new BoundedTypes<String>();
		BoundedTypes<Integer> objI = new BoundedTypes<Integer>();
		objI.display();
		
		KeyValue<Integer, String> entry = new KeyValue<Integer, String>(12000111, "Tom");
		Integer phone = entry.getKey();
		String name = entry.getValue();
		
		System.out.println("Phone = " + phone + "/ name = " + name);
		
		PhoneNameEntry phoneNameEntry = new PhoneNameEntry(12000222, "Mie");
		Integer phoneN = phoneNameEntry.getKey();
		String nameN = phoneNameEntry.getValue();
		System.out.println("Phone = " + phoneN + "/ nameN = " + nameN);
		
		System.out.println();
		
		StringAndValueEntry<Integer> savEntry = new StringAndValueEntry<Integer>("E001", 123456789);
		String empNumber = savEntry.getKey();
		Integer empPhone = savEntry.getValue();
		
		System.out.println("Emp number: " + empNumber);
		System.out.println("Emp phone: " + empPhone);
		
		
	}
}
