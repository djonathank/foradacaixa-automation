package fora.pages.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClienteMap {

	@FindBy(id = "cpf_cnpj")
	protected WebElement cpf_cnpj;

	@FindBy(id = "fisica")
	protected WebElement fisica;

	@FindBy(id = "juridica")
	protected WebElement juridica;

	@FindBy(id = "nome_razaosocial")
	protected WebElement nome_razaosocial;

	@FindBy(id = "email")
	protected WebElement email;

	@FindBy(id = "data_nascimento")
	protected WebElement data_nascimento;

	@FindBy(id = "sexo")
	protected WebElement sexo;

	@FindBy(id = "estado_civil")
	protected WebElement estado_civil;

	@FindBy(id = "avancar")
	protected WebElement avancar;

	// Endereco Principal

	@FindBy(id = "endp_cep")
	protected WebElement endp_cep;

	@FindBy(id = "endp_endereco")
	protected WebElement endp_endereco;

	@FindBy(id = "endp_numero")
	protected WebElement endp_numero;

	@FindBy(id = "endp_complemento")
	protected WebElement endp_complemento;

	@FindBy(id = "endp_cidade")
	protected WebElement endp_cidade;

	@FindBy(id = "endp_estado")
	protected WebElement endp_estado;

	@FindBy(id = "endp_telefone")
	protected WebElement endp_telefone;

	@FindBy(id = "endp_celular")
	protected WebElement endp_celular;

	// Endereco Cobranca

	@FindBy(id = "endc_cep")
	protected WebElement endc_cep;

	@FindBy(id = "endc_endereco")
	protected WebElement endc_endereco;

	@FindBy(id = "endc_numero")
	protected WebElement endc_numero;

	@FindBy(id = "endc_complemento")
	protected WebElement endc_complemento;

	@FindBy(id = "endc_cidade")
	protected WebElement endc_cidade;

	@FindBy(id = "endc_estado")
	protected WebElement endc_estado;

	@FindBy(id = "endc_telefone")
	protected WebElement endc_telefone;

	@FindBy(id = "endc_celular")
	protected WebElement endc_celular;

	@FindBy(id = "salvar")
	protected WebElement salvar;
	
	@FindBy(id = "mensagem")
	protected WebElement mensagem;
	
}
