package javaPrograms;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println("enter any number");
		Scanner s=new Scanner(System.in);
		int num = s.nextInt();
		int temp=num;
		int rev=0;
		while(num>0) {
			int n=num%10;
			rev=rev*10+n;
			num/=10;
			
		}
		if(rev==temp) {
			System.out.println("given number is palindrome number "+temp);
		}
		else {
			System.out.println("given number is not a palindrome number "+temp);
		}

	}

}
