package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRegexFindPattern {
	public static void main(String[] args) {
		// Input String for matching the regex pattern
		String inputStr = "This is an apple. These are 33 (thirty - three) apples.";

		// Regex to be matched
		// matches any word (delimited by space), 
		// where \w is a meta-character matching any word character [a-zA-Z0-9_], 
		// and + is an occurrence indicator for one or more occurrences.
//		String regexStr = "\\w+";
		
		// matches any number with a non-zero leading digit, separated by spaces from other words, 
		// where \b is the position anchor for word boundary, 
		// [1-9] is a character class for any character in the range of 1 to 9, and * is an occurrence indicator for zero or more occurrences.
//		String regexStr = "\\b[1-9][0-9]+\\b";
		String regexStr = "\\b[1-9][0-9]*\\b";

		// Step 1: Compile a regex via static method Pattern.compile,
		// default is case-sensitive
		Pattern pattern = Pattern.compile(regexStr);

		// Step 2" Allocate a matching engine from the compiled regex pattern,
		// and bind to the input string
		Matcher matcher = pattern.matcher(inputStr);

		// Step 3: Perform matching and process the matching results

		// Try Matcher.find(), which finds the next match
		while (matcher.find()) {
			System.out.println("find() found substring \"" + matcher.group() + "\" starting at index " + matcher.start()
					+ " and ending at index " + matcher.end());
		}

		// Try Matcher.matches(), which tries to match the entire input string
		if (matcher.matches()) {
			System.out.println("matches() found substring \"" + matcher.group() + "\" starting at index "
					+ matcher.start() + " and ending at index " + matcher.end());
		} else {
			System.out.println("matches() found nothing");
		}

		// Try Matcher.longkingAt(), which tries to match from the beginning of the
		// input string
		if (matcher.lookingAt()) {
			System.out.println("lookingAt() found substring \"" + matcher.group() + "\" starting at index "
					+ matcher.start() + " and ending at index " + matcher.end());
		} else {
			System.out.println("lookingAt() found nothing");
		}
	}
}
