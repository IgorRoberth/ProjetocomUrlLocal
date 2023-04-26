package pagetestes;

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
import elementos.Elementos.DadosPessoais;
import elementos.Elementos.UserProblem;
import elementos.Elementos.User_Bloq;
import elementos.Elementos.selecionarItem;
import metodos.Metodos;

@RunWith(JUnit4.class)
public class Testes extends Driver {

    private Navegadores navegadores;

    @Before
    public void InicioTeste() {
    	
        navegadores = new Navegadores("firefox"); //Informe o navegador desejado
        driver = navegadores.configurarDriver();
        String url = ConfigUrl.getURL();
        driver.get(url);
    }

	private void ExecutarCompraEValidarProdutoEmsgFinal(String login_user, String senha_user, By button,
			String validar_produto, String nome_cliente, String sobrenome_cliente, String cep_cliente, String msg_final)
			throws IOException {

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
		System.out.println("\n=====Produto " + validar_produto + " e mensagem " + msg_final + " validado com sucesso=====");

	}

	@Test
	public void RealizarCompraValidandoMsgFinal() throws IOException {

		String login_user = "standard_user";
		String senha_user = "secret_sauce";
		By button = null;
		String validar_produto = "Sauce Labs Backpack";
		String nome_cliente = "Cláudio Emanuel";
		String sobrenome_cliente = "José da Rocha";
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
		System.out.println("\n======Mensagem de erro validado com sucesso " + msgErro + "======");

	}

	@Test
	public void ValidarTentativaDeLoginComUsuarioBloqueado() throws IOException {

		String User_Bloq = "locked_out_user";
		String senha_Bloq = "secret_sauce";
		By button = null;
		String msgErro = "Epic sadface: Sorry, this user has been locked out.";

		TentarExecutarLoginComUsuarioBloqueado(User_Bloq, senha_Bloq, button, msgErro);
	}

	private void TesteDeCompraComVerificacaoDeProdutoEntregueIncorretamente(String login_Probl, String senha_Probl,
			String sauce_Labs, String prod_retornado, By button) throws IOException {

		Metodos.escrever(driver, Elementos.Login.login, login_Probl);
		Metodos.escrever(driver, Elementos.Login.senha, senha_Probl);
		Metodos.clicar(driver, Elementos.Login.button);
		Metodos.clicar(driver, UserProblem.sauceLabs);
		Metodos.validarItem(driver, UserProblem.produtoRetornado, prod_retornado);
		System.out.println("\n====Erro, o produto selecionado era " + sauce_Labs + " e o retorno foi " + prod_retornado + "====");

	}

	@Test
	public void TesteDeCompraComVerificacaoDeProdutoEntregueIncorretamente() throws IOException {

		String login_Probl = "problem_user";
		String senha_Probl = "secret_sauce";
		By button = null;
		String sauce_Labs = "Sauce Labs Onesie";
		String prod_retornado = "Test.allTheThings() T-Shirt (Red)";

		TesteDeCompraComVerificacaoDeProdutoEntregueIncorretamente(login_Probl, senha_Probl, sauce_Labs, prod_retornado,
				button);

	}

	@After
	public void tearDown() {

		driver.quit();
	}
}