package service;

import java.util.ArrayList;
import java.util.List;

import entity.Student;
import repository.StudentRepository;

public class StudentService {
	private StudentRepository studentRepository = new StudentRepository();
	private List<Student> studentsMutable = new ArrayList<Student>();

	public void createDummyStudentData() {
		studentRepository.createDummyStudentData();
	}

	public Student getStudentById(int index) {
		if (studentsMutable.isEmpty()) {
			return null;
		}
		
		return studentsMutable.get(index);
	}
	
	public List<Student> getAllList() {
		return studentRepository.getListStudent();
	}
	
	public void showStudentList() {
		List<Student> students = studentRepository.getListStudent();
		studentsMutable = students;
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println(students.get(i).showStudent());
		}
	}
	
	public void showStudentListWithIndex() {
		List<Student> students = studentRepository.getListStudent();
		studentsMutable = students;
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + students.get(i).showStudent());
		}
	}

	public void showStudentList(List<Student> studentList) {
		studentsMutable = studentList;
		int size = studentList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(studentList.get(i).showStudent());
		}
	}

	public void filterByClassName(String className) {
		List<Student> studentFilters = studentRepository.filterByClassName(className);
		if (studentFilters.isEmpty()) {
			System.out.println("Không có học sinh nào trong lớp " + className);
			return;
		}
		System.out.println("Danh sách học viên lớp " + className);
		showStudentList(studentFilters);
	}

	public void findByName(String name) {
		List<Student> students = studentRepository.findByLastName(name);
		if (students.isEmpty()) {
			System.out.println("Không có học sinh nào có tên " + name);
			return;
		}
		System.out.println("Danh sách học viên có tên " + name);
		showStudentList(students);
	}

	public void findByEmail(String email) {
		Student student = studentRepository.findByEmail(email);
		if (student == null) {
			System.out.println("Không có học sinh nào có email " + email);
			return;
		}
		System.out.println("Thông tin học viên có email " + email);
		System.out.println(student.showStudent());
	}

	public void findByPhone(String phone) {
		Student student = studentRepository.findByPhone(phone);
		if (student == null) {
			System.out.println("Không có học sinh nào có số điện thoại " + phone);
			return;
		}
		System.out.println("Thông tin học viên có số điện thoại " + phone);
		System.out.println(student.showStudent());
	}

	public void sortByName() {
		List<Student> students = studentRepository.sortByLastName();
		studentsMutable = students;
		System.out.println("Danh sách học viên sau khi sắp xếp theo tên");
		showStudentList(students);
	}

	public void sortByEmail() {
		List<Student> students = studentRepository.sortByEmail();
		studentsMutable = students;
		System.out.println("Danh sách học viên sau khi sắp xếp theo email");
		showStudentList(students);
	}

	public void sortByPhone() {
		List<Student> students = studentRepository.sortByPhone();
		studentsMutable = students;
		System.out.println("Danh sách học viên sau khi sắp xếp theo phone");
		showStudentList(students);
	}

	public void insertStudent(Student student) {
		boolean success = studentRepository.insertStudent(student);
		if (success) {
			System.out.println("Thêm thông tin học viên thành công");
			showStudentListWithIndex();
		} else {
			System.out.println("Có lỗi trong quá trình thêm thông tin học viên");
		}
	}

	public void updateStudent(int index, Student student) {
//		Student s = studentsMutable.get(id);
//		List<Student> students = studentRepository.getListStudent();
//		int index = -1;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getId().equals(s.getId())) {
//				index = i;
//			}
//		}

		boolean success = studentRepository.updateStudent(index, student);
		
		if (success) {
			showStudentListWithIndex();
			System.out.println("Sửa thông tin học viên thành công");
		} else {
			System.out.println("Có lỗi trong quá trình sửa thông tin học viên");
		}
	}

	public void deleteStudent(int index) {
//		Student s = studentsMutable.get(id);
//		List<Student> students = studentRepository.getListStudent();
//		int index = -1;
//		for (int i = 0; i < students.size(); i++) {
//			if (students.get(i).getId().equals(s.getId())) {
//				index = i;
//			}
//		}

		boolean success = studentRepository.deleteStudent(index);
		if (success) {
			System.out.println("Xóa thông tin học viên thành công");
			showStudentListWithIndex();
		} else {
			System.out.println("Có lỗi trong quá trình xóa thông tin học viên");
		}
	}
}
