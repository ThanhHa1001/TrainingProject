package controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.Preferences;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.MinistryEntity;
import util.InputUtil;

public class MinistryController extends BaseController {
	Logger logger = LoggerFactory.getLogger(MinistryController.class);

	public String signIn(Scanner scanner) {
		System.out.println("Sign in to your account - signIn(AccountService accountService)");
		logger.debug("Sign in to your account");

		String email = InputUtil.requireUserInput("Email", scanner);
		String password = InputUtil.requireUserInput("Password", scanner);

		if (getMinistryService().signIn(email, password)) {
			logger.debug("Sign in success");
			System.out.println("========> Sign in success");
			return email;
		} else {
			logger.debug("Sign in failed");
			System.out.println("========> Sign in failed");
			return null;
		}
	}

	public boolean signIn(MinistryEntity account) {
		System.out.println("Sign in to your account - signIn(AccountService accountService, Account account)");
		if (getMinistryService().signIn(account.getEmail(), account.getPassword())) {
			logger.debug("Sign in to your account: " + account.toString());
			System.out.println("========> Sign in success");
			return true;
		} else {
			System.out.println("========> Sign in failed");
			return false;
		}
	}

	public MinistryEntity signUp(Scanner scanner) {
		logger.debug("signUp(MinistryService ministryService) - Create your account");
		System.out.println("Create your account");
		String email = InputUtil.requireUserInputEmail("Email", scanner);
		
		if (getMinistryService().checkAccountExist(email)) {
			String msg = email + " is already a QLDT account. Please try a different email address.";
			logger.debug("signUp(AccountService accountService) - " + msg);
			System.out.println(msg);
			signUp(scanner);
			return null;
		} else {
			String firstName = InputUtil.requireUserInput("First Name", scanner);
//			while (!UtilValidator.validateName(firstName)) {
//				String msg = "Invalid firstname - firstName: " + firstName;
//				logger.debug(msg);
//				System.out.println(msg);
//				firstName = InputUtil.requireUserInput("First Name", scanner);
//			}

			String lastName = InputUtil.requireUserInput("Last Name", scanner);
			String password = InputUtil.requireUserInputPassword("Password", scanner);

			String phone = InputUtil.requireUserInput("Phone", scanner);
//			while (!UtilValidator.validatePhone(phone)) {
//				String msg = "Invalid phone - phone: " + phone;
//				logger.debug(msg);
//				System.out.println(msg);
//				phone = InputUtil.requireUserInput("Phone", scanner);
//			}

			// Create the ministry info
			MinistryEntity ministryEntity = new MinistryEntity();
			ministryEntity.setFirstName(firstName);
			ministryEntity.setLastName(lastName);
			ministryEntity.setEmail(email);
			ministryEntity.setPassword(password);
			ministryEntity.setPhone(phone);
			ministryEntity.setCreatedAt(new Date());
			ministryEntity.setCreatedBy(lastName);

			getMinistryService().insert(ministryEntity);

			logger.debug("signUp(AccountService accountService) - " + firstName + " - " + lastName + " - " + email
					+ " - " + password + " - " + phone);
			return ministryEntity;
		}
	}

	public boolean checkAccountExist(String email) {
		if (getMinistryService().checkAccountExist(email)) {
			System.out.println(email + " is already a QLDT account. Please try a different email address.");
			return true;
		}
		return false;
	}

	public MinistryEntity findByEmail(String email) {
		return getMinistryService().findByEmail(email);
	}

	public void showMinistryList() {
		System.out.println("\n============Danh sách giáo vụ==============");
		List<MinistryEntity> ministryList = getMinistryService().findAll();
		System.out.printf("%-5s%-15s%-15s%-30s%-15s%-5s", "ID", "First name", "Last name", "Email", "Phone", "Classroom");
		for (MinistryEntity ministryEntity : ministryList) {
			System.out.printf("\n%-5s%-15s%-15s%-30s%-15s%-5s", ministryEntity.getId(), ministryEntity.getFirstName(),
					ministryEntity.getLastName(), ministryEntity.getEmail(), ministryEntity.getPhone(), ministryEntity.getClassroomName());
		}
	}

	public void insertMinistry(Scanner scanner) {
		System.out.println("Nhập thông tin giáo vụ bạn muốn thêm mới");
		String firstName = InputUtil.requireUserInput("First Name", scanner);
		String lastName = InputUtil.requireUserInput("Last Name", scanner);
		String email = InputUtil.requireUserInputEmail("Email", scanner);
		String password = InputUtil.requireUserInputPassword("Pasword", scanner);
		String phone = InputUtil.requireUserInput("Phone", scanner);

		MinistryEntity ministry = new MinistryEntity();
		ministry.setFirstName(firstName);
		ministry.setLastName(lastName);
		ministry.setEmail(email);
		ministry.setPassword(password);
		ministry.setPhone(phone);
		ministry.setCreatedAt(new Date());
		ministry.setCreatedBy("Admin");

		getMinistryService().insert(ministry);
	}

	public void updateMinistry(Preferences prefs, Scanner scanner) {
		System.out.println("\nDanh sách giáo vụ");
		List<MinistryEntity> ministries = getMinistryService().findAll();
		int size = ministries.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + ministries.get(i).showMinistry());
		}
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn giáo vụ bạn muốn cập nhật thông tin(1 -> " + ministries.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= ministries.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		// Phan tu trong mang bat dau tu 0
		--index;
		MinistryEntity ministry = ministries.get(index);

		System.out.println("Chỉnh sửa thông tin giáo vụ");
		scanner.nextLine();
		String firstName = InputUtil.userInput("First Name", ministry.getFirstName(), scanner);
		String lastName = InputUtil.userInput("Last Name", ministry.getLastName(), scanner);
		String email = InputUtil.userInput("Email", ministry.getEmail(), scanner);
		String password = InputUtil.userInput("Password", ministry.getPassword(), scanner);
		String phone = InputUtil.userInput("Phone", ministry.getPhone(), scanner);

		if (firstName == null || firstName.isEmpty()) {
			firstName = ministry.getFirstName();
		}
		ministry.setFirstName(firstName);

		if (lastName == null || lastName.isEmpty()) {
			lastName = ministry.getLastName();
		}
		ministry.setLastName(lastName);

		if (email == null || email.isEmpty()) {
			email = ministry.getEmail();
		}
		ministry.setEmail(email);

		if (password == null || password.isEmpty()) {
			password = ministry.getPassword();
		}
		ministry.setPassword(password);

		if (phone == null || phone.isEmpty()) {
			phone = ministry.getPhone();
		}
		ministry.setPhone(phone);

		ministry.setModifiedAt(new Date());
		ministry.setModifiedBy("Admin");

		getMinistryService().update(ministry);
	}

	public void deleteMinistry(Preferences prefs, Scanner scanner) {
		System.out.println("\nDanh sách giáo vụ");
		List<MinistryEntity> ministries = getMinistryService().findAll();
		int size = ministries.size();
		for (int i = 0; i < size; i++) {
			System.out.println("[" + (i + 1) + "] " + ministries.get(i).showMinistry());
		}
		boolean loop = false;
		int index;

		do {
			System.out.println("Chọn giáo vụ bạn muốn xóa(1 -> " + ministries.size() + "): ");
			index = scanner.nextInt();

			if (index > 0 && index <= ministries.size()) {
				loop = false;
			} else {
				loop = true;
			}
		} while (loop);

		scanner.nextLine();
		getMinistryService().delete(ministries.get(index - 1).getId());
	}
}
