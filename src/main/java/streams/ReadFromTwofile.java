package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;

public class ReadFromTwofile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream input=new FileInputStream("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\DemoProject\\TestData\\notepad.txt");
		FileInputStream input1=new FileInputStream("C:\\Users\\krishnapradeep.k\\eclipse-workspace\\DemoProject\\TestData\\notepd.txt");
		
		SequenceInputStream inst=new SequenceInputStream(input,input1);
		int j;
		while((j=inst.read())!=-1) {
			System.out.println((char)j);
		}
		
		inst.close();
		

	}

}
