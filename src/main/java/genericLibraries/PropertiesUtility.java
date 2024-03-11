package genericLibraries;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	/**
	 * This class contains reusable methods to initialize and read data from
	 * Properties file
	 * 
	 * @author jyoth
	 *
	 */
	public class PropertiesUtility {
		private Properties property;

		/**
		 * This method is used to initialize Properties file
		 * 
		 * @param filePath
		 */
		public void propertiesInit(String filePath) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			property = new Properties();
			try {
				property.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * This method fetches data from properties file based on the key passed as an
		 * argument
		 * 
		 * @param key
		 * @return
		 */
		public String readFromProperties(String key) {
			return property.getProperty(key);
		}
	}

