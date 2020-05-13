package repository;

import entity.Student;

public class StudentEmailComparator implements StudentComparator {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getEmail().compareTo(o2.getEmail());
	}
}
