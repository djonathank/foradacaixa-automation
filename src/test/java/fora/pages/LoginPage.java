package fora.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fora.TestRule;

public class LoginPage {

	@FindBy(id = "login")
	protected WebElement login;

	@FindBy(id = "senha")
	protected WebElement senha;

	@FindBy(id = "btnLogin")
	protected WebElement btnLogin;

	// #################//

	public void efetuarLogin() {
		login.sendKeys();
		senha.sendKeys();
		btnLogin.click();
	}

	//## METODO CONSTRUTOR ##//
	
	public LoginPage() {
		PageFactory.initElements(TestRule.geDriver(), this);
	}
}
