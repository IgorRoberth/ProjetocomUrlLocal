package elementos;

import org.openqa.selenium.By;

public class Elementos {

	public static class Login {
		public static By login = By.cssSelector("#user-name");
		public static By senha = By.cssSelector("#password");
		public static By button = By.cssSelector("#login-button");
	}

	public static class selecionarItem {
		public static By Item = By.cssSelector("#item_4_title_link");
		public static By adcCarrinho = By.cssSelector("#add-to-cart-sauce-labs-backpack");
		public static By carrinho = By.cssSelector("#shopping_cart_container");
		public static By validarItem = By.cssSelector("#item_4_title_link");
		public static By check = By.cssSelector("#checkout");
	}

	public static class DadosPessoais {
		public static By nome = By.cssSelector("#first-name");
		public static By sobrenome = By.cssSelector("#last-name");
		public static By cep = By.cssSelector("#postal-code");
		public static By Continue = By.cssSelector("#continue");
		public static By finish = By.cssSelector("#finish");
		public static By msgFinal = By.cssSelector("#checkout_complete_container > h2");
	}

	public static class UserBloq {
		public static By validarErro = By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']");

	}

	public static class UserProblem {
		public static By sauceLabs = By.xpath("//*[text()='Sauce Labs Onesie']");
		public static By produtoRetornado = By.xpath("//*[text()='Test.allTheThings() T-Shirt (Red)']");
	}
}