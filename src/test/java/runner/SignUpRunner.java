package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue="stepdefinition",features="src/test/java/feature/signup.feature", monochrome=true)
public class SignUpRunner {

}
