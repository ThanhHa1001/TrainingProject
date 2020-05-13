package utils;

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
}
