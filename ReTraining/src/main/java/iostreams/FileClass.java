package iostreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileClass {
	public static void main(String[] args) {
//		FileClass.createNewFile();
//		FileClass.readFile();
//		FileClass.writeFile();
		FileClass.deleteFile();
	}

	public static void createNewFile() {
		// Create a file object for the current location
		File file = new File("newFile.txt");

		try {
			// trying to create a file based on the object
			boolean value = file.createNewFile();
			if (value) {
				System.out.println("The new file is created.");
			} else {
				System.out.println("The file already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readFile() {
		char[] array = new char[100];
		
		try {
			// Creates a read using the FileReader
			FileReader input = new FileReader("input.txt");
			
			// Reads characters
			input.read(array);
			System.out.println("Data in the file:");
			System.out.println(array);
			
			// Closes the reader
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeFile() {
		String data = "This is the data in the output file";
		
		try {
			// Creates a Writer using FileWriter
			FileWriter output = new FileWriter("outputFile.txt");
			
			//Writes string to the file
			output.write(data);
			System.out.println("Data is written to the file");
			
			// Closes the writer
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteFile() {
		// Creates a file object
		File file = new File("outputFile.txt");
		
		// Deletes the file
		boolean value = file.delete();
		if (value) {
			System.out.println("The File is deleted.");
		} else {
			System.out.println("The File is not deleted.");
		}
	}
}
