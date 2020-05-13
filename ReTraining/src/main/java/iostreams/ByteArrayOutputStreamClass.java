package iostreams;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamClass {
	public static void main(String[] args) {
		ByteArrayOutputStreamClass.readData();
	}

	public static void readData() {
		String data = "This is a line of text inside the string";

		try {
			// Creates an output stream
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] array = data.getBytes();

			// Writes data to the output stream
			out.write(array);

			// Returns an array of bytes
			byte[] byteData = out.toByteArray();
			System.out.print("Data using toByteArray(): ");
			for (int i = 0; i < byteData.length; i++) {
				System.out.print((char) byteData[i]);
			}

			System.out.println();
			// Retrieves data from the output stream in string format
			String streamData = out.toString();
			System.out.println("Data using toString(): " + streamData);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
