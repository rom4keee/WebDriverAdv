package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class SingletonDriver {

    private static final String CHROME_DRIVER = "chrome";
    private static final String FIREFOX_DRIVER = "firefox";
    private static final String EDGE_DRIVER = "edge";
    private static final String IE_DRIVER = "ie";

    private static WebDriver driver;

    private SingletonDriver() {
    }

    public static synchronized WebDriver getDriver() {
        if (driver == null) {
            String driverName = System.getProperty("driver", CHROME_DRIVER);
            switch (driverName.toLowerCase()) {
                case FIREFOX_DRIVER:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case IE_DRIVER:
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case EDGE_DRIVER:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case CHROME_DRIVER:
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(getChromeOptions());
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(
                    Long.getLong("implicitlyWaitTimeout", 10), TimeUnit.SECONDS);
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--test-type");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return chromeOptions;
    }
}
