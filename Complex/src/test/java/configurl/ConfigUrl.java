package configurl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUrl {

	private static Properties properties = new Properties();
	private static final String CONFIG_FILE_PATH = System.getenv("CONFIG_FILE_PATH") != null ? System.getenv("CONFIG_FILE_PATH"): "Caminho properties"; 
       //Insira o caminho da URL no arquivo propertie

	static {
		try {
			if (CONFIG_FILE_PATH == null) {
				throw new IllegalArgumentException("Variável de ambiente CONFIG_FILE_PATH não definida");
			}
			InputStream input = new FileInputStream(CONFIG_FILE_PATH);
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao carregar o arquivo de propriedades", e);
		}
	}

	public static String getURL() {
		String url = properties.getProperty("url");
		if (url == null || url.isEmpty()) {
			throw new RuntimeException("A propriedade 'url' não foi definida no arquivo de propriedades");
		}
		return url;
	}
}