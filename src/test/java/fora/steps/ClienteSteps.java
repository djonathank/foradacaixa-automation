package fora.steps;

import org.junit.Assert;

import fora.Utils;
import fora.pages.ClientePage;
import fora.pages.MenuPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class ClienteSteps {

	@Dado ("efetuei login no sistema")
	public void efetuarLogin() {
		
	}
	
	@E ("acessei o menu Clientes >> Inserir")
	public void acessarMenuClienteInserior () throws Exception {
		MenuPage menusPage = new MenuPage();
		menusPage.acessarMenuInserir();	
	}
	
	@Quando("na tela Dados de Identificacao informo os dados de Pessoa Fisica: {string},{string},{string},{string} e {string}")
	public void informarDadosIdentificacaoPF(String strNome, String strEmail, String strData_nascimento, String strSexo, String strEstado_civil) {
		ClientePage clientePage = new ClientePage();
		clientePage.informarDadosIdentificacaoPF(strNome, strEmail, strData_nascimento, strSexo, strEstado_civil);
		Utils.logPrint("Dados de Identificacao PF");
	}
	
	@Quando("na tela Dados de Identificacao informo os dados de Pessoa Juridica: {string},{string}")
	public void informarDadosIdentificacaoPF(String strRazaoSocial, String strEmail) {
		ClientePage clientePage = new ClientePage();
		clientePage.informarDadosIdentificacaoPJ(strRazaoSocial, strEmail);
		Utils.logPrint("Dados de Identificacao PJ");
	}
	
	
	@E ("na tela Dados de Identificacao clico em Avancar")
	public void clicarAvancar() {
		ClientePage clientePage = new ClientePage();
		clientePage.clicarAvancar();
	}
	
	@E ("na tela Enderecos informo os enderecos")
	public void informarEndereco() {
		ClientePage clientePage = new ClientePage();
		clientePage.informarEnderecos();
		Utils.logPrint("Enderecos");
	}
	
	@E ("na tela Enderecos clico em Salvar")
	public void clicarSalvar() {
		ClientePage clientePage = new ClientePage();
		clientePage.clicarSalvar();
		Utils.logPrint("Cliente Cadastrado");

	}
	
	@Entao ("na tela Enderecos sera exibida mensagem de sucesso")
	public void verificarMensagemSucesso() {
		ClientePage clientePage = new ClientePage();
//		clientePage.verificarMensagemSucesso();
		
		boolean btnExibiuMensageSucesso = clientePage.verificarMensagemSucesso();
	
		if(btnExibiuMensageSucesso) {
			Utils.logPass("Cliente Cadastrado com sucesso");
		} else {
			Utils.logFail("Erro ao Cadastrrar o cliente");
		}
		
		Assert.assertTrue("Não exibiu a mensagem de sucesso", btnExibiuMensageSucesso);

	}
	
	@Entao("validar alerta na tela Enderecos")
	public void validarMensagem() {

	}
}
