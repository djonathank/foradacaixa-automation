package fora;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Utils {

	public static String formatarNomeLog(String strLog) {
		LocalDateTime dataHoraAgora = LocalDateTime.now();
		DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_SS");
		String strLogFormatado = strLog + "_" + dataHoraAgora.format(formatoDataHora);
		return strLogFormatado;
	}

	public static void logPrint(String strLog) {
		String strLogFormatado = formatarNomeLog(strLog);
		ExtentTest extentTest = TestRule.geExtentTest();
		efetuarPrintTela(strLogFormatado);
		try {
			extentTest.log(Status.INFO, strLog,	MediaEntityBuilder.createScreenCaptureFromPath("C:\\workspace\\foradacaixa\\src\\test\\resources\\" + strLogFormatado + ".png")
							.build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void efetuarPrintTela(String strLog) {
		File scrFile = ((TakesScreenshot) TestRule.geDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:\\workspace\\foradacaixa\\src\\test\\resources\\" + strLog + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void logPass(String strMensagem) {
		ExtentTest extentTest = TestRule.geExtentTest();
		extentTest.log(Status.PASS, strMensagem);
	}

	public static void logFail(String strMensagem) {
		ExtentTest extentTest = TestRule.geExtentTest();
		extentTest.log(Status.FAIL, strMensagem);
	}

	public static String gerarCPF() {

		String iniciais = "";// contém os 9 primeiros números do cpf
		int numero;// número gerado randomicamente
		int primDig, segDig;// recebem o primeiro e o segundo digitos calculados
		int soma = 0, peso = 10; // utilizados nos calculos dos digitos
		// verificadores
		String num; // receberá o valor contido em iniciais

		// gera randomicamente os 9 primeiros números do cpf
		for (int i = 0; i < 9; i++) {

			numero = (int) (Math.random() * 10);
			if (numero > 9)// pois o número deve ser de 0 a 9
				numero = 9;
			iniciais += Integer.toString(numero);
		}

		// armazena em num o valor de iniciais
		num = iniciais;

		for (int i = 0; i < iniciais.length(); i++) {
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		}

		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = 0;
		else
			primDig = 11 - (soma % 11);

		soma = 0;
		peso = 11;

		for (int i = 0; i < num.length(); i++) {
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		}

		soma += primDig * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = 0;
		else
			segDig = 11 - (soma % 11);

		// retorna o cpf gerado
		return iniciais + primDig + segDig;
	}

	public static String gerarCNPJ() {
		String iniciais = "";// contém os 8 primeiros números do cnpj
		int numero;// número gerado randomicamente
		int primDig, segDig;// recebem o primeiro e o segundo digitos calculados
		String num; // receberá o valor contido em iniciais
		int intRestoDivisao; // recebe o resto de uma divisão

		// gera randomicamente os 8 primeiros números do cnpj
		for (int i = 0; i < 8; i++) {
			numero = (int) (Math.random() * 10);
			if (numero > 9)// pois o número deve ser de 0 a 9
				numero = 9;
			iniciais += Integer.toString(numero);
		}
		iniciais += "0001";
		// armazena em num o valor de iniciais
		num = iniciais;

		// 5 4 3 2 9 8 7 6 5 4 3 2
		// calculando o primeiro dígito:
		int soma = 0;
		soma += 5 * Integer.parseInt((num.substring(0, 1)));
		soma += 4 * Integer.parseInt((num.substring(1, 2)));
		soma += 3 * Integer.parseInt((num.substring(2, 3)));
		soma += 2 * Integer.parseInt((num.substring(3, 4)));
		soma += 9 * Integer.parseInt((num.substring(4, 5)));
		soma += 8 * Integer.parseInt((num.substring(5, 6)));
		soma += 7 * Integer.parseInt((num.substring(6, 7)));
		soma += 6 * Integer.parseInt((num.substring(7, 8)));
		soma += 5 * Integer.parseInt((num.substring(8, 9)));
		soma += 4 * Integer.parseInt((num.substring(9, 10)));
		soma += 3 * Integer.parseInt((num.substring(10, 11)));
		soma += 2 * Integer.parseInt((num.substring(11, 12)));

		intRestoDivisao = soma % 11;
		// Caso o resto da divisão seja menor que 2,
		// o nosso primeiro dígito verificador se torna 0 (zero),
		// caso contrário subtrai-se o valor obtido de 11
		if (intRestoDivisao < 2) {
			primDig = 0;
		} else {
			primDig = 11 - intRestoDivisao;
		}

		// 6 5 4 3 2 9 8 7 6 5 4 3 2
		// calculando o segundo dígito:
		soma = 0;
		soma += 6 * Integer.parseInt((num.substring(0, 1)));
		soma += 5 * Integer.parseInt((num.substring(1, 2)));
		soma += 4 * Integer.parseInt((num.substring(2, 3)));
		soma += 3 * Integer.parseInt((num.substring(3, 4)));
		soma += 2 * Integer.parseInt((num.substring(4, 5)));
		soma += 9 * Integer.parseInt((num.substring(5, 6)));
		soma += 8 * Integer.parseInt((num.substring(6, 7)));
		soma += 7 * Integer.parseInt((num.substring(7, 8)));
		soma += 6 * Integer.parseInt((num.substring(8, 9)));
		soma += 5 * Integer.parseInt((num.substring(9, 10)));
		soma += 4 * Integer.parseInt((num.substring(10, 11)));
		soma += 3 * Integer.parseInt((num.substring(11, 12)));
		soma += 2 * primDig;

		intRestoDivisao = soma % 11;
		// Caso o resto da divisão seja menor que 2,
		// o nosso primeiro dígito verificador se torna 0 (zero),
		// caso contrário subtrai-se o valor obtido de 11
		if (intRestoDivisao < 2) {
			segDig = 0;
		} else {
			segDig = 11 - intRestoDivisao;
		}

		// retorna o cnpj gerado
		return iniciais + primDig + segDig;

	}

	public static void wait(int intSegundos) {
		try {
			synchronized (TestRule.geDriver()) {
				TestRule.geDriver().wait(intSegundos * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void deleteArquivo() {
		String pastaImagens = "C:\\workspace\\foradacaixa\\src\\test\\resources\\";

		File pasta = new File(pastaImagens);
		if (pasta.isDirectory()) {
			File[] sun = pasta.listFiles();
			for (File toDelete : sun) {
				toDelete.delete();
			}
		}
	}

}
