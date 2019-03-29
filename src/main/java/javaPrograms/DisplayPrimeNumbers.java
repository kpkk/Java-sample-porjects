package javaPrograms;

import java.util.Scanner;

public class DisplayPrimeNumbers {

	public static void main(String[] args) {
		System.out.println("enter the range, to find the prime numbers in between");
		Scanner s=new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		for(int i=n1;i<=n2;i++) {
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
				
				}
			if(count==2) {
				System.out.print(i+" ");
				
			}
		}

	}

}
