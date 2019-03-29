package javaPrograms;

import java.util.Scanner;

public class DaysOfAmonth {

	public static void main(String[] args) {
		System.out.println("enter the year");
		Scanner s=new Scanner(System.in);
		int year = s.nextInt();
		System.out.println("enter month number");
		int month = s.nextInt();
		int nd=0;
		if(month==2) {
			if((year%4==0||year%100!=0)&&(year%400==0)) {
				nd=29;
			}else {
				nd=28;
			}
		}
		else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			nd=31;
		}
		else {
			nd=30;
		}
		System.out.println("no of days in a given month is :" +nd);
	}

}
