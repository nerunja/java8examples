
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
//import java.util.stream.Collectors;

public class PredicateTest{

	public static void main(String... args){
	
		//Predicate<paramType> already returns a boolean type. 
		//But a Function<paramType, returnType> can return any given returnType
		
		//simple predicate
		Predicate<Integer> greaterThanTen = (i) -> i > 10;
		System.out.println(greaterThanTen.test(14));	// Will print true
		
		//----------------------
		//predicate chaining	
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
		System.out.println(greaterThanTen.and(lowerThanTwenty).test(15));			//Will print true
		System.out.println(greaterThanTen.and(lowerThanTwenty).negate().test(15));	//Will print false
		
		//----------------------
		//Passing predicates into functions 
		process(10, (i) -> i > 7);	//Will print "Number 10 was accepted!"
		
		//Filtering list elements with a predicate 
		List<User> users = new ArrayList<>();
		users.add(new User("John", "admin"));
		users.add(new User("Peter", "member"));
		List<User> admins = process2(users, (u) -> u.getRole().equals("admin"));
		System.out.println(admins.get(0).user);	//Will print John
		
		//----------------------
		//Simple Function
		Function<String, Integer> stringLength = (s) -> s.length();
		System.out.println(stringLength.apply("Hello world"));		// Will print 11
		
		//----------------------
		//Function chaining 
		Function<Integer, Boolean> greaterThanFive = (i) -> i > 5;
		//apply is first run on function stringLength andThen on function greaterThanFive -- chaining
		System.out.println(stringLength.andThen(greaterThanFive).apply("Hello world"));		// Will print true

		//----------------------
		//Another function chaining example 
		Function<Integer, Boolean> lowerThanTen = (i) -> i < 10;
		Function<String, Boolean> function = stringLength.andThen(lowerThanTen);
		System.out.println(function.apply("elloworld"));// Will print false
		
		
	}//main
	
	//Passing predicates into functions 
	static void process(int number, Predicate<Integer> predicate) {
		if (predicate.test(number)) {
			System.out.println("Number " + number + " was accepted!");
		}
	}//process

	//Filtering list elements with a predicate 
	static List<User> process2(List<User> users, Predicate<User> predicate) {
		List<User> result = new ArrayList<>();
		for (User user : users) {
			if (predicate.test(user)) {
				result.add(user);
			}
		}
		return result;
	}
		
}//class

