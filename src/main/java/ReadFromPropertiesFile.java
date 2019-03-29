import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		
		FileInputStream fs=new FileInputStream("./src/main/java/prop.properties");
		
		p.load(fs);
		
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));
		
		fs.close();
		
		

	}

}
