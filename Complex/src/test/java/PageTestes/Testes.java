package PageTestes;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import browsers.Navegadores;
import configurl.ConfigUrl;
import driver.Driver;
import elementos.Elementos;
import elementos.Elementos.User_Bloq;
import metodos.Metodos;

@RunWith(JUnit4.class)
public class Testes extends Driver {

	private static Navegadores navegadores;

	@SuppressWarnings("static-access")
	@Before
	public void InicioTeste() {

		navegadores = new Navegadores();
		navegadores.configurarDriver();
		driver = Navegadores.getDriver();
		String url = ConfigUrl.getURL();
		driver.get(url);

	}

	private void ExecutarCompraEValidarProdutoEmsgFinal(String login_user, String senha_user, By button,
			String validar_produto, String nome_cliente, String sobrenome_cliente, String cep_cliente, String msg_final)
			throws IOException {

	}
	@Test
	public void RealizarCompraValidandoMsgFinal() throws IOException {

		String login_user = "standard_user";
		String senha_user = "secret_sauce";
		By button = null;
		String validar_produto = "Sauce Labs Backpack";
		String nome_cliente = "Cl�udio Emanuel";
		String sobrenome_cliente = "Jos� da Rocha";
		String cep_cliente = "78559706";
		String msg_final = "Thank you for your order!";

		ExecutarCompraEValidarProdutoEmsgFinal(login_user, senha_user, button, validar_produto, nome_cliente,
				sobrenome_cliente, cep_cliente, msg_final);

	}

	private void TentarExecutarLoginComUsuarioBloqueado(String UserBloq, String senha_Bloq, By button, String msgErro) {

		Metodos.escrever(driver, Elementos.Login.login, UserBloq);
		Metodos.escrever(driver, Elementos.Login.senha, senha_Bloq);
		Metodos.clicar(driver, Elementos.Login.button);
		Metodos.validarItem(driver, User_Bloq.validarErro, msgErro);
		System.out.println("\n======Mensagem de erro validado com sucesso "+ msgErro + "======");

	}

	@Test
	public void ValidarTentativaDeLoginComUsuarioBloqueado() throws IOException {

		String User_Bloq = "locked_out_user";
		String senha_Bloq = "secret_sauce";
		By button = null;
		String msgErro = "Epic sadface: Sorry, this user has been locked out.";

		TentarExecutarLoginComUsuarioBloqueado(User_Bloq, senha_Bloq, button, msgErro);
	}

	@After
	public void tearDown() {

		driver.quit();
	}
}