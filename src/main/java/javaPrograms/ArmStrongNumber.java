package javaPrograms;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		System.out.println("enter the range of values");
		Scanner s=new Scanner(System.in);
		int n1 = s.nextInt();

		int arm=0;
		int temp=n1;
	while(n1>0) {
		int m=n1%10;
		arm=arm+(m*m*m);
		n1/=10;
		
	}
	if(arm==temp) {
		System.out.println("given number is an armstrong number"+ temp);
	}

	}

}
