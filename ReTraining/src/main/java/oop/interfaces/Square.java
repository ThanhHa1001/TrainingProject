package oop.interfaces;

public class Square implements Polygon {

	@Override
	public void getArea(int length, int breadth) {
		
	}

	@Override
	public void getArea() {
		int length = 5;
		int area = length * length;
		System.out.println("Thea area of the square is " + area);
	}
}
