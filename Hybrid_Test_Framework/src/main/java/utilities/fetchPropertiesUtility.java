package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class fetchPropertiesUtility {
	
	public static String fetchproperty(String key) throws IOException
	
	{
		FileInputStream file=new FileInputStream("./src/test/resources/Config/Config.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key).toString();
	}

	public static String fetchlocatorvalue(String key) throws IOException
	
	{
		FileInputStream file=new FileInputStream("./src/test/resources/Config/elements.properties");
		Properties property=new Properties();
		property.load(file);
		return property.get(key).toString();
	}
}
