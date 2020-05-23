package todo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class GoogleSearchPage {
    @FindBy(css = "input[name=\"q\"]")
    public WebElement txtSearchInput;

    public GoogleSearchPage(WebDriver driver)
    {
        driver.get("https://www.google.com.vn/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
