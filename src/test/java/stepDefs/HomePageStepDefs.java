package stepDefs;

import desktop.pages.HomePage;
import driver.SingletonDriver;
import io.cucumber.java.en.When;

public class HomePageStepDefs {

    HomePage homePage = new HomePage(SingletonDriver.getDriver());

    @When("I open the Initial home page")
    public void openWebSite() {
        homePage.openWebSite();
    }

    @When("^I search for ([^\"]*)$")
    public void searchRequest(String request) {
        homePage.searchRequest(request);
    }

}
