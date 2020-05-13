import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Account;
import service.AccountService;
import utils.InputUtil;

public class SignIn {
	Logger logger = LoggerFactory.getLogger(SignIn.class);
	
	Scanner scanner = new Scanner(System.in);
	
	public boolean signIn(AccountService accountService) {
		System.out.println("Sign in to your account - signIn(AccountService accountService)");
		logger.debug("Sign in to your account");
		
		String email = InputUtil.requireUserInput("Email", scanner);
		String password = InputUtil.requireUserInput("Password", scanner);
		
		if (accountService.signIn(email, password)) {
			logger.debug("Sign in success");
			System.out.println("========> Sign in success");
			return true;
		} else {
			logger.debug("Sign in failed");
			System.out.println("========> Sign in failed");
			return false;
		}
	}
	
	public boolean signIn(AccountService accountService, Account account) {
		System.out.println("Sign in to your account - signIn(AccountService accountService, Account account)");
		if (accountService.signIn(account.getEmail(), account.getPassword())) {
			logger.debug("Sign in to your account: " + account.toString());
			System.out.println("========> Sign in success");
			return true;
		} else {
			System.out.println("========> Sign in failed");
			return false;
		}
	}
}
