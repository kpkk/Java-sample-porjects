package javaPrograms;

import java.util.Scanner;

public class FindMonthNameNnDaysByNumber {

	public static void main(String[] args) {
		System.out.println("enter any month number");
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("enter year number");
		int n1 = s.nextInt();
	    switch(n) {
	    case 1: System.out.println("given month is january and the number of days are 31");
	    break;
	    case 2: if((n1%4==0&& n1%100!=0)&&(n1%400==0)) {
	    	System.out.println("given month is February and the number of days are 29");
	    	break;
	    }else {
	    	System.out.println("given month is February and the number of days are 28");
	    	break;
	    }
	    case 3: System.out.println("given month is March and the number of days are 31");
	    break;
	    case 4: System.out.println("given month is April and the number of days are 30");
	    break;
	    case 5: System.out.println("given month is may and the number of days are 31");
	    break;
	    case 6: System.out.println("given month is June and the number of days are 30");
	    break;
	    case 7: System.out.println("given month is July and the number of days are 31");
	    break;
	    case 8: System.out.println("given month is August and the number of days are 31");
	    break;
	    case 9: System.out.println("given month is September and the number of days are 30");
	    break;
	    case 10: System.out.println("given month is October and the number of days are 31");
	    break;
	    case 11: System.out.println("given month is November and the number of days are 30");
	    break;
	    case 12: System.out.println("given month is december and the number of days are 31");
	    break;
	    default: System.out.println("invalid number enetered");
	    }

	}

}
