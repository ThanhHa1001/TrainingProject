import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import controller.ClassroomController;
import controller.MinistryController;
import controller.StudentController;
import entity.MinistryEntity;
import util.MenuUtils;

public class Main {
	static Preferences prefs = Preferences.userRoot().node(Main.class.getName());

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		MinistryController ministryController = new MinistryController();
		StudentController studentController = new StudentController();
		ClassroomController classroomController = new ClassroomController();

		try {
			prefs.clear();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}

		handleHomeMenu(ministryController, studentController, classroomController, prefs, scanner);
	}

	public static void handleHomeMenu(MinistryController ministryController, StudentController studentController,
			ClassroomController classroomController, Preferences prefs, Scanner scanner) {
		MenuUtils.showMenuHome();

		boolean loop = false;
		do {
			loop = false;
			switch (scanner.nextLine().trim()) {
			case "1":
				String email = ministryController.signIn(scanner);
				if (email != null) {
					MinistryEntity ministryEntity = ministryController.findByEmail(email);
					prefs.putLong("ministry_id", ministryEntity.getId());
					prefs.put("ministry_name", ministryEntity.getFirstName() + ministryEntity.getLastName());

					if (ministryEntity.getRole() == 1L) {
						ministryController.showMinistryList();
						handleMangerMinistryMenu(ministryController, studentController, classroomController, scanner);
					} else {
						studentController.showStudentList(ministryEntity.getId());
						handleMangerStudentMenu(ministryController, studentController, classroomController, prefs, scanner);
					}
				} else {
					System.out.println("\nTài khoản hoặc mật khẩu không tồn tại.");
					System.out.println("Nhập 1 tài khoản khác hoặc đăng ký tài khoản mới");
					handleHomeMenu(ministryController, studentController, classroomController, prefs, scanner);
				}
				break;
			case "2":
				MinistryEntity account = ministryController.signUp(scanner);
				if (ministryController.signIn(account)) {
					studentController.showStudentList(account.getId());
					handleMangerStudentMenu(ministryController, studentController, classroomController, prefs, scanner);
				} else {
					System.out.println("\nCó lỗi trong quá trình tạo tài khoản. Vui lòng thử lại.");
					System.out.println("Nhập 1 tài khoản khác hoặc đăng ký tài khoản mới");
					handleHomeMenu(ministryController, studentController, classroomController, prefs, scanner);
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

	public static void handleMangerMinistryMenu(MinistryController ministryController,
			StudentController studentController, ClassroomController classroomController, Scanner scanner) {
		int selection = -1;
		do {
			MenuUtils.showMenuManageMinistry();
			switch (scanner.nextLine().trim()) {
			case "1": // Thêm thông tin giáo vụ
				ministryController.insertMinistry(scanner);
				break;
			case "2": // Sửa thông tin giáo vụ
				ministryController.updateMinistry(prefs, scanner);
				break;
			case "3": // Xóa thông tin giáo vụ
				ministryController.deleteMinistry(prefs, scanner);
				break;
			case "4": // Thêm thông tin lớp
				classroomController.insertClassroom(scanner);
				break;
			case "5": // Sửa thông tin lớp
				classroomController.updateClassroom(scanner);
				break;
			case "6": // Xóa thông tin lớp
				classroomController.deleteClassroom(scanner);
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

	public static void handleMangerStudentMenu(MinistryController ministryController,
			StudentController studentController, ClassroomController classroomController, Preferences prefs,
			Scanner scanner) {
		int selection = -1;
		do {
			MenuUtils.showMenuManageStudent();
			switch (scanner.nextLine().trim()) {
			case "1": // Thêm thông tin học viên
				studentController.insertStudent(prefs, scanner);
				break;
			case "2": // Sửa thông tin học viên
				studentController.updateStudent(prefs, scanner);
				break;
			case "3": // Xóa thông tin học viên
				studentController.deleteStudent(prefs, scanner);
				break;
			case "4": // Tìm thông tin học viên theo: Tên, lớp, email
				studentController.findByNameOrClass(scanner);
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
}
