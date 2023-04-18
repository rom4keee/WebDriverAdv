package abstractClasses.page;

import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverWaiter;

import java.util.List;

public abstract class AbstractPage extends WebDriverWaiter {
    private String pageUrl;
    private String pageUrlPattern;

    public AbstractPage(String pageUrl, String pageUrlPattern) {
        this.pageUrl = pageUrl;
        this.pageUrlPattern = pageUrlPattern;
    }

    protected AbstractPage() {
    }

    public AbstractPage(WebDriver driver) {
    }

    public boolean checkUrl() {
        String currentUrl = SingletonDriver.getDriver().getCurrentUrl();
        if (currentUrl.equals(pageUrl)) {
            return true;
        } else if (pageUrlPattern != null) {
            return currentUrl.matches(pageUrlPattern);
        } else {
            return false;
        }
    }

    public WebElement findElement(By by) {
        return SingletonDriver.getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return SingletonDriver.getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }
}
