package stepDefs;

import hooks.DriverHooks;
import io.cucumber.java.en.Given;

public class WebDriverStepDefs {

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        DriverHooks.clearCookies();
    }

}
