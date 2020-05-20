package util;

public class MenuUtils {
	private static void showHeaderMenu() {
		System.out.println("======================================================");
		System.out.println("|              TRANG QUAN LY DAO TAO                 |");
	}
	
	public static void showMenuHome() {
		showHeaderMenu();
		System.out.println("======================================================");
		System.out.println("| Menu:                                              |");
		System.out.println("|     [1] Đăng nhập                                  |");
		System.out.println("|     [2] Đăng ký                                    |");
		System.out.println("|     [0] Thoát                                      |");
		System.out.println("======================================================");
		System.out.println("Chọn số tương ứng với các chức năng: ");
	}
	
	public static void showMenuManageMinistry() {
		System.out.println("\n");
		showHeaderMenu();
		System.out.println("======================================================");
		System.out.println("| Menu:                                              |");
		System.out.println("|     [1] Thêm thông tin giáo vụ                     |");
		System.out.println("|     [2] Sửa thông tin giáo vụ                      |");
		System.out.println("|     [3] Xóa thông tin giáo vụ                      |");
		System.out.println("|     [4] Thêm thông tin lớp                         |");
		System.out.println("|     [5] Sửa thông tin lớp                          |");
		System.out.println("|     [6] Xóa thông tin lớp                          |");
		System.out.println("|     [0] Thoát                                      |");
		System.out.println("======================================================");
		System.out.println("Chọn số tương ứng với các chức năng: ");
	}
	
	public static void showMenuManageStudent() {
		System.out.println("\n");
		showHeaderMenu();
		System.out.println("======================================================");
		System.out.println("| Menu:                                              |");
		System.out.println("|     [1] Thêm thông tin học sinh                    |");
		System.out.println("|     [2] Sửa thông tin học sinh                     |");
		System.out.println("|     [3] Xóa thông tin học sinh                     |");
		System.out.println("|     [4] Tìm kiếm học viên theo: Tên hoặc lớp       |");
		System.out.println("|     [0] Thoát                                      |");
		System.out.println("======================================================");
		System.out.println("Chọn số tương ứng với các chức năng: ");
	}
}
