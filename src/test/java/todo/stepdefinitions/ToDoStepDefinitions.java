package todo.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import todo.DriverManager;
import todo.pageobjects.TodoPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ToDoStepDefinitions {
    WebDriver driver;
    TodoPage todoPage;
    DataTable lstKeyword;
    public ToDoStepDefinitions()
    {
        this.driver = DriverManager.getDriver();
        this.todoPage = new TodoPage(this.driver);
    }

    @Given("^The Todo page is open$")
    public void the_todo_page_is_open() throws Throwable {
        this.driver.get("http://todomvc.com/examples/react-backbone/");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.todoPage.InitElement();
    }

    @When("^The user refresh the page$")
    public void the_user_refresh_the_page() {
        this.driver.navigate().refresh();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.todoPage.InitElement();
    }

    @Then("^The list with inserted items is displayed$")
    public void the_list_with_inserted_items_is_displayed() {
        List<Map<String, String>> lst = this.lstKeyword.asMaps(String.class, String.class);
        ArrayList<String> lstKeyword = new ArrayList<String>();
        for(Map<String, String> s: lst)
        {
            lstKeyword.add(s.get("item"));
        }

        ArrayList<String> lstDisplayedResult = new ArrayList<String>();
        List<WebElement> lstEl = todoPage.lstItems;
        for(WebElement el: lstEl)
        {
            lstDisplayedResult.add(el.getText().trim());
        }

        Assert.assertEquals(lstKeyword, lstDisplayedResult);
    }

    @And("^The data as below list already inserted$")
    public void the_data_as_below_list_already_inserted(DataTable data) {
        this.lstKeyword = data;
        todoPage.InitElement();
        WebElement txtInput = todoPage.txtInput;
        List<Map<String, String>> lst = data.asMaps(String.class, String.class);
        for (Map<String, String> s: lst) {
            txtInput.clear();
            txtInput.sendKeys(s.get("item"));
            txtInput.sendKeys(Keys.ENTER);
        }
    }

}
