package javaPrograms;

import java.util.Scanner;

public class FactorialOfANumber {

	public static void main(String[] args) {
		System.out.println("enter any number");
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int fact=1;
		while(n>0) {
			fact=fact*n;
			n--;
		}
		System.out.println("the factorial of a given number is: "+fact);
	}

}
