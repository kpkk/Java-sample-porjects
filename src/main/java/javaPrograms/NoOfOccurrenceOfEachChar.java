package javaPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class NoOfOccurrenceOfEachChar {

	public static void main(String[] args) {
		System.out.println("enter any senetence");
		Scanner s=new Scanner(System.in);
		ArrayList<Character> list=new ArrayList<Character>();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		String str = s.nextLine();
		for(int i=0;i<str.length();i++) {
			list.add(str.charAt(i));
		}
		System.out.println(list);
		Iterator<Character> iterator = list.iterator();
		while(iterator.hasNext()) {
			Character next = iterator.next();
			
			if(!map.containsKey(next)) {
				map.put(next, 1);
			}else {
				map.put(next, map.get(next)+1);
			}
		}
		System.out.println(map);
		
		//solution-2
		
		char[] ch = str.toCharArray();
		
		
		
		for(Character eachChar: ch) {
			if(!map.containsKey(eachChar)) {
				map.put(eachChar, 1);
			}else {
				map.put(eachChar, map.get(eachChar)+1);
			}
		}
		System.out.println(map);
		
		

	}

}
