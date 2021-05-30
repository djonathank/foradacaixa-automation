package fora.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fora.TestRule;
import fora.Utils;
import fora.pages.maps.ClienteMap;

public class ClientePage extends ClienteMap {


	public void informarDadosIdentificacaoPF(String strNome, String strEmail, String strData_nascimento, String strSexo, String strEstado_civil) {	
		fisica.click();
		cpf_cnpj.sendKeys(Utils.gerarCPF());
		nome_razaosocial.sendKeys(strNome);
		email.sendKeys(strEmail);
		data_nascimento.sendKeys(strData_nascimento.replace("/", ""));
		
		Select cmbSexo = new Select(sexo);
		cmbSexo.selectByVisibleText(strSexo);
		
		Select cmbEstadoCivil = new Select(estado_civil);
		cmbEstadoCivil.selectByVisibleText(strEstado_civil);
	}

	public void clicarAvancar() {
		avancar.click();
	}

	public void informarEnderecos() {
		//Endereco principal
		endp_cep.sendKeys("99130529");
		endp_endereco.sendKeys("Rua da Automação");
		endp_numero.sendKeys("123");
		endp_complemento.sendKeys("Bloco A");
		endp_cidade.sendKeys("Porto Alegre");
		Select cmEstadoEndPrincipal = new Select(endp_estado);
		cmEstadoEndPrincipal.selectByVisibleText("RS");
		endp_telefone.sendKeys("51 3366-9999");
		endp_celular.sendKeys("51 3366-3594");
		
		//Endereco cobranca
		endc_cep.sendKeys("99130529");
		endc_endereco.sendKeys("Rua fora da caixa");
		endc_numero.sendKeys("111");
		endc_complemento.sendKeys("Portaria 1");
		endc_cidade.sendKeys("Curitiba");
		Select cmEstadoEndCobranca = new Select(endc_estado);
		cmEstadoEndCobranca.selectByVisibleText("RS");
		endc_telefone.sendKeys("51 33669859");
		endc_celular.sendKeys("51 996583974");
	}

	public void clicarSalvar() {
		salvar.click();
	}

	public boolean verificarMensagemSucesso() {
		Utils.wait(3);		
		String strMensagemExibida = mensagem.getText();
		if(strMensagemExibida.contains("Cliente cadastrado com sucesso")) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void informarDadosIdentificacaoPJ(String strRazaoSocial, String strEmail) {
		juridica.click();
		cpf_cnpj.sendKeys(Utils.gerarCNPJ());
		nome_razaosocial.sendKeys(strRazaoSocial);
		email.sendKeys(strEmail);
	}
	
	//## METODO CONSTRUTOR ##//
	
	public ClientePage() {
		PageFactory.initElements(TestRule.geDriver(), this);
	}


	

}
