package configfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesfileReader {
	public static Properties properties_Reader()
	{	
		Properties pro = null;

		try
		{
		File file_pro_ref = new File("C:\\Users\\zubairhussains\\workspace\\POMproject\\src\\test\\java\\configfile\\test1.properties");
		FileInputStream fis = new FileInputStream(file_pro_ref);
		 pro = new Properties();
		pro.load(fis);
		}
		catch(FileNotFoundException fi)
		{
			fi.printStackTrace();
		}
		
		catch(IOException io)
		{
			io.printStackTrace();
		}
		return pro;
	}
	

}
