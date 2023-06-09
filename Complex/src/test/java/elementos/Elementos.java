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
		public static By adcCarrinho = By.cssSelector("button[class=\"btn btn_primary btn_small btn_inventory\"]");
		public static By carrinho = By.cssSelector("a[class=\"shopping_cart_link\"]");
		public static By validarItem = By.xpath("//*[text()='Sauce Labs Backpack']");
		public static By check = By.cssSelector("#checkout");
	}

	public static class DadosPessoais {
		public static By nome = By.cssSelector("#first-name");
		public static By sobrenome = By.cssSelector("#last-name");
		public static By cep = By.cssSelector("#postal-code");
		public static By Continue = By.cssSelector("#continue");
		public static By finish = By.cssSelector("#finish");
		public static By msgFinal = By.xpath("//*[text()='Thank you for your order!']");

	}

	public static class User_Bloq {
		public static By validarErro = By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']");

	}

	public static class UserProblem {
		public static By sauceLabs = By.xpath("//*[text()='Sauce Labs Onesie']");
		public static By produtoRetornado = By.xpath("//*[text()='Test.allTheThings() T-Shirt (Red)']");
	}
}