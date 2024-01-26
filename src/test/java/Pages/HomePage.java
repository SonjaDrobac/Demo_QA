package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Constants.FrameworkConstants.getDemoQAUrl;
import static Constants.FrameworkConstants.getToolsQaUrl;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class HomePage extends BasePage {

    public WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public @FindBy (xpath = "//div[@class='card-body']")
    List<WebElement> cards;

    public @FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
    WebElement headerButton;

    public @FindBy (className = "banner-image")
    WebElement banner;

    public @FindBy(xpath = "//li[contains(text(),'')]")
    List<WebElement> sideBarLisElements;

    //----------------------------------

    public void clickOnCardFromHomePage(String cardName) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardName)) {
                cards.get(i).click();
                break;
            } } }

    public void clickOnHeaderButton () {
        click(headerButton);
    }

    public void clickOnBanner () {
       click(banner);
    }

    public void verifiesThatPageIsOpened (String endpoint) {
        assertEquals(getCurrentURL(), getDemoQAUrl()+endpoint);
        assertTrue(headerButton.isDisplayed());
    }

    public void verifiesThatPageInNewTabIsOpened () {
        switchToNextTab();
        assertEquals(getCurrentURL(), getToolsQaUrl());
    }

    public void clickOnSideBarLisElement(String name) {
        for (int i = 0; i < sideBarLisElements.size(); i++) {
            if (sideBarLisElements.get(i).getText().equals(name)) {
               sideBarLisElements.get(i).click();
                break;
            }
        }
    }


}
