package todo;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report"},
        glue = "todo.stepdefinitions",
        features = "src/test/resources/todo/"
)
public class RunCucumberTest {
}
