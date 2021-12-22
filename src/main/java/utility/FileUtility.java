package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Adarsh M
 *
 */
public class FileUtility {

	public static String getPropertyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(FilePath.PROPERTY_FILE_PATH);
		Properties properties=new Properties();
		properties.load(file);
		return	properties.getProperty(key);

	}
}
