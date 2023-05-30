/*Write a Java program that uses stream api to perform operations on a large data set,
such as sorting or filtering the data.*/
package corejava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question6 {

	public static void main(String[] args) {
		
			List<Integer>data=Arrays.asList(4,7,3,2,9,5);
			
			//filter
			//getting the data which is odd
			Stream<Integer> oddData = data.stream().filter(num->num%2!=0);
			System.out.println("Odd Data is ::");
			oddData.forEach((num)->System.out.print(num+" "));
			
			
			System.out.println();
			//sort in ascending order
			
			List<Integer>sortedData=data.stream().sorted().collect(Collectors.toList());
			System.out.println("Sorted data is:: ");
			System.out.println(sortedData);
			
			//sorting in descending order
			List<Integer>descSortData=data.stream().sorted((a,b)->b-a).collect(Collectors.toList());
			System.out.println("Descending order sorted  data is:: ");
			System.out.println(descSortData);
			
			
	}

}
