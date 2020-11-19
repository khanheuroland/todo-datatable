package todo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import todo.DriverManager;
import todo.pageobjects.GoogleSearchPage;

public class SearchDefinitions {
    WebDriver driver;
    GoogleSearchPage googlePage;
    public SearchDefinitions()
    {
        this.driver = Hooks.driver;
    }

    @Given("^The user is staying at google homepage$")
    public void the_user_is_staying_at_google_homepage() {
        this.googlePage = new GoogleSearchPage(this.driver);
    }

    @When("^The user attempt to search the keyword \"([^\"]*)\"$")
    public void the_user_attempt_to_search_the_keyword_something(String keyword) {
        this.googlePage.txtSearchInput.sendKeys(keyword);
        this.googlePage.txtSearchInput.sendKeys(Keys.ENTER);
    }

    @Then("^The result page with \"([^\"]*)\" on the title$")
    public void the_result_page_with_something_on_the_title(String keyword) {
        Assert.assertTrue(this.driver.getTitle().startsWith(keyword));
    }
}
