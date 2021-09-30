package learnJava001;
import java.util.function.*;
public class Programmer extends Employee {
BiFunction<String, String, Integer> comp = 
(first, second) -> first.length() - second.length();

public void makeCode() throws MyException{
	for(int i = 0; i<10;i++) {
		if (i>5)throw( new MyException());
		System.out.println("i = "+i);
	}
}

}
 class MyException extends Exception{
	
}