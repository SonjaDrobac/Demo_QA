package StepDefinitions;

import Pages.ElementsTab;
import Pages.HomePage;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Constants.FrameworkConstants.getPermanentAddress;

public class ElementsTabStepDefinitions {
    TestContext testContext;
    ElementsTab elementsTab;
    HomePage homePage;

    public ElementsTabStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        elementsTab = testContext.pageManager.getElementsTab();
        homePage= testContext.pageManager.getHomePage();
    }

    @When("User clicks on the Elements tab")
    public void userClicksOnTheElementsTab() {
        homePage.clickOnCardFromHomePage("Elements");
    }

    @When("User clicks on the TextBox list element")
    public void userClicksOnTheTextBoxListElement() {
        homePage.clickOnSideBarLisElement("Text Box");
    }

    @Then("User verifies that a TextBox page is opened")
    public void userVerifiesThatATextBoxPageIsOpened() {
        homePage.verifiesThatPageIsOpened("text-box");
    }

    @And("User enters the name")
    public void userEntersTheName() {
        elementsTab.insertFullName();
    }

    @And("User enters the email")
    public void userEntersTheEmail() {
        elementsTab.generateEmail();
        elementsTab.insertEmail(elementsTab.randomEmail);
    }

    @And("User enters the current address")
    public void userEntersTheCurrentAddress() {
        elementsTab.insertCurrentAddress(elementsTab.currentAddress);
    }

    @And("User enters the permanent address")
    public void userEntersThePermanentAddress() {
        elementsTab.insertPermanentAddress(getPermanentAddress());
    }

    @When("User clicks the submit button")
    public void userClicksTheSubmitButton() {
        elementsTab.clickOnSubmitButton();
    }

    @Then("User verifies that the message is displayed in correct form")
    public void userVerifiesThatTheMessageIsDisplayedInCorrectForm() {
        elementsTab.verifyThatDataIsAdded();
    }

    @Then("User verifies that the message is not displayed")
    public void userVerifiesThatTheMessageIsNotDisplayed() {
        elementsTab.verifyThatDataIsNotAdded();
    }

    @When("User clicks on the CheckBox list element")
    public void userClicksOnTheCheckBoxListElement() {
        homePage.clickOnSideBarLisElement("Check Box");
    }

    @Then("User verifies that a CheckBox page is opened")
    public void userVerifiesThatACheckBoxPageIsOpened() {
        homePage.verifiesThatPageIsOpened("checkbox");
        elementsTab.verifyNumberOfCheckBoxes(1);
    }

    @When("User click on expand all button")
    public void userClickOnExpandAllButton() {
        elementsTab.clickOnExpandAll();
    }

    @Then("User verifies that all check boxes are opened")
    public void userVerifiesThatAllCheckBoxesAreOpened() {
        elementsTab.verifyNumberOfCheckBoxes(17);
    }

    @When("User selects one check boxes")
    public void userSelectsOneCheckBoxes() {
        ElementsTab.selectRandomOptionFromDropdownList();
        elementsTab.clickOnCheckBoxItemByName(ElementsTab.randomCheckBox);
    }

    @Then("User verifies message")
    public void userVerifiesMessage() {
        elementsTab.getTickedCheckBoxesName();
        elementsTab.verifyCheckBoxMessage();
    }

    @When("User click on home check box")
    public void userClickOnHomeCheckBox() {
        elementsTab.clickOnCheckBoxItemByName("Home");
    }

    @When("User deselects the checkbox")
    public void userDeselectsTheCheckbox() {
        ElementsTab.selectRandomOptionFromDropdownList();
        elementsTab.clickOnCheckBoxItemByName(ElementsTab.randomCheckBox);
        ElementsTab.selectRandomOptionFromDropdownList();
        elementsTab.clickOnCheckBoxItemByName(ElementsTab.randomCheckBox);
    }

    @When("User click on collapse all button")
    public void userClickOnCollapseAllButton() {
        elementsTab.clickOnCollapseAll();
    }

    @Then("User verifies that all check boxes are closed")
    public void userVerifiesThatAllCheckBoxesAreClosed() {
        elementsTab.verifyNumberOfCheckBoxes(1);
    }

    @When("User clicks on the Radio buttons list element")
    public void userClicksOnTheRadioButtonsListElement() {
        homePage.clickOnSideBarLisElement("Radio Button");
    }

    @Then("User verifies that a Radio buttons page is opened")
    public void userVerifiesThatARadioButtonsPageIsOpened() {
        homePage.verifiesThatPageIsOpened("radio-button");
    }

    @And("User verifies that expected elements are disabled")
    public void userVerifiesThatExpectedElementsAreDisabled() {
        elementsTab.verifyEnabledRadioButton();
    }

    @When("User click on YES radio buttons")
    public void userClickOnYEsRadioButtons() {
        elementsTab.clickOnRadioButton("Yes");
    }

    @When("User click on IMPRESSIVE radio buttons")
    public void userClickOnImpressiveRadioButtons() {
        elementsTab.clickOnRadioButton("Impressive");
    }

    @Then("User verifies message on radio button page")
    public void userVerifiesMessageOnRadioButtonPage() {
        elementsTab.verifyRadioButtonMessage();
    }
}
