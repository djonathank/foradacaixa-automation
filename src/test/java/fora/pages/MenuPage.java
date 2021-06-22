package fora.pages;

import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fora.TestRule;
import fora.Utils;

public class MenuPage {

	@FindBy(xpath = "//a[text()='Clientes']")
	protected WebElement menuClientes;

	@FindBy(css = "[href='inserircliente_identificacao.html']")
	protected WebElement submenuClientesInserir;

	public void acessarMenuInserir() throws Exception {
//		Actions actions = new Actions(TestRule.geDriver());
//		actions.moveToElement(menuClientes);
//		actions.moveToElement(submenuClientesInserir);
//		actions.click().build().perform();
		this.moverMouseSobreElemento(menuClientes);
		Utils.wait(1);		
		submenuClientesInserir.click();
	}

	public void moverMouseSobreElemento(WebElement elemento) throws Exception {
		
		// obt�m a altura da p�gina interna
		long intAlturaPagina = (Long) ((JavascriptExecutor) TestRule.geDriver()).executeScript("return document.documentElement.clientHeight");

		// obt�m a altura da janela (browser)
		int intAlturaJanela = TestRule.geDriver().manage().window().getSize().height;

		// obt�m a diferen�a de altura entre janela e p�gina
		int intDiferencaAltura = intAlturaJanela - (int) intAlturaPagina;

		// obt�m as coordenadas relativas do objeto
		int intCoordXElemento = elemento.getLocation().getX();
		int intCoordYElemento = elemento.getLocation().getY();

		// move para a posi��o esperada do objeto
		int intCoordXEsperada = intCoordXElemento;
		int intCoordYEsperada = intCoordYElemento + intDiferencaAltura;
		Robot robot = new Robot();
		robot.mouseMove(intCoordXEsperada, intCoordYEsperada);
	}

	// ## METODO CONSTRUTOR ##//

	public MenuPage() {
		PageFactory.initElements(TestRule.geDriver(), this);
	}

}
