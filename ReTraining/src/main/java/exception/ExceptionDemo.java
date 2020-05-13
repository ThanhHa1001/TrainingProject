package exception;

import java.util.List;

public class ExceptionDemo {
	public void exception() {
		int a = 1;
		int b = 0;

		System.out.println(a / b);
		System.out.println("Continue code");
	}
	
	public void nonException() {
		try {
			int a = 1;
			int b = 0;
			System.out.println(a/b);
		} catch (ArithmeticException | NullPointerException e) {
			System.out.println("Have error");
			throw new ArithmeticException();
		} finally {
			System.out.println("Continue code - finnaly");
		}
		System.out.println("Continue code");
	}
	
	public void throwsException() throws Exception {
		int a = 1;
		int b = 0;
		System.out.println(a/b);
		System.out.println("Continue code");
		throw new Exception();
	}
	
	public void demoMyException() throws MyException {
		String name = "";
		if ("".equals(name)) {
			throw new MyException("Name is empty");
		}
	}
	
	public void setData(List<String> data) {
		if (data.size() > 10) {
			throw new MyUncheckException("Size exceeds limit");
		}
	}
}
