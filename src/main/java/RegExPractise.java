
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPractise {
	
	Scanner s=new Scanner(System.in);
	
	public void iStringMatches(String str) {
		System.out.println(str.matches("\\d"));
	}
	
	public void patternMatches(String text) {
		System.out.println(Pattern.compile("\\d{2}$").matcher(text).find());
		
	}
	
	public void patterMatchCaseInsensitive(String text) {
		
		System.out.println(Pattern.compile("java",Pattern.CASE_INSENSITIVE).matcher(text).find());
		
	}
	
	public void ipMatch(String ip) {
		System.out.println("given Ip address is "+Pattern.compile("^(\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3})$").matcher(ip).find()+" one ");
	}
	
	public void replaceWithPatterns(String input,String replaceWith) {
		
		System.out.println(Pattern.compile("\\s+").matcher(input).replaceAll(replaceWith));
	}
	
	public void emailMatch(String email) {
		System.out.println("given email address is a "+Pattern.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z-0-9-]+)*@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$").matcher(email).matches()+" one.");
		
		
	}

	public void passwordmatch(String pwd) {
		System.out.println(Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})").matcher(pwd).matches());
		
	//	((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})
	}
	
	public void dateFormat(String date) {
		System.out.println(Pattern.compile("[\\d]{2}-[\\d]{2}-[\\d]{2,4}").matcher(date).matches());
	}
	
	public void fileExtension(String filename) {
		System.out.println(Pattern.compile("[\\S]+\\.(?i)(txt|doc|pdf|tiff|jpeg)$").matcher(filename).matches());
	}
	
	public void datafetchWithaSpecificPattern(String text) {
		Pattern compile = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		Matcher matcher = compile.matcher(text);
		
		ArrayList<String> data=new ArrayList<String>();
		while(matcher.find()) {
			data.add(matcher.group());
			int count = matcher.groupCount();
			System.out.println(count+" ips were found");
		}
		
		System.out.println(data);
		
		
	}
	public static void main(String[] args) {
		
		RegExPractise reg=new RegExPractise();
		reg.iStringMatches("1abc23");
		
		reg.patternMatches("is your age 23");
		
		reg.patterMatchCaseInsensitive("this is java, in smaller case");
		reg.patterMatchCaseInsensitive("this is JAVA, in upper case");
		reg.patterMatchCaseInsensitive("this is python, in smaller case");
		
		reg.ipMatch("13.61.15.231");
		
		reg.replaceWithPatterns("My name is Khan", "\\$");
		
		reg.emailMatch("kadarla.pradeep4@gmail.com");
		
		reg.passwordmatch("jdgdfg2v");
		
		reg.dateFormat("08-04-2018");
		
		reg.fileExtension("image.jpeg");
		
		reg.datafetchWithaSpecificPattern("Hi my machine IP is 10.20.30.40 and i would like to access port 80 from the host 23.12.56.34, which internally connects to 3.90.23.65. Please process the request");
	}

}
