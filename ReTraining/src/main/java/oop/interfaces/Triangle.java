package oop.interfaces;

public class Triangle implements Polygon {
	private int a, b, c;
	private double s, area;

	Triangle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		s = 0;
	}

	@Override
	public void getArea(int length, int breadth) {
		s = (a + b + c) / 2;
		area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		System.out.println("Area: " + area);
	}

	@Override
	public void getArea() {
		s = (double) (a + b + c) / 2;
		area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		System.out.println("Area: " + area);
	}

}
