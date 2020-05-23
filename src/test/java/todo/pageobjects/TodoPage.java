package todo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TodoPage {
    WebDriver driver;
    @FindBy(css = "input.new-todo")
    public WebElement txtInput;

    @FindAll(
            @FindBy(css="ul.todo-list label")
    )
    public List<WebElement> lstItems;

    public TodoPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void InitElement()
    {
        PageFactory.initElements(this.driver, this);
    }
}
