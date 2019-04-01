package javaPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		
		List<Integer> asList = Arrays.asList(2,3,4,5,3,4);
		
		//it prints the values those are divisible by 2
	 asList.stream().filter(x->x%2==0).collect(Collectors.toSet()).forEach(y->System.out.println(y+" is divisble by 2"));
	 
	 IntSummaryStatistics summaryStatistics = asList.stream().mapToInt((x)->x).summaryStatistics();
	 System.out.println(summaryStatistics.getAverage());
	 System.out.println(summaryStatistics.getMax());
	 System.out.println(summaryStatistics.getCount());
	 System.out.println(summaryStatistics.getMin());
	 
	 Integer reduce = asList.stream().filter(s->s%2==1).reduce(0,(y,i)->y+i);
	 System.out.println("This string is reduced to one number, "+reduce);
	 
	 System.out.println("after removed the duplicates");
	 //to remove duplicates
	 asList.stream().distinct().forEach(y->System.out.println(y));
	 
	 System.out.println();
	 asList.stream().map(x->x*x).collect(Collectors.toList()).forEach(y->System.out.println("Squares of given number is: "+y));
	 ArrayList<String> ll=new ArrayList<String>();
	 ll.add("wozniacki");
	 ll.add("pradeep");
	 ll.add("shapalov");
	 ll.add("djockovic");
	 ll.add("roger federer");
	 
	 // this will print the sorted list 
	 System.out.println("after putting the elements in sorting order");
	 ll.stream().sorted().collect(Collectors.toList()).forEach(y->System.out.println(y));;
	 
	 //finding results based on certain criteria
	 List<String> filter = ll.stream().filter(s->s.startsWith("d")).collect(Collectors.toList());
	 System.out.println(filter);
	 
	 Random r=new Random();
	 r.ints().limit(10).forEach(System.out::println);
	 
	List<Integer> l2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	l2.stream().filter(i->isEven(i)).map(j->doubleit(j)).collect(Collectors.toList()).forEach(x->System.out.println(x));
	
	List<String> names=Arrays.asList("pradeep","","vjv","","gvfje");
	
	//to join output as a string
	String collect = names.stream().filter(s->!s.isEmpty()).collect(Collectors.joining(","));
	System.out.println(collect);
	
	

	}
	public static boolean isEven(int num) {
		return num%2==0;
	}
	public static int doubleit(int num) {
		return num*2;
	}
	

}
