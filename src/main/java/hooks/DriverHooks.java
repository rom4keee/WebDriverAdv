package hooks;

import driver.SingletonDriver;
import io.cucumber.java.Before;
import org.junit.After;

public class DriverHooks {


    @After
    public void tearDown() {
        if (SingletonDriver.getDriver() != null) {
            SingletonDriver.getDriver().quit();
        }
    }

    @Before
    public static void clearCookies() {
        SingletonDriver.getDriver().manage().deleteAllCookies();
    }

}
