package todo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import todo.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void Before()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-2");
        driver = new ChromeDriver();
    }

    @After
    public void After(Scenario scenario)
    {
        //WebDriver driver = DriverManager.getDriver();
        if(scenario.isFailed())
        {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed (screenshot, "image/png");
        }
        //DriverManager.closeWebDriver();
        driver.quit();
    }
}
