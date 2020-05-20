package controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.Preferences;

import entity.ClassroomEntity;
import entity.StudentEntity;
import util.InputUtil;

public class StudentController extends BaseController {

	public void showStudentList(Long ministryId) {
		System.out.println("\n============Danh sách học viên==============");
		List<StudentEntity> studentList = getStudentService().findByMinistryId(ministryId);
		System.out.printf("%-5s%-15s%-15s%-15s%-15s", "ID", "First name", "Last name", "Classroom", "Ministry");
		for (StudentEntity studentEntity : studentList) {
			System.out.printf("\n%-5s%-15s%-15s%-15s%-15s", studentEntity.getId(), studentEntity.getFirstName(),
					studentEntity.getLastName(), studentEntity.getClassroomName(), studentEntity.getMinistryName());
		}
	}

	public void insertStudent(Preferences prefs, Scanner scanner) {
		List<ClassroomEntity> classrooms = getClassroomService().findByMinistryId(prefs.getLong("ministry_id", 0));
		StringBuilder className = new StringBuilder("Danh sách lớp: ");
		for (int i = 0; i < classrooms.size(); i++) {
			int index = i + 1;
			className.append("\n(").append(index).append(") ").append(classrooms.get(i).getName());
		}
		className.append("\nChọn lớp theo danh sách trên ");

		System.out.println("Nhập thông tin học viên bạn muốn thêm mới");
		String firstName = InputUtil.requireUserInput("First Name", scanner);
		String lastName = InputUtil.requireUserInput("Last Name", scanner);
		int classNameId = -1;
		do {
			classNameId = Integer.parseInt(InputUtil.requireUserInput(className.toString(), scanner));
		} while (classNameId < 0 || classNameId > classrooms.size());

		String note = InputUtil.requireUserInput("Ghi chú (nếu có)", scanner);

		StudentEntity student = new StudentEntity();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setClassroomId(classrooms.get(classNameId - 1).getId());
		student.setNote(note);
		student.setCreatedAt(new Date());
		student.setCreatedBy(prefs.get("ministry_name", "NULL"));

		getStudentService().insert(student);
	}

	public void updateStudent(Preferences prefs, Scanner scanner) {
		List<ClassroomEntity> classrooms = getClassroomService().findByMinistryId(prefs.getLong("ministry_id", 0));
		StringBuilder className = new StringBuilder("Danh sách lớp: ");
		for (int i = 0; i < classrooms.size(); i++) {
			int index = i + 1;
			className.append("\n(").append(index).append(") ").append(classrooms.get(i).getName());
		}
		className.append("\nChọn lớp theo danh sách trên ");

		System.out.println("\nDanh sách học viên");
		List<StudentEntity> students = getStudentService().findByMinistryId(prefs.getLong("ministry_id", 0));
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + students.get(i).showStudent());
		}
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn học viên bạn muốn cập nhật thông tin(1 -> " + students.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= students.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		// Phan tu trong mang bat dau tu 0
		--index;
		StudentEntity student = students.get(index);

		System.out.println("Chỉnh sửa thông tin học viên");
		scanner.nextLine();
		String firstName = InputUtil.userInput("First Name", student.getFirstName(), scanner);
		String lastName = InputUtil.userInput("Last Name", student.getLastName(), scanner);

		int classNameId = student.getClassroomId().intValue();
		do {
			classNameId = Integer.parseInt(InputUtil.requireUserInput(className.toString(), scanner)) - 1;
		} while (classNameId < 0 || classNameId > classrooms.size());

		String noteValue = student.getNote();
		if (noteValue == null) {
			noteValue = "";
		}
		String note = InputUtil.userInput("Ghi chú (nếu có)", noteValue, scanner);
		if (note == null || note.isEmpty()) {
			note = noteValue;
		}
		student.setNote(note);
		
		if (firstName == null || firstName.isEmpty()) {
			firstName = student.getFirstName();
		}
		student.setFirstName(firstName);

		if (lastName == null || lastName.isEmpty()) {
			lastName = student.getLastName();
		}
		student.setLastName(lastName);
		
		student.setClassroomId(classrooms.get(classNameId).getId());
		student.setModifiedAt(new Date());
		student.setModifiedBy(prefs.get("ministry_name", ""));

		getStudentService().update(student);
	}

	public void deleteStudent(Preferences prefs, Scanner scanner) {
		System.out.println("\nDanh sách học viên");
		List<StudentEntity> students = getStudentService().findByMinistryId(prefs.getLong("ministry_id", 0));
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + students.get(i).showStudent());
		}
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn học viên bạn muốn xóa(1 -> " + students.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= students.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		scanner.nextLine();
		getStudentService().delete(students.get(index - 1).getId());
	}

	public void findByNameOrClass(Scanner scanner) {
		System.out.println("\nNhập tên hoặc lớp học viên: ");
		String value = scanner.nextLine();

		List<StudentEntity> students = getStudentService().findByNameOrClass(value);
		int size = students.size();

		if (size == 0) {
			System.out.println("Không có học sinh nào thỏa mãn thông tin tìm kiếm");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.println("[" + (i + 1) + "] " + students.get(i).showStudent());
			}
		}
	}
}