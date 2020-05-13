import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Account;
import entity.Ministry;
import service.AccountService;
import utils.InputUtil;
import utils.UtilValidator;

public class SignUp {
	Logger logger = LoggerFactory.getLogger(SignUp.class);
	
	Scanner scanner = new Scanner(System.in);

	public Account signUp(AccountService accountService) {
		logger.debug("signUp(AccountService accountService) - Create your account");
		System.out.println("Create your account");
		String email = InputUtil.requireUserInput("Email", scanner);
		while(!UtilValidator.validateEmail(email)) {
			String msg = "Invalid email address - email: " + email;
			logger.debug(msg);
			System.out.println(msg);
			email = InputUtil.requireUserInput("Email", scanner);
		}
		
		if (accountService.checkAccountExist(email)) {
			String msg = email + " is already a QLDT account. Please try a different email address.";
			logger.debug("signUp(AccountService accountService) - " + msg);
			System.out.println(msg);
			signUp(accountService);
			return null;
		} else {
			String firstName = InputUtil.requireUserInput("First Name", scanner);
			while(!UtilValidator.validateName(firstName)) {
				String msg = "Invalid email firstname - firstName: " + firstName;
				logger.debug(msg);
				System.out.println(msg);
				firstName = InputUtil.requireUserInput("First Name", scanner);
			}
			
			String lastName = InputUtil.requireUserInput("Last Name", scanner);
			String password = InputUtil.requireUserInput("Password", scanner);
			
			String phone = InputUtil.requireUserInput("Phone", scanner);
			while(!UtilValidator.validatePhone(phone)) {
				String msg = "Invalid email phone - phone: " + phone;
				logger.debug(msg);
				System.out.println(msg);
				phone = InputUtil.requireUserInput("Phone", scanner);
			}

			// Create the ministry info
			Ministry ministry = new Ministry();
			ministry.setFirstName(firstName);
			ministry.setLastName(lastName);
			ministry.setPhone(phone);

			// Create the account info
			Account account = new Account();
			account.setId(UUID.randomUUID());
			account.setEmail(email);
			account.setPassword(password);
			account.setCreateAt(new Date());
			account.setMinistry(ministry);
			account.setLastLoginTime(new Date());

			accountService.createAccount(account);
			logger.debug("signUp(AccountService accountService) - " + firstName + " - " + lastName + " - " + email + " - " + password + " - " + phone);
			System.out.println(firstName + " - " + lastName + " - " + email + " - " + password + " - " + phone);
			return account;
		}
	}

	public boolean checkAccountExist(AccountService accountService, String email) {
		if (accountService.checkAccountExist(email)) {
			System.out.println(email + " is already a QLDT account. Please try a different email address.");
			return true;
		}
		return false;
	}
}
