package statements;

public class Conditional {
	public void demoIfElseFindMax(int a, int b) {
		if (a > b) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}
	
	public void demoIfElseIfFizzBuzz(int a) {
		if (a % 3 == 0 && a % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (a % 3 == 0) {
			System.out.println("Fizz");
		} else if (a % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(a);
		}
	}
	
	public void demoSwitchCase(int a) {
		switch (a) {
		case 1:
			System.out.println("Một");
			break;
		case 2:
			System.out.println("Hai");
			break;
		case 3:
			System.out.println("Ba");
			System.out.println("Bạn vừa nhập số 3 phải không? Liuliu, tặng thêm số 4 nhé");
		case 4:
			System.out.println("Bốn");
			break;
		case 5:
		case 6:
		case 7:
			System.out.println("Đây là số 5 hoặc 6 hoặc 7");
			break;
		default:
			System.out.println("Đây là số # 1,2, 3, 4, 5, 6, 7");
			break;
		}
	}
}
