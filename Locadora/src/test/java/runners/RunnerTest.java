package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/alugar_filme.feature",
        glue = "/steps",
        plugin = {"pretty", "html:target/reports/report.html", "json:target/reports/report.json"}
)
public class RunnerTest {



}
