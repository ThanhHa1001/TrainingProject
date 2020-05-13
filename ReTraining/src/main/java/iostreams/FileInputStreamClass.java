package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamClass {
	public static void main(String[] args) {
		FileInputStreamClass.testAvailableMethod();
		FileInputStreamClass.testSkipMethod();
		
		/**
		try {
			FileInputStream input = new FileInputStream("input.txt");
			
			System.out.println("Data in the file: ");
			
			// Reads the first file
			int i = input.read();
			while( i != -1) {
				System.out.print((char)i);
				System.out.println();
				// Reads next byte from the file
				i = input.read();
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	public static void testAvailableMethod() {
		try {
			// Suppose, the input.txt file contains the following text
			// This is a line of text inside the file.
			FileInputStream input = new FileInputStream("input.txt");
			
			// Returns the number of available bytes
			System.out.println("Available bytes at the beginning: " + input.available());
			
			// Reads 3 bytes from the file
			input.read();
			input.read();
			input.read();
			
			// Returns the number of available bytes
			System.out.println("Available bytes at the end: " + input.available());
			
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testSkipMethod() {
		try {
			// Suppose, the input.txt file contains the following text
			// This is a line of text inside the file.
			FileInputStream input = new FileInputStream("input.txt");
			
			// Skips the 5 bytes
			input.skip(5);
			System.out.println("Input stream after skipping 5 bytes: ");
			
			// Reads the first byte
			int i = input.read();
			while(i != -1) {
				System.out.println((char) i);
				
				// Reads next byte from the file
				i = input.read();
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
