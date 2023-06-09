import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/java/features",
        glue = "end_to_end"
)
public class TestRunner {

}