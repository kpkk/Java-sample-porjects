package javaPrograms;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPractise {

	public static void main(String[] args) {
		
		
		List<Integer>num=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		System.out.println("even numbers from the given array are:");
		num.stream().filter(x->x%2==0).collect(Collectors.toList()).forEach(y->System.out.println(y));
		
		System.out.println("cubes of given number are");
		
		num.stream().map(x->x*x*x).collect(Collectors.toList()).forEach(x->System.out.println(x));
		
		List<String>dupList=Arrays.asList("pr","kk","rf","pr","ab","kk","ph");
		
		//get the list that starts with p
		dupList.stream().filter(s->s.startsWith("p")).collect(Collectors.toList()).forEach(y->System.out.println(y));
		
		System.out.println("after removed the duplicates");
		dupList.stream().distinct().forEach(y->System.out.println(y));
		
		Integer integer = num.stream().findAny().get();
		System.out.println(integer);
		
		//to calculate the sum
		int reduce = num.stream().mapToInt(x->x).reduce(0,(y,i)->y+i);
		System.out.println(reduce);
		
		IntSummaryStatistics stats = num.stream().mapToInt(x->x).summaryStatistics();
		
		stats.accept(30);
		System.out.println("The average of the given lis of number is: "+stats.getAverage());
		System.out.println("count of the numbers in list is: "+stats.getCount());
		System.out.println(stats.getMin());
		System.out.println(stats.getMax());
		
		
			
		
		
		
		

	}

}
