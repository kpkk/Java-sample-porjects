package javaPrograms;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		System.out.println("enter the range of values");
		Scanner s=new Scanner(System.in);
		int n1 = s.nextInt();
		int n2= s.nextInt();
		for(int i=n1;i<=n2;i++) {
			int arm=0;
			int temp=i;
		while(i>0) {
			int m=i%10;
			arm=arm+(m*m*m);
			i=i/10;	
		}
		
		if(arm==temp) 
			System.out.println(temp);	
		
	}
	

	}

}
