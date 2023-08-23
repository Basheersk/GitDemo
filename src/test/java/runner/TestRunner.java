package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = "src/test/java/features",
        glue = {"stepdefinitions"},
        tags="",
        plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        publish = true)

public class TestRunner extends AbstractTestNGCucumberTests{

  @Override
   @DataProvider(parallel = true)
  public Object[][] scenarios() {
      return super.scenarios();
    }

	
}
