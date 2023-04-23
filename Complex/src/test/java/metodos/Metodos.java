package metodos;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.Driver;

public class Metodos extends Driver{

	@SuppressWarnings("unused")
	private static void inicializarDriver(WebDriver driver) {
        Metodos.driver = driver;
	}
	
	public static void screenShot(WebDriver drive, String nome) throws IOException {

		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("./Evidencias/" + nome + ".png");
		FileUtils.copyFile(srcFile, desFile);

	}

	public static void clicar(WebDriver drive, By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.err.println("-------erro ao clicar---------" + e.getMessage());
			System.err.println("-------causa do erro---------" + e.getCause());
		}
	}

	public static void escrever(WebDriver drive, By elemento, String texto) {

		driver.findElement(elemento).sendKeys(texto);

	}

	@SuppressWarnings("deprecation")
	public static void validarItem(WebDriver drive, By elemento, String textoEsperado) {

		WebDriverWait wait = new WebDriverWait(driver, 120);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elemento));
		String textoCapturado = element.getText();
		assertTrue(textoCapturado.contains(textoEsperado));

	}
}