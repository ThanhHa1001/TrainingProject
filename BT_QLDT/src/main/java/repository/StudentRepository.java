package repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Student;

public class StudentRepository {
	Logger logger = LoggerFactory.getLogger(StudentRepository.class);
	
	List<Student> students = new ArrayList<>();

	public void createDummyStudentData() {
		Student student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Nguyen Van");
		student.setLastName("A");
		student.setEmail("nguyenvana@gmail.com");
		student.setClassName("12A1");
		student.setPhone("0971236584");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Phan Thi");
		student.setLastName("B");
		student.setEmail("phanthib@gmail.com");
		student.setClassName("12A2");
		student.setPhone("0971231234");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Tran Van");
		student.setLastName("C");
		student.setEmail("tranvanc@gmail.com");
		student.setClassName("12A3");
		student.setPhone("0971234785");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Truong Van");
		student.setLastName("D");
		student.setEmail("truongvand@gmail.com");
		student.setClassName("12A4");
		student.setPhone("0971231212");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Truong");
		student.setLastName("J");
		student.setEmail("truongj@gmail.com");
		student.setClassName("12A1");
		student.setPhone("0971231212");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Nguyen");
		student.setLastName("W");
		student.setEmail("nguyenw@gmail.com");
		student.setClassName("12A1");
		student.setPhone("0971231212");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Nguyen Thi");
		student.setLastName("D");
		student.setEmail("nguyenthid@gmail.com");
		student.setClassName("12A2");
		student.setPhone("0971231212");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Truong Van");
		student.setLastName("D");
		student.setEmail("truongvand@gmail.com");
		student.setClassName("12A4");
		student.setPhone("0971231212");
		students.add(student);

		student = new Student();
		student.setId(UUID.randomUUID());
		student.setFirstName("Tran Thu");
		student.setLastName("x");
		student.setEmail("tranthux@gmail.com");
		student.setClassName("12A3");
		student.setPhone("0971231212");
		students.add(student);
		
		logger.debug("createDummyStudentData success - accountList: " + students.toString());
	}

	public List<Student> getListStudent() {
		if (students.isEmpty()) {
			return null;
		}
		return students;
	}

	public List<Student> filterByClassName(String className) {
		List<Student> studentFilters = new ArrayList<>();
		int size = students.size();
		for (int i = 0; i < size; i++) {
			Student student = students.get(i);
			if (student.getClassName().equals(className)) {
				studentFilters.add(student);
			}
		}
		return studentFilters;
	}

	public List<Student> findByLastName(String name) {
		List<Student> s = new ArrayList<>();
		int size = students.size();
		for (int i = 0; i < size; i++) {
			Student student = students.get(i);
			if (student.getLastName().equals(name)) {
				s.add(student);
			}
		}
		return s;
	}

	public Student findByPhone(String phone) {
		Student student = null;
		int size = students.size();
		for (int i = 0; i < size; i++) {
			Student s = students.get(i);
			if (s.getPhone().equals(phone)) {
				student = s;
				break;
			}
		}
		return student;
	}

	public Student findByEmail(String email) {
		Student student = null;
		int size = students.size();
		for (int i = 0; i < size; i++) {
			Student s = students.get(i);
			if (s.getEmail().equals(email)) {
				student = s;
				break;
			}
		}
		return student;
	}

	public List<Student> sortByLastName() {
		List<Student> s = getListStudent();
		if (s == null) {
			return s;
		}
		Collections.sort(s, new StudentNameComparator());
		return s;
	}

	public List<Student> sortByEmail() {
		List<Student> s = getListStudent();
		if (s == null) {
			return s;
		}
		Collections.sort(s, new StudentEmailComparator());
		return s;
	}

	public List<Student> sortByPhone() {
		List<Student> s = getListStudent();
		if (s == null) {
			return s;
		}
		Collections.sort(s, new StudentPhoneComparator());
		return s;
	}

	public boolean insertStudent(Student student) {
		students.add(student);
		logger.debug("insertStudent: " + student.toString());
		return true;
	}

	public boolean updateStudent(int id, Student student) {
		if (id == -1) {
			return false;
		}
		students.set(id, student);
		logger.debug("updateStudent: id = " + id + " student: " + student.toString());
		return true;
	}

	public boolean deleteStudent(int id) {
		if (id == -1) {
			return false;
		}
		logger.debug("deleteStudent: id = " + id + " - student: " + students.get(id));
		students.remove(id);
		return true;
	}
}
