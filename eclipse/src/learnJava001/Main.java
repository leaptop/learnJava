package learnJava001;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		learnExceptions();

	}

	public static void learnExceptions() {
		Programmer prg = new Programmer();
		try {
			prg.makeCode();
		} catch (MyException ex) {
			var out = new StringWriter();
			ex.printStackTrace(new PrintWriter(out));
			String description = out.toString();
			System.out.println("inside catch");
			System.out.println(description);
		} finally {
			System.out.println("inside finally");
			// TODO: handle finally clause
		}
		System.out.println("have come here even after an exception occured");
	}

	public static void learningInheritance() {// and lambdas
		System.out.println("hi there");
		Employee emp1 = new Employee(34);
		emp1.breathe();
		emp1.showAge();

		Office office = new Office();
		office.prog1.doWork(14);
		office.prog2.doGenericReverse();

		new Thread(() -> System.out.println("hello other thread")).start();
		office.prog1.emptyLam();

		ArrayList<Person> ap = new ArrayList();
		ap.add(new Employee());
		ap.add(new QAEngineer());
		ap.get(0).breathe();
		QAEngineer q1 = new QAEngineer();
		QAEngineer q2 = new QAEngineer();
		QAEngineer q3 = q1;
		System.out.println("q1.equals(q2): " + q1.equals(q2));
		System.out.println("q1.equals(q3): " + q1.equals(q3));

		Employee.repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
		// it's just you have to always use a functional
		// interface to call lambda. That interface is either built in, like Runnable
		// with a method run(), or created by me.
	}
}
