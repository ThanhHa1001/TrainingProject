import java.util.List;
import java.util.Scanner;

import entity.Account;
import entity.Student;
import service.AccountService;
import service.StudentService;
import utils.InputUtil;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountService accountService = new AccountService();
		StudentService studentService = new StudentService();
		Menu menu = new Menu();

		// Create dummy account
		accountService.createDummyAccountData();

		// Create dummy student
		studentService.createDummyStudentData();

		handleHomeMenu(menu, accountService, studentService, scanner);
	}

	public static void handleHomeMenu(Menu menu, AccountService accountService, StudentService studentService,
			Scanner scanner) {
		SignUp signUp = new SignUp();
		SignIn signIn = new SignIn();

		boolean loop = false;
		do {
			loop = false;
			menu.showMenuHome();
			switch (scanner.nextLine().trim()) {
			case "1":
				boolean signInSuccess = signIn.signIn(accountService);
				if (signInSuccess) {
					System.out.println("\n============Danh sách học viên==============");
					studentService.showStudentList();

					handleMangerStudentMenu(menu, studentService, scanner);
				} else {
					System.out.println("\nTài khoản hoặc mật khẩu không tồn tại.");
					System.out.println("Nhập 1 tài khoản khác hoặc đăng ký tài khoản mới");
					handleHomeMenu(menu, accountService, studentService, scanner);
				}
				break;
			case "2":
				Account account = signUp.signUp(accountService);
				if (signIn.signIn(accountService, account)) {
					System.out.println("\n============Danh sách học viên==============");
					studentService.showStudentList();

					handleMangerStudentMenu(menu, studentService, scanner);
				} else {
					System.out.println("\nCó lỗi trong quá trình tạo tài khoản. Vui lòng thử lại.");
					System.out.println("Nhập 1 tài khoản khác hoặc đăng ký tài khoản mới");
					handleHomeMenu(menu, accountService, studentService, scanner);
				}
				break;
			case "0":
				System.out.println("Vừa vào đã thoát luôn à :(");
				break;
			default:
				System.out.println("Chức năng bạn chọn không hợp lệ. Vui lòng kiểm tra lại.");
				loop = true;
				break;
			}
		} while (loop);
	}

	public static void handleMangerStudentMenu(Menu menu, StudentService studentService, Scanner scanner) {
		int selection = -1;
		do {
			menu.showMenuManageStudent();
			switch (scanner.nextLine().trim()) {
			case "1": // Lọc danh sách học viên theo lớp
				filterStudentByClass(studentService, scanner);
				break;
			case "2": // Tìm thông tin học viên: Tên
				findByName(studentService, scanner);
				break;
			case "3": // Tìm thông tin học viên: Email
				findByEmail(studentService, scanner);
				break;
			case "4": // Tìm thông tin học viên: Số điện thoại
				findByPhone(studentService, scanner);
				break;
			case "5": // Sắp xếp học viên: Tên
				studentService.sortByName();
				break;
			case "6": // Sắp xếp học viên: Email
				studentService.sortByEmail();
				break;
			case "7": // Sắp xếp học viên: Số điện thoại
				studentService.sortByPhone();
				break;
			case "8": // Thêm thông tin học viên
				insertStudent(studentService, scanner);
				break;
			case "9": // Sửa thông tin học viên
				updateStudent(studentService, scanner);
				break;
			case "10": // Xóa thông tin học viên
				deleteStudent(studentService, scanner);
				break;
			case "0": // Thoát
				selection = 0;
				break;
			default:
				System.out.println("Chức năng bạn chọn không hợp lệ. Vui lòng kiểm tra lại.");
				break;
			}
		} while (selection != 0);
	}

	public static void filterStudentByClass(StudentService studentService, Scanner scanner) {
		System.out.println("Nhập tên lớp (12A1, 12A2, 12A3, 12A4): ");
		String className = scanner.nextLine();
		studentService.filterByClassName(className);
	}

	public static void findByName(StudentService studentService, Scanner scanner) {
		System.out.println("Nhập tên học viên: ");
		String name = scanner.nextLine();
		studentService.findByName(name);
	}

	public static void findByEmail(StudentService studentService, Scanner scanner) {
		System.out.println("Nhập email học viên: ");
		String email = scanner.nextLine();
		studentService.findByEmail(email);
	}

	public static void findByPhone(StudentService studentService, Scanner scanner) {
		System.out.println("Nhập số điện thoại học viên: ");
		String phone = scanner.nextLine();
		studentService.findByPhone(phone);
	}

	private static void insertStudent(StudentService studentService, Scanner scanner) {
		System.out.println("Nhập thông tin học viên bạn muốn thêm mới");
		String firstName = InputUtil.requireUserInput("First Name", scanner);
		String lastName = InputUtil.requireUserInput("Last Name", scanner);
		String className = InputUtil.requireUserInput("ClassName", scanner);
		String email = InputUtil.requireUserInput("Email", scanner);
		String phone = InputUtil.requireUserInput("Phone", scanner);
		String note = InputUtil.requireUserInput("Ghi chú (nếu có)", scanner);

		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setClassName(className);
		student.setPhone(phone);
		student.setNote(note);

		studentService.insertStudent(student);
	}
	
	private static void updateStudent(StudentService studentService, Scanner scanner) {
		System.out.println("\nDanh sách học viên");
		List<Student> students = studentService.getAllList();
		studentService.showStudentListWithIndex();
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
		Student student = students.get(index);

		System.out.println("Chỉnh sửa thông tin học viên");
		scanner.nextLine();
		String firstName = InputUtil.userInput("First Name", student.getFirstName(), scanner);
		String lastName = InputUtil.userInput("Last Name", student.getLastName(), scanner);
		String className = InputUtil.userInput("ClassName", student.getClassName(), scanner);
		String email = InputUtil.userInput("Email", student.getEmail(), scanner);
		String phone = InputUtil.userInput("Phone", student.getPhone(), scanner);

		String noteValue = student.getNote();
		if (noteValue == null) {
			noteValue = "";
		}
		String note = InputUtil.userInput("Ghi chú (nếu có)", noteValue, scanner);

		if (firstName == null || firstName.isEmpty()) {
			firstName = student.getFirstName();
		}
		student.setFirstName(firstName);

		if (lastName == null || lastName.isEmpty()) {
			lastName = student.getLastName();
		}
		student.setLastName(lastName);

		if (email == null || email.isEmpty()) {
			email = student.getEmail();
		}
		student.setEmail(email);

		if (className == null || className.isEmpty()) {
			className = student.getClassName();
		}
		student.setClassName(className);

		if (phone == null || phone.isEmpty()) {
			phone = student.getPhone();
		}
		student.setPhone(phone);

		if (note == null || note.isEmpty()) {
			note = noteValue;
		}
		student.setNote(note);

		studentService.updateStudent(index, student);
	}

	private static void deleteStudent(StudentService studentService, Scanner scanner) {
		System.out.println("\nDanh sách học viên");
		studentService.showStudentListWithIndex();
		List<Student> students = studentService.getAllList();
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
		studentService.deleteStudent(index - 1);
	}
}
