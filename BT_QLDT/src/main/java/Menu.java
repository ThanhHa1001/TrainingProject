
public class Menu {
	private void showHeaderMenu() {
		System.out.println("======================================================");
		System.out.println("|              TRANG QUAN LY DAO TAO                 |");
	}
	
	public void showMenuHome() {
		showHeaderMenu();
		System.out.println("======================================================");
		System.out.println("| Menu:                                              |");
		System.out.println("|     [1] Đăng nhập                                  |");
		System.out.println("|     [2] Đăng ký                                    |");
		System.out.println("|     [0] Thoát                                      |");
		System.out.println("======================================================");
		System.out.println("Chọn số tương ứng với các chức năng: ");
	}
	
	public void showMenuManageStudent() {
		System.out.println("\n");
		showHeaderMenu();
		System.out.println("======================================================");
		System.out.println("| Menu:                                              |");
		System.out.println("|     [1] Lọc danh sách học viên theo lớp            |");
		System.out.println("|     [2] Tìm thông tin học viên: Tên                |");
		System.out.println("|     [3] Tìm thông tin học viên: Email              |");
		System.out.println("|     [4] Tìm thông tin học viên: Số điện thoại      |");
		System.out.println("|     [5] Sắp xếp học viên: Tên                      |");
		System.out.println("|     [6] Sắp xếp học viên: Email                    |");
		System.out.println("|     [7] Sắp xếp học viên: Số điện thoại            |");
		System.out.println("|     [8] Thêm thông tin học viên                    |");
		System.out.println("|     [9] Sửa thông tin học viên                     |");
		System.out.println("|    [10] Xóa thông tin học viên                     |");
		System.out.println("|     [0] Thoát                                      |");
		System.out.println("======================================================");
		System.out.println("Chọn số tương ứng với các chức năng: ");
	}
}
