import java.util.ArrayList;
import java.util.List;

import entity.Person;
import entity.Student;
import exception.ExceptionDemo;
import exception.MyException;

public class Main {
	public static void main(String[] args) {
		/*
		 * Conditional conditional = new Conditional();
		 * conditional.demoIfElseIfFizzBuzz(15); conditional.demoIfElseIfFizzBuzz(3);
		 * conditional.demoIfElseIfFizzBuzz(5); conditional.demoIfElseIfFizzBuzz(4);
		 * conditional.demoSwitchCase(1); conditional.demoSwitchCase(3);
		 * conditional.demoSwitchCase(4); conditional.demoSwitchCase(6);
		 * conditional.demoSwitchCase(10);
		 */

		/*
		 * Loop loop = new Loop(); loop.loop();
		 * 
		 * System.out.println("\n"); loop.doWhilePrint1To5();
		 */

		/*
		 * DataTypes dataTypes = new DataTypes(); dataTypes.showPrimitiveDataTypes();
		 * dataTypes.showNonPrimitiveDatatype(); dataTypes.demoPassBy();
		 */

		/*
		Student student1 = new Student();
		student1.getTeacherNamePublic();

		Person student2 = new Student();
		student2.goPartyPublic();
		*/
		
		ExceptionDemo exDemo = new ExceptionDemo();
//		exDemo.exception();
//		exDemo.nonException();
		try {
			exDemo.throwsException();
		} catch (Exception e) {
			System.out.println("Loi chia cho 0 nhe");
			e.printStackTrace();
		} finally {
			System.out.println("Xem lai code di nhe");
		}

		System.out.println();
		
		try {
			exDemo.demoMyException();
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		List<String> strings = new ArrayList<>();
		strings.add("1");
		exDemo.setData(strings);
		
		for (int i = 0; i < 12; i++) {
			strings.add(String.valueOf(i));
		}
		exDemo.setData(strings);
		
		
	}
}
