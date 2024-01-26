package Pages;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class PageManager {

    private final WebDriver driver;

    private BasePage basePage;
    private HomePage homePage;

    private ElementsTab elementsTab;
    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getBasePage() {
        return (Objects.isNull(basePage)) ? basePage = new BasePage(driver) : basePage;
    }

    public HomePage getHomePage() {
        return (Objects.isNull(homePage)) ? homePage = new HomePage(driver) : homePage;
    }

    public ElementsTab getElementsTab() {return (Objects.isNull(elementsTab)) ? elementsTab = new ElementsTab(driver) : elementsTab;
    }
}
