public class DefaultMethodImplementation implements TestInterface {

	@Override
	public String methodTwo(String input) {
		return "methodTwo implementation. Input: " + input;
	}
	

	/*
	//methodOne (which has default implementation in TestInterface can still be overridden if need be as below
	@Override
	public String methodOne(String s) {
		return "methodOne is overriden!";
	}
	*/
	
	
}