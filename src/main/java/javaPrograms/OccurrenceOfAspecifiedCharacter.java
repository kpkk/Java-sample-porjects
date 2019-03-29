package javaPrograms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class OccurrenceOfAspecifiedCharacter {

	public static void main(String[] args) {
		System.out.println("enter any statement");
		Scanner s=new Scanner(System.in);
		String str = s.nextLine();
		System.out.println("enter any character of frequency to be found");
		char ch = s.next().charAt(0);
		ArrayList<Character> l=new ArrayList<Character>();
		for(int i=0;i<str.length();i++) {
			l.add(str.charAt(i));
			
		}
		Iterator<Character> itr = l.iterator();
		int count=0;
		while(itr.hasNext()) {
			if(ch==itr.next()) {
				count++;
				
			}
		}
		System.out.println("the entered character "+ch+" has repeated for "+count+" times");
		
		

	}

}
