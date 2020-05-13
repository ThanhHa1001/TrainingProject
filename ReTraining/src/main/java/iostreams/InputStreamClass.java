package iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamClass {
	public static void main(String[] args) {
		byte[] array = new byte[100];
		
		try {
			// Creates an InputStream
			InputStream inputStream = new FileInputStream("input.txt");
			System.out.println("Available bytes in the file: " + inputStream.available());
			
			// Read byte from input stream
			inputStream.read(array);
			System.out.println("Data read from the file: ");
			
			// Convert byte array into string
			String data = new String(array);
			System.out.println(data);
			
			// Close the input stream
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileInputStream: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("InputStream available: " + e);
			e.printStackTrace();
		}
	}
}
