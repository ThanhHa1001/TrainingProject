package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Account;
import repository.AccountRepository;

public class AccountService {
	Logger logger = LoggerFactory.getLogger(AccountService.class);
	
	AccountRepository accountRepository = new AccountRepository();
	
	public void createDummyAccountData() {
		logger.debug("createDummyAccountData() method");
		accountRepository.createDummyAccountData();
	}
	
	public void createAccount(Account account) {
		logger.debug("createAccount() - account: " + account.toString());
		accountRepository.createAccount(account);
	}
	
	public boolean checkAccountExist(String accountName) {
		logger.debug("checkAccountExist() - accountName: " + accountName);
		return accountRepository.checkAccountExist(accountName);
	}
	
	public boolean signIn(String email, String password) {
		if (accountRepository.checkAccountExist(email)) {
			Account account = accountRepository.getAccountInfo(email);
			if (account.getPassword().equals(password)) {
				accountRepository.updateLastLoginTime(account);
				return true;
			}
		}
		return false;
	}
}
