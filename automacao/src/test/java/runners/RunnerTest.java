package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@pedidocorreiospost",
        features = "src/test/java/jornadas",
        glue = "jornadas",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin ={
                "pretty",
                "html:target/cucumber-reports"
                }
)

public class RunnerTest {

    @BeforeClass
    public static void init(){
        System.out.println("RunnerTest Iniciado");
    }

}