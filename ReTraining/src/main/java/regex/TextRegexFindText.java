package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRegexFindText {
	public static void main(String[] args) {
		// Input String for matching the regex pattern
		String inputStr = "This is an apple. These are 33 (thirty-three) apples.";
//		String inputStr = "is is an apple. ese are 33 (thirty-three) apples.";
//		String inputStr = "Th";
		// Regex to be matched
		String regexStr = "Th";
		
		// Step 1: Compile a regex via static method Pattern.compile(), 
		// default is case-sensitive
		Pattern pattern = Pattern.compile(regexStr);
//		Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE); // for case-sensitive matching
		
		// Step 2: Allocate a matching engine from the compiled regex pattern,
		// and bind to the input string
		Matcher matcher = pattern.matcher(inputStr);
		
		// Step 3: Perform matching and process the matching results
		
		// Try Matcher.find(), which finds the next match
		while(matcher.find()) {
			System.out.println("find() found substring \"" + matcher.group()
			+ "\" starting at index " + matcher.start()
			+ " and ending at index " + matcher.end());
		}
		
		// Try Matcher.matches(), which tries to match the entire input string
		if (matcher.matches()) {
			System.out.println("matches() found substring \"" + matcher.group()
			+ "\" starting at index " + matcher.start()
			+ " and ending at index " + matcher.end());
		} else {
			System.out.println("matches() found nothing");
		}
		
		// Try Matcher.longkingAt(), which tries to match from the beginning of the input string
		if (matcher.lookingAt()) {
			System.out.println("lookingAt() found substring \"" + matcher.group()
			 + "\" starting at index " + matcher.start()
			 + " and ending at index " + matcher.end());
		} else {
			System.out.println("lookingAt() found nothing");
		}
	}
}
