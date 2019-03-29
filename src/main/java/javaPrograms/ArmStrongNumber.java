package javaPrograms;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		System.out.println("enter the range of values");
		Scanner s=new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		int arm=0;
		int temp=0;
		for(int i=n1;i<=n2;i++) {
			temp=i;
			int m=i%10;
			arm=arm+(m*m*m);
			i=i/10;
		
			if(temp==arm) {
				System.out.println(i);
			}
	}
		
		

	}

}
