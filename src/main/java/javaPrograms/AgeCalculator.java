package javaPrograms;

import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		System.out.println("enter the birth date, month and year ");
		Scanner s=new Scanner(System.in);
		int byear = s.nextInt();
		int bmonth = s.nextInt();
		int bdate = s.nextInt();
		System.out.println("enter the current date, month and year ");
		int cyear = s.nextInt();
		int cmonth = s.nextInt();
		int cdate = s.nextInt();
		
		//this is newly added line
		
			int d=0,m=0,y=0;
			
				d=cdate-bdate;
				
				
				if(d<0) {
					d=d+30;
					m=m-1;
				}
				m=bmonth-cmonth;
				if(m<0) {
					m=m+12;
					y=y-1;
				}
				y=cyear-byear;
				
			
			System.out.println("age is "+ y+" years "+ m+" months "+d+" days");
			
		
		
		
		

	}

}
