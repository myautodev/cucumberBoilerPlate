import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",glue = "src/test/java/stepDefs",plugin = {"html:target/report"},monochrome = true)

public class TestRunner {




}
