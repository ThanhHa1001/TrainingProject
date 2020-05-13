package oop.interfaces;

public class Rectangle implements Polygon {

	@Override
	public void getArea(int length, int breadth) {
//		System.out.println("The area of the rectangle is " + (length * breadth));
	}

	@Override
	public void getArea() {
		int length = 6;
		int breadth = 5;
		int area = length + breadth;
		System.out.println("The area of the rectangle is " + area);
	}
	
	@Override
	public void getSlides() {
		System.out.println("I have 4 sides.");
	}
}
