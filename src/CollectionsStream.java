import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsStream {
	public static void main(String... args){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
		
		//-------------------------------------
		List<Integer> even = list.stream().
				filter( i -> i % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(even); //[2, 4, 6, 8, 10]
		
		//-------------------------------------
		//Terminal operations - 
		//count
		System.out.println(String.format("Odd count is %d", 
				list.stream().
				filter( i -> i % 2 != 0)
				.count())); //6
		
		//-------------------------------------
		//min, max
		List<String> numberstrings = Arrays.asList("one", "to", "three", "onethousand");
		String shortest = numberstrings.stream()
			        .min(Comparator.comparing(item -> item.length()))
			        .get(); //to
		System.out.println(String.format("Shortest in list is '%s'", shortest));
		
		//-------------------------------------
		 //The BinaryOperator.apply() method is the method implemented by the 
		//lambda expression below. This method takes two parameters. 
		String reduce = numberstrings.stream()
		        .reduce((acc, item) -> acc + " " + item)
		        .get();//here reduce() returns Optional class instance and hence .get() method required here.
		System.out.println(String.format("accumulated strings is '%s'", reduce));//accumulated strings is 'one to three'
		
		//--------------------------------------
		//There is another reduce() method which takes two parameters. 
		//It takes an initial value for the accumulated value, and then a BinaryOperator. Here is an example:

		String reduced = numberstrings.stream()
										.reduce("_", (acc, item) -> acc + " " + item);
		System.out.println(String.format("accumulated strings with initial accumulated val \"\" as 1st param is '%s'", reduced));//accumulated strings is 'one to three'
		
		//-------------------------------------
		//This example takes an empty string as initial value, and then the 
		//same lambda expression as the previous example. 
		//This version of the reduce() method returns the accumulated value directly, and not an Optional. 
		//If the stream contains no elements, the initial value will be returned.
		//The reduce() method can be combined with the filter() method too. Here is an example:

		String reduced2 = numberstrings.stream()
			     .filter( item -> item.startsWith("o"))
			     .reduce("-", (acc, item) -> acc + " " + item);
		System.out.println(String.format("accumulated strings with initial accumulated val \"\" as 1st param and filter by starting with o is '%s'", reduced2));//accumulated strings is 'one to three'

		
		/*
		 	[2, 4, 6, 8, 10]
			Odd count is 6
			Shortest in list is 'to'
			accumulated strings is 'one to three onethousand'
			accumulated strings with initial accumulated val "" as 1st param is '_ one to three onethousand'
			accumulated strings with initial accumulated val "" as 1st param and filter by starting with o is '- one onethousand'
		 * */
		
		Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
		System.out.println("Stream created using 'Stream.of(1,2,3,4,5,6,7,8,9);'");
        stream.forEach(p -> System.out.print(p + " "));
        System.out.println();
        
        //converting from stream to array after filtering (for even) items
        Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4,5,6,7,8,9});
        Integer[] evenNumbersArr = stream2.filter(i -> i%2 == 0).toArray(Integer[]::new);
        List<Integer> evenNumbers = Arrays.asList(evenNumbersArr );
        System.out.println("Even number are:");
        evenNumbers.forEach(item -> System.out.print(item + " "));

        
	}
}
