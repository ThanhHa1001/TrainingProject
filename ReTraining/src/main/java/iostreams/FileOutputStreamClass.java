package iostreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamClass {
	public static void main(String[] args) {
		FileOutputStreamClass.writeData();
		FileOutputStreamClass.flushMethod();
	}
	
	public static void writeData() {
		String data = "This is a line of text inside the file. Ahihi";
		
		try {
			FileOutputStream output = new FileOutputStream("output.txt");
			
			byte[] array = data.getBytes();
			
			//Writes byte to the file
			output.write(array);
			
			output.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void flushMethod() {
		FileOutputStream out = null;
		
		String data1 = "This is demo of flush method.";
		
		try {
			out = new FileOutputStream("flush112.txt");
			
			// Using write() method
			out.write(data1.getBytes());
			
			// Using the flush() method
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
