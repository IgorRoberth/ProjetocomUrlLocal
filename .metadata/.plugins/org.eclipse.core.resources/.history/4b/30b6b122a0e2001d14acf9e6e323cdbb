package configurl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUrl {

	private static Properties propriedades = new Properties();
	static {
		try {
			InputStream entrada = new FileInputStream("C:\\Users\\igorr\\AutomaticComplex\\config.properties");
			propriedades.load(entrada);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getURL() {
		return propriedades.getProperty("url");
	}
}