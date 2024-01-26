package Pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasePage {

    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static SoftAssert softAssert;



    public BasePage(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver= driver;
        softAssert=new SoftAssert();
        PageFactory.initElements(driver,this);
    }

    public static String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    /**
     * This method enables to wait desired seconds
     * @param seconds
     */
    public static void waitFor(int seconds){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(seconds));
    }

    /**
     * This method enables to wait visibility of the element
     * @param element
     */
    public static void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This method enables to wait clickable of the element
     * @param element
     */
    public static void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * This method enables to wait for element to be selectable
     * @param element
     */
    public void waitForElementToBeSelectable(WebElement element){
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    /**
     * This method enables to wait for page to be loaded
     * @param seconds
     */
    public static void waitForPageToLoad(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    /**
     * This method enables to navigate desired URL
     * @param url
     */
    public void navigateTo_URL(String url){
        driver.get(url);
    }

    /**
     * This method enables to click the element
     * @param element
     */
    public static void click(WebElement element){
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This method enables to enter text into inputBox
     * @param element
     * @param keyword
     */
    public static void enterText(WebElement element, String keyword){
        wait.until(driver -> ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(keyword);
    }

    /**
     * This method enables to get text of the element
     * @param element
     * @return
     */
    public static String getText(WebElement element){
        wait.until(driver ->ExpectedConditions.visibilityOf(element) );
        return element.getText();
    }

    /**
     * This method enables to get text of the elements and put them into list
     * @param lists
     * @return
     */
    public List<String> getListText(List<WebElement> lists){
        wait.until(driver -> ExpectedConditions.visibilityOf(lists.get(0)));
        return lists.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * This method enables to scroll to the element
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * This method enables to make double click
     * @param element
     */
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    /**
     * This method enables to refresh the page
     */
    public static void reFresh(){
        driver.navigate().refresh();
    }

    /**
     * This method enables to remove obscuring element to click
     * @param obscuringElement
     */
    public static void removeObscuringElement(WebElement obscuringElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].parentNode.removeChild(arguments[0])", obscuringElement);
    }

    /**
     * This method enables to hover over the element
     * @param element
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Opens a new tab and switches to new tab
     */
    public static void openANewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    /**
     * Wait for the new window or tab
     * @param tabNumber
     */
    public static void waitUntilNewTabOpens(int tabNumber){
        wait.until(numberOfWindowsToBe(tabNumber));
    }

    /**
     * Wait for the new tab to finish loading content
     * @param title
     */
    public static void waitUntilTitleIs(String title){
        wait.until(titleIs(title));
    }

    /**
     * This method enables to switch to next tab
     */
    public static void switchToNextTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.stream()
                .skip(1) // Skip the first tab
                .findFirst() // Find the next tab
                .ifPresent(tab -> driver.switchTo().window(tab));
    }

    /**
     * This method enables to switch to back - MainTab
     */
    public static void switchToMainTab() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        tabs.stream()
                .findFirst() // Find the first tab (main tab)
                .ifPresent(tab -> driver.switchTo().window(tab));
    }

    /**
     * This method enables to click an element by JavaScriptExecutor
     * @param element
     */
    public static void clickElementByJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void clear(WebElement element){
        waitForVisibility(element);
        element.clear();
    }

}
