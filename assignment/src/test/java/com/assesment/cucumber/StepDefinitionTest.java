package com.assesment.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitionTest {

    private static final String URL = "https://link.springer.com";
    private WebDriver driver = HooksTest.driver;
    private String searchQueryBox = "query";
    private String numberOfSearchResults = "h1.number-of-search-results-and-search-terms";
    private String expectedSearchResultMessage = "0 Result(s) for";

    @Given("^I am on the homepage$")
    public void i_am_on_the_homepage() {
        driver.get(URL);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(searchQueryBox)));
    }

    @When("^I search with text \"([^\"]*)\"$")
    public void i_search_with_text(String text) {
        String searchButton = "search";
        driver.findElement(By.id(searchQueryBox)).sendKeys(text);
        driver.findElement(By.id(searchButton)).click();
    }

    @Then("^search should provide a correct search count message$")
    public void search_should_provide_a_correct_search_count_message() {
        final String actualSearchResultMessage = driver.findElement(By.cssSelector(numberOfSearchResults)).getText();

        assertThat("Search result does not have 0 count message", !actualSearchResultMessage.contains(expectedSearchResultMessage));
    }

    @Then("^search should provide a null search count message$")
    public void search_should_provide_a_null_search_count_message() {
        final String actualSearchResultMessage = driver.findElement(By.cssSelector(numberOfSearchResults)).getText();

        assertThat("Search result does not contain 0 count message", actualSearchResultMessage.contains(expectedSearchResultMessage));
    }


}


