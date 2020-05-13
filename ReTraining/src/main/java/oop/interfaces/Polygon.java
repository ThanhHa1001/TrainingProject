package oop.interfaces;

public interface Polygon {
//	public static final String color = "blue";
//	public void getArea();
	
	String color = "blue";
	
	void getArea(int length, int breadth);
	
	void getArea();
	
	default void getSlides() {
		System.out.println("I can get sides of polygon.");
	}
	
	default void getPerimeter(int... sides) {
		int perimeter = 0;
		for (int side : sides) {
			perimeter += side;
		}
		
		System.out.println("Perimeter: " + perimeter);
	}
}
