package desktop.pages;

import static utils.WebDriverUtils.clickElementWithJavascript;
import abstractClasses.page.AbstractPage;
import driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    public static final String BASE_URL = "https://www.bookdepository.com/";

    @FindBy(xpath = "//input[@class='text-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='header-search-btn']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openWebSite() {
        SingletonDriver.getDriver().get(BASE_URL);
    }

    public void searchRequest(String request) {
        searchInput.clear();
        searchInput.sendKeys(request);
        clickElementWithJavascript(searchButton);
    }

}
