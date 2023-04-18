package abstractClasses.fragment;

import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaiter;

import java.util.List;

public abstract class AbstractFragment extends WebDriverWaiter {
    private final WebElement rootElement;

    public AbstractFragment(WebElement rootElement) {
        this.rootElement = rootElement;
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }

    protected AbstractFragment() {
        this.rootElement = null;
    }

    public WebElement findElement(By by) {
        if (rootElement != null) {
            return rootElement.findElement(by);
        }
        return null;
    }

    public List<WebElement> findElements(By by) {
        if (rootElement != null) {
            return rootElement.findElements(by);
        }
        return null;
    }

    public boolean isElementDisplayed(By by) {
        if (rootElement != null) {
            return !findElements(by).isEmpty();
        }
        return false;
    }

    public abstract boolean verifyCheckoutOrderSummary(String k);
}
