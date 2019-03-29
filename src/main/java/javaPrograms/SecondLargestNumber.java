package javaPrograms;

import java.util.Scanner;

public class SecondLargestNumber {

	public static void main(String[] args) {
		System.out.println("enter 3 numbers");
		Scanner s=new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		
		if((a>b)&&(a>c)) {
			if(b>c){
				System.out.println(b+" is second biggest number");
			}else {
				System.out.println(c+" is second biggest number");
			}
		}
		if((b>a)&&(b>c)) {
			if(a>c){
				System.out.println(a+" is second biggest number");
			}else {
				System.out.println(c+" is second biggest number");
			}
		}
		if((c>a)&&(c>b)) {
			if(a>b){
				System.out.println(a+" is second biggest number");
			}else {
				System.out.println(b+" is second biggest number");
			}
		}

	}

}
