package fora;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestRule {

	private static WebDriver driver;
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;

	@Before
	public void beforeCenario(Scenario cenario) {
		Utils.deleteArquivo();
		if (extentReport == null) {
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("src/test/resources/htmlReporter.html");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(cenario.getId());
		
		System.setProperty("webdriver.chrome.driver", "..\\foradacaixa\\Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("-user-data-dir=C:\\Users\\dkaiper\\AppData\\Local\\Google\\Chrome\\User Data");
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("file:///C:/Versao_2/inicio.html");
	}
	
	@After
	public void afterCenario(Scenario cenario) {
		if(cenario.isFailed()) {
			extentTest.log(Status.FAIL, "Cenario: " + cenario.getName() + " EXECUTADO COM FALHAS!");
			extentReport.flush();
		} else {
			extentTest.log(Status.PASS, "Cenario: " + cenario.getName() + " EXECUTADO COM SUCESSO!");
			extentReport.flush();
		}
		
		if(driver != null) {
			driver.close();
		}
	}

	public static WebDriver geDriver() {
		return driver;
	}
	
	public static ExtentTest geExtentTest() {
		return extentTest;
	}

}
