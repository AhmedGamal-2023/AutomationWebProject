package end_to_end;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import settings.WinjigoSettings;

import static settings.DriverFactory.getDriver;

public class Hooks {
    private final WebDriver driver = getDriver(WinjigoSettings.browserType);

    @Before
    public void setUp() {
        driver.get(WinjigoSettings.homeUrl);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
