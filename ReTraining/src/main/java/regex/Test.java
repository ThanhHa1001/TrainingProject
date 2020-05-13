package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String str = null;
		String regex = null;
		Pattern pattern = null;
		Matcher matcher = null;
		
		// the most basic example		
		str = "The bat took a bite out of the big boring apple.";
		regex = "th";
		// ==> result: th

		// the dot - any character
		str = "The big bag of bits was bugged";
		regex = "b.g";
		// ==> result: big bag
		
		str = "You can live like a king but make sure it isn't a lie";
		regex = "l..e";
		// ==> result: live like
		
		//ranges of characters
		str = "When today is over Ted will have a tedious time tidying up";
		regex = "t[eo]d";
		// ==> result: tod  ted
		
		// Shortcut for characters in a row
		str = "Room Allocations: G4 G9 F2 H1 L0 K7 M9";
		regex = "[1-8]";
		// ==> 4     2     1     7  
		
		// đây có nghĩa là: khớp với các số từ 1 đến 4 và số 9
		regex = "[1-49]";
		// ==> 4     9     2     1     9  
		
		str = "y, w, a, r, f, 4, 9, 6, 3, p, x, t";
		// đây có nghĩa là: khớp với các số từ 1 đến 5 và từ a đến f và x
		regex = "[1-5a-fx]";
		// ==> a     f     4     3     x 
		
		// Negating - Find characters that aren't
		str = "When today is over Ted will have a tedious time tidying up";
		regex = "t[^eo]d";
		// ==> tid
		
		
		// Multipliers
		// Multipliers allow us to increase the number of times an item may occur in our regular expression. 
		// Here is the basic set of multipliers:
		//	* - item occurs zero or more times.
		//	+ - item occurs one or more times.
		//	? - item occurs zero or one times.
		//	{5} - item occurs five times.
		//	{3,7} - item occurs between 3 and 7 times.
		//	{2,} - item occurs at least 2 times.
		str = "Are you looking at the lock or the silk?";
		regex = "lo*";
		// ==> loo  lo  l
		
		regex = "l.*k";
		// ==> looking at the lock or the silk
		
		regex = "l.*?k";
		// ==> look     lock     lk
		
		
		// Escaping metacharacters
		str = "Surely this regular expression should match this.";
		regex = "this.";
		// ==> this    this.
		
		// mặc định ký tự . là khớp với bất kỳ ký tự nào
		// để loại bỏ điều đó, t thêm backslash ( \ ) vào phía trước metacharacter đó
		regex = "this\\.";
		// ==> this
		
		str = "My appetite is huge";
		regex = "p.t";
		
		
		// Anchor - ^ and $
		str = "This line does not match but the next line does \n bat";
		regex = "^b[aiu]t$";
		
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(str);
		System.out.println("String: " + str);
		System.out.println("regex: " + regex);
		System.out.print("matcher.find(): ");
		while(matcher.find()) {
			System.out.print(matcher.group() + "     ");
		}
	}
}
