package oop.abstraction;

public class Pig extends Animal {

	Pig() {
		super();
		System.out.println("Pig ahihi");
	}
	
	@Override
	public void animalSound() {
		System.out.println("The pig says: wee wee");
	}

}
