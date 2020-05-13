package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRegexFindReplace {
	public static void main(String[] args) {
		String inputStr = "This is an apple. These are 33 (Thirty-three) apples.";
		String regexStr = "apple"; // pattern to be matched
		String replacementStr = "orange"; //replacement pattern
		
		Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(inputStr);
		
		String outputStr = matcher.replaceAll(replacementStr);
		System.out.println(outputStr);
	}
}
