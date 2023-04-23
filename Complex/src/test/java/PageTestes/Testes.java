package PageTestes;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import browsers.Navegadores;
import configurl.ConfigUrl;
import driver.Driver;
import elementos.Elementos;
import elementos.Elementos.DadosPessoais;
import elementos.Elementos.selecionarItem;
import metodos.Metodos;

@RunWith(JUnit4.class)
public class Testes extends Driver{

	private static Navegadores navegadores;

	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUp() {

		navegadores = new Navegadores();
		navegadores.configurarDriver();
		driver = Navegadores.getDriver();
		String url = ConfigUrl.getURL();
		driver.get(url);

	}

	@Test
	public void RealizarCompraValidandoMsgFinal() throws IOException {
		
	    final String
		login_user = "standard_user";
		final String
		senha_user = "secret_sauce";
		final String
		validar_produto = "Sauce Labs Backpack";
		final String
		nome_cliente = "Cl�udio Emanuel";
		final String
		sobrenome_cliente = "Jos� da Rocha";
		final String
		cep_cliente = "78559706";
		final String
		msg_final = "Thank you for your order!";  
		
		Metodos.escrever(driver, Elementos.Login.login, login_user);
		Metodos.escrever(driver, Elementos.Login.senha, senha_user);
		Metodos.clicar(driver, Elementos.Login.button);
		Metodos.clicar(driver, selecionarItem.validarItem);
		Metodos.clicar(driver, selecionarItem.adcCarrinho);
		Metodos.clicar(driver, selecionarItem.carrinho);
		Metodos.validarItem(driver, selecionarItem.validarItem, validar_produto);
		Metodos.clicar(driver, selecionarItem.check);
		Metodos.escrever(driver, DadosPessoais.nome, nome_cliente);
		Metodos.escrever(driver, DadosPessoais.sobrenome, sobrenome_cliente);
		Metodos.escrever(driver, DadosPessoais.cep, cep_cliente);
		Metodos.clicar(driver, DadosPessoais.Continue);
		Metodos.clicar(driver, DadosPessoais.finish);
		Metodos.validarItem(driver, DadosPessoais.msgFinal, msg_final);
	//	Metodos.screenShot(driver, "Funcional");
		System.out.println("\n=====Produto "+ validar_produto +" e mensagem " + msg_final + " validado com sucesso=====");
	
	}

	@Test
	public void ValidarTentativaDeLoginComUsuarioBloqueado() throws IOException {

		

	}

	@AfterClass
	public static void tearDown() {
		
		 driver.quit();
	}
}