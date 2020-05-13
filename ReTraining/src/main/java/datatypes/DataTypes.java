package datatypes;

import entity.Student;

public class DataTypes {
	public void demoDataTypes() {
		// The number 26, in decimal
		int decVal = 26;
		System.out.println("decVal: " + decVal);
		// The number 26, in hexadecimal
		int hexVal = 0x1a;
		System.out.println("hexVal: " + hexVal);
		// The number 26, in binary
		int binVal = 0b11010;
		System.out.println("binVal: " + binVal);

		double d1 = 123.4;
		// same value as d1, but in scientific notation
		double d2 = 1.234e2;
		System.out.println("d1: " + d1 + " -- d2: " + d2);
		float f1 = 123.4f;
		System.out.println("f1: " + f1);
	}

	public void showPrimitiveDataTypes() {
		// declaring character
		char a = 'G';

		// Integer data type is generally
		// used for numeric values
		int i = 89;

		// use byte and short
		// if memory is a constraint
		byte b = 4;

		// this will give error as number is
		// large than byte range
		// byte b1 = 7888888955
		short s = 56;

		// this will give error as number is
		// larger than short range
		// short s1 = 87878787878;

		// by default fraction value
		// is double in java
		double d = 4.355453532;

		// for float use 'f' as suffix
		float f = 4.73334347f;

		System.out.println("char: " + a);
		System.out.println("integer: " + i);
		System.out.println("byte: " + b);
		System.out.println("short: " + s);
		System.out.println("float: " + f);
		System.out.println("double: " + d);
	}
	
	public void showNonPrimitiveDatatype() {
		// Declare String without using new operator
		String s = "Mie";
		
		// Declare String using new operator
		String s1 = new String("Ahihihi");
		
		System.out.println("s: " + s);
		System.out.println("s1: " + s1);
	}
	
	public void demoPassBy() {
		Student student1 = new Student("001", "12A1", 9);
		System.out.println("Student1: " + student1.toString());
		
		Student student2 = student1;
		System.out.println("Student2: " + student2.toString());
		
		student1.setPoint(8);
		System.out.println("After change value point of student1 -> Student1: " + student1.toString());
		System.out.println("After change value point of student1 -> Student2: " + student2.toString());
		
		student2.setPoint(5);
		System.out.println("After change value point of student2 -> Student1: " + student1.toString());
		System.out.println("After change value point of student2 -> Student2: " + student2.toString());
	}
}
