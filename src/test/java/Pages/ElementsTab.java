package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

public class ElementsTab extends HomePage {
    public WebDriver driver;
    public ElementsTab (WebDriver driver) {
        super(driver);}

    public @FindBy(xpath = "//div[@class='main-header']")
    WebElement elementsHeader;

    public @FindBy (css= "button[id='submit']") WebElement submitButton;

    public @FindBy(css = "input[id='userName']")
    WebElement fullNameField;

    public @FindBy(css = "input[id='userEmail']")
    WebElement emailField;

    public @FindBy(css = "textarea[id='currentAddress']")
    WebElement currentAddressField;

    public @FindBy(css = "textarea[id='permanentAddress']")
    WebElement permanentAddressField;

    public @FindBy(xpath = "//p[contains(text(),'')]")
    List<WebElement> textBoxMessage;

    public @FindBy (xpath = "//p[@id='name']")
    WebElement textBoxMessageName;

    public @FindBy (xpath = "//p[@id='email']")
    WebElement textBoxMessageEmail;

    public @FindBy (xpath = "//p[@id='currentAddress']")
    WebElement textBoxMessageCurrentAddress;

    public @FindBy (xpath = "//p[@id='permanentAddress']")
    WebElement textBoxMessagePermanentAddress;
    public @FindBy(css = "button[title='Expand all']")
    WebElement expandAllButton;

    public @FindBy(css = "button[title='Collapse all']")
    WebElement collapseAllButton;

    public @FindBy(xpath = "//label")
    List<WebElement> checkBoxItems;

    public @FindBy(css = "span[class='rct-title']")
    List<WebElement> checkBox;
    public @FindBy(xpath = "span[class='text-success']")
    List<WebElement> verificationMessage;

    public @FindBy(className = "text-success")
    WebElement radioButtonVerificationMessage;

    public @FindBy(css = "svg[class='rct-icon rct-icon-check']")
    List<WebElement> tickedCheckboxes;

    public @FindBy (xpath = "//div[@id='result']")
    WebElement messageTitle;

    public @FindBy(xpath = "//label[contains(text(),'')]")
    List<WebElement> radioButtons;


    public String randomFullName;
    public void insertFullName() {
        Faker faker=new Faker();
        randomFullName=faker.name().firstName() + " " + faker.name().lastName() ;
        enterText(fullNameField,randomFullName);
        System.out.println(randomFullName);
    }

    public void insertNumberFullName(int fullName) {
        fullNameField.clear();
        fullNameField.sendKeys(String.valueOf(fullName));
    }

    public String randomEmail;
    public void generateEmail() {
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String lastName=faker.name().lastName();
        randomEmail=name+""+lastName+"@"+"mail.com";
    }

    public void insertEmail(String emailString) {
        enterText(emailField,emailString);
        System.out.println(emailString);
    }

    public String currentAddress;
    public void insertCurrentAddress(String currentAddress) {
        Faker faker=new Faker();
        currentAddress=faker.address().cityName();
        enterText(currentAddressField,currentAddress);
    }
    public void insertPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton () {
        click(submitButton);
    }

    public void verifyThatDataIsNotAdded (){
        boolean message = false;
        try {
            message = textBoxMessage.get(0).isDisplayed();
        } catch (Exception e) {
        }
        assertFalse(message);
    }

    public void verifyThatDataIsAdded () {
        boolean isMessageDisplayed = true;
        try {
            isMessageDisplayed = textBoxMessage.get(0).isDisplayed();
        } catch (Exception e) {
        }
        assertTrue(isMessageDisplayed);
    }
    //-------------------------------------------
    public void clickOnCheckBoxItemByName(String name) {
        scrollToElement(checkBox.get(16));
        for (WebElement box : checkBox) {
            if (box.getText().equals(name)) {
                box.click();
                break;
            }} }
    public void clickOnExpandAll () {
        click(expandAllButton);
    }
    public void clickOnCollapseAll () {
        click(collapseAllButton);
    }
    public void verifyNumberOfCheckBoxes (int expectedNumberOfCheckBoxes) {
       assertEquals(checkBoxItems.size(), expectedNumberOfCheckBoxes);
    }

    public static List<String> getNameOfCheckedBoxes() {
        List<String> nameOfCheckedBoxes = Arrays.asList(
                "Home", "Desktop", "Notes", "Commands", "Documents",
                "WorkSpace", "React", "Angular", "Veu", "Office",
                "Public", "Private", "Classified", "General", "Downloads",
                "Word File.doc", "Excel File.doc");
        return nameOfCheckedBoxes;
    }
    public static String randomCheckBox;
    public static void selectRandomOptionFromDropdownList(){
        Random random=new Random();
        int randomNumber = random.nextInt(getNameOfCheckedBoxes().size());
        randomCheckBox = getNameOfCheckedBoxes().get(randomNumber);
        System.out.println(randomCheckBox);
    }

    public List<String> getTickedCheckBoxesName() {
        return tickedCheckboxes.stream()
                .filter(WebElement::isSelected)
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public void verifyCheckBoxMessage () {
        List<String> checkedMessageList = new ArrayList<>();
        scrollToElement(messageTitle);
        for (int i = 1; i< verificationMessage.size(); i++) {
            checkedMessageList.add(verificationMessage.get(i).getText().toLowerCase());
            System.out.println(verificationMessage.get(i).getText().toLowerCase());
        }
        assertEquals(getTickedCheckBoxesName(),checkedMessageList);
    }

    public String clickedRadioButton;

    public void clickOnRadioButton(String radioButtonName) {
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getText().equals(radioButtonName)) {
                clickedRadioButton = radioButton.getText();
                radioButton.click();
                break;
            } } }

    public void verifyEnabledRadioButton () {
        for (int i = 0; i < radioButtons.size(); i++) {
            if (radioButtons.get(i).getText().equals("No")) {
                assertTrue(radioButtons.get(i).getAttribute("class").contains("disabled"));
            } else {
                assertFalse(radioButtons.get(i).getAttribute("class").contains("disabled"));
            }}}

    public void verifyRadioButtonMessage () {
        assertEquals(radioButtonVerificationMessage.getText(),clickedRadioButton);
    }




}
