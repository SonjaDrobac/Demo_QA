package Utils;

import org.openqa.selenium.WebDriver;

public class BaseTest {

    BaseTest() {
    }

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public  synchronized WebDriver getDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(createDriver());
        }
        return webDriverThreadLocal.get();
    }

    private synchronized WebDriver createDriver() {

        String browser = ConfigurationReader.get("browser");
        return DriverFactory.getDriver(browser);
    }

    public  void closeDriver() {
        webDriverThreadLocal.get().close();
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }
}
