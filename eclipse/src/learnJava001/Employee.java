package learnJava001;

public class Employee extends Person {
	public Employee() {

	}

	public Employee(int age) {
		this.age = age;
	}

	Intf intf = (num) -> num * num;

	public void doWork(int n) {

		System.out.println("The result of the lambda operation is: " + intf.operation(n));
	}

	GenericInt<String> gireverse = (str) -> {
		String res = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			res += str.charAt(i);
		}
		return res;
	};

	public void doGenericReverse() {
		System.out.println("The reverse of fire is: " + gireverse.geop("fire"));
	}

	public void emptyLam() {
		new Thread(
		()->	System.out.println("emptyLam gives: ")).start();
	}
	public void emptyLam2() {
		Intf2 ii = ()->{
			return"a"+"b";
		};
	}
	public static void repeat(int n, IntConsumer action) {
		for (int i = 0; i < n; i++) {
			action.accept(i);
			
		}
	}

}
interface IntConsumer{
	void accept(int value);
}

interface Intf2 {
	String operation();
}

@FunctionalInterface
interface Intf {
	int operation(int a);
}

interface GenericInt<T> {
	T geop(T t);
}