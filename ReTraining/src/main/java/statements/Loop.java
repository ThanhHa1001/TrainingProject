package statements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loop {
	public void loop() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] b = { 1, 2, 3, 4 };
		List numberList = new ArrayList();

		System.out.println("========== Normal for-loop ============");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
			numberList.add(a[i]);
		}

		System.out.println("\n========== Normal for-each ============");
		for (int i : a) {
			System.out.print(i + "  ");
		}

		System.out.println("\n========== Use lamda ==================");
		numberList.forEach(i -> {
			System.out.print(i + "  ");
		});
		
		System.out.println("\n========== Use lamda (Primitive type) ==================");
		Arrays.stream(b).forEach(i -> {
			System.out.print(i + "  ");
		});
		
		System.out.println("\n========== Use Method references (Java 8) ==================");
		numberList.forEach(System.out::print);
	}
	
	public void doWhilePrint1To5() {
		int j = 1;
		while(j <= 5) {
			System.out.print(j + "  ");
			j++;
		}
		
		int i = 6;
		System.out.println("\ndo while - chay truoc roi tinh sau");
		do {
			System.out.print(i + "  ");
			i++;
		} while(i <= 5);
	}
}
