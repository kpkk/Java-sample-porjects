package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeToAfile {

	public static void main(String[] args) throws IOException {
		 byte [] a={97,98,99,100,101};
		 
		 String s="hello world";
		 byte[] bytes = s.getBytes();
		
		try {
			FileOutputStream fout=new FileOutputStream("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\DemoProject\\TestData\\notepad.txt");
			/*for(int i=0;i<a.length;i++) {
				fout.write(a[i]);
			}*/
			fout.write(bytes);
			System.out.println("succesfully written");
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fis=new FileInputStream("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\DemoProject\\TestData\\notepad.txt");
		int available = fis.available();
		
		
		int i=0;
		while((i=fis.read())!=-1) {
			System.out.println((char)i);
		}
		

	}

}
