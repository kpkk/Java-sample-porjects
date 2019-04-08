import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExPractisematchingApatternAtIndex {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		while(true) {
			System.out.println("enter the pattern");
			Pattern compile = Pattern.compile(s.nextLine());
			System.out.println("enter the string that you want to match the pattern");
			Matcher matcher = compile.matcher(s.nextLine());
			boolean found=false;
			while(matcher.find()) {
				System.out.println("the text" +compile+" was found at "+matcher.start()+" index and ends at "+matcher.end()+" index");
				found=true;
			}
			if(!found) {
				System.out.println("no match found");
			}
			
		

	}
	}
}

