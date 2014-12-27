import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CollectionsSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 9, 7, 10, 8);
		
		//anonymous comparator
		/*
		Collections.sort(list, new Comparator<Integer>() {
		  @Override
		  public int compare(Integer i1, Integer i2) {
		    return i1.compareTo(i2);
		  }
		});
		*/
		
		//anonymous comparator can be replaced with Lambda expression as below
		Collections.sort(list, (i1, i2) -> i1.compareTo(i2));
		
		
		for (Integer i : list){
			System.out.println(i);
		}
		
	}

}
