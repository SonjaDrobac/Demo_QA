package StepDefinitions;

import Pages.BasePage;
import Pages.HomePage;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Constants.FrameworkConstants.getDemoQAUrl;
import static org.testng.Assert.assertEquals;


public class DemoQAHomePageStepDefinitions {
    TestContext testContext;
    HomePage homePage;
    BasePage basePage;


    public DemoQAHomePageStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        homePage = testContext.pageManager.getHomePage();
        basePage = testContext.pageManager.getBasePage();
    }

    @Given("User navigates to the demoQA website")
    public void userNavigatesToTheDemoQaWebsite() {
        basePage.navigateTo_URL(getDemoQAUrl());
    }

    @Then("User verifies that the page is open")
    public void userVerifiesThatThePageIsOpen() {
        homePage.verifiesThatPageIsOpened("");
    }

    @And("User verifies the ability to open the Elements tab")
    public void userVerifiesTheAbilityToOpenTheElementsTab() {
        homePage.clickOnCardFromHomePage("Elements");
        homePage.verifiesThatPageIsOpened("elements");
        BasePage.driver.navigate().back();
    }

    @And("User verifies the ability to open the Forms tab")
    public void userVerifiesTheAbilityToOpenTheFormsTab() {
        homePage.clickOnCardFromHomePage("Forms");
        homePage.verifiesThatPageIsOpened("forms");
        BasePage.driver.navigate().back();
    }

    @And("User verifies the ability to open the Alerts, Frame & Windows tab")
    public void userVerifiesTheAbilityToOpenTheAlertsFrameWindowsTab() {
        homePage.clickOnCardFromHomePage("Alerts, Frame & Windows");
        homePage.verifiesThatPageIsOpened("alertsWindows");
        BasePage.driver.navigate().back();
    }

    @And("User verifies the ability to open the Widgets tab")
    public void userVerifiesTheAbilityToOpenTheWidgetsTab() {
        homePage.clickOnCardFromHomePage("Widgets");
        homePage.verifiesThatPageIsOpened("widgets");
        BasePage.driver.navigate().back();
    }

    @And("User verifies the ability to open the Interactions tab")
    public void userVerifiesTheAbilityToOpenTheInteractionsTab() {
        homePage.clickOnCardFromHomePage("Interactions");
        homePage.verifiesThatPageIsOpened("interaction");
        BasePage.driver.navigate().back();
    }

    @And("User verifies the ability to open the Book Store tab")
    public void userVerifiesTheAbilityToOpenTheBookStoreTab() {
        BasePage.scrollToElement(homePage.cards.get(homePage.cards.size()-1));
        homePage.clickOnCardFromHomePage("Book Store Application");
        homePage.verifiesThatPageIsOpened("books");
        BasePage.driver.navigate().back();
    }

    @When("User clicks on the banner")
    public void userClicksOnTheBanner() {
        homePage.clickOnBanner();
    }

    @Then("User verifies that a page in a new browser tab has opened")
    public void userVerifiesThatAPageInANewBrowserTabHasOpened() {
       homePage.verifiesThatPageInNewTabIsOpened ();
    }

}
