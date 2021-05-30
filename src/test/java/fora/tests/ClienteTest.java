package fora.tests;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/resources/Cliente.feature", glue = { "" }, 
		monochrome = true, dryRun  = false)
public class ClienteTest {

}
