package stepDefs;

import desktop.pages.SearchPage;
import driver.SingletonDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static desktop.pages.SearchPage.TITLE;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchPageStepDefs {

    SearchPage searchPage = new SearchPage(SingletonDriver.getDriver());

    @When("I apply the following search filters")
    public void applySearchFilter(DataTable table) {
        searchPage.getSearchFilterFragment().selectOption(table);
        searchPage.getSearchFilterFragment().clickSubmitButton();
    }

    @When("^I click 'Add to basket' button for product with name '([\\w ]+)'$")
    public void clickAddToBasketButton(String expectedProductName) {
        searchPage.getBookItemFragment().clickAddToBasketButton(expectedProductName);
    }

    @Then("I am redirected to a Search page")
    public void verifyUserIsRedirectedToSearchPage() {
        assertThat(searchPage.getPageTitle())
                .withFailMessage("Search page is not found")
                .isEqualTo(TITLE);
    }

    @Then("Search results contain the following products")
    public void verifySearchResultsContainsProducts(List<String> expectedProductList) {
        assertThat(searchPage.getSearchResultsFragment().getBookItemsTitles())
                .withFailMessage("Search results do not contain the following products")
                .containsAll(expectedProductList);
    }

    @Then("Search results contain only the following products")
    public void verifySearchResultEqualsProduct(List<String> expectedProductList) {
        assertThat(searchPage.getSearchResultsFragment().getBookItemsTitles())
                .withFailMessage("Search results do not contain only the following products ")
                .isEqualTo(expectedProductList);
    }

}
