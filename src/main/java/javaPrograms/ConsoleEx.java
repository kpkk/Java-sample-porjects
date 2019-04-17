package javaPrograms;

import java.io.Console;

public class ConsoleEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Console console = System.console();
		System.out.println("enter text");
		String readLine = console.readLine();
		
		System.out.println("hello..! "+readLine);

	}

}
