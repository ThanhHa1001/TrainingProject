package iostreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamClass {
	public static void main(String[] args) {
		ByteArrayInputStreamClass.readData();
	}

	public static void readData() {

		// Creates an array of byte
		byte[] array = { 1, 2, 3, 4 };

		try {
			ByteArrayInputStream input = new ByteArrayInputStream(array);

			System.out.println("The bytes read from the input stream: ");

			for (int i = 0; i < array.length; i++) {
				// Reads the bytes
				int data = input.read();
				System.out.print(data + ", ");
			}

			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
