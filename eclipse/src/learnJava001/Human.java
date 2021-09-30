package learnJava001;

public interface Human {

	public default void breathe() {//methods with bodies in the interface don't have to be implemented in 
		System.out.println("inhaling sound... exhaling sound");//implementing classes. Also they have to 
	}//be signed with the "default" keyword
	public void method000();//hasToBeDefinedInTheFirstImplemetingClass
	//Every class, that implements 
	//this interface has to define methods of the interface, that don't have a body
}
