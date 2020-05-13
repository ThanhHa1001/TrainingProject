package oop.interfaces;

public class MainInterfaces {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.getArea(5, 6);
		r1.getArea();
		r1.getSlides();

		Square s1 = new Square();
		s1.getArea();

		Triangle t1 = new Triangle(2, 3, 4);
		t1.getArea();
		t1.getPerimeter(2, 3, 4);
	}
}
