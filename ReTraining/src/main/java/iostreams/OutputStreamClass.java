package iostreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamClass {
	public static void main(String[] args) {
		String data = "This is a line of text inside the file.";
		
		try {
			OutputStream out = new FileOutputStream("output.txt");
			
			// Converts the string into bytes
			byte[] dataBytes = data.getBytes();
			
			// Writes data to the output stream
			out.write(dataBytes);
			System.out.println("Data is written to the file.");
			
			// Close the output stream
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
