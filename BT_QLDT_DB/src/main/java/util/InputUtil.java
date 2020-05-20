package util;

import java.util.Scanner;

public class InputUtil {
	public static String requireUserInput(String title, Scanner scanner) {
		System.out.print(title + ": ");
		String input = scanner.nextLine();
		while (input == null || input.isEmpty()) {
			System.out.println(title + " is required");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		
		return input;
	}

	public static String userInput(String title, String value, Scanner scanner) {
		System.out.print(title + "(không nhập sẽ sử dụng thông tin ban đầu: " + value + " ): ");
		String input = scanner.nextLine();
		return input;
	}
	
	public static String requireUserInputEmail(String title, Scanner scanner) {
		System.out.print(title + ": ");
		String input = scanner.nextLine();
		while (input == null || input.isEmpty()) {
			System.out.println(title + " is required");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		
		while(!UtilValidator.validateEmail(input)) {
			System.out.println("Nhập địa chỉ email address theo định dạng sau: 'someone@example.com'");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		return input;
	}
	
	public static String requireUserInputPassword(String title, Scanner scanner) {
		System.out.print(title + ": ");
		String input = scanner.nextLine();
		while (input == null || input.isEmpty()) {
			System.out.println(title + " is required");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		
		while(!UtilValidator.validatePassword(input)) {
			System.out.println("Password phải lớn hơn 6 ký tự, bao gồm ít nhất 1 số, chữ cái in hoa, chữ thường");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		return input;
	}
	
	public static String requireUserInputName(String title, Scanner scanner) {
		System.out.print(title + ": ");
		String input = scanner.nextLine();
		while (input == null || input.isEmpty()) {
			System.out.println(title + " is required");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		while(!UtilValidator.validateName(input)) {
			System.out.println("Chỉ được phép nhập chữ cái");
			System.out.print(title + ": ");
			input = scanner.nextLine();
		}
		return input;
	}
}
