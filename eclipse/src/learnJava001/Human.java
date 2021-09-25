package learnJava001;

public interface Human {

	public default void breathe() {
		System.out.println("inhaling sound... exhaling sound");
	}
}
