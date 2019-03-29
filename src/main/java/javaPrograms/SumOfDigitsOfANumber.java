package javaPrograms;

import java.util.Scanner;

public class SumOfDigitsOfANumber {

	public static void main(String[] args) {
		System.out.println("enter any number");
		Scanner s=new Scanner(System.in);
		int num = s.nextInt();
		int sum=0;
		while(num>0) {
			int n=num%10;
			sum+=n;
			num/=10;
		}
System.out.println(sum);
	}

}
