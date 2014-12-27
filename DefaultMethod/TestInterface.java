
public interface TestInterface {
	default String methodOne(String input){
		return "Default methodOne implementation. Input: " + input;
	}
	  
	String methodTwo(String input);
}
