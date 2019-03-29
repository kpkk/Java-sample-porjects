package javaPrograms;

import java.util.Scanner;

public class PalindromeStringCheck {

	public static void main(String[] args) {
		System.out.println("enter any string");
		Scanner s=new Scanner(System.in);
		String str = s.nextLine();
		String temp=str;
		char[] ch = str.toCharArray();
		String revStr="";

		for(int i=ch.length-1;i>=0;i--) {
			revStr+=ch[i];
		}
		System.out.println("reverse of a given string is  :"+ revStr);
		if(revStr.equals(temp)) {
			System.out.println("given string is a palindrome string");
		}else {
			System.out.println("given string is not a palindrome string");
		}
	}

}
