package org.example.pages;

import io.qameta.allure.Step;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class WebFormPage extends BasePage {

    public WebDriver driver;
    private Logger log = LogManager.getLogger(WebFormPage.class);
    private By ch03menuBy = By.xpath(".//*[@href='web-form.html']");

    private By textInput = By.id("my-text-id");
    private By passwordInput = By.name("my-password");
    private By textAreaInput = By.name("my-textarea");
    private By disabledInput = By.name("my-disabled");
    private By readOnlyInput = By.name("my-readonly");
    private By selectBy = By.name("my-select");

    private By fileUpload = By.name("my-file");
    private By colorPicker = By.name("my-colors");
    private By datePicker = By.name("my-date");
    private By sliderBy = By.name("my-range");

    private String checkBoxPattern = ".//*[ @id='my-check-%s']";
    private String radioButtonPattern = ".//*[ @id='my-radio-%s']";

    public WebFormPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
       /* WebElement element = getWebElement(ch03menuBy);
        element.click();*/
        clickOnElement(ch03menuBy);
        //waitForElementNotVisible(element);
    }

    @Step
    public WebFormPage typeTextInput(String value) {
        log.info("Type text input");
        typeTextToElement(textInput, value);
        return this;
    }

    @Step
    public WebFormPage typePasswordInput(String value) {
        log.info("Type password input");
        typeTextToElement(passwordInput, value);
        return this;
    }

    @Step
    public WebFormPage typeTextAreaInput(String value) {
        typeTextToElement(textAreaInput, value);
        return this;
    }
    @Step
    public WebFormPage selectItemInDropDown(String value, SelectStrategy strategy) {
        WebElement selectElement = driver.findElement(selectBy);
        Select select = new Select(selectElement);

        switch (strategy) {
            case BY_INDEX:
                select.selectByIndex(Integer.valueOf(value));
                break;
            case BY_VALUE:
                select.selectByValue(value);
            case BY_VISIBLE_TEXT:
                select.selectByVisibleText(value);
        }
        return this;
    }

    @Step
    public WebFormPage selectItemInDataListByIndex(int index) {

        var input = driver.findElement(By.xpath("//input[@list='my-options']"));
        var option = driver.findElement(By.xpath("//*[@id='my-options']/option[" + index + "]"));
        var value = option.getAttribute("value");
        input.clear();
        input.sendKeys(value);
        return this;
    }

    public WebFormPage selectItemInDataListByValue(int index) {
        //TODO
        return this;
    }

    public WebFormPage typeFilePath(String path) {

        // if sendKeys type into fileUpload it can throw exception if file is not correct
        try {
            driver.findElement(fileUpload).sendKeys(path);
        } catch (Exception exception) {
            System.out.println("OOps looks like " + exception.getMessage());
        }

        return this;
    }

    @Step
    public WebFormPage chooseCheckBox(int id) {
        driver.findElement(By.xpath(String.format(checkBoxPattern, id))).click();
        return this;
    }

    @Step
    public WebFormPage chooseRadioButton(int id) {
        driver.findElement(By.xpath(String.format(radioButtonPattern, id))).click();
        return this;
    }

    @Step
    public WebFormPage selectColorInPicker(String hexValue) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementsByName('my-colors')[0].value='" + hexValue + "'");

        //TODO how to handle pop up picker
        return this;
    }

    @Step
    public WebFormPage selectCurrentDateInDatePicker() {
        LocalDate today = LocalDate.now();
        int currentMonth = today.getMonth().getValue();
        int currentYear = today.getYear();
        int currentDay = today.getDayOfMonth();
        String date = String.format("%s/%s/%s", currentMonth, currentDay, currentYear);
        driver.findElement(datePicker).sendKeys(date);
        driver.findElement(datePicker).sendKeys(Keys.ESCAPE);
        return this;
    }

    @Step
    public WebFormPage changeScale(int times, boolean isUp) {
        WebElement slider = driver.findElement(sliderBy);
        for (int i = 0; i < times; i++) {
            if (isUp) {
                slider.sendKeys(Keys.ARROW_UP);
            } else {
                slider.sendKeys(Keys.ARROW_DOWN);
            }
        }
        return this;
    }

    public String getTextInputValue() {

        return getAttributeValueOfElement(textInput, "value");
    }

    public String getPasswordValue() {
        return "";
    }

    public String getTextAreaText() {
        return "";
    }

    public String getDropDownValue() {
        return "";
    }

    public String getDataListValue() {
        return "";
    }

    public boolean isCheckboxEnabled() {
        return false;
    }

    public boolean isRadioButtonSelected() {
        return false;
    }
}
