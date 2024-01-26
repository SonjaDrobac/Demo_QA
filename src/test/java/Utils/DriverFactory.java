package Utils;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {
    private DriverFactory() {
    }

    private static final Supplier<WebDriver> chromeSupplier = ChromeDriver::new;
    private static final Supplier<WebDriver> chromeHeadlessSupplier =
            () -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--start-maximized");
                return new ChromeDriver(options);
            };

    private static final Supplier<WebDriver> fireFoxSupplier = FirefoxDriver::new;
    private static final Supplier<WebDriver> fireFoxHeadlessSupplier = () -> {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setProfile(profile);
        options.addArguments("-headless");
        return new FirefoxDriver(options);
    };
    private static final Supplier<WebDriver> edgeDriverSupplier = () -> {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
        return new EdgeDriver(options);
    };
    private static final Supplier<WebDriver> edgeDriverHeadlessSupplier = () -> {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
        options.addArguments("--headless=new");
        return new EdgeDriver(options);
    };
    private static final Supplier<WebDriver> safariDriverSupplier = SafariDriver::new;

    private static final Map<String, Supplier<WebDriver>> DRIVER_MAP = new HashMap<>();

    static {
        DRIVER_MAP.put("chrome", chromeSupplier);
        DRIVER_MAP.put("chrome-headless", chromeHeadlessSupplier);
        DRIVER_MAP.put("firefox", fireFoxSupplier);
        DRIVER_MAP.put("firefox-headless", fireFoxHeadlessSupplier);
        DRIVER_MAP.put("edge", edgeDriverSupplier);
        DRIVER_MAP.put("edge-headless", edgeDriverHeadlessSupplier);
        DRIVER_MAP.put("safari", safariDriverSupplier);
    }

    public static WebDriver getDriver(String browser) {
        return DRIVER_MAP.get(browser).get();
    }

}
