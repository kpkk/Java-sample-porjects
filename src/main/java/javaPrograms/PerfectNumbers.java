package javaPrograms;

import java.util.Scanner;

public class PerfectNumbers {

	public static void main(String[] args) {
		System.out.println("enter the range");
		Scanner s=new Scanner(System.in);
		int n1 = s.nextInt();
		int n2 = s.nextInt();
		for(int i=n1;i<=n2;i++) {
			int sum=0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					sum+=j;
				}
				
			}
			if(sum==i) {
				System.out.println(i);
			}
		}

	}

}
