package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @ignore",
        features = "src/test/resources/inserir_conta.feature",
        glue = "steps",
        plugin = {"pretty", "html:target/reports/report.html", "json:target/reports/report.json"}
)
public class RunnerTest {

    @BeforeClass
    public static void reset() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("abc@org");
        driver.findElement(By.name("senha")).sendKeys("abc123");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
