package repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Account;
import entity.Ministry;

public class AccountRepository {
	Logger logger = LoggerFactory.getLogger(AccountRepository.class);
	
	Map<String, Account> accounts = new HashMap<>();

	public void createDummyAccountData() {
		Ministry ministry = new Ministry();
		ministry.setFirstName("misaki");
		ministry.setLastName("mei");
		ministry.setEmail("mei@gmail.com");
		ministry.setPhone("0972145365");
		
		Account account = new Account();
		account.setEmail(ministry.getEmail());
		account.setId(UUID.randomUUID());
		account.setPassword("123456");
		account.setMinistry(ministry);
		account.setCreateAt(new Date());
	
		accounts.put(account.getEmail(), account);
		logger.debug("createDummyAccountData success: accountList: " + accounts.toString());
	}
	
	public void createAccount(Account account) {
		String accountName = account.getEmail();
		accounts.put(accountName, account);
	}
	
	public Account getAccountInfo(String accountName) {
		return accounts.get(accountName);
	}

	public void updateLastLoginTime(Account account) {
		account.setLastLoginTime(new Date());
		accounts.put(account.getEmail(), account);
		logger.debug("updateLastLoginTime success");
	}
	
	public boolean checkAccountExist(Account account) {
		String accountName = account.getEmail();
		if (accounts.containsKey(accountName)) {
			return true;
		}
		return false;
	}
	
	public boolean checkAccountExist(String accountName) {
		if (accounts.containsKey(accountName)) {
			return true;
		}
		return false;
	}

}
