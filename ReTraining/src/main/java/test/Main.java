package test;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		Student s1 = new Student(1, "A");
		students.add(s1);

		Student s2 = new Student(2, "B");
		students.add(s2);
		
		Student s3 = new Student(3, "C");
		students.add(s3);
		
		Student s4 = new Student(4, "D");
		students.add(s4);
		
		System.out.println(students.toString());
		
		Student editStudent = students.get(1);
		System.out.println(editStudent.toString());
		
		editStudent.setName("Adasdadasadasdasdas");
		
		System.out.println(students.toString());
	}

}
