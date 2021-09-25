package learnJava001;
import java.util.function.*;
public class Programmer extends Employee {
BiFunction<String, String, Integer> comp = 
(first, second) -> first.length() - second.length();


}
