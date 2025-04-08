package org.example.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    private Logger logger = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    protected WebElement getWebElement(By by) {
        //     WebElement element = null;
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            //TODO replace by logger
            throw new RuntimeException("Cant found element");
        }
    }

    protected void typeTextToElement(By by, String text) {
        typeTextToElement(getWebElement(by), text);
    }

    protected void typeTextToElement(WebElement element, String text) {
        waitForElementVisible(element);
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Text " + text + " was typed to " + getElementName(element));
        } catch (Exception e) {
            logger.error(" Error: " + e.getMessage());
        }
    }

    protected void clickOnElement(By by) {
        clickOnElement(getWebElement(by));
    }

    protected void clickOnElement(WebElement element) {
        waitForElementClickable(element);
        try {
            logger.info(" Element was clicked: " + getElementName(element));
            element.click();
        } catch (Exception e) {
            logger.error(" Error: " + e.getMessage());
        }
    }


    protected void moveToElement(By by) {
        actions.moveToElement(getWebElement(by))
                .build()
                .perform();
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return getWebElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void dragAndDrop(By elementToDrag, By areaToDrop) {
        actions.dragAndDrop(getWebElement(elementToDrag), getWebElement(areaToDrop))
                .build()
                .perform();
    }

    protected String getText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            logger.error(" Error: " + e.getMessage());
            return "";
        }
    }

    protected void waitForElementClickable(By by) {
        waitForElementClickable(getWebElement(by));
    }

    protected void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementNotVisible(By by) {
        waitForElementNotVisible(getWebElement(by));
    }

    protected void waitForElementNotVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementVisible(By by) {
        waitForElementVisible(getWebElement(by));
    }

    protected void waitForElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    protected String getElementText (WebElement element){
        return element.getText();
    }

    protected String getAttributeValueOfElement (By elementBy ,String attribute){
        return getWebElement(elementBy).getDomProperty( attribute );
    }

}
