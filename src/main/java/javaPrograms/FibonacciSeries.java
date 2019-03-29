package javaPrograms;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Enter the range of the series");
		Scanner s=new Scanner(System.in);
		
		int endRange = s.nextInt();
		
		int n1=0, n2=1, temp=0;
		System.out.print(n1+" "+n2+" ");
		for(int i=1;i<=endRange;i++) {
			int j=n1+n2;
			n1=n2;
			n2=j;
			
			System.out.print(j+" ");		
			
		}
s.close();
	}

}
