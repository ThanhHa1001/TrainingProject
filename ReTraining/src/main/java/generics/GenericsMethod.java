package generics;

import java.util.ArrayList;

public class GenericsMethod {
	public <T> void genericsMethod(T data) {
		System.out.println("This is a generics method.");
		System.out.println("The data passed to method is " + data);
	}
	
	public <E> E getFirstElement(ArrayList<E> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		
		E first = list.get(0);
		return first;
	}
}
