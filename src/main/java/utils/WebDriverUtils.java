package utils;

import driver.SingletonDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtils {

    private static final JavascriptExecutor js = (JavascriptExecutor) SingletonDriver.getDriver();
    private static final Actions action = new Actions(SingletonDriver.getDriver());

    private WebDriverUtils() {
    }

    public static void switchToIframe(WebElement frameId) {
        SingletonDriver.getDriver().switchTo().frame(frameId);
    }

    public static void switchToDefaultContent() {
        SingletonDriver.getDriver().switchTo().defaultContent();
    }

    public static void scrollDown() {
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void clickElementWithJavascript(WebElement webElement) {
        js.executeScript("arguments[0].click();", webElement);
    }

}
