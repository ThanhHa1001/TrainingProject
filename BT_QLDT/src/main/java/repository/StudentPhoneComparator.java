package repository;

import entity.Student;

public class StudentPhoneComparator implements StudentComparator {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getPhone().compareTo(o2.getPhone());
	}

}
