
public class SeperationOfChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="abc123$%^";
		String alp="";
		String num="";
		String spl="";
		
		char[] ch=s.toCharArray();
		
		/*for(int i=0;i<ch.length;i++) {
			if(Character.isDigit(ch[i])) {
				num+=ch[i];
				
			}
			else if(Character.isAlphabetic(ch[i])) {
				alp+=ch[i];
				
			}
			else {
				spl+=ch[i];
				
			}
		}
		System.out.println(num);
		System.out.println(alp);
		System.out.println(spl);*/
		
		String[] split = s.split("[^0-9]");
		for(int i=0; i<split.length;i++) {
			System.out.println(split[i]);
		}
		
		String[] alp2 = s.split("[^a-z A-Z]");
		for(int i=0; i<alp2.length;i++) {
			System.out.println(alp2[i]);
		}
		String[] special = s.split("[0-9a-zA-Z]");
		for(int i=0; i<special.length;i++) {
			System.out.println(special[i]);
		}

	}

}
