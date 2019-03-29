package javaPrograms;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateDifferene {

	public static void main(String[] args) throws ParseException {
		String bDate="01/14/2012 09:29:58";
		String cDate="01/15/2012 10:31:48";
		
		SimpleDateFormat date=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		Date d=new Date();
		System.out.println(date.format(d));
		
		Date d1=null;
		Date d2=null;
			
		 d1 = date.parse(bDate);
		d2=date.parse(cDate);
		
		
		/*System.out.println(d1.getTime());
		
		long diff= d2.getTime()-d1.getTime();
		
		long diffSeconds= diff/1000 %60;
		long diffMinutes=diff/ (60*1000) % 60;
		long diffHours=diff/(60*60*1000 )% 24;
		long diffdays= diff/(24*60*60*1000);
		//long diffMonths=diff/30*24*60*60*1000;
		//long diffYears=diff/12*24*60*60*1000;
		
		//System.out.println(diffYears);
		//System.out.println(diffMonths);
		
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);*/
		/*
		System.out.println(diffDays);
		System.out.println(diffHours);
		System.out.println(diffMinutes);
		System.out.println(diffSeconds);*/
		
		
		

	}

}
