package repository;

import entity.Student;

public class StudentNameComparator implements StudentComparator {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}
}
