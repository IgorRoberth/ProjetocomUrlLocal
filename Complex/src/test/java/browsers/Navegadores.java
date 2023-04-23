package browsers;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import driver.Driver;

public class Navegadores extends Driver {

	private static String navegadorEscolhido;

	public static void configurarDriver() {
		navegadorEscolhido = "chrome";

		if (navegadorEscolhido.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
		} else if (navegadorEscolhido.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		} else if (navegadorEscolhido.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(edgeOptions);
		} else {
			throw new IllegalArgumentException("Navegador inv�lido: " + navegadorEscolhido);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			configurarDriver();
		}
		return driver;
	}
}