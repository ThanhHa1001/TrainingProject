package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRegexBackReference {
	public static void main(String[] args) {
		String inputStr = "One:two:three:four";
		// pattern to be matched
		String regexStr = "(.+):(.+):(.+):(.+)";
		// replacement pattern with back reference
		String replacementStr = "$4-$3-$2-$1";

		Pattern pattern = Pattern.compile(regexStr);

		Matcher matcher = pattern.matcher(inputStr);

		System.out.println(matcher.groupCount());

		while (matcher.find()) {
			for (int i = 0; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + " : " + matcher.group(i));
			}
			System.out.println("----------");
		}
		String outputStr = matcher.replaceAll(replacementStr);
		System.out.println(outputStr);

	}
}
