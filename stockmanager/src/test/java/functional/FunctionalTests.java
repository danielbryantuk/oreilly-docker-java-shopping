package functional;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        features = "classpath:features/",
        plugin = "html:build/reports/cucumber",
        glue = "functional",
        strict = true)
public class FunctionalTests {

}
