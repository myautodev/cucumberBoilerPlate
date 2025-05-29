import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",                     // path to feature files
        glue = "stepDefs",                                   // package of step definitions
        plugin = {
                "com.aventstack.chaintest.plugins.ChainTestCucumberListener:", // ChainTest plugin
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber.json"
        },
        monochrome = true
)

public class TestRunner {




}
