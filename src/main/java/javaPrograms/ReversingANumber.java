package javaPrograms;

import java.util.Scanner;

public class ReversingANumber {

	public static void main(String[] args) {
		System.out.println("Enter any number");
		Scanner s=new Scanner(System.in);
		
		int n = s.nextInt();
		int rev=0;
		while(n>0) {
			int num=n%10;
			rev=rev*10+num;
			n/=10;
		}
System.out.println("reverse of a given number is "+rev);
	}

}
