package iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputStreamClass {
	
	public static void main(String[] args) {
		// Creates an object of Dog class
		Dog dog = new Dog("Tyson", "Labrador");
		
		try {
			// Creates a FileOutputStream where objects from ObjectOutputStream are written
			FileOutputStream file = new FileOutputStream("file.txt");
			
			// Creates an ObjectOutputStream
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			// Writes objects to the output stream
			output.writeObject(dog);
			
			// Creates a file input stream linked with the specified file
			FileInputStream fileStream = new FileInputStream("file.txt");
			
			//Creates an ObjectInputStream
			ObjectInputStream input = new ObjectInputStream(fileStream);
			
			// Reads the objects
			Dog newDog = (Dog) input.readObject();
			
			System.out.println("Dog name:" + newDog.name);
			System.out.println("Dog breed:" + newDog.breed);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}

class Dog implements Serializable {
	String name;
	String breed;
	
	public Dog(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}
}