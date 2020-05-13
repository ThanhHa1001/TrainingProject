package iostreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//Get scanner instance
        Scanner scanner;
		try {
			scanner = new Scanner(new File("TestCSVFile.csv"));
			
			//Set the delimiter used in file
	        scanner.useDelimiter(",");
	         
	        //Get all tokens and store them in some data structure
	        //I am just printing them
	        while (scanner.hasNext()) 
	        {
	            System.out.print(scanner.next() + " ");
	        }
	      //Do not forget to close the scanner  
	        scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
