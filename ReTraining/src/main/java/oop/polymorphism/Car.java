package oop.polymorphism;

import oop.inheritance.Vehicle;

public class Car extends Vehicle {
	private String modelName = "Mustang";
	
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.honk();
		
		System.out.println("Brand: " + myCar.brand + "  modelName: " + myCar.modelName);
	}
}
