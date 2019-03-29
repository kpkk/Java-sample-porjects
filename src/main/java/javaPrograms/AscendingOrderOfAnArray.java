package javaPrograms;

import java.util.Scanner;

public class AscendingOrderOfAnArray {

	public static void main(String[] args) {
		System.out.println("enter the size of an array");
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("read elements of an array");
		int []a=new int[n];
		for(int i=0;i<n;i++) {
			int num = s.nextInt();
			a[i]=num;
		}
		System.out.println("array elements before sorting in ascending order");
		for(int i=0;i<n;i++) {
			System.out.println(a[i]);
		}
		
		for(int i=0;i<n;i++) {
			int temp=0;
			for(int j=i+1;j<n;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		System.out.println("array elements after sorting in ascending order");
		
		for(int i=0;i<n;i++) {
			System.out.println(a[i]);
		}

	}

}
