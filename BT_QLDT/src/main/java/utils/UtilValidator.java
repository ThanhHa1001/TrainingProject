package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidator {
	private static final String EMAIL_REGEX =  "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	private static final String PHONE_REGEX = "^\\d{4}([- .]?\\d{3}){2}$";
	private static final String NAME_REGEX = "^[a-zA-Z ]*[a-zA-Z]+$";
	
	public static boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean validatePhone(String phoneNumber) {
		Pattern pattern = Pattern.compile(PHONE_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}
	
	public static boolean validateName(String name) {
		Pattern pattern = Pattern.compile(NAME_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
}
